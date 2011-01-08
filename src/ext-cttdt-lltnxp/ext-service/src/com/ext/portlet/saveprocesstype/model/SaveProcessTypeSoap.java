package com.ext.portlet.saveprocesstype.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="SaveProcessTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.saveprocesstype.service.http.SaveProcessTypeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.saveprocesstype.service.http.SaveProcessTypeServiceSoap
 *
 */
public class SaveProcessTypeSoap implements Serializable {
    private long _sptId;
    private long _docId;
    private long _flagProcessType;
    private boolean _flag;

    public SaveProcessTypeSoap() {
    }

    public static SaveProcessTypeSoap toSoapModel(SaveProcessType model) {
        SaveProcessTypeSoap soapModel = new SaveProcessTypeSoap();

        soapModel.setSptId(model.getSptId());
        soapModel.setDocId(model.getDocId());
        soapModel.setFlagProcessType(model.getFlagProcessType());
        soapModel.setFlag(model.getFlag());

        return soapModel;
    }

    public static SaveProcessTypeSoap[] toSoapModels(
        List<SaveProcessType> models) {
        List<SaveProcessTypeSoap> soapModels = new ArrayList<SaveProcessTypeSoap>(models.size());

        for (SaveProcessType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SaveProcessTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _sptId;
    }

    public void setPrimaryKey(long pk) {
        setSptId(pk);
    }

    public long getSptId() {
        return _sptId;
    }

    public void setSptId(long sptId) {
        _sptId = sptId;
    }

    public long getDocId() {
        return _docId;
    }

    public void setDocId(long docId) {
        _docId = docId;
    }

    public long getFlagProcessType() {
        return _flagProcessType;
    }

    public void setFlagProcessType(long flagProcessType) {
        _flagProcessType = flagProcessType;
    }

    public boolean getFlag() {
        return _flag;
    }

    public boolean isFlag() {
        return _flag;
    }

    public void setFlag(boolean flag) {
        _flag = flag;
    }
}
