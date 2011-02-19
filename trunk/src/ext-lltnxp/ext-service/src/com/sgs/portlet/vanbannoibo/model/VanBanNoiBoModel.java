package com.sgs.portlet.vanbannoibo.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="VanBanNoiBoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>VanBanNoiBo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.model.VanBanNoiBo
 * @see com.sgs.portlet.vanbannoibo.model.impl.VanBanNoiBoImpl
 * @see com.sgs.portlet.vanbannoibo.model.impl.VanBanNoiBoModelImpl
 *
 */
public interface VanBanNoiBoModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getVanBanNoiBoId();

    public void setVanBanNoiBoId(long vanBanNoiBoId);

    public long getLoaiVanBanNoiBo();

    public void setLoaiVanBanNoiBo(long loaiVanBanNoiBo);

    public long getSoVanBanNoiBo();

    public void setSoVanBanNoiBo(long soVanBanNoiBo);

    public Date getNgayTao();

    public void setNgayTao(Date ngayTao);

    public Date getNgayKy();

    public void setNgayKy(Date ngayKy);

    public String getTrichYeu();

    public void setTrichYeu(String trichYeu);

    public long getNguoiKy();

    public void setNguoiKy(long nguoiKy);

    public String getGhiChu();

    public void setGhiChu(String ghiChu);

    public String getSoVaoSoVanBanNoiBo();

    public void setSoVaoSoVanBanNoiBo(String soVaoSoVanBanNoiBo);

    public int getSoPhatSinhTheoNam();

    public void setSoPhatSinhTheoNam(int soPhatSinhTheoNam);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public VanBanNoiBo toEscapedModel();
}
