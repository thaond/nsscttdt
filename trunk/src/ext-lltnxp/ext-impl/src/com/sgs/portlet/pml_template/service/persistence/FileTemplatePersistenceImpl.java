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

import com.sgs.portlet.pml_template.NoSuchFileTemplateException;
import com.sgs.portlet.pml_template.model.FileTemplate;
import com.sgs.portlet.pml_template.model.impl.FileTemplateImpl;
import com.sgs.portlet.pml_template.model.impl.FileTemplateModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class FileTemplatePersistenceImpl extends BasePersistenceImpl
    implements FileTemplatePersistence {
    private static Log _log = LogFactory.getLog(FileTemplatePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public FileTemplate create(long fileTemplateId) {
        FileTemplate fileTemplate = new FileTemplateImpl();

        fileTemplate.setNew(true);
        fileTemplate.setPrimaryKey(fileTemplateId);

        return fileTemplate;
    }

    public FileTemplate remove(long fileTemplateId)
        throws NoSuchFileTemplateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            FileTemplate fileTemplate = (FileTemplate) session.get(FileTemplateImpl.class,
                    new Long(fileTemplateId));

            if (fileTemplate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No FileTemplate exists with the primary key " +
                        fileTemplateId);
                }

                throw new NoSuchFileTemplateException(
                    "No FileTemplate exists with the primary key " +
                    fileTemplateId);
            }

            return remove(fileTemplate);
        } catch (NoSuchFileTemplateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public FileTemplate remove(FileTemplate fileTemplate)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(fileTemplate);
            }
        }

        fileTemplate = removeImpl(fileTemplate);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(fileTemplate);
            }
        }

        return fileTemplate;
    }

    protected FileTemplate removeImpl(FileTemplate fileTemplate)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(fileTemplate);

            session.flush();

            return fileTemplate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(FileTemplate.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(FileTemplate fileTemplate, boolean merge)</code>.
     */
    public FileTemplate update(FileTemplate fileTemplate)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(FileTemplate fileTemplate) method. Use update(FileTemplate fileTemplate, boolean merge) instead.");
        }

        return update(fileTemplate, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileTemplate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileTemplate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public FileTemplate update(FileTemplate fileTemplate, boolean merge)
        throws SystemException {
        boolean isNew = fileTemplate.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(fileTemplate);
                } else {
                    listener.onBeforeUpdate(fileTemplate);
                }
            }
        }

        fileTemplate = updateImpl(fileTemplate, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(fileTemplate);
                } else {
                    listener.onAfterUpdate(fileTemplate);
                }
            }
        }

        return fileTemplate;
    }

    public FileTemplate updateImpl(
        com.sgs.portlet.pml_template.model.FileTemplate fileTemplate,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(fileTemplate);
            } else {
                if (fileTemplate.isNew()) {
                    session.save(fileTemplate);
                }
            }

            session.flush();

            fileTemplate.setNew(false);

            return fileTemplate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(FileTemplate.class.getName());
        }
    }

    public FileTemplate findByPrimaryKey(long fileTemplateId)
        throws NoSuchFileTemplateException, SystemException {
        FileTemplate fileTemplate = fetchByPrimaryKey(fileTemplateId);

        if (fileTemplate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No FileTemplate exists with the primary key " +
                    fileTemplateId);
            }

            throw new NoSuchFileTemplateException(
                "No FileTemplate exists with the primary key " +
                fileTemplateId);
        }

        return fileTemplate;
    }

    public FileTemplate fetchByPrimaryKey(long fileTemplateId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (FileTemplate) session.get(FileTemplateImpl.class,
                new Long(fileTemplateId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<FileTemplate> findByTemplateId(long templateId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = FileTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = FileTemplate.class.getName();
        String finderMethodName = "findByTemplateId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(templateId) };

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
                    "FROM com.sgs.portlet.pml_template.model.FileTemplate WHERE ");

                query.append("templateId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(templateId);

                List<FileTemplate> list = q.list();

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
            return (List<FileTemplate>) result;
        }
    }

    public List<FileTemplate> findByTemplateId(long templateId, int start,
        int end) throws SystemException {
        return findByTemplateId(templateId, start, end, null);
    }

    public List<FileTemplate> findByTemplateId(long templateId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = FileTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = FileTemplate.class.getName();
        String finderMethodName = "findByTemplateId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(templateId),
                
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
                    "FROM com.sgs.portlet.pml_template.model.FileTemplate WHERE ");

                query.append("templateId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(templateId);

                List<FileTemplate> list = (List<FileTemplate>) QueryUtil.list(q,
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
            return (List<FileTemplate>) result;
        }
    }

    public FileTemplate findByTemplateId_First(long templateId,
        OrderByComparator obc)
        throws NoSuchFileTemplateException, SystemException {
        List<FileTemplate> list = findByTemplateId(templateId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileTemplate exists with the key {");

            msg.append("templateId=" + templateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileTemplate findByTemplateId_Last(long templateId,
        OrderByComparator obc)
        throws NoSuchFileTemplateException, SystemException {
        int count = countByTemplateId(templateId);

        List<FileTemplate> list = findByTemplateId(templateId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileTemplate exists with the key {");

            msg.append("templateId=" + templateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileTemplateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileTemplate[] findByTemplateId_PrevAndNext(long fileTemplateId,
        long templateId, OrderByComparator obc)
        throws NoSuchFileTemplateException, SystemException {
        FileTemplate fileTemplate = findByPrimaryKey(fileTemplateId);

        int count = countByTemplateId(templateId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_template.model.FileTemplate WHERE ");

            query.append("templateId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(templateId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    fileTemplate);

            FileTemplate[] array = new FileTemplateImpl[3];

            array[0] = (FileTemplate) objArray[0];
            array[1] = (FileTemplate) objArray[1];
            array[2] = (FileTemplate) objArray[2];

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

    public List<FileTemplate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<FileTemplate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<FileTemplate> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = FileTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = FileTemplate.class.getName();
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
                    "FROM com.sgs.portlet.pml_template.model.FileTemplate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<FileTemplate> list = (List<FileTemplate>) QueryUtil.list(q,
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
            return (List<FileTemplate>) result;
        }
    }

    public void removeByTemplateId(long templateId) throws SystemException {
        for (FileTemplate fileTemplate : findByTemplateId(templateId)) {
            remove(fileTemplate);
        }
    }

    public void removeAll() throws SystemException {
        for (FileTemplate fileTemplate : findAll()) {
            remove(fileTemplate);
        }
    }

    public int countByTemplateId(long templateId) throws SystemException {
        boolean finderClassNameCacheEnabled = FileTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = FileTemplate.class.getName();
        String finderMethodName = "countByTemplateId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(templateId) };

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
                    "FROM com.sgs.portlet.pml_template.model.FileTemplate WHERE ");

                query.append("templateId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(templateId);

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
        boolean finderClassNameCacheEnabled = FileTemplateModelImpl.CACHE_ENABLED;
        String finderClassName = FileTemplate.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pml_template.model.FileTemplate");

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
                        "value.object.listener.com.sgs.portlet.pml_template.model.FileTemplate")));

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
