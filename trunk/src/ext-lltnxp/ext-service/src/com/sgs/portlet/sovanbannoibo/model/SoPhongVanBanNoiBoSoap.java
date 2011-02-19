package com.sgs.portlet.sovanbannoibo.model;

import com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="SoPhongVanBanNoiBoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.sovanbannoibo.service.http.SoPhongVanBanNoiBoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.service.http.SoPhongVanBanNoiBoServiceSoap
 *
 */
public class SoPhongVanBanNoiBoSoap implements Serializable {
    private long _soVanBanNoiBoId;
    private String _phongVanBanNoiBoId;

    public SoPhongVanBanNoiBoSoap() {
    }

    public static SoPhongVanBanNoiBoSoap toSoapModel(SoPhongVanBanNoiBo model) {
        SoPhongVanBanNoiBoSoap soapModel = new SoPhongVanBanNoiBoSoap();

        soapModel.setSoVanBanNoiBoId(model.getSoVanBanNoiBoId());
        soapModel.setPhongVanBanNoiBoId(model.getPhongVanBanNoiBoId());

        return soapModel;
    }

    public static SoPhongVanBanNoiBoSoap[] toSoapModels(
        List<SoPhongVanBanNoiBo> models) {
        List<SoPhongVanBanNoiBoSoap> soapModels = new ArrayList<SoPhongVanBanNoiBoSoap>(models.size());

        for (SoPhongVanBanNoiBo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SoPhongVanBanNoiBoSoap[soapModels.size()]);
    }

    public SoPhongVanBanNoiBoPK getPrimaryKey() {
        return new SoPhongVanBanNoiBoPK(_soVanBanNoiBoId, _phongVanBanNoiBoId);
    }

    public void setPrimaryKey(SoPhongVanBanNoiBoPK pk) {
        setSoVanBanNoiBoId(pk.soVanBanNoiBoId);
        setPhongVanBanNoiBoId(pk.phongVanBanNoiBoId);
    }

    public long getSoVanBanNoiBoId() {
        return _soVanBanNoiBoId;
    }

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId) {
        _soVanBanNoiBoId = soVanBanNoiBoId;
    }

    public String getPhongVanBanNoiBoId() {
        return _phongVanBanNoiBoId;
    }

    public void setPhongVanBanNoiBoId(String phongVanBanNoiBoId) {
        _phongVanBanNoiBoId = phongVanBanNoiBoId;
    }
}
