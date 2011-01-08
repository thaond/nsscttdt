package com.sgs.portlet.agency.service.persistence;

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

import com.sgs.portlet.agency.NoSuchAgencyException;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.model.impl.AgencyImpl;
import com.sgs.portlet.agency.model.impl.AgencyModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class AgencyPersistenceImpl extends BasePersistenceImpl
    implements AgencyPersistence {
    private static Log _log = LogFactory.getLog(AgencyPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public Agency create(String agencyId) {
        Agency agency = new AgencyImpl();

        agency.setNew(true);
        agency.setPrimaryKey(agencyId);

        return agency;
    }

    public Agency remove(String agencyId)
        throws NoSuchAgencyException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Agency agency = (Agency) session.get(AgencyImpl.class, agencyId);

            if (agency == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Agency exists with the primary key " +
                        agencyId);
                }

                throw new NoSuchAgencyException(
                    "No Agency exists with the primary key " + agencyId);
            }

            return remove(agency);
        } catch (NoSuchAgencyException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Agency remove(Agency agency) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(agency);
            }
        }

        agency = removeImpl(agency);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(agency);
            }
        }

        return agency;
    }

    protected Agency removeImpl(Agency agency) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(agency);

            session.flush();

            return agency;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Agency.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Agency agency, boolean merge)</code>.
     */
    public Agency update(Agency agency) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Agency agency) method. Use update(Agency agency, boolean merge) instead.");
        }

        return update(agency, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                agency the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when agency is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Agency update(Agency agency, boolean merge)
        throws SystemException {
        boolean isNew = agency.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(agency);
                } else {
                    listener.onBeforeUpdate(agency);
                }
            }
        }

        agency = updateImpl(agency, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(agency);
                } else {
                    listener.onAfterUpdate(agency);
                }
            }
        }

        return agency;
    }

    public Agency updateImpl(com.sgs.portlet.agency.model.Agency agency,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(agency);
            } else {
                if (agency.isNew()) {
                    session.save(agency);
                }
            }

            session.flush();

            agency.setNew(false);

            return agency;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Agency.class.getName());
        }
    }

    public Agency findByPrimaryKey(String agencyId)
        throws NoSuchAgencyException, SystemException {
        Agency agency = fetchByPrimaryKey(agencyId);

        if (agency == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Agency exists with the primary key " + agencyId);
            }

            throw new NoSuchAgencyException(
                "No Agency exists with the primary key " + agencyId);
        }

        return agency;
    }

    public Agency fetchByPrimaryKey(String agencyId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Agency) session.get(AgencyImpl.class, agencyId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Agency> findByAgencyCode(String agencyCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "findByAgencyCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { agencyCode };

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

                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyCode == null) {
                    query.append("agencycode LIKE null");
                } else {
                    query.append("lower(agencycode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("agencyname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyCode != null) {
                    qPos.add(agencyCode);
                }

                List<Agency> list = q.list();

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
            return (List<Agency>) result;
        }
    }

    public List<Agency> findByAgencyCode(String agencyCode, int start, int end)
        throws SystemException {
        return findByAgencyCode(agencyCode, start, end, null);
    }

    public List<Agency> findByAgencyCode(String agencyCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "findByAgencyCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                agencyCode,
                
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

                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyCode == null) {
                    query.append("agencycode LIKE null");
                } else {
                    query.append("lower(agencycode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("agencyname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyCode != null) {
                    qPos.add(agencyCode);
                }

                List<Agency> list = (List<Agency>) QueryUtil.list(q,
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
            return (List<Agency>) result;
        }
    }

    public Agency findByAgencyCode_First(String agencyCode,
        OrderByComparator obc) throws NoSuchAgencyException, SystemException {
        List<Agency> list = findByAgencyCode(agencyCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Agency exists with the key {");

            msg.append("agencyCode=" + agencyCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAgencyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Agency findByAgencyCode_Last(String agencyCode, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        int count = countByAgencyCode(agencyCode);

        List<Agency> list = findByAgencyCode(agencyCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Agency exists with the key {");

            msg.append("agencyCode=" + agencyCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAgencyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Agency[] findByAgencyCode_PrevAndNext(String agencyId,
        String agencyCode, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        Agency agency = findByPrimaryKey(agencyId);

        int count = countByAgencyCode(agencyCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

            if (agencyCode == null) {
                query.append("agencycode LIKE null");
            } else {
                query.append("lower(agencycode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("agencyname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (agencyCode != null) {
                qPos.add(agencyCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, agency);

            Agency[] array = new AgencyImpl[3];

            array[0] = (Agency) objArray[0];
            array[1] = (Agency) objArray[1];
            array[2] = (Agency) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Agency> findByAgencyName(String agencyName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "findByAgencyName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { agencyName };

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

                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyName == null) {
                    query.append("agencyname LIKE null");
                } else {
                    query.append("lower(agencyname) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("agencyname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyName != null) {
                    qPos.add(agencyName);
                }

                List<Agency> list = q.list();

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
            return (List<Agency>) result;
        }
    }

    public List<Agency> findByAgencyName(String agencyName, int start, int end)
        throws SystemException {
        return findByAgencyName(agencyName, start, end, null);
    }

    public List<Agency> findByAgencyName(String agencyName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "findByAgencyName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                agencyName,
                
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

                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyName == null) {
                    query.append("agencyname LIKE null");
                } else {
                    query.append("lower(agencyname) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("agencyname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyName != null) {
                    qPos.add(agencyName);
                }

                List<Agency> list = (List<Agency>) QueryUtil.list(q,
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
            return (List<Agency>) result;
        }
    }

    public Agency findByAgencyName_First(String agencyName,
        OrderByComparator obc) throws NoSuchAgencyException, SystemException {
        List<Agency> list = findByAgencyName(agencyName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Agency exists with the key {");

            msg.append("agencyName=" + agencyName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAgencyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Agency findByAgencyName_Last(String agencyName, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        int count = countByAgencyName(agencyName);

        List<Agency> list = findByAgencyName(agencyName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Agency exists with the key {");

            msg.append("agencyName=" + agencyName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAgencyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Agency[] findByAgencyName_PrevAndNext(String agencyId,
        String agencyName, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        Agency agency = findByPrimaryKey(agencyId);

        int count = countByAgencyName(agencyName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

            if (agencyName == null) {
                query.append("agencyname LIKE null");
            } else {
                query.append("lower(agencyname) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("agencyname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (agencyName != null) {
                qPos.add(agencyName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, agency);

            Agency[] array = new AgencyImpl[3];

            array[0] = (Agency) objArray[0];
            array[1] = (Agency) objArray[1];
            array[2] = (Agency) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Agency> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
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

                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("agencyname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Agency> list = q.list();

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
            return (List<Agency>) result;
        }
    }

    public List<Agency> findByDescription(String description, int start, int end)
        throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Agency> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
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

                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

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

                    query.append("agencyname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Agency> list = (List<Agency>) QueryUtil.list(q,
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
            return (List<Agency>) result;
        }
    }

    public Agency findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchAgencyException, SystemException {
        List<Agency> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Agency exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAgencyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Agency findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchAgencyException, SystemException {
        int count = countByDescription(description);

        List<Agency> list = findByDescription(description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Agency exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAgencyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Agency[] findByDescription_PrevAndNext(String agencyId,
        String description, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        Agency agency = findByPrimaryKey(agencyId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

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

                query.append("agencyname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, agency);

            Agency[] array = new AgencyImpl[3];

            array[0] = (Agency) objArray[0];
            array[1] = (Agency) objArray[1];
            array[2] = (Agency) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Agency> findByC_N_D(String agencyCode, String agencyName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { agencyCode, agencyName, description };

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

                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyCode == null) {
                    query.append("agencycode LIKE null");
                } else {
                    query.append("agencycode LIKE ?");
                }

                query.append(" AND ");

                if (agencyName == null) {
                    query.append("agencyname LIKE null");
                } else {
                    query.append("agencyname LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("agencyname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyCode != null) {
                    qPos.add(agencyCode);
                }

                if (agencyName != null) {
                    qPos.add(agencyName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Agency> list = q.list();

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
            return (List<Agency>) result;
        }
    }

    public List<Agency> findByC_N_D(String agencyCode, String agencyName,
        String description, int start, int end) throws SystemException {
        return findByC_N_D(agencyCode, agencyName, description, start, end, null);
    }

    public List<Agency> findByC_N_D(String agencyCode, String agencyName,
        String description, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                agencyCode,
                
                agencyName,
                
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

                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyCode == null) {
                    query.append("agencycode LIKE null");
                } else {
                    query.append("agencycode LIKE ?");
                }

                query.append(" AND ");

                if (agencyName == null) {
                    query.append("agencyname LIKE null");
                } else {
                    query.append("agencyname LIKE ?");
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
                else {
                    query.append("ORDER BY ");

                    query.append("agencyname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyCode != null) {
                    qPos.add(agencyCode);
                }

                if (agencyName != null) {
                    qPos.add(agencyName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Agency> list = (List<Agency>) QueryUtil.list(q,
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
            return (List<Agency>) result;
        }
    }

    public Agency findByC_N_D_First(String agencyCode, String agencyName,
        String description, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        List<Agency> list = findByC_N_D(agencyCode, agencyName, description, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Agency exists with the key {");

            msg.append("agencyCode=" + agencyCode);

            msg.append(", ");
            msg.append("agencyName=" + agencyName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAgencyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Agency findByC_N_D_Last(String agencyCode, String agencyName,
        String description, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        int count = countByC_N_D(agencyCode, agencyName, description);

        List<Agency> list = findByC_N_D(agencyCode, agencyName, description,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Agency exists with the key {");

            msg.append("agencyCode=" + agencyCode);

            msg.append(", ");
            msg.append("agencyName=" + agencyName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAgencyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Agency[] findByC_N_D_PrevAndNext(String agencyId, String agencyCode,
        String agencyName, String description, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        Agency agency = findByPrimaryKey(agencyId);

        int count = countByC_N_D(agencyCode, agencyName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

            if (agencyCode == null) {
                query.append("agencycode LIKE null");
            } else {
                query.append("agencycode LIKE ?");
            }

            query.append(" AND ");

            if (agencyName == null) {
                query.append("agencyname LIKE null");
            } else {
                query.append("agencyname LIKE ?");
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
            else {
                query.append("ORDER BY ");

                query.append("agencyname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (agencyCode != null) {
                qPos.add(agencyCode);
            }

            if (agencyName != null) {
                qPos.add(agencyName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, agency);

            Agency[] array = new AgencyImpl[3];

            array[0] = (Agency) objArray[0];
            array[1] = (Agency) objArray[1];
            array[2] = (Agency) objArray[2];

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

    public List<Agency> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Agency> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Agency> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
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

                query.append("FROM com.sgs.portlet.agency.model.Agency ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("agencyname ASC");
                }

                Query q = session.createQuery(query.toString());

                List<Agency> list = (List<Agency>) QueryUtil.list(q,
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
            return (List<Agency>) result;
        }
    }

    public void removeByAgencyCode(String agencyCode) throws SystemException {
        for (Agency agency : findByAgencyCode(agencyCode)) {
            remove(agency);
        }
    }

    public void removeByAgencyName(String agencyName) throws SystemException {
        for (Agency agency : findByAgencyName(agencyName)) {
            remove(agency);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (Agency agency : findByDescription(description)) {
            remove(agency);
        }
    }

    public void removeByC_N_D(String agencyCode, String agencyName,
        String description) throws SystemException {
        for (Agency agency : findByC_N_D(agencyCode, agencyName, description)) {
            remove(agency);
        }
    }

    public void removeAll() throws SystemException {
        for (Agency agency : findAll()) {
            remove(agency);
        }
    }

    public int countByAgencyCode(String agencyCode) throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "countByAgencyCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { agencyCode };

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
                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyCode == null) {
                    query.append("agencycode LIKE null");
                } else {
                    query.append("lower(agencycode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyCode != null) {
                    qPos.add(agencyCode);
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

    public int countByAgencyName(String agencyName) throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "countByAgencyName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { agencyName };

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
                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyName == null) {
                    query.append("agencyname LIKE null");
                } else {
                    query.append("lower(agencyname) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyName != null) {
                    qPos.add(agencyName);
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
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
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
                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

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

    public int countByC_N_D(String agencyCode, String agencyName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
        String finderMethodName = "countByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { agencyCode, agencyName, description };

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
                query.append("FROM com.sgs.portlet.agency.model.Agency WHERE ");

                if (agencyCode == null) {
                    query.append("agencycode LIKE null");
                } else {
                    query.append("agencycode LIKE ?");
                }

                query.append(" AND ");

                if (agencyName == null) {
                    query.append("agencyname LIKE null");
                } else {
                    query.append("agencyname LIKE ?");
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

                if (agencyCode != null) {
                    qPos.add(agencyCode);
                }

                if (agencyName != null) {
                    qPos.add(agencyName);
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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = AgencyModelImpl.CACHE_ENABLED;
        String finderClassName = Agency.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.agency.model.Agency");

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
                        "value.object.listener.com.sgs.portlet.agency.model.Agency")));

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
