package com.sgs.portlet.department.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDepartmentHSCVSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.department.service.http.PmlDepartmentHSCVServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.service.http.PmlDepartmentHSCVServiceSoap
 *
 */
public class PmlDepartmentHSCVSoap implements Serializable {
    private long _pmlDepartmentHSCVId;
    private String _departmentsId;
    private long _id_ho_so_cong_viec;
    private String _description;

    public PmlDepartmentHSCVSoap() {
    }

    public static PmlDepartmentHSCVSoap toSoapModel(PmlDepartmentHSCV model) {
        PmlDepartmentHSCVSoap soapModel = new PmlDepartmentHSCVSoap();

        soapModel.setPmlDepartmentHSCVId(model.getPmlDepartmentHSCVId());
        soapModel.setDepartmentsId(model.getDepartmentsId());
        soapModel.setId_ho_so_cong_viec(model.getId_ho_so_cong_viec());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static PmlDepartmentHSCVSoap[] toSoapModels(
        List<PmlDepartmentHSCV> models) {
        List<PmlDepartmentHSCVSoap> soapModels = new ArrayList<PmlDepartmentHSCVSoap>(models.size());

        for (PmlDepartmentHSCV model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDepartmentHSCVSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _pmlDepartmentHSCVId;
    }

    public void setPrimaryKey(long pk) {
        setPmlDepartmentHSCVId(pk);
    }

    public long getPmlDepartmentHSCVId() {
        return _pmlDepartmentHSCVId;
    }

    public void setPmlDepartmentHSCVId(long pmlDepartmentHSCVId) {
        _pmlDepartmentHSCVId = pmlDepartmentHSCVId;
    }

    public String getDepartmentsId() {
        return _departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public long getId_ho_so_cong_viec() {
        return _id_ho_so_cong_viec;
    }

    public void setId_ho_so_cong_viec(long id_ho_so_cong_viec) {
        _id_ho_so_cong_viec = id_ho_so_cong_viec;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
