package com.sgs.portlet.loaivanbannoibo.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK;


/**
 * <a href="LoaiPhongVanBanNoiBoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LoaiPhongVanBanNoiBo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.LoaiPhongVanBanNoiBoImpl
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.LoaiPhongVanBanNoiBoModelImpl
 *
 */
public interface LoaiPhongVanBanNoiBoModel extends BaseModel {
    public LoaiPhongVanBanNoiBoPK getPrimaryKey();

    public void setPrimaryKey(LoaiPhongVanBanNoiBoPK pk);

    public long getLoaiVanBanNoiBoId();

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId);

    public long getPhongVanBanNoiBoId();

    public void setPhongVanBanNoiBoId(long phongVanBanNoiBoId);

    public LoaiPhongVanBanNoiBo toEscapedModel();
}
