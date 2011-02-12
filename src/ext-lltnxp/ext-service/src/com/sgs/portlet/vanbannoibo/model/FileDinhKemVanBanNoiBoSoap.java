package com.sgs.portlet.vanbannoibo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="FileDinhKemVanBanNoiBoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.vanbannoibo.service.http.FileDinhKemVanBanNoiBoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.vanbannoibo.service.http.FileDinhKemVanBanNoiBoServiceSoap
 *
 */
public class FileDinhKemVanBanNoiBoSoap implements Serializable {
    private long _fileDinhKemVanBanNoiBoId;
    private String _tenFileFull;
    private String _tenFile;
    private String _duongDanFile;
    private String _tieuDe;
    private Date _ngayTao;
    private String _loaiFile;
    private String _mucDichFile;
    private long _vanBanNoiBoId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public FileDinhKemVanBanNoiBoSoap() {
    }

    public static FileDinhKemVanBanNoiBoSoap toSoapModel(
        FileDinhKemVanBanNoiBo model) {
        FileDinhKemVanBanNoiBoSoap soapModel = new FileDinhKemVanBanNoiBoSoap();

        soapModel.setFileDinhKemVanBanNoiBoId(model.getFileDinhKemVanBanNoiBoId());
        soapModel.setTenFileFull(model.getTenFileFull());
        soapModel.setTenFile(model.getTenFile());
        soapModel.setDuongDanFile(model.getDuongDanFile());
        soapModel.setTieuDe(model.getTieuDe());
        soapModel.setNgayTao(model.getNgayTao());
        soapModel.setLoaiFile(model.getLoaiFile());
        soapModel.setMucDichFile(model.getMucDichFile());
        soapModel.setVanBanNoiBoId(model.getVanBanNoiBoId());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static FileDinhKemVanBanNoiBoSoap[] toSoapModels(
        List<FileDinhKemVanBanNoiBo> models) {
        List<FileDinhKemVanBanNoiBoSoap> soapModels = new ArrayList<FileDinhKemVanBanNoiBoSoap>(models.size());

        for (FileDinhKemVanBanNoiBo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FileDinhKemVanBanNoiBoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fileDinhKemVanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setFileDinhKemVanBanNoiBoId(pk);
    }

    public long getFileDinhKemVanBanNoiBoId() {
        return _fileDinhKemVanBanNoiBoId;
    }

    public void setFileDinhKemVanBanNoiBoId(long fileDinhKemVanBanNoiBoId) {
        _fileDinhKemVanBanNoiBoId = fileDinhKemVanBanNoiBoId;
    }

    public String getTenFileFull() {
        return _tenFileFull;
    }

    public void setTenFileFull(String tenFileFull) {
        _tenFileFull = tenFileFull;
    }

    public String getTenFile() {
        return _tenFile;
    }

    public void setTenFile(String tenFile) {
        _tenFile = tenFile;
    }

    public String getDuongDanFile() {
        return _duongDanFile;
    }

    public void setDuongDanFile(String duongDanFile) {
        _duongDanFile = duongDanFile;
    }

    public String getTieuDe() {
        return _tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        _tieuDe = tieuDe;
    }

    public Date getNgayTao() {
        return _ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        _ngayTao = ngayTao;
    }

    public String getLoaiFile() {
        return _loaiFile;
    }

    public void setLoaiFile(String loaiFile) {
        _loaiFile = loaiFile;
    }

    public String getMucDichFile() {
        return _mucDichFile;
    }

    public void setMucDichFile(String mucDichFile) {
        _mucDichFile = mucDichFile;
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
