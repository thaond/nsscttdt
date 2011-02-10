package com.sgs.portlet.citymanagement.service.persistence;

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

import com.sgs.portlet.citymanagement.NoSuchCityException;
import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.model.impl.CityImpl;
import com.sgs.portlet.citymanagement.model.impl.CityModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class CityPersistenceImpl extends BasePersistenceImpl
    implements CityPersistence {
    private static Log _log = LogFactory.getLog(CityPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public City create(String cityID) {
        City city = new CityImpl();

        city.setNew(true);
        city.setPrimaryKey(cityID);

        return city;
    }

    public City remove(String cityID)
        throws NoSuchCityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            City city = (City) session.get(CityImpl.class, cityID);

            if (city == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No City exists with the primary key " + cityID);
                }

                throw new NoSuchCityException(
                    "No City exists with the primary key " + cityID);
            }

            return remove(city);
        } catch (NoSuchCityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public City remove(City city) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(city);
            }
        }

        city = removeImpl(city);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(city);
            }
        }

        return city;
    }

    protected City removeImpl(City city) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(city);

            session.flush();

            return city;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(City.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(City city, boolean merge)</code>.
     */
    public City update(City city) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(City city) method. Use update(City city, boolean merge) instead.");
        }

        return update(city, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                city the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when city is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public City update(City city, boolean merge) throws SystemException {
        boolean isNew = city.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(city);
                } else {
                    listener.onBeforeUpdate(city);
                }
            }
        }

        city = updateImpl(city, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(city);
                } else {
                    listener.onAfterUpdate(city);
                }
            }
        }

        return city;
    }

    public City updateImpl(com.sgs.portlet.citymanagement.model.City city,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(city);
            } else {
                if (city.isNew()) {
                    session.save(city);
                }
            }

            session.flush();

            city.setNew(false);

            return city;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(City.class.getName());
        }
    }

    public City findByPrimaryKey(String cityID)
        throws NoSuchCityException, SystemException {
        City city = fetchByPrimaryKey(cityID);

        if (city == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No City exists with the primary key " + cityID);
            }

            throw new NoSuchCityException(
                "No City exists with the primary key " + cityID);
        }

        return city;
    }

    public City fetchByPrimaryKey(String cityID) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (City) session.get(CityImpl.class, cityID);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<City> findByCityActive(String active) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByCityActive";
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("cityName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

                List<City> list = q.list();

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
            return (List<City>) result;
        }
    }

    public List<City> findByCityActive(String active, int start, int end)
        throws SystemException {
        return findByCityActive(active, start, end, null);
    }

    public List<City> findByCityActive(String active, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByCityActive";
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

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

                    query.append("cityName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

                List<City> list = (List<City>) QueryUtil.list(q, getDialect(),
                        start, end);

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
            return (List<City>) result;
        }
    }

    public City findByCityActive_First(String active, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        List<City> list = findByCityActive(active, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City findByCityActive_Last(String active, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        int count = countByCityActive(active);

        List<City> list = findByCityActive(active, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City[] findByCityActive_PrevAndNext(String cityID, String active,
        OrderByComparator obc) throws NoSuchCityException, SystemException {
        City city = findByPrimaryKey(cityID);

        int count = countByCityActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

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

                query.append("cityName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (active != null) {
                qPos.add(active);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, city);

            City[] array = new CityImpl[3];

            array[0] = (City) objArray[0];
            array[1] = (City) objArray[1];
            array[2] = (City) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<City> findByC_N_D(String cityCode, String cityName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { cityCode, cityName, description };

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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityCode == null) {
                    query.append("cityCode LIKE null");
                } else {
                    query.append("cityCode LIKE ?");
                }

                query.append(" AND ");

                if (cityName == null) {
                    query.append("cityName LIKE null");
                } else {
                    query.append("cityName LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("cityName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityCode != null) {
                    qPos.add(cityCode);
                }

                if (cityName != null) {
                    qPos.add(cityName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<City> list = q.list();

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
            return (List<City>) result;
        }
    }

    public List<City> findByC_N_D(String cityCode, String cityName,
        String description, int start, int end) throws SystemException {
        return findByC_N_D(cityCode, cityName, description, start, end, null);
    }

    public List<City> findByC_N_D(String cityCode, String cityName,
        String description, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                cityCode,
                
                cityName,
                
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityCode == null) {
                    query.append("cityCode LIKE null");
                } else {
                    query.append("cityCode LIKE ?");
                }

                query.append(" AND ");

                if (cityName == null) {
                    query.append("cityName LIKE null");
                } else {
                    query.append("cityName LIKE ?");
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

                    query.append("cityName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityCode != null) {
                    qPos.add(cityCode);
                }

                if (cityName != null) {
                    qPos.add(cityName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<City> list = (List<City>) QueryUtil.list(q, getDialect(),
                        start, end);

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
            return (List<City>) result;
        }
    }

    public City findByC_N_D_First(String cityCode, String cityName,
        String description, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        List<City> list = findByC_N_D(cityCode, cityName, description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("cityCode=" + cityCode);

            msg.append(", ");
            msg.append("cityName=" + cityName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City findByC_N_D_Last(String cityCode, String cityName,
        String description, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        int count = countByC_N_D(cityCode, cityName, description);

        List<City> list = findByC_N_D(cityCode, cityName, description,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("cityCode=" + cityCode);

            msg.append(", ");
            msg.append("cityName=" + cityName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City[] findByC_N_D_PrevAndNext(String cityID, String cityCode,
        String cityName, String description, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        City city = findByPrimaryKey(cityID);

        int count = countByC_N_D(cityCode, cityName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

            if (cityCode == null) {
                query.append("cityCode LIKE null");
            } else {
                query.append("cityCode LIKE ?");
            }

            query.append(" AND ");

            if (cityName == null) {
                query.append("cityName LIKE null");
            } else {
                query.append("cityName LIKE ?");
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

                query.append("cityName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (cityCode != null) {
                qPos.add(cityCode);
            }

            if (cityName != null) {
                qPos.add(cityName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, city);

            City[] array = new CityImpl[3];

            array[0] = (City) objArray[0];
            array[1] = (City) objArray[1];
            array[2] = (City) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<City> findByCode(String cityCode) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { cityCode };

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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityCode == null) {
                    query.append("cityCode LIKE null");
                } else {
                    query.append("lower(cityCode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("cityName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityCode != null) {
                    qPos.add(cityCode);
                }

                List<City> list = q.list();

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
            return (List<City>) result;
        }
    }

    public List<City> findByCode(String cityCode, int start, int end)
        throws SystemException {
        return findByCode(cityCode, start, end, null);
    }

    public List<City> findByCode(String cityCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                cityCode,
                
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityCode == null) {
                    query.append("cityCode LIKE null");
                } else {
                    query.append("lower(cityCode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("cityName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityCode != null) {
                    qPos.add(cityCode);
                }

                List<City> list = (List<City>) QueryUtil.list(q, getDialect(),
                        start, end);

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
            return (List<City>) result;
        }
    }

    public City findByCode_First(String cityCode, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        List<City> list = findByCode(cityCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("cityCode=" + cityCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City findByCode_Last(String cityCode, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        int count = countByCode(cityCode);

        List<City> list = findByCode(cityCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("cityCode=" + cityCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City[] findByCode_PrevAndNext(String cityID, String cityCode,
        OrderByComparator obc) throws NoSuchCityException, SystemException {
        City city = findByPrimaryKey(cityID);

        int count = countByCode(cityCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

            if (cityCode == null) {
                query.append("cityCode LIKE null");
            } else {
                query.append("lower(cityCode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("cityName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (cityCode != null) {
                qPos.add(cityCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, city);

            City[] array = new CityImpl[3];

            array[0] = (City) objArray[0];
            array[1] = (City) objArray[1];
            array[2] = (City) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<City> findByName(String cityName) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { cityName };

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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityName == null) {
                    query.append("cityName LIKE null");
                } else {
                    query.append("cityName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("cityName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityName != null) {
                    qPos.add(cityName);
                }

                List<City> list = q.list();

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
            return (List<City>) result;
        }
    }

    public List<City> findByName(String cityName, int start, int end)
        throws SystemException {
        return findByName(cityName, start, end, null);
    }

    public List<City> findByName(String cityName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                cityName,
                
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityName == null) {
                    query.append("cityName LIKE null");
                } else {
                    query.append("cityName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("cityName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityName != null) {
                    qPos.add(cityName);
                }

                List<City> list = (List<City>) QueryUtil.list(q, getDialect(),
                        start, end);

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
            return (List<City>) result;
        }
    }

    public City findByName_First(String cityName, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        List<City> list = findByName(cityName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("cityName=" + cityName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City findByName_Last(String cityName, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        int count = countByName(cityName);

        List<City> list = findByName(cityName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("cityName=" + cityName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City[] findByName_PrevAndNext(String cityID, String cityName,
        OrderByComparator obc) throws NoSuchCityException, SystemException {
        City city = findByPrimaryKey(cityID);

        int count = countByName(cityName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

            if (cityName == null) {
                query.append("cityName LIKE null");
            } else {
                query.append("cityName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("cityName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (cityName != null) {
                qPos.add(cityName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, city);

            City[] array = new CityImpl[3];

            array[0] = (City) objArray[0];
            array[1] = (City) objArray[1];
            array[2] = (City) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<City> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("cityName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<City> list = q.list();

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
            return (List<City>) result;
        }
    }

    public List<City> findByDescription(String description, int start, int end)
        throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<City> findByDescription(String description, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

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

                    query.append("cityName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<City> list = (List<City>) QueryUtil.list(q, getDialect(),
                        start, end);

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
            return (List<City>) result;
        }
    }

    public City findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchCityException, SystemException {
        List<City> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City findByDescription_Last(String description, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        int count = countByDescription(description);

        List<City> list = findByDescription(description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City[] findByDescription_PrevAndNext(String cityID,
        String description, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        City city = findByPrimaryKey(cityID);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

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

                query.append("cityName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, city);

            City[] array = new CityImpl[3];

            array[0] = (City) objArray[0];
            array[1] = (City) objArray[1];
            array[2] = (City) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<City> findByCountryId(String countryId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByCountryId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { countryId };

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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (countryId == null) {
                    query.append("countryid LIKE null");
                } else {
                    query.append("countryid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("cityName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryId != null) {
                    qPos.add(countryId);
                }

                List<City> list = q.list();

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
            return (List<City>) result;
        }
    }

    public List<City> findByCountryId(String countryId, int start, int end)
        throws SystemException {
        return findByCountryId(countryId, start, end, null);
    }

    public List<City> findByCountryId(String countryId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "findByCountryId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                countryId,
                
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (countryId == null) {
                    query.append("countryid LIKE null");
                } else {
                    query.append("countryid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("cityName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryId != null) {
                    qPos.add(countryId);
                }

                List<City> list = (List<City>) QueryUtil.list(q, getDialect(),
                        start, end);

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
            return (List<City>) result;
        }
    }

    public City findByCountryId_First(String countryId, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        List<City> list = findByCountryId(countryId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("countryId=" + countryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City findByCountryId_Last(String countryId, OrderByComparator obc)
        throws NoSuchCityException, SystemException {
        int count = countByCountryId(countryId);

        List<City> list = findByCountryId(countryId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No City exists with the key {");

            msg.append("countryId=" + countryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCityException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public City[] findByCountryId_PrevAndNext(String cityID, String countryId,
        OrderByComparator obc) throws NoSuchCityException, SystemException {
        City city = findByPrimaryKey(cityID);

        int count = countByCountryId(countryId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

            if (countryId == null) {
                query.append("countryid LIKE null");
            } else {
                query.append("countryid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("cityName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (countryId != null) {
                qPos.add(countryId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, city);

            City[] array = new CityImpl[3];

            array[0] = (City) objArray[0];
            array[1] = (City) objArray[1];
            array[2] = (City) objArray[2];

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

    public List<City> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<City> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<City> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
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

                query.append("FROM com.sgs.portlet.citymanagement.model.City ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("cityName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<City> list = (List<City>) QueryUtil.list(q, getDialect(),
                        start, end);

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
            return (List<City>) result;
        }
    }

    public void removeByCityActive(String active) throws SystemException {
        for (City city : findByCityActive(active)) {
            remove(city);
        }
    }

    public void removeByC_N_D(String cityCode, String cityName,
        String description) throws SystemException {
        for (City city : findByC_N_D(cityCode, cityName, description)) {
            remove(city);
        }
    }

    public void removeByCode(String cityCode) throws SystemException {
        for (City city : findByCode(cityCode)) {
            remove(city);
        }
    }

    public void removeByName(String cityName) throws SystemException {
        for (City city : findByName(cityName)) {
            remove(city);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (City city : findByDescription(description)) {
            remove(city);
        }
    }

    public void removeByCountryId(String countryId) throws SystemException {
        for (City city : findByCountryId(countryId)) {
            remove(city);
        }
    }

    public void removeAll() throws SystemException {
        for (City city : findAll()) {
            remove(city);
        }
    }

    public int countByCityActive(String active) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "countByCityActive";
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

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

    public int countByC_N_D(String cityCode, String cityName, String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "countByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { cityCode, cityName, description };

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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityCode == null) {
                    query.append("cityCode LIKE null");
                } else {
                    query.append("cityCode LIKE ?");
                }

                query.append(" AND ");

                if (cityName == null) {
                    query.append("cityName LIKE null");
                } else {
                    query.append("cityName LIKE ?");
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

                if (cityCode != null) {
                    qPos.add(cityCode);
                }

                if (cityName != null) {
                    qPos.add(cityName);
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

    public int countByCode(String cityCode) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "countByCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { cityCode };

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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityCode == null) {
                    query.append("cityCode LIKE null");
                } else {
                    query.append("lower(cityCode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityCode != null) {
                    qPos.add(cityCode);
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

    public int countByName(String cityName) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "countByName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { cityName };

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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (cityName == null) {
                    query.append("cityName LIKE null");
                } else {
                    query.append("cityName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cityName != null) {
                    qPos.add(cityName);
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
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

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

    public int countByCountryId(String countryId) throws SystemException {
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
        String finderMethodName = "countByCountryId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { countryId };

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
                    "FROM com.sgs.portlet.citymanagement.model.City WHERE ");

                if (countryId == null) {
                    query.append("countryid LIKE null");
                } else {
                    query.append("countryid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryId != null) {
                    qPos.add(countryId);
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
        boolean finderClassNameCacheEnabled = CityModelImpl.CACHE_ENABLED;
        String finderClassName = City.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.citymanagement.model.City");

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
                        "value.object.listener.com.sgs.portlet.citymanagement.model.City")));

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
