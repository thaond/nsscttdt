package com.nss.portlet.qa_phan_quyen.service.persistence;

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

import com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;
import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen;
import com.nss.portlet.qa_phan_quyen.model.impl.QAPhanQuyenImpl;
import com.nss.portlet.qa_phan_quyen.model.impl.QAPhanQuyenModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QAPhanQuyenPersistenceImpl extends BasePersistenceImpl
    implements QAPhanQuyenPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = QAPhanQuyenImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_MACHUDECAUHOI = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBymaChuDeCauHoi", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBymaChuDeCauHoi",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACHUDECAUHOI = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countBymaChuDeCauHoi", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MANGUOITRALOI = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBymaNguoiTraLoi", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBymaNguoiTraLoi",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MANGUOITRALOI = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countBymaNguoiTraLoi", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MACHUDECAUHOI_MANGUOITRALOI =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaChuDeCauHoi_MaNguoiTraLoi",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI_MANGUOITRALOI =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaChuDeCauHoi_MaNguoiTraLoi",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACHUDECAUHOI_MANGUOITRALOI =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaChuDeCauHoi_MaNguoiTraLoi",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENXEM = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaNguoiTraLoi_QuyenXem",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENXEM =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaNguoiTraLoi_QuyenXem",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENXEM = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaNguoiTraLoi_QuyenXem",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENCAPNHAT =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaNguoiTraLoi_QuyenCapNhat",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENCAPNHAT =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaNguoiTraLoi_QuyenCapNhat",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENCAPNHAT =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaNguoiTraLoi_QuyenCapNhat",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENTRALOI =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaNguoiTraLoi_QuyenTraloi",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENTRALOI =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaNguoiTraLoi_QuyenTraloi",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENTRALOI =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaNguoiTraLoi_QuyenTraloi",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENDUYET = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaNguoiTraLoi_QuyenDuyet",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENDUYET =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaNguoiTraLoi_QuyenDuyet",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENDUYET =
        new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaNguoiTraLoi_QuyenDuyet",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(QAPhanQuyenPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.qa_phan_quyen.service.persistence.QAPhanQuyenPersistence.impl")
    protected com.nss.portlet.qa_phan_quyen.service.persistence.QAPhanQuyenPersistence qaPhanQuyenPersistence;

    public void cacheResult(QAPhanQuyen qaPhanQuyen) {
        EntityCacheUtil.putResult(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenImpl.class, qaPhanQuyen.getPrimaryKey(), qaPhanQuyen);
    }

    public void cacheResult(List<QAPhanQuyen> qaPhanQuyens) {
        for (QAPhanQuyen qaPhanQuyen : qaPhanQuyens) {
            if (EntityCacheUtil.getResult(
                        QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
                        QAPhanQuyenImpl.class, qaPhanQuyen.getPrimaryKey(), this) == null) {
                cacheResult(qaPhanQuyen);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(QAPhanQuyenImpl.class.getName());
        EntityCacheUtil.clearCache(QAPhanQuyenImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public QAPhanQuyen create(long maPhanQuyen) {
        QAPhanQuyen qaPhanQuyen = new QAPhanQuyenImpl();

        qaPhanQuyen.setNew(true);
        qaPhanQuyen.setPrimaryKey(maPhanQuyen);

        return qaPhanQuyen;
    }

    public QAPhanQuyen remove(long maPhanQuyen)
        throws NoSuchQAPhanQuyenException, SystemException {
        Session session = null;

        try {
            session = openSession();

            QAPhanQuyen qaPhanQuyen = (QAPhanQuyen) session.get(QAPhanQuyenImpl.class,
                    new Long(maPhanQuyen));

            if (qaPhanQuyen == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No QAPhanQuyen exists with the primary key " +
                        maPhanQuyen);
                }

                throw new NoSuchQAPhanQuyenException(
                    "No QAPhanQuyen exists with the primary key " +
                    maPhanQuyen);
            }

            return remove(qaPhanQuyen);
        } catch (NoSuchQAPhanQuyenException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public QAPhanQuyen remove(QAPhanQuyen qaPhanQuyen)
        throws SystemException {
        for (ModelListener<QAPhanQuyen> listener : listeners) {
            listener.onBeforeRemove(qaPhanQuyen);
        }

        qaPhanQuyen = removeImpl(qaPhanQuyen);

        for (ModelListener<QAPhanQuyen> listener : listeners) {
            listener.onAfterRemove(qaPhanQuyen);
        }

        return qaPhanQuyen;
    }

    protected QAPhanQuyen removeImpl(QAPhanQuyen qaPhanQuyen)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (qaPhanQuyen.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(QAPhanQuyenImpl.class,
                        qaPhanQuyen.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(qaPhanQuyen);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenImpl.class, qaPhanQuyen.getPrimaryKey());

        return qaPhanQuyen;
    }

    /**
     * @deprecated Use <code>update(QAPhanQuyen qaPhanQuyen, boolean merge)</code>.
     */
    public QAPhanQuyen update(QAPhanQuyen qaPhanQuyen)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(QAPhanQuyen qaPhanQuyen) method. Use update(QAPhanQuyen qaPhanQuyen, boolean merge) instead.");
        }

        return update(qaPhanQuyen, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                qaPhanQuyen the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when qaPhanQuyen is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public QAPhanQuyen update(QAPhanQuyen qaPhanQuyen, boolean merge)
        throws SystemException {
        boolean isNew = qaPhanQuyen.isNew();

        for (ModelListener<QAPhanQuyen> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(qaPhanQuyen);
            } else {
                listener.onBeforeUpdate(qaPhanQuyen);
            }
        }

        qaPhanQuyen = updateImpl(qaPhanQuyen, merge);

        for (ModelListener<QAPhanQuyen> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(qaPhanQuyen);
            } else {
                listener.onAfterUpdate(qaPhanQuyen);
            }
        }

        return qaPhanQuyen;
    }

    public QAPhanQuyen updateImpl(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, qaPhanQuyen, merge);

            qaPhanQuyen.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
            QAPhanQuyenImpl.class, qaPhanQuyen.getPrimaryKey(), qaPhanQuyen);

        return qaPhanQuyen;
    }

    public QAPhanQuyen findByPrimaryKey(long maPhanQuyen)
        throws NoSuchQAPhanQuyenException, SystemException {
        QAPhanQuyen qaPhanQuyen = fetchByPrimaryKey(maPhanQuyen);

        if (qaPhanQuyen == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No QAPhanQuyen exists with the primary key " +
                    maPhanQuyen);
            }

            throw new NoSuchQAPhanQuyenException(
                "No QAPhanQuyen exists with the primary key " + maPhanQuyen);
        }

        return qaPhanQuyen;
    }

    public QAPhanQuyen fetchByPrimaryKey(long maPhanQuyen)
        throws SystemException {
        QAPhanQuyen qaPhanQuyen = (QAPhanQuyen) EntityCacheUtil.getResult(QAPhanQuyenModelImpl.ENTITY_CACHE_ENABLED,
                QAPhanQuyenImpl.class, maPhanQuyen, this);

        if (qaPhanQuyen == null) {
            Session session = null;

            try {
                session = openSession();

                qaPhanQuyen = (QAPhanQuyen) session.get(QAPhanQuyenImpl.class,
                        new Long(maPhanQuyen));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (qaPhanQuyen != null) {
                    cacheResult(qaPhanQuyen);
                }

                closeSession(session);
            }
        }

        return qaPhanQuyen;
    }

    public List<QAPhanQuyen> findBymaChuDeCauHoi(long maChuDeCauHoi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maChuDeCauHoi) };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACHUDECAUHOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACHUDECAUHOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QAPhanQuyen> findBymaChuDeCauHoi(long maChuDeCauHoi, int start,
        int end) throws SystemException {
        return findBymaChuDeCauHoi(maChuDeCauHoi, start, end, null);
    }

    public List<QAPhanQuyen> findBymaChuDeCauHoi(long maChuDeCauHoi, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maChuDeCauHoi),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QAPhanQuyen findBymaChuDeCauHoi_First(long maChuDeCauHoi,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        List<QAPhanQuyen> list = findBymaChuDeCauHoi(maChuDeCauHoi, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maChuDeCauHoi=" + maChuDeCauHoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen findBymaChuDeCauHoi_Last(long maChuDeCauHoi,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        int count = countBymaChuDeCauHoi(maChuDeCauHoi);

        List<QAPhanQuyen> list = findBymaChuDeCauHoi(maChuDeCauHoi, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maChuDeCauHoi=" + maChuDeCauHoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen[] findBymaChuDeCauHoi_PrevAndNext(long maPhanQuyen,
        long maChuDeCauHoi, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        QAPhanQuyen qaPhanQuyen = findByPrimaryKey(maPhanQuyen);

        int count = countBymaChuDeCauHoi(maChuDeCauHoi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

            query.append("maChuDeCauHoi = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maChuDeCauHoi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    qaPhanQuyen);

            QAPhanQuyen[] array = new QAPhanQuyenImpl[3];

            array[0] = (QAPhanQuyen) objArray[0];
            array[1] = (QAPhanQuyen) objArray[1];
            array[2] = (QAPhanQuyen) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<QAPhanQuyen> findBymaNguoiTraLoi(long maNguoiTraLoi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maNguoiTraLoi) };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MANGUOITRALOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MANGUOITRALOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QAPhanQuyen> findBymaNguoiTraLoi(long maNguoiTraLoi, int start,
        int end) throws SystemException {
        return findBymaNguoiTraLoi(maNguoiTraLoi, start, end, null);
    }

    public List<QAPhanQuyen> findBymaNguoiTraLoi(long maNguoiTraLoi, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QAPhanQuyen findBymaNguoiTraLoi_First(long maNguoiTraLoi,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        List<QAPhanQuyen> list = findBymaNguoiTraLoi(maNguoiTraLoi, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen findBymaNguoiTraLoi_Last(long maNguoiTraLoi,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        int count = countBymaNguoiTraLoi(maNguoiTraLoi);

        List<QAPhanQuyen> list = findBymaNguoiTraLoi(maNguoiTraLoi, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen[] findBymaNguoiTraLoi_PrevAndNext(long maPhanQuyen,
        long maNguoiTraLoi, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        QAPhanQuyen qaPhanQuyen = findByPrimaryKey(maPhanQuyen);

        int count = countBymaNguoiTraLoi(maNguoiTraLoi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

            query.append("maNguoiTraLoi = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maNguoiTraLoi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    qaPhanQuyen);

            QAPhanQuyen[] array = new QAPhanQuyenImpl[3];

            array[0] = (QAPhanQuyen) objArray[0];
            array[1] = (QAPhanQuyen) objArray[1];
            array[2] = (QAPhanQuyen) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maChuDeCauHoi), new Long(maNguoiTraLoi)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACHUDECAUHOI_MANGUOITRALOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" AND ");

                query.append("maNguoiTraLoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                qPos.add(maNguoiTraLoi);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACHUDECAUHOI_MANGUOITRALOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi, int start, int end)
        throws SystemException {
        return findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi, maNguoiTraLoi,
            start, end, null);
    }

    public List<QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maChuDeCauHoi), new Long(maNguoiTraLoi),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI_MANGUOITRALOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" AND ");

                query.append("maNguoiTraLoi = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                qPos.add(maNguoiTraLoi);

                list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI_MANGUOITRALOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi_First(
        long maChuDeCauHoi, long maNguoiTraLoi, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        List<QAPhanQuyen> list = findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
                maNguoiTraLoi, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maChuDeCauHoi=" + maChuDeCauHoi);

            msg.append(", ");
            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi_Last(
        long maChuDeCauHoi, long maNguoiTraLoi, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        int count = countByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
                maNguoiTraLoi);

        List<QAPhanQuyen> list = findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
                maNguoiTraLoi, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maChuDeCauHoi=" + maChuDeCauHoi);

            msg.append(", ");
            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen[] findByMaChuDeCauHoi_MaNguoiTraLoi_PrevAndNext(
        long maPhanQuyen, long maChuDeCauHoi, long maNguoiTraLoi,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        QAPhanQuyen qaPhanQuyen = findByPrimaryKey(maPhanQuyen);

        int count = countByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
                maNguoiTraLoi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

            query.append("maChuDeCauHoi = ?");

            query.append(" AND ");

            query.append("maNguoiTraLoi = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maChuDeCauHoi);

            qPos.add(maNguoiTraLoi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    qaPhanQuyen);

            QAPhanQuyen[] array = new QAPhanQuyenImpl[3];

            array[0] = (QAPhanQuyen) objArray[0];
            array[1] = (QAPhanQuyen) objArray[1];
            array[2] = (QAPhanQuyen) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenXem)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENXEM,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenXem = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenXem);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENXEM,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem, int start, int end) throws SystemException {
        return findByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, quyenXem, start,
            end, null);
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenXem),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENXEM,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenXem = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenXem);

                list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENXEM,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QAPhanQuyen findByMaNguoiTraLoi_QuyenXem_First(long maNguoiTraLoi,
        boolean quyenXem, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        List<QAPhanQuyen> list = findByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi,
                quyenXem, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(", ");
            msg.append("quyenXem=" + quyenXem);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen findByMaNguoiTraLoi_QuyenXem_Last(long maNguoiTraLoi,
        boolean quyenXem, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        int count = countByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, quyenXem);

        List<QAPhanQuyen> list = findByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi,
                quyenXem, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(", ");
            msg.append("quyenXem=" + quyenXem);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen[] findByMaNguoiTraLoi_QuyenXem_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenXem,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        QAPhanQuyen qaPhanQuyen = findByPrimaryKey(maPhanQuyen);

        int count = countByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, quyenXem);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

            query.append("maNguoiTraLoi = ?");

            query.append(" AND ");

            query.append("quyenXem = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maNguoiTraLoi);

            qPos.add(quyenXem);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    qaPhanQuyen);

            QAPhanQuyen[] array = new QAPhanQuyenImpl[3];

            array[0] = (QAPhanQuyen) objArray[0];
            array[1] = (QAPhanQuyen) objArray[1];
            array[2] = (QAPhanQuyen) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenCapNhat)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENCAPNHAT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenCapNhat = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenCapNhat);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENCAPNHAT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat, int start, int end)
        throws SystemException {
        return findByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi, quyenCapNhat,
            start, end, null);
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenCapNhat),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENCAPNHAT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenCapNhat = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenCapNhat);

                list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENCAPNHAT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QAPhanQuyen findByMaNguoiTraLoi_QuyenCapNhat_First(
        long maNguoiTraLoi, boolean quyenCapNhat, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        List<QAPhanQuyen> list = findByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi,
                quyenCapNhat, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(", ");
            msg.append("quyenCapNhat=" + quyenCapNhat);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen findByMaNguoiTraLoi_QuyenCapNhat_Last(
        long maNguoiTraLoi, boolean quyenCapNhat, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        int count = countByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi,
                quyenCapNhat);

        List<QAPhanQuyen> list = findByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi,
                quyenCapNhat, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(", ");
            msg.append("quyenCapNhat=" + quyenCapNhat);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen[] findByMaNguoiTraLoi_QuyenCapNhat_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenCapNhat,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        QAPhanQuyen qaPhanQuyen = findByPrimaryKey(maPhanQuyen);

        int count = countByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi,
                quyenCapNhat);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

            query.append("maNguoiTraLoi = ?");

            query.append(" AND ");

            query.append("quyenCapNhat = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maNguoiTraLoi);

            qPos.add(quyenCapNhat);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    qaPhanQuyen);

            QAPhanQuyen[] array = new QAPhanQuyenImpl[3];

            array[0] = (QAPhanQuyen) objArray[0];
            array[1] = (QAPhanQuyen) objArray[1];
            array[2] = (QAPhanQuyen) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenTraLoi)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENTRALOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenTraLoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenTraLoi);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENTRALOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi, int start, int end)
        throws SystemException {
        return findByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi, quyenTraLoi,
            start, end, null);
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenTraLoi),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENTRALOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenTraLoi = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenTraLoi);

                list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENTRALOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QAPhanQuyen findByMaNguoiTraLoi_QuyenTraloi_First(
        long maNguoiTraLoi, boolean quyenTraLoi, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        List<QAPhanQuyen> list = findByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi,
                quyenTraLoi, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(", ");
            msg.append("quyenTraLoi=" + quyenTraLoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen findByMaNguoiTraLoi_QuyenTraloi_Last(
        long maNguoiTraLoi, boolean quyenTraLoi, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        int count = countByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi, quyenTraLoi);

        List<QAPhanQuyen> list = findByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi,
                quyenTraLoi, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(", ");
            msg.append("quyenTraLoi=" + quyenTraLoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen[] findByMaNguoiTraLoi_QuyenTraloi_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenTraLoi,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        QAPhanQuyen qaPhanQuyen = findByPrimaryKey(maPhanQuyen);

        int count = countByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi, quyenTraLoi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

            query.append("maNguoiTraLoi = ?");

            query.append(" AND ");

            query.append("quyenTraLoi = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maNguoiTraLoi);

            qPos.add(quyenTraLoi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    qaPhanQuyen);

            QAPhanQuyen[] array = new QAPhanQuyenImpl[3];

            array[0] = (QAPhanQuyen) objArray[0];
            array[1] = (QAPhanQuyen) objArray[1];
            array[2] = (QAPhanQuyen) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenDuyet)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENDUYET,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenDuyet = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenDuyet);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MANGUOITRALOI_QUYENDUYET,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet, int start, int end)
        throws SystemException {
        return findByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi, quyenDuyet, start,
            end, null);
    }

    public List<QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenDuyet),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENDUYET,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenDuyet = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenDuyet);

                list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MANGUOITRALOI_QUYENDUYET,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QAPhanQuyen findByMaNguoiTraLoi_QuyenDuyet_First(
        long maNguoiTraLoi, boolean quyenDuyet, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        List<QAPhanQuyen> list = findByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi,
                quyenDuyet, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(", ");
            msg.append("quyenDuyet=" + quyenDuyet);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen findByMaNguoiTraLoi_QuyenDuyet_Last(long maNguoiTraLoi,
        boolean quyenDuyet, OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        int count = countByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi, quyenDuyet);

        List<QAPhanQuyen> list = findByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi,
                quyenDuyet, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAPhanQuyen exists with the key {");

            msg.append("maNguoiTraLoi=" + maNguoiTraLoi);

            msg.append(", ");
            msg.append("quyenDuyet=" + quyenDuyet);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAPhanQuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAPhanQuyen[] findByMaNguoiTraLoi_QuyenDuyet_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenDuyet,
        OrderByComparator obc)
        throws NoSuchQAPhanQuyenException, SystemException {
        QAPhanQuyen qaPhanQuyen = findByPrimaryKey(maPhanQuyen);

        int count = countByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi, quyenDuyet);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

            query.append("maNguoiTraLoi = ?");

            query.append(" AND ");

            query.append("quyenDuyet = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maNguoiTraLoi);

            qPos.add(quyenDuyet);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    qaPhanQuyen);

            QAPhanQuyen[] array = new QAPhanQuyenImpl[3];

            array[0] = (QAPhanQuyen) objArray[0];
            array[1] = (QAPhanQuyen) objArray[1];
            array[2] = (QAPhanQuyen) objArray[2];

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

    public List<QAPhanQuyen> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<QAPhanQuyen> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<QAPhanQuyen> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAPhanQuyen> list = (List<QAPhanQuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<QAPhanQuyen>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAPhanQuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeBymaChuDeCauHoi(long maChuDeCauHoi)
        throws SystemException {
        for (QAPhanQuyen qaPhanQuyen : findBymaChuDeCauHoi(maChuDeCauHoi)) {
            remove(qaPhanQuyen);
        }
    }

    public void removeBymaNguoiTraLoi(long maNguoiTraLoi)
        throws SystemException {
        for (QAPhanQuyen qaPhanQuyen : findBymaNguoiTraLoi(maNguoiTraLoi)) {
            remove(qaPhanQuyen);
        }
    }

    public void removeByMaChuDeCauHoi_MaNguoiTraLoi(long maChuDeCauHoi,
        long maNguoiTraLoi) throws SystemException {
        for (QAPhanQuyen qaPhanQuyen : findByMaChuDeCauHoi_MaNguoiTraLoi(
                maChuDeCauHoi, maNguoiTraLoi)) {
            remove(qaPhanQuyen);
        }
    }

    public void removeByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem) throws SystemException {
        for (QAPhanQuyen qaPhanQuyen : findByMaNguoiTraLoi_QuyenXem(
                maNguoiTraLoi, quyenXem)) {
            remove(qaPhanQuyen);
        }
    }

    public void removeByMaNguoiTraLoi_QuyenCapNhat(long maNguoiTraLoi,
        boolean quyenCapNhat) throws SystemException {
        for (QAPhanQuyen qaPhanQuyen : findByMaNguoiTraLoi_QuyenCapNhat(
                maNguoiTraLoi, quyenCapNhat)) {
            remove(qaPhanQuyen);
        }
    }

    public void removeByMaNguoiTraLoi_QuyenTraloi(long maNguoiTraLoi,
        boolean quyenTraLoi) throws SystemException {
        for (QAPhanQuyen qaPhanQuyen : findByMaNguoiTraLoi_QuyenTraloi(
                maNguoiTraLoi, quyenTraLoi)) {
            remove(qaPhanQuyen);
        }
    }

    public void removeByMaNguoiTraLoi_QuyenDuyet(long maNguoiTraLoi,
        boolean quyenDuyet) throws SystemException {
        for (QAPhanQuyen qaPhanQuyen : findByMaNguoiTraLoi_QuyenDuyet(
                maNguoiTraLoi, quyenDuyet)) {
            remove(qaPhanQuyen);
        }
    }

    public void removeAll() throws SystemException {
        for (QAPhanQuyen qaPhanQuyen : findAll()) {
            remove(qaPhanQuyen);
        }
    }

    public int countBymaChuDeCauHoi(long maChuDeCauHoi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maChuDeCauHoi) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACHUDECAUHOI,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACHUDECAUHOI,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countBymaNguoiTraLoi(long maNguoiTraLoi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maNguoiTraLoi) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaChuDeCauHoi_MaNguoiTraLoi(long maChuDeCauHoi,
        long maNguoiTraLoi) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maChuDeCauHoi), new Long(maNguoiTraLoi)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACHUDECAUHOI_MANGUOITRALOI,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" AND ");

                query.append("maNguoiTraLoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                qPos.add(maNguoiTraLoi);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACHUDECAUHOI_MANGUOITRALOI,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenXem)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENXEM,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenXem = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenXem);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENXEM,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaNguoiTraLoi_QuyenCapNhat(long maNguoiTraLoi,
        boolean quyenCapNhat) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenCapNhat)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENCAPNHAT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenCapNhat = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenCapNhat);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENCAPNHAT,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaNguoiTraLoi_QuyenTraloi(long maNguoiTraLoi,
        boolean quyenTraLoi) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenTraLoi)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENTRALOI,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenTraLoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenTraLoi);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENTRALOI,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaNguoiTraLoi_QuyenDuyet(long maNguoiTraLoi,
        boolean quyenDuyet) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maNguoiTraLoi), Boolean.valueOf(quyenDuyet)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENDUYET,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen WHERE ");

                query.append("maNguoiTraLoi = ?");

                query.append(" AND ");

                query.append("quyenDuyet = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maNguoiTraLoi);

                qPos.add(quyenDuyet);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MANGUOITRALOI_QUYENDUYET,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen");

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
                        "value.object.listener.com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<QAPhanQuyen>> listenersList = new ArrayList<ModelListener<QAPhanQuyen>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<QAPhanQuyen>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
