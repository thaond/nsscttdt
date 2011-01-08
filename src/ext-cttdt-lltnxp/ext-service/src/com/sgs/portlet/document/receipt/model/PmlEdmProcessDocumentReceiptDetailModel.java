package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlEdmProcessDocumentReceiptDetailModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmProcessDocumentReceiptDetail</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmProcessDocumentReceiptDetailImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmProcessDocumentReceiptDetailModelImpl
 *
 */
public interface PmlEdmProcessDocumentReceiptDetailModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getId();

    public void setId(long id);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

    public long getUserId();

    public void setUserId(long userId);

    public String getNote();

    public void setNote(String note);

    public Date getDateCreated();

    public void setDateCreated(Date dateCreated);

    public Date getDateUpdate();

    public void setDateUpdate(Date dateUpdate);

    public PmlEdmProcessDocumentReceiptDetail toEscapedModel();
}
