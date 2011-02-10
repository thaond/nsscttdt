package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlProcessDisposeSoap;

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
 * @see com.sgs.portlet.document.model.PmlProcessDispose
 * @see com.sgs.portlet.document.model.PmlProcessDisposeModel
 * @see com.sgs.portlet.document.model.impl.PmlProcessDisposeImpl
 *
 */
public class PmlProcessDisposeModelImpl extends BaseModelImpl {
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
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlProcessDispose"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlProcessDispose"));
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
        if (processDisposeId != _processDisposeId) {
            _processDisposeId = processDisposeId;
        }
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        if (((fileId == null) && (_fileId != null)) ||
                ((fileId != null) && (_fileId == null)) ||
                ((fileId != null) && (_fileId != null) &&
                !fileId.equals(_fileId))) {
            _fileId = fileId;
        }
    }

    public int getTransition_() {
        return _transition_;
    }

    public void setTransition_(int transition_) {
        if (transition_ != _transition_) {
            _transition_ = transition_;
        }
    }

    public long getProcesser() {
        return _processer;
    }

    public void setProcesser(long processer) {
        if (processer != _processer) {
            _processer = processer;
        }
    }

    public Date getDateProcess() {
        return _dateProcess;
    }

    public void setDateProcess(Date dateProcess) {
        if (((dateProcess == null) && (_dateProcess != null)) ||
                ((dateProcess != null) && (_dateProcess == null)) ||
                ((dateProcess != null) && (_dateProcess != null) &&
                !dateProcess.equals(_dateProcess))) {
            _dateProcess = dateProcess;
        }
    }

    public String getProcessInfomation() {
        return GetterUtil.getString(_processInfomation);
    }

    public void setProcessInfomation(String processInfomation) {
        if (((processInfomation == null) && (_processInfomation != null)) ||
                ((processInfomation != null) && (_processInfomation == null)) ||
                ((processInfomation != null) && (_processInfomation != null) &&
                !processInfomation.equals(_processInfomation))) {
            _processInfomation = processInfomation;
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

    public Date getReceiveDate() {
        return _receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        if (((receiveDate == null) && (_receiveDate != null)) ||
                ((receiveDate != null) && (_receiveDate == null)) ||
                ((receiveDate != null) && (_receiveDate != null) &&
                !receiveDate.equals(_receiveDate))) {
            _receiveDate = receiveDate;
        }
    }

    public long getStateProcessIdBefore() {
        return _stateProcessIdBefore;
    }

    public void setStateProcessIdBefore(long stateProcessIdBefore) {
        if (stateProcessIdBefore != _stateProcessIdBefore) {
            _stateProcessIdBefore = stateProcessIdBefore;
        }
    }

    public long getStateProcessIdAfter() {
        return _stateProcessIdAfter;
    }

    public void setStateProcessIdAfter(long stateProcessIdAfter) {
        if (stateProcessIdAfter != _stateProcessIdAfter) {
            _stateProcessIdAfter = stateProcessIdAfter;
        }
    }

    public Date getExpiredDate() {
        return _expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        if (((expiredDate == null) && (_expiredDate != null)) ||
                ((expiredDate != null) && (_expiredDate == null)) ||
                ((expiredDate != null) && (_expiredDate != null) &&
                !expiredDate.equals(_expiredDate))) {
            _expiredDate = expiredDate;
        }
    }

    public long getDelegateUser() {
        return _delegateUser;
    }

    public void setDelegateUser(long delegateUser) {
        if (delegateUser != _delegateUser) {
            _delegateUser = delegateUser;
        }
    }

    public Date getSendDate() {
        return _sendDate;
    }

    public void setSendDate(Date sendDate) {
        if (((sendDate == null) && (_sendDate != null)) ||
                ((sendDate != null) && (_sendDate == null)) ||
                ((sendDate != null) && (_sendDate != null) &&
                !sendDate.equals(_sendDate))) {
            _sendDate = sendDate;
        }
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

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlProcessDisposeImpl pmlProcessDispose = (PmlProcessDisposeImpl) obj;

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

        PmlProcessDisposeImpl pmlProcessDispose = null;

        try {
            pmlProcessDispose = (PmlProcessDisposeImpl) obj;
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
}
