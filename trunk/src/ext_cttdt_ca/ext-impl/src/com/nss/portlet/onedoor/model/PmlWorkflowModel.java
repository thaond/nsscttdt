package com.nss.portlet.onedoor.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlWorkflowModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlWorkflow</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlWorkflow
 * @see com.nss.portlet.onedoor.model.impl.PmlWorkflowImpl
 * @see com.nss.portlet.onedoor.model.impl.PmlWorkflowModelImpl
 *
 */
public interface PmlWorkflowModel extends BaseModel<PmlWorkflow> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getWorkflowId();

    public void setWorkflowId(long workflowId);

    public String getFileTypeId();

    public void setFileTypeId(String fileTypeId);

    public String getWorkflow();

    public void setWorkflow(String workflow);

    public int getVersion_();

    public void setVersion_(int version_);

    public Date getStartDate();

    public void setStartDate(Date startDate);

    public Date getEndDate();

    public void setEndDate(Date endDate);

    public PmlWorkflow toEscapedModel();
}
