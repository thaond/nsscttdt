package com.sgs.portlet.country.pmluserfiletype.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK;


/**
 * <a href="PmlUserFileTypeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlUserFileType</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType
 * @see com.sgs.portlet.country.pmluserfiletype.model.impl.PmlUserFileTypeImpl
 * @see com.sgs.portlet.country.pmluserfiletype.model.impl.PmlUserFileTypeModelImpl
 *
 */
public interface PmlUserFileTypeModel extends BaseModel {
    public PmlUserFileTypePK getPrimaryKey();

    public void setPrimaryKey(PmlUserFileTypePK pk);

    public long getUserId();

    public void setUserId(long userId);

    public String getFileTypeId();

    public void setFileTypeId(String fileTypeId);

    public String getDescription();

    public void setDescription(String description);

    public PmlUserFileType toEscapedModel();
}
