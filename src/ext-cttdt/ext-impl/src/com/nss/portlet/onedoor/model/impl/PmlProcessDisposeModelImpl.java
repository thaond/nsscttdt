package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.model.PmlProcessDisposeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlProcessDisposeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlProcessDispose</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlProcessDispose
 * @see com.nss.portlet.onedoor.model.PmlProcessDisposeModel
 * @see com.nss.portlet.onedoor.model.impl.PmlProcessDisposeImpl
 *
 */
public class PmlProcessDisposeModelImpl extends BaseModelImpl<PmlProcessDispose> {
    public static final String TABLE_NAME = "pml_processdispose";
    public static final Object[][] TABLE_COLUMNS = {
            { "processdisposeid", new Integer(Types.BIGINT) },
            

            { "fileid", new Integer(Types.VARCHAR) },
            

            { "transition_", new Integer(Types.INTEGER) },
            

            { "processer", new Integer(Types.BIGINT) },
            

            { "dateprocess", new Integer(Types.TIMESTAMP) },
            

            { "processinfomation", new Integer(Types.VARCHAR) },
            

            { "receiver", new Integer(Types.BIGINT) },
            

            { "receivedate", new Integer(Types.TIMESTAMP) },
            

            { "stateprocessidbefore", new Integer(Types.BIGINT) },
            

            { "stateprocessidafter", new Integer(Types.BIGINT) },
            

            { "expireddate", new Integer(Types.TIMESTAMP) },
            

            { "delegateuser", new Integer(Types.BIGINT) },
            

            { "senddate", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_processdispose (processdisposeid LONG not null primary key,fileid VARCHAR(75) null,transition_ INTEGER,processer LONG,dateprocess DATE null,processinfomation VARCHAR(75) null,receiver LONG,receivedate DATE null,stateprocessidbefore LONG,stateprocessidafter LONG,expireddate DATE null,delegateuser LONG,senddate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table pml_processdispose";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlProcessDispose"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlProcessDispose"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlProcessDispose"));
    private long _processDisposeId;
    private String _fileId;
    private int _transition_;
    private long _processer;
    private Date _dateProcess;
    private String _processInfomation;
    private long _receiver;
    private Date _receiveDate;
    private long _stateProcessIdBefore;
    private long _stateProcessIdAfter;
    private Date _expiredDate;
    private long _delegateUser;
    private Date _sendDate;
    private transient ExpandoBridge _expandoBridge;

    public PmlProcessDisposeModelImpl() {
    }

    public static PmlProcessDispose toModel(PmlProcessDisposeSoap soapModel) {
        PmlProcessDispose model = new PmlProcessDisposeImpl();

        model.setProcessDisposeId(soapModel.getProcessDisposeId());
        model.setFileId(soapModel.getFileId());
        model.setTransition_(soapModel.getTransition_());
        model.setProcesser(soapModel.getProcesser());
        model.setDateProcess(soapModel.getDateProcess());
        model.setProcessInfomation(soapModel.getProcessInfomation());
        model.setReceiver(soapModel.getReceiver());
        model.setReceiveDate(soapModel.getReceiveDate());
        model.setStateProcessIdBefore(soapModel.getStateProcessIdBefore());
        model.setStateProcessIdAfter(soapModel.getStateProcessIdAfter());
        model.setExpiredDate(soapModel.getExpiredDate());
        model.setDelegateUser(soapModel.getDelegateUser());
        model.setSendDate(soapModel.getSendDate());

        return model;
    }

    public static List<PmlProcessDispose> toModels(
        PmlProcessDisposeSoap[] soapModels) {
        List<PmlProcessDispose> models = new ArrayList<PmlProcessDispose>(soapModels.length);

        for (PmlProcessDisposeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _processDisposeId;
    }

    public void setPrimaryKey(long pk) {
        setProcessDisposeId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_processDisposeId);
    }

    public long getProcessDisposeId() {
        return _processDisposeId;
    }

    public void setProcessDisposeId(long processDisposeId) {
        _processDisposeId = processDisposeId;
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public int getTransition_() {
        return _transition_;
    }

    public void setTransition_(int transition_) {
        _transition_ = transition_;
    }

    public long getProcesser() {
        return _processer;
    }

    public void setProcesser(long processer) {
        _processer = processer;
    }

    public Date getDateProcess() {
        return _dateProcess;
    }

    public void setDateProcess(Date dateProcess) {
        _dateProcess = dateProcess;
    }

    public String getProcessInfomation() {
        return GetterUtil.getString(_processInfomation);
    }

    public void setProcessInfomation(String processInfomation) {
        _processInfomation = processInfomation;
    }

    public long getReceiver() {
        return _receiver;
    }

    public void setReceiver(long receiver) {
        _receiver = receiver;
    }

    public Date getReceiveDate() {
        return _receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        _receiveDate = receiveDate;
    }

    public long getStateProcessIdBefore() {
        return _stateProcessIdBefore;
    }

    public void setStateProcessIdBefore(long stateProcessIdBefore) {
        _stateProcessIdBefore = stateProcessIdBefore;
    }

    public long getStateProcessIdAfter() {
        return _stateProcessIdAfter;
    }

    public void setStateProcessIdAfter(long stateProcessIdAfter) {
        _stateProcessIdAfter = stateProcessIdAfter;
    }

    public Date getExpiredDate() {
        return _expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        _expiredDate = expiredDate;
    }

    public long getDelegateUser() {
        return _delegateUser;
    }

    public void setDelegateUser(long delegateUser) {
        _delegateUser = delegateUser;
    }

    public Date getSendDate() {
        return _sendDate;
    }

    public void setSendDate(Date sendDate) {
        _sendDate = sendDate;
    }

    public PmlProcessDispose toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlProcessDispose) this;
        } else {
            PmlProcessDispose model = new PmlProcessDisposeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setProcessDisposeId(getProcessDisposeId());
            model.setFileId(HtmlUtil.escape(getFileId()));
            model.setTransition_(getTransition_());
            model.setProcesser(getProcesser());
            model.setDateProcess(getDateProcess());
            model.setProcessInfomation(HtmlUtil.escape(getProcessInfomation()));
            model.setReceiver(getReceiver());
            model.setReceiveDate(getReceiveDate());
            model.setStateProcessIdBefore(getStateProcessIdBefore());
            model.setStateProcessIdAfter(getStateProcessIdAfter());
            model.setExpiredDate(getExpiredDate());
            model.setDelegateUser(getDelegateUser());
            model.setSendDate(getSendDate());

            model = (PmlProcessDispose) Proxy.newProxyInstance(PmlProcessDispose.class.getClassLoader(),
                    new Class[] { PmlProcessDispose.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlProcessDispose.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PmlProcessDisposeImpl clone = new PmlProcessDisposeImpl();

        clone.setProcessDisposeId(getProcessDisposeId());
        clone.setFileId(getFileId());
        clone.setTransition_(getTransition_());
        clone.setProcesser(getProcesser());
        clone.setDateProcess(getDateProcess());
        clone.setProcessInfomation(getProcessInfomation());
        clone.setReceiver(getReceiver());
        clone.setReceiveDate(getReceiveDate());
        clone.setStateProcessIdBefore(getStateProcessIdBefore());
        clone.setStateProcessIdAfter(getStateProcessIdAfter());
        clone.setExpiredDate(getExpiredDate());
        clone.setDelegateUser(getDelegateUser());
        clone.setSendDate(getSendDate());

        return clone;
    }

    public int compareTo(PmlProcessDispose pmlProcessDispose) {
        int value = 0;

        if (getProcessDisposeId() < pmlProcessDispose.getProcessDisposeId()) {
            value = -1;
        } else if (getProcessDisposeId() > pmlProcessDispose.getProcessDisposeId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlProcessDispose pmlProcessDispose = null;

        try {
            pmlProcessDispose = (PmlProcessDispose) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlProcessDispose.getPrimaryKey();

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

        sb.append("{processDisposeId=");
        sb.append(getProcessDisposeId());
        sb.append(", fileId=");
        sb.append(getFileId());
        sb.append(", transition_=");
        sb.append(getTransition_());
        sb.append(", processer=");
        sb.append(getProcesser());
        sb.append(", dateProcess=");
        sb.append(getDateProcess());
        sb.append(", processInfomation=");
        sb.append(getProcessInfomation());
        sb.append(", receiver=");
        sb.append(getReceiver());
        sb.append(", receiveDate=");
        sb.append(getReceiveDate());
        sb.append(", stateProcessIdBefore=");
        sb.append(getStateProcessIdBefore());
        sb.append(", stateProcessIdAfter=");
        sb.append(getStateProcessIdAfter());
        sb.append(", expiredDate=");
        sb.append(getExpiredDate());
        sb.append(", delegateUser=");
        sb.append(getDelegateUser());
        sb.append(", sendDate=");
        sb.append(getSendDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlProcessDispose");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>processDisposeId</column-name><column-value><![CDATA[");
        sb.append(getProcessDisposeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileId</column-name><column-value><![CDATA[");
        sb.append(getFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>transition_</column-name><column-value><![CDATA[");
        sb.append(getTransition_());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>processer</column-name><column-value><![CDATA[");
        sb.append(getProcesser());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateProcess</column-name><column-value><![CDATA[");
        sb.append(getDateProcess());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>processInfomation</column-name><column-value><![CDATA[");
        sb.append(getProcessInfomation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiver</column-name><column-value><![CDATA[");
        sb.append(getReceiver());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiveDate</column-name><column-value><![CDATA[");
        sb.append(getReceiveDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stateProcessIdBefore</column-name><column-value><![CDATA[");
        sb.append(getStateProcessIdBefore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stateProcessIdAfter</column-name><column-value><![CDATA[");
        sb.append(getStateProcessIdAfter());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>expiredDate</column-name><column-value><![CDATA[");
        sb.append(getExpiredDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>delegateUser</column-name><column-value><![CDATA[");
        sb.append(getDelegateUser());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sendDate</column-name><column-value><![CDATA[");
        sb.append(getSendDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
