package com.sgs.portlet.onedoor.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlWfOnedoorProcessModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlWfOnedoorProcess</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess
 * @see com.sgs.portlet.onedoor.model.impl.PmlWfOnedoorProcessImpl
 * @see com.sgs.portlet.onedoor.model.impl.PmlWfOnedoorProcessModelImpl
 *
 */
public interface PmlWfOnedoorProcessModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getFileId();

    public void setFileId(String fileId);

    public long getProcessId();

    public void setProcessId(long processId);

    public long getNodeId();

    public void setNodeId(long nodeId);

    public PmlWfOnedoorProcess toEscapedModel();
}
