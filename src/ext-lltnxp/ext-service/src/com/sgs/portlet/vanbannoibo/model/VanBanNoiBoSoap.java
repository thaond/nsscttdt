package com.sgs.portlet.vanbannoibo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="VanBanNoiBoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.vanbannoibo.service.http.VanBanNoiBoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.http.VanBanNoiBoServiceSoap
 *
 */
public class VanBanNoiBoSoap implements Serializable {
    private long _vanBanNoiBoId;
    private long _loaiVanBanNoiBo;
    private Date _ngayTao;
    private Date _ngayKy;
    private String _trichYeu;
    private long _nguoiKy;
    private String _ghiChu;
    private String _soVanBanNoiBo;
    private String _soPhatSinhTheoNam;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public VanBanNoiBoSoap() {
    }

    public static VanBanNoiBoSoap toSoapModel(VanBanNoiBo model) {
        VanBanNoiBoSoap soapModel = new VanBanNoiBoSoap();

        soapModel.setVanBanNoiBoId(model.getVanBanNoiBoId());
        soapModel.setLoaiVanBanNoiBo(model.getLoaiVanBanNoiBo());
        soapModel.setNgayTao(model.getNgayTao());
        soapModel.setNgayKy(model.getNgayKy());
        soapModel.setTrichYeu(model.getTrichYeu());
        soapModel.setNguoiKy(model.getNguoiKy());
        soapModel.setGhiChu(model.getGhiChu());
        soapModel.setSoVanBanNoiBo(model.getSoVanBanNoiBo());
        soapModel.setSoPhatSinhTheoNam(model.getSoPhatSinhTheoNam());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static VanBanNoiBoSoap[] toSoapModels(List<VanBanNoiBo> models) {
        List<VanBanNoiBoSoap> soapModels = new ArrayList<VanBanNoiBoSoap>(models.size());

        for (VanBanNoiBo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new VanBanNoiBoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _vanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setVanBanNoiBoId(pk);
    }

    public long getVanBanNoiBoId() {
        return _vanBanNoiBoId;
    }

    public void setVanBanNoiBoId(long vanBanNoiBoId) {
        _vanBanNoiBoId = vanBanNoiBoId;
    }

    public long getLoaiVanBanNoiBo() {
        return _loaiVanBanNoiBo;
    }

    public void setLoaiVanBanNoiBo(long loaiVanBanNoiBo) {
        _loaiVanBanNoiBo = loaiVanBanNoiBo;
    }

    public Date getNgayTao() {
        return _ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        _ngayTao = ngayTao;
    }

    public Date getNgayKy() {
        return _ngayKy;
    }

    public void setNgayKy(Date ngayKy) {
        _ngayKy = ngayKy;
    }

    public String getTrichYeu() {
        return _trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        _trichYeu = trichYeu;
    }

    public long getNguoiKy() {
        return _nguoiKy;
    }

    public void setNguoiKy(long nguoiKy) {
        _nguoiKy = nguoiKy;
    }

    public String getGhiChu() {
        return _ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        _ghiChu = ghiChu;
    }

    public String getSoVanBanNoiBo() {
        return _soVanBanNoiBo;
    }

    public void setSoVanBanNoiBo(String soVanBanNoiBo) {
        _soVanBanNoiBo = soVanBanNoiBo;
    }

    public String getSoPhatSinhTheoNam() {
        return _soPhatSinhTheoNam;
    }

    public void setSoPhatSinhTheoNam(String soPhatSinhTheoNam) {
        _soPhatSinhTheoNam = soPhatSinhTheoNam;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }
}
