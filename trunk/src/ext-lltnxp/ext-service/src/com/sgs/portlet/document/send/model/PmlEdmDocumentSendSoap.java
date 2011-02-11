package com.sgs.portlet.document.send.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentSendSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmDocumentSendServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmDocumentSendServiceSoap
 *
 */
public class PmlEdmDocumentSendSoap implements Serializable {
    private long _documentSendId;
    private String _briefContent;
    private String _documentReference;
    private String _receivingPlace;
    private Date _issuingDate;
    private String _opinion;
    private long _editorId;
    private long _signerId;
    private long _documentTypeId;
    private String _privilegeLevelId;
    private String _confidentialLevelId;
    private Date _dateCreated;
    private boolean _isLocal;
    private String _active;
    private Date _sendDate;
    private String _signerName;
    private String _position;
    private String _numberPage;
    private String _numberPublish;
    private String _documentSendCode;
    private long _statusId;
    private boolean _iscongvanphucdap;
    private long _numOfDocRef;
    private boolean _isPublish;
    private long _orgExternalId;
    private boolean _numOfDirector;
    private int _documentRecordTypeId;

    public PmlEdmDocumentSendSoap() {
    }

    public static PmlEdmDocumentSendSoap toSoapModel(PmlEdmDocumentSend model) {
        PmlEdmDocumentSendSoap soapModel = new PmlEdmDocumentSendSoap();

        soapModel.setDocumentSendId(model.getDocumentSendId());
        soapModel.setBriefContent(model.getBriefContent());
        soapModel.setDocumentReference(model.getDocumentReference());
        soapModel.setReceivingPlace(model.getReceivingPlace());
        soapModel.setIssuingDate(model.getIssuingDate());
        soapModel.setOpinion(model.getOpinion());
        soapModel.setEditorId(model.getEditorId());
        soapModel.setSignerId(model.getSignerId());
        soapModel.setDocumentTypeId(model.getDocumentTypeId());
        soapModel.setPrivilegeLevelId(model.getPrivilegeLevelId());
        soapModel.setConfidentialLevelId(model.getConfidentialLevelId());
        soapModel.setDateCreated(model.getDateCreated());
        soapModel.setIsLocal(model.getIsLocal());
        soapModel.setActive(model.getActive());
        soapModel.setSendDate(model.getSendDate());
        soapModel.setSignerName(model.getSignerName());
        soapModel.setPosition(model.getPosition());
        soapModel.setNumberPage(model.getNumberPage());
        soapModel.setNumberPublish(model.getNumberPublish());
        soapModel.setDocumentSendCode(model.getDocumentSendCode());
        soapModel.setStatusId(model.getStatusId());
        soapModel.setIscongvanphucdap(model.getIscongvanphucdap());
        soapModel.setNumOfDocRef(model.getNumOfDocRef());
        soapModel.setIsPublish(model.getIsPublish());
        soapModel.setOrgExternalId(model.getOrgExternalId());
        soapModel.setNumOfDirector(model.getNumOfDirector());
        soapModel.setDocumentRecordTypeId(model.getDocumentRecordTypeId());

        return soapModel;
    }

    public static PmlEdmDocumentSendSoap[] toSoapModels(
        List<PmlEdmDocumentSend> models) {
        List<PmlEdmDocumentSendSoap> soapModels = new ArrayList<PmlEdmDocumentSendSoap>(models.size());

        for (PmlEdmDocumentSend model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocumentSendSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentSendId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentSendId(pk);
    }

    public long getDocumentSendId() {
        return _documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        _documentSendId = documentSendId;
    }

    public String getBriefContent() {
        return _briefContent;
    }

    public void setBriefContent(String briefContent) {
        _briefContent = briefContent;
    }

    public String getDocumentReference() {
        return _documentReference;
    }

    public void setDocumentReference(String documentReference) {
        _documentReference = documentReference;
    }

    public String getReceivingPlace() {
        return _receivingPlace;
    }

    public void setReceivingPlace(String receivingPlace) {
        _receivingPlace = receivingPlace;
    }

    public Date getIssuingDate() {
        return _issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        _issuingDate = issuingDate;
    }

    public String getOpinion() {
        return _opinion;
    }

    public void setOpinion(String opinion) {
        _opinion = opinion;
    }

    public long getEditorId() {
        return _editorId;
    }

    public void setEditorId(long editorId) {
        _editorId = editorId;
    }

    public long getSignerId() {
        return _signerId;
    }

    public void setSignerId(long signerId) {
        _signerId = signerId;
    }

    public long getDocumentTypeId() {
        return _documentTypeId;
    }

    public void setDocumentTypeId(long documentTypeId) {
        _documentTypeId = documentTypeId;
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

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
    }

    public boolean getIsLocal() {
        return _isLocal;
    }

    public boolean isIsLocal() {
        return _isLocal;
    }

    public void setIsLocal(boolean isLocal) {
        _isLocal = isLocal;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }

    public Date getSendDate() {
        return _sendDate;
    }

    public void setSendDate(Date sendDate) {
        _sendDate = sendDate;
    }

    public String getSignerName() {
        return _signerName;
    }

    public void setSignerName(String signerName) {
        _signerName = signerName;
    }

    public String getPosition() {
        return _position;
    }

    public void setPosition(String position) {
        _position = position;
    }

    public String getNumberPage() {
        return _numberPage;
    }

    public void setNumberPage(String numberPage) {
        _numberPage = numberPage;
    }

    public String getNumberPublish() {
        return _numberPublish;
    }

    public void setNumberPublish(String numberPublish) {
        _numberPublish = numberPublish;
    }

    public String getDocumentSendCode() {
        return _documentSendCode;
    }

    public void setDocumentSendCode(String documentSendCode) {
        _documentSendCode = documentSendCode;
    }

    public long getStatusId() {
        return _statusId;
    }

    public void setStatusId(long statusId) {
        _statusId = statusId;
    }

    public boolean getIscongvanphucdap() {
        return _iscongvanphucdap;
    }

    public boolean isIscongvanphucdap() {
        return _iscongvanphucdap;
    }

    public void setIscongvanphucdap(boolean iscongvanphucdap) {
        _iscongvanphucdap = iscongvanphucdap;
    }

    public long getNumOfDocRef() {
        return _numOfDocRef;
    }

    public void setNumOfDocRef(long numOfDocRef) {
        _numOfDocRef = numOfDocRef;
    }

    public boolean getIsPublish() {
        return _isPublish;
    }

    public boolean isIsPublish() {
        return _isPublish;
    }

    public void setIsPublish(boolean isPublish) {
        _isPublish = isPublish;
    }

    public long getOrgExternalId() {
        return _orgExternalId;
    }

    public void setOrgExternalId(long orgExternalId) {
        _orgExternalId = orgExternalId;
    }

    public boolean getNumOfDirector() {
        return _numOfDirector;
    }

    public boolean isNumOfDirector() {
        return _numOfDirector;
    }

    public void setNumOfDirector(boolean numOfDirector) {
        _numOfDirector = numOfDirector;
    }

    public int getDocumentRecordTypeId() {
        return _documentRecordTypeId;
    }

    public void setDocumentRecordTypeId(int documentRecordTypeId) {
        _documentRecordTypeId = documentRecordTypeId;
    }
}
