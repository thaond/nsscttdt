package com.nss.portlet.position.service.persistence;

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

import com.nss.portlet.position.NoSuchPositionException;
import com.nss.portlet.position.model.Position;
import com.nss.portlet.position.model.impl.PositionImpl;
import com.nss.portlet.position.model.impl.PositionModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PositionPersistenceImpl extends BasePersistenceImpl
    implements PositionPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PositionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_POSITIONCODE = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByPositionCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_POSITIONCODE = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByPositionCode",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONCODE = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByPositionCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_POSITIONNAME = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByPositionName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_POSITIONNAME = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByPositionName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONNAME = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByPositionName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ALLFILTER = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAllfilter",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ALLFILTER = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAllfilter",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ALLFILTER = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAllfilter",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PositionPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.position.service.persistence.PositionPersistence.impl")
    protected com.nss.portlet.position.service.persistence.PositionPersistence positionPersistence;

    public void cacheResult(Position position) {
        EntityCacheUtil.putResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionImpl.class, position.getPrimaryKey(), position);
    }

    public void cacheResult(List<Position> positions) {
        for (Position position : positions) {
            if (EntityCacheUtil.getResult(
                        PositionModelImpl.ENTITY_CACHE_ENABLED,
                        PositionImpl.class, position.getPrimaryKey(), this) == null) {
                cacheResult(position);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PositionImpl.class.getName());
        EntityCacheUtil.clearCache(PositionImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<Position> listener : listeners) {
            listener.onBeforeRemove(position);
        }

        position = removeImpl(position);

        for (ModelListener<Position> listener : listeners) {
            listener.onAfterRemove(position);
        }

        return position;
    }

    protected Position removeImpl(Position position) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (position.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PositionImpl.class,
                        position.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(position);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionImpl.class, position.getPrimaryKey());

        return position;
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

        for (ModelListener<Position> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(position);
            } else {
                listener.onBeforeUpdate(position);
            }
        }

        position = updateImpl(position, merge);

        for (ModelListener<Position> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(position);
            } else {
                listener.onAfterUpdate(position);
            }
        }

        return position;
    }

    public Position updateImpl(
        com.nss.portlet.position.model.Position position, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, position, merge);

            position.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
            PositionImpl.class, position.getPrimaryKey(), position);

        return position;
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
        Position position = (Position) EntityCacheUtil.getResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
                PositionImpl.class, positionId, this);

        if (position == null) {
            Session session = null;

            try {
                session = openSession();

                position = (Position) session.get(PositionImpl.class, positionId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (position != null) {
                    cacheResult(position);
                }

                closeSession(session);
            }
        }

        return position;
    }

    public List<Position> findByPositionCode(String positionCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { positionCode };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_POSITIONCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_POSITIONCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Position> findByPositionCode(String positionCode, int start,
        int end) throws SystemException {
        return findByPositionCode(positionCode, start, end, null);
    }

    public List<Position> findByPositionCode(String positionCode, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                positionCode,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_POSITIONCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                list = (List<Position>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_POSITIONCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Position findByPositionCode_First(String positionCode,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        List<Position> list = findByPositionCode(positionCode, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append("FROM com.nss.portlet.position.model.Position WHERE ");

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
        Object[] finderArgs = new Object[] { positionName };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_POSITIONNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_POSITIONNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Position> findByPositionName(String positionName, int start,
        int end) throws SystemException {
        return findByPositionName(positionName, start, end, null);
    }

    public List<Position> findByPositionName(String positionName, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                positionName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_POSITIONNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                list = (List<Position>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_POSITIONNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Position findByPositionName_First(String positionName,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        List<Position> list = findByPositionName(positionName, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append("FROM com.nss.portlet.position.model.Position WHERE ");

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
        Object[] finderArgs = new Object[] { description };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Position> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Position> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                list = (List<Position>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Position findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchPositionException, SystemException {
        List<Position> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append("FROM com.nss.portlet.position.model.Position WHERE ");

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
        Object[] finderArgs = new Object[] {
                positionCode,
                
                positionName,
                
                description
            };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ALLFILTER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ALLFILTER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] {
                positionCode,
                
                positionName,
                
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ALLFILTER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                list = (List<Position>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ALLFILTER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Position findByAllfilter_First(String positionCode,
        String positionName, String description, OrderByComparator obc)
        throws NoSuchPositionException, SystemException {
        List<Position> list = findByAllfilter(positionCode, positionName,
                description, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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

            query.append("FROM com.nss.portlet.position.model.Position WHERE ");

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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Position> list = (List<Position>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.position.model.Position ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("positionname ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<Position>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Position>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Position>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { positionCode };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_POSITIONCODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSITIONCODE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByPositionName(String positionName)
        throws SystemException {
        Object[] finderArgs = new Object[] { positionName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_POSITIONNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSITIONNAME,
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
                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

    public int countByAllfilter(String positionCode, String positionName,
        String description) throws SystemException {
        Object[] finderArgs = new Object[] {
                positionCode,
                
                positionName,
                
                description
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALLFILTER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.position.model.Position WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALLFILTER,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.position.model.Position");

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
                        "value.object.listener.com.nss.portlet.position.model.Position")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Position>> listenersList = new ArrayList<ModelListener<Position>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Position>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
