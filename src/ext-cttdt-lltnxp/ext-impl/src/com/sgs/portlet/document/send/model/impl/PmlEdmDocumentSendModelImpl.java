package com.sgs.portlet.document.send.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSendSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentSendModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocumentSend</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmDocumentSend
 * @see com.sgs.portlet.document.send.model.PmlEdmDocumentSendModel
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl
 *
 */
public class PmlEdmDocumentSendModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documentsend";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentsendid", new Integer(Types.BIGINT) },
            

            { "briefcontent", new Integer(Types.VARCHAR) },
            

            { "documentreference", new Integer(Types.VARCHAR) },
            

            { "receivingplace", new Integer(Types.VARCHAR) },
            

            { "issuingdate", new Integer(Types.TIMESTAMP) },
            

            { "opinion", new Integer(Types.VARCHAR) },
            

            { "editorid", new Integer(Types.BIGINT) },
            

            { "signerid", new Integer(Types.BIGINT) },
            

            { "documenttypeid", new Integer(Types.BIGINT) },
            

            { "privilegelevelid", new Integer(Types.VARCHAR) },
            

            { "confidentiallevelid", new Integer(Types.VARCHAR) },
            

            { "datecreated", new Integer(Types.TIMESTAMP) },
            

            { "islocal", new Integer(Types.BOOLEAN) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "senddate", new Integer(Types.TIMESTAMP) },
            

            { "signername", new Integer(Types.VARCHAR) },
            

            { "position_", new Integer(Types.VARCHAR) },
            

            { "numberpage", new Integer(Types.VARCHAR) },
            

            { "numberpublish", new Integer(Types.VARCHAR) },
            

            { "documentsendcode", new Integer(Types.VARCHAR) },
            

            { "statusid", new Integer(Types.BIGINT) },
            

            { "iscongvanphucdap", new Integer(Types.BOOLEAN) },
            

            { "numofdocref", new Integer(Types.BIGINT) },
            

            { "ispublish", new Integer(Types.BOOLEAN) },
            

            { "orgexternalid", new Integer(Types.BIGINT) },
            

            { "numofdirector", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documentsend (documentsendid LONG not null primary key,briefcontent VARCHAR(75) null,documentreference VARCHAR(75) null,receivingplace VARCHAR(75) null,issuingdate DATE null,opinion VARCHAR(75) null,editorid LONG,signerid LONG,documenttypeid LONG,privilegelevelid VARCHAR(75) null,confidentiallevelid VARCHAR(75) null,datecreated DATE null,islocal BOOLEAN,active VARCHAR(75) null,senddate DATE null,signername VARCHAR(75) null,position_ VARCHAR(75) null,numberpage VARCHAR(75) null,numberpublish VARCHAR(75) null,documentsendcode VARCHAR(75) null,statusid LONG,iscongvanphucdap BOOLEAN,numofdocref LONG,ispublish BOOLEAN,orgexternalid LONG,numofdirector BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documentsend";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.send.model.PmlEdmDocumentSend"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.send.model.PmlEdmDocumentSend"));
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

    public PmlEdmDocumentSendModelImpl() {
    }

    public static PmlEdmDocumentSend toModel(PmlEdmDocumentSendSoap soapModel) {
        PmlEdmDocumentSend model = new PmlEdmDocumentSendImpl();

        model.setDocumentSendId(soapModel.getDocumentSendId());
        model.setBriefContent(soapModel.getBriefContent());
        model.setDocumentReference(soapModel.getDocumentReference());
        model.setReceivingPlace(soapModel.getReceivingPlace());
        model.setIssuingDate(soapModel.getIssuingDate());
        model.setOpinion(soapModel.getOpinion());
        model.setEditorId(soapModel.getEditorId());
        model.setSignerId(soapModel.getSignerId());
        model.setDocumentTypeId(soapModel.getDocumentTypeId());
        model.setPrivilegeLevelId(soapModel.getPrivilegeLevelId());
        model.setConfidentialLevelId(soapModel.getConfidentialLevelId());
        model.setDateCreated(soapModel.getDateCreated());
        model.setIsLocal(soapModel.getIsLocal());
        model.setActive(soapModel.getActive());
        model.setSendDate(soapModel.getSendDate());
        model.setSignerName(soapModel.getSignerName());
        model.setPosition(soapModel.getPosition());
        model.setNumberPage(soapModel.getNumberPage());
        model.setNumberPublish(soapModel.getNumberPublish());
        model.setDocumentSendCode(soapModel.getDocumentSendCode());
        model.setStatusId(soapModel.getStatusId());
        model.setIscongvanphucdap(soapModel.getIscongvanphucdap());
        model.setNumOfDocRef(soapModel.getNumOfDocRef());
        model.setIsPublish(soapModel.getIsPublish());
        model.setOrgExternalId(soapModel.getOrgExternalId());
        model.setNumOfDirector(soapModel.getNumOfDirector());

        return model;
    }

    public static List<PmlEdmDocumentSend> toModels(
        PmlEdmDocumentSendSoap[] soapModels) {
        List<PmlEdmDocumentSend> models = new ArrayList<PmlEdmDocumentSend>(soapModels.length);

        for (PmlEdmDocumentSendSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentSendId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentSendId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentSendId);
    }

    public long getDocumentSendId() {
        return _documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        if (documentSendId != _documentSendId) {
            _documentSendId = documentSendId;
        }
    }

    public String getBriefContent() {
        return GetterUtil.getString(_briefContent);
    }

    public void setBriefContent(String briefContent) {
        if (((briefContent == null) && (_briefContent != null)) ||
                ((briefContent != null) && (_briefContent == null)) ||
                ((briefContent != null) && (_briefContent != null) &&
                !briefContent.equals(_briefContent))) {
            _briefContent = briefContent;
        }
    }

    public String getDocumentReference() {
        return GetterUtil.getString(_documentReference);
    }

    public void setDocumentReference(String documentReference) {
        if (((documentReference == null) && (_documentReference != null)) ||
                ((documentReference != null) && (_documentReference == null)) ||
                ((documentReference != null) && (_documentReference != null) &&
                !documentReference.equals(_documentReference))) {
            _documentReference = documentReference;
        }
    }

    public String getReceivingPlace() {
        return GetterUtil.getString(_receivingPlace);
    }

    public void setReceivingPlace(String receivingPlace) {
        if (((receivingPlace == null) && (_receivingPlace != null)) ||
                ((receivingPlace != null) && (_receivingPlace == null)) ||
                ((receivingPlace != null) && (_receivingPlace != null) &&
                !receivingPlace.equals(_receivingPlace))) {
            _receivingPlace = receivingPlace;
        }
    }

    public Date getIssuingDate() {
        return _issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        if (((issuingDate == null) && (_issuingDate != null)) ||
                ((issuingDate != null) && (_issuingDate == null)) ||
                ((issuingDate != null) && (_issuingDate != null) &&
                !issuingDate.equals(_issuingDate))) {
            _issuingDate = issuingDate;
        }
    }

    public String getOpinion() {
        return GetterUtil.getString(_opinion);
    }

    public void setOpinion(String opinion) {
        if (((opinion == null) && (_opinion != null)) ||
                ((opinion != null) && (_opinion == null)) ||
                ((opinion != null) && (_opinion != null) &&
                !opinion.equals(_opinion))) {
            _opinion = opinion;
        }
    }

    public long getEditorId() {
        return _editorId;
    }

    public void setEditorId(long editorId) {
        if (editorId != _editorId) {
            _editorId = editorId;
        }
    }

    public long getSignerId() {
        return _signerId;
    }

    public void setSignerId(long signerId) {
        if (signerId != _signerId) {
            _signerId = signerId;
        }
    }

    public long getDocumentTypeId() {
        return _documentTypeId;
    }

    public void setDocumentTypeId(long documentTypeId) {
        if (documentTypeId != _documentTypeId) {
            _documentTypeId = documentTypeId;
        }
    }

    public String getPrivilegeLevelId() {
        return GetterUtil.getString(_privilegeLevelId);
    }

    public void setPrivilegeLevelId(String privilegeLevelId) {
        if (((privilegeLevelId == null) && (_privilegeLevelId != null)) ||
                ((privilegeLevelId != null) && (_privilegeLevelId == null)) ||
                ((privilegeLevelId != null) && (_privilegeLevelId != null) &&
                !privilegeLevelId.equals(_privilegeLevelId))) {
            _privilegeLevelId = privilegeLevelId;
        }
    }

    public String getConfidentialLevelId() {
        return GetterUtil.getString(_confidentialLevelId);
    }

    public void setConfidentialLevelId(String confidentialLevelId) {
        if (((confidentialLevelId == null) && (_confidentialLevelId != null)) ||
                ((confidentialLevelId != null) &&
                (_confidentialLevelId == null)) ||
                ((confidentialLevelId != null) &&
                (_confidentialLevelId != null) &&
                !confidentialLevelId.equals(_confidentialLevelId))) {
            _confidentialLevelId = confidentialLevelId;
        }
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        if (((dateCreated == null) && (_dateCreated != null)) ||
                ((dateCreated != null) && (_dateCreated == null)) ||
                ((dateCreated != null) && (_dateCreated != null) &&
                !dateCreated.equals(_dateCreated))) {
            _dateCreated = dateCreated;
        }
    }

    public boolean getIsLocal() {
        return _isLocal;
    }

    public boolean isIsLocal() {
        return _isLocal;
    }

    public void setIsLocal(boolean isLocal) {
        if (isLocal != _isLocal) {
            _isLocal = isLocal;
        }
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        if (((active == null) && (_active != null)) ||
                ((active != null) && (_active == null)) ||
                ((active != null) && (_active != null) &&
                !active.equals(_active))) {
            _active = active;
        }
    }

    public Date getSendDate() {
        return _sendDate;
    }

    public void setSendDate(Date sendDate) {
        if (((sendDate == null) && (_sendDate != null)) ||
                ((sendDate != null) && (_sendDate == null)) ||
                ((sendDate != null) && (_sendDate != null) &&
                !sendDate.equals(_sendDate))) {
            _sendDate = sendDate;
        }
    }

    public String getSignerName() {
        return GetterUtil.getString(_signerName);
    }

    public void setSignerName(String signerName) {
        if (((signerName == null) && (_signerName != null)) ||
                ((signerName != null) && (_signerName == null)) ||
                ((signerName != null) && (_signerName != null) &&
                !signerName.equals(_signerName))) {
            _signerName = signerName;
        }
    }

    public String getPosition() {
        return GetterUtil.getString(_position);
    }

    public void setPosition(String position) {
        if (((position == null) && (_position != null)) ||
                ((position != null) && (_position == null)) ||
                ((position != null) && (_position != null) &&
                !position.equals(_position))) {
            _position = position;
        }
    }

    public String getNumberPage() {
        return GetterUtil.getString(_numberPage);
    }

    public void setNumberPage(String numberPage) {
        if (((numberPage == null) && (_numberPage != null)) ||
                ((numberPage != null) && (_numberPage == null)) ||
                ((numberPage != null) && (_numberPage != null) &&
                !numberPage.equals(_numberPage))) {
            _numberPage = numberPage;
        }
    }

    public String getNumberPublish() {
        return GetterUtil.getString(_numberPublish);
    }

    public void setNumberPublish(String numberPublish) {
        if (((numberPublish == null) && (_numberPublish != null)) ||
                ((numberPublish != null) && (_numberPublish == null)) ||
                ((numberPublish != null) && (_numberPublish != null) &&
                !numberPublish.equals(_numberPublish))) {
            _numberPublish = numberPublish;
        }
    }

    public String getDocumentSendCode() {
        return GetterUtil.getString(_documentSendCode);
    }

    public void setDocumentSendCode(String documentSendCode) {
        if (((documentSendCode == null) && (_documentSendCode != null)) ||
                ((documentSendCode != null) && (_documentSendCode == null)) ||
                ((documentSendCode != null) && (_documentSendCode != null) &&
                !documentSendCode.equals(_documentSendCode))) {
            _documentSendCode = documentSendCode;
        }
    }

    public long getStatusId() {
        return _statusId;
    }

    public void setStatusId(long statusId) {
        if (statusId != _statusId) {
            _statusId = statusId;
        }
    }

    public boolean getIscongvanphucdap() {
        return _iscongvanphucdap;
    }

    public boolean isIscongvanphucdap() {
        return _iscongvanphucdap;
    }

    public void setIscongvanphucdap(boolean iscongvanphucdap) {
        if (iscongvanphucdap != _iscongvanphucdap) {
            _iscongvanphucdap = iscongvanphucdap;
        }
    }

    public long getNumOfDocRef() {
        return _numOfDocRef;
    }

    public void setNumOfDocRef(long numOfDocRef) {
        if (numOfDocRef != _numOfDocRef) {
            _numOfDocRef = numOfDocRef;
        }
    }

    public boolean getIsPublish() {
        return _isPublish;
    }

    public boolean isIsPublish() {
        return _isPublish;
    }

    public void setIsPublish(boolean isPublish) {
        if (isPublish != _isPublish) {
            _isPublish = isPublish;
        }
    }

    public long getOrgExternalId() {
        return _orgExternalId;
    }

    public void setOrgExternalId(long orgExternalId) {
        if (orgExternalId != _orgExternalId) {
            _orgExternalId = orgExternalId;
        }
    }

    public boolean getNumOfDirector() {
        return _numOfDirector;
    }

    public boolean isNumOfDirector() {
        return _numOfDirector;
    }

    public void setNumOfDirector(boolean numOfDirector) {
        if (numOfDirector != _numOfDirector) {
            _numOfDirector = numOfDirector;
        }
    }

    public PmlEdmDocumentSend toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocumentSend) this;
        } else {
            PmlEdmDocumentSend model = new PmlEdmDocumentSendImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentSendId(getDocumentSendId());
            model.setBriefContent(HtmlUtil.escape(getBriefContent()));
            model.setDocumentReference(HtmlUtil.escape(getDocumentReference()));
            model.setReceivingPlace(HtmlUtil.escape(getReceivingPlace()));
            model.setIssuingDate(getIssuingDate());
            model.setOpinion(HtmlUtil.escape(getOpinion()));
            model.setEditorId(getEditorId());
            model.setSignerId(getSignerId());
            model.setDocumentTypeId(getDocumentTypeId());
            model.setPrivilegeLevelId(HtmlUtil.escape(getPrivilegeLevelId()));
            model.setConfidentialLevelId(HtmlUtil.escape(
                    getConfidentialLevelId()));
            model.setDateCreated(getDateCreated());
            model.setIsLocal(getIsLocal());
            model.setActive(HtmlUtil.escape(getActive()));
            model.setSendDate(getSendDate());
            model.setSignerName(HtmlUtil.escape(getSignerName()));
            model.setPosition(HtmlUtil.escape(getPosition()));
            model.setNumberPage(HtmlUtil.escape(getNumberPage()));
            model.setNumberPublish(HtmlUtil.escape(getNumberPublish()));
            model.setDocumentSendCode(HtmlUtil.escape(getDocumentSendCode()));
            model.setStatusId(getStatusId());
            model.setIscongvanphucdap(getIscongvanphucdap());
            model.setNumOfDocRef(getNumOfDocRef());
            model.setIsPublish(getIsPublish());
            model.setOrgExternalId(getOrgExternalId());
            model.setNumOfDirector(getNumOfDirector());

            model = (PmlEdmDocumentSend) Proxy.newProxyInstance(PmlEdmDocumentSend.class.getClassLoader(),
                    new Class[] { PmlEdmDocumentSend.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocumentSendImpl clone = new PmlEdmDocumentSendImpl();

        clone.setDocumentSendId(getDocumentSendId());
        clone.setBriefContent(getBriefContent());
        clone.setDocumentReference(getDocumentReference());
        clone.setReceivingPlace(getReceivingPlace());
        clone.setIssuingDate(getIssuingDate());
        clone.setOpinion(getOpinion());
        clone.setEditorId(getEditorId());
        clone.setSignerId(getSignerId());
        clone.setDocumentTypeId(getDocumentTypeId());
        clone.setPrivilegeLevelId(getPrivilegeLevelId());
        clone.setConfidentialLevelId(getConfidentialLevelId());
        clone.setDateCreated(getDateCreated());
        clone.setIsLocal(getIsLocal());
        clone.setActive(getActive());
        clone.setSendDate(getSendDate());
        clone.setSignerName(getSignerName());
        clone.setPosition(getPosition());
        clone.setNumberPage(getNumberPage());
        clone.setNumberPublish(getNumberPublish());
        clone.setDocumentSendCode(getDocumentSendCode());
        clone.setStatusId(getStatusId());
        clone.setIscongvanphucdap(getIscongvanphucdap());
        clone.setNumOfDocRef(getNumOfDocRef());
        clone.setIsPublish(getIsPublish());
        clone.setOrgExternalId(getOrgExternalId());
        clone.setNumOfDirector(getNumOfDirector());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmDocumentSendImpl pmlEdmDocumentSend = (PmlEdmDocumentSendImpl) obj;

        int value = 0;

        if (getDocumentSendId() < pmlEdmDocumentSend.getDocumentSendId()) {
            value = -1;
        } else if (getDocumentSendId() > pmlEdmDocumentSend.getDocumentSendId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlEdmDocumentSendImpl pmlEdmDocumentSend = null;

        try {
            pmlEdmDocumentSend = (PmlEdmDocumentSendImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmDocumentSend.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
