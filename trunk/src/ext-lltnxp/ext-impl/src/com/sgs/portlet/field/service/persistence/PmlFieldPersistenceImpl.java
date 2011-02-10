package com.sgs.portlet.field.service.persistence;

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

import com.sgs.portlet.field.NoSuchPmlFieldException;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.model.impl.PmlFieldImpl;
import com.sgs.portlet.field.model.impl.PmlFieldModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlFieldPersistenceImpl extends BasePersistenceImpl
    implements PmlFieldPersistence {
    private static Log _log = LogFactory.getLog(PmlFieldPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlField create(String fieldId) {
        PmlField pmlField = new PmlFieldImpl();

        pmlField.setNew(true);
        pmlField.setPrimaryKey(fieldId);

        return pmlField;
    }

    public PmlField remove(String fieldId)
        throws NoSuchPmlFieldException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlField pmlField = (PmlField) session.get(PmlFieldImpl.class,
                    fieldId);

            if (pmlField == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlField exists with the primary key " +
                        fieldId);
                }

                throw new NoSuchPmlFieldException(
                    "No PmlField exists with the primary key " + fieldId);
            }

            return remove(pmlField);
        } catch (NoSuchPmlFieldException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlField remove(PmlField pmlField) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlField);
            }
        }

        pmlField = removeImpl(pmlField);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlField);
            }
        }

        return pmlField;
    }

    protected PmlField removeImpl(PmlField pmlField) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlField);

            session.flush();

            return pmlField;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlField.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlField pmlField, boolean merge)</code>.
     */
    public PmlField update(PmlField pmlField) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlField pmlField) method. Use update(PmlField pmlField, boolean merge) instead.");
        }

        return update(pmlField, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlField the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlField is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlField update(PmlField pmlField, boolean merge)
        throws SystemException {
        boolean isNew = pmlField.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlField);
                } else {
                    listener.onBeforeUpdate(pmlField);
                }
            }
        }

        pmlField = updateImpl(pmlField, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlField);
                } else {
                    listener.onAfterUpdate(pmlField);
                }
            }
        }

        return pmlField;
    }

    public PmlField updateImpl(com.sgs.portlet.field.model.PmlField pmlField,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlField);
            } else {
                if (pmlField.isNew()) {
                    session.save(pmlField);
                }
            }

            session.flush();

            pmlField.setNew(false);

            return pmlField;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlField.class.getName());
        }
    }

    public PmlField findByPrimaryKey(String fieldId)
        throws NoSuchPmlFieldException, SystemException {
        PmlField pmlField = fetchByPrimaryKey(fieldId);

        if (pmlField == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlField exists with the primary key " + fieldId);
            }

            throw new NoSuchPmlFieldException(
                "No PmlField exists with the primary key " + fieldId);
        }

        return pmlField;
    }

    public PmlField fetchByPrimaryKey(String fieldId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlField) session.get(PmlFieldImpl.class, fieldId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlField> findByFieldCode(String fieldCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "findByFieldCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fieldCode };

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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldCode == null) {
                    query.append("fieldCode LIKE null");
                } else {
                    query.append("lower(fieldCode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fieldName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldCode != null) {
                    qPos.add(fieldCode);
                }

                List<PmlField> list = q.list();

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
            return (List<PmlField>) result;
        }
    }

    public List<PmlField> findByFieldCode(String fieldCode, int start, int end)
        throws SystemException {
        return findByFieldCode(fieldCode, start, end, null);
    }

    public List<PmlField> findByFieldCode(String fieldCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "findByFieldCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fieldCode,
                
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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldCode == null) {
                    query.append("fieldCode LIKE null");
                } else {
                    query.append("lower(fieldCode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fieldName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldCode != null) {
                    qPos.add(fieldCode);
                }

                List<PmlField> list = (List<PmlField>) QueryUtil.list(q,
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
            return (List<PmlField>) result;
        }
    }

    public PmlField findByFieldCode_First(String fieldCode,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByFieldCode(fieldCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("fieldCode=" + fieldCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField findByFieldCode_Last(String fieldCode, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        int count = countByFieldCode(fieldCode);

        List<PmlField> list = findByFieldCode(fieldCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("fieldCode=" + fieldCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField[] findByFieldCode_PrevAndNext(String fieldId,
        String fieldCode, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        PmlField pmlField = findByPrimaryKey(fieldId);

        int count = countByFieldCode(fieldCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

            if (fieldCode == null) {
                query.append("fieldCode LIKE null");
            } else {
                query.append("lower(fieldCode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fieldName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fieldCode != null) {
                qPos.add(fieldCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlField);

            PmlField[] array = new PmlFieldImpl[3];

            array[0] = (PmlField) objArray[0];
            array[1] = (PmlField) objArray[1];
            array[2] = (PmlField) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlField> findByFieldName(String fieldName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "findByFieldName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fieldName };

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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldName == null) {
                    query.append("fieldName LIKE null");
                } else {
                    query.append("fieldName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fieldName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldName != null) {
                    qPos.add(fieldName);
                }

                List<PmlField> list = q.list();

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
            return (List<PmlField>) result;
        }
    }

    public List<PmlField> findByFieldName(String fieldName, int start, int end)
        throws SystemException {
        return findByFieldName(fieldName, start, end, null);
    }

    public List<PmlField> findByFieldName(String fieldName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "findByFieldName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fieldName,
                
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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldName == null) {
                    query.append("fieldName LIKE null");
                } else {
                    query.append("fieldName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fieldName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldName != null) {
                    qPos.add(fieldName);
                }

                List<PmlField> list = (List<PmlField>) QueryUtil.list(q,
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
            return (List<PmlField>) result;
        }
    }

    public PmlField findByFieldName_First(String fieldName,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByFieldName(fieldName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("fieldName=" + fieldName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField findByFieldName_Last(String fieldName, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        int count = countByFieldName(fieldName);

        List<PmlField> list = findByFieldName(fieldName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("fieldName=" + fieldName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField[] findByFieldName_PrevAndNext(String fieldId,
        String fieldName, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        PmlField pmlField = findByPrimaryKey(fieldId);

        int count = countByFieldName(fieldName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

            if (fieldName == null) {
                query.append("fieldName LIKE null");
            } else {
                query.append("fieldName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fieldName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fieldName != null) {
                qPos.add(fieldName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlField);

            PmlField[] array = new PmlFieldImpl[3];

            array[0] = (PmlField) objArray[0];
            array[1] = (PmlField) objArray[1];
            array[2] = (PmlField) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlField> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fieldName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlField> list = q.list();

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
            return (List<PmlField>) result;
        }
    }

    public List<PmlField> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlField> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

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

                    query.append("fieldName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlField> list = (List<PmlField>) QueryUtil.list(q,
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
            return (List<PmlField>) result;
        }
    }

    public PmlField findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        int count = countByDescription(description);

        List<PmlField> list = findByDescription(description, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField[] findByDescription_PrevAndNext(String fieldId,
        String description, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        PmlField pmlField = findByPrimaryKey(fieldId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

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

                query.append("fieldName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlField);

            PmlField[] array = new PmlFieldImpl[3];

            array[0] = (PmlField) objArray[0];
            array[1] = (PmlField) objArray[1];
            array[2] = (PmlField) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlField> findByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "findByDepartmentsId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsId };

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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fieldName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlField> list = q.list();

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
            return (List<PmlField>) result;
        }
    }

    public List<PmlField> findByDepartmentsId(String departmentsId, int start,
        int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlField> findByDepartmentsId(String departmentsId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "findByDepartmentsId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsId,
                
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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fieldName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlField> list = (List<PmlField>) QueryUtil.list(q,
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
            return (List<PmlField>) result;
        }
    }

    public PmlField findByDepartmentsId_First(String departmentsId,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByDepartmentsId(departmentsId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField findByDepartmentsId_Last(String departmentsId,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlField> list = findByDepartmentsId(departmentsId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField[] findByDepartmentsId_PrevAndNext(String fieldId,
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        PmlField pmlField = findByPrimaryKey(fieldId);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId LIKE null");
            } else {
                query.append("departmentsId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fieldName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlField);

            PmlField[] array = new PmlFieldImpl[3];

            array[0] = (PmlField) objArray[0];
            array[1] = (PmlField) objArray[1];
            array[2] = (PmlField) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlField> findByFieldCode_FieldName(String fieldCode,
        String fieldName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "findByFieldCode_FieldName";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fieldCode, fieldName };

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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldCode == null) {
                    query.append("fieldCode LIKE null");
                } else {
                    query.append("fieldCode LIKE ?");
                }

                query.append(" AND ");

                if (fieldName == null) {
                    query.append("fieldName LIKE null");
                } else {
                    query.append("fieldName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fieldName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldCode != null) {
                    qPos.add(fieldCode);
                }

                if (fieldName != null) {
                    qPos.add(fieldName);
                }

                List<PmlField> list = q.list();

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
            return (List<PmlField>) result;
        }
    }

    public List<PmlField> findByFieldCode_FieldName(String fieldCode,
        String fieldName, int start, int end) throws SystemException {
        return findByFieldCode_FieldName(fieldCode, fieldName, start, end, null);
    }

    public List<PmlField> findByFieldCode_FieldName(String fieldCode,
        String fieldName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "findByFieldCode_FieldName";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fieldCode,
                
                fieldName,
                
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

                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldCode == null) {
                    query.append("fieldCode LIKE null");
                } else {
                    query.append("fieldCode LIKE ?");
                }

                query.append(" AND ");

                if (fieldName == null) {
                    query.append("fieldName LIKE null");
                } else {
                    query.append("fieldName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fieldName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldCode != null) {
                    qPos.add(fieldCode);
                }

                if (fieldName != null) {
                    qPos.add(fieldName);
                }

                List<PmlField> list = (List<PmlField>) QueryUtil.list(q,
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
            return (List<PmlField>) result;
        }
    }

    public PmlField findByFieldCode_FieldName_First(String fieldCode,
        String fieldName, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByFieldCode_FieldName(fieldCode, fieldName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("fieldCode=" + fieldCode);

            msg.append(", ");
            msg.append("fieldName=" + fieldName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField findByFieldCode_FieldName_Last(String fieldCode,
        String fieldName, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        int count = countByFieldCode_FieldName(fieldCode, fieldName);

        List<PmlField> list = findByFieldCode_FieldName(fieldCode, fieldName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlField exists with the key {");

            msg.append("fieldCode=" + fieldCode);

            msg.append(", ");
            msg.append("fieldName=" + fieldName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFieldException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlField[] findByFieldCode_FieldName_PrevAndNext(String fieldId,
        String fieldCode, String fieldName, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        PmlField pmlField = findByPrimaryKey(fieldId);

        int count = countByFieldCode_FieldName(fieldCode, fieldName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

            if (fieldCode == null) {
                query.append("fieldCode LIKE null");
            } else {
                query.append("fieldCode LIKE ?");
            }

            query.append(" AND ");

            if (fieldName == null) {
                query.append("fieldName LIKE null");
            } else {
                query.append("fieldName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fieldName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fieldCode != null) {
                qPos.add(fieldCode);
            }

            if (fieldName != null) {
                qPos.add(fieldName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlField);

            PmlField[] array = new PmlFieldImpl[3];

            array[0] = (PmlField) objArray[0];
            array[1] = (PmlField) objArray[1];
            array[2] = (PmlField) objArray[2];

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

    public List<PmlField> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlField> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlField> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
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

                query.append("FROM com.sgs.portlet.field.model.PmlField ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fieldName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlField> list = (List<PmlField>) QueryUtil.list(q,
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
            return (List<PmlField>) result;
        }
    }

    public void removeByFieldCode(String fieldCode) throws SystemException {
        for (PmlField pmlField : findByFieldCode(fieldCode)) {
            remove(pmlField);
        }
    }

    public void removeByFieldName(String fieldName) throws SystemException {
        for (PmlField pmlField : findByFieldName(fieldName)) {
            remove(pmlField);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (PmlField pmlField : findByDescription(description)) {
            remove(pmlField);
        }
    }

    public void removeByDepartmentsId(String departmentsId)
        throws SystemException {
        for (PmlField pmlField : findByDepartmentsId(departmentsId)) {
            remove(pmlField);
        }
    }

    public void removeByFieldCode_FieldName(String fieldCode, String fieldName)
        throws SystemException {
        for (PmlField pmlField : findByFieldCode_FieldName(fieldCode, fieldName)) {
            remove(pmlField);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlField pmlField : findAll()) {
            remove(pmlField);
        }
    }

    public int countByFieldCode(String fieldCode) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "countByFieldCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fieldCode };

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
                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldCode == null) {
                    query.append("fieldCode LIKE null");
                } else {
                    query.append("lower(fieldCode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldCode != null) {
                    qPos.add(fieldCode);
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

    public int countByFieldName(String fieldName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "countByFieldName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fieldName };

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
                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldName == null) {
                    query.append("fieldName LIKE null");
                } else {
                    query.append("fieldName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldName != null) {
                    qPos.add(fieldName);
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
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
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
                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
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

    public int countByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "countByDepartmentsId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsId };

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
                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
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

    public int countByFieldCode_FieldName(String fieldCode, String fieldName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
        String finderMethodName = "countByFieldCode_FieldName";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fieldCode, fieldName };

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
                query.append("FROM com.sgs.portlet.field.model.PmlField WHERE ");

                if (fieldCode == null) {
                    query.append("fieldCode LIKE null");
                } else {
                    query.append("fieldCode LIKE ?");
                }

                query.append(" AND ");

                if (fieldName == null) {
                    query.append("fieldName LIKE null");
                } else {
                    query.append("fieldName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldCode != null) {
                    qPos.add(fieldCode);
                }

                if (fieldName != null) {
                    qPos.add(fieldName);
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
        boolean finderClassNameCacheEnabled = PmlFieldModelImpl.CACHE_ENABLED;
        String finderClassName = PmlField.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.field.model.PmlField");

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
                        "value.object.listener.com.sgs.portlet.field.model.PmlField")));

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
