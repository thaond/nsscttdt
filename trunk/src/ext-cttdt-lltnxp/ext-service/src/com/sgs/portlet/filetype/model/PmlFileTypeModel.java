package com.sgs.portlet.filetype.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlFileTypeModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFileType</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.filetype.model.PmlFileType
 * @see com.sgs.portlet.filetype.model.impl.PmlFileTypeImpl
 * @see com.sgs.portlet.filetype.model.impl.PmlFileTypeModelImpl
 *
 */
public interface PmlFileTypeModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getFileTypeId();

    public void setFileTypeId(String fileTypeId);

    public String getFileTypeCode();

    public void setFileTypeCode(String fileTypeCode);

    public String getFileTypeName();

    public void setFileTypeName(String fileTypeName);

    public String getFieldId();

    public void setFieldId(String fieldId);

    public String getTemplateId();

    public void setTemplateId(String templateId);

    public String getProcessTime();

    public void setProcessTime(String processTime);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public String getCurrentReceiptNumber();

    public void setCurrentReceiptNumber(String currentReceiptNumber);

    public String getReceiptTemplate();

    public void setReceiptTemplate(String receiptTemplate);

    public PmlFileType toEscapedModel();
}
