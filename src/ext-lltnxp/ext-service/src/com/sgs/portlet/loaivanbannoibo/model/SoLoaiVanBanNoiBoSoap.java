package com.sgs.portlet.loaivanbannoibo.model;

import com.sgs.portlet.loaivanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="SoLoaiVanBanNoiBoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.loaivanbannoibo.service.http.SoLoaiVanBanNoiBoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.service.http.SoLoaiVanBanNoiBoServiceSoap
 *
 */
public class SoLoaiVanBanNoiBoSoap implements Serializable {
    private long _soVanBanNoiBoId;
    private long _loaiVanBanNoiBoId;

    public SoLoaiVanBanNoiBoSoap() {
    }

    public static SoLoaiVanBanNoiBoSoap toSoapModel(SoLoaiVanBanNoiBo model) {
        SoLoaiVanBanNoiBoSoap soapModel = new SoLoaiVanBanNoiBoSoap();

        soapModel.setSoVanBanNoiBoId(model.getSoVanBanNoiBoId());
        soapModel.setLoaiVanBanNoiBoId(model.getLoaiVanBanNoiBoId());

        return soapModel;
    }

    public static SoLoaiVanBanNoiBoSoap[] toSoapModels(
        List<SoLoaiVanBanNoiBo> models) {
        List<SoLoaiVanBanNoiBoSoap> soapModels = new ArrayList<SoLoaiVanBanNoiBoSoap>(models.size());

        for (SoLoaiVanBanNoiBo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SoLoaiVanBanNoiBoSoap[soapModels.size()]);
    }

    public SoLoaiVanBanNoiBoPK getPrimaryKey() {
        return new SoLoaiVanBanNoiBoPK(_soVanBanNoiBoId, _loaiVanBanNoiBoId);
    }

    public void setPrimaryKey(SoLoaiVanBanNoiBoPK pk) {
        setSoVanBanNoiBoId(pk.soVanBanNoiBoId);
        setLoaiVanBanNoiBoId(pk.loaiVanBanNoiBoId);
    }

    public long getSoVanBanNoiBoId() {
        return _soVanBanNoiBoId;
    }

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId) {
        _soVanBanNoiBoId = soVanBanNoiBoId;
    }

    public long getLoaiVanBanNoiBoId() {
        return _loaiVanBanNoiBoId;
    }

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId) {
        _loaiVanBanNoiBoId = loaiVanBanNoiBoId;
    }
}
