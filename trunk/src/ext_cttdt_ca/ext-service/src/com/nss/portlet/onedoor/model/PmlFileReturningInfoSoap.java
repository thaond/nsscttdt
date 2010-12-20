package com.nss.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFileReturningInfoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlFileReturningInfoServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlFileReturningInfoServiceSoap
 *
 */
public class PmlFileReturningInfoSoap implements Serializable {
    private long _fileReturningInfoId;
    private String _fileId;
    private String _fileSender;
    private String _licenseNumber;
    private Date _issuingDateLicense;
    private Date _receiveLicenseDate;
    private String _documentNumber;
    private String _billNumber;
    private long _numberMoney;
    private String _note;
    private String _conclude;

    public PmlFileReturningInfoSoap() {
    }

    public static PmlFileReturningInfoSoap toSoapModel(
        PmlFileReturningInfo model) {
        PmlFileReturningInfoSoap soapModel = new PmlFileReturningInfoSoap();

        soapModel.setFileReturningInfoId(model.getFileReturningInfoId());
        soapModel.setFileId(model.getFileId());
        soapModel.setFileSender(model.getFileSender());
        soapModel.setLicenseNumber(model.getLicenseNumber());
        soapModel.setIssuingDateLicense(model.getIssuingDateLicense());
        soapModel.setReceiveLicenseDate(model.getReceiveLicenseDate());
        soapModel.setDocumentNumber(model.getDocumentNumber());
        soapModel.setBillNumber(model.getBillNumber());
        soapModel.setNumberMoney(model.getNumberMoney());
        soapModel.setNote(model.getNote());
        soapModel.setConclude(model.getConclude());

        return soapModel;
    }

    public static PmlFileReturningInfoSoap[] toSoapModels(
        PmlFileReturningInfo[] models) {
        PmlFileReturningInfoSoap[] soapModels = new PmlFileReturningInfoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlFileReturningInfoSoap[][] toSoapModels(
        PmlFileReturningInfo[][] models) {
        PmlFileReturningInfoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlFileReturningInfoSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlFileReturningInfoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlFileReturningInfoSoap[] toSoapModels(
        List<PmlFileReturningInfo> models) {
        List<PmlFileReturningInfoSoap> soapModels = new ArrayList<PmlFileReturningInfoSoap>(models.size());

        for (PmlFileReturningInfo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFileReturningInfoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fileReturningInfoId;
    }

    public void setPrimaryKey(long pk) {
        setFileReturningInfoId(pk);
    }

    public long getFileReturningInfoId() {
        return _fileReturningInfoId;
    }

    public void setFileReturningInfoId(long fileReturningInfoId) {
        _fileReturningInfoId = fileReturningInfoId;
    }

    public String getFileId() {
        return _fileId;
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public String getFileSender() {
        return _fileSender;
    }

    public void setFileSender(String fileSender) {
        _fileSender = fileSender;
    }

    public String getLicenseNumber() {
        return _licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        _licenseNumber = licenseNumber;
    }

    public Date getIssuingDateLicense() {
        return _issuingDateLicense;
    }

    public void setIssuingDateLicense(Date issuingDateLicense) {
        _issuingDateLicense = issuingDateLicense;
    }

    public Date getReceiveLicenseDate() {
        return _receiveLicenseDate;
    }

    public void setReceiveLicenseDate(Date receiveLicenseDate) {
        _receiveLicenseDate = receiveLicenseDate;
    }

    public String getDocumentNumber() {
        return _documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        _documentNumber = documentNumber;
    }

    public String getBillNumber() {
        return _billNumber;
    }

    public void setBillNumber(String billNumber) {
        _billNumber = billNumber;
    }

    public long getNumberMoney() {
        return _numberMoney;
    }

    public void setNumberMoney(long numberMoney) {
        _numberMoney = numberMoney;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    public String getConclude() {
        return _conclude;
    }

    public void setConclude(String conclude) {
        _conclude = conclude;
    }
}
