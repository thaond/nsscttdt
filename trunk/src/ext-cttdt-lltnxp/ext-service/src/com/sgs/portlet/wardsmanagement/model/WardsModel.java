package com.sgs.portlet.wardsmanagement.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="WardsModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Wards</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.wardsmanagement.model.Wards
 * @see com.sgs.portlet.wardsmanagement.model.impl.WardsImpl
 * @see com.sgs.portlet.wardsmanagement.model.impl.WardsModelImpl
 *
 */
public interface WardsModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getWardsId();

    public void setWardsId(String wardsId);

    public String getWardsCode();

    public void setWardsCode(String wardsCode);

    public String getWardsName();

    public void setWardsName(String wardsName);

    public String getDistrictId();

    public void setDistrictId(String districtId);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public Wards toEscapedModel();
}
