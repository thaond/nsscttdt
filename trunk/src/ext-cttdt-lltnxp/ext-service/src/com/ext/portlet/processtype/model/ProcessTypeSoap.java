package com.ext.portlet.processtype.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="ProcessTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.processtype.service.http.ProcessTypeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.processtype.service.http.ProcessTypeServiceSoap
 *
 */
public class ProcessTypeSoap implements Serializable {
    private long _processTypeId;
    private String _name;
    private int _flagProcessType;

    public ProcessTypeSoap() {
    }

    public static ProcessTypeSoap toSoapModel(ProcessType model) {
        ProcessTypeSoap soapModel = new ProcessTypeSoap();

        soapModel.setProcessTypeId(model.getProcessTypeId());
        soapModel.setName(model.getName());
        soapModel.setFlagProcessType(model.getFlagProcessType());

        return soapModel;
    }

    public static ProcessTypeSoap[] toSoapModels(List<ProcessType> models) {
        List<ProcessTypeSoap> soapModels = new ArrayList<ProcessTypeSoap>(models.size());

        for (ProcessType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ProcessTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _processTypeId;
    }

    public void setPrimaryKey(long pk) {
        setProcessTypeId(pk);
    }

    public long getProcessTypeId() {
        return _processTypeId;
    }

    public void setProcessTypeId(long processTypeId) {
        _processTypeId = processTypeId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getFlagProcessType() {
        return _flagProcessType;
    }

    public void setFlagProcessType(int flagProcessType) {
        _flagProcessType = flagProcessType;
    }
}
