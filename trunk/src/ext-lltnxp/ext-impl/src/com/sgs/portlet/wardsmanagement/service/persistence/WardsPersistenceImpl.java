package com.sgs.portlet.wardsmanagement.service.persistence;

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

import com.sgs.portlet.wardsmanagement.NoSuchWardsException;
import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.model.impl.WardsImpl;
import com.sgs.portlet.wardsmanagement.model.impl.WardsModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class WardsPersistenceImpl extends BasePersistenceImpl
    implements WardsPersistence {
    private static Log _log = LogFactory.getLog(WardsPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public Wards create(String wardsId) {
        Wards wards = new WardsImpl();

        wards.setNew(true);
        wards.setPrimaryKey(wardsId);

        return wards;
    }

    public Wards remove(String wardsId)
        throws NoSuchWardsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Wards wards = (Wards) session.get(WardsImpl.class, wardsId);

            if (wards == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Wards exists with the primary key " +
                        wardsId);
                }

                throw new NoSuchWardsException(
                    "No Wards exists with the primary key " + wardsId);
            }

            return remove(wards);
        } catch (NoSuchWardsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Wards remove(Wards wards) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(wards);
            }
        }

        wards = removeImpl(wards);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(wards);
            }
        }

        return wards;
    }

    protected Wards removeImpl(Wards wards) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(wards);

            session.flush();

            return wards;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Wards.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Wards wards, boolean merge)</code>.
     */
    public Wards update(Wards wards) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Wards wards) method. Use update(Wards wards, boolean merge) instead.");
        }

        return update(wards, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                wards the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when wards is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Wards update(Wards wards, boolean merge) throws SystemException {
        boolean isNew = wards.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(wards);
                } else {
                    listener.onBeforeUpdate(wards);
                }
            }
        }

        wards = updateImpl(wards, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(wards);
                } else {
                    listener.onAfterUpdate(wards);
                }
            }
        }

        return wards;
    }

    public Wards updateImpl(com.sgs.portlet.wardsmanagement.model.Wards wards,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(wards);
            } else {
                if (wards.isNew()) {
                    session.save(wards);
                }
            }

            session.flush();

            wards.setNew(false);

            return wards;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Wards.class.getName());
        }
    }

    public Wards findByPrimaryKey(String wardsId)
        throws NoSuchWardsException, SystemException {
        Wards wards = fetchByPrimaryKey(wardsId);

        if (wards == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Wards exists with the primary key " + wardsId);
            }

            throw new NoSuchWardsException(
                "No Wards exists with the primary key " + wardsId);
        }

        return wards;
    }

    public Wards fetchByPrimaryKey(String wardsId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Wards) session.get(WardsImpl.class, wardsId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Wards> findByC_N_I_D(String wardsCode, String wardsName,
        String districtId, String description) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "findByC_N_I_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                wardsCode,
                
                wardsName,
                
                districtId,
                
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsCode == null) {
                    query.append("wardsCode LIKE null");
                } else {
                    query.append("wardsCode LIKE ?");
                }

                query.append(" AND ");

                if (wardsName == null) {
                    query.append("wardsName LIKE null");
                } else {
                    query.append("wardsName LIKE ?");
                }

                query.append(" AND ");

                if (districtId == null) {
                    query.append("districtId LIKE null");
                } else {
                    query.append("districtId LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("wardsName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (wardsCode != null) {
                    qPos.add(wardsCode);
                }

                if (wardsName != null) {
                    qPos.add(wardsName);
                }

                if (districtId != null) {
                    qPos.add(districtId);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Wards> list = q.list();

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
            return (List<Wards>) result;
        }
    }

    public List<Wards> findByC_N_I_D(String wardsCode, String wardsName,
        String districtId, String description, int start, int end)
        throws SystemException {
        return findByC_N_I_D(wardsCode, wardsName, districtId, description,
            start, end, null);
    }

    public List<Wards> findByC_N_I_D(String wardsCode, String wardsName,
        String districtId, String description, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "findByC_N_I_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                wardsCode,
                
                wardsName,
                
                districtId,
                
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsCode == null) {
                    query.append("wardsCode LIKE null");
                } else {
                    query.append("wardsCode LIKE ?");
                }

                query.append(" AND ");

                if (wardsName == null) {
                    query.append("wardsName LIKE null");
                } else {
                    query.append("wardsName LIKE ?");
                }

                query.append(" AND ");

                if (districtId == null) {
                    query.append("districtId LIKE null");
                } else {
                    query.append("districtId LIKE ?");
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

                    query.append("wardsName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (wardsCode != null) {
                    qPos.add(wardsCode);
                }

                if (wardsName != null) {
                    qPos.add(wardsName);
                }

                if (districtId != null) {
                    qPos.add(districtId);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Wards> list = (List<Wards>) QueryUtil.list(q,
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
            return (List<Wards>) result;
        }
    }

    public Wards findByC_N_I_D_First(String wardsCode, String wardsName,
        String districtId, String description, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        List<Wards> list = findByC_N_I_D(wardsCode, wardsName, districtId,
                description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("wardsCode=" + wardsCode);

            msg.append(", ");
            msg.append("wardsName=" + wardsName);

            msg.append(", ");
            msg.append("districtId=" + districtId);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards findByC_N_I_D_Last(String wardsCode, String wardsName,
        String districtId, String description, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        int count = countByC_N_I_D(wardsCode, wardsName, districtId, description);

        List<Wards> list = findByC_N_I_D(wardsCode, wardsName, districtId,
                description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("wardsCode=" + wardsCode);

            msg.append(", ");
            msg.append("wardsName=" + wardsName);

            msg.append(", ");
            msg.append("districtId=" + districtId);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards[] findByC_N_I_D_PrevAndNext(String wardsId, String wardsCode,
        String wardsName, String districtId, String description,
        OrderByComparator obc) throws NoSuchWardsException, SystemException {
        Wards wards = findByPrimaryKey(wardsId);

        int count = countByC_N_I_D(wardsCode, wardsName, districtId, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

            if (wardsCode == null) {
                query.append("wardsCode LIKE null");
            } else {
                query.append("wardsCode LIKE ?");
            }

            query.append(" AND ");

            if (wardsName == null) {
                query.append("wardsName LIKE null");
            } else {
                query.append("wardsName LIKE ?");
            }

            query.append(" AND ");

            if (districtId == null) {
                query.append("districtId LIKE null");
            } else {
                query.append("districtId LIKE ?");
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

                query.append("wardsName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (wardsCode != null) {
                qPos.add(wardsCode);
            }

            if (wardsName != null) {
                qPos.add(wardsName);
            }

            if (districtId != null) {
                qPos.add(districtId);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, wards);

            Wards[] array = new WardsImpl[3];

            array[0] = (Wards) objArray[0];
            array[1] = (Wards) objArray[1];
            array[2] = (Wards) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Wards> findByCode(String wardsCode) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "findByCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { wardsCode };

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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsCode == null) {
                    query.append("wardsCode LIKE null");
                } else {
                    query.append("lower(wardsCode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("wardsName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (wardsCode != null) {
                    qPos.add(wardsCode);
                }

                List<Wards> list = q.list();

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
            return (List<Wards>) result;
        }
    }

    public List<Wards> findByCode(String wardsCode, int start, int end)
        throws SystemException {
        return findByCode(wardsCode, start, end, null);
    }

    public List<Wards> findByCode(String wardsCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "findByCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                wardsCode,
                
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsCode == null) {
                    query.append("wardsCode LIKE null");
                } else {
                    query.append("lower(wardsCode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("wardsName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (wardsCode != null) {
                    qPos.add(wardsCode);
                }

                List<Wards> list = (List<Wards>) QueryUtil.list(q,
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
            return (List<Wards>) result;
        }
    }

    public Wards findByCode_First(String wardsCode, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        List<Wards> list = findByCode(wardsCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("wardsCode=" + wardsCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards findByCode_Last(String wardsCode, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        int count = countByCode(wardsCode);

        List<Wards> list = findByCode(wardsCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("wardsCode=" + wardsCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards[] findByCode_PrevAndNext(String wardsId, String wardsCode,
        OrderByComparator obc) throws NoSuchWardsException, SystemException {
        Wards wards = findByPrimaryKey(wardsId);

        int count = countByCode(wardsCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

            if (wardsCode == null) {
                query.append("wardsCode LIKE null");
            } else {
                query.append("lower(wardsCode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("wardsName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (wardsCode != null) {
                qPos.add(wardsCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, wards);

            Wards[] array = new WardsImpl[3];

            array[0] = (Wards) objArray[0];
            array[1] = (Wards) objArray[1];
            array[2] = (Wards) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Wards> findByName(String wardsName) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "findByName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { wardsName };

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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsName == null) {
                    query.append("wardsName LIKE null");
                } else {
                    query.append("lower(wardsName) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("wardsName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (wardsName != null) {
                    qPos.add(wardsName);
                }

                List<Wards> list = q.list();

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
            return (List<Wards>) result;
        }
    }

    public List<Wards> findByName(String wardsName, int start, int end)
        throws SystemException {
        return findByName(wardsName, start, end, null);
    }

    public List<Wards> findByName(String wardsName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "findByName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                wardsName,
                
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsName == null) {
                    query.append("wardsName LIKE null");
                } else {
                    query.append("lower(wardsName) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("wardsName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (wardsName != null) {
                    qPos.add(wardsName);
                }

                List<Wards> list = (List<Wards>) QueryUtil.list(q,
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
            return (List<Wards>) result;
        }
    }

    public Wards findByName_First(String wardsName, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        List<Wards> list = findByName(wardsName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("wardsName=" + wardsName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards findByName_Last(String wardsName, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        int count = countByName(wardsName);

        List<Wards> list = findByName(wardsName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("wardsName=" + wardsName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards[] findByName_PrevAndNext(String wardsId, String wardsName,
        OrderByComparator obc) throws NoSuchWardsException, SystemException {
        Wards wards = findByPrimaryKey(wardsId);

        int count = countByName(wardsName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

            if (wardsName == null) {
                query.append("wardsName LIKE null");
            } else {
                query.append("lower(wardsName) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("wardsName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (wardsName != null) {
                qPos.add(wardsName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, wards);

            Wards[] array = new WardsImpl[3];

            array[0] = (Wards) objArray[0];
            array[1] = (Wards) objArray[1];
            array[2] = (Wards) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Wards> findByDistrictId(String districtId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "findByDistrictId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { districtId };

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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (districtId == null) {
                    query.append("districtId LIKE null");
                } else {
                    query.append("districtId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("wardsName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtId != null) {
                    qPos.add(districtId);
                }

                List<Wards> list = q.list();

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
            return (List<Wards>) result;
        }
    }

    public List<Wards> findByDistrictId(String districtId, int start, int end)
        throws SystemException {
        return findByDistrictId(districtId, start, end, null);
    }

    public List<Wards> findByDistrictId(String districtId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "findByDistrictId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                districtId,
                
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (districtId == null) {
                    query.append("districtId LIKE null");
                } else {
                    query.append("districtId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("wardsName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtId != null) {
                    qPos.add(districtId);
                }

                List<Wards> list = (List<Wards>) QueryUtil.list(q,
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
            return (List<Wards>) result;
        }
    }

    public Wards findByDistrictId_First(String districtId, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        List<Wards> list = findByDistrictId(districtId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("districtId=" + districtId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards findByDistrictId_Last(String districtId, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        int count = countByDistrictId(districtId);

        List<Wards> list = findByDistrictId(districtId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("districtId=" + districtId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards[] findByDistrictId_PrevAndNext(String wardsId,
        String districtId, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        Wards wards = findByPrimaryKey(wardsId);

        int count = countByDistrictId(districtId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

            if (districtId == null) {
                query.append("districtId LIKE null");
            } else {
                query.append("districtId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("wardsName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (districtId != null) {
                qPos.add(districtId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, wards);

            Wards[] array = new WardsImpl[3];

            array[0] = (Wards) objArray[0];
            array[1] = (Wards) objArray[1];
            array[2] = (Wards) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Wards> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("wardsName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Wards> list = q.list();

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
            return (List<Wards>) result;
        }
    }

    public List<Wards> findByDescription(String description, int start, int end)
        throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Wards> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

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

                    query.append("wardsName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Wards> list = (List<Wards>) QueryUtil.list(q,
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
            return (List<Wards>) result;
        }
    }

    public Wards findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchWardsException, SystemException {
        List<Wards> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchWardsException, SystemException {
        int count = countByDescription(description);

        List<Wards> list = findByDescription(description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Wards exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchWardsException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Wards[] findByDescription_PrevAndNext(String wardsId,
        String description, OrderByComparator obc)
        throws NoSuchWardsException, SystemException {
        Wards wards = findByPrimaryKey(wardsId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

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

                query.append("wardsName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, wards);

            Wards[] array = new WardsImpl[3];

            array[0] = (Wards) objArray[0];
            array[1] = (Wards) objArray[1];
            array[2] = (Wards) objArray[2];

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

    public List<Wards> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Wards> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Wards> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("wardsName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<Wards> list = (List<Wards>) QueryUtil.list(q,
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
            return (List<Wards>) result;
        }
    }

    public void removeByC_N_I_D(String wardsCode, String wardsName,
        String districtId, String description) throws SystemException {
        for (Wards wards : findByC_N_I_D(wardsCode, wardsName, districtId,
                description)) {
            remove(wards);
        }
    }

    public void removeByCode(String wardsCode) throws SystemException {
        for (Wards wards : findByCode(wardsCode)) {
            remove(wards);
        }
    }

    public void removeByName(String wardsName) throws SystemException {
        for (Wards wards : findByName(wardsName)) {
            remove(wards);
        }
    }

    public void removeByDistrictId(String districtId) throws SystemException {
        for (Wards wards : findByDistrictId(districtId)) {
            remove(wards);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (Wards wards : findByDescription(description)) {
            remove(wards);
        }
    }

    public void removeAll() throws SystemException {
        for (Wards wards : findAll()) {
            remove(wards);
        }
    }

    public int countByC_N_I_D(String wardsCode, String wardsName,
        String districtId, String description) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "countByC_N_I_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                wardsCode,
                
                wardsName,
                
                districtId,
                
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsCode == null) {
                    query.append("wardsCode LIKE null");
                } else {
                    query.append("wardsCode LIKE ?");
                }

                query.append(" AND ");

                if (wardsName == null) {
                    query.append("wardsName LIKE null");
                } else {
                    query.append("wardsName LIKE ?");
                }

                query.append(" AND ");

                if (districtId == null) {
                    query.append("districtId LIKE null");
                } else {
                    query.append("districtId LIKE ?");
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

                if (wardsCode != null) {
                    qPos.add(wardsCode);
                }

                if (wardsName != null) {
                    qPos.add(wardsName);
                }

                if (districtId != null) {
                    qPos.add(districtId);
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

    public int countByCode(String wardsCode) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "countByCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { wardsCode };

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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsCode == null) {
                    query.append("wardsCode LIKE null");
                } else {
                    query.append("lower(wardsCode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (wardsCode != null) {
                    qPos.add(wardsCode);
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

    public int countByName(String wardsName) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "countByName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { wardsName };

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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (wardsName == null) {
                    query.append("wardsName LIKE null");
                } else {
                    query.append("lower(wardsName) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (wardsName != null) {
                    qPos.add(wardsName);
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

    public int countByDistrictId(String districtId) throws SystemException {
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
        String finderMethodName = "countByDistrictId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { districtId };

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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

                if (districtId == null) {
                    query.append("districtId LIKE null");
                } else {
                    query.append("districtId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (districtId != null) {
                    qPos.add(districtId);
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
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
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
                    "FROM com.sgs.portlet.wardsmanagement.model.Wards WHERE ");

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
        boolean finderClassNameCacheEnabled = WardsModelImpl.CACHE_ENABLED;
        String finderClassName = Wards.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.wardsmanagement.model.Wards");

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
                        "value.object.listener.com.sgs.portlet.wardsmanagement.model.Wards")));

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
