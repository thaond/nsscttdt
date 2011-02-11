package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmConfidentialLevelSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmConfidentialLevelServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmConfidentialLevelServiceSoap
 *
 */
public class PmlEdmConfidentialLevelSoap implements Serializable {
    private String _confidentialLevelId;
    private String _confidentialLevelName;
    private boolean _limitViewDetail;
    private boolean _haveProcess;
    private int _confidentialLevelSymbol;

    public PmlEdmConfidentialLevelSoap() {
    }

    public static PmlEdmConfidentialLevelSoap toSoapModel(
        PmlEdmConfidentialLevel model) {
        PmlEdmConfidentialLevelSoap soapModel = new PmlEdmConfidentialLevelSoap();

        soapModel.setConfidentialLevelId(model.getConfidentialLevelId());
        soapModel.setConfidentialLevelName(model.getConfidentialLevelName());
        soapModel.setLimitViewDetail(model.getLimitViewDetail());
        soapModel.setHaveProcess(model.getHaveProcess());
        soapModel.setConfidentialLevelSymbol(model.getConfidentialLevelSymbol());

        return soapModel;
    }

    public static PmlEdmConfidentialLevelSoap[] toSoapModels(
        List<PmlEdmConfidentialLevel> models) {
        List<PmlEdmConfidentialLevelSoap> soapModels = new ArrayList<PmlEdmConfidentialLevelSoap>(models.size());

        for (PmlEdmConfidentialLevel model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmConfidentialLevelSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _confidentialLevelId;
    }

    public void setPrimaryKey(String pk) {
        setConfidentialLevelId(pk);
    }

    public String getConfidentialLevelId() {
        return _confidentialLevelId;
    }

    public void setConfidentialLevelId(String confidentialLevelId) {
        _confidentialLevelId = confidentialLevelId;
    }

    public String getConfidentialLevelName() {
        return _confidentialLevelName;
    }

    public void setConfidentialLevelName(String confidentialLevelName) {
        _confidentialLevelName = confidentialLevelName;
    }

    public boolean getLimitViewDetail() {
        return _limitViewDetail;
    }

    public boolean isLimitViewDetail() {
        return _limitViewDetail;
    }

    public void setLimitViewDetail(boolean limitViewDetail) {
        _limitViewDetail = limitViewDetail;
    }

    public boolean getHaveProcess() {
        return _haveProcess;
    }

    public boolean isHaveProcess() {
        return _haveProcess;
    }

    public void setHaveProcess(boolean haveProcess) {
        _haveProcess = haveProcess;
    }

    public int getConfidentialLevelSymbol() {
        return _confidentialLevelSymbol;
    }

    public void setConfidentialLevelSymbol(int confidentialLevelSymbol) {
        _confidentialLevelSymbol = confidentialLevelSymbol;
    }
}
