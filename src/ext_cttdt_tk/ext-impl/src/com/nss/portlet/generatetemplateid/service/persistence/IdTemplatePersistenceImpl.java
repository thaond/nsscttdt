package com.nss.portlet.generatetemplateid.service.persistence;

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

import com.nss.portlet.generatetemplateid.NoSuchIdTemplateException;
import com.nss.portlet.generatetemplateid.model.IdTemplate;
import com.nss.portlet.generatetemplateid.model.impl.IdTemplateImpl;
import com.nss.portlet.generatetemplateid.model.impl.IdTemplateModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class IdTemplatePersistenceImpl extends BasePersistenceImpl
    implements IdTemplatePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = IdTemplateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ALLLIKE = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAllLike",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ALLLIKE = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAllLike",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ALLLIKE = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAllLike",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FORMAT = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFormat", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FORMAT = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFormat",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FORMAT = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFormat", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FORMATLIKE = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFormatLike", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FORMATLIKE = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFormatLike",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FORMATLIKE = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFormatLike", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(IdTemplatePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.persistence.IdTemplatePersistence.impl")
    protected com.nss.portlet.generatetemplateid.service.persistence.IdTemplatePersistence idTemplatePersistence;
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence.impl")
    protected com.nss.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence idGeneratedPersistence;

    public void cacheResult(IdTemplate idTemplate) {
        EntityCacheUtil.putResult(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateImpl.class, idTemplate.getPrimaryKey(), idTemplate);
    }

    public void cacheResult(List<IdTemplate> idTemplates) {
        for (IdTemplate idTemplate : idTemplates) {
            if (EntityCacheUtil.getResult(
                        IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
                        IdTemplateImpl.class, idTemplate.getPrimaryKey(), this) == null) {
                cacheResult(idTemplate);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(IdTemplateImpl.class.getName());
        EntityCacheUtil.clearCache(IdTemplateImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public IdTemplate create(long templateId) {
        IdTemplate idTemplate = new IdTemplateImpl();

        idTemplate.setNew(true);
        idTemplate.setPrimaryKey(templateId);

        return idTemplate;
    }

    public IdTemplate remove(long templateId)
        throws NoSuchIdTemplateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            IdTemplate idTemplate = (IdTemplate) session.get(IdTemplateImpl.class,
                    new Long(templateId));

            if (idTemplate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No IdTemplate exists with the primary key " +
                        templateId);
                }

                throw new NoSuchIdTemplateException(
                    "No IdTemplate exists with the primary key " + templateId);
            }

            return remove(idTemplate);
        } catch (NoSuchIdTemplateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public IdTemplate remove(IdTemplate idTemplate) throws SystemException {
        for (ModelListener<IdTemplate> listener : listeners) {
            listener.onBeforeRemove(idTemplate);
        }

        idTemplate = removeImpl(idTemplate);

        for (ModelListener<IdTemplate> listener : listeners) {
            listener.onAfterRemove(idTemplate);
        }

        return idTemplate;
    }

    protected IdTemplate removeImpl(IdTemplate idTemplate)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (idTemplate.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(IdTemplateImpl.class,
                        idTemplate.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(idTemplate);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateImpl.class, idTemplate.getPrimaryKey());

        return idTemplate;
    }

    /**
     * @deprecated Use <code>update(IdTemplate idTemplate, boolean merge)</code>.
     */
    public IdTemplate update(IdTemplate idTemplate) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(IdTemplate idTemplate) method. Use update(IdTemplate idTemplate, boolean merge) instead.");
        }

        return update(idTemplate, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                idTemplate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when idTemplate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public IdTemplate update(IdTemplate idTemplate, boolean merge)
        throws SystemException {
        boolean isNew = idTemplate.isNew();

        for (ModelListener<IdTemplate> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(idTemplate);
            } else {
                listener.onBeforeUpdate(idTemplate);
            }
        }

        idTemplate = updateImpl(idTemplate, merge);

        for (ModelListener<IdTemplate> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(idTemplate);
            } else {
                listener.onAfterUpdate(idTemplate);
            }
        }

        return idTemplate;
    }

    public IdTemplate updateImpl(
        com.nss.portlet.generatetemplateid.model.IdTemplate idTemplate,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, idTemplate, merge);

            idTemplate.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
            IdTemplateImpl.class, idTemplate.getPrimaryKey(), idTemplate);

        return idTemplate;
    }

    public IdTemplate findByPrimaryKey(long templateId)
        throws NoSuchIdTemplateException, SystemException {
        IdTemplate idTemplate = fetchByPrimaryKey(templateId);

        if (idTemplate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No IdTemplate exists with the primary key " +
                    templateId);
            }

            throw new NoSuchIdTemplateException(
                "No IdTemplate exists with the primary key " + templateId);
        }

        return idTemplate;
    }

    public IdTemplate fetchByPrimaryKey(long templateId)
        throws SystemException {
        IdTemplate idTemplate = (IdTemplate) EntityCacheUtil.getResult(IdTemplateModelImpl.ENTITY_CACHE_ENABLED,
                IdTemplateImpl.class, templateId, this);

        if (idTemplate == null) {
            Session session = null;

            try {
                session = openSession();

                idTemplate = (IdTemplate) session.get(IdTemplateImpl.class,
                        new Long(templateId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (idTemplate != null) {
                    cacheResult(idTemplate);
                }

                closeSession(session);
            }
        }

        return idTemplate;
    }

    public List<IdTemplate> findByAllLike(String format, String description)
        throws SystemException {
        Object[] finderArgs = new Object[] { format, description };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ALLLIKE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
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

                if (format != null) {
                    qPos.add(format);
                }

                if (description != null) {
                    qPos.add(description);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ALLLIKE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<IdTemplate> findByAllLike(String format, String description,
        int start, int end) throws SystemException {
        return findByAllLike(format, description, start, end, null);
    }

    public List<IdTemplate> findByAllLike(String format, String description,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                format,
                
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ALLLIKE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (format != null) {
                    qPos.add(format);
                }

                if (description != null) {
                    qPos.add(description);
                }

                list = (List<IdTemplate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ALLLIKE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public IdTemplate findByAllLike_First(String format, String description,
        OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        List<IdTemplate> list = findByAllLike(format, description, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate findByAllLike_Last(String format, String description,
        OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        int count = countByAllLike(format, description);

        List<IdTemplate> list = findByAllLike(format, description, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate[] findByAllLike_PrevAndNext(long templateId,
        String format, String description, OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        IdTemplate idTemplate = findByPrimaryKey(templateId);

        int count = countByAllLike(format, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

            if (format == null) {
                query.append("format LIKE null");
            } else {
                query.append("format LIKE ?");
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

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (format != null) {
                qPos.add(format);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    idTemplate);

            IdTemplate[] array = new IdTemplateImpl[3];

            array[0] = (IdTemplate) objArray[0];
            array[1] = (IdTemplate) objArray[1];
            array[2] = (IdTemplate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<IdTemplate> findByFormat(String format)
        throws SystemException {
        Object[] finderArgs = new Object[] { format };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FORMAT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (format != null) {
                    qPos.add(format);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FORMAT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<IdTemplate> findByFormat(String format, int start, int end)
        throws SystemException {
        return findByFormat(format, start, end, null);
    }

    public List<IdTemplate> findByFormat(String format, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                format,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FORMAT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (format != null) {
                    qPos.add(format);
                }

                list = (List<IdTemplate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FORMAT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public IdTemplate findByFormat_First(String format, OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        List<IdTemplate> list = findByFormat(format, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate findByFormat_Last(String format, OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        int count = countByFormat(format);

        List<IdTemplate> list = findByFormat(format, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate[] findByFormat_PrevAndNext(long templateId,
        String format, OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        IdTemplate idTemplate = findByPrimaryKey(templateId);

        int count = countByFormat(format);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

            if (format == null) {
                query.append("format LIKE null");
            } else {
                query.append("format LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (format != null) {
                qPos.add(format);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    idTemplate);

            IdTemplate[] array = new IdTemplateImpl[3];

            array[0] = (IdTemplate) objArray[0];
            array[1] = (IdTemplate) objArray[1];
            array[2] = (IdTemplate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<IdTemplate> findByFormatLike(String format)
        throws SystemException {
        Object[] finderArgs = new Object[] { format };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FORMATLIKE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (format != null) {
                    qPos.add(format);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FORMATLIKE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<IdTemplate> findByFormatLike(String format, int start, int end)
        throws SystemException {
        return findByFormatLike(format, start, end, null);
    }

    public List<IdTemplate> findByFormatLike(String format, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                format,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FORMATLIKE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (format != null) {
                    qPos.add(format);
                }

                list = (List<IdTemplate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FORMATLIKE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public IdTemplate findByFormatLike_First(String format,
        OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        List<IdTemplate> list = findByFormatLike(format, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate findByFormatLike_Last(String format, OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        int count = countByFormatLike(format);

        List<IdTemplate> list = findByFormatLike(format, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate[] findByFormatLike_PrevAndNext(long templateId,
        String format, OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        IdTemplate idTemplate = findByPrimaryKey(templateId);

        int count = countByFormatLike(format);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

            if (format == null) {
                query.append("format LIKE null");
            } else {
                query.append("format LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (format != null) {
                qPos.add(format);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    idTemplate);

            IdTemplate[] array = new IdTemplateImpl[3];

            array[0] = (IdTemplate) objArray[0];
            array[1] = (IdTemplate) objArray[1];
            array[2] = (IdTemplate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<IdTemplate> findByDescription(String description)
        throws SystemException {
        Object[] finderArgs = new Object[] { description };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<IdTemplate> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<IdTemplate> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                list = (List<IdTemplate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public IdTemplate findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        List<IdTemplate> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        int count = countByDescription(description);

        List<IdTemplate> list = findByDescription(description, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate[] findByDescription_PrevAndNext(long templateId,
        String description, OrderByComparator obc)
        throws NoSuchIdTemplateException, SystemException {
        IdTemplate idTemplate = findByPrimaryKey(templateId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    idTemplate);

            IdTemplate[] array = new IdTemplateImpl[3];

            array[0] = (IdTemplate) objArray[0];
            array[1] = (IdTemplate) objArray[1];
            array[2] = (IdTemplate) objArray[2];

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

    public List<IdTemplate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<IdTemplate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<IdTemplate> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdTemplate> list = (List<IdTemplate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<IdTemplate>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<IdTemplate>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdTemplate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByAllLike(String format, String description)
        throws SystemException {
        for (IdTemplate idTemplate : findByAllLike(format, description)) {
            remove(idTemplate);
        }
    }

    public void removeByFormat(String format) throws SystemException {
        for (IdTemplate idTemplate : findByFormat(format)) {
            remove(idTemplate);
        }
    }

    public void removeByFormatLike(String format) throws SystemException {
        for (IdTemplate idTemplate : findByFormatLike(format)) {
            remove(idTemplate);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (IdTemplate idTemplate : findByDescription(description)) {
            remove(idTemplate);
        }
    }

    public void removeAll() throws SystemException {
        for (IdTemplate idTemplate : findAll()) {
            remove(idTemplate);
        }
    }

    public int countByAllLike(String format, String description)
        throws SystemException {
        Object[] finderArgs = new Object[] { format, description };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALLLIKE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
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

                if (format != null) {
                    qPos.add(format);
                }

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALLLIKE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFormat(String format) throws SystemException {
        Object[] finderArgs = new Object[] { format };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FORMAT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (format != null) {
                    qPos.add(format);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FORMAT,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFormatLike(String format) throws SystemException {
        Object[] finderArgs = new Object[] { format };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FORMATLIKE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

                if (format == null) {
                    query.append("format LIKE null");
                } else {
                    query.append("format LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (format != null) {
                    qPos.add(format);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FORMATLIKE,
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
                    "FROM com.nss.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.nss.portlet.generatetemplateid.model.IdTemplate");

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
                        "value.object.listener.com.nss.portlet.generatetemplateid.model.IdTemplate")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<IdTemplate>> listenersList = new ArrayList<ModelListener<IdTemplate>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<IdTemplate>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
