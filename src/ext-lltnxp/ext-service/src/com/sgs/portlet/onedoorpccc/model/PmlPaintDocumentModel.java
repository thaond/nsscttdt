package com.sgs.portlet.onedoorpccc.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlPaintDocumentModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlPaintDocument</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.model.PmlPaintDocument
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlPaintDocumentImpl
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlPaintDocumentModelImpl
 *
 */
public interface PmlPaintDocumentModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getPaintDocumentId();

    public void setPaintDocumentId(long paintDocumentId);

    public String getFileId();

    public void setFileId(String fileId);

    public String getPaintDocumentName();

    public void setPaintDocumentName(String paintDocumentName);

    public int getQuantity();

    public void setQuantity(int quantity);

    public String getNote();

    public void setNote(String note);

    public PmlPaintDocument toEscapedModel();
}
