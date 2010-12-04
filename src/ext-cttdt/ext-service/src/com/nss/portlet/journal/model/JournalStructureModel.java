package com.nss.portlet.journal.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="JournalStructureModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalStructure</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalStructure
 * @see com.nss.portlet.journal.model.impl.JournalStructureImpl
 * @see com.nss.portlet.journal.model.impl.JournalStructureModelImpl
 *
 */
public interface JournalStructureModel extends BaseModel<JournalStructure> {
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

    public String getStructureId();

    public void setStructureId(String structureId);

    public String getParentStructureId();

    public void setParentStructureId(String parentStructureId);

    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public String getXsd();

    public void setXsd(String xsd);

    public JournalStructure toEscapedModel();
}
