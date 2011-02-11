package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptProcessTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptProcessTypeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptProcessTypeServiceSoap
 *
 */
public class PmlEdmDocumentReceiptProcessTypeSoap implements Serializable {
    private long _docReceiptProcessTypeId;
    private long _documentReceiptId;
    private long _documentReceiptLogId;
    private int _processTypeOrderNo;
    private Date _dateEdit;
    private String _processTypeIdBefore;
    private String _processTypeIdAfter;
    private String _processTypeReason;
    private long _processerId;
    private String _departmentId;

    public PmlEdmDocumentReceiptProcessTypeSoap() {
    }

    public static PmlEdmDocumentReceiptProcessTypeSoap toSoapModel(
        PmlEdmDocumentReceiptProcessType model) {
        PmlEdmDocumentReceiptProcessTypeSoap soapModel = new PmlEdmDocumentReceiptProcessTypeSoap();

        soapModel.setDocReceiptProcessTypeId(model.getDocReceiptProcessTypeId());
        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setDocumentReceiptLogId(model.getDocumentReceiptLogId());
        soapModel.setProcessTypeOrderNo(model.getProcessTypeOrderNo());
        soapModel.setDateEdit(model.getDateEdit());
        soapModel.setProcessTypeIdBefore(model.getProcessTypeIdBefore());
        soapModel.setProcessTypeIdAfter(model.getProcessTypeIdAfter());
        soapModel.setProcessTypeReason(model.getProcessTypeReason());
        soapModel.setProcesserId(model.getProcesserId());
        soapModel.setDepartmentId(model.getDepartmentId());

        return soapModel;
    }

    public static PmlEdmDocumentReceiptProcessTypeSoap[] toSoapModels(
        List<PmlEdmDocumentReceiptProcessType> models) {
        List<PmlEdmDocumentReceiptProcessTypeSoap> soapModels = new ArrayList<PmlEdmDocumentReceiptProcessTypeSoap>(models.size());

        for (PmlEdmDocumentReceiptProcessType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocumentReceiptProcessTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _docReceiptProcessTypeId;
    }

    public void setPrimaryKey(long pk) {
        setDocReceiptProcessTypeId(pk);
    }

    public long getDocReceiptProcessTypeId() {
        return _docReceiptProcessTypeId;
    }

    public void setDocReceiptProcessTypeId(long docReceiptProcessTypeId) {
        _docReceiptProcessTypeId = docReceiptProcessTypeId;
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public long getDocumentReceiptLogId() {
        return _documentReceiptLogId;
    }

    public void setDocumentReceiptLogId(long documentReceiptLogId) {
        _documentReceiptLogId = documentReceiptLogId;
    }

    public int getProcessTypeOrderNo() {
        return _processTypeOrderNo;
    }

    public void setProcessTypeOrderNo(int processTypeOrderNo) {
        _processTypeOrderNo = processTypeOrderNo;
    }

    public Date getDateEdit() {
        return _dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        _dateEdit = dateEdit;
    }

    public String getProcessTypeIdBefore() {
        return _processTypeIdBefore;
    }

    public void setProcessTypeIdBefore(String processTypeIdBefore) {
        _processTypeIdBefore = processTypeIdBefore;
    }

    public String getProcessTypeIdAfter() {
        return _processTypeIdAfter;
    }

    public void setProcessTypeIdAfter(String processTypeIdAfter) {
        _processTypeIdAfter = processTypeIdAfter;
    }

    public String getProcessTypeReason() {
        return _processTypeReason;
    }

    public void setProcessTypeReason(String processTypeReason) {
        _processTypeReason = processTypeReason;
    }

    public long getProcesserId() {
        return _processerId;
    }

    public void setProcesserId(long processerId) {
        _processerId = processerId;
    }

    public String getDepartmentId() {
        return _departmentId;
    }

    public void setDepartmentId(String departmentId) {
        _departmentId = departmentId;
    }
}
