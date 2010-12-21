package com.nss.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTransitionSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlTransitionServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlTransitionServiceSoap
 *
 */
public class PmlTransitionSoap implements Serializable {
    private long _transitionId;
    private String _transitionName;
    private String _fileTypeId;
    private int _noTransition;
    private long _stateProcessCurrent;
    private long _stateProcessNext;
    private String _version_;

    public PmlTransitionSoap() {
    }

    public static PmlTransitionSoap toSoapModel(PmlTransition model) {
        PmlTransitionSoap soapModel = new PmlTransitionSoap();

        soapModel.setTransitionId(model.getTransitionId());
        soapModel.setTransitionName(model.getTransitionName());
        soapModel.setFileTypeId(model.getFileTypeId());
        soapModel.setNoTransition(model.getNoTransition());
        soapModel.setStateProcessCurrent(model.getStateProcessCurrent());
        soapModel.setStateProcessNext(model.getStateProcessNext());
        soapModel.setVersion_(model.getVersion_());

        return soapModel;
    }

    public static PmlTransitionSoap[] toSoapModels(PmlTransition[] models) {
        PmlTransitionSoap[] soapModels = new PmlTransitionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlTransitionSoap[][] toSoapModels(PmlTransition[][] models) {
        PmlTransitionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlTransitionSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlTransitionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlTransitionSoap[] toSoapModels(List<PmlTransition> models) {
        List<PmlTransitionSoap> soapModels = new ArrayList<PmlTransitionSoap>(models.size());

        for (PmlTransition model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlTransitionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _transitionId;
    }

    public void setPrimaryKey(long pk) {
        setTransitionId(pk);
    }

    public long getTransitionId() {
        return _transitionId;
    }

    public void setTransitionId(long transitionId) {
        _transitionId = transitionId;
    }

    public String getTransitionName() {
        return _transitionName;
    }

    public void setTransitionName(String transitionName) {
        _transitionName = transitionName;
    }

    public String getFileTypeId() {
        return _fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public int getNoTransition() {
        return _noTransition;
    }

    public void setNoTransition(int noTransition) {
        _noTransition = noTransition;
    }

    public long getStateProcessCurrent() {
        return _stateProcessCurrent;
    }

    public void setStateProcessCurrent(long stateProcessCurrent) {
        _stateProcessCurrent = stateProcessCurrent;
    }

    public long getStateProcessNext() {
        return _stateProcessNext;
    }

    public void setStateProcessNext(long stateProcessNext) {
        _stateProcessNext = stateProcessNext;
    }

    public String getVersion_() {
        return _version_;
    }

    public void setVersion_(String version_) {
        _version_ = version_;
    }
}
