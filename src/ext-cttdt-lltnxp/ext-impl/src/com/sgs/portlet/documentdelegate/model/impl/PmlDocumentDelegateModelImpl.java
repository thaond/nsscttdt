package com.sgs.portlet.documentdelegate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegateSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentDelegateModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDocumentDelegate</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate
 * @see com.sgs.portlet.documentdelegate.model.PmlDocumentDelegateModel
 * @see com.sgs.portlet.documentdelegate.model.impl.PmlDocumentDelegateImpl
 *
 */
public class PmlDocumentDelegateModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documentdelegate";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentDelegateId", new Integer(Types.BIGINT) },
            

            { "userDelegateId", new Integer(Types.BIGINT) },
            

            { "userIsDelegateId", new Integer(Types.BIGINT) },
            

            { "documentId", new Integer(Types.INTEGER) },
            

            { "fromtDate", new Integer(Types.TIMESTAMP) },
            

            { "toDate", new Integer(Types.TIMESTAMP) },
            

            { "cancelDate", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documentdelegate (documentDelegateId LONG not null primary key,userDelegateId LONG,userIsDelegateId LONG,documentId INTEGER,fromtDate DATE null,toDate DATE null,cancelDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documentdelegate";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate"));
    private long _documentDelegateId;
    private long _userDelegateId;
    private long _userIsDelegateId;
    private int _documentId;
    private Date _fromtDate;
    private Date _toDate;
    private Date _cancelDate;

    public PmlDocumentDelegateModelImpl() {
    }

    public static PmlDocumentDelegate toModel(PmlDocumentDelegateSoap soapModel) {
        PmlDocumentDelegate model = new PmlDocumentDelegateImpl();

        model.setDocumentDelegateId(soapModel.getDocumentDelegateId());
        model.setUserDelegateId(soapModel.getUserDelegateId());
        model.setUserIsDelegateId(soapModel.getUserIsDelegateId());
        model.setDocumentId(soapModel.getDocumentId());
        model.setFromtDate(soapModel.getFromtDate());
        model.setToDate(soapModel.getToDate());
        model.setCancelDate(soapModel.getCancelDate());

        return model;
    }

    public static List<PmlDocumentDelegate> toModels(
        PmlDocumentDelegateSoap[] soapModels) {
        List<PmlDocumentDelegate> models = new ArrayList<PmlDocumentDelegate>(soapModels.length);

        for (PmlDocumentDelegateSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentDelegateId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentDelegateId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentDelegateId);
    }

    public long getDocumentDelegateId() {
        return _documentDelegateId;
    }

    public void setDocumentDelegateId(long documentDelegateId) {
        if (documentDelegateId != _documentDelegateId) {
            _documentDelegateId = documentDelegateId;
        }
    }

    public long getUserDelegateId() {
        return _userDelegateId;
    }

    public void setUserDelegateId(long userDelegateId) {
        if (userDelegateId != _userDelegateId) {
            _userDelegateId = userDelegateId;
        }
    }

    public long getUserIsDelegateId() {
        return _userIsDelegateId;
    }

    public void setUserIsDelegateId(long userIsDelegateId) {
        if (userIsDelegateId != _userIsDelegateId) {
            _userIsDelegateId = userIsDelegateId;
        }
    }

    public int getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(int documentId) {
        if (documentId != _documentId) {
            _documentId = documentId;
        }
    }

    public Date getFromtDate() {
        return _fromtDate;
    }

    public void setFromtDate(Date fromtDate) {
        if (((fromtDate == null) && (_fromtDate != null)) ||
                ((fromtDate != null) && (_fromtDate == null)) ||
                ((fromtDate != null) && (_fromtDate != null) &&
                !fromtDate.equals(_fromtDate))) {
            _fromtDate = fromtDate;
        }
    }

    public Date getToDate() {
        return _toDate;
    }

    public void setToDate(Date toDate) {
        if (((toDate == null) && (_toDate != null)) ||
                ((toDate != null) && (_toDate == null)) ||
                ((toDate != null) && (_toDate != null) &&
                !toDate.equals(_toDate))) {
            _toDate = toDate;
        }
    }

    public Date getCancelDate() {
        return _cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        if (((cancelDate == null) && (_cancelDate != null)) ||
                ((cancelDate != null) && (_cancelDate == null)) ||
                ((cancelDate != null) && (_cancelDate != null) &&
                !cancelDate.equals(_cancelDate))) {
            _cancelDate = cancelDate;
        }
    }

    public PmlDocumentDelegate toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDocumentDelegate) this;
        } else {
            PmlDocumentDelegate model = new PmlDocumentDelegateImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentDelegateId(getDocumentDelegateId());
            model.setUserDelegateId(getUserDelegateId());
            model.setUserIsDelegateId(getUserIsDelegateId());
            model.setDocumentId(getDocumentId());
            model.setFromtDate(getFromtDate());
            model.setToDate(getToDate());
            model.setCancelDate(getCancelDate());

            model = (PmlDocumentDelegate) Proxy.newProxyInstance(PmlDocumentDelegate.class.getClassLoader(),
                    new Class[] { PmlDocumentDelegate.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDocumentDelegateImpl clone = new PmlDocumentDelegateImpl();

        clone.setDocumentDelegateId(getDocumentDelegateId());
        clone.setUserDelegateId(getUserDelegateId());
        clone.setUserIsDelegateId(getUserIsDelegateId());
        clone.setDocumentId(getDocumentId());
        clone.setFromtDate(getFromtDate());
        clone.setToDate(getToDate());
        clone.setCancelDate(getCancelDate());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDocumentDelegateImpl pmlDocumentDelegate = (PmlDocumentDelegateImpl) obj;

        long pk = pmlDocumentDelegate.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlDocumentDelegateImpl pmlDocumentDelegate = null;

        try {
            pmlDocumentDelegate = (PmlDocumentDelegateImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlDocumentDelegate.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
