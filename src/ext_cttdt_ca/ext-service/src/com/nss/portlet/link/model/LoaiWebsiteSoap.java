package com.nss.portlet.link.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LoaiWebsiteSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.link.service.http.LoaiWebsiteServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.service.http.LoaiWebsiteServiceSoap
 *
 */
public class LoaiWebsiteSoap implements Serializable {
    private long _maLoaiWebsite;
    private String _tenLoaiWebsite;
    private String _moTaLoaiWebsite;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;

    public LoaiWebsiteSoap() {
    }

    public static LoaiWebsiteSoap toSoapModel(LoaiWebsite model) {
        LoaiWebsiteSoap soapModel = new LoaiWebsiteSoap();

        soapModel.setMaLoaiWebsite(model.getMaLoaiWebsite());
        soapModel.setTenLoaiWebsite(model.getTenLoaiWebsite());
        soapModel.setMoTaLoaiWebsite(model.getMoTaLoaiWebsite());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static LoaiWebsiteSoap[] toSoapModels(LoaiWebsite[] models) {
        LoaiWebsiteSoap[] soapModels = new LoaiWebsiteSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LoaiWebsiteSoap[][] toSoapModels(LoaiWebsite[][] models) {
        LoaiWebsiteSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LoaiWebsiteSoap[models.length][models[0].length];
        } else {
            soapModels = new LoaiWebsiteSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LoaiWebsiteSoap[] toSoapModels(List<LoaiWebsite> models) {
        List<LoaiWebsiteSoap> soapModels = new ArrayList<LoaiWebsiteSoap>(models.size());

        for (LoaiWebsite model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LoaiWebsiteSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maLoaiWebsite;
    }

    public void setPrimaryKey(long pk) {
        setMaLoaiWebsite(pk);
    }

    public long getMaLoaiWebsite() {
        return _maLoaiWebsite;
    }

    public void setMaLoaiWebsite(long maLoaiWebsite) {
        _maLoaiWebsite = maLoaiWebsite;
    }

    public String getTenLoaiWebsite() {
        return _tenLoaiWebsite;
    }

    public void setTenLoaiWebsite(String tenLoaiWebsite) {
        _tenLoaiWebsite = tenLoaiWebsite;
    }

    public String getMoTaLoaiWebsite() {
        return _moTaLoaiWebsite;
    }

    public void setMoTaLoaiWebsite(String moTaLoaiWebsite) {
        _moTaLoaiWebsite = moTaLoaiWebsite;
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
}
