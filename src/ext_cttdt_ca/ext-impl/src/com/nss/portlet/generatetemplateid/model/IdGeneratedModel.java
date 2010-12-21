package com.nss.portlet.generatetemplateid.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="IdGeneratedModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>IdGenerated</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.generatetemplateid.model.IdGenerated
 * @see com.nss.portlet.generatetemplateid.model.impl.IdGeneratedImpl
 * @see com.nss.portlet.generatetemplateid.model.impl.IdGeneratedModelImpl
 *
 */
public interface IdGeneratedModel extends BaseModel<IdGenerated> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getId();

    public void setId(long id);

    public String getYear();

    public void setYear(String year);

    public long getCurValue();

    public void setCurValue(long curValue);

    public IdGenerated toEscapedModel();
}
