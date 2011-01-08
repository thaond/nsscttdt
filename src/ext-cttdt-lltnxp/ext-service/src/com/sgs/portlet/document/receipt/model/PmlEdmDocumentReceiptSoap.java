package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptServiceSoap
 *
 */
public class PmlEdmDocumentReceiptSoap implements Serializable {
    private long _documentReceiptId;
    private int _levelSendId;
    private long _documentTypeId;
    private String _documentReference;
    private String _issuingPlaceId;
    private Date _issuingDate;
    private Date _dateArrive;
    private String _signer;
    private String _privilegeLevelId;
    private String _confidentialLevelId;
    private String _opinion;
    private String _briefContent;
    private String _isPublic;
    private String _numberDocumentReceipt;
    private int _processTime;
    private String _status;
    private String _active;
    private String _numberLocalDocumentReceipt;
    private String _issuingPlaceOtherName;
    private String _documentType;
    private Date _dateButPhe;
    private Date _dateHoanThanh;
    private long _statusId;
    private String _thoigiannhancvden;
    private String _socongvandiphucdap;
    private long _generalOrderNo;
    private String _mainDepartmentProcessId;
    private long _mainUserProcessId;
    private long _orgExternalId;
    private long _docReceiptTempId;
    private String _donViSaoY;

    public PmlEdmDocumentReceiptSoap() {
    }

    public static PmlEdmDocumentReceiptSoap toSoapModel(
        PmlEdmDocumentReceipt model) {
        PmlEdmDocumentReceiptSoap soapModel = new PmlEdmDocumentReceiptSoap();

        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setLevelSendId(model.getLevelSendId());
        soapModel.setDocumentTypeId(model.getDocumentTypeId());
        soapModel.setDocumentReference(model.getDocumentReference());
        soapModel.setIssuingPlaceId(model.getIssuingPlaceId());
        soapModel.setIssuingDate(model.getIssuingDate());
        soapModel.setDateArrive(model.getDateArrive());
        soapModel.setSigner(model.getSigner());
        soapModel.setPrivilegeLevelId(model.getPrivilegeLevelId());
        soapModel.setConfidentialLevelId(model.getConfidentialLevelId());
        soapModel.setOpinion(model.getOpinion());
        soapModel.setBriefContent(model.getBriefContent());
        soapModel.setIsPublic(model.getIsPublic());
        soapModel.setNumberDocumentReceipt(model.getNumberDocumentReceipt());
        soapModel.setProcessTime(model.getProcessTime());
        soapModel.setStatus(model.getStatus());
        soapModel.setActive(model.getActive());
        soapModel.setNumberLocalDocumentReceipt(model.getNumberLocalDocumentReceipt());
        soapModel.setIssuingPlaceOtherName(model.getIssuingPlaceOtherName());
        soapModel.setDocumentType(model.getDocumentType());
        soapModel.setDateButPhe(model.getDateButPhe());
        soapModel.setDateHoanThanh(model.getDateHoanThanh());
        soapModel.setStatusId(model.getStatusId());
        soapModel.setThoigiannhancvden(model.getThoigiannhancvden());
        soapModel.setSocongvandiphucdap(model.getSocongvandiphucdap());
        soapModel.setGeneralOrderNo(model.getGeneralOrderNo());
        soapModel.setMainDepartmentProcessId(model.getMainDepartmentProcessId());
        soapModel.setMainUserProcessId(model.getMainUserProcessId());
        soapModel.setOrgExternalId(model.getOrgExternalId());
        soapModel.setDocReceiptTempId(model.getDocReceiptTempId());
        soapModel.setDonViSaoY(model.getDonViSaoY());

        return soapModel;
    }

