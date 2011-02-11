package com.sgs.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlOneDoorReceiveFileSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoor.service.http.PmlOneDoorReceiveFileServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.http.PmlOneDoorReceiveFileServiceSoap
 *
 */
public class PmlOneDoorReceiveFileSoap implements Serializable {
    private String _fileId;
    private String _cityId;
    private String _districtId;
    private String _wardsId;
    private String _streetId;
    private Date _exactReturningDate;
    private long _receiverId;
    private Date _validDate;
    private Date _expectedReturningDate;
    private Date _applicationDate;
    private String _otherContent;
    private String _briefContent;
    private String _applicantName;
    private String _organization;
    private String _authorisedLetter;
    private String _idNumber;
    private Date _issuingDate;
    private String _issuingPlace;
    private String _telephone;
    private String _gender;
    private String _streetNumber;
    private String _permanentAddress;
    private String _contactInfomation;
    private String _oldNumberReceipt;
    private String _numberReceipt;
    private String _fileTypeId;
    private String _fieldId;
    private int _solvingTime;
    private String _amendedContent;
    private Date _landCheckingDate;
    private String _decisionNotice;
    private String _receiver;
    private Date _dateCreated;
    private Date _lastUpdate;
    private String _lastTestProcessInfo;
    private String _active;
    private long _generalorderno;

    public PmlOneDoorReceiveFileSoap() {
    }

    public static PmlOneDoorReceiveFileSoap toSoapModel(
        PmlOneDoorReceiveFile model) {
        PmlOneDoorReceiveFileSoap soapModel = new PmlOneDoorReceiveFileSoap();

        soapModel.setFileId(model.getFileId());
        soapModel.setCityId(model.getCityId());
        soapModel.setDistrictId(model.getDistrictId());
        soapModel.setWardsId(model.getWardsId());
        soapModel.setStreetId(model.getStreetId());
        soapModel.setExactReturningDate(model.getExactReturningDate());
        soapModel.setReceiverId(model.getReceiverId());
        soapModel.setValidDate(model.getValidDate());
        soapModel.setExpectedReturningDate(model.getExpectedReturningDate());
        soapModel.setApplicationDate(model.getApplicationDate());
        soapModel.setOtherContent(model.getOtherContent());
        soapModel.setBriefContent(model.getBriefContent());
        soapModel.setApplicantName(model.getApplicantName());
        soapModel.setOrganization(model.getOrganization());
        soapModel.setAuthorisedLetter(model.getAuthorisedLetter());
        soapModel.setIdNumber(model.getIdNumber());
        soapModel.setIssuingDate(model.getIssuingDate());
        soapModel.setIssuingPlace(model.getIssuingPlace());
        soapModel.setTelephone(model.getTelephone());
        soapModel.setGender(model.getGender());
        soapModel.setStreetNumber(model.getStreetNumber());
        soapModel.setPermanentAddress(model.getPermanentAddress());
        soapModel.setContactInfomation(model.getContactInfomation());
        soapModel.setOldNumberReceipt(model.getOldNumberReceipt());
        soapModel.setNumberReceipt(model.getNumberReceipt());
        soapModel.setFileTypeId(model.getFileTypeId());
        soapModel.setFieldId(model.getFieldId());
        soapModel.setSolvingTime(model.getSolvingTime());
        soapModel.setAmendedContent(model.getAmendedContent());
        soapModel.setLandCheckingDate(model.getLandCheckingDate());
        soapModel.setDecisionNotice(model.getDecisionNotice());
        soapModel.setReceiver(model.getReceiver());
        soapModel.setDateCreated(model.getDateCreated());
        soapModel.setLastUpdate(model.getLastUpdate());
        soapModel.setLastTestProcessInfo(model.getLastTestProcessInfo());
        soapModel.setActive(model.getActive());
        soapModel.setGeneralorderno(model.getGeneralorderno());

        return soapModel;
    }

