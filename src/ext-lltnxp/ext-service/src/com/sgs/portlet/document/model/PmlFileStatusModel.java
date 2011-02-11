package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlFileStatusModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFileStatus</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlFileStatus
 * @see com.sgs.portlet.document.model.impl.PmlFileStatusImpl
 * @see com.sgs.portlet.document.model.impl.PmlFileStatusModelImpl
 *
 */
public interface PmlFileStatusModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getFileStatusId();

    public void setFileStatusId(long fileStatusId);

    public String getFileStatusCode();

    public void setFileStatusCode(String fileStatusCode);

    public String getFileStatusName();

    public void setFileStatusName(String fileStatusName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public String getType();

    public void setType(String type);

    public PmlFileStatus toEscapedModel();
}
