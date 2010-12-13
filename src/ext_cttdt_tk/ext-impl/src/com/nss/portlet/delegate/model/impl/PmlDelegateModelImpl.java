package com.nss.portlet.delegate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.delegate.model.PmlDelegate;
import com.nss.portlet.delegate.model.PmlDelegateSoap;

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
 * @see com.nss.portlet.delegate.model.PmlDelegate
 * @see com.nss.portlet.delegate.model.PmlDelegateModel
 * @see com.nss.portlet.delegate.model.impl.PmlDelegateImpl
 *
 */
public class PmlDelegateModelImpl extends BaseModelImpl<PmlDelegate> {
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
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.delegate.model.PmlDelegate"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.delegate.model.PmlDelegate"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.delegate.model.PmlDelegate"));
    private long _delegateId;
    private long _assigner;
    private long _receiver;
    private Date _startDate;
    private Date _endDate;
    private Date _cancelDate;
    private String _cancelDelegate;
    private Date _dateCreated;
    private transient ExpandoBridge _expandoBridge;

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
        _delegateId = delegateId;
    }

    public long getAssigner() {
        return _assigner;
    }

    public void setAssigner(long assigner) {
        _assigner = assigner;
    }

    public long getReceiver() {
        return _receiver;
    }

    public void setReceiver(long receiver) {
        _receiver = receiver;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public Date getEndDate() {
        return _endDate;
    }

    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    public Date getCancelDate() {
        return _cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        _cancelDate = cancelDate;
    }

    public String getCancelDelegate() {
        return GetterUtil.getString(_cancelDelegate);
    }

    public void setCancelDelegate(String cancelDelegate) {
        _cancelDelegate = cancelDelegate;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
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

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlDelegate.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
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

    public int compareTo(PmlDelegate pmlDelegate) {
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

        PmlDelegate pmlDelegate = null;

        try {
            pmlDelegate = (PmlDelegate) obj;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{delegateId=");
        sb.append(getDelegateId());
        sb.append(", assigner=");
        sb.append(getAssigner());
        sb.append(", receiver=");
        sb.append(getReceiver());
        sb.append(", startDate=");
        sb.append(getStartDate());
        sb.append(", endDate=");
        sb.append(getEndDate());
        sb.append(", cancelDate=");
        sb.append(getCancelDate());
        sb.append(", cancelDelegate=");
        sb.append(getCancelDelegate());
        sb.append(", dateCreated=");
        sb.append(getDateCreated());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.delegate.model.PmlDelegate");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>delegateId</column-name><column-value><![CDATA[");
        sb.append(getDelegateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>assigner</column-name><column-value><![CDATA[");
        sb.append(getAssigner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiver</column-name><column-value><![CDATA[");
        sb.append(getReceiver());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startDate</column-name><column-value><![CDATA[");
        sb.append(getStartDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>endDate</column-name><column-value><![CDATA[");
        sb.append(getEndDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cancelDate</column-name><column-value><![CDATA[");
        sb.append(getCancelDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cancelDelegate</column-name><column-value><![CDATA[");
        sb.append(getCancelDelegate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateCreated</column-name><column-value><![CDATA[");
        sb.append(getDateCreated());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
