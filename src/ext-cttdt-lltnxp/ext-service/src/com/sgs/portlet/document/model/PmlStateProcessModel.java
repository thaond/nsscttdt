package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlStateProcessModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlStateProcess</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlStateProcess
 * @see com.sgs.portlet.document.model.impl.PmlStateProcessImpl
 * @see com.sgs.portlet.document.model.impl.PmlStateProcessModelImpl
 *
 */
public interface PmlStateProcessModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getStateProcessId();

    public void setStateProcessId(long stateProcessId);

    public String getStateProcessCode();

    public void setStateProcessCode(String stateProcessCode);

    public String getStateProcessName();

    public void setStateProcessName(String stateProcessName);

    public long getFileStatusId();

    public void setFileStatusId(long fileStatusId);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public PmlStateProcess toEscapedModel();
}
