package com.sgs.portlet.report_registry_work.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="DepartmentSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.report_registry_work.service.http.DepartmentServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.http.DepartmentServiceSoap
 *
 */
public class DepartmentSoap implements Serializable {
    private long _departmentId;
    private String _departmentCode;
    private String _departmentName;
    private String _departmentDescription;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public DepartmentSoap() {
    }

    public static DepartmentSoap toSoapModel(Department model) {
        DepartmentSoap soapModel = new DepartmentSoap();

        soapModel.setDepartmentId(model.getDepartmentId());
        soapModel.setDepartmentCode(model.getDepartmentCode());
        soapModel.setDepartmentName(model.getDepartmentName());
        soapModel.setDepartmentDescription(model.getDepartmentDescription());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static DepartmentSoap[] toSoapModels(List<Department> models) {
        List<DepartmentSoap> soapModels = new ArrayList<DepartmentSoap>(models.size());

        for (Department model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DepartmentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _departmentId;
    }

    public void setPrimaryKey(long pk) {
        setDepartmentId(pk);
    }

    public long getDepartmentId() {
        return _departmentId;
    }

    public void setDepartmentId(long departmentId) {
        _departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return _departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        _departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return _departmentName;
    }

    public void setDepartmentName(String departmentName) {
        _departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return _departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        _departmentDescription = departmentDescription;
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
