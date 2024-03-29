package com.nss.portlet.journal.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.journal.NoSuchStructureException;
import com.nss.portlet.journal.model.JournalStructure;
import com.nss.portlet.journal.model.impl.JournalStructureImpl;
import com.nss.portlet.journal.model.impl.JournalStructureModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JournalStructurePersistenceImpl extends BasePersistenceImpl
    implements JournalStructurePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = JournalStructureImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUuid",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_UUID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUuid",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByUuid",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_GROUPID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STRUCTUREID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStructureId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STRUCTUREID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStructureId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STRUCTUREID = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStructureId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_G_S = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByG_S",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByG_S",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_G_P = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByG_P",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_G_P = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByG_P",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_G_P = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByG_P",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(JournalStructurePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalArticlePersistence.impl")
    protected com.nss.portlet.journal.service.persistence.JournalArticlePersistence journalArticlePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalArticleImagePersistence.impl")
    protected com.nss.portlet.journal.service.persistence.JournalArticleImagePersistence journalArticleImagePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalArticleResourcePersistence.impl")
    protected com.nss.portlet.journal.service.persistence.JournalArticleResourcePersistence journalArticleResourcePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalContentSearchPersistence.impl")
    protected com.nss.portlet.journal.service.persistence.JournalContentSearchPersistence journalContentSearchPersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalFeedPersistence.impl")
    protected com.nss.portlet.journal.service.persistence.JournalFeedPersistence journalFeedPersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalStructurePersistence.impl")
    protected com.nss.portlet.journal.service.persistence.JournalStructurePersistence journalStructurePersistence;
    @BeanReference(name = "com.nss.portlet.journal.service.persistence.JournalTemplatePersistence.impl")
    protected com.nss.portlet.journal.service.persistence.JournalTemplatePersistence journalTemplatePersistence;
    @BeanReference(name = "com.liferay.portal.service.persistence.ResourcePersistence.impl")
    protected com.liferay.portal.service.persistence.ResourcePersistence resourcePersistence;
    @BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
    protected com.liferay.portal.service.persistence.UserPersistence userPersistence;
    @BeanReference(name = "com.liferay.portal.service.persistence.WebDAVPropsPersistence.impl")
    protected com.liferay.portal.service.persistence.WebDAVPropsPersistence webDAVPropsPersistence;
    @BeanReference(name = "com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence.impl")
    protected com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence expandoValuePersistence;

    public void cacheResult(JournalStructure journalStructure) {
        EntityCacheUtil.putResult(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureImpl.class, journalStructure.getPrimaryKey(),
            journalStructure);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] {
                journalStructure.getUuid(),
                new Long(journalStructure.getGroupId())
            }, journalStructure);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S,
            new Object[] {
                new Long(journalStructure.getGroupId()),
                
            journalStructure.getStructureId()
            }, journalStructure);
    }

    public void cacheResult(List<JournalStructure> journalStructures) {
        for (JournalStructure journalStructure : journalStructures) {
            if (EntityCacheUtil.getResult(
                        JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
                        JournalStructureImpl.class,
                        journalStructure.getPrimaryKey(), this) == null) {
                cacheResult(journalStructure);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(JournalStructureImpl.class.getName());
        EntityCacheUtil.clearCache(JournalStructureImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public JournalStructure create(long id) {
        JournalStructure journalStructure = new JournalStructureImpl();

        journalStructure.setNew(true);
        journalStructure.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        journalStructure.setUuid(uuid);

        return journalStructure;
    }

    public JournalStructure remove(long id)
        throws NoSuchStructureException, SystemException {
        Session session = null;

        try {
            session = openSession();

            JournalStructure journalStructure = (JournalStructure) session.get(JournalStructureImpl.class,
                    new Long(id));

            if (journalStructure == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No JournalStructure exists with the primary key " +
                        id);
                }

                throw new NoSuchStructureException(
                    "No JournalStructure exists with the primary key " + id);
            }

            return remove(journalStructure);
        } catch (NoSuchStructureException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public JournalStructure remove(JournalStructure journalStructure)
        throws SystemException {
        for (ModelListener<JournalStructure> listener : listeners) {
            listener.onBeforeRemove(journalStructure);
        }

        journalStructure = removeImpl(journalStructure);

        for (ModelListener<JournalStructure> listener : listeners) {
            listener.onAfterRemove(journalStructure);
        }

        return journalStructure;
    }

    protected JournalStructure removeImpl(JournalStructure journalStructure)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (journalStructure.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(JournalStructureImpl.class,
                        journalStructure.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(journalStructure);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        JournalStructureModelImpl journalStructureModelImpl = (JournalStructureModelImpl) journalStructure;

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] {
                journalStructureModelImpl.getOriginalUuid(),
                new Long(journalStructureModelImpl.getOriginalGroupId())
            });

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_S,
            new Object[] {
                new Long(journalStructureModelImpl.getOriginalGroupId()),
                
            journalStructureModelImpl.getOriginalStructureId()
            });

        EntityCacheUtil.removeResult(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureImpl.class, journalStructure.getPrimaryKey());

        return journalStructure;
    }

    /**
     * @deprecated Use <code>update(JournalStructure journalStructure, boolean merge)</code>.
     */
    public JournalStructure update(JournalStructure journalStructure)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(JournalStructure journalStructure) method. Use update(JournalStructure journalStructure, boolean merge) instead.");
        }

        return update(journalStructure, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalStructure the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalStructure is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public JournalStructure update(JournalStructure journalStructure,
        boolean merge) throws SystemException {
        boolean isNew = journalStructure.isNew();

        for (ModelListener<JournalStructure> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(journalStructure);
            } else {
                listener.onBeforeUpdate(journalStructure);
            }
        }

        journalStructure = updateImpl(journalStructure, merge);

        for (ModelListener<JournalStructure> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(journalStructure);
            } else {
                listener.onAfterUpdate(journalStructure);
            }
        }

        return journalStructure;
    }

    public JournalStructure updateImpl(
        com.nss.portlet.journal.model.JournalStructure journalStructure,
        boolean merge) throws SystemException {
        boolean isNew = journalStructure.isNew();

        JournalStructureModelImpl journalStructureModelImpl = (JournalStructureModelImpl) journalStructure;

        if (Validator.isNull(journalStructure.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            journalStructure.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, journalStructure, merge);

            journalStructure.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
            JournalStructureImpl.class, journalStructure.getPrimaryKey(),
            journalStructure);

        if (!isNew &&
                (!Validator.equals(journalStructure.getUuid(),
                    journalStructureModelImpl.getOriginalUuid()) ||
                (journalStructure.getGroupId() != journalStructureModelImpl.getOriginalGroupId()))) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                new Object[] {
                    journalStructureModelImpl.getOriginalUuid(),
                    new Long(journalStructureModelImpl.getOriginalGroupId())
                });
        }

        if (isNew ||
                (!Validator.equals(journalStructure.getUuid(),
                    journalStructureModelImpl.getOriginalUuid()) ||
                (journalStructure.getGroupId() != journalStructureModelImpl.getOriginalGroupId()))) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                new Object[] {
                    journalStructure.getUuid(),
                    new Long(journalStructure.getGroupId())
                }, journalStructure);
        }

        if (!isNew &&
                ((journalStructure.getGroupId() != journalStructureModelImpl.getOriginalGroupId()) ||
                !Validator.equals(journalStructure.getStructureId(),
                    journalStructureModelImpl.getOriginalStructureId()))) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_S,
                new Object[] {
                    new Long(journalStructureModelImpl.getOriginalGroupId()),
                    
                journalStructureModelImpl.getOriginalStructureId()
                });
        }

        if (isNew ||
                ((journalStructure.getGroupId() != journalStructureModelImpl.getOriginalGroupId()) ||
                !Validator.equals(journalStructure.getStructureId(),
                    journalStructureModelImpl.getOriginalStructureId()))) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S,
                new Object[] {
                    new Long(journalStructure.getGroupId()),
                    
                journalStructure.getStructureId()
                }, journalStructure);
        }

        return journalStructure;
    }

    public JournalStructure findByPrimaryKey(long id)
        throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = fetchByPrimaryKey(id);

        if (journalStructure == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No JournalStructure exists with the primary key " +
                    id);
            }

            throw new NoSuchStructureException(
                "No JournalStructure exists with the primary key " + id);
        }

        return journalStructure;
    }

    public JournalStructure fetchByPrimaryKey(long id)
        throws SystemException {
        JournalStructure journalStructure = (JournalStructure) EntityCacheUtil.getResult(JournalStructureModelImpl.ENTITY_CACHE_ENABLED,
                JournalStructureImpl.class, id, this);

        if (journalStructure == null) {
            Session session = null;

            try {
                session = openSession();

                journalStructure = (JournalStructure) session.get(JournalStructureImpl.class,
                        new Long(id));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (journalStructure != null) {
                    cacheResult(journalStructure);
                }

                closeSession(session);
            }
        }

        return journalStructure;
    }

    public List<JournalStructure> findByUuid(String uuid)
        throws SystemException {
        Object[] finderArgs = new Object[] { uuid };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("structureId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<JournalStructure> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    public List<JournalStructure> findByUuid(String uuid, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                uuid,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UUID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("structureId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                list = (List<JournalStructure>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UUID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public JournalStructure findByUuid_First(String uuid, OrderByComparator obc)
        throws NoSuchStructureException, SystemException {
        List<JournalStructure> list = findByUuid(uuid, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("uuid=" + uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchStructureException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public JournalStructure findByUuid_Last(String uuid, OrderByComparator obc)
        throws NoSuchStructureException, SystemException {
        int count = countByUuid(uuid);

        List<JournalStructure> list = findByUuid(uuid, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("uuid=" + uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchStructureException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public JournalStructure[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator obc) throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = findByPrimaryKey(id);

        int count = countByUuid(uuid);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

            if (uuid == null) {
                query.append("uuid_ IS NULL");
            } else {
                query.append("uuid_ = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("structureId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (uuid != null) {
                qPos.add(uuid);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    journalStructure);

            JournalStructure[] array = new JournalStructureImpl[3];

            array[0] = (JournalStructure) objArray[0];
            array[1] = (JournalStructure) objArray[1];
            array[2] = (JournalStructure) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public JournalStructure findByUUID_G(String uuid, long groupId)
        throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = fetchByUUID_G(uuid, groupId);

        if (journalStructure == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("uuid=" + uuid);

            msg.append(", ");
            msg.append("groupId=" + groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchStructureException(msg.toString());
        }

        return journalStructure;
    }

    public JournalStructure fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    public JournalStructure fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, new Long(groupId) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" AND ");

                query.append("groupId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("structureId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<JournalStructure> list = q.list();

                result = list;

                JournalStructure journalStructure = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    journalStructure = list.get(0);

                    cacheResult(journalStructure);

                    if ((journalStructure.getUuid() == null) ||
                            !journalStructure.getUuid().equals(uuid) ||
                            (journalStructure.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, journalStructure);
                    }
                }

                return journalStructure;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, new ArrayList<JournalStructure>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (JournalStructure) result;
            }
        }
    }

    public List<JournalStructure> findByGroupId(long groupId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId) };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("structureId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<JournalStructure> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    public List<JournalStructure> findByGroupId(long groupId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("structureId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = (List<JournalStructure>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public JournalStructure findByGroupId_First(long groupId,
        OrderByComparator obc) throws NoSuchStructureException, SystemException {
        List<JournalStructure> list = findByGroupId(groupId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchStructureException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public JournalStructure findByGroupId_Last(long groupId,
        OrderByComparator obc) throws NoSuchStructureException, SystemException {
        int count = countByGroupId(groupId);

        List<JournalStructure> list = findByGroupId(groupId, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchStructureException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public JournalStructure[] findByGroupId_PrevAndNext(long id, long groupId,
        OrderByComparator obc) throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = findByPrimaryKey(id);

        int count = countByGroupId(groupId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

            query.append("groupId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("structureId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    journalStructure);

            JournalStructure[] array = new JournalStructureImpl[3];

            array[0] = (JournalStructure) objArray[0];
            array[1] = (JournalStructure) objArray[1];
            array[2] = (JournalStructure) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<JournalStructure> findByStructureId(String structureId)
        throws SystemException {
        Object[] finderArgs = new Object[] { structureId };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STRUCTUREID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                if (structureId == null) {
                    query.append("structureId IS NULL");
                } else {
                    query.append("structureId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("structureId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (structureId != null) {
                    qPos.add(structureId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STRUCTUREID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<JournalStructure> findByStructureId(String structureId,
        int start, int end) throws SystemException {
        return findByStructureId(structureId, start, end, null);
    }

    public List<JournalStructure> findByStructureId(String structureId,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                structureId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STRUCTUREID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                if (structureId == null) {
                    query.append("structureId IS NULL");
                } else {
                    query.append("structureId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("structureId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (structureId != null) {
                    qPos.add(structureId);
                }

                list = (List<JournalStructure>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STRUCTUREID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public JournalStructure findByStructureId_First(String structureId,
        OrderByComparator obc) throws NoSuchStructureException, SystemException {
        List<JournalStructure> list = findByStructureId(structureId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("structureId=" + structureId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchStructureException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public JournalStructure findByStructureId_Last(String structureId,
        OrderByComparator obc) throws NoSuchStructureException, SystemException {
        int count = countByStructureId(structureId);

        List<JournalStructure> list = findByStructureId(structureId, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("structureId=" + structureId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchStructureException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public JournalStructure[] findByStructureId_PrevAndNext(long id,
        String structureId, OrderByComparator obc)
        throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = findByPrimaryKey(id);

        int count = countByStructureId(structureId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

            if (structureId == null) {
                query.append("structureId IS NULL");
            } else {
                query.append("structureId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("structureId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (structureId != null) {
                qPos.add(structureId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    journalStructure);

            JournalStructure[] array = new JournalStructureImpl[3];

            array[0] = (JournalStructure) objArray[0];
            array[1] = (JournalStructure) objArray[1];
            array[2] = (JournalStructure) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public JournalStructure findByG_S(long groupId, String structureId)
        throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = fetchByG_S(groupId, structureId);

        if (journalStructure == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("structureId=" + structureId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchStructureException(msg.toString());
        }

        return journalStructure;
    }

    public JournalStructure fetchByG_S(long groupId, String structureId)
        throws SystemException {
        return fetchByG_S(groupId, structureId, true);
    }

    public JournalStructure fetchByG_S(long groupId, String structureId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId), structureId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_S,
                    finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                if (structureId == null) {
                    query.append("structureId IS NULL");
                } else {
                    query.append("structureId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("structureId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (structureId != null) {
                    qPos.add(structureId);
                }

                List<JournalStructure> list = q.list();

                result = list;

                JournalStructure journalStructure = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S,
                        finderArgs, list);
                } else {
                    journalStructure = list.get(0);

                    cacheResult(journalStructure);

                    if ((journalStructure.getGroupId() != groupId) ||
                            (journalStructure.getStructureId() == null) ||
                            !journalStructure.getStructureId()
                                                 .equals(structureId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S,
                            finderArgs, journalStructure);
                    }
                }

                return journalStructure;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_S,
                        finderArgs, new ArrayList<JournalStructure>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (JournalStructure) result;
            }
        }
    }

    public List<JournalStructure> findByG_P(long groupId,
        String parentStructureId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId), parentStructureId };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_P,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                if (parentStructureId == null) {
                    query.append("parentStructureId IS NULL");
                } else {
                    query.append("parentStructureId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("structureId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (parentStructureId != null) {
                    qPos.add(parentStructureId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_P, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<JournalStructure> findByG_P(long groupId,
        String parentStructureId, int start, int end) throws SystemException {
        return findByG_P(groupId, parentStructureId, start, end, null);
    }

    public List<JournalStructure> findByG_P(long groupId,
        String parentStructureId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId),
                
                parentStructureId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_G_P,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                if (parentStructureId == null) {
                    query.append("parentStructureId IS NULL");
                } else {
                    query.append("parentStructureId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("structureId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (parentStructureId != null) {
                    qPos.add(parentStructureId);
                }

                list = (List<JournalStructure>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_G_P,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public JournalStructure findByG_P_First(long groupId,
        String parentStructureId, OrderByComparator obc)
        throws NoSuchStructureException, SystemException {
        List<JournalStructure> list = findByG_P(groupId, parentStructureId, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("parentStructureId=" + parentStructureId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchStructureException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public JournalStructure findByG_P_Last(long groupId,
        String parentStructureId, OrderByComparator obc)
        throws NoSuchStructureException, SystemException {
        int count = countByG_P(groupId, parentStructureId);

        List<JournalStructure> list = findByG_P(groupId, parentStructureId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No JournalStructure exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("parentStructureId=" + parentStructureId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchStructureException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public JournalStructure[] findByG_P_PrevAndNext(long id, long groupId,
        String parentStructureId, OrderByComparator obc)
        throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = findByPrimaryKey(id);

        int count = countByG_P(groupId, parentStructureId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

            query.append("groupId = ?");

            query.append(" AND ");

            if (parentStructureId == null) {
                query.append("parentStructureId IS NULL");
            } else {
                query.append("parentStructureId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("structureId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            if (parentStructureId != null) {
                qPos.add(parentStructureId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    journalStructure);

            JournalStructure[] array = new JournalStructureImpl[3];

            array[0] = (JournalStructure) objArray[0];
            array[1] = (JournalStructure) objArray[1];
            array[2] = (JournalStructure) objArray[2];

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

    public List<JournalStructure> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<JournalStructure> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<JournalStructure> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<JournalStructure> list = (List<JournalStructure>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("structureId ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<JournalStructure>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<JournalStructure>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalStructure>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByUuid(String uuid) throws SystemException {
        for (JournalStructure journalStructure : findByUuid(uuid)) {
            remove(journalStructure);
        }
    }

    public void removeByUUID_G(String uuid, long groupId)
        throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = findByUUID_G(uuid, groupId);

        remove(journalStructure);
    }

    public void removeByGroupId(long groupId) throws SystemException {
        for (JournalStructure journalStructure : findByGroupId(groupId)) {
            remove(journalStructure);
        }
    }

    public void removeByStructureId(String structureId)
        throws SystemException {
        for (JournalStructure journalStructure : findByStructureId(structureId)) {
            remove(journalStructure);
        }
    }

    public void removeByG_S(long groupId, String structureId)
        throws NoSuchStructureException, SystemException {
        JournalStructure journalStructure = findByG_S(groupId, structureId);

        remove(journalStructure);
    }

    public void removeByG_P(long groupId, String parentStructureId)
        throws SystemException {
        for (JournalStructure journalStructure : findByG_P(groupId,
                parentStructureId)) {
            remove(journalStructure);
        }
    }

    public void removeAll() throws SystemException {
        for (JournalStructure journalStructure : findAll()) {
            remove(journalStructure);
        }
    }

    public int countByUuid(String uuid) throws SystemException {
        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        Object[] finderArgs = new Object[] { uuid, new Long(groupId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" AND ");

                query.append("groupId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStructureId(String structureId) throws SystemException {
        Object[] finderArgs = new Object[] { structureId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STRUCTUREID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                if (structureId == null) {
                    query.append("structureId IS NULL");
                } else {
                    query.append("structureId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (structureId != null) {
                    qPos.add(structureId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STRUCTUREID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByG_S(long groupId, String structureId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId), structureId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_S,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                if (structureId == null) {
                    query.append("structureId IS NULL");
                } else {
                    query.append("structureId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (structureId != null) {
                    qPos.add(structureId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_S, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByG_P(long groupId, String parentStructureId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId), parentStructureId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_P,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journal.model.JournalStructure WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                if (parentStructureId == null) {
                    query.append("parentStructureId IS NULL");
                } else {
                    query.append("parentStructureId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (parentStructureId != null) {
                    qPos.add(parentStructureId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_P, finderArgs,
                    count);

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
                        "SELECT COUNT(*) FROM com.nss.portlet.journal.model.JournalStructure");

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
                        "value.object.listener.com.nss.portlet.journal.model.JournalStructure")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<JournalStructure>> listenersList = new ArrayList<ModelListener<JournalStructure>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<JournalStructure>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
