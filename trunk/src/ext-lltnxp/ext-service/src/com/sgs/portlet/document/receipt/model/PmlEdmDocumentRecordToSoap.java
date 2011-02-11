package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentRecordToSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentRecordToServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentRecordToServiceSoap
 *
 */
public class PmlEdmDocumentRecordToSoap implements Serializable {
    private long _documentRecordToId;
    private Date _dateCreate;
    private long _currentRecord;
    private String _departmentsId;
    private int _documentRecordTypeId;
    private String _yearInUse;
    private String _active;
    private String _isAgency;
    private String _agencyId;

    public PmlEdmDocumentRecordToSoap() {
    }

    public static PmlEdmDocumentRecordToSoap toSoapModel(
        PmlEdmDocumentRecordTo model) {
        PmlEdmDocumentRecordToSoap soapModel = new PmlEdmDocumentRecordToSoap();

        soapModel.setDocumentRecordToId(model.getDocumentRecordToId());
        soapModel.setDateCreate(model.getDateCreate());
        soapModel.setCurrentRecord(model.getCurrentRecord());
        soapModel.setDepartmentsId(model.getDepartmentsId());
        soapModel.setDocumentRecordTypeId(model.getDocumentRecordTypeId());
        soapModel.setYearInUse(model.getYearInUse());
        soapModel.setActive(model.getActive());
        soapModel.setIsAgency(model.getIsAgency());
        soapModel.setAgencyId(model.getAgencyId());

        return soapModel;
    }

    public static PmlEdmDocumentRecordToSoap[] toSoapModels(
        List<PmlEdmDocumentRecordTo> models) {
        List<PmlEdmDocumentRecordToSoap> soapModels = new ArrayList<PmlEdmDocumentRecordToSoap>(models.size());

        for (PmlEdmDocumentRecordTo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocumentRecordToSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentRecordToId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentRecordToId(pk);
    }

    public long getDocumentRecordToId() {
        return _documentRecordToId;
    }

    public void setDocumentRecordToId(long documentRecordToId) {
        _documentRecordToId = documentRecordToId;
    }

    public Date getDateCreate() {
        return _dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        _dateCreate = dateCreate;
    }

    public long getCurrentRecord() {
        return _currentRecord;
    }

    public void setCurrentRecord(long currentRecord) {
        _currentRecord = currentRecord;
    }

    public String getDepartmentsId() {
        return _departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public int getDocumentRecordTypeId() {
        return _documentRecordTypeId;
    }

    public void setDocumentRecordTypeId(int documentRecordTypeId) {
        _documentRecordTypeId = documentRecordTypeId;
    }

    public String getYearInUse() {
        return _yearInUse;
    }

    public void setYearInUse(String yearInUse) {
        _yearInUse = yearInUse;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }

    public String getIsAgency() {
        return _isAgency;
    }

    public void setIsAgency(String isAgency) {
        _isAgency = isAgency;
    }

    public String getAgencyId() {
        return _agencyId;
    }

    public void setAgencyId(String agencyId) {
        _agencyId = agencyId;
    }
}
