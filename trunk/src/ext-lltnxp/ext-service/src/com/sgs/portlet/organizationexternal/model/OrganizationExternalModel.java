package com.sgs.portlet.organizationexternal.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="OrganizationExternalModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>OrganizationExternal</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.organizationexternal.model.OrganizationExternal
 * @see com.sgs.portlet.organizationexternal.model.impl.OrganizationExternalImpl
 * @see com.sgs.portlet.organizationexternal.model.impl.OrganizationExternalModelImpl
 *
 */
public interface OrganizationExternalModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getOrgExternalId();

    public void setOrgExternalId(long orgExternalId);

    public String getOrgExternalCode();

    public void setOrgExternalCode(String orgExternalCode);

    public String getOrgExternalName();

    public void setOrgExternalName(String orgExternalName);

    public boolean getIsOwnerOrg();

    public boolean isIsOwnerOrg();

    public void setIsOwnerOrg(boolean isOwnerOrg);

    public OrganizationExternal toEscapedModel();
}
