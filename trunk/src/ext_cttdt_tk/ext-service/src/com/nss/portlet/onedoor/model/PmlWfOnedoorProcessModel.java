package com.nss.portlet.onedoor.model;

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
 * @see com.nss.portlet.onedoor.model.PmlWfOnedoorProcess
 * @see com.nss.portlet.onedoor.model.impl.PmlWfOnedoorProcessImpl
 * @see com.nss.portlet.onedoor.model.impl.PmlWfOnedoorProcessModelImpl
 *
 */
public interface PmlWfOnedoorProcessModel extends BaseModel<PmlWfOnedoorProcess> {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getFileId();

    public void setFileId(String fileId);

    public long getProcessId();

    public void setProcessId(long processId);

    public PmlWfOnedoorProcess toEscapedModel();
}