    public static PmlEdmDocumentReceiptSoap[] toSoapModels(
        List<PmlEdmDocumentReceipt> models) {
        List<PmlEdmDocumentReceiptSoap> soapModels = new ArrayList<PmlEdmDocumentReceiptSoap>(models.size());

        for (PmlEdmDocumentReceipt model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocumentReceiptSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentReceiptId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentReceiptId(pk);
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public int getLevelSendId() {
        return _levelSendId;
    }

    public void setLevelSendId(int levelSendId) {
        _levelSendId = levelSendId;
    }

    public long getDocumentTypeId() {
        return _documentTypeId;
    }

    public void setDocumentTypeId(long documentTypeId) {
        _documentTypeId = documentTypeId;
    }

    public String getDocumentReference() {
        return _documentReference;
    }

    public void setDocumentReference(String documentReference) {
        _documentReference = documentReference;
    }

    public String getIssuingPlaceId() {
        return _issuingPlaceId;
    }

    public void setIssuingPlaceId(String issuingPlaceId) {
        _issuingPlaceId = issuingPlaceId;
    }

    public Date getIssuingDate() {
        return _issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        _issuingDate = issuingDate;
    }

    public Date getDateArrive() {
        return _dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        _dateArrive = dateArrive;
    }

    public String getSigner() {
        return _signer;
    }

    public void setSigner(String signer) {
        _signer = signer;
    }

    public String getPrivilegeLevelId() {
        return _privilegeLevelId;
    }

    public void setPrivilegeLevelId(String privilegeLevelId) {
        _privilegeLevelId = privilegeLevelId;
    }

    public String getConfidentialLevelId() {
        return _confidentialLevelId;
    }

    public void setConfidentialLevelId(String confidentialLevelId) {
        _confidentialLevelId = confidentialLevelId;
    }

    public String getOpinion() {
        return _opinion;
    }

    public void setOpinion(String opinion) {
        _opinion = opinion;
    }

    public String getBriefContent() {
        return _briefContent;
    }

    public void setBriefContent(String briefContent) {
        _briefContent = briefContent;
    }

    public String getIsPublic() {
        return _isPublic;
    }

    public void setIsPublic(String isPublic) {
        _isPublic = isPublic;
    }

    public String getNumberDocumentReceipt() {
        return _numberDocumentReceipt;
    }

    public void setNumberDocumentReceipt(String numberDocumentReceipt) {
        _numberDocumentReceipt = numberDocumentReceipt;
    }

    public int getProcessTime() {
        return _processTime;
    }

    public void setProcessTime(int processTime) {
        _processTime = processTime;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }

    public String getNumberLocalDocumentReceipt() {
        return _numberLocalDocumentReceipt;
    }

    public void setNumberLocalDocumentReceipt(String numberLocalDocumentReceipt) {
        _numberLocalDocumentReceipt = numberLocalDocumentReceipt;
    }

    public String getIssuingPlaceOtherName() {
        return _issuingPlaceOtherName;
    }

    public void setIssuingPlaceOtherName(String issuingPlaceOtherName) {
        _issuingPlaceOtherName = issuingPlaceOtherName;
    }

    public String getDocumentType() {
        return _documentType;
    }

    public void setDocumentType(String documentType) {
        _documentType = documentType;
    }

    public Date getDateButPhe() {
        return _dateButPhe;
    }

    public void setDateButPhe(Date dateButPhe) {
        _dateButPhe = dateButPhe;
    }

    public Date getDateHoanThanh() {
        return _dateHoanThanh;
    }

    public void setDateHoanThanh(Date dateHoanThanh) {
        _dateHoanThanh = dateHoanThanh;
    }

    public long getStatusId() {
        return _statusId;
    }

    public void setStatusId(long statusId) {
        _statusId = statusId;
    }

    public String getThoigiannhancvden() {
        return _thoigiannhancvden;
    }

    public void setThoigiannhancvden(String thoigiannhancvden) {
        _thoigiannhancvden = thoigiannhancvden;
    }

    public String getSocongvandiphucdap() {
        return _socongvandiphucdap;
    }

    public void setSocongvandiphucdap(String socongvandiphucdap) {
        _socongvandiphucdap = socongvandiphucdap;
    }

    public long getGeneralOrderNo() {
        return _generalOrderNo;
    }

    public void setGeneralOrderNo(long generalOrderNo) {
        _generalOrderNo = generalOrderNo;
    }

    public String getMainDepartmentProcessId() {
        return _mainDepartmentProcessId;
    }

    public void setMainDepartmentProcessId(String mainDepartmentProcessId) {
        _mainDepartmentProcessId = mainDepartmentProcessId;
    }

    public long getMainUserProcessId() {
        return _mainUserProcessId;
    }

    public void setMainUserProcessId(long mainUserProcessId) {
        _mainUserProcessId = mainUserProcessId;
    }

    public long getOrgExternalId() {
        return _orgExternalId;
    }

    public void setOrgExternalId(long orgExternalId) {
        _orgExternalId = orgExternalId;
    }

    public long getDocReceiptTempId() {
        return _docReceiptTempId;
    }

    public void setDocReceiptTempId(long docReceiptTempId) {
        _docReceiptTempId = docReceiptTempId;
    }

    public String getDonViSaoY() {
        return _donViSaoY;
    }

    public void setDonViSaoY(String donViSaoY) {
        _donViSaoY = donViSaoY;
    }
}
