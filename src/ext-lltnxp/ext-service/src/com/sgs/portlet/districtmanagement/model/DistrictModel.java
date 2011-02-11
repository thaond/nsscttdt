package com.sgs.portlet.districtmanagement.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="DistrictModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>District</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.districtmanagement.model.District
 * @see com.sgs.portlet.districtmanagement.model.impl.DistrictImpl
 * @see com.sgs.portlet.districtmanagement.model.impl.DistrictModelImpl
 *
 */
public interface DistrictModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getDistrictId();

    public void setDistrictId(String districtId);

    public String getDistrictCode();

    public void setDistrictCode(String districtCode);

    public String getDistrictName();

    public void setDistrictName(String districtName);

    public String getCityID();

    public void setCityID(String cityID);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public District toEscapedModel();
}
