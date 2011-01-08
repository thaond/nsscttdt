package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK;

import java.util.Date;


/**
 * <a href="PmlEdmBookDocumentRecordToModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmBookDocumentRecordTo</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToModelImpl
 *
 */
public interface PmlEdmBookDocumentRecordToModel extends BaseModel {
    public PmlEdmBookDocumentRecordToPK getPrimaryKey();

    public void setPrimaryKey(PmlEdmBookDocumentRecordToPK pk);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

    public long getDocumentRecordToId();

    public void setDocumentRecordToId(long documentRecordToId);

    public Date getDateCreate();

    public void setDateCreate(Date dateCreate);

    public Date getDateComplete();

    public void setDateComplete(Date dateComplete);

    public int getSoCongVanDenPhongHienTai();

    public void setSoCongVanDenPhongHienTai(int soCongVanDenPhongHienTai);

    public PmlEdmBookDocumentRecordTo toEscapedModel();
}
