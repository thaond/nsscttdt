package com.sgs.portlet.department.model;

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
 * <code>com.sgs.portlet.department.service.http.DepartmentServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.service.http.DepartmentServiceSoap
 *
 */
public class DepartmentSoap implements Serializable {
    private String _departmentsId;
    private String _departmentsParentId;
    private String _departmentsCode;
    private String _departmentsName;
    private String _abbreviateName;
    private String _description;
    private String _active;
    private String _agencyId;
    private long _roleId;
    private String _hasTeam;

    public DepartmentSoap() {
    }

    public static DepartmentSoap toSoapModel(Department model) {
        DepartmentSoap soapModel = new DepartmentSoap();

        soapModel.setDepartmentsId(model.getDepartmentsId());
        soapModel.setDepartmentsParentId(model.getDepartmentsParentId());
        soapModel.setDepartmentsCode(model.getDepartmentsCode());
        soapModel.setDepartmentsName(model.getDepartmentsName());
        soapModel.setAbbreviateName(model.getAbbreviateName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());
        soapModel.setAgencyId(model.getAgencyId());
        soapModel.setRoleId(model.getRoleId());
        soapModel.setHasTeam(model.getHasTeam());

        return soapModel;
    }

    public static DepartmentSoap[] toSoapModels(List<Department> models) {
        List<DepartmentSoap> soapModels = new ArrayList<DepartmentSoap>(models.size());

        for (Department model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DepartmentSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _departmentsId;
    }

    public void setPrimaryKey(String pk) {
        setDepartmentsId(pk);
    }

    public String getDepartmentsId() {
        return _departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public String getDepartmentsParentId() {
        return _departmentsParentId;
    }

    public void setDepartmentsParentId(String departmentsParentId) {
        _departmentsParentId = departmentsParentId;
    }

    public String getDepartmentsCode() {
        return _departmentsCode;
    }

    public void setDepartmentsCode(String departmentsCode) {
        _departmentsCode = departmentsCode;
    }

    public String getDepartmentsName() {
        return _departmentsName;
    }

    public void setDepartmentsName(String departmentsName) {
        _departmentsName = departmentsName;
    }

    public String getAbbreviateName() {
        return _abbreviateName;
    }

    public void setAbbreviateName(String abbreviateName) {
        _abbreviateName = abbreviateName;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }

    public String getAgencyId() {
        return _agencyId;
    }

    public void setAgencyId(String agencyId) {
        _agencyId = agencyId;
    }

    public long getRoleId() {
        return _roleId;
    }

    public void setRoleId(long roleId) {
        _roleId = roleId;
    }

    public String getHasTeam() {
        return _hasTeam;
    }

    public void setHasTeam(String hasTeam) {
        _hasTeam = hasTeam;
    }
}
