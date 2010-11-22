package com.nss.portlet.image_signer.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.image_signer.NoSuchImageSignerException;
import com.nss.portlet.image_signer.model.ImageSigner;
import com.nss.portlet.image_signer.model.impl.ImageSignerImpl;
import com.nss.portlet.image_signer.model.impl.ImageSignerModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ImageSignerPersistenceImpl extends BasePersistenceImpl
    implements ImageSignerPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = ImageSignerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ImageSignerModelImpl.ENTITY_CACHE_ENABLED,
            ImageSignerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImageSignerModelImpl.ENTITY_CACHE_ENABLED,
            ImageSignerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(ImageSignerPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.image_signer.service.persistence.ImageSignerPersistence.impl")
    protected com.nss.portlet.image_signer.service.persistence.ImageSignerPersistence imageSignerPersistence;

    public void cacheResult(ImageSigner imageSigner) {
        EntityCacheUtil.putResult(ImageSignerModelImpl.ENTITY_CACHE_ENABLED,
            ImageSignerImpl.class, imageSigner.getPrimaryKey(), imageSigner);
    }

    public void cacheResult(List<ImageSigner> imageSigners) {
        for (ImageSigner imageSigner : imageSigners) {
            if (EntityCacheUtil.getResult(
                        ImageSignerModelImpl.ENTITY_CACHE_ENABLED,
                        ImageSignerImpl.class, imageSigner.getPrimaryKey(), this) == null) {
                cacheResult(imageSigner);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(ImageSignerImpl.class.getName());
        EntityCacheUtil.clearCache(ImageSignerImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public ImageSigner create(long imageSignerId) {
        ImageSigner imageSigner = new ImageSignerImpl();

        imageSigner.setNew(true);
        imageSigner.setPrimaryKey(imageSignerId);

        return imageSigner;
    }

    public ImageSigner remove(long imageSignerId)
        throws NoSuchImageSignerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ImageSigner imageSigner = (ImageSigner) session.get(ImageSignerImpl.class,
                    new Long(imageSignerId));

            if (imageSigner == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No ImageSigner exists with the primary key " +
                        imageSignerId);
                }

                throw new NoSuchImageSignerException(
                    "No ImageSigner exists with the primary key " +
                    imageSignerId);
            }

            return remove(imageSigner);
        } catch (NoSuchImageSignerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ImageSigner remove(ImageSigner imageSigner)
        throws SystemException {
        for (ModelListener<ImageSigner> listener : listeners) {
            listener.onBeforeRemove(imageSigner);
        }

        imageSigner = removeImpl(imageSigner);

        for (ModelListener<ImageSigner> listener : listeners) {
            listener.onAfterRemove(imageSigner);
        }

        return imageSigner;
    }

    protected ImageSigner removeImpl(ImageSigner imageSigner)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (imageSigner.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(ImageSignerImpl.class,
                        imageSigner.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(imageSigner);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(ImageSignerModelImpl.ENTITY_CACHE_ENABLED,
            ImageSignerImpl.class, imageSigner.getPrimaryKey());

        return imageSigner;
    }

    /**
     * @deprecated Use <code>update(ImageSigner imageSigner, boolean merge)</code>.
     */
    public ImageSigner update(ImageSigner imageSigner)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ImageSigner imageSigner) method. Use update(ImageSigner imageSigner, boolean merge) instead.");
        }

        return update(imageSigner, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                imageSigner the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when imageSigner is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ImageSigner update(ImageSigner imageSigner, boolean merge)
        throws SystemException {
        boolean isNew = imageSigner.isNew();

        for (ModelListener<ImageSigner> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(imageSigner);
            } else {
                listener.onBeforeUpdate(imageSigner);
            }
        }

        imageSigner = updateImpl(imageSigner, merge);

        for (ModelListener<ImageSigner> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(imageSigner);
            } else {
                listener.onAfterUpdate(imageSigner);
            }
        }

        return imageSigner;
    }

    public ImageSigner updateImpl(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, imageSigner, merge);

            imageSigner.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(ImageSignerModelImpl.ENTITY_CACHE_ENABLED,
            ImageSignerImpl.class, imageSigner.getPrimaryKey(), imageSigner);

        return imageSigner;
    }

    public ImageSigner findByPrimaryKey(long imageSignerId)
        throws NoSuchImageSignerException, SystemException {
        ImageSigner imageSigner = fetchByPrimaryKey(imageSignerId);

        if (imageSigner == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ImageSigner exists with the primary key " +
                    imageSignerId);
            }

            throw new NoSuchImageSignerException(
                "No ImageSigner exists with the primary key " + imageSignerId);
        }

        return imageSigner;
    }

    public ImageSigner fetchByPrimaryKey(long imageSignerId)
        throws SystemException {
        ImageSigner imageSigner = (ImageSigner) EntityCacheUtil.getResult(ImageSignerModelImpl.ENTITY_CACHE_ENABLED,
                ImageSignerImpl.class, imageSignerId, this);

        if (imageSigner == null) {
            Session session = null;

            try {
                session = openSession();

                imageSigner = (ImageSigner) session.get(ImageSignerImpl.class,
                        new Long(imageSignerId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (imageSigner != null) {
                    cacheResult(imageSigner);
                }

                closeSession(session);
            }
        }

        return imageSigner;
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

    public List<ImageSigner> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ImageSigner> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ImageSigner> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ImageSigner> list = (List<ImageSigner>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.image_signer.model.ImageSigner ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<ImageSigner>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ImageSigner>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ImageSigner>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeAll() throws SystemException {
        for (ImageSigner imageSigner : findAll()) {
            remove(imageSigner);
        }
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
                        "SELECT COUNT(*) FROM com.nss.portlet.image_signer.model.ImageSigner");

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
                        "value.object.listener.com.nss.portlet.image_signer.model.ImageSigner")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ImageSigner>> listenersList = new ArrayList<ModelListener<ImageSigner>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ImageSigner>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
