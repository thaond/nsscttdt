package com.sgs.portlet.pmllevelsend.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmLevelSendSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pmllevelsend.service.http.PmlEdmLevelSendServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmllevelsend.service.http.PmlEdmLevelSendServiceSoap
 *
 */
public class PmlEdmLevelSendSoap implements Serializable {
    private int _levelSendId;
    private String _levelSendName;
    private String _levelSendCode;

    public PmlEdmLevelSendSoap() {
    }

    public static PmlEdmLevelSendSoap toSoapModel(PmlEdmLevelSend model) {
        PmlEdmLevelSendSoap soapModel = new PmlEdmLevelSendSoap();

        soapModel.setLevelSendId(model.getLevelSendId());
        soapModel.setLevelSendName(model.getLevelSendName());
        soapModel.setLevelSendCode(model.getLevelSendCode());

        return soapModel;
    }

    public static PmlEdmLevelSendSoap[] toSoapModels(
        List<PmlEdmLevelSend> models) {
        List<PmlEdmLevelSendSoap> soapModels = new ArrayList<PmlEdmLevelSendSoap>(models.size());

        for (PmlEdmLevelSend model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmLevelSendSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _levelSendId;
    }

    public void setPrimaryKey(int pk) {
        setLevelSendId(pk);
    }

    public int getLevelSendId() {
        return _levelSendId;
    }

    public void setLevelSendId(int levelSendId) {
        _levelSendId = levelSendId;
    }

    public String getLevelSendName() {
        return _levelSendName;
    }

    public void setLevelSendName(String levelSendName) {
        _levelSendName = levelSendName;
    }

    public String getLevelSendCode() {
        return _levelSendCode;
    }

    public void setLevelSendCode(String levelSendCode) {
        _levelSendCode = levelSendCode;
    }
}
