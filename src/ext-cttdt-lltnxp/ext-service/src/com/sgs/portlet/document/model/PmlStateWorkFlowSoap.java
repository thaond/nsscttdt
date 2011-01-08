package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlStateWorkFlowSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlStateWorkFlowServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlStateWorkFlowServiceSoap
 *
 */
public class PmlStateWorkFlowSoap implements Serializable {
    private long _stateWfId;
    private String _workflow;
    private long _stateProcessId;
    private int _solvingTime;
    private int _version_;

    public PmlStateWorkFlowSoap() {
    }

    public static PmlStateWorkFlowSoap toSoapModel(PmlStateWorkFlow model) {
        PmlStateWorkFlowSoap soapModel = new PmlStateWorkFlowSoap();

        soapModel.setStateWfId(model.getStateWfId());
        soapModel.setWorkflow(model.getWorkflow());
        soapModel.setStateProcessId(model.getStateProcessId());
        soapModel.setSolvingTime(model.getSolvingTime());
        soapModel.setVersion_(model.getVersion_());

        return soapModel;
    }

    public static PmlStateWorkFlowSoap[] toSoapModels(
        List<PmlStateWorkFlow> models) {
        List<PmlStateWorkFlowSoap> soapModels = new ArrayList<PmlStateWorkFlowSoap>(models.size());

        for (PmlStateWorkFlow model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlStateWorkFlowSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _stateWfId;
    }

    public void setPrimaryKey(long pk) {
        setStateWfId(pk);
    }

    public long getStateWfId() {
        return _stateWfId;
    }

    public void setStateWfId(long stateWfId) {
        _stateWfId = stateWfId;
    }

    public String getWorkflow() {
        return _workflow;
    }

    public void setWorkflow(String workflow) {
        _workflow = workflow;
    }

    public long getStateProcessId() {
        return _stateProcessId;
    }

    public void setStateProcessId(long stateProcessId) {
        _stateProcessId = stateProcessId;
    }

    public int getSolvingTime() {
        return _solvingTime;
    }

    public void setSolvingTime(int solvingTime) {
        _solvingTime = solvingTime;
    }

    public int getVersion_() {
        return _version_;
    }

    public void setVersion_(int version_) {
        _version_ = version_;
    }
}
