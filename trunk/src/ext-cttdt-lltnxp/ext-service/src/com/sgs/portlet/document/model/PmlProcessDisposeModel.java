package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlProcessDisposeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlProcessDispose</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlProcessDispose
 * @see com.sgs.portlet.document.model.impl.PmlProcessDisposeImpl
 * @see com.sgs.portlet.document.model.impl.PmlProcessDisposeModelImpl
 *
 */
public interface PmlProcessDisposeModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getProcessDisposeId();

    public void setProcessDisposeId(long processDisposeId);

    public String getFileId();

    public void setFileId(String fileId);

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

    public long getDelegateUser();

    public void setDelegateUser(long delegateUser);

    public Date getSendDate();

    public void setSendDate(Date sendDate);

    public PmlProcessDispose toEscapedModel();
}
