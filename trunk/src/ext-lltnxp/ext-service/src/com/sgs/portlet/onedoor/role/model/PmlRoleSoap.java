package com.sgs.portlet.onedoor.role.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlRoleSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.role.service.http.PmlRoleServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.role.service.http.PmlRoleServiceSoap
 *
 */
public class PmlRoleSoap implements Serializable {
    private String _roleId;
    private String _roleCode;
    private String _roleName;
    private String _description;
    private String _active;

    public PmlRoleSoap() {
    }

    public static PmlRoleSoap toSoapModel(PmlRole model) {
        PmlRoleSoap soapModel = new PmlRoleSoap();

        soapModel.setRoleId(model.getRoleId());
        soapModel.setRoleCode(model.getRoleCode());
        soapModel.setRoleName(model.getRoleName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static PmlRoleSoap[] toSoapModels(List<PmlRole> models) {
        List<PmlRoleSoap> soapModels = new ArrayList<PmlRoleSoap>(models.size());

        for (PmlRole model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlRoleSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _roleId;
    }

    public void setPrimaryKey(String pk) {
        setRoleId(pk);
    }

    public String getRoleId() {
        return _roleId;
    }

    public void setRoleId(String roleId) {
        _roleId = roleId;
    }

    public String getRoleCode() {
        return _roleCode;
    }

    public void setRoleCode(String roleCode) {
        _roleCode = roleCode;
    }

    public String getRoleName() {
        return _roleName;
    }

    public void setRoleName(String roleName) {
        _roleName = roleName;
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
}
