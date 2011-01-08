package com.sgs.portlet.pmlstreet.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlStreetModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlStreet</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlstreet.model.PmlStreet
 * @see com.sgs.portlet.pmlstreet.model.impl.PmlStreetImpl
 * @see com.sgs.portlet.pmlstreet.model.impl.PmlStreetModelImpl
 *
 */
public interface PmlStreetModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getStreetId();

    public void setStreetId(String streetId);

    public String getStreetName();

    public void setStreetName(String streetName);

    public PmlStreet toEscapedModel();
}
