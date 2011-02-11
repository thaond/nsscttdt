package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlEdmDocumentReceiptProcessTypeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocumentReceiptProcessType</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptProcessTypeImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptProcessTypeModelImpl
 *
 */
public interface PmlEdmDocumentReceiptProcessTypeModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocReceiptProcessTypeId();

    public void setDocReceiptProcessTypeId(long docReceiptProcessTypeId);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

    public long getDocumentReceiptLogId();

    public void setDocumentReceiptLogId(long documentReceiptLogId);

    public int getProcessTypeOrderNo();

    public void setProcessTypeOrderNo(int processTypeOrderNo);

    public Date getDateEdit();

    public void setDateEdit(Date dateEdit);

    public String getProcessTypeIdBefore();

    public void setProcessTypeIdBefore(String processTypeIdBefore);

    public String getProcessTypeIdAfter();

    public void setProcessTypeIdAfter(String processTypeIdAfter);

    public String getProcessTypeReason();

    public void setProcessTypeReason(String processTypeReason);

    public long getProcesserId();

    public void setProcesserId(long processerId);

    public String getDepartmentId();

    public void setDepartmentId(String departmentId);

    public PmlEdmDocumentReceiptProcessType toEscapedModel();
}
