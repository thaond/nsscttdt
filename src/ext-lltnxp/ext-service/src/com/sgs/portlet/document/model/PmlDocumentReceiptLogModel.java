package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlDocumentReceiptLogModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDocumentReceiptLog</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentReceiptLog
 * @see com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogImpl
 * @see com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogModelImpl
 *
 */
public interface PmlDocumentReceiptLogModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentReceiptLogId();

    public void setDocumentReceiptLogId(long documentReceiptLogId);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

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

    public int getType_();

    public void setType_(int type_);

    public Date getExpiredDate();

    public void setExpiredDate(Date expiredDate);

    public int getNumDateProcess();

    public void setNumDateProcess(int numDateProcess);

    public long getProcessInstanceId();

    public void setProcessInstanceId(long processInstanceId);

    public String getMainDepartmentProcessId();

    public void setMainDepartmentProcessId(String mainDepartmentProcessId);

    public long getMainUserProcessId();

    public void setMainUserProcessId(long mainUserProcessId);

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

    public PmlDocumentReceiptLog toEscapedModel();
}
