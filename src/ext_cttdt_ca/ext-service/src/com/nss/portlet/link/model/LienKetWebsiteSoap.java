package com.nss.portlet.link.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LienKetWebsiteSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.link.service.http.LienKetWebsiteServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.service.http.LienKetWebsiteServiceSoap
 *
 */
public class LienKetWebsiteSoap implements Serializable {
    private long _maWebsite;
    private String _tenWebsite;
    private String _urlWebsite;
    private String _moTaWebsite;
    private long _loaiWebsite;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuWebsite;
    private String _target;
    private long _imageId_liferay;
    private int _active;

    public LienKetWebsiteSoap() {
    }

    public static LienKetWebsiteSoap toSoapModel(LienKetWebsite model) {
        LienKetWebsiteSoap soapModel = new LienKetWebsiteSoap();

        soapModel.setMaWebsite(model.getMaWebsite());
        soapModel.setTenWebsite(model.getTenWebsite());
        soapModel.setUrlWebsite(model.getUrlWebsite());
        soapModel.setMoTaWebsite(model.getMoTaWebsite());
        soapModel.setLoaiWebsite(model.getLoaiWebsite());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setThuTuWebsite(model.getThuTuWebsite());
        soapModel.setTarget(model.getTarget());
        soapModel.setImageId_liferay(model.getImageId_liferay());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static LienKetWebsiteSoap[] toSoapModels(LienKetWebsite[] models) {
        LienKetWebsiteSoap[] soapModels = new LienKetWebsiteSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LienKetWebsiteSoap[][] toSoapModels(LienKetWebsite[][] models) {
        LienKetWebsiteSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LienKetWebsiteSoap[models.length][models[0].length];
        } else {
            soapModels = new LienKetWebsiteSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LienKetWebsiteSoap[] toSoapModels(List<LienKetWebsite> models) {
        List<LienKetWebsiteSoap> soapModels = new ArrayList<LienKetWebsiteSoap>(models.size());

        for (LienKetWebsite model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LienKetWebsiteSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maWebsite;
    }

    public void setPrimaryKey(long pk) {
        setMaWebsite(pk);
    }

    public long getMaWebsite() {
        return _maWebsite;
    }

    public void setMaWebsite(long maWebsite) {
        _maWebsite = maWebsite;
    }

    public String getTenWebsite() {
        return _tenWebsite;
    }

    public void setTenWebsite(String tenWebsite) {
        _tenWebsite = tenWebsite;
    }

    public String getUrlWebsite() {
        return _urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        _urlWebsite = urlWebsite;
    }

    public String getMoTaWebsite() {
        return _moTaWebsite;
    }

    public void setMoTaWebsite(String moTaWebsite) {
        _moTaWebsite = moTaWebsite;
    }

    public long getLoaiWebsite() {
        return _loaiWebsite;
    }

    public void setLoaiWebsite(long loaiWebsite) {
        _loaiWebsite = loaiWebsite;
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

    public int getThuTuWebsite() {
        return _thuTuWebsite;
    }

    public void setThuTuWebsite(int thuTuWebsite) {
        _thuTuWebsite = thuTuWebsite;
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
