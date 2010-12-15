package com.nss.portlet.linh_vuc_van_ban.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LinhVucVanBanSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.linh_vuc_van_ban.service.http.LinhVucVanBanServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_van_ban.service.http.LinhVucVanBanServiceSoap
 *
 */
public class LinhVucVanBanSoap implements Serializable {
    private long _maLinhVucVanBan;
    private String _tenLinhVucVanBan;
    private long _parentid;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;

    public LinhVucVanBanSoap() {
    }

    public static LinhVucVanBanSoap toSoapModel(LinhVucVanBan model) {
        LinhVucVanBanSoap soapModel = new LinhVucVanBanSoap();

        soapModel.setMaLinhVucVanBan(model.getMaLinhVucVanBan());
        soapModel.setTenLinhVucVanBan(model.getTenLinhVucVanBan());
        soapModel.setParentid(model.getParentid());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static LinhVucVanBanSoap[] toSoapModels(LinhVucVanBan[] models) {
        LinhVucVanBanSoap[] soapModels = new LinhVucVanBanSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LinhVucVanBanSoap[][] toSoapModels(LinhVucVanBan[][] models) {
        LinhVucVanBanSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LinhVucVanBanSoap[models.length][models[0].length];
        } else {
            soapModels = new LinhVucVanBanSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LinhVucVanBanSoap[] toSoapModels(List<LinhVucVanBan> models) {
        List<LinhVucVanBanSoap> soapModels = new ArrayList<LinhVucVanBanSoap>(models.size());

        for (LinhVucVanBan model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LinhVucVanBanSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maLinhVucVanBan;
    }

    public void setPrimaryKey(long pk) {
        setMaLinhVucVanBan(pk);
    }

    public long getMaLinhVucVanBan() {
        return _maLinhVucVanBan;
    }

    public void setMaLinhVucVanBan(long maLinhVucVanBan) {
        _maLinhVucVanBan = maLinhVucVanBan;
    }

    public String getTenLinhVucVanBan() {
        return _tenLinhVucVanBan;
    }

    public void setTenLinhVucVanBan(String tenLinhVucVanBan) {
        _tenLinhVucVanBan = tenLinhVucVanBan;
    }

    public long getParentid() {
        return _parentid;
    }

    public void setParentid(long parentid) {
        _parentid = parentid;
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
