package com.sgs.portlet.vanbannoibo.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="LogVanBanNoiBoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LogVanBanNoiBo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo
 * @see com.sgs.portlet.vanbannoibo.model.impl.LogVanBanNoiBoImpl
 * @see com.sgs.portlet.vanbannoibo.model.impl.LogVanBanNoiBoModelImpl
 *
 */
public interface LogVanBanNoiBoModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getLogVanBanNoiBoId();

    public void setLogVanBanNoiBoId(long logVanBanNoiBoId);

    public int getBuocLuanChuyen();

    public void setBuocLuanChuyen(int buocLuanChuyen);

    public long getNguoiXuLy();

    public void setNguoiXuLy(long nguoiXuLy);

    public Date getNgayXuLy();

    public void setNgayXuLy(Date ngayXuLy);

    public long getNguoiNhan();

    public void setNguoiNhan(long nguoiNhan);

    public Date getNgayNhan();

    public void setNgayNhan(Date ngayNhan);

    public String getTrangThaiTruoc();

    public void setTrangThaiTruoc(String trangThaiTruoc);

    public String getTrangThaiSau();

    public void setTrangThaiSau(String trangThaiSau);

    public Date getNgayGui();

    public void setNgayGui(Date ngayGui);

    public long getPhongXuLyChinh();

    public void setPhongXuLyChinh(long phongXuLyChinh);

    public long getNguoiXuLyChinh();

    public void setNguoiXuLyChinh(long nguoiXuLyChinh);

    public int getLoaiQuyTrinh();

    public void setLoaiQuyTrinh(int loaiQuyTrinh);

    public Date getNgayHetHan();

    public void setNgayHetHan(Date ngayHetHan);

    public int getSoNgayXuLy();

    public void setSoNgayXuLy(int soNgayXuLy);

    public long getProcessInstanceId();

    public void setProcessInstanceId(long processInstanceId);

    public String getThongTinXuLy();

    public void setThongTinXuLy(String thongTinXuLy);

    public int getStep();

    public void setStep(int step);

    public long getNguoiXuLyTrucTiep();

    public void setNguoiXuLyTrucTiep(long nguoiXuLyTrucTiep);

    public long getPhongXuLy();

    public void setPhongXuLy(long phongXuLy);

    public long getPhongNhan();

    public void setPhongNhan(long phongNhan);

    public boolean getVanBanHoanThanhHayChua();

    public boolean isVanBanHoanThanhHayChua();

    public void setVanBanHoanThanhHayChua(boolean vanBanHoanThanhHayChua);

    public long getVanBanNoiBoId();

    public void setVanBanNoiBoId(long vanBanNoiBoId);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public LogVanBanNoiBo toEscapedModel();
}
