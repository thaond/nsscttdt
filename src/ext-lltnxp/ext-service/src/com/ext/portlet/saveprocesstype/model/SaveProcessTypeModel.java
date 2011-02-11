package com.ext.portlet.saveprocesstype.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="SaveProcessTypeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>SaveProcessType</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.saveprocesstype.model.SaveProcessType
 * @see com.ext.portlet.saveprocesstype.model.impl.SaveProcessTypeImpl
 * @see com.ext.portlet.saveprocesstype.model.impl.SaveProcessTypeModelImpl
 *
 */
public interface SaveProcessTypeModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getSptId();

    public void setSptId(long sptId);

    public long getDocId();

    public void setDocId(long docId);

    public long getFlagProcessType();

    public void setFlagProcessType(long flagProcessType);

    public boolean getFlag();

    public boolean isFlag();

    public void setFlag(boolean flag);

    public SaveProcessType toEscapedModel();
}
