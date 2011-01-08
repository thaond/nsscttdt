package com.sgs.portlet.document.manageworkflow.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlManageWorkDocumentFlowModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlManageWorkDocumentFlow</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow
 * @see com.sgs.portlet.document.manageworkflow.model.impl.PmlManageWorkDocumentFlowImpl
 * @see com.sgs.portlet.document.manageworkflow.model.impl.PmlManageWorkDocumentFlowModelImpl
 *
 */
public interface PmlManageWorkDocumentFlowModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getManageDocumentWorkFlowId();

    public void setManageDocumentWorkFlowId(long manageDocumentWorkFlowId);

    public String getWorkFlowName();

    public void setWorkFlowName(String workFlowName);

    public int getVersion();

    public void setVersion(int version);

    public int getType();

    public void setType(int type);

    public String getDescription();

    public void setDescription(String description);

    public Date getStartDate();

    public void setStartDate(Date startDate);

    public Date getEndDate();

    public void setEndDate(Date endDate);

    public PmlManageWorkDocumentFlow toEscapedModel();
}
