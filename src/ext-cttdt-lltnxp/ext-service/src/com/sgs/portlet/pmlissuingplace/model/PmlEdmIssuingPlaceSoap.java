package com.sgs.portlet.pmlissuingplace.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmIssuingPlaceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pmlissuingplace.service.http.PmlEdmIssuingPlaceServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlissuingplace.service.http.PmlEdmIssuingPlaceServiceSoap
 *
 */
public class PmlEdmIssuingPlaceSoap implements Serializable {
    private String _issuingPlaceId;
    private String _issuingPlaceName;
    private String _tablePhone;
    private String _handPhone;
    private String _email;
    private String _address;
    private String _active;
    private String _note;
    private String _issuingPlaceCode;
    private String _signer;

    public PmlEdmIssuingPlaceSoap() {
    }

    public static PmlEdmIssuingPlaceSoap toSoapModel(PmlEdmIssuingPlace model) {
        PmlEdmIssuingPlaceSoap soapModel = new PmlEdmIssuingPlaceSoap();

        soapModel.setIssuingPlaceId(model.getIssuingPlaceId());
        soapModel.setIssuingPlaceName(model.getIssuingPlaceName());
        soapModel.setTablePhone(model.getTablePhone());
        soapModel.setHandPhone(model.getHandPhone());
        soapModel.setEmail(model.getEmail());
        soapModel.setAddress(model.getAddress());
        soapModel.setActive(model.getActive());
        soapModel.setNote(model.getNote());
        soapModel.setIssuingPlaceCode(model.getIssuingPlaceCode());
        soapModel.setSigner(model.getSigner());

        return soapModel;
    }

    public static PmlEdmIssuingPlaceSoap[] toSoapModels(
        List<PmlEdmIssuingPlace> models) {
        List<PmlEdmIssuingPlaceSoap> soapModels = new ArrayList<PmlEdmIssuingPlaceSoap>(models.size());

        for (PmlEdmIssuingPlace model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmIssuingPlaceSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _issuingPlaceId;
    }

    public void setPrimaryKey(String pk) {
        setIssuingPlaceId(pk);
    }

    public String getIssuingPlaceId() {
        return _issuingPlaceId;
    }

    public void setIssuingPlaceId(String issuingPlaceId) {
        _issuingPlaceId = issuingPlaceId;
    }

    public String getIssuingPlaceName() {
        return _issuingPlaceName;
    }

    public void setIssuingPlaceName(String issuingPlaceName) {
        _issuingPlaceName = issuingPlaceName;
    }

    public String getTablePhone() {
        return _tablePhone;
    }

    public void setTablePhone(String tablePhone) {
        _tablePhone = tablePhone;
    }

    public String getHandPhone() {
        return _handPhone;
    }

    public void setHandPhone(String handPhone) {
        _handPhone = handPhone;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    public String getIssuingPlaceCode() {
        return _issuingPlaceCode;
    }

    public void setIssuingPlaceCode(String issuingPlaceCode) {
        _issuingPlaceCode = issuingPlaceCode;
    }

    public String getSigner() {
        return _signer;
    }

    public void setSigner(String signer) {
        _signer = signer;
    }
}
