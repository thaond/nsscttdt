package com.sgs.portlet.document_manager.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="DocumentManagerSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document_manager.service.http.DocumentManagerServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.service.http.DocumentManagerServiceSoap
 *
 */
public class DocumentManagerSoap implements Serializable {
    private long _documentManagerId;
    private String _documentManagerCode;
    private String _documentManagerCategory;
    private String _documentManagerStyle;
    private String _documentManagerDescription;
    private Date _documentManagerDateCreate;
    private String _documentManagerTitle;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public DocumentManagerSoap() {
    }

    public static DocumentManagerSoap toSoapModel(DocumentManager model) {
        DocumentManagerSoap soapModel = new DocumentManagerSoap();

        soapModel.setDocumentManagerId(model.getDocumentManagerId());
        soapModel.setDocumentManagerCode(model.getDocumentManagerCode());
        soapModel.setDocumentManagerCategory(model.getDocumentManagerCategory());
        soapModel.setDocumentManagerStyle(model.getDocumentManagerStyle());
        soapModel.setDocumentManagerDescription(model.getDocumentManagerDescription());
        soapModel.setDocumentManagerDateCreate(model.getDocumentManagerDateCreate());
        soapModel.setDocumentManagerTitle(model.getDocumentManagerTitle());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static DocumentManagerSoap[] toSoapModels(
        List<DocumentManager> models) {
        List<DocumentManagerSoap> soapModels = new ArrayList<DocumentManagerSoap>(models.size());

        for (DocumentManager model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DocumentManagerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentManagerId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentManagerId(pk);
    }

    public long getDocumentManagerId() {
        return _documentManagerId;
    }

    public void setDocumentManagerId(long documentManagerId) {
        _documentManagerId = documentManagerId;
    }

    public String getDocumentManagerCode() {
        return _documentManagerCode;
    }

    public void setDocumentManagerCode(String documentManagerCode) {
        _documentManagerCode = documentManagerCode;
    }

    public String getDocumentManagerCategory() {
        return _documentManagerCategory;
    }

    public void setDocumentManagerCategory(String documentManagerCategory) {
        _documentManagerCategory = documentManagerCategory;
    }

    public String getDocumentManagerStyle() {
        return _documentManagerStyle;
    }

    public void setDocumentManagerStyle(String documentManagerStyle) {
        _documentManagerStyle = documentManagerStyle;
    }

    public String getDocumentManagerDescription() {
        return _documentManagerDescription;
    }

    public void setDocumentManagerDescription(String documentManagerDescription) {
        _documentManagerDescription = documentManagerDescription;
    }

    public Date getDocumentManagerDateCreate() {
        return _documentManagerDateCreate;
    }

    public void setDocumentManagerDateCreate(Date documentManagerDateCreate) {
        _documentManagerDateCreate = documentManagerDateCreate;
    }

    public String getDocumentManagerTitle() {
        return _documentManagerTitle;
    }

    public void setDocumentManagerTitle(String documentManagerTitle) {
        _documentManagerTitle = documentManagerTitle;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }
}
