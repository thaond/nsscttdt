package com.sgs.portlet.country.service.persistence;

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

import com.sgs.portlet.country.NoSuchException;
import com.sgs.portlet.country.model.Country;
import com.sgs.portlet.country.model.impl.CountryImpl;
import com.sgs.portlet.country.model.impl.CountryModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class CountryPersistenceImpl extends BasePersistenceImpl
    implements CountryPersistence {
    private static Log _log = LogFactory.getLog(CountryPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public Country create(String countryId) {
        Country country = new CountryImpl();

        country.setNew(true);
        country.setPrimaryKey(countryId);

        return country;
    }

    public Country remove(String countryId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Country country = (Country) session.get(CountryImpl.class, countryId);

            if (country == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Country exists with the primary key " +
                        countryId);
                }

                throw new NoSuchException(
                    "No Country exists with the primary key " + countryId);
            }

            return remove(country);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Country remove(Country country) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(country);
            }
        }

        country = removeImpl(country);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(country);
            }
        }

        return country;
    }

    protected Country removeImpl(Country country) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(country);

            session.flush();

            return country;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Country.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Country country, boolean merge)</code>.
     */
    public Country update(Country country) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Country country) method. Use update(Country country, boolean merge) instead.");
        }

        return update(country, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                country the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when country is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Country update(Country country, boolean merge)
        throws SystemException {
        boolean isNew = country.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(country);
                } else {
                    listener.onBeforeUpdate(country);
                }
            }
        }

        country = updateImpl(country, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(country);
                } else {
                    listener.onAfterUpdate(country);
                }
            }
        }

        return country;
    }

    public Country updateImpl(com.sgs.portlet.country.model.Country country,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(country);
            } else {
                if (country.isNew()) {
                    session.save(country);
                }
            }

            session.flush();

            country.setNew(false);

            return country;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Country.class.getName());
        }
    }

    public Country findByPrimaryKey(String countryId)
        throws NoSuchException, SystemException {
        Country country = fetchByPrimaryKey(countryId);

        if (country == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Country exists with the primary key " +
                    countryId);
            }

            throw new NoSuchException("No Country exists with the primary key " +
                countryId);
        }

        return country;
    }

    public Country fetchByPrimaryKey(String countryId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Country) session.get(CountryImpl.class, countryId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Country> findByCountryCode(String countryCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "findByCountryCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { countryCode };

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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryCode == null) {
                    query.append("countryCode LIKE null");
                } else {
                    query.append("countryCode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("countryName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryCode != null) {
                    qPos.add(countryCode);
                }

                List<Country> list = q.list();

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
            return (List<Country>) result;
        }
    }

    public List<Country> findByCountryCode(String countryCode, int start,
        int end) throws SystemException {
        return findByCountryCode(countryCode, start, end, null);
    }

    public List<Country> findByCountryCode(String countryCode, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "findByCountryCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                countryCode,
                
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryCode == null) {
                    query.append("countryCode LIKE null");
                } else {
                    query.append("countryCode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("countryName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryCode != null) {
                    qPos.add(countryCode);
                }

                List<Country> list = (List<Country>) QueryUtil.list(q,
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
            return (List<Country>) result;
        }
    }

    public Country findByCountryCode_First(String countryCode,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<Country> list = findByCountryCode(countryCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("countryCode=" + countryCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country findByCountryCode_Last(String countryCode,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByCountryCode(countryCode);

        List<Country> list = findByCountryCode(countryCode, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("countryCode=" + countryCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country[] findByCountryCode_PrevAndNext(String countryId,
        String countryCode, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Country country = findByPrimaryKey(countryId);

        int count = countByCountryCode(countryCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.country.model.Country WHERE ");

            if (countryCode == null) {
                query.append("countryCode LIKE null");
            } else {
                query.append("countryCode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("countryName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (countryCode != null) {
                qPos.add(countryCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, country);

            Country[] array = new CountryImpl[3];

            array[0] = (Country) objArray[0];
            array[1] = (Country) objArray[1];
            array[2] = (Country) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Country> findByCountryName(String countryName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "findByCountryName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { countryName };

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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryName == null) {
                    query.append("countryName LIKE null");
                } else {
                    query.append("countryName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("countryName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryName != null) {
                    qPos.add(countryName);
                }

                List<Country> list = q.list();

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
            return (List<Country>) result;
        }
    }

    public List<Country> findByCountryName(String countryName, int start,
        int end) throws SystemException {
        return findByCountryName(countryName, start, end, null);
    }

    public List<Country> findByCountryName(String countryName, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "findByCountryName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                countryName,
                
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryName == null) {
                    query.append("countryName LIKE null");
                } else {
                    query.append("countryName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("countryName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryName != null) {
                    qPos.add(countryName);
                }

                List<Country> list = (List<Country>) QueryUtil.list(q,
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
            return (List<Country>) result;
        }
    }

    public Country findByCountryName_First(String countryName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<Country> list = findByCountryName(countryName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("countryName=" + countryName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country findByCountryName_Last(String countryName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByCountryName(countryName);

        List<Country> list = findByCountryName(countryName, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("countryName=" + countryName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country[] findByCountryName_PrevAndNext(String countryId,
        String countryName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Country country = findByPrimaryKey(countryId);

        int count = countByCountryName(countryName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.country.model.Country WHERE ");

            if (countryName == null) {
                query.append("countryName LIKE null");
            } else {
                query.append("countryName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("countryName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (countryName != null) {
                qPos.add(countryName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, country);

            Country[] array = new CountryImpl[3];

            array[0] = (Country) objArray[0];
            array[1] = (Country) objArray[1];
            array[2] = (Country) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Country> findByActive(String active) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "findByActive";
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (active == null) {
                    query.append("active LIKE null");
                } else {
                    query.append("active LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("countryName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

                List<Country> list = q.list();

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
            return (List<Country>) result;
        }
    }

    public List<Country> findByActive(String active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<Country> findByActive(String active, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "findByActive";
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (active == null) {
                    query.append("active LIKE null");
                } else {
                    query.append("active LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("countryName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

                List<Country> list = (List<Country>) QueryUtil.list(q,
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
            return (List<Country>) result;
        }
    }

    public Country findByActive_First(String active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<Country> list = findByActive(active, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country findByActive_Last(String active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByActive(active);

        List<Country> list = findByActive(active, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country[] findByActive_PrevAndNext(String countryId, String active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        Country country = findByPrimaryKey(countryId);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.country.model.Country WHERE ");

            if (active == null) {
                query.append("active LIKE null");
            } else {
                query.append("active LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("countryName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (active != null) {
                qPos.add(active);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, country);

            Country[] array = new CountryImpl[3];

            array[0] = (Country) objArray[0];
            array[1] = (Country) objArray[1];
            array[2] = (Country) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Country> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("countryName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Country> list = q.list();

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
            return (List<Country>) result;
        }
    }

    public List<Country> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Country> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

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

                    query.append("countryName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Country> list = (List<Country>) QueryUtil.list(q,
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
            return (List<Country>) result;
        }
    }

    public Country findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<Country> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByDescription(description);

        List<Country> list = findByDescription(description, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country[] findByDescription_PrevAndNext(String countryId,
        String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Country country = findByPrimaryKey(countryId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.country.model.Country WHERE ");

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

                query.append("countryName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, country);

            Country[] array = new CountryImpl[3];

            array[0] = (Country) objArray[0];
            array[1] = (Country) objArray[1];
            array[2] = (Country) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Country> findByC_N_D(String countryCode, String countryName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { countryCode, countryName, description };

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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryCode == null) {
                    query.append("countryCode LIKE null");
                } else {
                    query.append("countryCode LIKE ?");
                }

                query.append(" AND ");

                if (countryName == null) {
                    query.append("countryName LIKE null");
                } else {
                    query.append("countryName LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("countryName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryCode != null) {
                    qPos.add(countryCode);
                }

                if (countryName != null) {
                    qPos.add(countryName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Country> list = q.list();

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
            return (List<Country>) result;
        }
    }

    public List<Country> findByC_N_D(String countryCode, String countryName,
        String description, int start, int end) throws SystemException {
        return findByC_N_D(countryCode, countryName, description, start, end,
            null);
    }

    public List<Country> findByC_N_D(String countryCode, String countryName,
        String description, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                countryCode,
                
                countryName,
                
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryCode == null) {
                    query.append("countryCode LIKE null");
                } else {
                    query.append("countryCode LIKE ?");
                }

                query.append(" AND ");

                if (countryName == null) {
                    query.append("countryName LIKE null");
                } else {
                    query.append("countryName LIKE ?");
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

                    query.append("countryName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryCode != null) {
                    qPos.add(countryCode);
                }

                if (countryName != null) {
                    qPos.add(countryName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Country> list = (List<Country>) QueryUtil.list(q,
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
            return (List<Country>) result;
        }
    }

    public Country findByC_N_D_First(String countryCode, String countryName,
        String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<Country> list = findByC_N_D(countryCode, countryName, description,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("countryCode=" + countryCode);

            msg.append(", ");
            msg.append("countryName=" + countryName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country findByC_N_D_Last(String countryCode, String countryName,
        String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByC_N_D(countryCode, countryName, description);

        List<Country> list = findByC_N_D(countryCode, countryName, description,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Country exists with the key {");

            msg.append("countryCode=" + countryCode);

            msg.append(", ");
            msg.append("countryName=" + countryName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Country[] findByC_N_D_PrevAndNext(String countryId,
        String countryCode, String countryName, String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        Country country = findByPrimaryKey(countryId);

        int count = countByC_N_D(countryCode, countryName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.country.model.Country WHERE ");

            if (countryCode == null) {
                query.append("countryCode LIKE null");
            } else {
                query.append("countryCode LIKE ?");
            }

            query.append(" AND ");

            if (countryName == null) {
                query.append("countryName LIKE null");
            } else {
                query.append("countryName LIKE ?");
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

                query.append("countryName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (countryCode != null) {
                qPos.add(countryCode);
            }

            if (countryName != null) {
                qPos.add(countryName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, country);

            Country[] array = new CountryImpl[3];

            array[0] = (Country) objArray[0];
            array[1] = (Country) objArray[1];
            array[2] = (Country) objArray[2];

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

    public List<Country> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Country> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Country> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
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

                query.append("FROM com.sgs.portlet.country.model.Country ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("countryName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<Country> list = (List<Country>) QueryUtil.list(q,
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
            return (List<Country>) result;
        }
    }

    public void removeByCountryCode(String countryCode)
        throws SystemException {
        for (Country country : findByCountryCode(countryCode)) {
            remove(country);
        }
    }

    public void removeByCountryName(String countryName)
        throws SystemException {
        for (Country country : findByCountryName(countryName)) {
            remove(country);
        }
    }

    public void removeByActive(String active) throws SystemException {
        for (Country country : findByActive(active)) {
            remove(country);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (Country country : findByDescription(description)) {
            remove(country);
        }
    }

    public void removeByC_N_D(String countryCode, String countryName,
        String description) throws SystemException {
        for (Country country : findByC_N_D(countryCode, countryName, description)) {
            remove(country);
        }
    }

    public void removeAll() throws SystemException {
        for (Country country : findAll()) {
            remove(country);
        }
    }

    public int countByCountryCode(String countryCode) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "countByCountryCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { countryCode };

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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryCode == null) {
                    query.append("countryCode LIKE null");
                } else {
                    query.append("countryCode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryCode != null) {
                    qPos.add(countryCode);
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

    public int countByCountryName(String countryName) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "countByCountryName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { countryName };

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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryName == null) {
                    query.append("countryName LIKE null");
                } else {
                    query.append("countryName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryName != null) {
                    qPos.add(countryName);
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

    public int countByActive(String active) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "countByActive";
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (active == null) {
                    query.append("active LIKE null");
                } else {
                    query.append("active LIKE ?");
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

    public int countByDescription(String description) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

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

    public int countByC_N_D(String countryCode, String countryName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
        String finderMethodName = "countByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { countryCode, countryName, description };

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
                    "FROM com.sgs.portlet.country.model.Country WHERE ");

                if (countryCode == null) {
                    query.append("countryCode LIKE null");
                } else {
                    query.append("countryCode LIKE ?");
                }

                query.append(" AND ");

                if (countryName == null) {
                    query.append("countryName LIKE null");
                } else {
                    query.append("countryName LIKE ?");
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

                if (countryCode != null) {
                    qPos.add(countryCode);
                }

                if (countryName != null) {
                    qPos.add(countryName);
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
        boolean finderClassNameCacheEnabled = CountryModelImpl.CACHE_ENABLED;
        String finderClassName = Country.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.country.model.Country");

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
                        "value.object.listener.com.sgs.portlet.country.model.Country")));

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
