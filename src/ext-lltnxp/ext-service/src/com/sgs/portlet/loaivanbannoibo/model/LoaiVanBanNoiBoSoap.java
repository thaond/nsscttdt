package com.sgs.portlet.loaivanbannoibo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="LoaiVanBanNoiBoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.loaivanbannoibo.service.http.LoaiVanBanNoiBoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.service.http.LoaiVanBanNoiBoServiceSoap
 *
 */
public class LoaiVanBanNoiBoSoap implements Serializable {
    private long _loaiVanBanNoiBoId;
    private String _kyHieuLoaiVanBanNoiBo;
    private String _tenLoaiVanBanNoiBo;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public LoaiVanBanNoiBoSoap() {
    }

    public static LoaiVanBanNoiBoSoap toSoapModel(LoaiVanBanNoiBo model) {
        LoaiVanBanNoiBoSoap soapModel = new LoaiVanBanNoiBoSoap();

        soapModel.setLoaiVanBanNoiBoId(model.getLoaiVanBanNoiBoId());
        soapModel.setKyHieuLoaiVanBanNoiBo(model.getKyHieuLoaiVanBanNoiBo());
        soapModel.setTenLoaiVanBanNoiBo(model.getTenLoaiVanBanNoiBo());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static LoaiVanBanNoiBoSoap[] toSoapModels(
        List<LoaiVanBanNoiBo> models) {
        List<LoaiVanBanNoiBoSoap> soapModels = new ArrayList<LoaiVanBanNoiBoSoap>(models.size());

        for (LoaiVanBanNoiBo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LoaiVanBanNoiBoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _loaiVanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setLoaiVanBanNoiBoId(pk);
    }

    public long getLoaiVanBanNoiBoId() {
        return _loaiVanBanNoiBoId;
    }

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId) {
        _loaiVanBanNoiBoId = loaiVanBanNoiBoId;
    }

    public String getKyHieuLoaiVanBanNoiBo() {
        return _kyHieuLoaiVanBanNoiBo;
    }

    public void setKyHieuLoaiVanBanNoiBo(String kyHieuLoaiVanBanNoiBo) {
        _kyHieuLoaiVanBanNoiBo = kyHieuLoaiVanBanNoiBo;
    }

    public String getTenLoaiVanBanNoiBo() {
        return _tenLoaiVanBanNoiBo;
    }

    public void setTenLoaiVanBanNoiBo(String tenLoaiVanBanNoiBo) {
        _tenLoaiVanBanNoiBo = tenLoaiVanBanNoiBo;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }
}
