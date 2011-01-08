package com.sgs.portlet.onedoorpccc.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlFilePCCCModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFilePCCC</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.model.PmlFilePCCC
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCImpl
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCModelImpl
 *
 */
public interface PmlFilePCCCModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getFileId();

    public void setFileId(String fileId);

    public String getFileName();

    public void setFileName(String fileName);

    public String getApplicantRepresentation();

    public void setApplicantRepresentation(String applicantRepresentation);

    public String getApplicantTelephone();

    public void setApplicantTelephone(String applicantTelephone);

    public String getReceiverRepresentation();

    public void setReceiverRepresentation(String receiverRepresentation);

    public String getReceiverTelephone();

    public void setReceiverTelephone(String receiverTelephone);

    public String getProjectName();

    public void setProjectName(String projectName);

    public String getApplicantCategory();

    public void setApplicantCategory(String applicantCategory);

    public String getAddressBuilder();

    public void setAddressBuilder(String addressBuilder);

    public String getInvestor();

    public void setInvestor(String investor);

    public String getDesignCop();

    public void setDesignCop(String designCop);

    public int getFileNumber();

    public void setFileNumber(int fileNumber);

    public Date getInputDataDate();

    public void setInputDataDate(Date inputDataDate);

    public String getNoteInformationManagement();

    public void setNoteInformationManagement(String noteInformationManagement);

    public int getTotalHour();

    public void setTotalHour(int totalHour);

    public int getTotalDate();

    public void setTotalDate(int totalDate);

    public String getConclusion();

    public void setConclusion(String conclusion);

    public String getReceiveOfUnit();

    public void setReceiveOfUnit(String receiveOfUnit);

    public String getApplicantTime();

    public void setApplicantTime(String applicantTime);

    public PmlFilePCCC toEscapedModel();
}
