package com.sgs.portlet.document.send.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmCadreSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmCadreServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmCadreServiceSoap
 *
 */
public class PmlEdmCadreSoap implements Serializable {
    private long _userId;
    private String _positionId;
    private String _departmentsId;
    private String _handPhone;
    private String _note;
    private String _active;

    public PmlEdmCadreSoap() {
    }

    public static PmlEdmCadreSoap toSoapModel(PmlEdmCadre model) {
        PmlEdmCadreSoap soapModel = new PmlEdmCadreSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setPositionId(model.getPositionId());
        soapModel.setDepartmentsId(model.getDepartmentsId());
        soapModel.setHandPhone(model.getHandPhone());
        soapModel.setNote(model.getNote());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static PmlEdmCadreSoap[] toSoapModels(List<PmlEdmCadre> models) {
        List<PmlEdmCadreSoap> soapModels = new ArrayList<PmlEdmCadreSoap>(models.size());

        for (PmlEdmCadre model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmCadreSoap[soapModels.size()]);
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

    public String getPositionId() {
        return _positionId;
    }

    public void setPositionId(String positionId) {
        _positionId = positionId;
    }

    public String getDepartmentsId() {
        return _departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public String getHandPhone() {
        return _handPhone;
    }

    public void setHandPhone(String handPhone) {
        _handPhone = handPhone;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }
}
