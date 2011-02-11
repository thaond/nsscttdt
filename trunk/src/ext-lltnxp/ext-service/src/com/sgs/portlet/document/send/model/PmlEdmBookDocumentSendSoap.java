package com.sgs.portlet.document.send.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmBookDocumentSendSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmBookDocumentSendServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmBookDocumentSendServiceSoap
 *
 */
public class PmlEdmBookDocumentSendSoap implements Serializable {
    private long _bookDocumentSendId;
    private Date _dateCreated;
    private long _currentRecord;
    private String _departmentsId;
    private int _documentRecordTypeId;
    private String _yearInUse;
    private String _active;
    private String _isAgency;
    private String _agencyId;

    public PmlEdmBookDocumentSendSoap() {
    }

    public static PmlEdmBookDocumentSendSoap toSoapModel(
        PmlEdmBookDocumentSend model) {
        PmlEdmBookDocumentSendSoap soapModel = new PmlEdmBookDocumentSendSoap();

        soapModel.setBookDocumentSendId(model.getBookDocumentSendId());
        soapModel.setDateCreated(model.getDateCreated());
        soapModel.setCurrentRecord(model.getCurrentRecord());
        soapModel.setDepartmentsId(model.getDepartmentsId());
        soapModel.setDocumentRecordTypeId(model.getDocumentRecordTypeId());
        soapModel.setYearInUse(model.getYearInUse());
        soapModel.setActive(model.getActive());
        soapModel.setIsAgency(model.getIsAgency());
        soapModel.setAgencyId(model.getAgencyId());

        return soapModel;
    }

    public static PmlEdmBookDocumentSendSoap[] toSoapModels(
        List<PmlEdmBookDocumentSend> models) {
        List<PmlEdmBookDocumentSendSoap> soapModels = new ArrayList<PmlEdmBookDocumentSendSoap>(models.size());

        for (PmlEdmBookDocumentSend model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmBookDocumentSendSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _bookDocumentSendId;
    }

    public void setPrimaryKey(long pk) {
        setBookDocumentSendId(pk);
    }

    public long getBookDocumentSendId() {
        return _bookDocumentSendId;
    }

    public void setBookDocumentSendId(long bookDocumentSendId) {
        _bookDocumentSendId = bookDocumentSendId;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
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
