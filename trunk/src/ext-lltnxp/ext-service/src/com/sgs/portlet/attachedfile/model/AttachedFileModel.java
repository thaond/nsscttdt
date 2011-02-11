package com.sgs.portlet.attachedfile.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="AttachedFileModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>AttachedFile</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.attachedfile.model.AttachedFile
 * @see com.sgs.portlet.attachedfile.model.impl.AttachedFileImpl
 * @see com.sgs.portlet.attachedfile.model.impl.AttachedFileModelImpl
 *
 */
public interface AttachedFileModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getAttachedFileId();

    public void setAttachedFileId(String attachedFileId);

    public String getAttachedFileCode();

    public void setAttachedFileCode(String attachedFileCode);

    public String getAttachedFileName();

    public void setAttachedFileName(String attachedFileName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public AttachedFile toEscapedModel();
}
