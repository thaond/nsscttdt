package com.sgs.portlet.loaivanbannoibo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="SoVanBanNoiBoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.loaivanbannoibo.service.http.SoVanBanNoiBoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.service.http.SoVanBanNoiBoServiceSoap
 *
 */
public class SoVanBanNoiBoSoap implements Serializable {
    private long _soVanBanNoiBoId;
    private String _maSoVanBanNoiBo;
    private String _tenSoVanBanNoiBo;
    private Date _ngayTao;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public SoVanBanNoiBoSoap() {
    }

    public static SoVanBanNoiBoSoap toSoapModel(SoVanBanNoiBo model) {
        SoVanBanNoiBoSoap soapModel = new SoVanBanNoiBoSoap();

        soapModel.setSoVanBanNoiBoId(model.getSoVanBanNoiBoId());
        soapModel.setMaSoVanBanNoiBo(model.getMaSoVanBanNoiBo());
        soapModel.setTenSoVanBanNoiBo(model.getTenSoVanBanNoiBo());
        soapModel.setNgayTao(model.getNgayTao());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static SoVanBanNoiBoSoap[] toSoapModels(List<SoVanBanNoiBo> models) {
        List<SoVanBanNoiBoSoap> soapModels = new ArrayList<SoVanBanNoiBoSoap>(models.size());

        for (SoVanBanNoiBo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SoVanBanNoiBoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _soVanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setSoVanBanNoiBoId(pk);
    }

    public long getSoVanBanNoiBoId() {
        return _soVanBanNoiBoId;
    }

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId) {
        _soVanBanNoiBoId = soVanBanNoiBoId;
    }

    public String getMaSoVanBanNoiBo() {
        return _maSoVanBanNoiBo;
    }

    public void setMaSoVanBanNoiBo(String maSoVanBanNoiBo) {
        _maSoVanBanNoiBo = maSoVanBanNoiBo;
    }

    public String getTenSoVanBanNoiBo() {
        return _tenSoVanBanNoiBo;
    }

    public void setTenSoVanBanNoiBo(String tenSoVanBanNoiBo) {
        _tenSoVanBanNoiBo = tenSoVanBanNoiBo;
    }

    public Date getNgayTao() {
        return _ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        _ngayTao = ngayTao;
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
