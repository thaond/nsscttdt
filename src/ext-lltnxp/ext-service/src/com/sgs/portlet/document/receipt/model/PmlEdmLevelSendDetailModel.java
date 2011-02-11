package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK;


/**
 * <a href="PmlEdmLevelSendDetailModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmLevelSendDetail</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmLevelSendDetailImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmLevelSendDetailModelImpl
 *
 */
public interface PmlEdmLevelSendDetailModel extends BaseModel {
    public PmlEdmLevelSendDetailPK getPrimaryKey();

    public void setPrimaryKey(PmlEdmLevelSendDetailPK pk);

    public int getLevelSendId();

    public void setLevelSendId(int levelSendId);

    public String getIssuingPlaceId();

    public void setIssuingPlaceId(String issuingPlaceId);

    public PmlEdmLevelSendDetail toEscapedModel();
}
