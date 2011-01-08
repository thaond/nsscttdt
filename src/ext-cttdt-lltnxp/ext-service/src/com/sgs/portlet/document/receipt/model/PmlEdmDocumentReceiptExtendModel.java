package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlEdmDocumentReceiptExtendModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocumentReceiptExtend</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptExtendImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptExtendModelImpl
 *
 */
public interface PmlEdmDocumentReceiptExtendModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentReceiptExtendId();

    public void setDocumentReceiptExtendId(long documentReceiptExtendId);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

    public long getDocumentReceiptLogId();

    public void setDocumentReceiptLogId(long documentReceiptLogId);

    public int getExtendOrderNo();

    public void setExtendOrderNo(int extendOrderNo);

    public Date getStartProcessDate();

    public void setStartProcessDate(Date startProcessDate);

    public int getNumDayProcessBef();

    public void setNumDayProcessBef(int numDayProcessBef);

    public Date getLimitDateBef();

    public void setLimitDateBef(Date limitDateBef);

    public String getExtendReason();

    public void setExtendReason(String extendReason);

    public int getNumDayProcessAft();

    public void setNumDayProcessAft(int numDayProcessAft);

    public Date getLimitDateAft();

    public void setLimitDateAft(Date limitDateAft);

    public boolean getLeanOnLimitDate();

    public boolean isLeanOnLimitDate();

    public void setLeanOnLimitDate(boolean leanOnLimitDate);

    public long getExtendUserId();

    public void setExtendUserId(long extendUserId);

    public String getExtendDepartmentId();

    public void setExtendDepartmentId(String extendDepartmentId);

    public PmlEdmDocumentReceiptExtend toEscapedModel();
}
