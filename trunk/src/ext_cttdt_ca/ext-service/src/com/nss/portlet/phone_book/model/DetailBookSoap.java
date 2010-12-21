package com.nss.portlet.phone_book.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="DetailBookSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.phone_book.service.http.DetailBookServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.service.http.DetailBookServiceSoap
 *
 */
public class DetailBookSoap implements Serializable {
    private long _detailBookId;
    private String _detailBookCode;
    private String _detailBookName;
    private String _detailDescription;
    private boolean _detailActive;
    private String _zip;
    private String _internal;
    private String _home;
    private String _mobile;
    private long _contactBookId;
    private long _companyid;
    private long _userid;

    public DetailBookSoap() {
    }

    public static DetailBookSoap toSoapModel(DetailBook model) {
        DetailBookSoap soapModel = new DetailBookSoap();

        soapModel.setDetailBookId(model.getDetailBookId());
        soapModel.setDetailBookCode(model.getDetailBookCode());
        soapModel.setDetailBookName(model.getDetailBookName());
        soapModel.setDetailDescription(model.getDetailDescription());
        soapModel.setDetailActive(model.getDetailActive());
        soapModel.setZip(model.getZip());
        soapModel.setInternal(model.getInternal());
        soapModel.setHome(model.getHome());
        soapModel.setMobile(model.getMobile());
        soapModel.setContactBookId(model.getContactBookId());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());

        return soapModel;
    }

    public static DetailBookSoap[] toSoapModels(DetailBook[] models) {
        DetailBookSoap[] soapModels = new DetailBookSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DetailBookSoap[][] toSoapModels(DetailBook[][] models) {
        DetailBookSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DetailBookSoap[models.length][models[0].length];
        } else {
            soapModels = new DetailBookSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DetailBookSoap[] toSoapModels(List<DetailBook> models) {
        List<DetailBookSoap> soapModels = new ArrayList<DetailBookSoap>(models.size());

        for (DetailBook model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DetailBookSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _detailBookId;
    }

    public void setPrimaryKey(long pk) {
        setDetailBookId(pk);
    }

    public long getDetailBookId() {
        return _detailBookId;
    }

    public void setDetailBookId(long detailBookId) {
        _detailBookId = detailBookId;
    }

    public String getDetailBookCode() {
        return _detailBookCode;
    }

    public void setDetailBookCode(String detailBookCode) {
        _detailBookCode = detailBookCode;
    }

    public String getDetailBookName() {
        return _detailBookName;
    }

    public void setDetailBookName(String detailBookName) {
        _detailBookName = detailBookName;
    }

    public String getDetailDescription() {
        return _detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        _detailDescription = detailDescription;
    }

    public boolean getDetailActive() {
        return _detailActive;
    }

    public boolean isDetailActive() {
        return _detailActive;
    }

    public void setDetailActive(boolean detailActive) {
        _detailActive = detailActive;
    }

    public String getZip() {
        return _zip;
    }

    public void setZip(String zip) {
        _zip = zip;
    }

    public String getInternal() {
        return _internal;
    }

    public void setInternal(String internal) {
        _internal = internal;
    }

    public String getHome() {
        return _home;
    }

    public void setHome(String home) {
        _home = home;
    }

    public String getMobile() {
        return _mobile;
    }

    public void setMobile(String mobile) {
        _mobile = mobile;
    }

    public long getContactBookId() {
        return _contactBookId;
    }

    public void setContactBookId(long contactBookId) {
        _contactBookId = contactBookId;
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
}
