package com.sgs.portlet.document.send.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlEdmDocumentSendModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocumentSend</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmDocumentSend
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendImpl
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmDocumentSendModelImpl
 *
 */
public interface PmlEdmDocumentSendModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentSendId();

    public void setDocumentSendId(long documentSendId);

    public String getBriefContent();

    public void setBriefContent(String briefContent);

    public String getDocumentReference();

    public void setDocumentReference(String documentReference);

    public String getReceivingPlace();

    public void setReceivingPlace(String receivingPlace);

    public Date getIssuingDate();

    public void setIssuingDate(Date issuingDate);

    public String getOpinion();

    public void setOpinion(String opinion);

    public long getEditorId();

    public void setEditorId(long editorId);

    public long getSignerId();

    public void setSignerId(long signerId);

    public long getDocumentTypeId();

    public void setDocumentTypeId(long documentTypeId);

    public String getPrivilegeLevelId();

    public void setPrivilegeLevelId(String privilegeLevelId);

    public String getConfidentialLevelId();

    public void setConfidentialLevelId(String confidentialLevelId);

    public Date getDateCreated();

    public void setDateCreated(Date dateCreated);

    public boolean getIsLocal();

    public boolean isIsLocal();

    public void setIsLocal(boolean isLocal);

    public String getActive();

    public void setActive(String active);

    public Date getSendDate();

    public void setSendDate(Date sendDate);

    public String getSignerName();

    public void setSignerName(String signerName);

    public String getPosition();

    public void setPosition(String position);

    public String getNumberPage();

    public void setNumberPage(String numberPage);

    public String getNumberPublish();

    public void setNumberPublish(String numberPublish);

    public String getDocumentSendCode();

    public void setDocumentSendCode(String documentSendCode);

    public long getStatusId();

    public void setStatusId(long statusId);

    public boolean getIscongvanphucdap();

    public boolean isIscongvanphucdap();

    public void setIscongvanphucdap(boolean iscongvanphucdap);

    public long getNumOfDocRef();

    public void setNumOfDocRef(long numOfDocRef);

    public boolean getIsPublish();

    public boolean isIsPublish();

    public void setIsPublish(boolean isPublish);

    public long getOrgExternalId();

    public void setOrgExternalId(long orgExternalId);

    public boolean getNumOfDirector();

    public boolean isNumOfDirector();

    public void setNumOfDirector(boolean numOfDirector);

    public PmlEdmDocumentSend toEscapedModel();
}
