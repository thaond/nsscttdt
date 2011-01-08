package com.sgs.portlet.career.service.persistence;

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

import com.sgs.portlet.career.NoSuchCareerException;
import com.sgs.portlet.career.model.Career;
import com.sgs.portlet.career.model.impl.CareerImpl;
import com.sgs.portlet.career.model.impl.CareerModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class CareerPersistenceImpl extends BasePersistenceImpl
    implements CareerPersistence {
    private static Log _log = LogFactory.getLog(CareerPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public Career create(String careerId) {
        Career career = new CareerImpl();

        career.setNew(true);
        career.setPrimaryKey(careerId);

        return career;
    }

    public Career remove(String careerId)
        throws NoSuchCareerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Career career = (Career) session.get(CareerImpl.class, careerId);

            if (career == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Career exists with the primary key " +
                        careerId);
                }

                throw new NoSuchCareerException(
                    "No Career exists with the primary key " + careerId);
            }

            return remove(career);
        } catch (NoSuchCareerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Career remove(Career career) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(career);
            }
        }

        career = removeImpl(career);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(career);
            }
        }

        return career;
    }

    protected Career removeImpl(Career career) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(career);

            session.flush();

            return career;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Career.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Career career, boolean merge)</code>.
     */
    public Career update(Career career) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Career career) method. Use update(Career career, boolean merge) instead.");
        }

        return update(career, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                career the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when career is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Career update(Career career, boolean merge)
        throws SystemException {
        boolean isNew = career.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(career);
                } else {
                    listener.onBeforeUpdate(career);
                }
            }
        }

        career = updateImpl(career, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(career);
                } else {
                    listener.onAfterUpdate(career);
                }
            }
        }

        return career;
    }

    public Career updateImpl(com.sgs.portlet.career.model.Career career,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(career);
            } else {
                if (career.isNew()) {
                    session.save(career);
                }
            }

            session.flush();

            career.setNew(false);

            return career;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Career.class.getName());
        }
    }

    public Career findByPrimaryKey(String careerId)
        throws NoSuchCareerException, SystemException {
        Career career = fetchByPrimaryKey(careerId);

        if (career == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Career exists with the primary key " + careerId);
            }

            throw new NoSuchCareerException(
                "No Career exists with the primary key " + careerId);
        }

        return career;
    }

    public Career fetchByPrimaryKey(String careerId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Career) session.get(CareerImpl.class, careerId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Career> findByCareerCode(String careerCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "findByCareerCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { careerCode };

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

                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerCode == null) {
                    query.append("careercode LIKE null");
                } else {
                    query.append("lower(careercode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("careername ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (careerCode != null) {
                    qPos.add(careerCode);
                }

                List<Career> list = q.list();

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
            return (List<Career>) result;
        }
    }

    public List<Career> findByCareerCode(String careerCode, int start, int end)
        throws SystemException {
        return findByCareerCode(careerCode, start, end, null);
    }

    public List<Career> findByCareerCode(String careerCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "findByCareerCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                careerCode,
                
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

                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerCode == null) {
                    query.append("careercode LIKE null");
                } else {
                    query.append("lower(careercode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("careername ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (careerCode != null) {
                    qPos.add(careerCode);
                }

                List<Career> list = (List<Career>) QueryUtil.list(q,
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
            return (List<Career>) result;
        }
    }

    public Career findByCareerCode_First(String careerCode,
        OrderByComparator obc) throws NoSuchCareerException, SystemException {
        List<Career> list = findByCareerCode(careerCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Career exists with the key {");

            msg.append("careerCode=" + careerCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCareerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Career findByCareerCode_Last(String careerCode, OrderByComparator obc)
        throws NoSuchCareerException, SystemException {
        int count = countByCareerCode(careerCode);

        List<Career> list = findByCareerCode(careerCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Career exists with the key {");

            msg.append("careerCode=" + careerCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCareerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Career[] findByCareerCode_PrevAndNext(String careerId,
        String careerCode, OrderByComparator obc)
        throws NoSuchCareerException, SystemException {
        Career career = findByPrimaryKey(careerId);

        int count = countByCareerCode(careerCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

            if (careerCode == null) {
                query.append("careercode LIKE null");
            } else {
                query.append("lower(careercode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("careername ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (careerCode != null) {
                qPos.add(careerCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, career);

            Career[] array = new CareerImpl[3];

            array[0] = (Career) objArray[0];
            array[1] = (Career) objArray[1];
            array[2] = (Career) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Career> findByCareerName(String careerName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "findByCareerName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { careerName };

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

                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerName == null) {
                    query.append("careername LIKE null");
                } else {
                    query.append("careername LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("careername ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (careerName != null) {
                    qPos.add(careerName);
                }

                List<Career> list = q.list();

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
            return (List<Career>) result;
        }
    }

    public List<Career> findByCareerName(String careerName, int start, int end)
        throws SystemException {
        return findByCareerName(careerName, start, end, null);
    }

    public List<Career> findByCareerName(String careerName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "findByCareerName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                careerName,
                
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

                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerName == null) {
                    query.append("careername LIKE null");
                } else {
                    query.append("careername LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("careername ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (careerName != null) {
                    qPos.add(careerName);
                }

                List<Career> list = (List<Career>) QueryUtil.list(q,
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
            return (List<Career>) result;
        }
    }

    public Career findByCareerName_First(String careerName,
        OrderByComparator obc) throws NoSuchCareerException, SystemException {
        List<Career> list = findByCareerName(careerName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Career exists with the key {");

            msg.append("careerName=" + careerName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCareerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Career findByCareerName_Last(String careerName, OrderByComparator obc)
        throws NoSuchCareerException, SystemException {
        int count = countByCareerName(careerName);

        List<Career> list = findByCareerName(careerName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Career exists with the key {");

            msg.append("careerName=" + careerName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCareerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Career[] findByCareerName_PrevAndNext(String careerId,
        String careerName, OrderByComparator obc)
        throws NoSuchCareerException, SystemException {
        Career career = findByPrimaryKey(careerId);

        int count = countByCareerName(careerName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

            if (careerName == null) {
                query.append("careername LIKE null");
            } else {
                query.append("careername LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("careername ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (careerName != null) {
                qPos.add(careerName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, career);

            Career[] array = new CareerImpl[3];

            array[0] = (Career) objArray[0];
            array[1] = (Career) objArray[1];
            array[2] = (Career) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Career> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
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

                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("careername ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Career> list = q.list();

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
            return (List<Career>) result;
        }
    }

    public List<Career> findByDescription(String description, int start, int end)
        throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Career> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
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

                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

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

                    query.append("careername ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Career> list = (List<Career>) QueryUtil.list(q,
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
            return (List<Career>) result;
        }
    }

    public Career findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchCareerException, SystemException {
        List<Career> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Career exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCareerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Career findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchCareerException, SystemException {
        int count = countByDescription(description);

        List<Career> list = findByDescription(description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Career exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCareerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Career[] findByDescription_PrevAndNext(String careerId,
        String description, OrderByComparator obc)
        throws NoSuchCareerException, SystemException {
        Career career = findByPrimaryKey(careerId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

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

                query.append("careername ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, career);

            Career[] array = new CareerImpl[3];

            array[0] = (Career) objArray[0];
            array[1] = (Career) objArray[1];
            array[2] = (Career) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Career> findByC_N_D(String careerCode, String careerName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { careerCode, careerName, description };

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

                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerCode == null) {
                    query.append("careercode LIKE null");
                } else {
                    query.append("careercode LIKE ?");
                }

                query.append(" AND ");

                if (careerName == null) {
                    query.append("careername LIKE null");
                } else {
                    query.append("careername LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("careername ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (careerCode != null) {
                    qPos.add(careerCode);
                }

                if (careerName != null) {
                    qPos.add(careerName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Career> list = q.list();

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
            return (List<Career>) result;
        }
    }

    public List<Career> findByC_N_D(String careerCode, String careerName,
        String description, int start, int end) throws SystemException {
        return findByC_N_D(careerCode, careerName, description, start, end, null);
    }

    public List<Career> findByC_N_D(String careerCode, String careerName,
        String description, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                careerCode,
                
                careerName,
                
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

                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerCode == null) {
                    query.append("careercode LIKE null");
                } else {
                    query.append("careercode LIKE ?");
                }

                query.append(" AND ");

                if (careerName == null) {
                    query.append("careername LIKE null");
                } else {
                    query.append("careername LIKE ?");
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

                    query.append("careername ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (careerCode != null) {
                    qPos.add(careerCode);
                }

                if (careerName != null) {
                    qPos.add(careerName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Career> list = (List<Career>) QueryUtil.list(q,
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
            return (List<Career>) result;
        }
    }

    public Career findByC_N_D_First(String careerCode, String careerName,
        String description, OrderByComparator obc)
        throws NoSuchCareerException, SystemException {
        List<Career> list = findByC_N_D(careerCode, careerName, description, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Career exists with the key {");

            msg.append("careerCode=" + careerCode);

            msg.append(", ");
            msg.append("careerName=" + careerName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCareerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Career findByC_N_D_Last(String careerCode, String careerName,
        String description, OrderByComparator obc)
        throws NoSuchCareerException, SystemException {
        int count = countByC_N_D(careerCode, careerName, description);

        List<Career> list = findByC_N_D(careerCode, careerName, description,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Career exists with the key {");

            msg.append("careerCode=" + careerCode);

            msg.append(", ");
            msg.append("careerName=" + careerName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCareerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Career[] findByC_N_D_PrevAndNext(String careerId, String careerCode,
        String careerName, String description, OrderByComparator obc)
        throws NoSuchCareerException, SystemException {
        Career career = findByPrimaryKey(careerId);

        int count = countByC_N_D(careerCode, careerName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

            if (careerCode == null) {
                query.append("careercode LIKE null");
            } else {
                query.append("careercode LIKE ?");
            }

            query.append(" AND ");

            if (careerName == null) {
                query.append("careername LIKE null");
            } else {
                query.append("careername LIKE ?");
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

                query.append("careername ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (careerCode != null) {
                qPos.add(careerCode);
            }

            if (careerName != null) {
                qPos.add(careerName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, career);

            Career[] array = new CareerImpl[3];

            array[0] = (Career) objArray[0];
            array[1] = (Career) objArray[1];
            array[2] = (Career) objArray[2];

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

    public List<Career> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Career> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Career> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
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

                query.append("FROM com.sgs.portlet.career.model.Career ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("careername ASC");
                }

                Query q = session.createQuery(query.toString());

                List<Career> list = (List<Career>) QueryUtil.list(q,
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
            return (List<Career>) result;
        }
    }

    public void removeByCareerCode(String careerCode) throws SystemException {
        for (Career career : findByCareerCode(careerCode)) {
            remove(career);
        }
    }

    public void removeByCareerName(String careerName) throws SystemException {
        for (Career career : findByCareerName(careerName)) {
            remove(career);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (Career career : findByDescription(description)) {
            remove(career);
        }
    }

    public void removeByC_N_D(String careerCode, String careerName,
        String description) throws SystemException {
        for (Career career : findByC_N_D(careerCode, careerName, description)) {
            remove(career);
        }
    }

    public void removeAll() throws SystemException {
        for (Career career : findAll()) {
            remove(career);
        }
    }

    public int countByCareerCode(String careerCode) throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "countByCareerCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { careerCode };

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
                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerCode == null) {
                    query.append("careercode LIKE null");
                } else {
                    query.append("lower(careercode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (careerCode != null) {
                    qPos.add(careerCode);
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

    public int countByCareerName(String careerName) throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "countByCareerName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { careerName };

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
                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerName == null) {
                    query.append("careername LIKE null");
                } else {
                    query.append("careername LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (careerName != null) {
                    qPos.add(careerName);
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
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
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
                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

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

    public int countByC_N_D(String careerCode, String careerName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
        String finderMethodName = "countByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { careerCode, careerName, description };

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
                query.append("FROM com.sgs.portlet.career.model.Career WHERE ");

                if (careerCode == null) {
                    query.append("careercode LIKE null");
                } else {
                    query.append("careercode LIKE ?");
                }

                query.append(" AND ");

                if (careerName == null) {
                    query.append("careername LIKE null");
                } else {
                    query.append("careername LIKE ?");
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

                if (careerCode != null) {
                    qPos.add(careerCode);
                }

                if (careerName != null) {
                    qPos.add(careerName);
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
        boolean finderClassNameCacheEnabled = CareerModelImpl.CACHE_ENABLED;
        String finderClassName = Career.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.career.model.Career");

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
                        "value.object.listener.com.sgs.portlet.career.model.Career")));

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
