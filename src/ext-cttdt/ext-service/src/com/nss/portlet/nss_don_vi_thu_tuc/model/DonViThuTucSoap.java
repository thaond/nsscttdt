package com.nss.portlet.nss_don_vi_thu_tuc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="DonViThuTucSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.nss_don_vi_thu_tuc.service.http.DonViThuTucServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.nss_don_vi_thu_tuc.service.http.DonViThuTucServiceSoap
 *
 */
public class DonViThuTucSoap implements Serializable {
    private long _maDonViThuTuc;
    private String _tenDonViThuTuc;
    private int _capDonVi;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;

    public DonViThuTucSoap() {
    }

    public static DonViThuTucSoap toSoapModel(DonViThuTuc model) {
        DonViThuTucSoap soapModel = new DonViThuTucSoap();

        soapModel.setMaDonViThuTuc(model.getMaDonViThuTuc());
        soapModel.setTenDonViThuTuc(model.getTenDonViThuTuc());
        soapModel.setCapDonVi(model.getCapDonVi());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static DonViThuTucSoap[] toSoapModels(DonViThuTuc[] models) {
        DonViThuTucSoap[] soapModels = new DonViThuTucSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DonViThuTucSoap[][] toSoapModels(DonViThuTuc[][] models) {
        DonViThuTucSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DonViThuTucSoap[models.length][models[0].length];
        } else {
            soapModels = new DonViThuTucSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DonViThuTucSoap[] toSoapModels(List<DonViThuTuc> models) {
        List<DonViThuTucSoap> soapModels = new ArrayList<DonViThuTucSoap>(models.size());

        for (DonViThuTuc model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DonViThuTucSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maDonViThuTuc;
    }

    public void setPrimaryKey(long pk) {
        setMaDonViThuTuc(pk);
    }

    public long getMaDonViThuTuc() {
        return _maDonViThuTuc;
    }

    public void setMaDonViThuTuc(long maDonViThuTuc) {
        _maDonViThuTuc = maDonViThuTuc;
    }

    public String getTenDonViThuTuc() {
        return _tenDonViThuTuc;
    }

    public void setTenDonViThuTuc(String tenDonViThuTuc) {
        _tenDonViThuTuc = tenDonViThuTuc;
    }

    public int getCapDonVi() {
        return _capDonVi;
    }

    public void setCapDonVi(int capDonVi) {
        _capDonVi = capDonVi;
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