    public static PmlOneDoorReceiveFileSoap[] toSoapModels(
        List<PmlOneDoorReceiveFile> models) {
        List<PmlOneDoorReceiveFileSoap> soapModels = new ArrayList<PmlOneDoorReceiveFileSoap>(models.size());

        for (PmlOneDoorReceiveFile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlOneDoorReceiveFileSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _fileId;
    }

    public void setPrimaryKey(String pk) {
        setFileId(pk);
    }

    public String getFileId() {
        return _fileId;
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public String getCityId() {
        return _cityId;
    }

    public void setCityId(String cityId) {
        _cityId = cityId;
    }

    public String getDistrictId() {
        return _districtId;
    }

    public void setDistrictId(String districtId) {
        _districtId = districtId;
    }

    public String getWardsId() {
        return _wardsId;
    }

    public void setWardsId(String wardsId) {
        _wardsId = wardsId;
    }

    public String getStreetId() {
        return _streetId;
    }

    public void setStreetId(String streetId) {
        _streetId = streetId;
    }

    public Date getExactReturningDate() {
        return _exactReturningDate;
    }

    public void setExactReturningDate(Date exactReturningDate) {
        _exactReturningDate = exactReturningDate;
    }

    public long getReceiverId() {
        return _receiverId;
    }

    public void setReceiverId(long receiverId) {
        _receiverId = receiverId;
    }

    public Date getValidDate() {
        return _validDate;
    }

    public void setValidDate(Date validDate) {
        _validDate = validDate;
    }

    public Date getExpectedReturningDate() {
        return _expectedReturningDate;
    }

    public void setExpectedReturningDate(Date expectedReturningDate) {
        _expectedReturningDate = expectedReturningDate;
    }

    public Date getApplicationDate() {
        return _applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        _applicationDate = applicationDate;
    }

    public String getOtherContent() {
        return _otherContent;
    }

    public void setOtherContent(String otherContent) {
        _otherContent = otherContent;
    }

    public String getBriefContent() {
        return _briefContent;
    }

    public void setBriefContent(String briefContent) {
        _briefContent = briefContent;
    }

    public String getApplicantName() {
        return _applicantName;
    }

    public void setApplicantName(String applicantName) {
        _applicantName = applicantName;
    }

    public String getOrganization() {
        return _organization;
    }

    public void setOrganization(String organization) {
        _organization = organization;
    }

    public String getAuthorisedLetter() {
        return _authorisedLetter;
    }

    public void setAuthorisedLetter(String authorisedLetter) {
        _authorisedLetter = authorisedLetter;
    }

    public String getIdNumber() {
        return _idNumber;
    }

    public void setIdNumber(String idNumber) {
        _idNumber = idNumber;
    }

    public Date getIssuingDate() {
        return _issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        _issuingDate = issuingDate;
    }

    public String getIssuingPlace() {
        return _issuingPlace;
    }

    public void setIssuingPlace(String issuingPlace) {
        _issuingPlace = issuingPlace;
    }

    public String getTelephone() {
        return _telephone;
    }

    public void setTelephone(String telephone) {
        _telephone = telephone;
    }

    public String getGender() {
        return _gender;
    }

    public void setGender(String gender) {
        _gender = gender;
    }

    public String getStreetNumber() {
        return _streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        _streetNumber = streetNumber;
    }

    public String getPermanentAddress() {
        return _permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        _permanentAddress = permanentAddress;
    }

    public String getContactInfomation() {
        return _contactInfomation;
    }

    public void setContactInfomation(String contactInfomation) {
        _contactInfomation = contactInfomation;
    }

    public String getOldNumberReceipt() {
        return _oldNumberReceipt;
    }

    public void setOldNumberReceipt(String oldNumberReceipt) {
        _oldNumberReceipt = oldNumberReceipt;
    }

    public String getNumberReceipt() {
        return _numberReceipt;
    }

    public void setNumberReceipt(String numberReceipt) {
        _numberReceipt = numberReceipt;
    }

    public String getFileTypeId() {
        return _fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public String getFieldId() {
        return _fieldId;
    }

    public void setFieldId(String fieldId) {
        _fieldId = fieldId;
    }

    public int getSolvingTime() {
        return _solvingTime;
    }

    public void setSolvingTime(int solvingTime) {
        _solvingTime = solvingTime;
    }

    public String getAmendedContent() {
        return _amendedContent;
    }

    public void setAmendedContent(String amendedContent) {
        _amendedContent = amendedContent;
    }

    public Date getLandCheckingDate() {
        return _landCheckingDate;
    }

    public void setLandCheckingDate(Date landCheckingDate) {
        _landCheckingDate = landCheckingDate;
    }

    public String getDecisionNotice() {
        return _decisionNotice;
    }

    public void setDecisionNotice(String decisionNotice) {
        _decisionNotice = decisionNotice;
    }

    public String getReceiver() {
        return _receiver;
    }

    public void setReceiver(String receiver) {
        _receiver = receiver;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
    }

    public Date getLastUpdate() {
        return _lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        _lastUpdate = lastUpdate;
    }

    public String getLastTestProcessInfo() {
        return _lastTestProcessInfo;
    }

    public void setLastTestProcessInfo(String lastTestProcessInfo) {
        _lastTestProcessInfo = lastTestProcessInfo;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }

    public long getGeneralorderno() {
        return _generalorderno;
    }

    public void setGeneralorderno(long generalorderno) {
        _generalorderno = generalorderno;
    }
}
