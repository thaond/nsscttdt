package com.sgs.portlet.onedoorpccc.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlFilePCCCAttachedFileModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFilePCCCAttachedFile</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCAttachedFileImpl
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCAttachedFileModelImpl
 *
 */
public interface PmlFilePCCCAttachedFileModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getAttachedFileId();

    public void setAttachedFileId(long attachedFileId);

    public String getFilePcccId();

    public void setFilePcccId(String filePcccId);

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

    public String getTitle();

    public void setTitle(String title);

    public PmlFilePCCCAttachedFile toEscapedModel();
}
