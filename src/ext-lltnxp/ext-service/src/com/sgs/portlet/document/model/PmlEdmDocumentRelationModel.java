package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmDocumentRelationModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocumentRelation</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlEdmDocumentRelation
 * @see com.sgs.portlet.document.model.impl.PmlEdmDocumentRelationImpl
 * @see com.sgs.portlet.document.model.impl.PmlEdmDocumentRelationModelImpl
 *
 */
public interface PmlEdmDocumentRelationModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentRelationId();

    public void setDocumentRelationId(long documentRelationId);

    public long getDocLeftId();

    public void setDocLeftId(long docLeftId);

    public long getDocRightId();

    public void setDocRightId(long docRightId);

    public boolean getLeftIsReceipt();

    public boolean isLeftIsReceipt();

    public void setLeftIsReceipt(boolean leftIsReceipt);

    public boolean getRightIsReceipt();

    public boolean isRightIsReceipt();

    public void setRightIsReceipt(boolean rightIsReceipt);

    public PmlEdmDocumentRelation toEscapedModel();
}
