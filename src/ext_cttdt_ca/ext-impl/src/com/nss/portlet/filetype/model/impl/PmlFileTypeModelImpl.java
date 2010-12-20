package com.nss.portlet.filetype.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.model.PmlFileTypeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileTypeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFileType</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.model.PmlFileType
 * @see com.nss.portlet.filetype.model.PmlFileTypeModel
 * @see com.nss.portlet.filetype.model.impl.PmlFileTypeImpl
 *
 */
public class PmlFileTypeModelImpl extends BaseModelImpl<PmlFileType> {
    public static final String TABLE_NAME = "pml_filetype";
    public static final Object[][] TABLE_COLUMNS = {
            { "fileTypeId", new Integer(Types.VARCHAR) },
            

            { "fileTypeCode", new Integer(Types.VARCHAR) },
            

            { "fileTypeName", new Integer(Types.VARCHAR) },
            

            { "fieldId", new Integer(Types.VARCHAR) },
            

            { "templateId", new Integer(Types.VARCHAR) },
            

            { "processTime", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "currentReceiptNumber", new Integer(Types.VARCHAR) },
            

            { "receiptTemplate", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_filetype (fileTypeId VARCHAR(75) not null primary key,fileTypeCode VARCHAR(75) null,fileTypeName VARCHAR(75) null,fieldId VARCHAR(75) null,templateId VARCHAR(75) null,processTime VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null,currentReceiptNumber VARCHAR(75) null,receiptTemplate VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_filetype";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.filetype.model.PmlFileType"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.filetype.model.PmlFileType"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.filetype.model.PmlFileType"));
    private String _fileTypeId;
    private String _fileTypeCode;
    private String _fileTypeName;
    private String _fieldId;
    private String _templateId;
    private String _processTime;
    private String _description;
    private String _active;
    private String _currentReceiptNumber;
    private String _receiptTemplate;

    public PmlFileTypeModelImpl() {
    }

    public static PmlFileType toModel(PmlFileTypeSoap soapModel) {
        PmlFileType model = new PmlFileTypeImpl();

        model.setFileTypeId(soapModel.getFileTypeId());
        model.setFileTypeCode(soapModel.getFileTypeCode());
        model.setFileTypeName(soapModel.getFileTypeName());
        model.setFieldId(soapModel.getFieldId());
        model.setTemplateId(soapModel.getTemplateId());
        model.setProcessTime(soapModel.getProcessTime());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());
        model.setCurrentReceiptNumber(soapModel.getCurrentReceiptNumber());
        model.setReceiptTemplate(soapModel.getReceiptTemplate());

        return model;
    }

    public static List<PmlFileType> toModels(PmlFileTypeSoap[] soapModels) {
        List<PmlFileType> models = new ArrayList<PmlFileType>(soapModels.length);

        for (PmlFileTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _fileTypeId;
    }

    public void setPrimaryKey(String pk) {
        setFileTypeId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _fileTypeId;
    }

    public String getFileTypeId() {
        return GetterUtil.getString(_fileTypeId);
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public String getFileTypeCode() {
        return GetterUtil.getString(_fileTypeCode);
    }

    public void setFileTypeCode(String fileTypeCode) {
        _fileTypeCode = fileTypeCode;
    }

    public String getFileTypeName() {
        return GetterUtil.getString(_fileTypeName);
    }

    public void setFileTypeName(String fileTypeName) {
        _fileTypeName = fileTypeName;
    }

    public String getFieldId() {
        return GetterUtil.getString(_fieldId);
    }

    public void setFieldId(String fieldId) {
        _fieldId = fieldId;
    }

    public String getTemplateId() {
        return GetterUtil.getString(_templateId);
    }

    public void setTemplateId(String templateId) {
        _templateId = templateId;
    }

    public String getProcessTime() {
        return GetterUtil.getString(_processTime);
    }

    public void setProcessTime(String processTime) {
        _processTime = processTime;
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        _active = active;
    }

    public String getCurrentReceiptNumber() {
        return GetterUtil.getString(_currentReceiptNumber);
    }

    public void setCurrentReceiptNumber(String currentReceiptNumber) {
        _currentReceiptNumber = currentReceiptNumber;
    }

    public String getReceiptTemplate() {
        return GetterUtil.getString(_receiptTemplate);
    }

    public void setReceiptTemplate(String receiptTemplate) {
        _receiptTemplate = receiptTemplate;
    }

    public PmlFileType toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFileType) this;
        } else {
            PmlFileType model = new PmlFileTypeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileTypeId(HtmlUtil.escape(getFileTypeId()));
            model.setFileTypeCode(HtmlUtil.escape(getFileTypeCode()));
            model.setFileTypeName(HtmlUtil.escape(getFileTypeName()));
            model.setFieldId(HtmlUtil.escape(getFieldId()));
            model.setTemplateId(HtmlUtil.escape(getTemplateId()));
            model.setProcessTime(HtmlUtil.escape(getProcessTime()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setCurrentReceiptNumber(HtmlUtil.escape(
                    getCurrentReceiptNumber()));
            model.setReceiptTemplate(HtmlUtil.escape(getReceiptTemplate()));

            model = (PmlFileType) Proxy.newProxyInstance(PmlFileType.class.getClassLoader(),
                    new Class[] { PmlFileType.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlFileTypeImpl clone = new PmlFileTypeImpl();

        clone.setFileTypeId(getFileTypeId());
        clone.setFileTypeCode(getFileTypeCode());
        clone.setFileTypeName(getFileTypeName());
        clone.setFieldId(getFieldId());
        clone.setTemplateId(getTemplateId());
        clone.setProcessTime(getProcessTime());
        clone.setDescription(getDescription());
        clone.setActive(getActive());
        clone.setCurrentReceiptNumber(getCurrentReceiptNumber());
        clone.setReceiptTemplate(getReceiptTemplate());

        return clone;
    }

    public int compareTo(PmlFileType pmlFileType) {
        int value = 0;

        value = getFileTypeName().toLowerCase()
                    .compareTo(pmlFileType.getFileTypeName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlFileType pmlFileType = null;

        try {
            pmlFileType = (PmlFileType) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlFileType.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{fileTypeId=");
        sb.append(getFileTypeId());
        sb.append(", fileTypeCode=");
        sb.append(getFileTypeCode());
        sb.append(", fileTypeName=");
        sb.append(getFileTypeName());
        sb.append(", fieldId=");
        sb.append(getFieldId());
        sb.append(", templateId=");
        sb.append(getTemplateId());
        sb.append(", processTime=");
        sb.append(getProcessTime());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", currentReceiptNumber=");
        sb.append(getCurrentReceiptNumber());
        sb.append(", receiptTemplate=");
        sb.append(getReceiptTemplate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.filetype.model.PmlFileType");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fileTypeId</column-name><column-value><![CDATA[");
        sb.append(getFileTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileTypeCode</column-name><column-value><![CDATA[");
        sb.append(getFileTypeCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileTypeName</column-name><column-value><![CDATA[");
        sb.append(getFileTypeName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fieldId</column-name><column-value><![CDATA[");
        sb.append(getFieldId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>templateId</column-name><column-value><![CDATA[");
        sb.append(getTemplateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>processTime</column-name><column-value><![CDATA[");
        sb.append(getProcessTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currentReceiptNumber</column-name><column-value><![CDATA[");
        sb.append(getCurrentReceiptNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiptTemplate</column-name><column-value><![CDATA[");
        sb.append(getReceiptTemplate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
