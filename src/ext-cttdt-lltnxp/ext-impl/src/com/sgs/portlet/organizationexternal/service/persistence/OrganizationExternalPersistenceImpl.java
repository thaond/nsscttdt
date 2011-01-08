package com.sgs.portlet.organizationexternal.service.persistence;

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

import com.sgs.portlet.organizationexternal.NoSuchException;
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.model.impl.OrganizationExternalImpl;
import com.sgs.portlet.organizationexternal.model.impl.OrganizationExternalModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class OrganizationExternalPersistenceImpl extends BasePersistenceImpl
    implements OrganizationExternalPersistence {
    private static Log _log = LogFactory.getLog(OrganizationExternalPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public OrganizationExternal create(long orgExternalId) {
        OrganizationExternal organizationExternal = new OrganizationExternalImpl();

        organizationExternal.setNew(true);
        organizationExternal.setPrimaryKey(orgExternalId);

        return organizationExternal;
    }

    public OrganizationExternal remove(long orgExternalId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            OrganizationExternal organizationExternal = (OrganizationExternal) session.get(OrganizationExternalImpl.class,
                    new Long(orgExternalId));

            if (organizationExternal == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No OrganizationExternal exists with the primary key " +
                        orgExternalId);
                }

                throw new NoSuchException(
                    "No OrganizationExternal exists with the primary key " +
                    orgExternalId);
            }

            return remove(organizationExternal);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public OrganizationExternal remove(
        OrganizationExternal organizationExternal) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(organizationExternal);
            }
        }

        organizationExternal = removeImpl(organizationExternal);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(organizationExternal);
            }
        }

        return organizationExternal;
    }

    protected OrganizationExternal removeImpl(
        OrganizationExternal organizationExternal) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(organizationExternal);

            session.flush();

            return organizationExternal;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(OrganizationExternal.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(OrganizationExternal organizationExternal, boolean merge)</code>.
     */
    public OrganizationExternal update(
        OrganizationExternal organizationExternal) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(OrganizationExternal organizationExternal) method. Use update(OrganizationExternal organizationExternal, boolean merge) instead.");
        }

        return update(organizationExternal, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                organizationExternal the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when organizationExternal is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public OrganizationExternal update(
        OrganizationExternal organizationExternal, boolean merge)
        throws SystemException {
        boolean isNew = organizationExternal.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(organizationExternal);
                } else {
                    listener.onBeforeUpdate(organizationExternal);
                }
            }
        }

        organizationExternal = updateImpl(organizationExternal, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(organizationExternal);
                } else {
                    listener.onAfterUpdate(organizationExternal);
                }
            }
        }

        return organizationExternal;
    }

    public OrganizationExternal updateImpl(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(organizationExternal);
            } else {
                if (organizationExternal.isNew()) {
                    session.save(organizationExternal);
                }
            }

            session.flush();

            organizationExternal.setNew(false);

            return organizationExternal;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(OrganizationExternal.class.getName());
        }
    }

    public OrganizationExternal findByPrimaryKey(long orgExternalId)
        throws NoSuchException, SystemException {
        OrganizationExternal organizationExternal = fetchByPrimaryKey(orgExternalId);

        if (organizationExternal == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No OrganizationExternal exists with the primary key " +
                    orgExternalId);
            }

            throw new NoSuchException(
                "No OrganizationExternal exists with the primary key " +
                orgExternalId);
        }

        return organizationExternal;
    }

    public OrganizationExternal fetchByPrimaryKey(long orgExternalId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (OrganizationExternal) session.get(OrganizationExternalImpl.class,
                new Long(orgExternalId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<OrganizationExternal> findByOrgExternalCode(
        String orgExternalCode) throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "findByOrgExternalCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { orgExternalCode };

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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                if (orgExternalCode == null) {
                    query.append("orgexternalcode LIKE null");
                } else {
                    query.append("orgexternalcode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("orgexternalname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (orgExternalCode != null) {
                    qPos.add(orgExternalCode);
                }

                List<OrganizationExternal> list = q.list();

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
            return (List<OrganizationExternal>) result;
        }
    }

    public List<OrganizationExternal> findByOrgExternalCode(
        String orgExternalCode, int start, int end) throws SystemException {
        return findByOrgExternalCode(orgExternalCode, start, end, null);
    }

    public List<OrganizationExternal> findByOrgExternalCode(
        String orgExternalCode, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "findByOrgExternalCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                orgExternalCode,
                
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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                if (orgExternalCode == null) {
                    query.append("orgexternalcode LIKE null");
                } else {
                    query.append("orgexternalcode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("orgexternalname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (orgExternalCode != null) {
                    qPos.add(orgExternalCode);
                }

                List<OrganizationExternal> list = (List<OrganizationExternal>) QueryUtil.list(q,
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
            return (List<OrganizationExternal>) result;
        }
    }

    public OrganizationExternal findByOrgExternalCode_First(
        String orgExternalCode, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<OrganizationExternal> list = findByOrgExternalCode(orgExternalCode,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No OrganizationExternal exists with the key {");

            msg.append("orgExternalCode=" + orgExternalCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public OrganizationExternal findByOrgExternalCode_Last(
        String orgExternalCode, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByOrgExternalCode(orgExternalCode);

        List<OrganizationExternal> list = findByOrgExternalCode(orgExternalCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No OrganizationExternal exists with the key {");

            msg.append("orgExternalCode=" + orgExternalCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public OrganizationExternal[] findByOrgExternalCode_PrevAndNext(
        long orgExternalId, String orgExternalCode, OrderByComparator obc)
        throws NoSuchException, SystemException {
        OrganizationExternal organizationExternal = findByPrimaryKey(orgExternalId);

        int count = countByOrgExternalCode(orgExternalCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

            if (orgExternalCode == null) {
                query.append("orgexternalcode LIKE null");
            } else {
                query.append("orgexternalcode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("orgexternalname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (orgExternalCode != null) {
                qPos.add(orgExternalCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    organizationExternal);

            OrganizationExternal[] array = new OrganizationExternalImpl[3];

            array[0] = (OrganizationExternal) objArray[0];
            array[1] = (OrganizationExternal) objArray[1];
            array[2] = (OrganizationExternal) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<OrganizationExternal> findByOrgExternalName(
        String orgExternalName) throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "findByOrgExternalName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { orgExternalName };

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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                if (orgExternalName == null) {
                    query.append("orgexternalname LIKE null");
                } else {
                    query.append("lower(orgexternalname) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("orgexternalname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (orgExternalName != null) {
                    qPos.add(orgExternalName);
                }

                List<OrganizationExternal> list = q.list();

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
            return (List<OrganizationExternal>) result;
        }
    }

    public List<OrganizationExternal> findByOrgExternalName(
        String orgExternalName, int start, int end) throws SystemException {
        return findByOrgExternalName(orgExternalName, start, end, null);
    }

    public List<OrganizationExternal> findByOrgExternalName(
        String orgExternalName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "findByOrgExternalName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                orgExternalName,
                
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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                if (orgExternalName == null) {
                    query.append("orgexternalname LIKE null");
                } else {
                    query.append("lower(orgexternalname) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("orgexternalname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (orgExternalName != null) {
                    qPos.add(orgExternalName);
                }

                List<OrganizationExternal> list = (List<OrganizationExternal>) QueryUtil.list(q,
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
            return (List<OrganizationExternal>) result;
        }
    }

    public OrganizationExternal findByOrgExternalName_First(
        String orgExternalName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<OrganizationExternal> list = findByOrgExternalName(orgExternalName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No OrganizationExternal exists with the key {");

            msg.append("orgExternalName=" + orgExternalName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public OrganizationExternal findByOrgExternalName_Last(
        String orgExternalName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByOrgExternalName(orgExternalName);

        List<OrganizationExternal> list = findByOrgExternalName(orgExternalName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No OrganizationExternal exists with the key {");

            msg.append("orgExternalName=" + orgExternalName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public OrganizationExternal[] findByOrgExternalName_PrevAndNext(
        long orgExternalId, String orgExternalName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        OrganizationExternal organizationExternal = findByPrimaryKey(orgExternalId);

        int count = countByOrgExternalName(orgExternalName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

            if (orgExternalName == null) {
                query.append("orgexternalname LIKE null");
            } else {
                query.append("lower(orgexternalname) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("orgexternalname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (orgExternalName != null) {
                qPos.add(orgExternalName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    organizationExternal);

            OrganizationExternal[] array = new OrganizationExternalImpl[3];

            array[0] = (OrganizationExternal) objArray[0];
            array[1] = (OrganizationExternal) objArray[1];
            array[2] = (OrganizationExternal) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<OrganizationExternal> findByIsOwnerOrg(boolean isOwnerOrg)
        throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "findByIsOwnerOrg";
        String[] finderParams = new String[] { Boolean.class.getName() };
        Object[] finderArgs = new Object[] { Boolean.valueOf(isOwnerOrg) };

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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                query.append("isownerorg = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("orgexternalname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(isOwnerOrg);

                List<OrganizationExternal> list = q.list();

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
            return (List<OrganizationExternal>) result;
        }
    }

    public List<OrganizationExternal> findByIsOwnerOrg(boolean isOwnerOrg,
        int start, int end) throws SystemException {
        return findByIsOwnerOrg(isOwnerOrg, start, end, null);
    }

    public List<OrganizationExternal> findByIsOwnerOrg(boolean isOwnerOrg,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "findByIsOwnerOrg";
        String[] finderParams = new String[] {
                Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                Boolean.valueOf(isOwnerOrg),
                
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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                query.append("isownerorg = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("orgexternalname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(isOwnerOrg);

                List<OrganizationExternal> list = (List<OrganizationExternal>) QueryUtil.list(q,
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
            return (List<OrganizationExternal>) result;
        }
    }

    public OrganizationExternal findByIsOwnerOrg_First(boolean isOwnerOrg,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<OrganizationExternal> list = findByIsOwnerOrg(isOwnerOrg, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No OrganizationExternal exists with the key {");

            msg.append("isOwnerOrg=" + isOwnerOrg);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public OrganizationExternal findByIsOwnerOrg_Last(boolean isOwnerOrg,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByIsOwnerOrg(isOwnerOrg);

        List<OrganizationExternal> list = findByIsOwnerOrg(isOwnerOrg,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No OrganizationExternal exists with the key {");

            msg.append("isOwnerOrg=" + isOwnerOrg);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public OrganizationExternal[] findByIsOwnerOrg_PrevAndNext(
        long orgExternalId, boolean isOwnerOrg, OrderByComparator obc)
        throws NoSuchException, SystemException {
        OrganizationExternal organizationExternal = findByPrimaryKey(orgExternalId);

        int count = countByIsOwnerOrg(isOwnerOrg);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

            query.append("isownerorg = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("orgexternalname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(isOwnerOrg);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    organizationExternal);

            OrganizationExternal[] array = new OrganizationExternalImpl[3];

            array[0] = (OrganizationExternal) objArray[0];
            array[1] = (OrganizationExternal) objArray[1];
            array[2] = (OrganizationExternal) objArray[2];

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

    public List<OrganizationExternal> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<OrganizationExternal> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<OrganizationExternal> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("orgexternalname ASC");
                }

                Query q = session.createQuery(query.toString());

                List<OrganizationExternal> list = (List<OrganizationExternal>) QueryUtil.list(q,
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
            return (List<OrganizationExternal>) result;
        }
    }

    public void removeByOrgExternalCode(String orgExternalCode)
        throws SystemException {
        for (OrganizationExternal organizationExternal : findByOrgExternalCode(
                orgExternalCode)) {
            remove(organizationExternal);
        }
    }

    public void removeByOrgExternalName(String orgExternalName)
        throws SystemException {
        for (OrganizationExternal organizationExternal : findByOrgExternalName(
                orgExternalName)) {
            remove(organizationExternal);
        }
    }

    public void removeByIsOwnerOrg(boolean isOwnerOrg)
        throws SystemException {
        for (OrganizationExternal organizationExternal : findByIsOwnerOrg(
                isOwnerOrg)) {
            remove(organizationExternal);
        }
    }

    public void removeAll() throws SystemException {
        for (OrganizationExternal organizationExternal : findAll()) {
            remove(organizationExternal);
        }
    }

    public int countByOrgExternalCode(String orgExternalCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "countByOrgExternalCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { orgExternalCode };

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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                if (orgExternalCode == null) {
                    query.append("orgexternalcode LIKE null");
                } else {
                    query.append("orgexternalcode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (orgExternalCode != null) {
                    qPos.add(orgExternalCode);
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

    public int countByOrgExternalName(String orgExternalName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "countByOrgExternalName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { orgExternalName };

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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                if (orgExternalName == null) {
                    query.append("orgexternalname LIKE null");
                } else {
                    query.append("lower(orgexternalname) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (orgExternalName != null) {
                    qPos.add(orgExternalName);
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

    public int countByIsOwnerOrg(boolean isOwnerOrg) throws SystemException {
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
        String finderMethodName = "countByIsOwnerOrg";
        String[] finderParams = new String[] { Boolean.class.getName() };
        Object[] finderArgs = new Object[] { Boolean.valueOf(isOwnerOrg) };

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
                    "FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal WHERE ");

                query.append("isownerorg = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(isOwnerOrg);

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
        boolean finderClassNameCacheEnabled = OrganizationExternalModelImpl.CACHE_ENABLED;
        String finderClassName = OrganizationExternal.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.organizationexternal.model.OrganizationExternal");

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
                        "value.object.listener.com.sgs.portlet.organizationexternal.model.OrganizationExternal")));

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
