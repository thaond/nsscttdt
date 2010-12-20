package com.nss.portlet.van_ban_phap_quy.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="VanBanPhapQuySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.van_ban_phap_quy.service.http.VanBanPhapQuyServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.service.http.VanBanPhapQuyServiceSoap
 *
 */
public class VanBanPhapQuySoap implements Serializable {
    private long _maVanBanPhapQuy;
    private String _kyHieuVanBan;
    private long _maLoaiVanBan;
    private long _maLinhVucVanBan;
    private String _tomTat;
    private String _nguon;
    private String _noiDung;
    private Date _ngayKy;
    private Date _ngayCoHieuLuc;
    private String _nguoiKy;
    private Date _ngayBanHanh;
    private Date _ngayHetHieuLuc;
    private long _maCoQuanBanHanh;
    private String _tag_;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;

    public VanBanPhapQuySoap() {
    }

    public static VanBanPhapQuySoap toSoapModel(VanBanPhapQuy model) {
        VanBanPhapQuySoap soapModel = new VanBanPhapQuySoap();

        soapModel.setMaVanBanPhapQuy(model.getMaVanBanPhapQuy());
        soapModel.setKyHieuVanBan(model.getKyHieuVanBan());
        soapModel.setMaLoaiVanBan(model.getMaLoaiVanBan());
        soapModel.setMaLinhVucVanBan(model.getMaLinhVucVanBan());
        soapModel.setTomTat(model.getTomTat());
        soapModel.setNguon(model.getNguon());
        soapModel.setNoiDung(model.getNoiDung());
        soapModel.setNgayKy(model.getNgayKy());
        soapModel.setNgayCoHieuLuc(model.getNgayCoHieuLuc());
        soapModel.setNguoiKy(model.getNguoiKy());
        soapModel.setNgayBanHanh(model.getNgayBanHanh());
        soapModel.setNgayHetHieuLuc(model.getNgayHetHieuLuc());
        soapModel.setMaCoQuanBanHanh(model.getMaCoQuanBanHanh());
        soapModel.setTag_(model.getTag_());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static VanBanPhapQuySoap[] toSoapModels(VanBanPhapQuy[] models) {
        VanBanPhapQuySoap[] soapModels = new VanBanPhapQuySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static VanBanPhapQuySoap[][] toSoapModels(VanBanPhapQuy[][] models) {
        VanBanPhapQuySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new VanBanPhapQuySoap[models.length][models[0].length];
        } else {
            soapModels = new VanBanPhapQuySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static VanBanPhapQuySoap[] toSoapModels(List<VanBanPhapQuy> models) {
        List<VanBanPhapQuySoap> soapModels = new ArrayList<VanBanPhapQuySoap>(models.size());

        for (VanBanPhapQuy model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new VanBanPhapQuySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maVanBanPhapQuy;
    }

    public void setPrimaryKey(long pk) {
        setMaVanBanPhapQuy(pk);
    }

    public long getMaVanBanPhapQuy() {
        return _maVanBanPhapQuy;
    }

    public void setMaVanBanPhapQuy(long maVanBanPhapQuy) {
        _maVanBanPhapQuy = maVanBanPhapQuy;
    }

    public String getKyHieuVanBan() {
        return _kyHieuVanBan;
    }

    public void setKyHieuVanBan(String kyHieuVanBan) {
        _kyHieuVanBan = kyHieuVanBan;
    }

    public long getMaLoaiVanBan() {
        return _maLoaiVanBan;
    }

    public void setMaLoaiVanBan(long maLoaiVanBan) {
        _maLoaiVanBan = maLoaiVanBan;
    }

    public long getMaLinhVucVanBan() {
        return _maLinhVucVanBan;
    }

    public void setMaLinhVucVanBan(long maLinhVucVanBan) {
        _maLinhVucVanBan = maLinhVucVanBan;
    }

    public String getTomTat() {
        return _tomTat;
    }

    public void setTomTat(String tomTat) {
        _tomTat = tomTat;
    }

    public String getNguon() {
        return _nguon;
    }

    public void setNguon(String nguon) {
        _nguon = nguon;
    }

    public String getNoiDung() {
        return _noiDung;
    }

    public void setNoiDung(String noiDung) {
        _noiDung = noiDung;
    }

    public Date getNgayKy() {
        return _ngayKy;
    }

    public void setNgayKy(Date ngayKy) {
        _ngayKy = ngayKy;
    }

    public Date getNgayCoHieuLuc() {
        return _ngayCoHieuLuc;
    }

    public void setNgayCoHieuLuc(Date ngayCoHieuLuc) {
        _ngayCoHieuLuc = ngayCoHieuLuc;
    }

    public String getNguoiKy() {
        return _nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        _nguoiKy = nguoiKy;
    }

    public Date getNgayBanHanh() {
        return _ngayBanHanh;
    }

    public void setNgayBanHanh(Date ngayBanHanh) {
        _ngayBanHanh = ngayBanHanh;
    }

    public Date getNgayHetHieuLuc() {
        return _ngayHetHieuLuc;
    }

    public void setNgayHetHieuLuc(Date ngayHetHieuLuc) {
        _ngayHetHieuLuc = ngayHetHieuLuc;
    }

    public long getMaCoQuanBanHanh() {
        return _maCoQuanBanHanh;
    }

    public void setMaCoQuanBanHanh(long maCoQuanBanHanh) {
        _maCoQuanBanHanh = maCoQuanBanHanh;
    }

    public String getTag_() {
        return _tag_;
    }

    public void setTag_(String tag_) {
        _tag_ = tag_;
    }

    public long getCompanyid() {
        return _companyid;
    }

    public void setCompanyid(long companyid) {
        _companyid = companyid;
    }

    public long getUserid() {
        return _userid;
    }

    public void setUserid(long userid) {
        _userid = userid;
    }

    public Date getCreatedate() {
        return _createdate;
    }

    public void setCreatedate(Date createdate) {
        _createdate = createdate;
    }

    public Date getModifieddate() {
        return _modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        _modifieddate = modifieddate;
    }

    public int getActive() {
        return _active;
    }

    public void setActive(int active) {
        _active = active;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
