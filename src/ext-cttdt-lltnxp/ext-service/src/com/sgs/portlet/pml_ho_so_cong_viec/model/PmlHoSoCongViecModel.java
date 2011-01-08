package com.sgs.portlet.pml_ho_so_cong_viec.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlHoSoCongViecModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlHoSoCongViec</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlHoSoCongViecImpl
 * @see com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlHoSoCongViecModelImpl
 *
 */
public interface PmlHoSoCongViecModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getIdHoSoCongViec();

    public void setIdHoSoCongViec(long idHoSoCongViec);

    public long getUserId();

    public void setUserId(long userId);

    public String getUserName();

    public void setUserName(String userName);

    public long getIdHSCVCha();

    public void setIdHSCVCha(long idHSCVCha);

    public String getSoHieuHSCV();

    public void setSoHieuHSCV(String soHieuHSCV);

    public String getTieuDe();

    public void setTieuDe(String tieuDe);

    public Date getNgayMoHSCV();

    public void setNgayMoHSCV(Date ngayMoHSCV);

    public Date getHanXuLy();

    public void setHanXuLy(Date hanXuLy);

    public String getIdLinhVuc();

    public void setIdLinhVuc(String idLinhVuc);

    public String getVanDeLienQuan();

    public void setVanDeLienQuan(String vanDeLienQuan);

    public long getIdDoQuanTrong();

    public void setIdDoQuanTrong(long idDoQuanTrong);

    public long getIdTinhChat();

    public void setIdTinhChat(long idTinhChat);

    public long getIdTrangThaiHSCV();

    public void setIdTrangThaiHSCV(long idTrangThaiHSCV);

    public String getTomTatNoiDung();

    public void setTomTatNoiDung(String tomTatNoiDung);

    public String getHoatDong();

    public void setHoatDong(String hoatDong);

    public PmlHoSoCongViec toEscapedModel();
}
