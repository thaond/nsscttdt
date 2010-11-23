package com.nss.portlet.necessary_info.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ThongTinCanThietSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.necessary_info.service.http.ThongTinCanThietServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.necessary_info.service.http.ThongTinCanThietServiceSoap
 *
 */
public class ThongTinCanThietSoap implements Serializable {
    private long _maThongTinCanThiet;
    private String _tenThongTinCanThiet;
    private String _urlWebsite;
    private String _moTaThongTinCanThiet;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuThongTin;
    private String _target;
    private long _imageId_liferay;
    private int _active;

    public ThongTinCanThietSoap() {
    }

    public static ThongTinCanThietSoap toSoapModel(ThongTinCanThiet model) {
        ThongTinCanThietSoap soapModel = new ThongTinCanThietSoap();

        soapModel.setMaThongTinCanThiet(model.getMaThongTinCanThiet());
        soapModel.setTenThongTinCanThiet(model.getTenThongTinCanThiet());
        soapModel.setUrlWebsite(model.getUrlWebsite());
        soapModel.setMoTaThongTinCanThiet(model.getMoTaThongTinCanThiet());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setThuTuThongTin(model.getThuTuThongTin());
        soapModel.setTarget(model.getTarget());
        soapModel.setImageId_liferay(model.getImageId_liferay());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static ThongTinCanThietSoap[] toSoapModels(ThongTinCanThiet[] models) {
        ThongTinCanThietSoap[] soapModels = new ThongTinCanThietSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ThongTinCanThietSoap[][] toSoapModels(
        ThongTinCanThiet[][] models) {
        ThongTinCanThietSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ThongTinCanThietSoap[models.length][models[0].length];
        } else {
            soapModels = new ThongTinCanThietSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ThongTinCanThietSoap[] toSoapModels(
        List<ThongTinCanThiet> models) {
        List<ThongTinCanThietSoap> soapModels = new ArrayList<ThongTinCanThietSoap>(models.size());

        for (ThongTinCanThiet model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ThongTinCanThietSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maThongTinCanThiet;
    }

    public void setPrimaryKey(long pk) {
        setMaThongTinCanThiet(pk);
    }

    public long getMaThongTinCanThiet() {
        return _maThongTinCanThiet;
    }

    public void setMaThongTinCanThiet(long maThongTinCanThiet) {
        _maThongTinCanThiet = maThongTinCanThiet;
    }

    public String getTenThongTinCanThiet() {
        return _tenThongTinCanThiet;
    }

    public void setTenThongTinCanThiet(String tenThongTinCanThiet) {
        _tenThongTinCanThiet = tenThongTinCanThiet;
    }

    public String getUrlWebsite() {
        return _urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        _urlWebsite = urlWebsite;
    }

    public String getMoTaThongTinCanThiet() {
        return _moTaThongTinCanThiet;
    }

    public void setMoTaThongTinCanThiet(String moTaThongTinCanThiet) {
        _moTaThongTinCanThiet = moTaThongTinCanThiet;
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

    public int getThuTuThongTin() {
        return _thuTuThongTin;
    }

    public void setThuTuThongTin(int thuTuThongTin) {
        _thuTuThongTin = thuTuThongTin;
    }

    public String getTarget() {
        return _target;
    }

    public void setTarget(String target) {
        _target = target;
    }

    public long getImageId_liferay() {
        return _imageId_liferay;
    }

    public void setImageId_liferay(long imageId_liferay) {
        _imageId_liferay = imageId_liferay;
    }

    public int getActive() {
        return _active;
    }

    public void setActive(int active) {
        _active = active;
    }
}
