package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlDocumentReceiptWFModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDocumentReceiptWF</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentReceiptWF
 * @see com.sgs.portlet.document.model.impl.PmlDocumentReceiptWFImpl
 * @see com.sgs.portlet.document.model.impl.PmlDocumentReceiptWFModelImpl
 *
 */
public interface PmlDocumentReceiptWFModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getProcessId();

    public void setProcessId(long processId);

    public long getDocumentReceiptId();

    public void setDocumentReceiptId(long documentReceiptId);

    public String getIsMain();

    public void setIsMain(String isMain);

    public PmlDocumentReceiptWF toEscapedModel();
}
