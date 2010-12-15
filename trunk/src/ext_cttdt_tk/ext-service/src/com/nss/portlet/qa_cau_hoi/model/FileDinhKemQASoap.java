package com.nss.portlet.qa_cau_hoi.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="FileDinhKemQASoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.qa_cau_hoi.service.http.FileDinhKemQAServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.service.http.FileDinhKemQAServiceSoap
 *
 */
public class FileDinhKemQASoap implements Serializable {
    private long _maFileDinhKemQA;
    private long _maCauHoi;
    private long _maCauTraLoi;
    private String _tenFile;
    private long _kichThuoc;
    private String _duongDan;

    public FileDinhKemQASoap() {
    }

    public static FileDinhKemQASoap toSoapModel(FileDinhKemQA model) {
        FileDinhKemQASoap soapModel = new FileDinhKemQASoap();

        soapModel.setMaFileDinhKemQA(model.getMaFileDinhKemQA());
        soapModel.setMaCauHoi(model.getMaCauHoi());
        soapModel.setMaCauTraLoi(model.getMaCauTraLoi());
        soapModel.setTenFile(model.getTenFile());
        soapModel.setKichThuoc(model.getKichThuoc());
        soapModel.setDuongDan(model.getDuongDan());

        return soapModel;
    }

    public static FileDinhKemQASoap[] toSoapModels(FileDinhKemQA[] models) {
        FileDinhKemQASoap[] soapModels = new FileDinhKemQASoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FileDinhKemQASoap[][] toSoapModels(FileDinhKemQA[][] models) {
        FileDinhKemQASoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FileDinhKemQASoap[models.length][models[0].length];
        } else {
            soapModels = new FileDinhKemQASoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FileDinhKemQASoap[] toSoapModels(List<FileDinhKemQA> models) {
        List<FileDinhKemQASoap> soapModels = new ArrayList<FileDinhKemQASoap>(models.size());

        for (FileDinhKemQA model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FileDinhKemQASoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maFileDinhKemQA;
    }

    public void setPrimaryKey(long pk) {
        setMaFileDinhKemQA(pk);
    }

    public long getMaFileDinhKemQA() {
        return _maFileDinhKemQA;
    }

    public void setMaFileDinhKemQA(long maFileDinhKemQA) {
        _maFileDinhKemQA = maFileDinhKemQA;
    }

    public long getMaCauHoi() {
        return _maCauHoi;
    }

    public void setMaCauHoi(long maCauHoi) {
        _maCauHoi = maCauHoi;
    }

    public long getMaCauTraLoi() {
        return _maCauTraLoi;
    }

    public void setMaCauTraLoi(long maCauTraLoi) {
        _maCauTraLoi = maCauTraLoi;
    }

    public String getTenFile() {
        return _tenFile;
    }

    public void setTenFile(String tenFile) {
        _tenFile = tenFile;
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
}
