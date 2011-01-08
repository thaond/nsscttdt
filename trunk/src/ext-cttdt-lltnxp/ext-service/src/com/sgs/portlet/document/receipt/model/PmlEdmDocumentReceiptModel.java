package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlEdmDocumentReceiptModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocumentReceipt</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptModelImpl
 *
 */
public interface PmlEdmDocumentReceiptModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

    public int getLevelSendId();

    public void setLevelSendId(int levelSendId);

    public long getDocumentTypeId();

    public void setDocumentTypeId(long documentTypeId);

    public String getDocumentReference();

    public void setDocumentReference(String documentReference);

    public String getIssuingPlaceId();

    public void setIssuingPlaceId(String issuingPlaceId);

    public Date getIssuingDate();

    public void setIssuingDate(Date issuingDate);

    public Date getDateArrive();

    public void setDateArrive(Date dateArrive);

    public String getSigner();

    public void setSigner(String signer);

    public String getPrivilegeLevelId();

    public void setPrivilegeLevelId(String privilegeLevelId);

    public String getConfidentialLevelId();

    public void setConfidentialLevelId(String confidentialLevelId);

    public String getOpinion();

    public void setOpinion(String opinion);

    public String getBriefContent();

    public void setBriefContent(String briefContent);

    public String getIsPublic();

    public void setIsPublic(String isPublic);

    public String getNumberDocumentReceipt();

    public void setNumberDocumentReceipt(String numberDocumentReceipt);

    public int getProcessTime();

    public void setProcessTime(int processTime);

    public String getStatus();

    public void setStatus(String status);

    public String getActive();

    public void setActive(String active);

    public String getNumberLocalDocumentReceipt();

    public void setNumberLocalDocumentReceipt(String numberLocalDocumentReceipt);

    public String getIssuingPlaceOtherName();

    public void setIssuingPlaceOtherName(String issuingPlaceOtherName);

    public String getDocumentType();

    public void setDocumentType(String documentType);

    public Date getDateButPhe();

    public void setDateButPhe(Date dateButPhe);

    public Date getDateHoanThanh();

    public void setDateHoanThanh(Date dateHoanThanh);

    public long getStatusId();

    public void setStatusId(long statusId);

    public String getThoigiannhancvden();

    public void setThoigiannhancvden(String thoigiannhancvden);

    public String getSocongvandiphucdap();

    public void setSocongvandiphucdap(String socongvandiphucdap);

    public long getGeneralOrderNo();

    public void setGeneralOrderNo(long generalOrderNo);

    public String getMainDepartmentProcessId();

    public void setMainDepartmentProcessId(String mainDepartmentProcessId);

    public long getMainUserProcessId();

    public void setMainUserProcessId(long mainUserProcessId);

    public long getOrgExternalId();

    public void setOrgExternalId(long orgExternalId);

    public long getDocReceiptTempId();

    public void setDocReceiptTempId(long docReceiptTempId);

    public String getDonViSaoY();

    public void setDonViSaoY(String donViSaoY);

    public PmlEdmDocumentReceipt toEscapedModel();
}
