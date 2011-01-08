package com.sgs.portlet.onedoorpccc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFilePCCCSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.onedoorpccc.service.http.PmlFilePCCCServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.service.http.PmlFilePCCCServiceSoap
 *
 */
public class PmlFilePCCCSoap implements Serializable {
    private String _fileId;
    private String _fileName;
    private String _applicantRepresentation;
    private String _applicantTelephone;
    private String _receiverRepresentation;
    private String _receiverTelephone;
    private String _projectName;
    private String _applicantCategory;
    private String _addressBuilder;
    private String _investor;
    private String _designCop;
    private int _fileNumber;
    private Date _inputDataDate;
    private String _noteInformationManagement;
    private int _totalHour;
    private int _totalDate;
    private String _conclusion;
    private String _receiveOfUnit;
    private String _applicantTime;

    public PmlFilePCCCSoap() {
    }

    public static PmlFilePCCCSoap toSoapModel(PmlFilePCCC model) {
        PmlFilePCCCSoap soapModel = new PmlFilePCCCSoap();

        soapModel.setFileId(model.getFileId());
        soapModel.setFileName(model.getFileName());
        soapModel.setApplicantRepresentation(model.getApplicantRepresentation());
        soapModel.setApplicantTelephone(model.getApplicantTelephone());
        soapModel.setReceiverRepresentation(model.getReceiverRepresentation());
        soapModel.setReceiverTelephone(model.getReceiverTelephone());
        soapModel.setProjectName(model.getProjectName());
        soapModel.setApplicantCategory(model.getApplicantCategory());
        soapModel.setAddressBuilder(model.getAddressBuilder());
        soapModel.setInvestor(model.getInvestor());
        soapModel.setDesignCop(model.getDesignCop());
        soapModel.setFileNumber(model.getFileNumber());
        soapModel.setInputDataDate(model.getInputDataDate());
        soapModel.setNoteInformationManagement(model.getNoteInformationManagement());
        soapModel.setTotalHour(model.getTotalHour());
        soapModel.setTotalDate(model.getTotalDate());
        soapModel.setConclusion(model.getConclusion());
        soapModel.setReceiveOfUnit(model.getReceiveOfUnit());
        soapModel.setApplicantTime(model.getApplicantTime());

        return soapModel;
    }

    public static PmlFilePCCCSoap[] toSoapModels(List<PmlFilePCCC> models) {
        List<PmlFilePCCCSoap> soapModels = new ArrayList<PmlFilePCCCSoap>(models.size());

        for (PmlFilePCCC model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFilePCCCSoap[soapModels.size()]);
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

    public String getFileName() {
        return _fileName;
    }

    public void setFileName(String fileName) {
        _fileName = fileName;
    }

    public String getApplicantRepresentation() {
        return _applicantRepresentation;
    }

    public void setApplicantRepresentation(String applicantRepresentation) {
        _applicantRepresentation = applicantRepresentation;
    }

    public String getApplicantTelephone() {
        return _applicantTelephone;
    }

    public void setApplicantTelephone(String applicantTelephone) {
        _applicantTelephone = applicantTelephone;
    }

    public String getReceiverRepresentation() {
        return _receiverRepresentation;
    }

    public void setReceiverRepresentation(String receiverRepresentation) {
        _receiverRepresentation = receiverRepresentation;
    }

    public String getReceiverTelephone() {
        return _receiverTelephone;
    }

    public void setReceiverTelephone(String receiverTelephone) {
        _receiverTelephone = receiverTelephone;
    }

    public String getProjectName() {
        return _projectName;
    }

    public void setProjectName(String projectName) {
        _projectName = projectName;
    }

    public String getApplicantCategory() {
        return _applicantCategory;
    }

    public void setApplicantCategory(String applicantCategory) {
        _applicantCategory = applicantCategory;
    }

    public String getAddressBuilder() {
        return _addressBuilder;
    }

    public void setAddressBuilder(String addressBuilder) {
        _addressBuilder = addressBuilder;
    }

    public String getInvestor() {
        return _investor;
    }

    public void setInvestor(String investor) {
        _investor = investor;
    }

    public String getDesignCop() {
        return _designCop;
    }

    public void setDesignCop(String designCop) {
        _designCop = designCop;
    }

    public int getFileNumber() {
        return _fileNumber;
    }

    public void setFileNumber(int fileNumber) {
        _fileNumber = fileNumber;
    }

    public Date getInputDataDate() {
        return _inputDataDate;
    }

    public void setInputDataDate(Date inputDataDate) {
        _inputDataDate = inputDataDate;
    }

    public String getNoteInformationManagement() {
        return _noteInformationManagement;
    }

    public void setNoteInformationManagement(String noteInformationManagement) {
        _noteInformationManagement = noteInformationManagement;
    }

    public int getTotalHour() {
        return _totalHour;
    }

    public void setTotalHour(int totalHour) {
        _totalHour = totalHour;
    }

    public int getTotalDate() {
        return _totalDate;
    }

    public void setTotalDate(int totalDate) {
        _totalDate = totalDate;
    }

    public String getConclusion() {
        return _conclusion;
    }

    public void setConclusion(String conclusion) {
        _conclusion = conclusion;
    }

    public String getReceiveOfUnit() {
        return _receiveOfUnit;
    }

    public void setReceiveOfUnit(String receiveOfUnit) {
        _receiveOfUnit = receiveOfUnit;
    }

    public String getApplicantTime() {
        return _applicantTime;
    }

    public void setApplicantTime(String applicantTime) {
        _applicantTime = applicantTime;
    }
}
