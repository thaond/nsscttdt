package com.nss.portlet.position.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PositionSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.position.service.http.PositionServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.position.service.http.PositionServiceSoap
 *
 */
public class PositionSoap implements Serializable {
    private String _positionId;
    private String _positionCode;
    private String _positionName;
    private String _description;
    private String _active;

    public PositionSoap() {
    }

    public static PositionSoap toSoapModel(Position model) {
        PositionSoap soapModel = new PositionSoap();

        soapModel.setPositionId(model.getPositionId());
        soapModel.setPositionCode(model.getPositionCode());
        soapModel.setPositionName(model.getPositionName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static PositionSoap[] toSoapModels(Position[] models) {
        PositionSoap[] soapModels = new PositionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PositionSoap[][] toSoapModels(Position[][] models) {
        PositionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PositionSoap[models.length][models[0].length];
        } else {
            soapModels = new PositionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PositionSoap[] toSoapModels(List<Position> models) {
        List<PositionSoap> soapModels = new ArrayList<PositionSoap>(models.size());

        for (Position model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PositionSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _positionId;
    }

    public void setPrimaryKey(String pk) {
        setPositionId(pk);
    }

    public String getPositionId() {
        return _positionId;
    }

    public void setPositionId(String positionId) {
        _positionId = positionId;
    }

    public String getPositionCode() {
        return _positionCode;
    }

    public void setPositionCode(String positionCode) {
        _positionCode = positionCode;
    }

    public String getPositionName() {
        return _positionName;
    }

    public void setPositionName(String positionName) {
        _positionName = positionName;
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
