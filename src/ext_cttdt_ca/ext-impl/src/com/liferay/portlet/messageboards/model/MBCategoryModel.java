package com.liferay.portlet.messageboards.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MBCategoryModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBCategory</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBCategory
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryModelImpl
 *
 */
public interface MBCategoryModel extends BaseModel<MBCategory> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public String getUuid();

    public void setUuid(String uuid);

    public long getCategoryId();

    public void setCategoryId(long categoryId);

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

    public long getParentCategoryId();

    public void setParentCategoryId(long parentCategoryId);

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public int getThreadCount();

    public void setThreadCount(int threadCount);

    public int getMessageCount();

    public void setMessageCount(int messageCount);

    public Date getLastPostDate();

    public void setLastPostDate(Date lastPostDate);

    public long getImage_liferay();

    public void setImage_liferay(long image_liferay);

    public int getOrderNumber();

    public void setOrderNumber(int orderNumber);

    public MBCategory toEscapedModel();
}
