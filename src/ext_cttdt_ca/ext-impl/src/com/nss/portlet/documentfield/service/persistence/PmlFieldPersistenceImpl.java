package com.nss.portlet.documentfield.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.documentfield.NoSuchPmlFieldException;
import com.nss.portlet.documentfield.model.PmlField;
import com.nss.portlet.documentfield.model.impl.PmlFieldImpl;
import com.nss.portlet.documentfield.model.impl.PmlFieldModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlFieldPersistenceImpl extends BasePersistenceImpl
    implements PmlFieldPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFieldImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FIELDCODE = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFieldCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FIELDCODE = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFieldCode",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FIELDCODE = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFieldCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FIELDNAME = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFieldName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FIELDNAME = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFieldName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FIELDNAME = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFieldName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSID = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSID = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDepartmentsId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FIELDCODE_FIELDNAME = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFieldCode_FieldName",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FIELDCODE_FIELDNAME = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFieldCode_FieldName",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FIELDCODE_FIELDNAME = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFieldCode_FieldName",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFieldPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.documentfield.service.persistence.PmlFieldPersistence.impl")
    protected com.nss.portlet.documentfield.service.persistence.PmlFieldPersistence pmlFieldPersistence;

    public void cacheResult(PmlField pmlField) {
        EntityCacheUtil.putResult(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldImpl.class, pmlField.getPrimaryKey(), pmlField);
    }

    public void cacheResult(List<PmlField> pmlFields) {
        for (PmlField pmlField : pmlFields) {
            if (EntityCacheUtil.getResult(
                        PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFieldImpl.class, pmlField.getPrimaryKey(), this) == null) {
                cacheResult(pmlField);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFieldImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFieldImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<PmlField> listener : listeners) {
            listener.onBeforeRemove(pmlField);
        }

        pmlField = removeImpl(pmlField);

        for (ModelListener<PmlField> listener : listeners) {
            listener.onAfterRemove(pmlField);
        }

        return pmlField;
    }

    protected PmlField removeImpl(PmlField pmlField) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlField.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFieldImpl.class,
                        pmlField.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlField);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldImpl.class, pmlField.getPrimaryKey());

        return pmlField;
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

        for (ModelListener<PmlField> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlField);
            } else {
                listener.onBeforeUpdate(pmlField);
            }
        }

        pmlField = updateImpl(pmlField, merge);

        for (ModelListener<PmlField> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlField);
            } else {
                listener.onAfterUpdate(pmlField);
            }
        }

        return pmlField;
    }

    public PmlField updateImpl(
        com.nss.portlet.documentfield.model.PmlField pmlField, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlField, merge);

            pmlField.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
            PmlFieldImpl.class, pmlField.getPrimaryKey(), pmlField);

        return pmlField;
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
        PmlField pmlField = (PmlField) EntityCacheUtil.getResult(PmlFieldModelImpl.ENTITY_CACHE_ENABLED,
                PmlFieldImpl.class, fieldId, this);

        if (pmlField == null) {
            Session session = null;

            try {
                session = openSession();

                pmlField = (PmlField) session.get(PmlFieldImpl.class, fieldId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlField != null) {
                    cacheResult(pmlField);
                }

                closeSession(session);
            }
        }

        return pmlField;
    }

    public List<PmlField> findByFieldCode(String fieldCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { fieldCode };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FIELDCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FIELDCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlField> findByFieldCode(String fieldCode, int start, int end)
        throws SystemException {
        return findByFieldCode(fieldCode, start, end, null);
    }

    public List<PmlField> findByFieldCode(String fieldCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fieldCode,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FIELDCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = (List<PmlField>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FIELDCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlField findByFieldCode_First(String fieldCode,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByFieldCode(fieldCode, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append(
                "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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
        Object[] finderArgs = new Object[] { fieldName };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FIELDNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FIELDNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlField> findByFieldName(String fieldName, int start, int end)
        throws SystemException {
        return findByFieldName(fieldName, start, end, null);
    }

    public List<PmlField> findByFieldName(String fieldName, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fieldName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FIELDNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = (List<PmlField>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FIELDNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlField findByFieldName_First(String fieldName,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByFieldName(fieldName, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append(
                "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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
        Object[] finderArgs = new Object[] { description };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlField> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlField> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = (List<PmlField>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlField findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append(
                "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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
        Object[] finderArgs = new Object[] { departmentsId };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlField> findByDepartmentsId(String departmentsId, int start,
        int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlField> findByDepartmentsId(String departmentsId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = (List<PmlField>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlField findByDepartmentsId_First(String departmentsId,
        OrderByComparator obc) throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByDepartmentsId(departmentsId, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append(
                "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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
        Object[] finderArgs = new Object[] { fieldCode, fieldName };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FIELDCODE_FIELDNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FIELDCODE_FIELDNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlField> findByFieldCode_FieldName(String fieldCode,
        String fieldName, int start, int end) throws SystemException {
        return findByFieldCode_FieldName(fieldCode, fieldName, start, end, null);
    }

    public List<PmlField> findByFieldCode_FieldName(String fieldCode,
        String fieldName, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                fieldCode,
                
                fieldName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FIELDCODE_FIELDNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                list = (List<PmlField>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FIELDCODE_FIELDNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlField findByFieldCode_FieldName_First(String fieldCode,
        String fieldName, OrderByComparator obc)
        throws NoSuchPmlFieldException, SystemException {
        List<PmlField> list = findByFieldCode_FieldName(fieldCode, fieldName,
                0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append(
                "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlField> list = (List<PmlField>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fieldName ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlField>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlField>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlField>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { fieldCode };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FIELDCODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDCODE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFieldName(String fieldName) throws SystemException {
        Object[] finderArgs = new Object[] { fieldName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FIELDNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDescription(String description) throws SystemException {
        Object[] finderArgs = new Object[] { description };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDepartmentsId(String departmentsId)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFieldCode_FieldName(String fieldCode, String fieldName)
        throws SystemException {
        Object[] finderArgs = new Object[] { fieldCode, fieldName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FIELDCODE_FIELDNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.documentfield.model.PmlField WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDCODE_FIELDNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.nss.portlet.documentfield.model.PmlField");

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.portal.util.PropsUtil.get(
                        "value.object.listener.com.nss.portlet.documentfield.model.PmlField")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlField>> listenersList = new ArrayList<ModelListener<PmlField>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlField>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
