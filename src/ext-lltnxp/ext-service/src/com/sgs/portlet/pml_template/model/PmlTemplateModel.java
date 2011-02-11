package com.sgs.portlet.pml_template.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlTemplateModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlTemplate</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.model.PmlTemplate
 * @see com.sgs.portlet.pml_template.model.impl.PmlTemplateImpl
 * @see com.sgs.portlet.pml_template.model.impl.PmlTemplateModelImpl
 *
 */
public interface PmlTemplateModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getTemplateId();

    public void setTemplateId(long templateId);

    public String getTemplateCode();

    public void setTemplateCode(String templateCode);

    public String getTemplateName();

    public void setTemplateName(String templateName);

    public int getNumberOfDocument();

    public void setNumberOfDocument(int numberOfDocument);

    public Date getPublishDate();

    public void setPublishDate(Date publishDate);

    public String getDepartmentId();

    public void setDepartmentId(String departmentId);

    public PmlTemplate toEscapedModel();
}
