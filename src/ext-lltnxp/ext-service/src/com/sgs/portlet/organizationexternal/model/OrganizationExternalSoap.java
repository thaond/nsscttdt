package com.sgs.portlet.organizationexternal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="OrganizationExternalSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.organizationexternal.service.http.OrganizationExternalServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.organizationexternal.service.http.OrganizationExternalServiceSoap
 *
 */
public class OrganizationExternalSoap implements Serializable {
    private long _orgExternalId;
    private String _orgExternalCode;
    private String _orgExternalName;
    private boolean _isOwnerOrg;

    public OrganizationExternalSoap() {
    }

    public static OrganizationExternalSoap toSoapModel(
        OrganizationExternal model) {
        OrganizationExternalSoap soapModel = new OrganizationExternalSoap();

        soapModel.setOrgExternalId(model.getOrgExternalId());
        soapModel.setOrgExternalCode(model.getOrgExternalCode());
        soapModel.setOrgExternalName(model.getOrgExternalName());
        soapModel.setIsOwnerOrg(model.getIsOwnerOrg());

        return soapModel;
    }

    public static OrganizationExternalSoap[] toSoapModels(
        List<OrganizationExternal> models) {
        List<OrganizationExternalSoap> soapModels = new ArrayList<OrganizationExternalSoap>(models.size());

        for (OrganizationExternal model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new OrganizationExternalSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _orgExternalId;
    }

    public void setPrimaryKey(long pk) {
        setOrgExternalId(pk);
    }

    public long getOrgExternalId() {
        return _orgExternalId;
    }

    public void setOrgExternalId(long orgExternalId) {
        _orgExternalId = orgExternalId;
    }

    public String getOrgExternalCode() {
        return _orgExternalCode;
    }

    public void setOrgExternalCode(String orgExternalCode) {
        _orgExternalCode = orgExternalCode;
    }

    public String getOrgExternalName() {
        return _orgExternalName;
    }

    public void setOrgExternalName(String orgExternalName) {
        _orgExternalName = orgExternalName;
    }

    public boolean getIsOwnerOrg() {
        return _isOwnerOrg;
    }

    public boolean isIsOwnerOrg() {
        return _isOwnerOrg;
    }

    public void setIsOwnerOrg(boolean isOwnerOrg) {
        _isOwnerOrg = isOwnerOrg;
    }
}
