package com.nss.portlet.journal.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="JournalFeedModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalFeed</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalFeed
 * @see com.nss.portlet.journal.model.impl.JournalFeedImpl
 * @see com.nss.portlet.journal.model.impl.JournalFeedModelImpl
 *
 */
public interface JournalFeedModel extends BaseModel<JournalFeed> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public String getUuid();

    public void setUuid(String uuid);

    public long getId();

    public void setId(long id);

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

    public String getFeedId();

    public void setFeedId(String feedId);

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public String getType();

    public void setType(String type);

    public String getStructureId();

    public void setStructureId(String structureId);

    public String getTemplateId();

    public void setTemplateId(String templateId);

    public String getRendererTemplateId();

    public void setRendererTemplateId(String rendererTemplateId);

    public int getDelta();

    public void setDelta(int delta);

    public String getOrderByCol();

    public void setOrderByCol(String orderByCol);

    public String getOrderByType();

    public void setOrderByType(String orderByType);

    public String getTargetLayoutFriendlyUrl();

    public void setTargetLayoutFriendlyUrl(String targetLayoutFriendlyUrl);

    public String getTargetPortletId();

    public void setTargetPortletId(String targetPortletId);

    public String getContentField();

    public void setContentField(String contentField);

    public String getFeedType();

    public void setFeedType(String feedType);

    public double getFeedVersion();

    public void setFeedVersion(double feedVersion);

    public JournalFeed toEscapedModel();
}
