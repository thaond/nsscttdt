package com.nss.portlet.department.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlUserSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.department.service.http.PmlUserServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.service.http.PmlUserServiceSoap
 *
 */
public class PmlUserSoap implements Serializable {
    private long _userId;
    private String _departmentsId;
    private String _positionId;
    private Boolean _active;

    public PmlUserSoap() {
    }

    public static PmlUserSoap toSoapModel(PmlUser model) {
        PmlUserSoap soapModel = new PmlUserSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setDepartmentsId(model.getDepartmentsId());
        soapModel.setPositionId(model.getPositionId());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static PmlUserSoap[] toSoapModels(PmlUser[] models) {
        PmlUserSoap[] soapModels = new PmlUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlUserSoap[][] toSoapModels(PmlUser[][] models) {
        PmlUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlUserSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlUserSoap[] toSoapModels(List<PmlUser> models) {
        List<PmlUserSoap> soapModels = new ArrayList<PmlUserSoap>(models.size());

        for (PmlUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlUserSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getDepartmentsId() {
        return _departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public String getPositionId() {
        return _positionId;
    }

    public void setPositionId(String positionId) {
        _positionId = positionId;
    }

    public Boolean getActive() {
        return _active;
    }

    public void setActive(Boolean active) {
        _active = active;
    }
}
