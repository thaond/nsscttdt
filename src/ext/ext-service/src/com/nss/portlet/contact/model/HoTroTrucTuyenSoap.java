package com.nss.portlet.contact.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="HoTroTrucTuyenSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.contact.service.http.HoTroTrucTuyenServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.contact.service.http.HoTroTrucTuyenServiceSoap
 *
 */
public class HoTroTrucTuyenSoap implements Serializable {
    private int _maHoTroTrucTuyen;
    private String _ten;
    private String _link;
    private String _imageUrl;
    private int _order;
    private int _active;
    private String _description;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;

    public HoTroTrucTuyenSoap() {
    }

    public static HoTroTrucTuyenSoap toSoapModel(HoTroTrucTuyen model) {
        HoTroTrucTuyenSoap soapModel = new HoTroTrucTuyenSoap();

        soapModel.setMaHoTroTrucTuyen(model.getMaHoTroTrucTuyen());
        soapModel.setTen(model.getTen());
        soapModel.setLink(model.getLink());
        soapModel.setImageUrl(model.getImageUrl());
        soapModel.setOrder(model.getOrder());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());

        return soapModel;
    }

    public static HoTroTrucTuyenSoap[] toSoapModels(HoTroTrucTuyen[] models) {
        HoTroTrucTuyenSoap[] soapModels = new HoTroTrucTuyenSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static HoTroTrucTuyenSoap[][] toSoapModels(HoTroTrucTuyen[][] models) {
        HoTroTrucTuyenSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new HoTroTrucTuyenSoap[models.length][models[0].length];
        } else {
            soapModels = new HoTroTrucTuyenSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static HoTroTrucTuyenSoap[] toSoapModels(List<HoTroTrucTuyen> models) {
        List<HoTroTrucTuyenSoap> soapModels = new ArrayList<HoTroTrucTuyenSoap>(models.size());

        for (HoTroTrucTuyen model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new HoTroTrucTuyenSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _maHoTroTrucTuyen;
    }

    public void setPrimaryKey(int pk) {
        setMaHoTroTrucTuyen(pk);
    }

    public int getMaHoTroTrucTuyen() {
        return _maHoTroTrucTuyen;
    }

    public void setMaHoTroTrucTuyen(int maHoTroTrucTuyen) {
        _maHoTroTrucTuyen = maHoTroTrucTuyen;
    }

    public String getTen() {
        return _ten;
    }

    public void setTen(String ten) {
        _ten = ten;
    }

    public String getLink() {
        return _link;
    }

    public void setLink(String link) {
        _link = link;
    }

    public String getImageUrl() {
        return _imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        _imageUrl = imageUrl;
    }

    public int getOrder() {
        return _order;
    }

    public void setOrder(int order) {
        _order = order;
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
}
