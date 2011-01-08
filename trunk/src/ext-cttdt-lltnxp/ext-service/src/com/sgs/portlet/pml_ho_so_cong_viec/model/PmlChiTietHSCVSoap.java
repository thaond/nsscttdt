package com.sgs.portlet.pml_ho_so_cong_viec.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlChiTietHSCVSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.http.PmlChiTietHSCVServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.http.PmlChiTietHSCVServiceSoap
 *
 */
public class PmlChiTietHSCVSoap implements Serializable {
    private long _idChiTietHSCV;
    private long _idHoSoCongViec;
    private long _idCongVanDen;
    private long _idCongVanDi;
    private String _diDen;

    public PmlChiTietHSCVSoap() {
    }

    public static PmlChiTietHSCVSoap toSoapModel(PmlChiTietHSCV model) {
        PmlChiTietHSCVSoap soapModel = new PmlChiTietHSCVSoap();

        soapModel.setIdChiTietHSCV(model.getIdChiTietHSCV());
        soapModel.setIdHoSoCongViec(model.getIdHoSoCongViec());
        soapModel.setIdCongVanDen(model.getIdCongVanDen());
        soapModel.setIdCongVanDi(model.getIdCongVanDi());
        soapModel.setDiDen(model.getDiDen());

        return soapModel;
    }

    public static PmlChiTietHSCVSoap[] toSoapModels(List<PmlChiTietHSCV> models) {
        List<PmlChiTietHSCVSoap> soapModels = new ArrayList<PmlChiTietHSCVSoap>(models.size());

        for (PmlChiTietHSCV model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlChiTietHSCVSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _idChiTietHSCV;
    }

    public void setPrimaryKey(long pk) {
        setIdChiTietHSCV(pk);
    }

    public long getIdChiTietHSCV() {
        return _idChiTietHSCV;
    }

    public void setIdChiTietHSCV(long idChiTietHSCV) {
        _idChiTietHSCV = idChiTietHSCV;
    }

    public long getIdHoSoCongViec() {
        return _idHoSoCongViec;
    }

    public void setIdHoSoCongViec(long idHoSoCongViec) {
        _idHoSoCongViec = idHoSoCongViec;
    }

    public long getIdCongVanDen() {
        return _idCongVanDen;
    }

    public void setIdCongVanDen(long idCongVanDen) {
        _idCongVanDen = idCongVanDen;
    }

    public long getIdCongVanDi() {
        return _idCongVanDi;
    }

    public void setIdCongVanDi(long idCongVanDi) {
        _idCongVanDi = idCongVanDi;
    }

    public String getDiDen() {
        return _diDen;
    }

    public void setDiDen(String diDen) {
        _diDen = diDen;
    }
}
