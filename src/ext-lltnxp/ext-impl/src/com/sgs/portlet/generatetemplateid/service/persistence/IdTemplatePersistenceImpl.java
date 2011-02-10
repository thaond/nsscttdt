package com.sgs.portlet.generatetemplateid.service.persistence;

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

import com.sgs.portlet.generatetemplateid.NoSuchException;
import com.sgs.portlet.generatetemplateid.model.IdTemplate;
import com.sgs.portlet.generatetemplateid.model.impl.IdTemplateImpl;
import com.sgs.portlet.generatetemplateid.model.impl.IdTemplateModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class IdTemplatePersistenceImpl extends BasePersistenceImpl
    implements IdTemplatePersistence {
    private static Log _log = LogFactory.getLog(IdTemplatePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public IdTemplate create(long templateId) {
        IdTemplate idTemplate = new IdTemplateImpl();

        idTemplate.setNew(true);
        idTemplate.setPrimaryKey(templateId);

        return idTemplate;
    }

    public IdTemplate remove(long templateId)
        throws NoSuchException, SystemException {
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

                throw new NoSuchException(
                    "No IdTemplate exists with the primary key " + templateId);
            }

            return remove(idTemplate);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public IdTemplate remove(IdTemplate idTemplate) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(idTemplate);
            }
        }

        idTemplate = removeImpl(idTemplate);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(idTemplate);
            }
        }

        return idTemplate;
    }

    protected IdTemplate removeImpl(IdTemplate idTemplate)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(idTemplate);

            session.flush();

            return idTemplate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(IdTemplate.class.getName());
        }
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

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(idTemplate);
                } else {
                    listener.onBeforeUpdate(idTemplate);
                }
            }
        }

        idTemplate = updateImpl(idTemplate, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(idTemplate);
                } else {
                    listener.onAfterUpdate(idTemplate);
                }
            }
        }

        return idTemplate;
    }

    public IdTemplate updateImpl(
        com.sgs.portlet.generatetemplateid.model.IdTemplate idTemplate,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(idTemplate);
            } else {
                if (idTemplate.isNew()) {
                    session.save(idTemplate);
                }
            }

            session.flush();

            idTemplate.setNew(false);

            return idTemplate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(IdTemplate.class.getName());
        }
    }

    public IdTemplate findByPrimaryKey(long templateId)
        throws NoSuchException, SystemException {
        IdTemplate idTemplate = fetchByPrimaryKey(templateId);

        if (idTemplate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No IdTemplate exists with the primary key " +
                    templateId);
            }

            throw new NoSuchException(
                "No IdTemplate exists with the primary key " + templateId);
        }

        return idTemplate;
    }

    public IdTemplate fetchByPrimaryKey(long templateId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (IdTemplate) session.get(IdTemplateImpl.class,
                new Long(templateId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<IdTemplate> findByAllLike(String format, String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "findByAllLike";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { format, description };

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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                List<IdTemplate> list = q.list();

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
            return (List<IdTemplate>) result;
        }
    }

    public List<IdTemplate> findByAllLike(String format, String description,
        int start, int end) throws SystemException {
        return findByAllLike(format, description, start, end, null);
    }

    public List<IdTemplate> findByAllLike(String format, String description,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "findByAllLike";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                format,
                
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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                List<IdTemplate> list = (List<IdTemplate>) QueryUtil.list(q,
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
            return (List<IdTemplate>) result;
        }
    }

    public IdTemplate findByAllLike_First(String format, String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<IdTemplate> list = findByAllLike(format, description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate findByAllLike_Last(String format, String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByAllLike(format, description);

        List<IdTemplate> list = findByAllLike(format, description, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate[] findByAllLike_PrevAndNext(long templateId,
        String format, String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        IdTemplate idTemplate = findByPrimaryKey(templateId);

        int count = countByAllLike(format, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "findByFormat";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { format };

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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                List<IdTemplate> list = q.list();

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
            return (List<IdTemplate>) result;
        }
    }

    public List<IdTemplate> findByFormat(String format, int start, int end)
        throws SystemException {
        return findByFormat(format, start, end, null);
    }

    public List<IdTemplate> findByFormat(String format, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "findByFormat";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                format,
                
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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                List<IdTemplate> list = (List<IdTemplate>) QueryUtil.list(q,
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
            return (List<IdTemplate>) result;
        }
    }

    public IdTemplate findByFormat_First(String format, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<IdTemplate> list = findByFormat(format, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate findByFormat_Last(String format, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByFormat(format);

        List<IdTemplate> list = findByFormat(format, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate[] findByFormat_PrevAndNext(long templateId,
        String format, OrderByComparator obc)
        throws NoSuchException, SystemException {
        IdTemplate idTemplate = findByPrimaryKey(templateId);

        int count = countByFormat(format);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "findByFormatLike";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { format };

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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                List<IdTemplate> list = q.list();

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
            return (List<IdTemplate>) result;
        }
    }

    public List<IdTemplate> findByFormatLike(String format, int start, int end)
        throws SystemException {
        return findByFormatLike(format, start, end, null);
    }

    public List<IdTemplate> findByFormatLike(String format, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "findByFormatLike";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                format,
                
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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                List<IdTemplate> list = (List<IdTemplate>) QueryUtil.list(q,
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
            return (List<IdTemplate>) result;
        }
    }

    public IdTemplate findByFormatLike_First(String format,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<IdTemplate> list = findByFormatLike(format, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate findByFormatLike_Last(String format, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByFormatLike(format);

        List<IdTemplate> list = findByFormatLike(format, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("format=" + format);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate[] findByFormatLike_PrevAndNext(long templateId,
        String format, OrderByComparator obc)
        throws NoSuchException, SystemException {
        IdTemplate idTemplate = findByPrimaryKey(templateId);

        int count = countByFormatLike(format);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                List<IdTemplate> list = q.list();

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
            return (List<IdTemplate>) result;
        }
    }

    public List<IdTemplate> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<IdTemplate> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

                List<IdTemplate> list = (List<IdTemplate>) QueryUtil.list(q,
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
            return (List<IdTemplate>) result;
        }
    }

    public IdTemplate findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<IdTemplate> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByDescription(description);

        List<IdTemplate> list = findByDescription(description, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdTemplate exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdTemplate[] findByDescription_PrevAndNext(long templateId,
        String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        IdTemplate idTemplate = findByPrimaryKey(templateId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<IdTemplate> list = (List<IdTemplate>) QueryUtil.list(q,
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
            return (List<IdTemplate>) result;
        }
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
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "countByAllLike";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { format, description };

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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

    public int countByFormat(String format) throws SystemException {
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "countByFormat";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { format };

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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

    public int countByFormatLike(String format) throws SystemException {
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
        String finderMethodName = "countByFormatLike";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { format };

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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
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
                    "FROM com.sgs.portlet.generatetemplateid.model.IdTemplate WHERE ");

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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = IdTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = IdTemplate.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.generatetemplateid.model.IdTemplate");

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
                        "value.object.listener.com.sgs.portlet.generatetemplateid.model.IdTemplate")));

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
