package com.nss.portlet.thong_tin_lien_quan.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ThongTinLienQuanSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.thong_tin_lien_quan.service.http.ThongTinLienQuanServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thong_tin_lien_quan.service.http.ThongTinLienQuanServiceSoap
 *
 */
public class ThongTinLienQuanSoap implements Serializable {
    private long _maThongTinLienQuan;
    private String _tenThongTinLienQuan;
    private String _urlWebsite;
    private String _moTaThongTinLienQuan;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuThongTin;
    private String _target;
    private long _imageId_liferay;
    private int _active;

    public ThongTinLienQuanSoap() {
    }

    public static ThongTinLienQuanSoap toSoapModel(ThongTinLienQuan model) {
        ThongTinLienQuanSoap soapModel = new ThongTinLienQuanSoap();

        soapModel.setMaThongTinLienQuan(model.getMaThongTinLienQuan());
        soapModel.setTenThongTinLienQuan(model.getTenThongTinLienQuan());
        soapModel.setUrlWebsite(model.getUrlWebsite());
        soapModel.setMoTaThongTinLienQuan(model.getMoTaThongTinLienQuan());
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

    public static ThongTinLienQuanSoap[] toSoapModels(ThongTinLienQuan[] models) {
        ThongTinLienQuanSoap[] soapModels = new ThongTinLienQuanSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ThongTinLienQuanSoap[][] toSoapModels(
        ThongTinLienQuan[][] models) {
        ThongTinLienQuanSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ThongTinLienQuanSoap[models.length][models[0].length];
        } else {
            soapModels = new ThongTinLienQuanSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ThongTinLienQuanSoap[] toSoapModels(
        List<ThongTinLienQuan> models) {
        List<ThongTinLienQuanSoap> soapModels = new ArrayList<ThongTinLienQuanSoap>(models.size());

        for (ThongTinLienQuan model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ThongTinLienQuanSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maThongTinLienQuan;
    }

    public void setPrimaryKey(long pk) {
        setMaThongTinLienQuan(pk);
    }

    public long getMaThongTinLienQuan() {
        return _maThongTinLienQuan;
    }

    public void setMaThongTinLienQuan(long maThongTinLienQuan) {
        _maThongTinLienQuan = maThongTinLienQuan;
    }

    public String getTenThongTinLienQuan() {
        return _tenThongTinLienQuan;
    }

    public void setTenThongTinLienQuan(String tenThongTinLienQuan) {
        _tenThongTinLienQuan = tenThongTinLienQuan;
    }

    public String getUrlWebsite() {
        return _urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        _urlWebsite = urlWebsite;
    }

    public String getMoTaThongTinLienQuan() {
        return _moTaThongTinLienQuan;
    }

    public void setMoTaThongTinLienQuan(String moTaThongTinLienQuan) {
        _moTaThongTinLienQuan = moTaThongTinLienQuan;
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
