package com.nss.portlet.thu_tuc_hanh_chinh.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="FileDinhKemTTHCSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.http.FileDinhKemTTHCServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.http.FileDinhKemTTHCServiceSoap
 *
 */
public class FileDinhKemTTHCSoap implements Serializable {
    private long _maFileDinhKemTTHC;
    private long _maThuTucHanhChinh;
    private String _tenFile;
    private String _moTa;
    private long _kichThuoc;
    private String _duongDan;
    private int _phienBan;

    public FileDinhKemTTHCSoap() {
    }

    public static FileDinhKemTTHCSoap toSoapModel(FileDinhKemTTHC model) {
        FileDinhKemTTHCSoap soapModel = new FileDinhKemTTHCSoap();

        soapModel.setMaFileDinhKemTTHC(model.getMaFileDinhKemTTHC());
        soapModel.setMaThuTucHanhChinh(model.getMaThuTucHanhChinh());
        soapModel.setTenFile(model.getTenFile());
        soapModel.setMoTa(model.getMoTa());
        soapModel.setKichThuoc(model.getKichThuoc());
        soapModel.setDuongDan(model.getDuongDan());
        soapModel.setPhienBan(model.getPhienBan());

        return soapModel;
    }

    public static FileDinhKemTTHCSoap[] toSoapModels(FileDinhKemTTHC[] models) {
        FileDinhKemTTHCSoap[] soapModels = new FileDinhKemTTHCSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FileDinhKemTTHCSoap[][] toSoapModels(
        FileDinhKemTTHC[][] models) {
        FileDinhKemTTHCSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FileDinhKemTTHCSoap[models.length][models[0].length];
        } else {
            soapModels = new FileDinhKemTTHCSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FileDinhKemTTHCSoap[] toSoapModels(
        List<FileDinhKemTTHC> models) {
        List<FileDinhKemTTHCSoap> soapModels = new ArrayList<FileDinhKemTTHCSoap>(models.size());

        for (FileDinhKemTTHC model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FileDinhKemTTHCSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maFileDinhKemTTHC;
    }

    public void setPrimaryKey(long pk) {
        setMaFileDinhKemTTHC(pk);
    }

    public long getMaFileDinhKemTTHC() {
        return _maFileDinhKemTTHC;
    }

    public void setMaFileDinhKemTTHC(long maFileDinhKemTTHC) {
        _maFileDinhKemTTHC = maFileDinhKemTTHC;
    }

    public long getMaThuTucHanhChinh() {
        return _maThuTucHanhChinh;
    }

    public void setMaThuTucHanhChinh(long maThuTucHanhChinh) {
        _maThuTucHanhChinh = maThuTucHanhChinh;
    }

    public String getTenFile() {
        return _tenFile;
    }

    public void setTenFile(String tenFile) {
        _tenFile = tenFile;
    }

    public String getMoTa() {
        return _moTa;
    }

    public void setMoTa(String moTa) {
        _moTa = moTa;
    }

    public long getKichThuoc() {
        return _kichThuoc;
    }

    public void setKichThuoc(long kichThuoc) {
        _kichThuoc = kichThuoc;
    }

    public String getDuongDan() {
        return _duongDan;
    }

    public void setDuongDan(String duongDan) {
        _duongDan = duongDan;
    }

    public int getPhienBan() {
        return _phienBan;
    }

    public void setPhienBan(int phienBan) {
        _phienBan = phienBan;
    }
}
