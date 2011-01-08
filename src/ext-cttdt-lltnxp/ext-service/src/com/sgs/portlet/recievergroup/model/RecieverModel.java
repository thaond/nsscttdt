package com.sgs.portlet.recievergroup.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="RecieverModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Reciever</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.model.Reciever
 * @see com.sgs.portlet.recievergroup.model.impl.RecieverImpl
 * @see com.sgs.portlet.recievergroup.model.impl.RecieverModelImpl
 *
 */
public interface RecieverModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getRecieverId();

    public void setRecieverId(long recieverId);

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

    public long getRecieverUserId();

    public void setRecieverUserId(long recieverUserId);

    public String getRecieverUserName();

    public void setRecieverUserName(String recieverUserName);

    public String getViewName();

    public void setViewName(String viewName);

    public int getRecieverType();

    public void setRecieverType(int recieverType);

    public Reciever toEscapedModel();
}
