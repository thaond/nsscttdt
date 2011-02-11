package com.sgs.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlWorkflowSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlWorkflowServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlWorkflowServiceSoap
 *
 */
public class PmlWorkflowSoap implements Serializable {
    private long _workflowId;
    private String _fileTypeId;
    private String _workflow;
    private int _version_;
    private Date _startDate;
    private Date _endDate;

    public PmlWorkflowSoap() {
    }

    public static PmlWorkflowSoap toSoapModel(PmlWorkflow model) {
        PmlWorkflowSoap soapModel = new PmlWorkflowSoap();

        soapModel.setWorkflowId(model.getWorkflowId());
        soapModel.setFileTypeId(model.getFileTypeId());
        soapModel.setWorkflow(model.getWorkflow());
        soapModel.setVersion_(model.getVersion_());
        soapModel.setStartDate(model.getStartDate());
        soapModel.setEndDate(model.getEndDate());

        return soapModel;
    }

    public static PmlWorkflowSoap[] toSoapModels(List<PmlWorkflow> models) {
        List<PmlWorkflowSoap> soapModels = new ArrayList<PmlWorkflowSoap>(models.size());

        for (PmlWorkflow model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlWorkflowSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _workflowId;
    }

    public void setPrimaryKey(long pk) {
        setWorkflowId(pk);
    }

    public long getWorkflowId() {
        return _workflowId;
    }

    public void setWorkflowId(long workflowId) {
        _workflowId = workflowId;
    }

    public String getFileTypeId() {
        return _fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public String getWorkflow() {
        return _workflow;
    }

    public void setWorkflow(String workflow) {
        _workflow = workflow;
    }

    public int getVersion_() {
        return _version_;
    }

    public void setVersion_(int version_) {
        _version_ = version_;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public Date getEndDate() {
        return _endDate;
    }

    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }
}
