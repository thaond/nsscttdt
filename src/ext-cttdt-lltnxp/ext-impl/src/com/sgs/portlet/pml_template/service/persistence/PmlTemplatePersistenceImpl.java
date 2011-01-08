package com.sgs.portlet.pml_template.service.persistence;

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

import com.sgs.portlet.pml_template.NoSuchException;
import com.sgs.portlet.pml_template.model.PmlTemplate;
import com.sgs.portlet.pml_template.model.impl.PmlTemplateImpl;
import com.sgs.portlet.pml_template.model.impl.PmlTemplateModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlTemplatePersistenceImpl extends BasePersistenceImpl
    implements PmlTemplatePersistence {
    private static Log _log = LogFactory.getLog(PmlTemplatePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlTemplate create(long templateId) {
        PmlTemplate pmlTemplate = new PmlTemplateImpl();

        pmlTemplate.setNew(true);
        pmlTemplate.setPrimaryKey(templateId);

        return pmlTemplate;
    }

    public PmlTemplate remove(long templateId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlTemplate pmlTemplate = (PmlTemplate) session.get(PmlTemplateImpl.class,
                    new Long(templateId));

            if (pmlTemplate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlTemplate exists with the primary key " +
                        templateId);
                }

                throw new NoSuchException(
                    "No PmlTemplate exists with the primary key " + templateId);
            }

            return remove(pmlTemplate);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlTemplate remove(PmlTemplate pmlTemplate)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlTemplate);
            }
        }

        pmlTemplate = removeImpl(pmlTemplate);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlTemplate);
            }
        }

        return pmlTemplate;
    }

    protected PmlTemplate removeImpl(PmlTemplate pmlTemplate)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlTemplate);

            session.flush();

            return pmlTemplate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTemplate.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlTemplate pmlTemplate, boolean merge)</code>.
     */
    public PmlTemplate update(PmlTemplate pmlTemplate)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlTemplate pmlTemplate) method. Use update(PmlTemplate pmlTemplate, boolean merge) instead.");
        }

        return update(pmlTemplate, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTemplate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTemplate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlTemplate update(PmlTemplate pmlTemplate, boolean merge)
        throws SystemException {
        boolean isNew = pmlTemplate.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlTemplate);
                } else {
                    listener.onBeforeUpdate(pmlTemplate);
                }
            }
        }

        pmlTemplate = updateImpl(pmlTemplate, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlTemplate);
                } else {
                    listener.onAfterUpdate(pmlTemplate);
                }
            }
        }

        return pmlTemplate;
    }

    public PmlTemplate updateImpl(
        com.sgs.portlet.pml_template.model.PmlTemplate pmlTemplate,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlTemplate);
            } else {
                if (pmlTemplate.isNew()) {
                    session.save(pmlTemplate);
                }
            }

            session.flush();

            pmlTemplate.setNew(false);

            return pmlTemplate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTemplate.class.getName());
        }
    }

    public PmlTemplate findByPrimaryKey(long templateId)
        throws NoSuchException, SystemException {
        PmlTemplate pmlTemplate = fetchByPrimaryKey(templateId);

        if (pmlTemplate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlTemplate exists with the primary key " +
                    templateId);
            }

            throw new NoSuchException(
                "No PmlTemplate exists with the primary key " + templateId);
        }

        return pmlTemplate;
    }

    public PmlTemplate fetchByPrimaryKey(long templateId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlTemplate) session.get(PmlTemplateImpl.class,
                new Long(templateId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTemplate> findByDepartmentId(String departmentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTemplate.class.getName();
        String finderMethodName = "findByDepartmentId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentId };

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
                    "FROM com.sgs.portlet.pml_template.model.PmlTemplate WHERE ");

                if (departmentId == null) {
                    query.append("departmentId IS NULL");
                } else {
                    query.append("departmentId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                List<PmlTemplate> list = q.list();

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
            return (List<PmlTemplate>) result;
        }
    }

    public List<PmlTemplate> findByDepartmentId(String departmentId, int start,
        int end) throws SystemException {
        return findByDepartmentId(departmentId, start, end, null);
    }

    public List<PmlTemplate> findByDepartmentId(String departmentId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTemplate.class.getName();
        String finderMethodName = "findByDepartmentId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentId,
                
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
                    "FROM com.sgs.portlet.pml_template.model.PmlTemplate WHERE ");

                if (departmentId == null) {
                    query.append("departmentId IS NULL");
                } else {
                    query.append("departmentId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                List<PmlTemplate> list = (List<PmlTemplate>) QueryUtil.list(q,
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
            return (List<PmlTemplate>) result;
        }
    }

    public PmlTemplate findByDepartmentId_First(String departmentId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlTemplate> list = findByDepartmentId(departmentId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTemplate exists with the key {");

            msg.append("departmentId=" + departmentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTemplate findByDepartmentId_Last(String departmentId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByDepartmentId(departmentId);

        List<PmlTemplate> list = findByDepartmentId(departmentId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTemplate exists with the key {");

            msg.append("departmentId=" + departmentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTemplate[] findByDepartmentId_PrevAndNext(long templateId,
        String departmentId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlTemplate pmlTemplate = findByPrimaryKey(templateId);

        int count = countByDepartmentId(departmentId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_template.model.PmlTemplate WHERE ");

            if (departmentId == null) {
                query.append("departmentId IS NULL");
            } else {
                query.append("departmentId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentId != null) {
                qPos.add(departmentId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTemplate);

            PmlTemplate[] array = new PmlTemplateImpl[3];

            array[0] = (PmlTemplate) objArray[0];
            array[1] = (PmlTemplate) objArray[1];
            array[2] = (PmlTemplate) objArray[2];

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

    public List<PmlTemplate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlTemplate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlTemplate> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTemplate.class.getName();
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
                    "FROM com.sgs.portlet.pml_template.model.PmlTemplate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlTemplate> list = (List<PmlTemplate>) QueryUtil.list(q,
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
            return (List<PmlTemplate>) result;
        }
    }

    public void removeByDepartmentId(String departmentId)
        throws SystemException {
        for (PmlTemplate pmlTemplate : findByDepartmentId(departmentId)) {
            remove(pmlTemplate);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlTemplate pmlTemplate : findAll()) {
            remove(pmlTemplate);
        }
    }

    public int countByDepartmentId(String departmentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTemplate.class.getName();
        String finderMethodName = "countByDepartmentId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentId };

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
                    "FROM com.sgs.portlet.pml_template.model.PmlTemplate WHERE ");

                if (departmentId == null) {
                    query.append("departmentId IS NULL");
                } else {
                    query.append("departmentId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
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
        boolean finderClassNameCacheEnabled = PmlTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTemplate.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pml_template.model.PmlTemplate");

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
                        "value.object.listener.com.sgs.portlet.pml_template.model.PmlTemplate")));

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
