package com.nss.portlet.partner.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PartnerSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.partner.service.http.PartnerServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.partner.service.http.PartnerServiceSoap
 *
 */
public class PartnerSoap implements Serializable {
    private long _maPartner;
    private String _tenPartner;
    private String _urlPartner;
    private String _moTaPartner;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuPartner;
    private String _target;
    private int _active;
    private long _imageId_liferay;

    public PartnerSoap() {
    }

    public static PartnerSoap toSoapModel(Partner model) {
        PartnerSoap soapModel = new PartnerSoap();

        soapModel.setMaPartner(model.getMaPartner());
        soapModel.setTenPartner(model.getTenPartner());
        soapModel.setUrlPartner(model.getUrlPartner());
        soapModel.setMoTaPartner(model.getMoTaPartner());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setThuTuPartner(model.getThuTuPartner());
        soapModel.setTarget(model.getTarget());
        soapModel.setActive(model.getActive());
        soapModel.setImageId_liferay(model.getImageId_liferay());

        return soapModel;
    }

    public static PartnerSoap[] toSoapModels(Partner[] models) {
        PartnerSoap[] soapModels = new PartnerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PartnerSoap[][] toSoapModels(Partner[][] models) {
        PartnerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PartnerSoap[models.length][models[0].length];
        } else {
            soapModels = new PartnerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PartnerSoap[] toSoapModels(List<Partner> models) {
        List<PartnerSoap> soapModels = new ArrayList<PartnerSoap>(models.size());

        for (Partner model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PartnerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maPartner;
    }

    public void setPrimaryKey(long pk) {
        setMaPartner(pk);
    }

    public long getMaPartner() {
        return _maPartner;
    }

    public void setMaPartner(long maPartner) {
        _maPartner = maPartner;
    }

    public String getTenPartner() {
        return _tenPartner;
    }

    public void setTenPartner(String tenPartner) {
        _tenPartner = tenPartner;
    }

    public String getUrlPartner() {
        return _urlPartner;
    }

    public void setUrlPartner(String urlPartner) {
        _urlPartner = urlPartner;
    }

    public String getMoTaPartner() {
        return _moTaPartner;
    }

    public void setMoTaPartner(String moTaPartner) {
        _moTaPartner = moTaPartner;
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

    public int getThuTuPartner() {
        return _thuTuPartner;
    }

    public void setThuTuPartner(int thuTuPartner) {
        _thuTuPartner = thuTuPartner;
    }

    public String getTarget() {
        return _target;
    }

    public void setTarget(String target) {
        _target = target;
    }

    public int getActive() {
        return _active;
    }

    public void setActive(int active) {
        _active = active;
    }

    public long getImageId_liferay() {
        return _imageId_liferay;
    }

    public void setImageId_liferay(long imageId_liferay) {
        _imageId_liferay = imageId_liferay;
    }
}
