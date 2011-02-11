package com.sgs.portlet.field.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlFieldModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlField</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.field.model.PmlField
 * @see com.sgs.portlet.field.model.impl.PmlFieldImpl
 * @see com.sgs.portlet.field.model.impl.PmlFieldModelImpl
 *
 */
public interface PmlFieldModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getFieldId();

    public void setFieldId(String fieldId);

    public String getFieldCode();

    public void setFieldCode(String fieldCode);

    public String getFieldName();

    public void setFieldName(String fieldName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public PmlField toEscapedModel();
}
