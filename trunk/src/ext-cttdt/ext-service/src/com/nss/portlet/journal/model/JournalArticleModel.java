package com.nss.portlet.journal.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="JournalArticleModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalArticle</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalArticle
 * @see com.nss.portlet.journal.model.impl.JournalArticleImpl
 * @see com.nss.portlet.journal.model.impl.JournalArticleModelImpl
 *
 */
public interface JournalArticleModel extends BaseModel<JournalArticle> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public String getUuid();

    public void setUuid(String uuid);

    public long getId();

    public void setId(long id);

    public long getResourcePrimKey();

    public void setResourcePrimKey(long resourcePrimKey);

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

    public String getArticleId();

    public void setArticleId(String articleId);

    public double getVersion();

    public void setVersion(double version);

    public String getTitle();

    public void setTitle(String title);

    public String getUrlTitle();

    public void setUrlTitle(String urlTitle);

    public String getDescription();

    public void setDescription(String description);

    public String getContent();

    public void setContent(String content);

    public String getType();

    public void setType(String type);

    public String getStructureId();

    public void setStructureId(String structureId);

    public String getTemplateId();

    public void setTemplateId(String templateId);

    public Date getDisplayDate();

    public void setDisplayDate(Date displayDate);

    public boolean getApproved();

    public boolean isApproved();

    public void setApproved(boolean approved);

    public long getApprovedByUserId();

    public void setApprovedByUserId(long approvedByUserId);

    public String getApprovedByUserName();

    public void setApprovedByUserName(String approvedByUserName);

    public Date getApprovedDate();

    public void setApprovedDate(Date approvedDate);

    public boolean getExpired();

    public boolean isExpired();

    public void setExpired(boolean expired);

    public Date getExpirationDate();

    public void setExpirationDate(Date expirationDate);

    public Date getReviewDate();

    public void setReviewDate(Date reviewDate);

    public boolean getIndexable();

    public boolean isIndexable();

    public void setIndexable(boolean indexable);

    public boolean getSmallImage();

    public boolean isSmallImage();

    public void setSmallImage(boolean smallImage);

    public long getSmallImageId();

    public void setSmallImageId(long smallImageId);

    public String getSmallImageURL();

    public void setSmallImageURL(String smallImageURL);

    public JournalArticle toEscapedModel();
}
