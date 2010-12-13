package com.nss.portlet.onedoor.service.persistence;

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

import com.nss.portlet.onedoor.NoSuchPmlFilePCCCException;
import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.impl.PmlFilePCCCImpl;
import com.nss.portlet.onedoor.model.impl.PmlFilePCCCModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlFilePCCCPersistenceImpl extends BasePersistenceImpl
    implements PmlFilePCCCPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFilePCCCImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILENAME = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILENAME = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILENAME = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFileName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_PROJECTNAME = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByProjectName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_PROJECTNAME = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByProjectName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTNAME = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByProjectName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_APPLICANTCATEGORY = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByApplicantCategory", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPLICANTCATEGORY = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByApplicantCategory",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTCATEGORY = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByApplicantCategory", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVEOFUNIT = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceiveOfUnit", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVEOFUNIT = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceiveOfUnit",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVEOFUNIT = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByReceiveOfUnit", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFilePCCCPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFilePersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFilePersistence pmlOneDoorReceiveFilePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlWfOnedoorProcessPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlWfOnedoorProcessPersistence pmlWfOnedoorProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlWorkflowPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlWorkflowPersistence pmlWorkflowPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlStateProcessPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlStateProcessPersistence pmlStateProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlProcessDisposePersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlProcessDisposePersistence pmlProcessDisposePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowPersistence pmlStateWorkFlowPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlTransitionPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlTransitionPersistence pmlTransitionPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFilePCCCPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFilePCCCPersistence pmlFilePCCCPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFilePCCCAttachedFilePersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFilePCCCAttachedFilePersistence pmlFilePCCCAttachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileReturningInfoPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFileReturningInfoPersistence pmlFileReturningInfoPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileStatusPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFileStatusPersistence pmlFileStatusPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessPersistence pmlFileStatusStateProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlPaintDocumentPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlPaintDocumentPersistence pmlPaintDocumentPersistence;

    public void cacheResult(PmlFilePCCC pmlFilePCCC) {
        EntityCacheUtil.putResult(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCImpl.class, pmlFilePCCC.getPrimaryKey(), pmlFilePCCC);
    }

    public void cacheResult(List<PmlFilePCCC> pmlFilePCCCs) {
        for (PmlFilePCCC pmlFilePCCC : pmlFilePCCCs) {
            if (EntityCacheUtil.getResult(
                        PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFilePCCCImpl.class, pmlFilePCCC.getPrimaryKey(), this) == null) {
                cacheResult(pmlFilePCCC);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFilePCCCImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFilePCCCImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlFilePCCC create(String fileId) {
        PmlFilePCCC pmlFilePCCC = new PmlFilePCCCImpl();

        pmlFilePCCC.setNew(true);
        pmlFilePCCC.setPrimaryKey(fileId);

        return pmlFilePCCC;
    }

    public PmlFilePCCC remove(String fileId)
        throws NoSuchPmlFilePCCCException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFilePCCC pmlFilePCCC = (PmlFilePCCC) session.get(PmlFilePCCCImpl.class,
                    fileId);

            if (pmlFilePCCC == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlFilePCCC exists with the primary key " +
                        fileId);
                }

                throw new NoSuchPmlFilePCCCException(
                    "No PmlFilePCCC exists with the primary key " + fileId);
            }

            return remove(pmlFilePCCC);
        } catch (NoSuchPmlFilePCCCException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFilePCCC remove(PmlFilePCCC pmlFilePCCC)
        throws SystemException {
        for (ModelListener<PmlFilePCCC> listener : listeners) {
            listener.onBeforeRemove(pmlFilePCCC);
        }

        pmlFilePCCC = removeImpl(pmlFilePCCC);

        for (ModelListener<PmlFilePCCC> listener : listeners) {
            listener.onAfterRemove(pmlFilePCCC);
        }

        return pmlFilePCCC;
    }

    protected PmlFilePCCC removeImpl(PmlFilePCCC pmlFilePCCC)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFilePCCC.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFilePCCCImpl.class,
                        pmlFilePCCC.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFilePCCC);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCImpl.class, pmlFilePCCC.getPrimaryKey());

        return pmlFilePCCC;
    }

    /**
     * @deprecated Use <code>update(PmlFilePCCC pmlFilePCCC, boolean merge)</code>.
     */
    public PmlFilePCCC update(PmlFilePCCC pmlFilePCCC)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFilePCCC pmlFilePCCC) method. Use update(PmlFilePCCC pmlFilePCCC, boolean merge) instead.");
        }

        return update(pmlFilePCCC, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFilePCCC the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFilePCCC is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFilePCCC update(PmlFilePCCC pmlFilePCCC, boolean merge)
        throws SystemException {
        boolean isNew = pmlFilePCCC.isNew();

        for (ModelListener<PmlFilePCCC> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFilePCCC);
            } else {
                listener.onBeforeUpdate(pmlFilePCCC);
            }
        }

        pmlFilePCCC = updateImpl(pmlFilePCCC, merge);

        for (ModelListener<PmlFilePCCC> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFilePCCC);
            } else {
                listener.onAfterUpdate(pmlFilePCCC);
            }
        }

        return pmlFilePCCC;
    }

    public PmlFilePCCC updateImpl(
        com.nss.portlet.onedoor.model.PmlFilePCCC pmlFilePCCC, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFilePCCC, merge);

            pmlFilePCCC.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCImpl.class, pmlFilePCCC.getPrimaryKey(), pmlFilePCCC);

        return pmlFilePCCC;
    }

    public PmlFilePCCC findByPrimaryKey(String fileId)
        throws NoSuchPmlFilePCCCException, SystemException {
        PmlFilePCCC pmlFilePCCC = fetchByPrimaryKey(fileId);

        if (pmlFilePCCC == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFilePCCC exists with the primary key " +
                    fileId);
            }

            throw new NoSuchPmlFilePCCCException(
                "No PmlFilePCCC exists with the primary key " + fileId);
        }

        return pmlFilePCCC;
    }

    public PmlFilePCCC fetchByPrimaryKey(String fileId)
        throws SystemException {
        PmlFilePCCC pmlFilePCCC = (PmlFilePCCC) EntityCacheUtil.getResult(PmlFilePCCCModelImpl.ENTITY_CACHE_ENABLED,
                PmlFilePCCCImpl.class, fileId, this);

        if (pmlFilePCCC == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFilePCCC = (PmlFilePCCC) session.get(PmlFilePCCCImpl.class,
                        fileId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFilePCCC != null) {
                    cacheResult(pmlFilePCCC);
                }

                closeSession(session);
            }
        }

        return pmlFilePCCC;
    }

    public List<PmlFilePCCC> findByFileName(String fileName)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileName };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (fileName == null) {
                    query.append("fileName IS NULL");
                } else {
                    query.append("fileName = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileName != null) {
                    qPos.add(fileName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCC> findByFileName(String fileName, int start, int end)
        throws SystemException {
        return findByFileName(fileName, start, end, null);
    }

    public List<PmlFilePCCC> findByFileName(String fileName, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (fileName == null) {
                    query.append("fileName IS NULL");
                } else {
                    query.append("fileName = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileName != null) {
                    qPos.add(fileName);
                }

                list = (List<PmlFilePCCC>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCC findByFileName_First(String fileName,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        List<PmlFilePCCC> list = findByFileName(fileName, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("fileName=" + fileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC findByFileName_Last(String fileName,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        int count = countByFileName(fileName);

        List<PmlFilePCCC> list = findByFileName(fileName, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("fileName=" + fileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC[] findByFileName_PrevAndNext(String fileId,
        String fileName, OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        PmlFilePCCC pmlFilePCCC = findByPrimaryKey(fileId);

        int count = countByFileName(fileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

            if (fileName == null) {
                query.append("fileName IS NULL");
            } else {
                query.append("fileName = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileName != null) {
                qPos.add(fileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCC);

            PmlFilePCCC[] array = new PmlFilePCCCImpl[3];

            array[0] = (PmlFilePCCC) objArray[0];
            array[1] = (PmlFilePCCC) objArray[1];
            array[2] = (PmlFilePCCC) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCC> findByProjectName(String projectName)
        throws SystemException {
        Object[] finderArgs = new Object[] { projectName };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PROJECTNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (projectName == null) {
                    query.append("projectname IS NULL");
                } else {
                    query.append("projectname = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (projectName != null) {
                    qPos.add(projectName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PROJECTNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCC> findByProjectName(String projectName, int start,
        int end) throws SystemException {
        return findByProjectName(projectName, start, end, null);
    }

    public List<PmlFilePCCC> findByProjectName(String projectName, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                projectName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PROJECTNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (projectName == null) {
                    query.append("projectname IS NULL");
                } else {
                    query.append("projectname = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (projectName != null) {
                    qPos.add(projectName);
                }

                list = (List<PmlFilePCCC>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PROJECTNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCC findByProjectName_First(String projectName,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        List<PmlFilePCCC> list = findByProjectName(projectName, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("projectName=" + projectName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC findByProjectName_Last(String projectName,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        int count = countByProjectName(projectName);

        List<PmlFilePCCC> list = findByProjectName(projectName, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("projectName=" + projectName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC[] findByProjectName_PrevAndNext(String fileId,
        String projectName, OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        PmlFilePCCC pmlFilePCCC = findByPrimaryKey(fileId);

        int count = countByProjectName(projectName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

            if (projectName == null) {
                query.append("projectname IS NULL");
            } else {
                query.append("projectname = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (projectName != null) {
                qPos.add(projectName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCC);

            PmlFilePCCC[] array = new PmlFilePCCCImpl[3];

            array[0] = (PmlFilePCCC) objArray[0];
            array[1] = (PmlFilePCCC) objArray[1];
            array[2] = (PmlFilePCCC) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCC> findByApplicantCategory(String applicantCategory)
        throws SystemException {
        Object[] finderArgs = new Object[] { applicantCategory };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPLICANTCATEGORY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (applicantCategory == null) {
                    query.append("applicantcategory IS NULL");
                } else {
                    query.append("applicantcategory = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantCategory != null) {
                    qPos.add(applicantCategory);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPLICANTCATEGORY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCC> findByApplicantCategory(String applicantCategory,
        int start, int end) throws SystemException {
        return findByApplicantCategory(applicantCategory, start, end, null);
    }

    public List<PmlFilePCCC> findByApplicantCategory(String applicantCategory,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                applicantCategory,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPLICANTCATEGORY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (applicantCategory == null) {
                    query.append("applicantcategory IS NULL");
                } else {
                    query.append("applicantcategory = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantCategory != null) {
                    qPos.add(applicantCategory);
                }

                list = (List<PmlFilePCCC>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPLICANTCATEGORY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCC findByApplicantCategory_First(String applicantCategory,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        List<PmlFilePCCC> list = findByApplicantCategory(applicantCategory, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("applicantCategory=" + applicantCategory);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC findByApplicantCategory_Last(String applicantCategory,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        int count = countByApplicantCategory(applicantCategory);

        List<PmlFilePCCC> list = findByApplicantCategory(applicantCategory,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("applicantCategory=" + applicantCategory);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC[] findByApplicantCategory_PrevAndNext(String fileId,
        String applicantCategory, OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        PmlFilePCCC pmlFilePCCC = findByPrimaryKey(fileId);

        int count = countByApplicantCategory(applicantCategory);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

            if (applicantCategory == null) {
                query.append("applicantcategory IS NULL");
            } else {
                query.append("applicantcategory = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (applicantCategory != null) {
                qPos.add(applicantCategory);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCC);

            PmlFilePCCC[] array = new PmlFilePCCCImpl[3];

            array[0] = (PmlFilePCCC) objArray[0];
            array[1] = (PmlFilePCCC) objArray[1];
            array[2] = (PmlFilePCCC) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCC> findByReceiveOfUnit(String receiveOfUnit)
        throws SystemException {
        Object[] finderArgs = new Object[] { receiveOfUnit };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVEOFUNIT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (receiveOfUnit == null) {
                    query.append("receiveofunit IS NULL");
                } else {
                    query.append("receiveofunit = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveOfUnit != null) {
                    qPos.add(receiveOfUnit);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVEOFUNIT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCC> findByReceiveOfUnit(String receiveOfUnit,
        int start, int end) throws SystemException {
        return findByReceiveOfUnit(receiveOfUnit, start, end, null);
    }

    public List<PmlFilePCCC> findByReceiveOfUnit(String receiveOfUnit,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                receiveOfUnit,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVEOFUNIT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (receiveOfUnit == null) {
                    query.append("receiveofunit IS NULL");
                } else {
                    query.append("receiveofunit = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveOfUnit != null) {
                    qPos.add(receiveOfUnit);
                }

                list = (List<PmlFilePCCC>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVEOFUNIT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCC findByReceiveOfUnit_First(String receiveOfUnit,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        List<PmlFilePCCC> list = findByReceiveOfUnit(receiveOfUnit, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("receiveOfUnit=" + receiveOfUnit);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC findByReceiveOfUnit_Last(String receiveOfUnit,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        int count = countByReceiveOfUnit(receiveOfUnit);

        List<PmlFilePCCC> list = findByReceiveOfUnit(receiveOfUnit, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("receiveOfUnit=" + receiveOfUnit);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC[] findByReceiveOfUnit_PrevAndNext(String fileId,
        String receiveOfUnit, OrderByComparator obc)
        throws NoSuchPmlFilePCCCException, SystemException {
        PmlFilePCCC pmlFilePCCC = findByPrimaryKey(fileId);

        int count = countByReceiveOfUnit(receiveOfUnit);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

            if (receiveOfUnit == null) {
                query.append("receiveofunit IS NULL");
            } else {
                query.append("receiveofunit = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiveOfUnit != null) {
                qPos.add(receiveOfUnit);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCC);

            PmlFilePCCC[] array = new PmlFilePCCCImpl[3];

            array[0] = (PmlFilePCCC) objArray[0];
            array[1] = (PmlFilePCCC) objArray[1];
            array[2] = (PmlFilePCCC) objArray[2];

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

    public List<PmlFilePCCC> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFilePCCC> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFilePCCC> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCC> list = (List<PmlFilePCCC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.onedoor.model.PmlFilePCCC ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFilePCCC>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFilePCCC>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileName(String fileName) throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findByFileName(fileName)) {
            remove(pmlFilePCCC);
        }
    }

    public void removeByProjectName(String projectName)
        throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findByProjectName(projectName)) {
            remove(pmlFilePCCC);
        }
    }

    public void removeByApplicantCategory(String applicantCategory)
        throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findByApplicantCategory(
                applicantCategory)) {
            remove(pmlFilePCCC);
        }
    }

    public void removeByReceiveOfUnit(String receiveOfUnit)
        throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findByReceiveOfUnit(receiveOfUnit)) {
            remove(pmlFilePCCC);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findAll()) {
            remove(pmlFilePCCC);
        }
    }

    public int countByFileName(String fileName) throws SystemException {
        Object[] finderArgs = new Object[] { fileName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILENAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (fileName == null) {
                    query.append("fileName IS NULL");
                } else {
                    query.append("fileName = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileName != null) {
                    qPos.add(fileName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILENAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByProjectName(String projectName) throws SystemException {
        Object[] finderArgs = new Object[] { projectName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROJECTNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (projectName == null) {
                    query.append("projectname IS NULL");
                } else {
                    query.append("projectname = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (projectName != null) {
                    qPos.add(projectName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROJECTNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByApplicantCategory(String applicantCategory)
        throws SystemException {
        Object[] finderArgs = new Object[] { applicantCategory };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPLICANTCATEGORY,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (applicantCategory == null) {
                    query.append("applicantcategory IS NULL");
                } else {
                    query.append("applicantcategory = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantCategory != null) {
                    qPos.add(applicantCategory);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICANTCATEGORY,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceiveOfUnit(String receiveOfUnit)
        throws SystemException {
        Object[] finderArgs = new Object[] { receiveOfUnit };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVEOFUNIT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCC WHERE ");

                if (receiveOfUnit == null) {
                    query.append("receiveofunit IS NULL");
                } else {
                    query.append("receiveofunit = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveOfUnit != null) {
                    qPos.add(receiveOfUnit);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVEOFUNIT,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlFilePCCC");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlFilePCCC")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFilePCCC>> listenersList = new ArrayList<ModelListener<PmlFilePCCC>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFilePCCC>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
