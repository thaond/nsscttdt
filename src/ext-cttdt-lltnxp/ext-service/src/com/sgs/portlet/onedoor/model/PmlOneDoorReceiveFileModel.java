package com.sgs.portlet.onedoor.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlOneDoorReceiveFileModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlOneDoorReceiveFile</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile
 * @see com.sgs.portlet.onedoor.model.impl.PmlOneDoorReceiveFileImpl
 * @see com.sgs.portlet.onedoor.model.impl.PmlOneDoorReceiveFileModelImpl
 *
 */
public interface PmlOneDoorReceiveFileModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getFileId();

    public void setFileId(String fileId);

    public String getCityId();

    public void setCityId(String cityId);

    public String getDistrictId();

    public void setDistrictId(String districtId);

    public String getWardsId();

    public void setWardsId(String wardsId);

    public String getStreetId();

    public void setStreetId(String streetId);

    public Date getExactReturningDate();

    public void setExactReturningDate(Date exactReturningDate);

    public long getReceiverId();

    public void setReceiverId(long receiverId);

    public Date getValidDate();

    public void setValidDate(Date validDate);

    public Date getExpectedReturningDate();

    public void setExpectedReturningDate(Date expectedReturningDate);

    public Date getApplicationDate();

    public void setApplicationDate(Date applicationDate);

    public String getOtherContent();

    public void setOtherContent(String otherContent);

    public String getBriefContent();

    public void setBriefContent(String briefContent);

    public String getApplicantName();

    public void setApplicantName(String applicantName);

    public String getOrganization();

    public void setOrganization(String organization);

    public String getAuthorisedLetter();

    public void setAuthorisedLetter(String authorisedLetter);

    public String getIdNumber();

    public void setIdNumber(String idNumber);

    public Date getIssuingDate();

    public void setIssuingDate(Date issuingDate);

    public String getIssuingPlace();

    public void setIssuingPlace(String issuingPlace);

    public String getTelephone();

    public void setTelephone(String telephone);

    public String getGender();

    public void setGender(String gender);

    public String getStreetNumber();

    public void setStreetNumber(String streetNumber);

    public String getPermanentAddress();

    public void setPermanentAddress(String permanentAddress);

    public String getContactInfomation();

    public void setContactInfomation(String contactInfomation);

    public String getOldNumberReceipt();

    public void setOldNumberReceipt(String oldNumberReceipt);

    public String getNumberReceipt();

    public void setNumberReceipt(String numberReceipt);

    public String getFileTypeId();

    public void setFileTypeId(String fileTypeId);

    public String getFieldId();

    public void setFieldId(String fieldId);

    public int getSolvingTime();

    public void setSolvingTime(int solvingTime);

    public String getAmendedContent();

    public void setAmendedContent(String amendedContent);

    public Date getLandCheckingDate();

    public void setLandCheckingDate(Date landCheckingDate);

    public String getDecisionNotice();

    public void setDecisionNotice(String decisionNotice);

    public String getReceiver();

    public void setReceiver(String receiver);

    public Date getDateCreated();

    public void setDateCreated(Date dateCreated);

    public Date getLastUpdate();

    public void setLastUpdate(Date lastUpdate);

    public String getLastTestProcessInfo();

    public void setLastTestProcessInfo(String lastTestProcessInfo);

    public String getActive();

    public void setActive(String active);

    public long getGeneralorderno();

    public void setGeneralorderno(long generalorderno);

    public PmlOneDoorReceiveFile toEscapedModel();
}
