package com.sgs.portlet.position.service.persistence;

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

import com.sgs.portlet.position.NoSuchPositionException;
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.model.impl.PositionImpl;
import com.sgs.portlet.position.model.impl.PositionModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PositionPersistenceImpl extends BasePersistenceImpl
    implements PositionPersistence {
    private static Log _log = LogFactory.getLog(PositionPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public Position create(String positionId) {
        Position position = new PositionImpl();

        position.setNew(true);
        position.setPrimaryKey(positionId);

        return position;
    }

    public Position remove(String positionId)
        throws NoSuchPositionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Position position = (Position) session.get(PositionImpl.class,
                    positionId);

            if (position == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Position exists with the primary key " +
                        positionId);
                }

                throw new NoSuchPositionException(
                    "No Position exists with the primary key " + positionId);
            }

            return remove(position);
        } catch (NoSuchPositionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Position remove(Position position) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(position);
            }
        }

        position = removeImpl(position);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(position);
            }
        }

        return position;
    }

    protected Position removeImpl(Position position) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(position);

            session.flush();

            return position;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Position.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Position position, boolean merge)</code>.
     */
    public Position update(Position position) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Position position) method. Use update(Position position, boolean merge) instead.");
        }

        return update(position, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                position the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when position is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Position update(Position position, boolean merge)
        throws SystemException {
        boolean isNew = position.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(position);
                } else {
                    listener.onBeforeUpdate(position);
                }
            }
        }

        position = updateImpl(position, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(position);
                } else {
                    listener.onAfterUpdate(position);
                }
            }
        }

        return position;
    }

    public Position updateImpl(
        com.sgs.portlet.position.model.Position position, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(position);
            } else {
                if (position.isNew()) {
                    session.save(position);
                }
            }

            session.flush();

            position.setNew(false);

            return position;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Position.class.getName());
        }
    }

    public Position findByPrimaryKey(String positionId)
        throws NoSuchPositionException, SystemException {
        Position position = fetchByPrimaryKey(positionId);

        if (position == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Position exists with the primary key " +
                    positionId);
            }

            throw new NoSuchPositionException(
                "No Position exists with the primary key " + positionId);
        }

        return position;
    }

    public Position fetchByPrimaryKey(String positionId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Position) session.get(PositionImpl.class, positionId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Position> findByPositionCode(String positionCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "findByPositionCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { positionCode };

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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionCode == null) {
                    query.append("positioncode LIKE null");
                } else {
                    query.append("lower(positioncode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("positionname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionCode != null) {
                    qPos.add(positionCode);
                }

                List<Position> list = q.list();

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
            return (List<Position>) result;
        }
    }

    public List<Position> findByPositionCode(String positionCode, int start,
        int end) throws SystemException {
        return findByPositionCode(positionCode, start, end, null);
    }

    public List<Position> findByPositionCode(String positionCode, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "findByPositionCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                positionCode,
                
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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionCode == null) {
                    query.append("positioncode LIKE null");
                } else {
                    query.append("lower(positioncode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("positionname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionCode != null) {
                    qPos.add(positionCode);
                }

                List<Position> list = (List<Position>) QueryUtil.list(q,
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
            return (List<Position>) result;
        }
    }

    public Position findByPositionCode_First(String positionCode,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        List<Position> list = findByPositionCode(positionCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Position exists with the key {");

            msg.append("positionCode=" + positionCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPositionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Position findByPositionCode_Last(String positionCode,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        int count = countByPositionCode(positionCode);

        List<Position> list = findByPositionCode(positionCode, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Position exists with the key {");

            msg.append("positionCode=" + positionCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPositionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Position[] findByPositionCode_PrevAndNext(String positionId,
        String positionCode, OrderByComparator obc)
        throws NoSuchPositionException, SystemException {
        Position position = findByPrimaryKey(positionId);

        int count = countByPositionCode(positionCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.position.model.Position WHERE ");

            if (positionCode == null) {
                query.append("positioncode LIKE null");
            } else {
                query.append("lower(positioncode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("positionname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (positionCode != null) {
                qPos.add(positionCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, position);

            Position[] array = new PositionImpl[3];

            array[0] = (Position) objArray[0];
            array[1] = (Position) objArray[1];
            array[2] = (Position) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Position> findByPositionName(String positionName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "findByPositionName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { positionName };

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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionName == null) {
                    query.append("positionname LIKE null");
                } else {
                    query.append("positionname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("positionname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionName != null) {
                    qPos.add(positionName);
                }

                List<Position> list = q.list();

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
            return (List<Position>) result;
        }
    }

    public List<Position> findByPositionName(String positionName, int start,
        int end) throws SystemException {
        return findByPositionName(positionName, start, end, null);
    }

    public List<Position> findByPositionName(String positionName, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "findByPositionName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                positionName,
                
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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionName == null) {
                    query.append("positionname LIKE null");
                } else {
                    query.append("positionname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("positionname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionName != null) {
                    qPos.add(positionName);
                }

                List<Position> list = (List<Position>) QueryUtil.list(q,
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
            return (List<Position>) result;
        }
    }

    public Position findByPositionName_First(String positionName,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        List<Position> list = findByPositionName(positionName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Position exists with the key {");

            msg.append("positionName=" + positionName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPositionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Position findByPositionName_Last(String positionName,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        int count = countByPositionName(positionName);

        List<Position> list = findByPositionName(positionName, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Position exists with the key {");

            msg.append("positionName=" + positionName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPositionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Position[] findByPositionName_PrevAndNext(String positionId,
        String positionName, OrderByComparator obc)
        throws NoSuchPositionException, SystemException {
        Position position = findByPrimaryKey(positionId);

        int count = countByPositionName(positionName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.position.model.Position WHERE ");

            if (positionName == null) {
                query.append("positionname LIKE null");
            } else {
                query.append("positionname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("positionname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (positionName != null) {
                qPos.add(positionName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, position);

            Position[] array = new PositionImpl[3];

            array[0] = (Position) objArray[0];
            array[1] = (Position) objArray[1];
            array[2] = (Position) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Position> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("positionname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Position> list = q.list();

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
            return (List<Position>) result;
        }
    }

    public List<Position> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Position> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

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

                    query.append("positionname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Position> list = (List<Position>) QueryUtil.list(q,
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
            return (List<Position>) result;
        }
    }

    public Position findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        List<Position> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Position exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPositionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Position findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        int count = countByDescription(description);

        List<Position> list = findByDescription(description, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Position exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPositionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Position[] findByDescription_PrevAndNext(String positionId,
        String description, OrderByComparator obc)
        throws NoSuchPositionException, SystemException {
        Position position = findByPrimaryKey(positionId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.position.model.Position WHERE ");

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

                query.append("positionname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, position);

            Position[] array = new PositionImpl[3];

            array[0] = (Position) objArray[0];
            array[1] = (Position) objArray[1];
            array[2] = (Position) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Position> findByAllfilter(String positionCode,
        String positionName, String description) throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "findByAllfilter";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                positionCode,
                
                positionName,
                
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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionCode == null) {
                    query.append("positioncode LIKE null");
                } else {
                    query.append("positioncode LIKE ?");
                }

                query.append(" AND ");

                if (positionName == null) {
                    query.append("positionname LIKE null");
                } else {
                    query.append("positionname LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("positionname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionCode != null) {
                    qPos.add(positionCode);
                }

                if (positionName != null) {
                    qPos.add(positionName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Position> list = q.list();

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
            return (List<Position>) result;
        }
    }

    public List<Position> findByAllfilter(String positionCode,
        String positionName, String description, int start, int end)
        throws SystemException {
        return findByAllfilter(positionCode, positionName, description, start,
            end, null);
    }

    public List<Position> findByAllfilter(String positionCode,
        String positionName, String description, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "findByAllfilter";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                positionCode,
                
                positionName,
                
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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionCode == null) {
                    query.append("positioncode LIKE null");
                } else {
                    query.append("positioncode LIKE ?");
                }

                query.append(" AND ");

                if (positionName == null) {
                    query.append("positionname LIKE null");
                } else {
                    query.append("positionname LIKE ?");
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

                    query.append("positionname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionCode != null) {
                    qPos.add(positionCode);
                }

                if (positionName != null) {
                    qPos.add(positionName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Position> list = (List<Position>) QueryUtil.list(q,
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
            return (List<Position>) result;
        }
    }

    public Position findByAllfilter_First(String positionCode,
        String positionName, String description, OrderByComparator obc)
        throws NoSuchPositionException, SystemException {
        List<Position> list = findByAllfilter(positionCode, positionName,
                description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Position exists with the key {");

            msg.append("positionCode=" + positionCode);

            msg.append(", ");
            msg.append("positionName=" + positionName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPositionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Position findByAllfilter_Last(String positionCode,
        String positionName, String description, OrderByComparator obc)
        throws NoSuchPositionException, SystemException {
        int count = countByAllfilter(positionCode, positionName, description);

        List<Position> list = findByAllfilter(positionCode, positionName,
                description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Position exists with the key {");

            msg.append("positionCode=" + positionCode);

            msg.append(", ");
            msg.append("positionName=" + positionName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPositionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Position[] findByAllfilter_PrevAndNext(String positionId,
        String positionCode, String positionName, String description,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        Position position = findByPrimaryKey(positionId);

        int count = countByAllfilter(positionCode, positionName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.position.model.Position WHERE ");

            if (positionCode == null) {
                query.append("positioncode LIKE null");
            } else {
                query.append("positioncode LIKE ?");
            }

            query.append(" AND ");

            if (positionName == null) {
                query.append("positionname LIKE null");
            } else {
                query.append("positionname LIKE ?");
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

                query.append("positionname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (positionCode != null) {
                qPos.add(positionCode);
            }

            if (positionName != null) {
                qPos.add(positionName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, position);

            Position[] array = new PositionImpl[3];

            array[0] = (Position) objArray[0];
            array[1] = (Position) objArray[1];
            array[2] = (Position) objArray[2];

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

    public List<Position> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Position> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Position> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
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

                query.append("FROM com.sgs.portlet.position.model.Position ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("positionname ASC");
                }

                Query q = session.createQuery(query.toString());

                List<Position> list = (List<Position>) QueryUtil.list(q,
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
            return (List<Position>) result;
        }
    }

    public void removeByPositionCode(String positionCode)
        throws SystemException {
        for (Position position : findByPositionCode(positionCode)) {
            remove(position);
        }
    }

    public void removeByPositionName(String positionName)
        throws SystemException {
        for (Position position : findByPositionName(positionName)) {
            remove(position);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (Position position : findByDescription(description)) {
            remove(position);
        }
    }

    public void removeByAllfilter(String positionCode, String positionName,
        String description) throws SystemException {
        for (Position position : findByAllfilter(positionCode, positionName,
                description)) {
            remove(position);
        }
    }

    public void removeAll() throws SystemException {
        for (Position position : findAll()) {
            remove(position);
        }
    }

    public int countByPositionCode(String positionCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "countByPositionCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { positionCode };

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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionCode == null) {
                    query.append("positioncode LIKE null");
                } else {
                    query.append("lower(positioncode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionCode != null) {
                    qPos.add(positionCode);
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

    public int countByPositionName(String positionName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "countByPositionName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { positionName };

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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionName == null) {
                    query.append("positionname LIKE null");
                } else {
                    query.append("positionname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionName != null) {
                    qPos.add(positionName);
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
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

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

    public int countByAllfilter(String positionCode, String positionName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
        String finderMethodName = "countByAllfilter";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                positionCode,
                
                positionName,
                
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
                    "FROM com.sgs.portlet.position.model.Position WHERE ");

                if (positionCode == null) {
                    query.append("positioncode LIKE null");
                } else {
                    query.append("positioncode LIKE ?");
                }

                query.append(" AND ");

                if (positionName == null) {
                    query.append("positionname LIKE null");
                } else {
                    query.append("positionname LIKE ?");
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

                if (positionCode != null) {
                    qPos.add(positionCode);
                }

                if (positionName != null) {
                    qPos.add(positionName);
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
        boolean finderClassNameCacheEnabled = PositionModelImpl.CACHE_ENABLED;
        String finderClassName = Position.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.position.model.Position");

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
                        "value.object.listener.com.sgs.portlet.position.model.Position")));

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
