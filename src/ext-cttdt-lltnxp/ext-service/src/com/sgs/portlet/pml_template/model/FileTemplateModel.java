package com.sgs.portlet.pml_template.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="FileTemplateModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>FileTemplate</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.model.FileTemplate
 * @see com.sgs.portlet.pml_template.model.impl.FileTemplateImpl
 * @see com.sgs.portlet.pml_template.model.impl.FileTemplateModelImpl
 *
 */
public interface FileTemplateModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getFileTemplateId();

    public void setFileTemplateId(long fileTemplateId);

    public long getTemplateId();

    public void setTemplateId(long templateId);

    public String getTenFile();

    public void setTenFile(String tenFile);

    public long getKichThuoc();

    public void setKichThuoc(long kichThuoc);

    public String getDuongDan();

    public void setDuongDan(String duongDan);

    public FileTemplate toEscapedModel();
}
