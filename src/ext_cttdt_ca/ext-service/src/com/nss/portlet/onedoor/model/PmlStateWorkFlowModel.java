package com.nss.portlet.onedoor.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlStateWorkFlowModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlStateWorkFlow</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlStateWorkFlow
 * @see com.nss.portlet.onedoor.model.impl.PmlStateWorkFlowImpl
 * @see com.nss.portlet.onedoor.model.impl.PmlStateWorkFlowModelImpl
 *
 */
public interface PmlStateWorkFlowModel extends BaseModel<PmlStateWorkFlow> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getStateWfId();

    public void setStateWfId(long stateWfId);

    public String getWorkflow();

    public void setWorkflow(String workflow);

    public long getStateProcessId();

    public void setStateProcessId(long stateProcessId);

    public int getSolvingTime();

    public void setSolvingTime(int solvingTime);

    public int getVersion_();

    public void setVersion_(int version_);

    public PmlStateWorkFlow toEscapedModel();
}
