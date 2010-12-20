package com.nss.portlet.filetype.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlFileTypeAttachedFileModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFileTypeAttachedFile</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.model.PmlFileTypeAttachedFile
 * @see com.nss.portlet.filetype.model.impl.PmlFileTypeAttachedFileImpl
 * @see com.nss.portlet.filetype.model.impl.PmlFileTypeAttachedFileModelImpl
 *
 */
public interface PmlFileTypeAttachedFileModel extends BaseModel<PmlFileTypeAttachedFile> {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getFiletypeAttachedFileId();

    public void setFiletypeAttachedFileId(String filetypeAttachedFileId);

    public String getFileTypeId();

    public void setFileTypeId(String fileTypeId);

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

    public PmlFileTypeAttachedFile toEscapedModel();
}
