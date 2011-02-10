package com.sgs.portlet.filetype.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.model.PmlFileTypeSoap;

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
 * @see com.sgs.portlet.filetype.model.PmlFileType
 * @see com.sgs.portlet.filetype.model.PmlFileTypeModel
 * @see com.sgs.portlet.filetype.model.impl.PmlFileTypeImpl
 *
 */
public class PmlFileTypeModelImpl extends BaseModelImpl {
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
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.filetype.model.PmlFileType"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.filetype.model.PmlFileType"));
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
        if (((fileTypeId == null) && (_fileTypeId != null)) ||
                ((fileTypeId != null) && (_fileTypeId == null)) ||
                ((fileTypeId != null) && (_fileTypeId != null) &&
                !fileTypeId.equals(_fileTypeId))) {
            _fileTypeId = fileTypeId;
        }
    }

    public String getFileTypeCode() {
        return GetterUtil.getString(_fileTypeCode);
    }

    public void setFileTypeCode(String fileTypeCode) {
        if (((fileTypeCode == null) && (_fileTypeCode != null)) ||
                ((fileTypeCode != null) && (_fileTypeCode == null)) ||
                ((fileTypeCode != null) && (_fileTypeCode != null) &&
                !fileTypeCode.equals(_fileTypeCode))) {
            _fileTypeCode = fileTypeCode;
        }
    }

    public String getFileTypeName() {
        return GetterUtil.getString(_fileTypeName);
    }

    public void setFileTypeName(String fileTypeName) {
        if (((fileTypeName == null) && (_fileTypeName != null)) ||
                ((fileTypeName != null) && (_fileTypeName == null)) ||
                ((fileTypeName != null) && (_fileTypeName != null) &&
                !fileTypeName.equals(_fileTypeName))) {
            _fileTypeName = fileTypeName;
        }
    }

    public String getFieldId() {
        return GetterUtil.getString(_fieldId);
    }

    public void setFieldId(String fieldId) {
        if (((fieldId == null) && (_fieldId != null)) ||
                ((fieldId != null) && (_fieldId == null)) ||
                ((fieldId != null) && (_fieldId != null) &&
                !fieldId.equals(_fieldId))) {
            _fieldId = fieldId;
        }
    }

    public String getTemplateId() {
        return GetterUtil.getString(_templateId);
    }

    public void setTemplateId(String templateId) {
        if (((templateId == null) && (_templateId != null)) ||
                ((templateId != null) && (_templateId == null)) ||
                ((templateId != null) && (_templateId != null) &&
                !templateId.equals(_templateId))) {
            _templateId = templateId;
        }
    }

    public String getProcessTime() {
        return GetterUtil.getString(_processTime);
    }

    public void setProcessTime(String processTime) {
        if (((processTime == null) && (_processTime != null)) ||
                ((processTime != null) && (_processTime == null)) ||
                ((processTime != null) && (_processTime != null) &&
                !processTime.equals(_processTime))) {
            _processTime = processTime;
        }
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        if (((description == null) && (_description != null)) ||
                ((description != null) && (_description == null)) ||
                ((description != null) && (_description != null) &&
                !description.equals(_description))) {
            _description = description;
        }
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        if (((active == null) && (_active != null)) ||
                ((active != null) && (_active == null)) ||
                ((active != null) && (_active != null) &&
                !active.equals(_active))) {
            _active = active;
        }
    }

    public String getCurrentReceiptNumber() {
        return GetterUtil.getString(_currentReceiptNumber);
    }

    public void setCurrentReceiptNumber(String currentReceiptNumber) {
        if (((currentReceiptNumber == null) && (_currentReceiptNumber != null)) ||
                ((currentReceiptNumber != null) &&
                (_currentReceiptNumber == null)) ||
                ((currentReceiptNumber != null) &&
                (_currentReceiptNumber != null) &&
                !currentReceiptNumber.equals(_currentReceiptNumber))) {
            _currentReceiptNumber = currentReceiptNumber;
        }
    }

    public String getReceiptTemplate() {
        return GetterUtil.getString(_receiptTemplate);
    }

    public void setReceiptTemplate(String receiptTemplate) {
        if (((receiptTemplate == null) && (_receiptTemplate != null)) ||
                ((receiptTemplate != null) && (_receiptTemplate == null)) ||
                ((receiptTemplate != null) && (_receiptTemplate != null) &&
                !receiptTemplate.equals(_receiptTemplate))) {
            _receiptTemplate = receiptTemplate;
        }
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

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFileTypeImpl pmlFileType = (PmlFileTypeImpl) obj;

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

        PmlFileTypeImpl pmlFileType = null;

        try {
            pmlFileType = (PmlFileTypeImpl) obj;
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
}
