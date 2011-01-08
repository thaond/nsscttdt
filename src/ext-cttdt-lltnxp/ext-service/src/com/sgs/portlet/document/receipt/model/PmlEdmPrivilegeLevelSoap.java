package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmPrivilegeLevelSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmPrivilegeLevelServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmPrivilegeLevelServiceSoap
 *
 */
public class PmlEdmPrivilegeLevelSoap implements Serializable {
    private String _privilegeLevelId;
    private String _privilegeLevelName;

    public PmlEdmPrivilegeLevelSoap() {
    }

    public static PmlEdmPrivilegeLevelSoap toSoapModel(
        PmlEdmPrivilegeLevel model) {
        PmlEdmPrivilegeLevelSoap soapModel = new PmlEdmPrivilegeLevelSoap();

        soapModel.setPrivilegeLevelId(model.getPrivilegeLevelId());
        soapModel.setPrivilegeLevelName(model.getPrivilegeLevelName());

        return soapModel;
    }

    public static PmlEdmPrivilegeLevelSoap[] toSoapModels(
        List<PmlEdmPrivilegeLevel> models) {
        List<PmlEdmPrivilegeLevelSoap> soapModels = new ArrayList<PmlEdmPrivilegeLevelSoap>(models.size());

        for (PmlEdmPrivilegeLevel model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmPrivilegeLevelSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _privilegeLevelId;
    }

    public void setPrimaryKey(String pk) {
        setPrivilegeLevelId(pk);
    }

    public String getPrivilegeLevelId() {
        return _privilegeLevelId;
    }

    public void setPrivilegeLevelId(String privilegeLevelId) {
        _privilegeLevelId = privilegeLevelId;
    }

    public String getPrivilegeLevelName() {
        return _privilegeLevelName;
    }

    public void setPrivilegeLevelName(String privilegeLevelName) {
        _privilegeLevelName = privilegeLevelName;
    }
}
