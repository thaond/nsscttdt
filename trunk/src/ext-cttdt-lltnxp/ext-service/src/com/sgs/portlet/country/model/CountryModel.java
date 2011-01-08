package com.sgs.portlet.country.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="CountryModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Country</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.model.Country
 * @see com.sgs.portlet.country.model.impl.CountryImpl
 * @see com.sgs.portlet.country.model.impl.CountryModelImpl
 *
 */
public interface CountryModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getCountryId();

    public void setCountryId(String countryId);

    public String getCountryCode();

    public void setCountryCode(String countryCode);

    public String getCountryName();

    public void setCountryName(String countryName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public Country toEscapedModel();
}
