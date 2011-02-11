package com.sgs.portlet.document.receipt.model;

import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmLevelSendDetailSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmLevelSendDetailServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmLevelSendDetailServiceSoap
 *
 */
public class PmlEdmLevelSendDetailSoap implements Serializable {
    private int _levelSendId;
    private String _issuingPlaceId;

    public PmlEdmLevelSendDetailSoap() {
    }

    public static PmlEdmLevelSendDetailSoap toSoapModel(
        PmlEdmLevelSendDetail model) {
        PmlEdmLevelSendDetailSoap soapModel = new PmlEdmLevelSendDetailSoap();

        soapModel.setLevelSendId(model.getLevelSendId());
        soapModel.setIssuingPlaceId(model.getIssuingPlaceId());

        return soapModel;
    }

    public static PmlEdmLevelSendDetailSoap[] toSoapModels(
        List<PmlEdmLevelSendDetail> models) {
        List<PmlEdmLevelSendDetailSoap> soapModels = new ArrayList<PmlEdmLevelSendDetailSoap>(models.size());

        for (PmlEdmLevelSendDetail model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmLevelSendDetailSoap[soapModels.size()]);
    }

    public PmlEdmLevelSendDetailPK getPrimaryKey() {
        return new PmlEdmLevelSendDetailPK(_levelSendId, _issuingPlaceId);
    }

    public void setPrimaryKey(PmlEdmLevelSendDetailPK pk) {
        setLevelSendId(pk.levelSendId);
        setIssuingPlaceId(pk.issuingPlaceId);
    }

    public int getLevelSendId() {
        return _levelSendId;
    }

    public void setLevelSendId(int levelSendId) {
        _levelSendId = levelSendId;
    }

    public String getIssuingPlaceId() {
        return _issuingPlaceId;
    }

    public void setIssuingPlaceId(String issuingPlaceId) {
        _issuingPlaceId = issuingPlaceId;
    }
}
