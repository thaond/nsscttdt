package com.sgs.portlet.onedoorpccc.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.onedoorpccc.NoSuchPmlFileReturningInfoException;
import com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo;
import com.sgs.portlet.onedoorpccc.model.impl.PmlFileReturningInfoImpl;
import com.sgs.portlet.onedoorpccc.model.impl.PmlFileReturningInfoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlFileReturningInfoPersistenceImpl extends BasePersistenceImpl
    implements PmlFileReturningInfoPersistence {
    private static Log _log = LogFactory.getLog(PmlFileReturningInfoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFileReturningInfo create(long fileReturningInfoId) {
        PmlFileReturningInfo pmlFileReturningInfo = new PmlFileReturningInfoImpl();

        pmlFileReturningInfo.setNew(true);
        pmlFileReturningInfo.setPrimaryKey(fileReturningInfoId);

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo remove(long fileReturningInfoId)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileReturningInfo pmlFileReturningInfo = (PmlFileReturningInfo) session.get(PmlFileReturningInfoImpl.class,
                    new Long(fileReturningInfoId));

            if (pmlFileReturningInfo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileReturningInfo exists with the primary key " +
                        fileReturningInfoId);
                }

                throw new NoSuchPmlFileReturningInfoException(
                    "No PmlFileReturningInfo exists with the primary key " +
                    fileReturningInfoId);
            }

            return remove(pmlFileReturningInfo);
        } catch (NoSuchPmlFileReturningInfoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileReturningInfo remove(
        PmlFileReturningInfo pmlFileReturningInfo) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFileReturningInfo);
            }
        }

        pmlFileReturningInfo = removeImpl(pmlFileReturningInfo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFileReturningInfo);
            }
        }

        return pmlFileReturningInfo;
    }

    protected PmlFileReturningInfo removeImpl(
        PmlFileReturningInfo pmlFileReturningInfo) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFileReturningInfo);

            session.flush();

            return pmlFileReturningInfo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileReturningInfo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFileReturningInfo pmlFileReturningInfo, boolean merge)</code>.
     */
    public PmlFileReturningInfo update(
        PmlFileReturningInfo pmlFileReturningInfo) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileReturningInfo pmlFileReturningInfo) method. Use update(PmlFileReturningInfo pmlFileReturningInfo, boolean merge) instead.");
        }

        return update(pmlFileReturningInfo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileReturningInfo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileReturningInfo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileReturningInfo update(
        PmlFileReturningInfo pmlFileReturningInfo, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileReturningInfo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFileReturningInfo);
                } else {
                    listener.onBeforeUpdate(pmlFileReturningInfo);
                }
            }
        }

        pmlFileReturningInfo = updateImpl(pmlFileReturningInfo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFileReturningInfo);
                } else {
                    listener.onAfterUpdate(pmlFileReturningInfo);
                }
            }
        }

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo pmlFileReturningInfo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFileReturningInfo);
            } else {
                if (pmlFileReturningInfo.isNew()) {
                    session.save(pmlFileReturningInfo);
                }
            }

            session.flush();

            pmlFileReturningInfo.setNew(false);

            return pmlFileReturningInfo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileReturningInfo.class.getName());
        }
    }

    public PmlFileReturningInfo findByPrimaryKey(long fileReturningInfoId)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = fetchByPrimaryKey(fileReturningInfoId);

        if (pmlFileReturningInfo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlFileReturningInfo exists with the primary key " +
                    fileReturningInfoId);
            }

            throw new NoSuchPmlFileReturningInfoException(
                "No PmlFileReturningInfo exists with the primary key " +
                fileReturningInfoId);
        }

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo fetchByPrimaryKey(long fileReturningInfoId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFileReturningInfo) session.get(PmlFileReturningInfoImpl.class,
                new Long(fileReturningInfoId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByFileId(String fileId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileId };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByFileId(String fileId, int start,
        int end) throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlFileReturningInfo> findByFileId(String fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileId,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByFileId_First(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByFileId(fileId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByFileId_Last(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByFileId(fileId);

        List<PmlFileReturningInfo> list = findByFileId(fileId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByFileId_PrevAndNext(
        long fileReturningInfoId, String fileId, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (fileId == null) {
                query.append("fileid LIKE null");
            } else {
                query.append("fileid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByFileSender(String fileSender)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByFileSender";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileSender };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (fileSender == null) {
                    query.append("filesender LIKE null");
                } else {
                    query.append("filesender LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileSender != null) {
                    qPos.add(fileSender);
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByFileSender(String fileSender,
        int start, int end) throws SystemException {
        return findByFileSender(fileSender, start, end, null);
    }

    public List<PmlFileReturningInfo> findByFileSender(String fileSender,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByFileSender";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileSender,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (fileSender == null) {
                    query.append("filesender LIKE null");
                } else {
                    query.append("filesender LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileSender != null) {
                    qPos.add(fileSender);
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByFileSender_First(String fileSender,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByFileSender(fileSender, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileSender=" + fileSender);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByFileSender_Last(String fileSender,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByFileSender(fileSender);

        List<PmlFileReturningInfo> list = findByFileSender(fileSender,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileSender=" + fileSender);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByFileSender_PrevAndNext(
        long fileReturningInfoId, String fileSender, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByFileSender(fileSender);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (fileSender == null) {
                query.append("filesender LIKE null");
            } else {
                query.append("filesender LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileSender != null) {
                qPos.add(fileSender);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByLicenseNumber(String licenseNumber)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByLicenseNumber";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { licenseNumber };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (licenseNumber == null) {
                    query.append("licensenumber LIKE null");
                } else {
                    query.append("licensenumber LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (licenseNumber != null) {
                    qPos.add(licenseNumber);
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByLicenseNumber(
        String licenseNumber, int start, int end) throws SystemException {
        return findByLicenseNumber(licenseNumber, start, end, null);
    }

    public List<PmlFileReturningInfo> findByLicenseNumber(
        String licenseNumber, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByLicenseNumber";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                licenseNumber,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (licenseNumber == null) {
                    query.append("licensenumber LIKE null");
                } else {
                    query.append("licensenumber LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (licenseNumber != null) {
                    qPos.add(licenseNumber);
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByLicenseNumber_First(
        String licenseNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByLicenseNumber(licenseNumber, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("licenseNumber=" + licenseNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByLicenseNumber_Last(String licenseNumber,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByLicenseNumber(licenseNumber);

        List<PmlFileReturningInfo> list = findByLicenseNumber(licenseNumber,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("licenseNumber=" + licenseNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByLicenseNumber_PrevAndNext(
        long fileReturningInfoId, String licenseNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByLicenseNumber(licenseNumber);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (licenseNumber == null) {
                query.append("licensenumber LIKE null");
            } else {
                query.append("licensenumber LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (licenseNumber != null) {
                qPos.add(licenseNumber);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByIssuingDateLicense(
        Date issuingDateLicense) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByIssuingDateLicense";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { issuingDateLicense };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (issuingDateLicense == null) {
                    query.append("issuingdatelicense IS NULL");
                } else {
                    query.append("issuingdatelicense = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDateLicense != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDateLicense));
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByIssuingDateLicense(
        Date issuingDateLicense, int start, int end) throws SystemException {
        return findByIssuingDateLicense(issuingDateLicense, start, end, null);
    }

    public List<PmlFileReturningInfo> findByIssuingDateLicense(
        Date issuingDateLicense, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByIssuingDateLicense";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                issuingDateLicense,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (issuingDateLicense == null) {
                    query.append("issuingdatelicense IS NULL");
                } else {
                    query.append("issuingdatelicense = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDateLicense != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDateLicense));
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByIssuingDateLicense_First(
        Date issuingDateLicense, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByIssuingDateLicense(issuingDateLicense,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("issuingDateLicense=" + issuingDateLicense);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByIssuingDateLicense_Last(
        Date issuingDateLicense, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByIssuingDateLicense(issuingDateLicense);

        List<PmlFileReturningInfo> list = findByIssuingDateLicense(issuingDateLicense,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("issuingDateLicense=" + issuingDateLicense);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByIssuingDateLicense_PrevAndNext(
        long fileReturningInfoId, Date issuingDateLicense, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByIssuingDateLicense(issuingDateLicense);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (issuingDateLicense == null) {
                query.append("issuingdatelicense IS NULL");
            } else {
                query.append("issuingdatelicense = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (issuingDateLicense != null) {
                qPos.add(CalendarUtil.getTimestamp(issuingDateLicense));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByReceiveLicenseDate(
        Date receiveLicenseDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByReceiveLicenseDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { receiveLicenseDate };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (receiveLicenseDate == null) {
                    query.append("receivelicensedate IS NULL");
                } else {
                    query.append("receivelicensedate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveLicenseDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveLicenseDate));
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByReceiveLicenseDate(
        Date receiveLicenseDate, int start, int end) throws SystemException {
        return findByReceiveLicenseDate(receiveLicenseDate, start, end, null);
    }

    public List<PmlFileReturningInfo> findByReceiveLicenseDate(
        Date receiveLicenseDate, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByReceiveLicenseDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                receiveLicenseDate,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (receiveLicenseDate == null) {
                    query.append("receivelicensedate IS NULL");
                } else {
                    query.append("receivelicensedate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveLicenseDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveLicenseDate));
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByReceiveLicenseDate_First(
        Date receiveLicenseDate, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByReceiveLicenseDate(receiveLicenseDate,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("receiveLicenseDate=" + receiveLicenseDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByReceiveLicenseDate_Last(
        Date receiveLicenseDate, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByReceiveLicenseDate(receiveLicenseDate);

        List<PmlFileReturningInfo> list = findByReceiveLicenseDate(receiveLicenseDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("receiveLicenseDate=" + receiveLicenseDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByReceiveLicenseDate_PrevAndNext(
        long fileReturningInfoId, Date receiveLicenseDate, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByReceiveLicenseDate(receiveLicenseDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (receiveLicenseDate == null) {
                query.append("receivelicensedate IS NULL");
            } else {
                query.append("receivelicensedate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiveLicenseDate != null) {
                qPos.add(CalendarUtil.getTimestamp(receiveLicenseDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByDocumentNumber(
        String documentNumber) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByDocumentNumber";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentNumber };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (documentNumber == null) {
                    query.append("documentnumber LIKE null");
                } else {
                    query.append("documentnumber LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentNumber != null) {
                    qPos.add(documentNumber);
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByDocumentNumber(
        String documentNumber, int start, int end) throws SystemException {
        return findByDocumentNumber(documentNumber, start, end, null);
    }

    public List<PmlFileReturningInfo> findByDocumentNumber(
        String documentNumber, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByDocumentNumber";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentNumber,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (documentNumber == null) {
                    query.append("documentnumber LIKE null");
                } else {
                    query.append("documentnumber LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentNumber != null) {
                    qPos.add(documentNumber);
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByDocumentNumber_First(
        String documentNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByDocumentNumber(documentNumber,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("documentNumber=" + documentNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByDocumentNumber_Last(
        String documentNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByDocumentNumber(documentNumber);

        List<PmlFileReturningInfo> list = findByDocumentNumber(documentNumber,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("documentNumber=" + documentNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByDocumentNumber_PrevAndNext(
        long fileReturningInfoId, String documentNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByDocumentNumber(documentNumber);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (documentNumber == null) {
                query.append("documentnumber LIKE null");
            } else {
                query.append("documentnumber LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentNumber != null) {
                qPos.add(documentNumber);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByBillNumber(String billNumber)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByBillNumber";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { billNumber };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (billNumber == null) {
                    query.append("billnumber LIKE null");
                } else {
                    query.append("billnumber LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (billNumber != null) {
                    qPos.add(billNumber);
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByBillNumber(String billNumber,
        int start, int end) throws SystemException {
        return findByBillNumber(billNumber, start, end, null);
    }

    public List<PmlFileReturningInfo> findByBillNumber(String billNumber,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByBillNumber";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                billNumber,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (billNumber == null) {
                    query.append("billnumber LIKE null");
                } else {
                    query.append("billnumber LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (billNumber != null) {
                    qPos.add(billNumber);
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByBillNumber_First(String billNumber,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByBillNumber(billNumber, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("billNumber=" + billNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByBillNumber_Last(String billNumber,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByBillNumber(billNumber);

        List<PmlFileReturningInfo> list = findByBillNumber(billNumber,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("billNumber=" + billNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByBillNumber_PrevAndNext(
        long fileReturningInfoId, String billNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByBillNumber(billNumber);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (billNumber == null) {
                query.append("billnumber LIKE null");
            } else {
                query.append("billnumber LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (billNumber != null) {
                qPos.add(billNumber);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByNumberMoney(long numberMoney)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByNumberMoney";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(numberMoney) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                query.append("numbermoney = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numberMoney);

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByNumberMoney(long numberMoney,
        int start, int end) throws SystemException {
        return findByNumberMoney(numberMoney, start, end, null);
    }

    public List<PmlFileReturningInfo> findByNumberMoney(long numberMoney,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByNumberMoney";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(numberMoney),
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                query.append("numbermoney = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numberMoney);

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByNumberMoney_First(long numberMoney,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByNumberMoney(numberMoney, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("numberMoney=" + numberMoney);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByNumberMoney_Last(long numberMoney,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByNumberMoney(numberMoney);

        List<PmlFileReturningInfo> list = findByNumberMoney(numberMoney,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("numberMoney=" + numberMoney);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByNumberMoney_PrevAndNext(
        long fileReturningInfoId, long numberMoney, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByNumberMoney(numberMoney);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            query.append("numbermoney = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(numberMoney);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByNote(String note)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByNote";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { note };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByNote(String note, int start, int end)
        throws SystemException {
        return findByNote(note, start, end, null);
    }

    public List<PmlFileReturningInfo> findByNote(String note, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByNote";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                note,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByNote_First(String note,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByNote(note, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByNote_Last(String note,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByNote(note);

        List<PmlFileReturningInfo> list = findByNote(note, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByNote_PrevAndNext(
        long fileReturningInfoId, String note, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByNote(note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("note LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByConclude(String conclude)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByConclude";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { conclude };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (conclude == null) {
                    query.append("conclude LIKE null");
                } else {
                    query.append("conclude LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (conclude != null) {
                    qPos.add(conclude);
                }

                List<PmlFileReturningInfo> list = q.list();

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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public List<PmlFileReturningInfo> findByConclude(String conclude,
        int start, int end) throws SystemException {
        return findByConclude(conclude, start, end, null);
    }

    public List<PmlFileReturningInfo> findByConclude(String conclude,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "findByConclude";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                conclude,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (conclude == null) {
                    query.append("conclude LIKE null");
                } else {
                    query.append("conclude LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (conclude != null) {
                    qPos.add(conclude);
                }

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public PmlFileReturningInfo findByConclude_First(String conclude,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByConclude(conclude, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("conclude=" + conclude);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByConclude_Last(String conclude,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByConclude(conclude);

        List<PmlFileReturningInfo> list = findByConclude(conclude, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("conclude=" + conclude);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByConclude_PrevAndNext(
        long fileReturningInfoId, String conclude, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByConclude(conclude);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

            if (conclude == null) {
                query.append("conclude LIKE null");
            } else {
                query.append("conclude LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (conclude != null) {
                qPos.add(conclude);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileReturningInfo findByFileReturningInfoIdFileId(String fileId,
        long fileReturningInfoId)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = fetchByFileReturningInfoIdFileId(fileId,
                fileReturningInfoId);

        if (pmlFileReturningInfo == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("fileReturningInfoId=" + fileReturningInfoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        }

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo fetchByFileReturningInfoIdFileId(
        String fileId, long fileReturningInfoId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "fetchByFileReturningInfoIdFileId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { fileId, new Long(fileReturningInfoId) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("filereturninginfoid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(fileReturningInfoId);

                List<PmlFileReturningInfo> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                if (list.size() == 0) {
                    return null;
                } else {
                    return list.get(0);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
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

    public List<PmlFileReturningInfo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileReturningInfo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileReturningInfo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
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
            return (List<PmlFileReturningInfo>) result;
        }
    }

    public void removeByFileId(String fileId) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByFileId(fileId)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByFileSender(String fileSender) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByFileSender(
                fileSender)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByLicenseNumber(String licenseNumber)
        throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByLicenseNumber(
                licenseNumber)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByIssuingDateLicense(Date issuingDateLicense)
        throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByIssuingDateLicense(
                issuingDateLicense)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByReceiveLicenseDate(Date receiveLicenseDate)
        throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByReceiveLicenseDate(
                receiveLicenseDate)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByDocumentNumber(String documentNumber)
        throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByDocumentNumber(
                documentNumber)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByBillNumber(String billNumber) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByBillNumber(
                billNumber)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByNumberMoney(long numberMoney) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByNumberMoney(
                numberMoney)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByNote(String note) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByNote(note)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByConclude(String conclude) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByConclude(
                conclude)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByFileReturningInfoIdFileId(String fileId,
        long fileReturningInfoId)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByFileReturningInfoIdFileId(fileId,
                fileReturningInfoId);

        remove(pmlFileReturningInfo);
    }

    public void removeAll() throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findAll()) {
            remove(pmlFileReturningInfo);
        }
    }

    public int countByFileId(String fileId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileId };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
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

    public int countByFileSender(String fileSender) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByFileSender";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileSender };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (fileSender == null) {
                    query.append("filesender LIKE null");
                } else {
                    query.append("filesender LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileSender != null) {
                    qPos.add(fileSender);
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

    public int countByLicenseNumber(String licenseNumber)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByLicenseNumber";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { licenseNumber };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (licenseNumber == null) {
                    query.append("licensenumber LIKE null");
                } else {
                    query.append("licensenumber LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (licenseNumber != null) {
                    qPos.add(licenseNumber);
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

    public int countByIssuingDateLicense(Date issuingDateLicense)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByIssuingDateLicense";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { issuingDateLicense };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (issuingDateLicense == null) {
                    query.append("issuingdatelicense IS NULL");
                } else {
                    query.append("issuingdatelicense = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDateLicense != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDateLicense));
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

    public int countByReceiveLicenseDate(Date receiveLicenseDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByReceiveLicenseDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { receiveLicenseDate };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (receiveLicenseDate == null) {
                    query.append("receivelicensedate IS NULL");
                } else {
                    query.append("receivelicensedate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveLicenseDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveLicenseDate));
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

    public int countByDocumentNumber(String documentNumber)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByDocumentNumber";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentNumber };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (documentNumber == null) {
                    query.append("documentnumber LIKE null");
                } else {
                    query.append("documentnumber LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentNumber != null) {
                    qPos.add(documentNumber);
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

    public int countByBillNumber(String billNumber) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByBillNumber";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { billNumber };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (billNumber == null) {
                    query.append("billnumber LIKE null");
                } else {
                    query.append("billnumber LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (billNumber != null) {
                    qPos.add(billNumber);
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

    public int countByNumberMoney(long numberMoney) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByNumberMoney";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(numberMoney) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                query.append("numbermoney = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numberMoney);

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

    public int countByNote(String note) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByNote";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { note };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
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

    public int countByConclude(String conclude) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByConclude";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { conclude };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (conclude == null) {
                    query.append("conclude LIKE null");
                } else {
                    query.append("conclude LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (conclude != null) {
                    qPos.add(conclude);
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

    public int countByFileReturningInfoIdFileId(String fileId,
        long fileReturningInfoId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
        String finderMethodName = "countByFileReturningInfoIdFileId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { fileId, new Long(fileReturningInfoId) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("filereturninginfoid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(fileReturningInfoId);

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
        boolean finderClassNameCacheEnabled = PmlFileReturningInfoModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileReturningInfo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo");

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
                        "value.object.listener.com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo")));

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
