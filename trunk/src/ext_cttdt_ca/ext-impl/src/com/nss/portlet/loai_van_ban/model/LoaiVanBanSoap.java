package com.nss.portlet.loai_van_ban.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LoaiVanBanSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.loai_van_ban.service.http.LoaiVanBanServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.loai_van_ban.service.http.LoaiVanBanServiceSoap
 *
 */
public class LoaiVanBanSoap implements Serializable {
    private long _maLoaiVanBan;
    private String _tenLoaiVanBan;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;

    public LoaiVanBanSoap() {
    }

    public static LoaiVanBanSoap toSoapModel(LoaiVanBan model) {
        LoaiVanBanSoap soapModel = new LoaiVanBanSoap();

        soapModel.setMaLoaiVanBan(model.getMaLoaiVanBan());
        soapModel.setTenLoaiVanBan(model.getTenLoaiVanBan());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static LoaiVanBanSoap[] toSoapModels(LoaiVanBan[] models) {
        LoaiVanBanSoap[] soapModels = new LoaiVanBanSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LoaiVanBanSoap[][] toSoapModels(LoaiVanBan[][] models) {
        LoaiVanBanSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LoaiVanBanSoap[models.length][models[0].length];
        } else {
            soapModels = new LoaiVanBanSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LoaiVanBanSoap[] toSoapModels(List<LoaiVanBan> models) {
        List<LoaiVanBanSoap> soapModels = new ArrayList<LoaiVanBanSoap>(models.size());

        for (LoaiVanBan model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LoaiVanBanSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maLoaiVanBan;
    }

    public void setPrimaryKey(long pk) {
        setMaLoaiVanBan(pk);
    }

    public long getMaLoaiVanBan() {
        return _maLoaiVanBan;
    }

    public void setMaLoaiVanBan(long maLoaiVanBan) {
        _maLoaiVanBan = maLoaiVanBan;
    }

    public String getTenLoaiVanBan() {
        return _tenLoaiVanBan;
    }

    public void setTenLoaiVanBan(String tenLoaiVanBan) {
        _tenLoaiVanBan = tenLoaiVanBan;
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
