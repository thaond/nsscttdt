package com.nss.portlet.adv.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="QuangCaoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.adv.service.http.QuangCaoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.adv.service.http.QuangCaoServiceSoap
 *
 */
public class QuangCaoSoap implements Serializable {
    private long _maQuangCao;
    private String _tenQuangCao;
    private String _urlWebsite;
    private String _moTaQuangCao;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuQuangCao;
    private String _target;
    private long _imageId_liferay;
    private int _active;

    public QuangCaoSoap() {
    }

    public static QuangCaoSoap toSoapModel(QuangCao model) {
        QuangCaoSoap soapModel = new QuangCaoSoap();

        soapModel.setMaQuangCao(model.getMaQuangCao());
        soapModel.setTenQuangCao(model.getTenQuangCao());
        soapModel.setUrlWebsite(model.getUrlWebsite());
        soapModel.setMoTaQuangCao(model.getMoTaQuangCao());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setThuTuQuangCao(model.getThuTuQuangCao());
        soapModel.setTarget(model.getTarget());
        soapModel.setImageId_liferay(model.getImageId_liferay());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static QuangCaoSoap[] toSoapModels(QuangCao[] models) {
        QuangCaoSoap[] soapModels = new QuangCaoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static QuangCaoSoap[][] toSoapModels(QuangCao[][] models) {
        QuangCaoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new QuangCaoSoap[models.length][models[0].length];
        } else {
            soapModels = new QuangCaoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static QuangCaoSoap[] toSoapModels(List<QuangCao> models) {
        List<QuangCaoSoap> soapModels = new ArrayList<QuangCaoSoap>(models.size());

        for (QuangCao model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new QuangCaoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maQuangCao;
    }

    public void setPrimaryKey(long pk) {
        setMaQuangCao(pk);
    }

    public long getMaQuangCao() {
        return _maQuangCao;
    }

    public void setMaQuangCao(long maQuangCao) {
        _maQuangCao = maQuangCao;
    }

    public String getTenQuangCao() {
        return _tenQuangCao;
    }

    public void setTenQuangCao(String tenQuangCao) {
        _tenQuangCao = tenQuangCao;
    }

    public String getUrlWebsite() {
        return _urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        _urlWebsite = urlWebsite;
    }

    public String getMoTaQuangCao() {
        return _moTaQuangCao;
    }

    public void setMoTaQuangCao(String moTaQuangCao) {
        _moTaQuangCao = moTaQuangCao;
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

    public int getThuTuQuangCao() {
        return _thuTuQuangCao;
    }

    public void setThuTuQuangCao(int thuTuQuangCao) {
        _thuTuQuangCao = thuTuQuangCao;
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
