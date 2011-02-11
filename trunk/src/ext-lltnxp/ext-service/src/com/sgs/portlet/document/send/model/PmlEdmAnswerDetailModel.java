package com.sgs.portlet.document.send.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmAnswerDetailModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmAnswerDetail</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmAnswerDetail
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmAnswerDetailImpl
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmAnswerDetailModelImpl
 *
 */
public interface PmlEdmAnswerDetailModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

    public long getDocumentSendId();

    public void setDocumentSendId(long documentSendId);

    public PmlEdmAnswerDetail toEscapedModel();
}
