package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlEdmAttachedFileModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmAttachedFile</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileModelImpl
 *
 */
public interface PmlEdmAttachedFileModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getAttachedFileId();

    public void setAttachedFileId(long attachedFileId);

    public long getObjectContentId();

    public void setObjectContentId(long objectContentId);

    public String getObjectType();

    public void setObjectType(String objectType);

    public String getAttachedFileName();

    public void setAttachedFileName(String attachedFileName);

    public String getPath();

    public void setPath(String path);

    public Date getDateCreated();

    public void setDateCreated(Date dateCreated);

    public String getFileType();

    public void setFileType(String fileType);

    public int getFileId();

    public void setFileId(int fileId);

    public String getTitle();

    public void setTitle(String title);

    public boolean getDisplayOrHidden();

    public boolean isDisplayOrHidden();

    public void setDisplayOrHidden(boolean displayOrHidden);

    public PmlEdmAttachedFile toEscapedModel();
}
