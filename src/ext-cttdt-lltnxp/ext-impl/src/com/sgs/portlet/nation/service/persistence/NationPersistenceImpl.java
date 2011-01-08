package com.sgs.portlet.nation.service.persistence;

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

import com.sgs.portlet.nation.NoSuchException;
import com.sgs.portlet.nation.model.Nation;
import com.sgs.portlet.nation.model.impl.NationImpl;
import com.sgs.portlet.nation.model.impl.NationModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class NationPersistenceImpl extends BasePersistenceImpl
    implements NationPersistence {
    private static Log _log = LogFactory.getLog(NationPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public Nation create(String nationId) {
        Nation nation = new NationImpl();

        nation.setNew(true);
        nation.setPrimaryKey(nationId);

        return nation;
    }

    public Nation remove(String nationId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Nation nation = (Nation) session.get(NationImpl.class, nationId);

            if (nation == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Nation exists with the primary key " +
                        nationId);
                }

                throw new NoSuchException(
                    "No Nation exists with the primary key " + nationId);
            }

            return remove(nation);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Nation remove(Nation nation) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(nation);
            }
        }

        nation = removeImpl(nation);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(nation);
            }
        }

        return nation;
    }

    protected Nation removeImpl(Nation nation) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(nation);

            session.flush();

            return nation;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Nation.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Nation nation, boolean merge)</code>.
     */
    public Nation update(Nation nation) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Nation nation) method. Use update(Nation nation, boolean merge) instead.");
        }

        return update(nation, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                nation the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when nation is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Nation update(Nation nation, boolean merge)
        throws SystemException {
        boolean isNew = nation.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(nation);
                } else {
                    listener.onBeforeUpdate(nation);
                }
            }
        }

        nation = updateImpl(nation, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(nation);
                } else {
                    listener.onAfterUpdate(nation);
                }
            }
        }

        return nation;
    }

    public Nation updateImpl(com.sgs.portlet.nation.model.Nation nation,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(nation);
            } else {
                if (nation.isNew()) {
                    session.save(nation);
                }
            }

            session.flush();

            nation.setNew(false);

            return nation;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Nation.class.getName());
        }
    }

    public Nation findByPrimaryKey(String nationId)
        throws NoSuchException, SystemException {
        Nation nation = fetchByPrimaryKey(nationId);

        if (nation == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Nation exists with the primary key " + nationId);
            }

            throw new NoSuchException("No Nation exists with the primary key " +
                nationId);
        }

        return nation;
    }

    public Nation fetchByPrimaryKey(String nationId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Nation) session.get(NationImpl.class, nationId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Nation> findByNationCode(String nationCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "findByNationCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { nationCode };

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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("lower(nationcode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("nationid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationCode != null) {
                    qPos.add(nationCode);
                }

                List<Nation> list = q.list();

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
            return (List<Nation>) result;
        }
    }

    public List<Nation> findByNationCode(String nationCode, int start, int end)
        throws SystemException {
        return findByNationCode(nationCode, start, end, null);
    }

    public List<Nation> findByNationCode(String nationCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "findByNationCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                nationCode,
                
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("lower(nationcode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("nationid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationCode != null) {
                    qPos.add(nationCode);
                }

                List<Nation> list = (List<Nation>) QueryUtil.list(q,
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
            return (List<Nation>) result;
        }
    }

    public Nation findByNationCode_First(String nationCode,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<Nation> list = findByNationCode(nationCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("nationCode=" + nationCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation findByNationCode_Last(String nationCode, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByNationCode(nationCode);

        List<Nation> list = findByNationCode(nationCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("nationCode=" + nationCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation[] findByNationCode_PrevAndNext(String nationId,
        String nationCode, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Nation nation = findByPrimaryKey(nationId);

        int count = countByNationCode(nationCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

            if (nationCode == null) {
                query.append("nationcode LIKE null");
            } else {
                query.append("lower(nationcode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("nationid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (nationCode != null) {
                qPos.add(nationCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, nation);

            Nation[] array = new NationImpl[3];

            array[0] = (Nation) objArray[0];
            array[1] = (Nation) objArray[1];
            array[2] = (Nation) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Nation> findByNationName(String nationName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "findByNationName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { nationName };

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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("lower(nationname) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("nationid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationName != null) {
                    qPos.add(nationName);
                }

                List<Nation> list = q.list();

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
            return (List<Nation>) result;
        }
    }

    public List<Nation> findByNationName(String nationName, int start, int end)
        throws SystemException {
        return findByNationName(nationName, start, end, null);
    }

    public List<Nation> findByNationName(String nationName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "findByNationName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                nationName,
                
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("lower(nationname) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("nationid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationName != null) {
                    qPos.add(nationName);
                }

                List<Nation> list = (List<Nation>) QueryUtil.list(q,
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
            return (List<Nation>) result;
        }
    }

    public Nation findByNationName_First(String nationName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<Nation> list = findByNationName(nationName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("nationName=" + nationName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation findByNationName_Last(String nationName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByNationName(nationName);

        List<Nation> list = findByNationName(nationName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("nationName=" + nationName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation[] findByNationName_PrevAndNext(String nationId,
        String nationName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Nation nation = findByPrimaryKey(nationId);

        int count = countByNationName(nationName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

            if (nationName == null) {
                query.append("nationname LIKE null");
            } else {
                query.append("lower(nationname) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("nationid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (nationName != null) {
                qPos.add(nationName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, nation);

            Nation[] array = new NationImpl[3];

            array[0] = (Nation) objArray[0];
            array[1] = (Nation) objArray[1];
            array[2] = (Nation) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Nation> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("nationid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Nation> list = q.list();

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
            return (List<Nation>) result;
        }
    }

    public List<Nation> findByDescription(String description, int start, int end)
        throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Nation> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

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

                    query.append("nationid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Nation> list = (List<Nation>) QueryUtil.list(q,
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
            return (List<Nation>) result;
        }
    }

    public Nation findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<Nation> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByDescription(description);

        List<Nation> list = findByDescription(description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation[] findByDescription_PrevAndNext(String nationId,
        String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Nation nation = findByPrimaryKey(nationId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

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

                query.append("nationid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, nation);

            Nation[] array = new NationImpl[3];

            array[0] = (Nation) objArray[0];
            array[1] = (Nation) objArray[1];
            array[2] = (Nation) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Nation> findByCountryId(String countryId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (countryId == null) {
                    query.append("countryid LIKE null");
                } else {
                    query.append("countryid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("nationid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryId != null) {
                    qPos.add(countryId);
                }

                List<Nation> list = q.list();

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
            return (List<Nation>) result;
        }
    }

    public List<Nation> findByCountryId(String countryId, int start, int end)
        throws SystemException {
        return findByCountryId(countryId, start, end, null);
    }

    public List<Nation> findByCountryId(String countryId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

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

                    query.append("nationid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (countryId != null) {
                    qPos.add(countryId);
                }

                List<Nation> list = (List<Nation>) QueryUtil.list(q,
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
            return (List<Nation>) result;
        }
    }

    public Nation findByCountryId_First(String countryId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<Nation> list = findByCountryId(countryId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("countryId=" + countryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation findByCountryId_Last(String countryId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByCountryId(countryId);

        List<Nation> list = findByCountryId(countryId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("countryId=" + countryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation[] findByCountryId_PrevAndNext(String nationId,
        String countryId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Nation nation = findByPrimaryKey(nationId);

        int count = countByCountryId(countryId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

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

                query.append("nationid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (countryId != null) {
                qPos.add(countryId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, nation);

            Nation[] array = new NationImpl[3];

            array[0] = (Nation) objArray[0];
            array[1] = (Nation) objArray[1];
            array[2] = (Nation) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Nation> findByC_N_D(String nationCode, String nationName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { nationCode, nationName, description };

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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("nationcode LIKE ?");
                }

                query.append(" AND ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("nationname LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("nationid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationCode != null) {
                    qPos.add(nationCode);
                }

                if (nationName != null) {
                    qPos.add(nationName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Nation> list = q.list();

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
            return (List<Nation>) result;
        }
    }

    public List<Nation> findByC_N_D(String nationCode, String nationName,
        String description, int start, int end) throws SystemException {
        return findByC_N_D(nationCode, nationName, description, start, end, null);
    }

    public List<Nation> findByC_N_D(String nationCode, String nationName,
        String description, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                nationCode,
                
                nationName,
                
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("nationcode LIKE ?");
                }

                query.append(" AND ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("nationname LIKE ?");
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

                    query.append("nationid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationCode != null) {
                    qPos.add(nationCode);
                }

                if (nationName != null) {
                    qPos.add(nationName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Nation> list = (List<Nation>) QueryUtil.list(q,
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
            return (List<Nation>) result;
        }
    }

    public Nation findByC_N_D_First(String nationCode, String nationName,
        String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<Nation> list = findByC_N_D(nationCode, nationName, description, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("nationCode=" + nationCode);

            msg.append(", ");
            msg.append("nationName=" + nationName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation findByC_N_D_Last(String nationCode, String nationName,
        String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByC_N_D(nationCode, nationName, description);

        List<Nation> list = findByC_N_D(nationCode, nationName, description,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("nationCode=" + nationCode);

            msg.append(", ");
            msg.append("nationName=" + nationName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation[] findByC_N_D_PrevAndNext(String nationId, String nationCode,
        String nationName, String description, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Nation nation = findByPrimaryKey(nationId);

        int count = countByC_N_D(nationCode, nationName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

            if (nationCode == null) {
                query.append("nationcode LIKE null");
            } else {
                query.append("nationcode LIKE ?");
            }

            query.append(" AND ");

            if (nationName == null) {
                query.append("nationname LIKE null");
            } else {
                query.append("nationname LIKE ?");
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

                query.append("nationid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (nationCode != null) {
                qPos.add(nationCode);
            }

            if (nationName != null) {
                qPos.add(nationName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, nation);

            Nation[] array = new NationImpl[3];

            array[0] = (Nation) objArray[0];
            array[1] = (Nation) objArray[1];
            array[2] = (Nation) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Nation> findByC_N_D_C(String nationCode, String nationName,
        String description, String countryId) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "findByC_N_D_C";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                nationCode,
                
                nationName,
                
                description,
                
                countryId
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("nationcode LIKE ?");
                }

                query.append(" AND ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("nationname LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" AND ");

                if (countryId == null) {
                    query.append("countryid LIKE null");
                } else {
                    query.append("countryid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("nationid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationCode != null) {
                    qPos.add(nationCode);
                }

                if (nationName != null) {
                    qPos.add(nationName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                if (countryId != null) {
                    qPos.add(countryId);
                }

                List<Nation> list = q.list();

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
            return (List<Nation>) result;
        }
    }

    public List<Nation> findByC_N_D_C(String nationCode, String nationName,
        String description, String countryId, int start, int end)
        throws SystemException {
        return findByC_N_D_C(nationCode, nationName, description, countryId,
            start, end, null);
    }

    public List<Nation> findByC_N_D_C(String nationCode, String nationName,
        String description, String countryId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "findByC_N_D_C";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                nationCode,
                
                nationName,
                
                description,
                
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

                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("nationcode LIKE ?");
                }

                query.append(" AND ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("nationname LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" AND ");

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

                    query.append("nationid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationCode != null) {
                    qPos.add(nationCode);
                }

                if (nationName != null) {
                    qPos.add(nationName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                if (countryId != null) {
                    qPos.add(countryId);
                }

                List<Nation> list = (List<Nation>) QueryUtil.list(q,
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
            return (List<Nation>) result;
        }
    }

    public Nation findByC_N_D_C_First(String nationCode, String nationName,
        String description, String countryId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<Nation> list = findByC_N_D_C(nationCode, nationName, description,
                countryId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("nationCode=" + nationCode);

            msg.append(", ");
            msg.append("nationName=" + nationName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(", ");
            msg.append("countryId=" + countryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation findByC_N_D_C_Last(String nationCode, String nationName,
        String description, String countryId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByC_N_D_C(nationCode, nationName, description,
                countryId);

        List<Nation> list = findByC_N_D_C(nationCode, nationName, description,
                countryId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Nation exists with the key {");

            msg.append("nationCode=" + nationCode);

            msg.append(", ");
            msg.append("nationName=" + nationName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(", ");
            msg.append("countryId=" + countryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Nation[] findByC_N_D_C_PrevAndNext(String nationId,
        String nationCode, String nationName, String description,
        String countryId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        Nation nation = findByPrimaryKey(nationId);

        int count = countByC_N_D_C(nationCode, nationName, description,
                countryId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

            if (nationCode == null) {
                query.append("nationcode LIKE null");
            } else {
                query.append("nationcode LIKE ?");
            }

            query.append(" AND ");

            if (nationName == null) {
                query.append("nationname LIKE null");
            } else {
                query.append("nationname LIKE ?");
            }

            query.append(" AND ");

            if (description == null) {
                query.append("description LIKE null");
            } else {
                query.append("description LIKE ?");
            }

            query.append(" AND ");

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

                query.append("nationid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (nationCode != null) {
                qPos.add(nationCode);
            }

            if (nationName != null) {
                qPos.add(nationName);
            }

            if (description != null) {
                qPos.add(description);
            }

            if (countryId != null) {
                qPos.add(countryId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, nation);

            Nation[] array = new NationImpl[3];

            array[0] = (Nation) objArray[0];
            array[1] = (Nation) objArray[1];
            array[2] = (Nation) objArray[2];

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

    public List<Nation> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Nation> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Nation> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
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

                query.append("FROM com.sgs.portlet.nation.model.Nation ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("nationid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<Nation> list = (List<Nation>) QueryUtil.list(q,
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
            return (List<Nation>) result;
        }
    }

    public void removeByNationCode(String nationCode) throws SystemException {
        for (Nation nation : findByNationCode(nationCode)) {
            remove(nation);
        }
    }

    public void removeByNationName(String nationName) throws SystemException {
        for (Nation nation : findByNationName(nationName)) {
            remove(nation);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (Nation nation : findByDescription(description)) {
            remove(nation);
        }
    }

    public void removeByCountryId(String countryId) throws SystemException {
        for (Nation nation : findByCountryId(countryId)) {
            remove(nation);
        }
    }

    public void removeByC_N_D(String nationCode, String nationName,
        String description) throws SystemException {
        for (Nation nation : findByC_N_D(nationCode, nationName, description)) {
            remove(nation);
        }
    }

    public void removeByC_N_D_C(String nationCode, String nationName,
        String description, String countryId) throws SystemException {
        for (Nation nation : findByC_N_D_C(nationCode, nationName, description,
                countryId)) {
            remove(nation);
        }
    }

    public void removeAll() throws SystemException {
        for (Nation nation : findAll()) {
            remove(nation);
        }
    }

    public int countByNationCode(String nationCode) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "countByNationCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { nationCode };

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
                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("lower(nationcode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationCode != null) {
                    qPos.add(nationCode);
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

    public int countByNationName(String nationName) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "countByNationName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { nationName };

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
                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("lower(nationname) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationName != null) {
                    qPos.add(nationName);
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
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
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
                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

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

    public int countByCountryId(String countryId) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
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
                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

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

    public int countByC_N_D(String nationCode, String nationName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "countByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { nationCode, nationName, description };

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
                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("nationcode LIKE ?");
                }

                query.append(" AND ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("nationname LIKE ?");
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

                if (nationCode != null) {
                    qPos.add(nationCode);
                }

                if (nationName != null) {
                    qPos.add(nationName);
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

    public int countByC_N_D_C(String nationCode, String nationName,
        String description, String countryId) throws SystemException {
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
        String finderMethodName = "countByC_N_D_C";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                nationCode,
                
                nationName,
                
                description,
                
                countryId
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
                query.append("FROM com.sgs.portlet.nation.model.Nation WHERE ");

                if (nationCode == null) {
                    query.append("nationcode LIKE null");
                } else {
                    query.append("nationcode LIKE ?");
                }

                query.append(" AND ");

                if (nationName == null) {
                    query.append("nationname LIKE null");
                } else {
                    query.append("nationname LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" AND ");

                if (countryId == null) {
                    query.append("countryid LIKE null");
                } else {
                    query.append("countryid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (nationCode != null) {
                    qPos.add(nationCode);
                }

                if (nationName != null) {
                    qPos.add(nationName);
                }

                if (description != null) {
                    qPos.add(description);
                }

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
        boolean finderClassNameCacheEnabled = NationModelImpl.CACHE_ENABLED;
        String finderClassName = Nation.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.nation.model.Nation");

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
                        "value.object.listener.com.sgs.portlet.nation.model.Nation")));

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
