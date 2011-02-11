package com.sgs.portlet.document_manager.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="AttactFileDocumentSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document_manager.service.http.AttactFileDocumentServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.service.http.AttactFileDocumentServiceSoap
 *
 */
public class AttactFileDocumentSoap implements Serializable {
    private long _attactFileDocumentId;
    private String _attactFileDocumentTitle;
    private String _attactFileDocumentPath;
    private long _documentManagerId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public AttactFileDocumentSoap() {
    }

    public static AttactFileDocumentSoap toSoapModel(AttactFileDocument model) {
        AttactFileDocumentSoap soapModel = new AttactFileDocumentSoap();

        soapModel.setAttactFileDocumentId(model.getAttactFileDocumentId());
        soapModel.setAttactFileDocumentTitle(model.getAttactFileDocumentTitle());
        soapModel.setAttactFileDocumentPath(model.getAttactFileDocumentPath());
        soapModel.setDocumentManagerId(model.getDocumentManagerId());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static AttactFileDocumentSoap[] toSoapModels(
        List<AttactFileDocument> models) {
        List<AttactFileDocumentSoap> soapModels = new ArrayList<AttactFileDocumentSoap>(models.size());

        for (AttactFileDocument model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AttactFileDocumentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _attactFileDocumentId;
    }

    public void setPrimaryKey(long pk) {
        setAttactFileDocumentId(pk);
    }

    public long getAttactFileDocumentId() {
        return _attactFileDocumentId;
    }

    public void setAttactFileDocumentId(long attactFileDocumentId) {
        _attactFileDocumentId = attactFileDocumentId;
    }

    public String getAttactFileDocumentTitle() {
        return _attactFileDocumentTitle;
    }

    public void setAttactFileDocumentTitle(String attactFileDocumentTitle) {
        _attactFileDocumentTitle = attactFileDocumentTitle;
    }

    public String getAttactFileDocumentPath() {
        return _attactFileDocumentPath;
    }

    public void setAttactFileDocumentPath(String attactFileDocumentPath) {
        _attactFileDocumentPath = attactFileDocumentPath;
    }

    public long getDocumentManagerId() {
        return _documentManagerId;
    }

    public void setDocumentManagerId(long documentManagerId) {
        _documentManagerId = documentManagerId;
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
