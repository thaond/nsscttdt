package com.sgs.portlet.onedoor.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlFileAttachedFileModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFileAttachedFile</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlFileAttachedFile
 * @see com.sgs.portlet.onedoor.model.impl.PmlFileAttachedFileImpl
 * @see com.sgs.portlet.onedoor.model.impl.PmlFileAttachedFileModelImpl
 *
 */
public interface PmlFileAttachedFileModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getFileAttachedFileId();

    public void setFileAttachedFileId(String fileAttachedFileId);

    public String getFileId();

    public void setFileId(String fileId);

    public int getOriginal();

    public void setOriginal(int original);

    public int getCopy_();

    public void setCopy_(int copy_);

    public String getAttachedFileId();

    public void setAttachedFileId(String attachedFileId);

    public String getAttachedFileName();

    public void setAttachedFileName(String attachedFileName);

    public String getNote();

    public void setNote(String note);

    public PmlFileAttachedFile toEscapedModel();
}
