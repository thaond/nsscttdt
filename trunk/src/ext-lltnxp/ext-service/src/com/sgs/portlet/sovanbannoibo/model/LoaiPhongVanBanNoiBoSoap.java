package com.sgs.portlet.sovanbannoibo.model;

import com.sgs.portlet.sovanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="LoaiPhongVanBanNoiBoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.sovanbannoibo.service.http.LoaiPhongVanBanNoiBoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.http.LoaiPhongVanBanNoiBoServiceSoap
 *
 */
public class LoaiPhongVanBanNoiBoSoap implements Serializable {
    private long _loaiVanBanNoiBoId;
    private String _phongVanBanNoiBoId;

    public LoaiPhongVanBanNoiBoSoap() {
    }

    public static LoaiPhongVanBanNoiBoSoap toSoapModel(
        LoaiPhongVanBanNoiBo model) {
        LoaiPhongVanBanNoiBoSoap soapModel = new LoaiPhongVanBanNoiBoSoap();

        soapModel.setLoaiVanBanNoiBoId(model.getLoaiVanBanNoiBoId());
        soapModel.setPhongVanBanNoiBoId(model.getPhongVanBanNoiBoId());

        return soapModel;
    }

    public static LoaiPhongVanBanNoiBoSoap[] toSoapModels(
        List<LoaiPhongVanBanNoiBo> models) {
        List<LoaiPhongVanBanNoiBoSoap> soapModels = new ArrayList<LoaiPhongVanBanNoiBoSoap>(models.size());

        for (LoaiPhongVanBanNoiBo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LoaiPhongVanBanNoiBoSoap[soapModels.size()]);
    }

    public LoaiPhongVanBanNoiBoPK getPrimaryKey() {
        return new LoaiPhongVanBanNoiBoPK(_loaiVanBanNoiBoId,
            _phongVanBanNoiBoId);
    }

    public void setPrimaryKey(LoaiPhongVanBanNoiBoPK pk) {
        setLoaiVanBanNoiBoId(pk.loaiVanBanNoiBoId);
        setPhongVanBanNoiBoId(pk.phongVanBanNoiBoId);
    }

    public long getLoaiVanBanNoiBoId() {
        return _loaiVanBanNoiBoId;
    }

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId) {
        _loaiVanBanNoiBoId = loaiVanBanNoiBoId;
    }

    public String getPhongVanBanNoiBoId() {
        return _phongVanBanNoiBoId;
    }

    public void setPhongVanBanNoiBoId(String phongVanBanNoiBoId) {
        _phongVanBanNoiBoId = phongVanBanNoiBoId;
    }
}
