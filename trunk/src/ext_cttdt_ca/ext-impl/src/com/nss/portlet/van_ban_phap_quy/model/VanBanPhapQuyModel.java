package com.nss.portlet.van_ban_phap_quy.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="VanBanPhapQuyModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>VanBanPhapQuy</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy
 * @see com.nss.portlet.van_ban_phap_quy.model.impl.VanBanPhapQuyImpl
 * @see com.nss.portlet.van_ban_phap_quy.model.impl.VanBanPhapQuyModelImpl
 *
 */
public interface VanBanPhapQuyModel extends BaseModel<VanBanPhapQuy> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMaVanBanPhapQuy();

    public void setMaVanBanPhapQuy(long maVanBanPhapQuy);

    public String getKyHieuVanBan();

    public void setKyHieuVanBan(String kyHieuVanBan);

    public long getMaLoaiVanBan();

    public void setMaLoaiVanBan(long maLoaiVanBan);

    public long getMaLinhVucVanBan();

    public void setMaLinhVucVanBan(long maLinhVucVanBan);

    public String getTomTat();

    public void setTomTat(String tomTat);

    public String getNguon();

    public void setNguon(String nguon);

    public String getNoiDung();

    public void setNoiDung(String noiDung);

    public Date getNgayKy();

    public void setNgayKy(Date ngayKy);

    public Date getNgayCoHieuLuc();

    public void setNgayCoHieuLuc(Date ngayCoHieuLuc);

    public String getNguoiKy();

    public void setNguoiKy(String nguoiKy);

    public Date getNgayBanHanh();

    public void setNgayBanHanh(Date ngayBanHanh);

    public Date getNgayHetHieuLuc();

    public void setNgayHetHieuLuc(Date ngayHetHieuLuc);

    public long getMaCoQuanBanHanh();

    public void setMaCoQuanBanHanh(long maCoQuanBanHanh);

    public String getTag_();

    public void setTag_(String tag_);

    public long getCompanyid();

    public void setCompanyid(long companyid);

    public long getUserid();

    public void setUserid(long userid);

    public Date getCreatedate();

    public void setCreatedate(Date createdate);

    public Date getModifieddate();

    public void setModifieddate(Date modifieddate);

    public int getActive();

    public void setActive(int active);

    public String getDescription();

    public void setDescription(String description);

    public VanBanPhapQuy toEscapedModel();
}
