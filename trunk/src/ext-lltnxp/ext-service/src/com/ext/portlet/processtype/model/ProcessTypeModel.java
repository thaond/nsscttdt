package com.ext.portlet.processtype.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="ProcessTypeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ProcessType</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.processtype.model.ProcessType
 * @see com.ext.portlet.processtype.model.impl.ProcessTypeImpl
 * @see com.ext.portlet.processtype.model.impl.ProcessTypeModelImpl
 *
 */
public interface ProcessTypeModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getProcessTypeId();

    public void setProcessTypeId(long processTypeId);

    public String getName();

    public void setName(String name);

    public int getFlagProcessType();

    public void setFlagProcessType(int flagProcessType);

    public ProcessType toEscapedModel();
}
