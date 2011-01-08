package com.sgs.portlet.nation.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="NationModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Nation</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.nation.model.Nation
 * @see com.sgs.portlet.nation.model.impl.NationImpl
 * @see com.sgs.portlet.nation.model.impl.NationModelImpl
 *
 */
public interface NationModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getNationId();

    public void setNationId(String nationId);

    public String getNationCode();

    public void setNationCode(String nationCode);

    public String getNationName();

    public void setNationName(String nationName);

    public String getCountryId();

    public void setCountryId(String countryId);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public Nation toEscapedModel();
}
