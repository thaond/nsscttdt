package com.nss.portlet.thu_tuc_hanh_chinh.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ThuTucHanhChinhSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.http.ThuTucHanhChinhServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.http.ThuTucHanhChinhServiceSoap
 *
 */
public class ThuTucHanhChinhSoap implements Serializable {
    private long _maThuTucHanhChinh;
    private String _tenThuTucHanhChinh;
    private String _diaChiLienHe;
    private long _maLinhVucThuTucHanhChinh;
    private long _maDonViThuTucHanhChinh;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;

    public ThuTucHanhChinhSoap() {
    }

    public static ThuTucHanhChinhSoap toSoapModel(ThuTucHanhChinh model) {
        ThuTucHanhChinhSoap soapModel = new ThuTucHanhChinhSoap();

        soapModel.setMaThuTucHanhChinh(model.getMaThuTucHanhChinh());
        soapModel.setTenThuTucHanhChinh(model.getTenThuTucHanhChinh());
        soapModel.setDiaChiLienHe(model.getDiaChiLienHe());
        soapModel.setMaLinhVucThuTucHanhChinh(model.getMaLinhVucThuTucHanhChinh());
        soapModel.setMaDonViThuTucHanhChinh(model.getMaDonViThuTucHanhChinh());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static ThuTucHanhChinhSoap[] toSoapModels(ThuTucHanhChinh[] models) {
        ThuTucHanhChinhSoap[] soapModels = new ThuTucHanhChinhSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ThuTucHanhChinhSoap[][] toSoapModels(
        ThuTucHanhChinh[][] models) {
        ThuTucHanhChinhSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ThuTucHanhChinhSoap[models.length][models[0].length];
        } else {
            soapModels = new ThuTucHanhChinhSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ThuTucHanhChinhSoap[] toSoapModels(
        List<ThuTucHanhChinh> models) {
        List<ThuTucHanhChinhSoap> soapModels = new ArrayList<ThuTucHanhChinhSoap>(models.size());

        for (ThuTucHanhChinh model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ThuTucHanhChinhSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maThuTucHanhChinh;
    }

    public void setPrimaryKey(long pk) {
        setMaThuTucHanhChinh(pk);
    }

    public long getMaThuTucHanhChinh() {
        return _maThuTucHanhChinh;
    }

    public void setMaThuTucHanhChinh(long maThuTucHanhChinh) {
        _maThuTucHanhChinh = maThuTucHanhChinh;
    }

    public String getTenThuTucHanhChinh() {
        return _tenThuTucHanhChinh;
    }

    public void setTenThuTucHanhChinh(String tenThuTucHanhChinh) {
        _tenThuTucHanhChinh = tenThuTucHanhChinh;
    }

    public String getDiaChiLienHe() {
        return _diaChiLienHe;
    }

    public void setDiaChiLienHe(String diaChiLienHe) {
        _diaChiLienHe = diaChiLienHe;
    }

    public long getMaLinhVucThuTucHanhChinh() {
        return _maLinhVucThuTucHanhChinh;
    }

    public void setMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh) {
        _maLinhVucThuTucHanhChinh = maLinhVucThuTucHanhChinh;
    }

    public long getMaDonViThuTucHanhChinh() {
        return _maDonViThuTucHanhChinh;
    }

    public void setMaDonViThuTucHanhChinh(long maDonViThuTucHanhChinh) {
        _maDonViThuTucHanhChinh = maDonViThuTucHanhChinh;
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
