package com.sgs.portlet.document.delegate.pmldelegate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate;
import com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegateSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDelegateModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDelegate</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate
 * @see com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegateModel
 * @see com.sgs.portlet.document.delegate.pmldelegate.model.impl.PmlDelegateImpl
 *
 */
public class PmlDelegateModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_delegate";
    public static final Object[][] TABLE_COLUMNS = {
            { "delegateid", new Integer(Types.BIGINT) },
            

            { "assigner", new Integer(Types.BIGINT) },
            

            { "receiver", new Integer(Types.BIGINT) },
            

            { "startdate", new Integer(Types.TIMESTAMP) },
            

            { "enddate", new Integer(Types.TIMESTAMP) },
            

            { "canceldate", new Integer(Types.TIMESTAMP) },
            

            { "canceldelegate", new Integer(Types.VARCHAR) },
            

            { "datecreated", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_delegate (delegateid LONG not null primary key,assigner LONG,receiver LONG,startdate DATE null,enddate DATE null,canceldate DATE null,canceldelegate VARCHAR(75) null,datecreated DATE null)";
    public static final String TABLE_SQL_DROP = "drop table pml_delegate";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate"));
    private long _delegateId;
    private long _assigner;
    private long _receiver;
    private Date _startDate;
    private Date _endDate;
    private Date _cancelDate;
    private String _cancelDelegate;
    private Date _dateCreated;

    public PmlDelegateModelImpl() {
    }

    public static PmlDelegate toModel(PmlDelegateSoap soapModel) {
        PmlDelegate model = new PmlDelegateImpl();

        model.setDelegateId(soapModel.getDelegateId());
        model.setAssigner(soapModel.getAssigner());
        model.setReceiver(soapModel.getReceiver());
        model.setStartDate(soapModel.getStartDate());
        model.setEndDate(soapModel.getEndDate());
        model.setCancelDate(soapModel.getCancelDate());
        model.setCancelDelegate(soapModel.getCancelDelegate());
        model.setDateCreated(soapModel.getDateCreated());

        return model;
    }

    public static List<PmlDelegate> toModels(PmlDelegateSoap[] soapModels) {
        List<PmlDelegate> models = new ArrayList<PmlDelegate>(soapModels.length);

        for (PmlDelegateSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _delegateId;
    }

    public void setPrimaryKey(long pk) {
        setDelegateId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_delegateId);
    }

    public long getDelegateId() {
        return _delegateId;
    }

    public void setDelegateId(long delegateId) {
        if (delegateId != _delegateId) {
            _delegateId = delegateId;
        }
    }

    public long getAssigner() {
        return _assigner;
    }

    public void setAssigner(long assigner) {
        if (assigner != _assigner) {
            _assigner = assigner;
        }
    }

    public long getReceiver() {
        return _receiver;
    }

    public void setReceiver(long receiver) {
        if (receiver != _receiver) {
            _receiver = receiver;
        }
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        if (((startDate == null) && (_startDate != null)) ||
                ((startDate != null) && (_startDate == null)) ||
                ((startDate != null) && (_startDate != null) &&
                !startDate.equals(_startDate))) {
            _startDate = startDate;
        }
    }

    public Date getEndDate() {
        return _endDate;
    }

    public void setEndDate(Date endDate) {
        if (((endDate == null) && (_endDate != null)) ||
                ((endDate != null) && (_endDate == null)) ||
                ((endDate != null) && (_endDate != null) &&
                !endDate.equals(_endDate))) {
            _endDate = endDate;
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

    public String getCancelDelegate() {
        return GetterUtil.getString(_cancelDelegate);
    }

    public void setCancelDelegate(String cancelDelegate) {
        if (((cancelDelegate == null) && (_cancelDelegate != null)) ||
                ((cancelDelegate != null) && (_cancelDelegate == null)) ||
                ((cancelDelegate != null) && (_cancelDelegate != null) &&
                !cancelDelegate.equals(_cancelDelegate))) {
            _cancelDelegate = cancelDelegate;
        }
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        if (((dateCreated == null) && (_dateCreated != null)) ||
                ((dateCreated != null) && (_dateCreated == null)) ||
                ((dateCreated != null) && (_dateCreated != null) &&
                !dateCreated.equals(_dateCreated))) {
            _dateCreated = dateCreated;
        }
    }

    public PmlDelegate toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDelegate) this;
        } else {
            PmlDelegate model = new PmlDelegateImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDelegateId(getDelegateId());
            model.setAssigner(getAssigner());
            model.setReceiver(getReceiver());
            model.setStartDate(getStartDate());
            model.setEndDate(getEndDate());
            model.setCancelDate(getCancelDate());
            model.setCancelDelegate(HtmlUtil.escape(getCancelDelegate()));
            model.setDateCreated(getDateCreated());

            model = (PmlDelegate) Proxy.newProxyInstance(PmlDelegate.class.getClassLoader(),
                    new Class[] { PmlDelegate.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDelegateImpl clone = new PmlDelegateImpl();

        clone.setDelegateId(getDelegateId());
        clone.setAssigner(getAssigner());
        clone.setReceiver(getReceiver());
        clone.setStartDate(getStartDate());
        clone.setEndDate(getEndDate());
        clone.setCancelDate(getCancelDate());
        clone.setCancelDelegate(getCancelDelegate());
        clone.setDateCreated(getDateCreated());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDelegateImpl pmlDelegate = (PmlDelegateImpl) obj;

        int value = 0;

        if (getDelegateId() < pmlDelegate.getDelegateId()) {
            value = -1;
        } else if (getDelegateId() > pmlDelegate.getDelegateId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlDelegateImpl pmlDelegate = null;

        try {
            pmlDelegate = (PmlDelegateImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlDelegate.getPrimaryKey();

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
