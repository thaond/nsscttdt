package com.sgs.portlet.loaivanbannoibo.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.loaivanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK;


/**
 * <a href="SoLoaiVanBanNoiBoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>SoLoaiVanBanNoiBo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.SoLoaiVanBanNoiBoImpl
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.SoLoaiVanBanNoiBoModelImpl
 *
 */
public interface SoLoaiVanBanNoiBoModel extends BaseModel {
    public SoLoaiVanBanNoiBoPK getPrimaryKey();

    public void setPrimaryKey(SoLoaiVanBanNoiBoPK pk);

    public long getSoVanBanNoiBoId();

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId);

    public long getLoaiVanBanNoiBoId();

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId);

    public SoLoaiVanBanNoiBo toEscapedModel();
}
