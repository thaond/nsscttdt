package com.sgs.portlet.sovanbannoibo.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="LoaiVanBanNoiBoCuaSoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LoaiVanBanNoiBoCuaSo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo
 * @see com.sgs.portlet.sovanbannoibo.model.impl.LoaiVanBanNoiBoCuaSoImpl
 * @see com.sgs.portlet.sovanbannoibo.model.impl.LoaiVanBanNoiBoCuaSoModelImpl
 *
 */
public interface LoaiVanBanNoiBoCuaSoModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getLoaiVanBanNoiBoId();

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId);

    public String getKyHieuLoaiVanBanNoiBo();

    public void setKyHieuLoaiVanBanNoiBo(String kyHieuLoaiVanBanNoiBo);

    public String getTenLoaiVanBanNoiBo();

    public void setTenLoaiVanBanNoiBo(String tenLoaiVanBanNoiBo);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public LoaiVanBanNoiBoCuaSo toEscapedModel();
}
