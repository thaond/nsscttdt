package com.sgs.portlet.document.send.service.persistence;

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

import com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentSendPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmDocumentSendPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentSendPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentSend create(long documentSendId) {
        PmlEdmDocumentSend pmlEdmDocumentSend = new PmlEdmDocumentSendImpl();

        pmlEdmDocumentSend.setNew(true);
        pmlEdmDocumentSend.setPrimaryKey(documentSendId);

        return pmlEdmDocumentSend;
    }

    public PmlEdmDocumentSend remove(long documentSendId)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentSend pmlEdmDocumentSend = (PmlEdmDocumentSend) session.get(PmlEdmDocumentSendImpl.class,
                    new Long(documentSendId));

            if (pmlEdmDocumentSend == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentSend exists with the primary key " +
                        documentSendId);
                }

                throw new NoSuchPmlEdmDocumentSendException(
                    "No PmlEdmDocumentSend exists with the primary key " +
                    documentSendId);
            }

            return remove(pmlEdmDocumentSend);
        } catch (NoSuchPmlEdmDocumentSendException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentSend remove(PmlEdmDocumentSend pmlEdmDocumentSend)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentSend);
            }
        }

        pmlEdmDocumentSend = removeImpl(pmlEdmDocumentSend);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentSend);
            }
        }

        return pmlEdmDocumentSend;
    }

    protected PmlEdmDocumentSend removeImpl(
        PmlEdmDocumentSend pmlEdmDocumentSend) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentSend);

            session.flush();

            return pmlEdmDocumentSend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentSend.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentSend pmlEdmDocumentSend, boolean merge)</code>.
     */
    public PmlEdmDocumentSend update(PmlEdmDocumentSend pmlEdmDocumentSend)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentSend pmlEdmDocumentSend) method. Use update(PmlEdmDocumentSend pmlEdmDocumentSend, boolean merge) instead.");
        }

        return update(pmlEdmDocumentSend, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentSend update(PmlEdmDocumentSend pmlEdmDocumentSend,
        boolean merge) throws SystemException {
        boolean isNew = pmlEdmDocumentSend.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentSend);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentSend);
                }
            }
        }

        pmlEdmDocumentSend = updateImpl(pmlEdmDocumentSend, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentSend);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentSend);
                }
            }
        }

        return pmlEdmDocumentSend;
    }

    public PmlEdmDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentSend);
            } else {
                if (pmlEdmDocumentSend.isNew()) {
                    session.save(pmlEdmDocumentSend);
                }
            }

            session.flush();

            pmlEdmDocumentSend.setNew(false);

            return pmlEdmDocumentSend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentSend.class.getName());
        }
    }

    public PmlEdmDocumentSend findByPrimaryKey(long documentSendId)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = fetchByPrimaryKey(documentSendId);

        if (pmlEdmDocumentSend == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlEdmDocumentSend exists with the primary key " +
                    documentSendId);
            }

            throw new NoSuchPmlEdmDocumentSendException(
                "No PmlEdmDocumentSend exists with the primary key " +
                documentSendId);
        }

        return pmlEdmDocumentSend;
    }

    public PmlEdmDocumentSend fetchByPrimaryKey(long documentSendId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentSend) session.get(PmlEdmDocumentSendImpl.class,
                new Long(documentSendId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByDocumentSendCode(
        String documentSendCode) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByDocumentSendCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentSendCode };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (documentSendCode == null) {
                    query.append("documentsendcode LIKE null");
                } else {
                    query.append("documentsendcode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentSendCode != null) {
                    qPos.add(documentSendCode);
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByDocumentSendCode(
        String documentSendCode, int start, int end) throws SystemException {
        return findByDocumentSendCode(documentSendCode, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByDocumentSendCode(
        String documentSendCode, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByDocumentSendCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentSendCode,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (documentSendCode == null) {
                    query.append("documentsendcode LIKE null");
                } else {
                    query.append("documentsendcode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentSendCode != null) {
                    qPos.add(documentSendCode);
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByDocumentSendCode_First(
        String documentSendCode, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByDocumentSendCode(documentSendCode,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("documentSendCode=" + documentSendCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByDocumentSendCode_Last(
        String documentSendCode, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByDocumentSendCode(documentSendCode);

        List<PmlEdmDocumentSend> list = findByDocumentSendCode(documentSendCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("documentSendCode=" + documentSendCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByDocumentSendCode_PrevAndNext(
        long documentSendId, String documentSendCode, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByDocumentSendCode(documentSendCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (documentSendCode == null) {
                query.append("documentsendcode LIKE null");
            } else {
                query.append("documentsendcode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentSendCode != null) {
                qPos.add(documentSendCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByNumberPublish(String numberPublish)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByNumberPublish";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { numberPublish };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (numberPublish == null) {
                    query.append("numberpublish LIKE null");
                } else {
                    query.append("numberpublish LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberPublish != null) {
                    qPos.add(numberPublish);
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByNumberPublish(String numberPublish,
        int start, int end) throws SystemException {
        return findByNumberPublish(numberPublish, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByNumberPublish(String numberPublish,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByNumberPublish";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                numberPublish,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (numberPublish == null) {
                    query.append("numberpublish LIKE null");
                } else {
                    query.append("numberpublish LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberPublish != null) {
                    qPos.add(numberPublish);
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByNumberPublish_First(String numberPublish,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByNumberPublish(numberPublish, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("numberPublish=" + numberPublish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByNumberPublish_Last(String numberPublish,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByNumberPublish(numberPublish);

        List<PmlEdmDocumentSend> list = findByNumberPublish(numberPublish,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("numberPublish=" + numberPublish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByNumberPublish_PrevAndNext(
        long documentSendId, String numberPublish, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByNumberPublish(numberPublish);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (numberPublish == null) {
                query.append("numberpublish LIKE null");
            } else {
                query.append("numberpublish LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (numberPublish != null) {
                qPos.add(numberPublish);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByNumberPage(String numberPage)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByNumberPage";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { numberPage };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (numberPage == null) {
                    query.append("numberpage LIKE null");
                } else {
                    query.append("numberpage LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberPage != null) {
                    qPos.add(numberPage);
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByNumberPage(String numberPage,
        int start, int end) throws SystemException {
        return findByNumberPage(numberPage, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByNumberPage(String numberPage,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByNumberPage";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                numberPage,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (numberPage == null) {
                    query.append("numberpage LIKE null");
                } else {
                    query.append("numberpage LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberPage != null) {
                    qPos.add(numberPage);
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByNumberPage_First(String numberPage,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByNumberPage(numberPage, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("numberPage=" + numberPage);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByNumberPage_Last(String numberPage,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByNumberPage(numberPage);

        List<PmlEdmDocumentSend> list = findByNumberPage(numberPage, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("numberPage=" + numberPage);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByNumberPage_PrevAndNext(
        long documentSendId, String numberPage, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByNumberPage(numberPage);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (numberPage == null) {
                query.append("numberpage LIKE null");
            } else {
                query.append("numberpage LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (numberPage != null) {
                qPos.add(numberPage);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByPosition(String position)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByPosition";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { position };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (position == null) {
                    query.append("position_ LIKE null");
                } else {
                    query.append("position_ LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (position != null) {
                    qPos.add(position);
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByPosition(String position, int start,
        int end) throws SystemException {
        return findByPosition(position, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByPosition(String position, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByPosition";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                position,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (position == null) {
                    query.append("position_ LIKE null");
                } else {
                    query.append("position_ LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (position != null) {
                    qPos.add(position);
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByPosition_First(String position,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByPosition(position, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("position=" + position);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByPosition_Last(String position,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByPosition(position);

        List<PmlEdmDocumentSend> list = findByPosition(position, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("position=" + position);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByPosition_PrevAndNext(
        long documentSendId, String position, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByPosition(position);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (position == null) {
                query.append("position_ LIKE null");
            } else {
                query.append("position_ LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (position != null) {
                qPos.add(position);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findBySignerName(String signerName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findBySignerName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { signerName };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (signerName == null) {
                    query.append("signername LIKE null");
                } else {
                    query.append("signername LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (signerName != null) {
                    qPos.add(signerName);
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findBySignerName(String signerName,
        int start, int end) throws SystemException {
        return findBySignerName(signerName, start, end, null);
    }

    public List<PmlEdmDocumentSend> findBySignerName(String signerName,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findBySignerName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                signerName,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (signerName == null) {
                    query.append("signername LIKE null");
                } else {
                    query.append("signername LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (signerName != null) {
                    qPos.add(signerName);
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findBySignerName_First(String signerName,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findBySignerName(signerName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("signerName=" + signerName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findBySignerName_Last(String signerName,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countBySignerName(signerName);

        List<PmlEdmDocumentSend> list = findBySignerName(signerName, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("signerName=" + signerName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findBySignerName_PrevAndNext(
        long documentSendId, String signerName, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countBySignerName(signerName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (signerName == null) {
                query.append("signername LIKE null");
            } else {
                query.append("signername LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (signerName != null) {
                qPos.add(signerName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findBySendDate(Date sendDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findBySendDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { sendDate };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findBySendDate(Date sendDate, int start,
        int end) throws SystemException {
        return findBySendDate(sendDate, start, end, null);
    }

    public List<PmlEdmDocumentSend> findBySendDate(Date sendDate, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findBySendDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                sendDate,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findBySendDate_First(Date sendDate,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findBySendDate(sendDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("sendDate=" + sendDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findBySendDate_Last(Date sendDate,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countBySendDate(sendDate);

        List<PmlEdmDocumentSend> list = findBySendDate(sendDate, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("sendDate=" + sendDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findBySendDate_PrevAndNext(
        long documentSendId, Date sendDate, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countBySendDate(sendDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (sendDate == null) {
                query.append("senddate IS NULL");
            } else {
                query.append("senddate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (sendDate != null) {
                qPos.add(CalendarUtil.getTimestamp(sendDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByDocumentReference(
        String documentReference) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByDocumentReference";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentReference };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (documentReference == null) {
                    query.append("documentreference LIKE null");
                } else {
                    query.append("documentreference LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentReference != null) {
                    qPos.add(documentReference);
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByDocumentReference(
        String documentReference, int start, int end) throws SystemException {
        return findByDocumentReference(documentReference, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByDocumentReference(
        String documentReference, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByDocumentReference";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentReference,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (documentReference == null) {
                    query.append("documentreference LIKE null");
                } else {
                    query.append("documentreference LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentReference != null) {
                    qPos.add(documentReference);
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByDocumentReference_First(
        String documentReference, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByDocumentReference(documentReference,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("documentReference=" + documentReference);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByDocumentReference_Last(
        String documentReference, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByDocumentReference(documentReference);

        List<PmlEdmDocumentSend> list = findByDocumentReference(documentReference,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("documentReference=" + documentReference);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByDocumentReference_PrevAndNext(
        long documentSendId, String documentReference, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByDocumentReference(documentReference);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (documentReference == null) {
                query.append("documentreference LIKE null");
            } else {
                query.append("documentreference LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentReference != null) {
                qPos.add(documentReference);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByEditorId(long editorId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByEditorId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(editorId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("editorid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(editorId);

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByEditorId(long editorId, int start,
        int end) throws SystemException {
        return findByEditorId(editorId, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByEditorId(long editorId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByEditorId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(editorId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("editorid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(editorId);

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByEditorId_First(long editorId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByEditorId(editorId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("editorId=" + editorId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByEditorId_Last(long editorId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByEditorId(editorId);

        List<PmlEdmDocumentSend> list = findByEditorId(editorId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("editorId=" + editorId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByEditorId_PrevAndNext(
        long documentSendId, long editorId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByEditorId(editorId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            query.append("editorid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(editorId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findBySignerId(long signerId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findBySignerId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(signerId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("signerid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(signerId);

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findBySignerId(long signerId, int start,
        int end) throws SystemException {
        return findBySignerId(signerId, start, end, null);
    }

    public List<PmlEdmDocumentSend> findBySignerId(long signerId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findBySignerId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(signerId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("signerid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(signerId);

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findBySignerId_First(long signerId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findBySignerId(signerId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("signerId=" + signerId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findBySignerId_Last(long signerId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countBySignerId(signerId);

        List<PmlEdmDocumentSend> list = findBySignerId(signerId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("signerId=" + signerId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findBySignerId_PrevAndNext(
        long documentSendId, long signerId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countBySignerId(signerId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            query.append("signerid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(signerId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByDocumentTypeId(long documentTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByDocumentTypeId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentTypeId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByDocumentTypeId(long documentTypeId,
        int start, int end) throws SystemException {
        return findByDocumentTypeId(documentTypeId, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByDocumentTypeId(long documentTypeId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByDocumentTypeId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentTypeId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByDocumentTypeId_First(long documentTypeId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByDocumentTypeId(documentTypeId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("documentTypeId=" + documentTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByDocumentTypeId_Last(long documentTypeId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByDocumentTypeId(documentTypeId);

        List<PmlEdmDocumentSend> list = findByDocumentTypeId(documentTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("documentTypeId=" + documentTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByDocumentTypeId_PrevAndNext(
        long documentSendId, long documentTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByDocumentTypeId(documentTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            query.append("documenttypeid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByPrivilegeLevelId(
        String privilegeLevelId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByPrivilegeLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { privilegeLevelId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByPrivilegeLevelId(
        String privilegeLevelId, int start, int end) throws SystemException {
        return findByPrivilegeLevelId(privilegeLevelId, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByPrivilegeLevelId(
        String privilegeLevelId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByPrivilegeLevelId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                privilegeLevelId,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByPrivilegeLevelId_First(
        String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByPrivilegeLevelId(privilegeLevelId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("privilegeLevelId=" + privilegeLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByPrivilegeLevelId_Last(
        String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByPrivilegeLevelId(privilegeLevelId);

        List<PmlEdmDocumentSend> list = findByPrivilegeLevelId(privilegeLevelId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("privilegeLevelId=" + privilegeLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByPrivilegeLevelId_PrevAndNext(
        long documentSendId, String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByPrivilegeLevelId(privilegeLevelId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (privilegeLevelId == null) {
                query.append("privilegelevelid LIKE null");
            } else {
                query.append("privilegelevelid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (privilegeLevelId != null) {
                qPos.add(privilegeLevelId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByConfidentialLevelId(
        String confidentialLevelId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByConfidentialLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { confidentialLevelId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByConfidentialLevelId(
        String confidentialLevelId, int start, int end)
        throws SystemException {
        return findByConfidentialLevelId(confidentialLevelId, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByConfidentialLevelId(
        String confidentialLevelId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByConfidentialLevelId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                confidentialLevelId,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByConfidentialLevelId_First(
        String confidentialLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByConfidentialLevelId(confidentialLevelId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("confidentialLevelId=" + confidentialLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByConfidentialLevelId_Last(
        String confidentialLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByConfidentialLevelId(confidentialLevelId);

        List<PmlEdmDocumentSend> list = findByConfidentialLevelId(confidentialLevelId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("confidentialLevelId=" + confidentialLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByConfidentialLevelId_PrevAndNext(
        long documentSendId, String confidentialLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByConfidentialLevelId(confidentialLevelId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (confidentialLevelId == null) {
                query.append("confidentiallevelid LIKE null");
            } else {
                query.append("confidentiallevelid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (confidentialLevelId != null) {
                qPos.add(confidentialLevelId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByIssuingDate(Date issuingDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByIssuingDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { issuingDate };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (issuingDate == null) {
                    query.append("issuingdate IS NULL");
                } else {
                    query.append("issuingdate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDate));
                }

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByIssuingDate(Date issuingDate,
        int start, int end) throws SystemException {
        return findByIssuingDate(issuingDate, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByIssuingDate(Date issuingDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByIssuingDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                issuingDate,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (issuingDate == null) {
                    query.append("issuingdate IS NULL");
                } else {
                    query.append("issuingdate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDate));
                }

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByIssuingDate_First(Date issuingDate,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByIssuingDate(issuingDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("issuingDate=" + issuingDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByIssuingDate_Last(Date issuingDate,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByIssuingDate(issuingDate);

        List<PmlEdmDocumentSend> list = findByIssuingDate(issuingDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("issuingDate=" + issuingDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByIssuingDate_PrevAndNext(
        long documentSendId, Date issuingDate, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByIssuingDate(issuingDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            if (issuingDate == null) {
                query.append("issuingdate IS NULL");
            } else {
                query.append("issuingdate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (issuingDate != null) {
                qPos.add(CalendarUtil.getTimestamp(issuingDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByStatusId(long statusId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(statusId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByStatusId(long statusId, int start,
        int end) throws SystemException {
        return findByStatusId(statusId, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByStatusId(long statusId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByStatusId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(statusId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByStatusId_First(long statusId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByStatusId(statusId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("statusId=" + statusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByStatusId_Last(long statusId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByStatusId(statusId);

        List<PmlEdmDocumentSend> list = findByStatusId(statusId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("statusId=" + statusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByStatusId_PrevAndNext(
        long documentSendId, long statusId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByStatusId(statusId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            query.append("statusid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(statusId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByIsCongVanPhucDap";
        String[] finderParams = new String[] { Boolean.class.getName() };
        Object[] finderArgs = new Object[] { Boolean.valueOf(iscongvanphucdap) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("iscongvanphucdap = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(iscongvanphucdap);

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap, int start, int end) throws SystemException {
        return findByIsCongVanPhucDap(iscongvanphucdap, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByIsCongVanPhucDap(
        boolean iscongvanphucdap, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByIsCongVanPhucDap";
        String[] finderParams = new String[] {
                Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                Boolean.valueOf(iscongvanphucdap),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("iscongvanphucdap = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(iscongvanphucdap);

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByIsCongVanPhucDap_First(
        boolean iscongvanphucdap, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByIsCongVanPhucDap(iscongvanphucdap,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("iscongvanphucdap=" + iscongvanphucdap);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByIsCongVanPhucDap_Last(
        boolean iscongvanphucdap, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByIsCongVanPhucDap(iscongvanphucdap);

        List<PmlEdmDocumentSend> list = findByIsCongVanPhucDap(iscongvanphucdap,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("iscongvanphucdap=" + iscongvanphucdap);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByIsCongVanPhucDap_PrevAndNext(
        long documentSendId, boolean iscongvanphucdap, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByIsCongVanPhucDap(iscongvanphucdap);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            query.append("iscongvanphucdap = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(iscongvanphucdap);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentSend> findByOrgExternalId(long orgExternalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByOrgExternalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(orgExternalId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

                List<PmlEdmDocumentSend> list = q.list();

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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public List<PmlEdmDocumentSend> findByOrgExternalId(long orgExternalId,
        int start, int end) throws SystemException {
        return findByOrgExternalId(orgExternalId, start, end, null);
    }

    public List<PmlEdmDocumentSend> findByOrgExternalId(long orgExternalId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "findByOrgExternalId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(orgExternalId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public PmlEdmDocumentSend findByOrgExternalId_First(long orgExternalId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        List<PmlEdmDocumentSend> list = findByOrgExternalId(orgExternalId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend findByOrgExternalId_Last(long orgExternalId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        int count = countByOrgExternalId(orgExternalId);

        List<PmlEdmDocumentSend> list = findByOrgExternalId(orgExternalId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentSend exists with the key {");

            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentSend[] findByOrgExternalId_PrevAndNext(
        long documentSendId, long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentSendException, SystemException {
        PmlEdmDocumentSend pmlEdmDocumentSend = findByPrimaryKey(documentSendId);

        int count = countByOrgExternalId(orgExternalId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

            query.append("orgexternalid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(orgExternalId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentSend);

            PmlEdmDocumentSend[] array = new PmlEdmDocumentSendImpl[3];

            array[0] = (PmlEdmDocumentSend) objArray[0];
            array[1] = (PmlEdmDocumentSend) objArray[1];
            array[2] = (PmlEdmDocumentSend) objArray[2];

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

    public List<PmlEdmDocumentSend> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentSend> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentSend> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentSend> list = (List<PmlEdmDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentSend>) result;
        }
    }

    public void removeByDocumentSendCode(String documentSendCode)
        throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByDocumentSendCode(
                documentSendCode)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByNumberPublish(String numberPublish)
        throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByNumberPublish(
                numberPublish)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByNumberPage(String numberPage) throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByNumberPage(
                numberPage)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByPosition(String position) throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByPosition(position)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeBySignerName(String signerName) throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findBySignerName(
                signerName)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeBySendDate(Date sendDate) throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findBySendDate(sendDate)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByDocumentReference(String documentReference)
        throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByDocumentReference(
                documentReference)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByEditorId(long editorId) throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByEditorId(editorId)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeBySignerId(long signerId) throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findBySignerId(signerId)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByDocumentTypeId(long documentTypeId)
        throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByDocumentTypeId(
                documentTypeId)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByPrivilegeLevelId(String privilegeLevelId)
        throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByPrivilegeLevelId(
                privilegeLevelId)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByConfidentialLevelId(String confidentialLevelId)
        throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByConfidentialLevelId(
                confidentialLevelId)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByIssuingDate(Date issuingDate) throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByIssuingDate(
                issuingDate)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByStatusId(long statusId) throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByStatusId(statusId)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByIsCongVanPhucDap(boolean iscongvanphucdap)
        throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByIsCongVanPhucDap(
                iscongvanphucdap)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeByOrgExternalId(long orgExternalId)
        throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findByOrgExternalId(
                orgExternalId)) {
            remove(pmlEdmDocumentSend);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentSend pmlEdmDocumentSend : findAll()) {
            remove(pmlEdmDocumentSend);
        }
    }

    public int countByDocumentSendCode(String documentSendCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByDocumentSendCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentSendCode };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (documentSendCode == null) {
                    query.append("documentsendcode LIKE null");
                } else {
                    query.append("documentsendcode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentSendCode != null) {
                    qPos.add(documentSendCode);
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

    public int countByNumberPublish(String numberPublish)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByNumberPublish";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { numberPublish };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (numberPublish == null) {
                    query.append("numberpublish LIKE null");
                } else {
                    query.append("numberpublish LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberPublish != null) {
                    qPos.add(numberPublish);
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

    public int countByNumberPage(String numberPage) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByNumberPage";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { numberPage };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (numberPage == null) {
                    query.append("numberpage LIKE null");
                } else {
                    query.append("numberpage LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberPage != null) {
                    qPos.add(numberPage);
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

    public int countByPosition(String position) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByPosition";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { position };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (position == null) {
                    query.append("position_ LIKE null");
                } else {
                    query.append("position_ LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (position != null) {
                    qPos.add(position);
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

    public int countBySignerName(String signerName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countBySignerName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { signerName };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (signerName == null) {
                    query.append("signername LIKE null");
                } else {
                    query.append("signername LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (signerName != null) {
                    qPos.add(signerName);
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

    public int countBySendDate(Date sendDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countBySendDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { sendDate };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
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

    public int countByDocumentReference(String documentReference)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByDocumentReference";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentReference };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (documentReference == null) {
                    query.append("documentreference LIKE null");
                } else {
                    query.append("documentreference LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentReference != null) {
                    qPos.add(documentReference);
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

    public int countByEditorId(long editorId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByEditorId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(editorId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("editorid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(editorId);

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

    public int countBySignerId(long signerId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countBySignerId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(signerId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("signerid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(signerId);

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

    public int countByDocumentTypeId(long documentTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByDocumentTypeId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentTypeId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

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

    public int countByPrivilegeLevelId(String privilegeLevelId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByPrivilegeLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { privilegeLevelId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
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

    public int countByConfidentialLevelId(String confidentialLevelId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByConfidentialLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { confidentialLevelId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
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

    public int countByIssuingDate(Date issuingDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByIssuingDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { issuingDate };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                if (issuingDate == null) {
                    query.append("issuingdate IS NULL");
                } else {
                    query.append("issuingdate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDate));
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

    public int countByStatusId(long statusId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(statusId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

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

    public int countByIsCongVanPhucDap(boolean iscongvanphucdap)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByIsCongVanPhucDap";
        String[] finderParams = new String[] { Boolean.class.getName() };
        Object[] finderArgs = new Object[] { Boolean.valueOf(iscongvanphucdap) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("iscongvanphucdap = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(iscongvanphucdap);

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

    public int countByOrgExternalId(long orgExternalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
        String finderMethodName = "countByOrgExternalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(orgExternalId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentSend.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.send.model.PmlEdmDocumentSend");

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
                        "value.object.listener.com.sgs.portlet.document.send.model.PmlEdmDocumentSend")));

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
