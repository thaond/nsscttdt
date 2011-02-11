package com.sgs.portlet.generatetemplateid.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="IdTemplateModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>IdTemplate</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.generatetemplateid.model.IdTemplate
 * @see com.sgs.portlet.generatetemplateid.model.impl.IdTemplateImpl
 * @see com.sgs.portlet.generatetemplateid.model.impl.IdTemplateModelImpl
 *
 */
public interface IdTemplateModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getTemplateId();

    public void setTemplateId(long templateId);

    public String getFormat();

    public void setFormat(String format);

    public String getStartNumber();

    public void setStartNumber(String startNumber);

    public long getLen();

    public void setLen(long len);

    public String getDescription();

    public void setDescription(String description);

    public IdTemplate toEscapedModel();
}
