package com.sgs.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTeamSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlTeamServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlTeamServiceSoap
 *
 */
public class PmlTeamSoap implements Serializable {
    private long _teamId;
    private String _departmentId;
    private String _teamName;
    private String _description;
    private long _organizationId;
    private long _companyId;
    private String _specialTeam;
    private String _teamCode;

    public PmlTeamSoap() {
    }

    public static PmlTeamSoap toSoapModel(PmlTeam model) {
        PmlTeamSoap soapModel = new PmlTeamSoap();

        soapModel.setTeamId(model.getTeamId());
        soapModel.setDepartmentId(model.getDepartmentId());
        soapModel.setTeamName(model.getTeamName());
        soapModel.setDescription(model.getDescription());
        soapModel.setOrganizationId(model.getOrganizationId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setSpecialTeam(model.getSpecialTeam());
        soapModel.setTeamCode(model.getTeamCode());

        return soapModel;
    }

    public static PmlTeamSoap[] toSoapModels(List<PmlTeam> models) {
        List<PmlTeamSoap> soapModels = new ArrayList<PmlTeamSoap>(models.size());

        for (PmlTeam model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlTeamSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _teamId;
    }

    public void setPrimaryKey(long pk) {
        setTeamId(pk);
    }

    public long getTeamId() {
        return _teamId;
    }

    public void setTeamId(long teamId) {
        _teamId = teamId;
    }

    public String getDepartmentId() {
        return _departmentId;
    }

    public void setDepartmentId(String departmentId) {
        _departmentId = departmentId;
    }

    public String getTeamName() {
        return _teamName;
    }

    public void setTeamName(String teamName) {
        _teamName = teamName;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getOrganizationId() {
        return _organizationId;
    }

    public void setOrganizationId(long organizationId) {
        _organizationId = organizationId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public String getSpecialTeam() {
        return _specialTeam;
    }

    public void setSpecialTeam(String specialTeam) {
        _specialTeam = specialTeam;
    }

    public String getTeamCode() {
        return _teamCode;
    }

    public void setTeamCode(String teamCode) {
        _teamCode = teamCode;
    }
}
