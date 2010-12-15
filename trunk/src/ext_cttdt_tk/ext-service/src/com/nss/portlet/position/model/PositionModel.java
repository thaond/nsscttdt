package com.nss.portlet.position.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PositionModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Position</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.position.model.Position
 * @see com.nss.portlet.position.model.impl.PositionImpl
 * @see com.nss.portlet.position.model.impl.PositionModelImpl
 *
 */
public interface PositionModel extends BaseModel<Position> {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getPositionId();

    public void setPositionId(String positionId);

    public String getPositionCode();

    public void setPositionCode(String positionCode);

    public String getPositionName();

    public void setPositionName(String positionName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public Position toEscapedModel();
}
