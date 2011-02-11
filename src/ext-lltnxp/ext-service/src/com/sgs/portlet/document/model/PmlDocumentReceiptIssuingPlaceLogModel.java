package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlDocumentReceiptIssuingPlaceLogModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDocumentReceiptIssuingPlaceLog</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog
 * @see com.sgs.portlet.document.model.impl.PmlDocumentReceiptIssuingPlaceLogImpl
 * @see com.sgs.portlet.document.model.impl.PmlDocumentReceiptIssuingPlaceLogModelImpl
 *
 */
public interface PmlDocumentReceiptIssuingPlaceLogModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentReceiptIssuingPlaceLogId();

    public void setDocumentReceiptIssuingPlaceLogId(
        long documentReceiptIssuingPlaceLogId);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

    public long getProcessor();

    public void setProcessor(long processor);

    public long getDirectProcessorId();

    public void setDirectProcessorId(long directProcessorId);

    public Date getDateProcess();

    public void setDateProcess(Date dateProcess);

    public String getProcessInfomation();

    public void setProcessInfomation(String processInfomation);

    public String getReceiver();

    public void setReceiver(String receiver);

    public int getType_();

    public void setType_(int type_);

    public int getStep();

    public void setStep(int step);

    public PmlDocumentReceiptIssuingPlaceLog toEscapedModel();
}
