package com.nss.portlet.delegate.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlDelegateModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDelegate</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.delegate.model.PmlDelegate
 * @see com.nss.portlet.delegate.model.impl.PmlDelegateImpl
 * @see com.nss.portlet.delegate.model.impl.PmlDelegateModelImpl
 *
 */
public interface PmlDelegateModel extends BaseModel<PmlDelegate> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDelegateId();

    public void setDelegateId(long delegateId);

    public long getAssigner();

    public void setAssigner(long assigner);

    public long getReceiver();

    public void setReceiver(long receiver);

    public Date getStartDate();

    public void setStartDate(Date startDate);

    public Date getEndDate();

    public void setEndDate(Date endDate);

    public Date getCancelDate();

    public void setCancelDate(Date cancelDate);

    public String getCancelDelegate();

    public void setCancelDelegate(String cancelDelegate);

    public Date getDateCreated();

    public void setDateCreated(Date dateCreated);

    public PmlDelegate toEscapedModel();
}
