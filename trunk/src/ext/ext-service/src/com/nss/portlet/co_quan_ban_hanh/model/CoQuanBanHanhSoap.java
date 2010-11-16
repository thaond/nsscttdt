package com.nss.portlet.co_quan_ban_hanh.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="CoQuanBanHanhSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.co_quan_ban_hanh.service.http.CoQuanBanHanhServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.co_quan_ban_hanh.service.http.CoQuanBanHanhServiceSoap
 *
 */
public class CoQuanBanHanhSoap implements Serializable {
    private long _maCoQuanBanHanh;
    private String _tenCoQuanBanHanh;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;

    public CoQuanBanHanhSoap() {
    }

    public static CoQuanBanHanhSoap toSoapModel(CoQuanBanHanh model) {
        CoQuanBanHanhSoap soapModel = new CoQuanBanHanhSoap();

        soapModel.setMaCoQuanBanHanh(model.getMaCoQuanBanHanh());
        soapModel.setTenCoQuanBanHanh(model.getTenCoQuanBanHanh());
        soapModel.setCompanyid(model.getCompanyid());
        soapModel.setUserid(model.getUserid());
        soapModel.setCreatedate(model.getCreatedate());
        soapModel.setModifieddate(model.getModifieddate());
        soapModel.setActive(model.getActive());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static CoQuanBanHanhSoap[] toSoapModels(CoQuanBanHanh[] models) {
        CoQuanBanHanhSoap[] soapModels = new CoQuanBanHanhSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CoQuanBanHanhSoap[][] toSoapModels(CoQuanBanHanh[][] models) {
        CoQuanBanHanhSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CoQuanBanHanhSoap[models.length][models[0].length];
        } else {
            soapModels = new CoQuanBanHanhSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CoQuanBanHanhSoap[] toSoapModels(List<CoQuanBanHanh> models) {
        List<CoQuanBanHanhSoap> soapModels = new ArrayList<CoQuanBanHanhSoap>(models.size());

        for (CoQuanBanHanh model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CoQuanBanHanhSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _maCoQuanBanHanh;
    }

    public void setPrimaryKey(long pk) {
        setMaCoQuanBanHanh(pk);
    }

    public long getMaCoQuanBanHanh() {
        return _maCoQuanBanHanh;
    }

    public void setMaCoQuanBanHanh(long maCoQuanBanHanh) {
        _maCoQuanBanHanh = maCoQuanBanHanh;
    }

    public String getTenCoQuanBanHanh() {
        return _tenCoQuanBanHanh;
    }

    public void setTenCoQuanBanHanh(String tenCoQuanBanHanh) {
        _tenCoQuanBanHanh = tenCoQuanBanHanh;
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
