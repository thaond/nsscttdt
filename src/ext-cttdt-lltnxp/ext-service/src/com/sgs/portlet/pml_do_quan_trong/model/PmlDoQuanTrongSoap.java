package com.sgs.portlet.pml_do_quan_trong.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDoQuanTrongSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_do_quan_trong.service.http.PmlDoQuanTrongServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_do_quan_trong.service.http.PmlDoQuanTrongServiceSoap
 *
 */
public class PmlDoQuanTrongSoap implements Serializable {
    private long _idDoQuanTrong;
    private String _tenDoQuanTrong;

    public PmlDoQuanTrongSoap() {
    }

    public static PmlDoQuanTrongSoap toSoapModel(PmlDoQuanTrong model) {
        PmlDoQuanTrongSoap soapModel = new PmlDoQuanTrongSoap();

        soapModel.setIdDoQuanTrong(model.getIdDoQuanTrong());
        soapModel.setTenDoQuanTrong(model.getTenDoQuanTrong());

        return soapModel;
    }

    public static PmlDoQuanTrongSoap[] toSoapModels(List<PmlDoQuanTrong> models) {
        List<PmlDoQuanTrongSoap> soapModels = new ArrayList<PmlDoQuanTrongSoap>(models.size());

        for (PmlDoQuanTrong model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDoQuanTrongSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _idDoQuanTrong;
    }

    public void setPrimaryKey(long pk) {
        setIdDoQuanTrong(pk);
    }

    public long getIdDoQuanTrong() {
        return _idDoQuanTrong;
    }

    public void setIdDoQuanTrong(long idDoQuanTrong) {
        _idDoQuanTrong = idDoQuanTrong;
    }

    public String getTenDoQuanTrong() {
        return _tenDoQuanTrong;
    }

    public void setTenDoQuanTrong(String tenDoQuanTrong) {
        _tenDoQuanTrong = tenDoQuanTrong;
    }
}
