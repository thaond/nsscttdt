package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlDocumentSendLogModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDocumentSendLog</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentSendLog
 * @see com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl
 * @see com.sgs.portlet.document.model.impl.PmlDocumentSendLogModelImpl
 *
 */
public interface PmlDocumentSendLogModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentSendLogId();

    public void setDocumentSendLogId(long documentSendLogId);

    public long getDocumentSendId();

    public void setDocumentSendId(long documentSendId);

    public int getTransition_();

    public void setTransition_(int transition_);

    public long getProcesser();

    public void setProcesser(long processer);

    public Date getDateProcess();

    public void setDateProcess(Date dateProcess);

    public String getProcessInfomation();

    public void setProcessInfomation(String processInfomation);

    public long getReceiver();

    public void setReceiver(long receiver);

    public Date getReceiveDate();

    public void setReceiveDate(Date receiveDate);

    public long getStateProcessIdBefore();

    public void setStateProcessIdBefore(long stateProcessIdBefore);

    public long getStateProcessIdAfter();

    public void setStateProcessIdAfter(long stateProcessIdAfter);

    public Date getExpiredDate();

    public void setExpiredDate(Date expiredDate);

    public int getNumDateProcess();

    public void setNumDateProcess(int numDateProcess);

    public long getProcessInstanceId();

    public void setProcessInstanceId(long processInstanceId);

    public int getType_();

    public void setType_(int type_);

    public Date getSendDateBefore();

    public void setSendDateBefore(Date sendDateBefore);

    public String getDepartmentReceiveId();

    public void setDepartmentReceiveId(String departmentReceiveId);

    public String getDepartmentProcessId();

    public void setDepartmentProcessId(String departmentProcessId);

    public Date getDateProcessTime();

    public void setDateProcessTime(Date dateProcessTime);

    public Date getReceiveDateTime();

    public void setReceiveDateTime(Date receiveDateTime);

    public long getDirectProcesserId();

    public void setDirectProcesserId(long directProcesserId);

    public int getStep();

    public void setStep(int step);

    public PmlDocumentSendLog toEscapedModel();
}
