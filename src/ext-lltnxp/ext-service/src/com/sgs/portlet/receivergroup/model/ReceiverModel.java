package com.sgs.portlet.receivergroup.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="ReceiverModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Receiver</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.model.Receiver
 * @see com.sgs.portlet.receivergroup.model.impl.ReceiverImpl
 * @see com.sgs.portlet.receivergroup.model.impl.ReceiverModelImpl
 *
 */
public interface ReceiverModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getReceiverId();

    public void setReceiverId(long receiverId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public String getUserName();

    public void setUserName(String userName);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public Date getModifiedDate();

    public void setModifiedDate(Date modifiedDate);

    public long getReceiverUserId();

    public void setReceiverUserId(long receiverUserId);

    public String getReceiverUserName();

    public void setReceiverUserName(String receiverUserName);

    public String getViewName();

    public void setViewName(String viewName);

    public int getReceiverType();

    public void setReceiverType(int receiverType);

    public Receiver toEscapedModel();
}
