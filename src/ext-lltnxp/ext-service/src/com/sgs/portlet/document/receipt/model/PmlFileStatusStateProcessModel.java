package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlFileStatusStateProcessModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFileStatusStateProcess</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess
 * @see com.sgs.portlet.document.receipt.model.impl.PmlFileStatusStateProcessImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlFileStatusStateProcessModelImpl
 *
 */
public interface PmlFileStatusStateProcessModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getId();

    public void setId(long id);

    public long getFileStatusId();

    public void setFileStatusId(long fileStatusId);

    public long getStateProcessId();

    public void setStateProcessId(long stateProcessId);

    public String getDescription();

    public void setDescription(String description);

    public PmlFileStatusStateProcess toEscapedModel();
}
