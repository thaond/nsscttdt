package com.sgs.portlet.document.manageworkflow.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlManageWorkDocumentFlowSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.manageworkflow.service.http.PmlManageWorkDocumentFlowServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.manageworkflow.service.http.PmlManageWorkDocumentFlowServiceSoap
 *
 */
public class PmlManageWorkDocumentFlowSoap implements Serializable {
    private long _manageDocumentWorkFlowId;
    private String _workFlowName;
    private int _version;
    private int _type;
    private String _description;
    private Date _startDate;
    private Date _endDate;

    public PmlManageWorkDocumentFlowSoap() {
    }

    public static PmlManageWorkDocumentFlowSoap toSoapModel(
        PmlManageWorkDocumentFlow model) {
        PmlManageWorkDocumentFlowSoap soapModel = new PmlManageWorkDocumentFlowSoap();

        soapModel.setManageDocumentWorkFlowId(model.getManageDocumentWorkFlowId());
        soapModel.setWorkFlowName(model.getWorkFlowName());
        soapModel.setVersion(model.getVersion());
        soapModel.setType(model.getType());
        soapModel.setDescription(model.getDescription());
        soapModel.setStartDate(model.getStartDate());
        soapModel.setEndDate(model.getEndDate());

        return soapModel;
    }

    public static PmlManageWorkDocumentFlowSoap[] toSoapModels(
        List<PmlManageWorkDocumentFlow> models) {
        List<PmlManageWorkDocumentFlowSoap> soapModels = new ArrayList<PmlManageWorkDocumentFlowSoap>(models.size());

        for (PmlManageWorkDocumentFlow model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlManageWorkDocumentFlowSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _manageDocumentWorkFlowId;
    }

    public void setPrimaryKey(long pk) {
        setManageDocumentWorkFlowId(pk);
    }

    public long getManageDocumentWorkFlowId() {
        return _manageDocumentWorkFlowId;
    }

    public void setManageDocumentWorkFlowId(long manageDocumentWorkFlowId) {
        _manageDocumentWorkFlowId = manageDocumentWorkFlowId;
    }

    public String getWorkFlowName() {
        return _workFlowName;
    }

    public void setWorkFlowName(String workFlowName) {
        _workFlowName = workFlowName;
    }

    public int getVersion() {
        return _version;
    }

    public void setVersion(int version) {
        _version = version;
    }

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        _type = type;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
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
