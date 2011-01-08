package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmDocumentRecordTypeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocumentRecordType</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeModelImpl
 *
 */
public interface PmlEdmDocumentRecordTypeModel extends BaseModel {
    public int getPrimaryKey();

    public void setPrimaryKey(int pk);

    public int getDocumentRecordTypeId();

    public void setDocumentRecordTypeId(int documentRecordTypeId);

    public String getDocumentRecordTypeName();

    public void setDocumentRecordTypeName(String documentRecordTypeName);

    public String getDocumentRecordTypeCode();

    public void setDocumentRecordTypeCode(String documentRecordTypeCode);

    public PmlEdmDocumentRecordType toEscapedModel();
}
