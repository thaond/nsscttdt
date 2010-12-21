package com.nss.portlet.agency.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="AgencyModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Agency</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.agency.model.Agency
 * @see com.nss.portlet.agency.model.impl.AgencyImpl
 * @see com.nss.portlet.agency.model.impl.AgencyModelImpl
 *
 */
public interface AgencyModel extends BaseModel<Agency> {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getAgencyId();

    public void setAgencyId(String agencyId);

    public String getAgencyCode();

    public void setAgencyCode(String agencyCode);

    public String getAgencyName();

    public void setAgencyName(String agencyName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public Agency toEscapedModel();
}
