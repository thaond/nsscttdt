package com.sgs.portlet.recievergroup.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="RecieverGroupModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>RecieverGroup</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.model.RecieverGroup
 * @see com.sgs.portlet.recievergroup.model.impl.RecieverGroupImpl
 * @see com.sgs.portlet.recievergroup.model.impl.RecieverGroupModelImpl
 *
 */
public interface RecieverGroupModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getRecieverGroupId();

    public void setRecieverGroupId(long recieverGroupId);

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

    public String getRecieverGroupName();

    public void setRecieverGroupName(String recieverGroupName);

    public String getDescription();

    public void setDescription(String description);

    public int getType();

    public void setType(int type);

    public boolean getActive();

    public boolean isActive();

    public void setActive(boolean active);

    public RecieverGroup toEscapedModel();
}
