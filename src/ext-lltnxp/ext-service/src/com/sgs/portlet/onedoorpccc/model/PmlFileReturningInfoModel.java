package com.sgs.portlet.onedoorpccc.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlFileReturningInfoModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFileReturningInfo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlFileReturningInfoImpl
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlFileReturningInfoModelImpl
 *
 */
public interface PmlFileReturningInfoModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getFileReturningInfoId();

    public void setFileReturningInfoId(long fileReturningInfoId);

    public String getFileId();

    public void setFileId(String fileId);

    public String getFileSender();

    public void setFileSender(String fileSender);

    public String getLicenseNumber();

    public void setLicenseNumber(String licenseNumber);

    public Date getIssuingDateLicense();

    public void setIssuingDateLicense(Date issuingDateLicense);

    public Date getReceiveLicenseDate();

    public void setReceiveLicenseDate(Date receiveLicenseDate);

    public String getDocumentNumber();

    public void setDocumentNumber(String documentNumber);

    public String getBillNumber();

    public void setBillNumber(String billNumber);

    public long getNumberMoney();

    public void setNumberMoney(long numberMoney);

    public String getNote();

    public void setNote(String note);

    public String getConclude();

    public void setConclude(String conclude);

    public PmlFileReturningInfo toEscapedModel();
}
