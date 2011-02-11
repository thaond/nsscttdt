package com.sgs.portlet.citymanagement.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="CityModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>City</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.citymanagement.model.City
 * @see com.sgs.portlet.citymanagement.model.impl.CityImpl
 * @see com.sgs.portlet.citymanagement.model.impl.CityModelImpl
 *
 */
public interface CityModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getCityID();

    public void setCityID(String cityID);

    public String getCityCode();

    public void setCityCode(String cityCode);

    public String getCityName();

    public void setCityName(String cityName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public String getCountryId();

    public void setCountryId(String countryId);

    public City toEscapedModel();
}
