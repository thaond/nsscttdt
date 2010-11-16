package com.nss.portlet.van_ban_phap_quy.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="FileDinhKemSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.van_ban_phap_quy.service.http.FileDinhKemServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.service.http.FileDinhKemServiceSoap
 *
 */
public class FileDinhKemSoap implements Serializable {
    private long _maFileDinhKem;
    private long _maVanBanPhapQuy;
    private String _tenFile;
    private String _moTa;
    private long _kichThuoc;
    private String _duongDan;
    private int _phienBan;

    public FileDinhKemSoap() {
    }

    public static FileDinhKemSoap toSoapModel(FileDinhKem model) {
        FileDinhKemSoap soapModel = new FileDinhKemSoap();

        soapModel.setMaFileDinhKem(model.getMaFileDinhKem());
        soapModel.setMaVanBanPhapQuy(model.getMaVanBanPhapQuy());
        soapModel.setTenFile(model.getTenFile());
        soapModel.setMoTa(model.getMoTa());
        soapModel.setKichThuoc(model.getKichThuoc());
        soapModel.setDuongDan(model.getDuongDan());
        soapModel.setPhienBan(model.getPhienBan());

        return soapModel;
    }

    public static FileDinhKemSoap[] toSoapModels(FileDinhKem[] models) {
        FileDinhKemSoap[] soapModels = new FileDinhKemSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FileDinhKemSoap[][] toSoapModels(FileDinhKem[][] models) {
        FileDinhKemSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FileDinhKemSoap[models.length][models[0].length];
        } else {
            soapModels = new FileDinhKemSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FileDinhKemSoap[] toSoapModels(List<FileDinhKem> models) {
        List<FileDinhKemSoap> soapModels = new ArrayList<FileDinhKemSoap>(models.size());

        for (FileDinhKem model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FileDinhKemSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maFileDinhKem;
    }

    public void setPrimaryKey(long pk) {
        setMaFileDinhKem(pk);
    }

    public long getMaFileDinhKem() {
        return _maFileDinhKem;
    }

    public void setMaFileDinhKem(long maFileDinhKem) {
        _maFileDinhKem = maFileDinhKem;
    }

    public long getMaVanBanPhapQuy() {
        return _maVanBanPhapQuy;
    }

    public void setMaVanBanPhapQuy(long maVanBanPhapQuy) {
        _maVanBanPhapQuy = maVanBanPhapQuy;
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
