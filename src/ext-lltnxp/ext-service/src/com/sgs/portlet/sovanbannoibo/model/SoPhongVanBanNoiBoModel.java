package com.sgs.portlet.sovanbannoibo.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK;


/**
 * <a href="SoPhongVanBanNoiBoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>SoPhongVanBanNoiBo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo
 * @see com.sgs.portlet.sovanbannoibo.model.impl.SoPhongVanBanNoiBoImpl
 * @see com.sgs.portlet.sovanbannoibo.model.impl.SoPhongVanBanNoiBoModelImpl
 *
 */
public interface SoPhongVanBanNoiBoModel extends BaseModel {
    public SoPhongVanBanNoiBoPK getPrimaryKey();

    public void setPrimaryKey(SoPhongVanBanNoiBoPK pk);

    public long getSoVanBanNoiBoId();

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId);

    public String getPhongVanBanNoiBoId();

    public void setPhongVanBanNoiBoId(String phongVanBanNoiBoId);

    public SoPhongVanBanNoiBo toEscapedModel();
}
