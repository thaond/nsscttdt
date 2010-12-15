package com.nss.portlet.journal.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="JournalTemplateModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalTemplate</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalTemplate
 * @see com.nss.portlet.journal.model.impl.JournalTemplateImpl
 * @see com.nss.portlet.journal.model.impl.JournalTemplateModelImpl
 *
 */
public interface JournalTemplateModel extends BaseModel<JournalTemplate> {
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

    public String getTemplateId();

    public void setTemplateId(String templateId);

    public String getStructureId();

    public void setStructureId(String structureId);

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public String getXsl();

    public void setXsl(String xsl);

    public String getLangType();

    public void setLangType(String langType);

    public boolean getCacheable();

    public boolean isCacheable();

    public void setCacheable(boolean cacheable);

    public boolean getSmallImage();

    public boolean isSmallImage();

    public void setSmallImage(boolean smallImage);

    public long getSmallImageId();

    public void setSmallImageId(long smallImageId);

    public String getSmallImageURL();

    public void setSmallImageURL(String smallImageURL);

    public JournalTemplate toEscapedModel();
}
