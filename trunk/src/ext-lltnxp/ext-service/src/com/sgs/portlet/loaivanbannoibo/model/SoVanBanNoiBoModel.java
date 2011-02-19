package com.sgs.portlet.loaivanbannoibo.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="SoVanBanNoiBoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>SoVanBanNoiBo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.SoVanBanNoiBoImpl
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.SoVanBanNoiBoModelImpl
 *
 */
public interface SoVanBanNoiBoModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getSoVanBanNoiBoId();

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId);

    public String getMaSoVanBanNoiBo();

    public void setMaSoVanBanNoiBo(String maSoVanBanNoiBo);

    public String getTenSoVanBanNoiBo();

    public void setTenSoVanBanNoiBo(String tenSoVanBanNoiBo);

    public Date getNgayTao();

    public void setNgayTao(Date ngayTao);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public SoVanBanNoiBo toEscapedModel();
}
