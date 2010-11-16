package com.liferay.portlet.messageboards.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MBBanModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBBan</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBBan
 * @see com.liferay.portlet.messageboards.model.impl.MBBanImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBBanModelImpl
 *
 */
public interface MBBanModel extends BaseModel<MBBan> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getBanId();

    public void setBanId(long banId);

    public long getGroupId();

    public void setGroupId(long groupId);

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

    public long getBanUserId();

    public void setBanUserId(long banUserId);

    public MBBan toEscapedModel();
}
