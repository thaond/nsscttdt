package com.sgs.portlet.filetype.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.filetype.service.http.PmlFileTypeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.filetype.service.http.PmlFileTypeServiceSoap
 *
 */
public class PmlFileTypeSoap implements Serializable {
    private String _fileTypeId;
    private String _fileTypeCode;
    private String _fileTypeName;
    private String _fieldId;
    private String _templateId;
    private String _processTime;
    private String _description;
    private String _active;
    private String _currentReceiptNumber;
    private String _receiptTemplate;

    public PmlFileTypeSoap() {
    }

    public static PmlFileTypeSoap toSoapModel(PmlFileType model) {
        PmlFileTypeSoap soapModel = new PmlFileTypeSoap();

        soapModel.setFileTypeId(model.getFileTypeId());
        soapModel.setFileTypeCode(model.getFileTypeCode());
        soapModel.setFileTypeName(model.getFileTypeName());
        soapModel.setFieldId(model.getFieldId());
        soapModel.setTemplateId(model.getTemplateId());
        soapModel.setProcessTime(model.getProcessTime());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());
        soapModel.setCurrentReceiptNumber(model.getCurrentReceiptNumber());
        soapModel.setReceiptTemplate(model.getReceiptTemplate());

        return soapModel;
    }

    public static PmlFileTypeSoap[] toSoapModels(List<PmlFileType> models) {
        List<PmlFileTypeSoap> soapModels = new ArrayList<PmlFileTypeSoap>(models.size());

        for (PmlFileType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFileTypeSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _fileTypeId;
    }

    public void setPrimaryKey(String pk) {
        setFileTypeId(pk);
    }

    public String getFileTypeId() {
        return _fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public String getFileTypeCode() {
        return _fileTypeCode;
    }

    public void setFileTypeCode(String fileTypeCode) {
        _fileTypeCode = fileTypeCode;
    }

    public String getFileTypeName() {
        return _fileTypeName;
    }

    public void setFileTypeName(String fileTypeName) {
        _fileTypeName = fileTypeName;
    }

    public String getFieldId() {
        return _fieldId;
    }

    public void setFieldId(String fieldId) {
        _fieldId = fieldId;
    }

    public String getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(String templateId) {
        _templateId = templateId;
    }

    public String getProcessTime() {
        return _processTime;
    }

    public void setProcessTime(String processTime) {
        _processTime = processTime;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }

    public String getCurrentReceiptNumber() {
        return _currentReceiptNumber;
    }

    public void setCurrentReceiptNumber(String currentReceiptNumber) {
        _currentReceiptNumber = currentReceiptNumber;
    }

    public String getReceiptTemplate() {
        return _receiptTemplate;
    }

    public void setReceiptTemplate(String receiptTemplate) {
        _receiptTemplate = receiptTemplate;
    }
}
