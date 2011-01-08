package com.sgs.portlet.pml_ho_so_cong_viec.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlHoSoCongViecSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.http.PmlHoSoCongViecServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.http.PmlHoSoCongViecServiceSoap
 *
 */
public class PmlHoSoCongViecSoap implements Serializable {
    private long _idHoSoCongViec;
    private long _userId;
    private String _userName;
    private long _idHSCVCha;
    private String _soHieuHSCV;
    private String _tieuDe;
    private Date _ngayMoHSCV;
    private Date _hanXuLy;
    private String _idLinhVuc;
    private String _vanDeLienQuan;
    private long _idDoQuanTrong;
    private long _idTinhChat;
    private long _idTrangThaiHSCV;
    private String _tomTatNoiDung;
    private String _hoatDong;

    public PmlHoSoCongViecSoap() {
    }

    public static PmlHoSoCongViecSoap toSoapModel(PmlHoSoCongViec model) {
        PmlHoSoCongViecSoap soapModel = new PmlHoSoCongViecSoap();

        soapModel.setIdHoSoCongViec(model.getIdHoSoCongViec());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setIdHSCVCha(model.getIdHSCVCha());
        soapModel.setSoHieuHSCV(model.getSoHieuHSCV());
        soapModel.setTieuDe(model.getTieuDe());
        soapModel.setNgayMoHSCV(model.getNgayMoHSCV());
        soapModel.setHanXuLy(model.getHanXuLy());
        soapModel.setIdLinhVuc(model.getIdLinhVuc());
        soapModel.setVanDeLienQuan(model.getVanDeLienQuan());
        soapModel.setIdDoQuanTrong(model.getIdDoQuanTrong());
        soapModel.setIdTinhChat(model.getIdTinhChat());
        soapModel.setIdTrangThaiHSCV(model.getIdTrangThaiHSCV());
        soapModel.setTomTatNoiDung(model.getTomTatNoiDung());
        soapModel.setHoatDong(model.getHoatDong());

        return soapModel;
    }

    public static PmlHoSoCongViecSoap[] toSoapModels(
        List<PmlHoSoCongViec> models) {
        List<PmlHoSoCongViecSoap> soapModels = new ArrayList<PmlHoSoCongViecSoap>(models.size());

        for (PmlHoSoCongViec model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlHoSoCongViecSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _idHoSoCongViec;
    }

    public void setPrimaryKey(long pk) {
        setIdHoSoCongViec(pk);
    }

    public long getIdHoSoCongViec() {
        return _idHoSoCongViec;
    }

    public void setIdHoSoCongViec(long idHoSoCongViec) {
        _idHoSoCongViec = idHoSoCongViec;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public long getIdHSCVCha() {
        return _idHSCVCha;
    }

    public void setIdHSCVCha(long idHSCVCha) {
        _idHSCVCha = idHSCVCha;
    }

    public String getSoHieuHSCV() {
        return _soHieuHSCV;
    }

    public void setSoHieuHSCV(String soHieuHSCV) {
        _soHieuHSCV = soHieuHSCV;
    }

    public String getTieuDe() {
        return _tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        _tieuDe = tieuDe;
    }

    public Date getNgayMoHSCV() {
        return _ngayMoHSCV;
    }

    public void setNgayMoHSCV(Date ngayMoHSCV) {
        _ngayMoHSCV = ngayMoHSCV;
    }

    public Date getHanXuLy() {
        return _hanXuLy;
    }

    public void setHanXuLy(Date hanXuLy) {
        _hanXuLy = hanXuLy;
    }

    public String getIdLinhVuc() {
        return _idLinhVuc;
    }

    public void setIdLinhVuc(String idLinhVuc) {
        _idLinhVuc = idLinhVuc;
    }

    public String getVanDeLienQuan() {
        return _vanDeLienQuan;
    }

    public void setVanDeLienQuan(String vanDeLienQuan) {
        _vanDeLienQuan = vanDeLienQuan;
    }

    public long getIdDoQuanTrong() {
        return _idDoQuanTrong;
    }

    public void setIdDoQuanTrong(long idDoQuanTrong) {
        _idDoQuanTrong = idDoQuanTrong;
    }

    public long getIdTinhChat() {
        return _idTinhChat;
    }

    public void setIdTinhChat(long idTinhChat) {
        _idTinhChat = idTinhChat;
    }

    public long getIdTrangThaiHSCV() {
        return _idTrangThaiHSCV;
    }

    public void setIdTrangThaiHSCV(long idTrangThaiHSCV) {
        _idTrangThaiHSCV = idTrangThaiHSCV;
    }

    public String getTomTatNoiDung() {
        return _tomTatNoiDung;
    }

    public void setTomTatNoiDung(String tomTatNoiDung) {
        _tomTatNoiDung = tomTatNoiDung;
    }

    public String getHoatDong() {
        return _hoatDong;
    }

    public void setHoatDong(String hoatDong) {
        _hoatDong = hoatDong;
    }
}
