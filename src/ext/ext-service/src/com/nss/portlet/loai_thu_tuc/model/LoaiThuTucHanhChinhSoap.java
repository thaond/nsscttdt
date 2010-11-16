package com.nss.portlet.loai_thu_tuc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LoaiThuTucHanhChinhSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.loai_thu_tuc.service.http.LoaiThuTucHanhChinhServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.loai_thu_tuc.service.http.LoaiThuTucHanhChinhServiceSoap
 *
 */
public class LoaiThuTucHanhChinhSoap implements Serializable {
    private long _maLoaiThuTucHanhChinh;
    private String _tenLoaiThuTucHanhChinh;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;

    public LoaiThuTucHanhChinhSoap() {
    }

    public static LoaiThuTucHanhChinhSoap toSoapModel(LoaiThuTucHanhChinh model) {
        LoaiThuTucHanhChinhSoap soapModel = new LoaiThuTucHanhChinhSoap();

        soapModel.setMaLoaiThuTucHanhChinh(model.getMaLoaiThuTucHanhChinh());
        soapModel.setTenLoaiThuTucHanhChinh(model.getTenLoaiThuTucHanhChinh());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static LoaiThuTucHanhChinhSoap[] toSoapModels(
        LoaiThuTucHanhChinh[] models) {
        LoaiThuTucHanhChinhSoap[] soapModels = new LoaiThuTucHanhChinhSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LoaiThuTucHanhChinhSoap[][] toSoapModels(
        LoaiThuTucHanhChinh[][] models) {
        LoaiThuTucHanhChinhSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LoaiThuTucHanhChinhSoap[models.length][models[0].length];
        } else {
            soapModels = new LoaiThuTucHanhChinhSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LoaiThuTucHanhChinhSoap[] toSoapModels(
        List<LoaiThuTucHanhChinh> models) {
        List<LoaiThuTucHanhChinhSoap> soapModels = new ArrayList<LoaiThuTucHanhChinhSoap>(models.size());

        for (LoaiThuTucHanhChinh model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LoaiThuTucHanhChinhSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maLoaiThuTucHanhChinh;
    }

    public void setPrimaryKey(long pk) {
        setMaLoaiThuTucHanhChinh(pk);
    }

    public long getMaLoaiThuTucHanhChinh() {
        return _maLoaiThuTucHanhChinh;
    }

    public void setMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh) {
        _maLoaiThuTucHanhChinh = maLoaiThuTucHanhChinh;
    }

    public String getTenLoaiThuTucHanhChinh() {
        return _tenLoaiThuTucHanhChinh;
    }

    public void setTenLoaiThuTucHanhChinh(String tenLoaiThuTucHanhChinh) {
        _tenLoaiThuTucHanhChinh = tenLoaiThuTucHanhChinh;
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
