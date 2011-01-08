package com.sgs.portlet.pmlissuingplace.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmIssuingPlaceModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmIssuingPlace</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace
 * @see com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceImpl
 * @see com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceModelImpl
 *
 */
public interface PmlEdmIssuingPlaceModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getIssuingPlaceId();

    public void setIssuingPlaceId(String issuingPlaceId);

    public String getIssuingPlaceName();

    public void setIssuingPlaceName(String issuingPlaceName);

    public String getTablePhone();

    public void setTablePhone(String tablePhone);

    public String getHandPhone();

    public void setHandPhone(String handPhone);

    public String getEmail();

    public void setEmail(String email);

    public String getAddress();

    public void setAddress(String address);

    public String getActive();

    public void setActive(String active);

    public String getNote();

    public void setNote(String note);

    public String getIssuingPlaceCode();

    public void setIssuingPlaceCode(String issuingPlaceCode);

    public String getSigner();

    public void setSigner(String signer);

    public PmlEdmIssuingPlace toEscapedModel();
}
