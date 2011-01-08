package com.sgs.portlet.document.model;

import com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlStateDepartmentSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlStateDepartmentServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlStateDepartmentServiceSoap
 *
 */
public class PmlStateDepartmentSoap implements Serializable {
    private String _departmentId;
    private long _stateWfId;

    public PmlStateDepartmentSoap() {
    }

    public static PmlStateDepartmentSoap toSoapModel(PmlStateDepartment model) {
        PmlStateDepartmentSoap soapModel = new PmlStateDepartmentSoap();

        soapModel.setDepartmentId(model.getDepartmentId());
        soapModel.setStateWfId(model.getStateWfId());

        return soapModel;
    }

    public static PmlStateDepartmentSoap[] toSoapModels(
        List<PmlStateDepartment> models) {
        List<PmlStateDepartmentSoap> soapModels = new ArrayList<PmlStateDepartmentSoap>(models.size());

        for (PmlStateDepartment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlStateDepartmentSoap[soapModels.size()]);
    }

    public PmlStateDepartmentPK getPrimaryKey() {
        return new PmlStateDepartmentPK(_departmentId, _stateWfId);
    }

    public void setPrimaryKey(PmlStateDepartmentPK pk) {
        setDepartmentId(pk.departmentId);
        setStateWfId(pk.stateWfId);
    }

    public String getDepartmentId() {
        return _departmentId;
    }

    public void setDepartmentId(String departmentId) {
        _departmentId = departmentId;
    }

    public long getStateWfId() {
        return _stateWfId;
    }

    public void setStateWfId(long stateWfId) {
        _stateWfId = stateWfId;
    }
}
