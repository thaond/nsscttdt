package com.nss.portlet.linh_vuc_thu_tuc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LinhVucThuTucHanhChinhSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.linh_vuc_thu_tuc.service.http.LinhVucThuTucHanhChinhServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_thu_tuc.service.http.LinhVucThuTucHanhChinhServiceSoap
 *
 */
public class LinhVucThuTucHanhChinhSoap implements Serializable {
    private long _maLinhVucThuTucHanhChinh;
    private String _tenLinhVucThuTucHanhChinh;
    private long _maLoaiThuTucHanhChinh;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;

    public LinhVucThuTucHanhChinhSoap() {
    }

    public static LinhVucThuTucHanhChinhSoap toSoapModel(
        LinhVucThuTucHanhChinh model) {
        LinhVucThuTucHanhChinhSoap soapModel = new LinhVucThuTucHanhChinhSoap();

        soapModel.setMaLinhVucThuTucHanhChinh(model.getMaLinhVucThuTucHanhChinh());
        soapModel.setTenLinhVucThuTucHanhChinh(model.getTenLinhVucThuTucHanhChinh());
        soapModel.setMaLoaiThuTucHanhChinh(model.getMaLoaiThuTucHanhChinh());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static LinhVucThuTucHanhChinhSoap[] toSoapModels(
        LinhVucThuTucHanhChinh[] models) {
        LinhVucThuTucHanhChinhSoap[] soapModels = new LinhVucThuTucHanhChinhSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LinhVucThuTucHanhChinhSoap[][] toSoapModels(
        LinhVucThuTucHanhChinh[][] models) {
        LinhVucThuTucHanhChinhSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LinhVucThuTucHanhChinhSoap[models.length][models[0].length];
        } else {
            soapModels = new LinhVucThuTucHanhChinhSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LinhVucThuTucHanhChinhSoap[] toSoapModels(
        List<LinhVucThuTucHanhChinh> models) {
        List<LinhVucThuTucHanhChinhSoap> soapModels = new ArrayList<LinhVucThuTucHanhChinhSoap>(models.size());

        for (LinhVucThuTucHanhChinh model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LinhVucThuTucHanhChinhSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maLinhVucThuTucHanhChinh;
    }

    public void setPrimaryKey(long pk) {
        setMaLinhVucThuTucHanhChinh(pk);
    }

    public long getMaLinhVucThuTucHanhChinh() {
        return _maLinhVucThuTucHanhChinh;
    }

    public void setMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh) {
        _maLinhVucThuTucHanhChinh = maLinhVucThuTucHanhChinh;
    }

    public String getTenLinhVucThuTucHanhChinh() {
        return _tenLinhVucThuTucHanhChinh;
    }

    public void setTenLinhVucThuTucHanhChinh(String tenLinhVucThuTucHanhChinh) {
        _tenLinhVucThuTucHanhChinh = tenLinhVucThuTucHanhChinh;
    }

    public long getMaLoaiThuTucHanhChinh() {
        return _maLoaiThuTucHanhChinh;
    }

    public void setMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh) {
        _maLoaiThuTucHanhChinh = maLoaiThuTucHanhChinh;
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
