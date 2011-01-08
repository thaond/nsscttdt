package com.sgs.portlet.districtmanagement.service.persistence;

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

import com.sgs.portlet.districtmanagement.NoSuchDistrictException;
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.model.impl.DistrictImpl;
import com.sgs.portlet.districtmanagement.model.impl.DistrictModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class DistrictPersistenceImpl extends BasePersistenceImpl
    implements DistrictPersistence {
    private static Log _log = LogFactory.getLog(DistrictPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public District create(String districtId) {
        District district = new DistrictImpl();

        district.setNew(true);
        district.setPrimaryKey(districtId);

        return district;
    }

    public District remove(String districtId)
        throws NoSuchDistrictException, SystemException {
        Session session = null;

        try {
            session = openSession();

            District district = (District) session.get(DistrictImpl.class,
                    districtId);

            if (district == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No District exists with the primary key " +
                        districtId);
                }

                throw new NoSuchDistrictException(
                    "No District exists with the primary key " + districtId);
            }

            return remove(district);
        } catch (NoSuchDistrictException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public District remove(District district) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(district);
            }
        }

        district = removeImpl(district);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(district);
            }
        }

        return district;
    }

    protected District removeImpl(District district) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(district);

            session.flush();

            return district;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(District.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(District district, boolean merge)</code>.
     */
    public District update(District district) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(District district) method. Use update(District district, boolean merge) instead.");
        }

        return update(district, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                district the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when district is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public District update(District district, boolean merge)
        throws SystemException {
        boolean isNew = district.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(district);
                } else {
                    listener.onBeforeUpdate(district);
                }
            }
        }

        district = updateImpl(district, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(district);
                } else {
                    listener.onAfterUpdate(district);
                }
            }
        }

        return district;
    }

    public District updateImpl(
        com.sgs.portlet.districtmanagement.model.District district,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(district);
            } else {
                if (district.isNew()) {
                    session.save(district);
                }
            }

            session.flush();

            district.setNew(false);

            return district;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(District.class.getName());
        }
    }

    public District findByPrimaryKey(String districtId)
        throws NoSuchDistrictException, SystemException {
        District district = fetchByPrimaryKey(districtId);

        if (district == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No District exists with the primary key " +
                    districtId);
            }

            throw new NoSuchDistrictException(
                "No District exists with the primary key " + districtId);
        }

        return district;
    }

    public District fetchByPrimaryKey(String districtId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (District) session.get(DistrictImpl.class, districtId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<District> findByDistrictActive(String active)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByDistrictActive";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { active };

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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("districtName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

                List<District> list = q.list();

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
            return (List<District>) result;
        }
    }

    public List<District> findByDistrictActive(String active, int start, int end)
        throws SystemException {
        return findByDistrictActive(active, start, end, null);
    }

    public List<District> findByDistrictActive(String active, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByDistrictActive";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                active,
                
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("districtName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

                List<District> list = (List<District>) QueryUtil.list(q,
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
            return (List<District>) result;
        }
    }

    public District findByDistrictActive_First(String active,
        OrderByComparator obc) throws NoSuchDistrictException, SystemException {
        List<District> list = findByDistrictActive(active, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District findByDistrictActive_Last(String active,
        OrderByComparator obc) throws NoSuchDistrictException, SystemException {
        int count = countByDistrictActive(active);

        List<District> list = findByDistrictActive(active, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District[] findByDistrictActive_PrevAndNext(String districtId,
        String active, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        int count = countByDistrictActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

            if (active == null) {
                query.append("active IS NULL");
            } else {
                query.append("active = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("districtName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (active != null) {
                qPos.add(active);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, district);

            District[] array = new DistrictImpl[3];

            array[0] = (District) objArray[0];
            array[1] = (District) objArray[1];
            array[2] = (District) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<District> findByC_N_I_D(String districtCode,
        String districtName, String cityID, String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByC_N_I_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                districtCode,
                
                districtName,
                
                cityID,
                
                description
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtCode == null) {
                    query.append("districtCode LIKE null");
                } else {
                    query.append("districtCode LIKE ?");
                }

                query.append(" AND ");

                if (districtName == null) {
                    query.append("districtName LIKE null");
                } else {
                    query.append("districtName LIKE ?");
                }

                query.append(" AND ");

                if (cityID == null) {
                    query.append("cityID LIKE null");
                } else {
                    query.append("cityID LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("districtName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtCode != null) {
                    qPos.add(districtCode);
                }

                if (districtName != null) {
                    qPos.add(districtName);
                }

                if (cityID != null) {
                    qPos.add(cityID);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<District> list = q.list();

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
            return (List<District>) result;
        }
    }

    public List<District> findByC_N_I_D(String districtCode,
        String districtName, String cityID, String description, int start,
        int end) throws SystemException {
        return findByC_N_I_D(districtCode, districtName, cityID, description,
            start, end, null);
    }

    public List<District> findByC_N_I_D(String districtCode,
        String districtName, String cityID, String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByC_N_I_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                districtCode,
                
                districtName,
                
                cityID,
                
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtCode == null) {
                    query.append("districtCode LIKE null");
                } else {
                    query.append("districtCode LIKE ?");
                }

                query.append(" AND ");

                if (districtName == null) {
                    query.append("districtName LIKE null");
                } else {
                    query.append("districtName LIKE ?");
                }

                query.append(" AND ");

                if (cityID == null) {
                    query.append("cityID LIKE null");
                } else {
                    query.append("cityID LIKE ?");
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

                    query.append("districtName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtCode != null) {
                    qPos.add(districtCode);
                }

                if (districtName != null) {
                    qPos.add(districtName);
                }

                if (cityID != null) {
                    qPos.add(cityID);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<District> list = (List<District>) QueryUtil.list(q,
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
            return (List<District>) result;
        }
    }

    public District findByC_N_I_D_First(String districtCode,
        String districtName, String cityID, String description,
        OrderByComparator obc) throws NoSuchDistrictException, SystemException {
        List<District> list = findByC_N_I_D(districtCode, districtName, cityID,
                description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("districtCode=" + districtCode);

            msg.append(", ");
            msg.append("districtName=" + districtName);

            msg.append(", ");
            msg.append("cityID=" + cityID);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District findByC_N_I_D_Last(String districtCode,
        String districtName, String cityID, String description,
        OrderByComparator obc) throws NoSuchDistrictException, SystemException {
        int count = countByC_N_I_D(districtCode, districtName, cityID,
                description);

        List<District> list = findByC_N_I_D(districtCode, districtName, cityID,
                description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("districtCode=" + districtCode);

            msg.append(", ");
            msg.append("districtName=" + districtName);

            msg.append(", ");
            msg.append("cityID=" + cityID);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District[] findByC_N_I_D_PrevAndNext(String districtId,
        String districtCode, String districtName, String cityID,
        String description, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        int count = countByC_N_I_D(districtCode, districtName, cityID,
                description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

            if (districtCode == null) {
                query.append("districtCode LIKE null");
            } else {
                query.append("districtCode LIKE ?");
            }

            query.append(" AND ");

            if (districtName == null) {
                query.append("districtName LIKE null");
            } else {
                query.append("districtName LIKE ?");
            }

            query.append(" AND ");

            if (cityID == null) {
                query.append("cityID LIKE null");
            } else {
                query.append("cityID LIKE ?");
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

                query.append("districtName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (districtCode != null) {
                qPos.add(districtCode);
            }

            if (districtName != null) {
                qPos.add(districtName);
            }

            if (cityID != null) {
                qPos.add(cityID);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, district);

            District[] array = new DistrictImpl[3];

            array[0] = (District) objArray[0];
            array[1] = (District) objArray[1];
            array[2] = (District) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<District> findByCode(String districtCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { districtCode };

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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtCode == null) {
                    query.append("districtCode LIKE null");
                } else {
                    query.append("lower(districtCode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("districtName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtCode != null) {
                    qPos.add(districtCode);
                }

                List<District> list = q.list();

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
            return (List<District>) result;
        }
    }

    public List<District> findByCode(String districtCode, int start, int end)
        throws SystemException {
        return findByCode(districtCode, start, end, null);
    }

    public List<District> findByCode(String districtCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                districtCode,
                
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtCode == null) {
                    query.append("districtCode LIKE null");
                } else {
                    query.append("lower(districtCode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("districtName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtCode != null) {
                    qPos.add(districtCode);
                }

                List<District> list = (List<District>) QueryUtil.list(q,
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
            return (List<District>) result;
        }
    }

    public District findByCode_First(String districtCode, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        List<District> list = findByCode(districtCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("districtCode=" + districtCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District findByCode_Last(String districtCode, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        int count = countByCode(districtCode);

        List<District> list = findByCode(districtCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("districtCode=" + districtCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District[] findByCode_PrevAndNext(String districtId,
        String districtCode, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        int count = countByCode(districtCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

            if (districtCode == null) {
                query.append("districtCode LIKE null");
            } else {
                query.append("lower(districtCode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("districtName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (districtCode != null) {
                qPos.add(districtCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, district);

            District[] array = new DistrictImpl[3];

            array[0] = (District) objArray[0];
            array[1] = (District) objArray[1];
            array[2] = (District) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<District> findByName(String districtName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { districtName };

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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtName == null) {
                    query.append("districtName LIKE null");
                } else {
                    query.append("lower(districtName) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("districtName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtName != null) {
                    qPos.add(districtName);
                }

                List<District> list = q.list();

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
            return (List<District>) result;
        }
    }

    public List<District> findByName(String districtName, int start, int end)
        throws SystemException {
        return findByName(districtName, start, end, null);
    }

    public List<District> findByName(String districtName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                districtName,
                
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtName == null) {
                    query.append("districtName LIKE null");
                } else {
                    query.append("lower(districtName) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("districtName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtName != null) {
                    qPos.add(districtName);
                }

                List<District> list = (List<District>) QueryUtil.list(q,
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
            return (List<District>) result;
        }
    }

    public District findByName_First(String districtName, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        List<District> list = findByName(districtName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("districtName=" + districtName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District findByName_Last(String districtName, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        int count = countByName(districtName);

        List<District> list = findByName(districtName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("districtName=" + districtName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District[] findByName_PrevAndNext(String districtId,
        String districtName, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        int count = countByName(districtName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

            if (districtName == null) {
                query.append("districtName LIKE null");
            } else {
                query.append("lower(districtName) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("districtName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (districtName != null) {
                qPos.add(districtName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, district);

            District[] array = new DistrictImpl[3];

            array[0] = (District) objArray[0];
            array[1] = (District) objArray[1];
            array[2] = (District) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<District> findByCityID(String cityID) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByCityID";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { cityID };

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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (cityID == null) {
                    query.append("cityID LIKE null");
                } else {
                    query.append("cityID LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("districtName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityID != null) {
                    qPos.add(cityID);
                }

                List<District> list = q.list();

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
            return (List<District>) result;
        }
    }

    public List<District> findByCityID(String cityID, int start, int end)
        throws SystemException {
        return findByCityID(cityID, start, end, null);
    }

    public List<District> findByCityID(String cityID, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "findByCityID";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                cityID,
                
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (cityID == null) {
                    query.append("cityID LIKE null");
                } else {
                    query.append("cityID LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("districtName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityID != null) {
                    qPos.add(cityID);
                }

                List<District> list = (List<District>) QueryUtil.list(q,
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
            return (List<District>) result;
        }
    }

    public District findByCityID_First(String cityID, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        List<District> list = findByCityID(cityID, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("cityID=" + cityID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District findByCityID_Last(String cityID, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        int count = countByCityID(cityID);

        List<District> list = findByCityID(cityID, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("cityID=" + cityID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District[] findByCityID_PrevAndNext(String districtId,
        String cityID, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        int count = countByCityID(cityID);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

            if (cityID == null) {
                query.append("cityID LIKE null");
            } else {
                query.append("cityID LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("districtName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (cityID != null) {
                qPos.add(cityID);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, district);

            District[] array = new DistrictImpl[3];

            array[0] = (District) objArray[0];
            array[1] = (District) objArray[1];
            array[2] = (District) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<District> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("districtName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<District> list = q.list();

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
            return (List<District>) result;
        }
    }

    public List<District> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<District> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

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

                    query.append("districtName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<District> list = (List<District>) QueryUtil.list(q,
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
            return (List<District>) result;
        }
    }

    public District findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchDistrictException, SystemException {
        List<District> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchDistrictException, SystemException {
        int count = countByDescription(description);

        List<District> list = findByDescription(description, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No District exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDistrictException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public District[] findByDescription_PrevAndNext(String districtId,
        String description, OrderByComparator obc)
        throws NoSuchDistrictException, SystemException {
        District district = findByPrimaryKey(districtId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

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

                query.append("districtName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, district);

            District[] array = new DistrictImpl[3];

            array[0] = (District) objArray[0];
            array[1] = (District) objArray[1];
            array[2] = (District) objArray[2];

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

    public List<District> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<District> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<District> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
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
                    "FROM com.sgs.portlet.districtmanagement.model.District ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("districtName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<District> list = (List<District>) QueryUtil.list(q,
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
            return (List<District>) result;
        }
    }

    public void removeByDistrictActive(String active) throws SystemException {
        for (District district : findByDistrictActive(active)) {
            remove(district);
        }
    }

    public void removeByC_N_I_D(String districtCode, String districtName,
        String cityID, String description) throws SystemException {
        for (District district : findByC_N_I_D(districtCode, districtName,
                cityID, description)) {
            remove(district);
        }
    }

    public void removeByCode(String districtCode) throws SystemException {
        for (District district : findByCode(districtCode)) {
            remove(district);
        }
    }

    public void removeByName(String districtName) throws SystemException {
        for (District district : findByName(districtName)) {
            remove(district);
        }
    }

    public void removeByCityID(String cityID) throws SystemException {
        for (District district : findByCityID(cityID)) {
            remove(district);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (District district : findByDescription(description)) {
            remove(district);
        }
    }

    public void removeAll() throws SystemException {
        for (District district : findAll()) {
            remove(district);
        }
    }

    public int countByDistrictActive(String active) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "countByDistrictActive";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { active };

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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
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

    public int countByC_N_I_D(String districtCode, String districtName,
        String cityID, String description) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "countByC_N_I_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                districtCode,
                
                districtName,
                
                cityID,
                
                description
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtCode == null) {
                    query.append("districtCode LIKE null");
                } else {
                    query.append("districtCode LIKE ?");
                }

                query.append(" AND ");

                if (districtName == null) {
                    query.append("districtName LIKE null");
                } else {
                    query.append("districtName LIKE ?");
                }

                query.append(" AND ");

                if (cityID == null) {
                    query.append("cityID LIKE null");
                } else {
                    query.append("cityID LIKE ?");
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

                if (districtCode != null) {
                    qPos.add(districtCode);
                }

                if (districtName != null) {
                    qPos.add(districtName);
                }

                if (cityID != null) {
                    qPos.add(cityID);
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

    public int countByCode(String districtCode) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "countByCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { districtCode };

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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtCode == null) {
                    query.append("districtCode LIKE null");
                } else {
                    query.append("lower(districtCode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtCode != null) {
                    qPos.add(districtCode);
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

    public int countByName(String districtName) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "countByName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { districtName };

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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (districtName == null) {
                    query.append("districtName LIKE null");
                } else {
                    query.append("lower(districtName) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtName != null) {
                    qPos.add(districtName);
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

    public int countByCityID(String cityID) throws SystemException {
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
        String finderMethodName = "countByCityID";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { cityID };

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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

                if (cityID == null) {
                    query.append("cityID LIKE null");
                } else {
                    query.append("cityID LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityID != null) {
                    qPos.add(cityID);
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
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
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
                    "FROM com.sgs.portlet.districtmanagement.model.District WHERE ");

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
        boolean finderClassNameCacheEnabled = DistrictModelImpl.CACHE_ENABLED;
        String finderClassName = District.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.districtmanagement.model.District");

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
                        "value.object.listener.com.sgs.portlet.districtmanagement.model.District")));

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
