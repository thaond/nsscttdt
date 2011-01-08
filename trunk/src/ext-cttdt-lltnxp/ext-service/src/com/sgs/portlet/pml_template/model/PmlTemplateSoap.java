package com.sgs.portlet.pml_template.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlTemplateSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pml_template.service.http.PmlTemplateServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.service.http.PmlTemplateServiceSoap
 *
 */
public class PmlTemplateSoap implements Serializable {
    private long _templateId;
    private String _templateCode;
    private String _templateName;
    private int _numberOfDocument;
    private Date _publishDate;
    private String _departmentId;

    public PmlTemplateSoap() {
    }

    public static PmlTemplateSoap toSoapModel(PmlTemplate model) {
        PmlTemplateSoap soapModel = new PmlTemplateSoap();

        soapModel.setTemplateId(model.getTemplateId());
        soapModel.setTemplateCode(model.getTemplateCode());
        soapModel.setTemplateName(model.getTemplateName());
        soapModel.setNumberOfDocument(model.getNumberOfDocument());
        soapModel.setPublishDate(model.getPublishDate());
        soapModel.setDepartmentId(model.getDepartmentId());

        return soapModel;
    }

    public static PmlTemplateSoap[] toSoapModels(List<PmlTemplate> models) {
        List<PmlTemplateSoap> soapModels = new ArrayList<PmlTemplateSoap>(models.size());

        for (PmlTemplate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlTemplateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _templateId;
    }

    public void setPrimaryKey(long pk) {
        setTemplateId(pk);
    }

    public long getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(long templateId) {
        _templateId = templateId;
    }

    public String getTemplateCode() {
        return _templateCode;
    }

    public void setTemplateCode(String templateCode) {
        _templateCode = templateCode;
    }

    public String getTemplateName() {
        return _templateName;
    }

    public void setTemplateName(String templateName) {
        _templateName = templateName;
    }

    public int getNumberOfDocument() {
        return _numberOfDocument;
    }

    public void setNumberOfDocument(int numberOfDocument) {
        _numberOfDocument = numberOfDocument;
    }

    public Date getPublishDate() {
        return _publishDate;
    }

    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;
    }

    public String getDepartmentId() {
        return _departmentId;
    }

    public void setDepartmentId(String departmentId) {
        _departmentId = departmentId;
    }
}
