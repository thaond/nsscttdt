package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.PmlDocumentSendLogSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentSendLogModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDocumentSendLog</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentSendLog
 * @see com.sgs.portlet.document.model.PmlDocumentSendLogModel
 * @see com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl
 *
 */
public class PmlDocumentSendLogModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_documentsend_log";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentsendlogid", new Integer(Types.BIGINT) },
            

            { "documentsendid", new Integer(Types.BIGINT) },
            

            { "transition_", new Integer(Types.INTEGER) },
            

            { "processer", new Integer(Types.BIGINT) },
            

            { "dateprocess", new Integer(Types.TIMESTAMP) },
            

            { "processinfomation", new Integer(Types.VARCHAR) },
            

            { "receiver", new Integer(Types.BIGINT) },
            

            { "receivedate", new Integer(Types.TIMESTAMP) },
            

            { "stateprocessidbefore", new Integer(Types.BIGINT) },
            

            { "stateprocessidafter", new Integer(Types.BIGINT) },
            

            { "expireddate", new Integer(Types.TIMESTAMP) },
            

            { "numdateprocess", new Integer(Types.INTEGER) },
            

            { "processinstanceid", new Integer(Types.BIGINT) },
            

            { "type_", new Integer(Types.INTEGER) },
            

            { "senddatebefore", new Integer(Types.TIMESTAMP) },
            

            { "departmentreceiveid", new Integer(Types.VARCHAR) },
            

            { "departmentprocessid", new Integer(Types.VARCHAR) },
            

            { "dateprocesstime", new Integer(Types.TIMESTAMP) },
            

            { "receivedatetime", new Integer(Types.TIMESTAMP) },
            

            { "directProcesserId", new Integer(Types.BIGINT) },
            

            { "step", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_documentsend_log (documentsendlogid LONG not null primary key,documentsendid LONG,transition_ INTEGER,processer LONG,dateprocess DATE null,processinfomation VARCHAR(75) null,receiver LONG,receivedate DATE null,stateprocessidbefore LONG,stateprocessidafter LONG,expireddate DATE null,numdateprocess INTEGER,processinstanceid LONG,type_ INTEGER,senddatebefore DATE null,departmentreceiveid VARCHAR(75) null,departmentprocessid VARCHAR(75) null,dateprocesstime DATE null,receivedatetime DATE null,directProcesserId LONG,step INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table pml_documentsend_log";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlDocumentSendLog"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlDocumentSendLog"));
    private long _documentSendLogId;
    private long _documentSendId;
    private int _transition_;
    private long _processer;
    private Date _dateProcess;
    private String _processInfomation;
    private long _receiver;
    private Date _receiveDate;
    private long _stateProcessIdBefore;
    private long _stateProcessIdAfter;
    private Date _expiredDate;
    private int _numDateProcess;
    private long _processInstanceId;
    private int _type_;
    private Date _sendDateBefore;
    private String _departmentReceiveId;
    private String _departmentProcessId;
    private Date _dateProcessTime;
    private Date _receiveDateTime;
    private long _directProcesserId;
    private int _step;

    public PmlDocumentSendLogModelImpl() {
    }

    public static PmlDocumentSendLog toModel(PmlDocumentSendLogSoap soapModel) {
        PmlDocumentSendLog model = new PmlDocumentSendLogImpl();

        model.setDocumentSendLogId(soapModel.getDocumentSendLogId());
        model.setDocumentSendId(soapModel.getDocumentSendId());
        model.setTransition_(soapModel.getTransition_());
        model.setProcesser(soapModel.getProcesser());
        model.setDateProcess(soapModel.getDateProcess());
        model.setProcessInfomation(soapModel.getProcessInfomation());
        model.setReceiver(soapModel.getReceiver());
        model.setReceiveDate(soapModel.getReceiveDate());
        model.setStateProcessIdBefore(soapModel.getStateProcessIdBefore());
        model.setStateProcessIdAfter(soapModel.getStateProcessIdAfter());
        model.setExpiredDate(soapModel.getExpiredDate());
        model.setNumDateProcess(soapModel.getNumDateProcess());
        model.setProcessInstanceId(soapModel.getProcessInstanceId());
        model.setType_(soapModel.getType_());
        model.setSendDateBefore(soapModel.getSendDateBefore());
        model.setDepartmentReceiveId(soapModel.getDepartmentReceiveId());
        model.setDepartmentProcessId(soapModel.getDepartmentProcessId());
        model.setDateProcessTime(soapModel.getDateProcessTime());
        model.setReceiveDateTime(soapModel.getReceiveDateTime());
        model.setDirectProcesserId(soapModel.getDirectProcesserId());
        model.setStep(soapModel.getStep());

        return model;
    }

    public static List<PmlDocumentSendLog> toModels(
        PmlDocumentSendLogSoap[] soapModels) {
        List<PmlDocumentSendLog> models = new ArrayList<PmlDocumentSendLog>(soapModels.length);

        for (PmlDocumentSendLogSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentSendLogId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentSendLogId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentSendLogId);
    }

    public long getDocumentSendLogId() {
        return _documentSendLogId;
    }

    public void setDocumentSendLogId(long documentSendLogId) {
        if (documentSendLogId != _documentSendLogId) {
            _documentSendLogId = documentSendLogId;
        }
    }

    public long getDocumentSendId() {
        return _documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        if (documentSendId != _documentSendId) {
            _documentSendId = documentSendId;
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

    public int getNumDateProcess() {
        return _numDateProcess;
    }

    public void setNumDateProcess(int numDateProcess) {
        if (numDateProcess != _numDateProcess) {
            _numDateProcess = numDateProcess;
        }
    }

    public long getProcessInstanceId() {
        return _processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        if (processInstanceId != _processInstanceId) {
            _processInstanceId = processInstanceId;
        }
    }

    public int getType_() {
        return _type_;
    }

    public void setType_(int type_) {
        if (type_ != _type_) {
            _type_ = type_;
        }
    }

    public Date getSendDateBefore() {
        return _sendDateBefore;
    }

    public void setSendDateBefore(Date sendDateBefore) {
        if (((sendDateBefore == null) && (_sendDateBefore != null)) ||
                ((sendDateBefore != null) && (_sendDateBefore == null)) ||
                ((sendDateBefore != null) && (_sendDateBefore != null) &&
                !sendDateBefore.equals(_sendDateBefore))) {
            _sendDateBefore = sendDateBefore;
        }
    }

    public String getDepartmentReceiveId() {
        return GetterUtil.getString(_departmentReceiveId);
    }

    public void setDepartmentReceiveId(String departmentReceiveId) {
        if (((departmentReceiveId == null) && (_departmentReceiveId != null)) ||
                ((departmentReceiveId != null) &&
                (_departmentReceiveId == null)) ||
                ((departmentReceiveId != null) &&
                (_departmentReceiveId != null) &&
                !departmentReceiveId.equals(_departmentReceiveId))) {
            _departmentReceiveId = departmentReceiveId;
        }
    }

    public String getDepartmentProcessId() {
        return GetterUtil.getString(_departmentProcessId);
    }

    public void setDepartmentProcessId(String departmentProcessId) {
        if (((departmentProcessId == null) && (_departmentProcessId != null)) ||
                ((departmentProcessId != null) &&
                (_departmentProcessId == null)) ||
                ((departmentProcessId != null) &&
                (_departmentProcessId != null) &&
                !departmentProcessId.equals(_departmentProcessId))) {
            _departmentProcessId = departmentProcessId;
        }
    }

    public Date getDateProcessTime() {
        return _dateProcessTime;
    }

    public void setDateProcessTime(Date dateProcessTime) {
        if (((dateProcessTime == null) && (_dateProcessTime != null)) ||
                ((dateProcessTime != null) && (_dateProcessTime == null)) ||
                ((dateProcessTime != null) && (_dateProcessTime != null) &&
                !dateProcessTime.equals(_dateProcessTime))) {
            _dateProcessTime = dateProcessTime;
        }
    }

    public Date getReceiveDateTime() {
        return _receiveDateTime;
    }

    public void setReceiveDateTime(Date receiveDateTime) {
        if (((receiveDateTime == null) && (_receiveDateTime != null)) ||
                ((receiveDateTime != null) && (_receiveDateTime == null)) ||
                ((receiveDateTime != null) && (_receiveDateTime != null) &&
                !receiveDateTime.equals(_receiveDateTime))) {
            _receiveDateTime = receiveDateTime;
        }
    }

    public long getDirectProcesserId() {
        return _directProcesserId;
    }

    public void setDirectProcesserId(long directProcesserId) {
        if (directProcesserId != _directProcesserId) {
            _directProcesserId = directProcesserId;
        }
    }

    public int getStep() {
        return _step;
    }

    public void setStep(int step) {
        if (step != _step) {
            _step = step;
        }
    }

    public PmlDocumentSendLog toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDocumentSendLog) this;
        } else {
            PmlDocumentSendLog model = new PmlDocumentSendLogImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentSendLogId(getDocumentSendLogId());
            model.setDocumentSendId(getDocumentSendId());
            model.setTransition_(getTransition_());
            model.setProcesser(getProcesser());
            model.setDateProcess(getDateProcess());
            model.setProcessInfomation(HtmlUtil.escape(getProcessInfomation()));
            model.setReceiver(getReceiver());
            model.setReceiveDate(getReceiveDate());
            model.setStateProcessIdBefore(getStateProcessIdBefore());
            model.setStateProcessIdAfter(getStateProcessIdAfter());
            model.setExpiredDate(getExpiredDate());
            model.setNumDateProcess(getNumDateProcess());
            model.setProcessInstanceId(getProcessInstanceId());
            model.setType_(getType_());
            model.setSendDateBefore(getSendDateBefore());
            model.setDepartmentReceiveId(HtmlUtil.escape(
                    getDepartmentReceiveId()));
            model.setDepartmentProcessId(HtmlUtil.escape(
                    getDepartmentProcessId()));
            model.setDateProcessTime(getDateProcessTime());
            model.setReceiveDateTime(getReceiveDateTime());
            model.setDirectProcesserId(getDirectProcesserId());
            model.setStep(getStep());

            model = (PmlDocumentSendLog) Proxy.newProxyInstance(PmlDocumentSendLog.class.getClassLoader(),
                    new Class[] { PmlDocumentSendLog.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDocumentSendLogImpl clone = new PmlDocumentSendLogImpl();

        clone.setDocumentSendLogId(getDocumentSendLogId());
        clone.setDocumentSendId(getDocumentSendId());
        clone.setTransition_(getTransition_());
        clone.setProcesser(getProcesser());
        clone.setDateProcess(getDateProcess());
        clone.setProcessInfomation(getProcessInfomation());
        clone.setReceiver(getReceiver());
        clone.setReceiveDate(getReceiveDate());
        clone.setStateProcessIdBefore(getStateProcessIdBefore());
        clone.setStateProcessIdAfter(getStateProcessIdAfter());
        clone.setExpiredDate(getExpiredDate());
        clone.setNumDateProcess(getNumDateProcess());
        clone.setProcessInstanceId(getProcessInstanceId());
        clone.setType_(getType_());
        clone.setSendDateBefore(getSendDateBefore());
        clone.setDepartmentReceiveId(getDepartmentReceiveId());
        clone.setDepartmentProcessId(getDepartmentProcessId());
        clone.setDateProcessTime(getDateProcessTime());
        clone.setReceiveDateTime(getReceiveDateTime());
        clone.setDirectProcesserId(getDirectProcesserId());
        clone.setStep(getStep());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDocumentSendLogImpl pmlDocumentSendLog = (PmlDocumentSendLogImpl) obj;

        int value = 0;

        if (getDocumentSendLogId() < pmlDocumentSendLog.getDocumentSendLogId()) {
            value = -1;
        } else if (getDocumentSendLogId() > pmlDocumentSendLog.getDocumentSendLogId()) {
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

        PmlDocumentSendLogImpl pmlDocumentSendLog = null;

        try {
            pmlDocumentSendLog = (PmlDocumentSendLogImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlDocumentSendLog.getPrimaryKey();

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
