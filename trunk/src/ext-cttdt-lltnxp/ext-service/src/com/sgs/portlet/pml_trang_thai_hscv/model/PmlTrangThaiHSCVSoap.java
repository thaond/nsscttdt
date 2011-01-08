package com.sgs.portlet.pml_trang_thai_hscv.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTrangThaiHSCVSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_trang_thai_hscv.service.http.PmlTrangThaiHSCVServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.http.PmlTrangThaiHSCVServiceSoap
 *
 */
public class PmlTrangThaiHSCVSoap implements Serializable {
    private long _idTrangThaiHSCV;
    private String _tenTrangThaiHSCV;

    public PmlTrangThaiHSCVSoap() {
    }

    public static PmlTrangThaiHSCVSoap toSoapModel(PmlTrangThaiHSCV model) {
        PmlTrangThaiHSCVSoap soapModel = new PmlTrangThaiHSCVSoap();

        soapModel.setIdTrangThaiHSCV(model.getIdTrangThaiHSCV());
        soapModel.setTenTrangThaiHSCV(model.getTenTrangThaiHSCV());

        return soapModel;
    }

    public static PmlTrangThaiHSCVSoap[] toSoapModels(
        List<PmlTrangThaiHSCV> models) {
        List<PmlTrangThaiHSCVSoap> soapModels = new ArrayList<PmlTrangThaiHSCVSoap>(models.size());

        for (PmlTrangThaiHSCV model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlTrangThaiHSCVSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _idTrangThaiHSCV;
    }

    public void setPrimaryKey(long pk) {
        setIdTrangThaiHSCV(pk);
    }

    public long getIdTrangThaiHSCV() {
        return _idTrangThaiHSCV;
    }

    public void setIdTrangThaiHSCV(long idTrangThaiHSCV) {
        _idTrangThaiHSCV = idTrangThaiHSCV;
    }

    public String getTenTrangThaiHSCV() {
        return _tenTrangThaiHSCV;
    }

    public void setTenTrangThaiHSCV(String tenTrangThaiHSCV) {
        _tenTrangThaiHSCV = tenTrangThaiHSCV;
    }
}
