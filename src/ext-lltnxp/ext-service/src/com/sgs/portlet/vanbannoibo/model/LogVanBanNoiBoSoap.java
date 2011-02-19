package com.sgs.portlet.vanbannoibo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LogVanBanNoiBoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.vanbannoibo.service.http.LogVanBanNoiBoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.http.LogVanBanNoiBoServiceSoap
 *
 */
public class LogVanBanNoiBoSoap implements Serializable {
    private long _logVanBanNoiBoId;
    private int _buocLuanChuyen;
    private long _nguoiXuLy;
    private Date _ngayXuLy;
    private long _nguoiNhan;
    private Date _ngayNhan;
    private String _trangThaiTruoc;
    private String _trangThaiSau;
    private Date _ngayGui;
    private String _phongXuLyChinh;
    private long _nguoiXuLyChinh;
    private int _loaiQuyTrinh;
    private Date _ngayHetHan;
    private int _soNgayXuLy;
    private long _processInstanceId;
    private String _thongTinXuLy;
    private int _step;
    private long _nguoiXuLyTrucTiep;
    private String _phongXuLy;
    private String _phongNhan;
    private boolean _vanBanHoanThanhHayChua;
    private long _vanBanNoiBoId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public LogVanBanNoiBoSoap() {
    }

    public static LogVanBanNoiBoSoap toSoapModel(LogVanBanNoiBo model) {
        LogVanBanNoiBoSoap soapModel = new LogVanBanNoiBoSoap();

        soapModel.setLogVanBanNoiBoId(model.getLogVanBanNoiBoId());
        soapModel.setBuocLuanChuyen(model.getBuocLuanChuyen());
        soapModel.setNguoiXuLy(model.getNguoiXuLy());
        soapModel.setNgayXuLy(model.getNgayXuLy());
        soapModel.setNguoiNhan(model.getNguoiNhan());
        soapModel.setNgayNhan(model.getNgayNhan());
        soapModel.setTrangThaiTruoc(model.getTrangThaiTruoc());
        soapModel.setTrangThaiSau(model.getTrangThaiSau());
        soapModel.setNgayGui(model.getNgayGui());
        soapModel.setPhongXuLyChinh(model.getPhongXuLyChinh());
        soapModel.setNguoiXuLyChinh(model.getNguoiXuLyChinh());
        soapModel.setLoaiQuyTrinh(model.getLoaiQuyTrinh());
        soapModel.setNgayHetHan(model.getNgayHetHan());
        soapModel.setSoNgayXuLy(model.getSoNgayXuLy());
        soapModel.setProcessInstanceId(model.getProcessInstanceId());
        soapModel.setThongTinXuLy(model.getThongTinXuLy());
        soapModel.setStep(model.getStep());
        soapModel.setNguoiXuLyTrucTiep(model.getNguoiXuLyTrucTiep());
        soapModel.setPhongXuLy(model.getPhongXuLy());
        soapModel.setPhongNhan(model.getPhongNhan());
        soapModel.setVanBanHoanThanhHayChua(model.getVanBanHoanThanhHayChua());
        soapModel.setVanBanNoiBoId(model.getVanBanNoiBoId());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static LogVanBanNoiBoSoap[] toSoapModels(List<LogVanBanNoiBo> models) {
        List<LogVanBanNoiBoSoap> soapModels = new ArrayList<LogVanBanNoiBoSoap>(models.size());

        for (LogVanBanNoiBo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LogVanBanNoiBoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _logVanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setLogVanBanNoiBoId(pk);
    }

    public long getLogVanBanNoiBoId() {
        return _logVanBanNoiBoId;
    }

    public void setLogVanBanNoiBoId(long logVanBanNoiBoId) {
        _logVanBanNoiBoId = logVanBanNoiBoId;
    }

    public int getBuocLuanChuyen() {
        return _buocLuanChuyen;
    }

    public void setBuocLuanChuyen(int buocLuanChuyen) {
        _buocLuanChuyen = buocLuanChuyen;
    }

    public long getNguoiXuLy() {
        return _nguoiXuLy;
    }

    public void setNguoiXuLy(long nguoiXuLy) {
        _nguoiXuLy = nguoiXuLy;
    }

    public Date getNgayXuLy() {
        return _ngayXuLy;
    }

    public void setNgayXuLy(Date ngayXuLy) {
        _ngayXuLy = ngayXuLy;
    }

    public long getNguoiNhan() {
        return _nguoiNhan;
    }

    public void setNguoiNhan(long nguoiNhan) {
        _nguoiNhan = nguoiNhan;
    }

    public Date getNgayNhan() {
        return _ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        _ngayNhan = ngayNhan;
    }

    public String getTrangThaiTruoc() {
        return _trangThaiTruoc;
    }

    public void setTrangThaiTruoc(String trangThaiTruoc) {
        _trangThaiTruoc = trangThaiTruoc;
    }

    public String getTrangThaiSau() {
        return _trangThaiSau;
    }

    public void setTrangThaiSau(String trangThaiSau) {
        _trangThaiSau = trangThaiSau;
    }

    public Date getNgayGui() {
        return _ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        _ngayGui = ngayGui;
    }

    public String getPhongXuLyChinh() {
        return _phongXuLyChinh;
    }

    public void setPhongXuLyChinh(String phongXuLyChinh) {
        _phongXuLyChinh = phongXuLyChinh;
    }

    public long getNguoiXuLyChinh() {
        return _nguoiXuLyChinh;
    }

    public void setNguoiXuLyChinh(long nguoiXuLyChinh) {
        _nguoiXuLyChinh = nguoiXuLyChinh;
    }

    public int getLoaiQuyTrinh() {
        return _loaiQuyTrinh;
    }

    public void setLoaiQuyTrinh(int loaiQuyTrinh) {
        _loaiQuyTrinh = loaiQuyTrinh;
    }

    public Date getNgayHetHan() {
        return _ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        _ngayHetHan = ngayHetHan;
    }

    public int getSoNgayXuLy() {
        return _soNgayXuLy;
    }

    public void setSoNgayXuLy(int soNgayXuLy) {
        _soNgayXuLy = soNgayXuLy;
    }

    public long getProcessInstanceId() {
        return _processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        _processInstanceId = processInstanceId;
    }

    public String getThongTinXuLy() {
        return _thongTinXuLy;
    }

    public void setThongTinXuLy(String thongTinXuLy) {
        _thongTinXuLy = thongTinXuLy;
    }

    public int getStep() {
        return _step;
    }

    public void setStep(int step) {
        _step = step;
    }

    public long getNguoiXuLyTrucTiep() {
        return _nguoiXuLyTrucTiep;
    }

    public void setNguoiXuLyTrucTiep(long nguoiXuLyTrucTiep) {
        _nguoiXuLyTrucTiep = nguoiXuLyTrucTiep;
    }

    public String getPhongXuLy() {
        return _phongXuLy;
    }

    public void setPhongXuLy(String phongXuLy) {
        _phongXuLy = phongXuLy;
    }

    public String getPhongNhan() {
        return _phongNhan;
    }

    public void setPhongNhan(String phongNhan) {
        _phongNhan = phongNhan;
    }

    public boolean getVanBanHoanThanhHayChua() {
        return _vanBanHoanThanhHayChua;
    }

    public boolean isVanBanHoanThanhHayChua() {
        return _vanBanHoanThanhHayChua;
    }

    public void setVanBanHoanThanhHayChua(boolean vanBanHoanThanhHayChua) {
        _vanBanHoanThanhHayChua = vanBanHoanThanhHayChua;
    }

    public long getVanBanNoiBoId() {
        return _vanBanNoiBoId;
    }

    public void setVanBanNoiBoId(long vanBanNoiBoId) {
        _vanBanNoiBoId = vanBanNoiBoId;
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
