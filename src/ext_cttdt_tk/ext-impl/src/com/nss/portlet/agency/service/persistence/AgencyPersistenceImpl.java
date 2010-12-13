package com.nss.portlet.agency.service.persistence;

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

import com.nss.portlet.agency.NoSuchAgencyException;
import com.nss.portlet.agency.model.Agency;
import com.nss.portlet.agency.model.impl.AgencyImpl;
import com.nss.portlet.agency.model.impl.AgencyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AgencyPersistenceImpl extends BasePersistenceImpl
    implements AgencyPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = AgencyImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_AGENCYCODE = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAgencyCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_AGENCYCODE = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAgencyCode",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_AGENCYCODE = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAgencyCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_AGENCYNAME = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAgencyName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_AGENCYNAME = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAgencyName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_AGENCYNAME = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAgencyName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_C_N_D = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_C_N_D = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_C_N_D = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(AgencyPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.agency.service.persistence.AgencyPersistence.impl")
    protected com.nss.portlet.agency.service.persistence.AgencyPersistence agencyPersistence;
    @BeanReference(name = "com.nss.portlet.agency.service.persistence.PmlAgencyLeaderPersistence.impl")
    protected com.nss.portlet.agency.service.persistence.PmlAgencyLeaderPersistence pmlAgencyLeaderPersistence;

    public void cacheResult(Agency agency) {
        EntityCacheUtil.putResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyImpl.class, agency.getPrimaryKey(), agency);
    }

    public void cacheResult(List<Agency> agencies) {
        for (Agency agency : agencies) {
            if (EntityCacheUtil.getResult(
                        AgencyModelImpl.ENTITY_CACHE_ENABLED, AgencyImpl.class,
                        agency.getPrimaryKey(), this) == null) {
                cacheResult(agency);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(AgencyImpl.class.getName());
        EntityCacheUtil.clearCache(AgencyImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<Agency> listener : listeners) {
            listener.onBeforeRemove(agency);
        }

        agency = removeImpl(agency);

        for (ModelListener<Agency> listener : listeners) {
            listener.onAfterRemove(agency);
        }

        return agency;
    }

    protected Agency removeImpl(Agency agency) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (agency.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(AgencyImpl.class,
                        agency.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(agency);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyImpl.class, agency.getPrimaryKey());

        return agency;
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

        for (ModelListener<Agency> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(agency);
            } else {
                listener.onBeforeUpdate(agency);
            }
        }

        agency = updateImpl(agency, merge);

        for (ModelListener<Agency> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(agency);
            } else {
                listener.onAfterUpdate(agency);
            }
        }

        return agency;
    }

    public Agency updateImpl(com.nss.portlet.agency.model.Agency agency,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, agency, merge);

            agency.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
            AgencyImpl.class, agency.getPrimaryKey(), agency);

        return agency;
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
        Agency agency = (Agency) EntityCacheUtil.getResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
                AgencyImpl.class, agencyId, this);

        if (agency == null) {
            Session session = null;

            try {
                session = openSession();

                agency = (Agency) session.get(AgencyImpl.class, agencyId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (agency != null) {
                    cacheResult(agency);
                }

                closeSession(session);
            }
        }

        return agency;
    }

    public List<Agency> findByAgencyCode(String agencyCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { agencyCode };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_AGENCYCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_AGENCYCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Agency> findByAgencyCode(String agencyCode, int start, int end)
        throws SystemException {
        return findByAgencyCode(agencyCode, start, end, null);
    }

    public List<Agency> findByAgencyCode(String agencyCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                agencyCode,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_AGENCYCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                list = (List<Agency>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_AGENCYCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Agency findByAgencyCode_First(String agencyCode,
        OrderByComparator obc) throws NoSuchAgencyException, SystemException {
        List<Agency> list = findByAgencyCode(agencyCode, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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
        Object[] finderArgs = new Object[] { agencyName };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_AGENCYNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_AGENCYNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Agency> findByAgencyName(String agencyName, int start, int end)
        throws SystemException {
        return findByAgencyName(agencyName, start, end, null);
    }

    public List<Agency> findByAgencyName(String agencyName, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                agencyName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_AGENCYNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                list = (List<Agency>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_AGENCYNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Agency findByAgencyName_First(String agencyName,
        OrderByComparator obc) throws NoSuchAgencyException, SystemException {
        List<Agency> list = findByAgencyName(agencyName, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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
        Object[] finderArgs = new Object[] { description };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Agency> findByDescription(String description, int start, int end)
        throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Agency> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                list = (List<Agency>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Agency findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchAgencyException, SystemException {
        List<Agency> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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
        Object[] finderArgs = new Object[] { agencyCode, agencyName, description };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_C_N_D,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_C_N_D,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Agency> findByC_N_D(String agencyCode, String agencyName,
        String description, int start, int end) throws SystemException {
        return findByC_N_D(agencyCode, agencyName, description, start, end, null);
    }

    public List<Agency> findByC_N_D(String agencyCode, String agencyName,
        String description, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                agencyCode,
                
                agencyName,
                
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_C_N_D,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                list = (List<Agency>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_C_N_D,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Agency findByC_N_D_First(String agencyCode, String agencyName,
        String description, OrderByComparator obc)
        throws NoSuchAgencyException, SystemException {
        List<Agency> list = findByC_N_D(agencyCode, agencyName, description, 0,
                1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Agency> list = (List<Agency>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.agency.model.Agency ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("agencyname ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<Agency>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Agency>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Agency>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { agencyCode };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AGENCYCODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AGENCYCODE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByAgencyName(String agencyName) throws SystemException {
        Object[] finderArgs = new Object[] { agencyName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AGENCYNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AGENCYNAME,
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
                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

    public int countByC_N_D(String agencyCode, String agencyName,
        String description) throws SystemException {
        Object[] finderArgs = new Object[] { agencyCode, agencyName, description };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_N_D,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append("FROM com.nss.portlet.agency.model.Agency WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_N_D,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.agency.model.Agency");

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
                        "value.object.listener.com.nss.portlet.agency.model.Agency")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Agency>> listenersList = new ArrayList<ModelListener<Agency>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Agency>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
