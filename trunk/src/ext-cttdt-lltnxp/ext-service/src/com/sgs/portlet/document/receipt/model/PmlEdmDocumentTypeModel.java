package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmDocumentTypeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocumentType</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentType
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentTypeImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentTypeModelImpl
 *
 */
public interface PmlEdmDocumentTypeModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentTypeId();

    public void setDocumentTypeId(long documentTypeId);

    public String getDocumentTypeName();

    public void setDocumentTypeName(String documentTypeName);

    public String getDocumentSymbol();

    public void setDocumentSymbol(String documentSymbol);

    public int getDocumentRecordTypeId();

    public void setDocumentRecordTypeId(int documentRecordTypeId);

    public int getSendReceiptDistinction();

    public void setSendReceiptDistinction(int sendReceiptDistinction);

    public boolean getHaveDepartExtends();

    public boolean isHaveDepartExtends();

    public void setHaveDepartExtends(boolean HaveDepartExtends);

    public PmlEdmDocumentType toEscapedModel();
}
