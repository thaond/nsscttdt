package com.sgs.portlet.field.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.model.PmlFieldSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFieldModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlField</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.field.model.PmlField
 * @see com.sgs.portlet.field.model.PmlFieldModel
 * @see com.sgs.portlet.field.model.impl.PmlFieldImpl
 *
 */
public class PmlFieldModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_field";
    public static final Object[][] TABLE_COLUMNS = {
            { "fieldId", new Integer(Types.VARCHAR) },
            

            { "fieldCode", new Integer(Types.VARCHAR) },
            

            { "fieldName", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "departmentsId", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_field (fieldId VARCHAR(75) not null primary key,fieldCode VARCHAR(75) null,fieldName VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null,departmentsId VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_field";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.field.model.PmlField"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.field.model.PmlField"));
    private String _fieldId;
    private String _fieldCode;
    private String _fieldName;
    private String _description;
    private String _active;
    private String _departmentsId;

    public PmlFieldModelImpl() {
    }

    public static PmlField toModel(PmlFieldSoap soapModel) {
        PmlField model = new PmlFieldImpl();

        model.setFieldId(soapModel.getFieldId());
        model.setFieldCode(soapModel.getFieldCode());
        model.setFieldName(soapModel.getFieldName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());
        model.setDepartmentsId(soapModel.getDepartmentsId());

        return model;
    }

    public static List<PmlField> toModels(PmlFieldSoap[] soapModels) {
        List<PmlField> models = new ArrayList<PmlField>(soapModels.length);

        for (PmlFieldSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _fieldId;
    }

    public void setPrimaryKey(String pk) {
        setFieldId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _fieldId;
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

    public String getFieldCode() {
        return GetterUtil.getString(_fieldCode);
    }

    public void setFieldCode(String fieldCode) {
        if (((fieldCode == null) && (_fieldCode != null)) ||
                ((fieldCode != null) && (_fieldCode == null)) ||
                ((fieldCode != null) && (_fieldCode != null) &&
                !fieldCode.equals(_fieldCode))) {
            _fieldCode = fieldCode;
        }
    }

    public String getFieldName() {
        return GetterUtil.getString(_fieldName);
    }

    public void setFieldName(String fieldName) {
        if (((fieldName == null) && (_fieldName != null)) ||
                ((fieldName != null) && (_fieldName == null)) ||
                ((fieldName != null) && (_fieldName != null) &&
                !fieldName.equals(_fieldName))) {
            _fieldName = fieldName;
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

    public String getDepartmentsId() {
        return GetterUtil.getString(_departmentsId);
    }

    public void setDepartmentsId(String departmentsId) {
        if (((departmentsId == null) && (_departmentsId != null)) ||
                ((departmentsId != null) && (_departmentsId == null)) ||
                ((departmentsId != null) && (_departmentsId != null) &&
                !departmentsId.equals(_departmentsId))) {
            _departmentsId = departmentsId;
        }
    }

    public PmlField toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlField) this;
        } else {
            PmlField model = new PmlFieldImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFieldId(HtmlUtil.escape(getFieldId()));
            model.setFieldCode(HtmlUtil.escape(getFieldCode()));
            model.setFieldName(HtmlUtil.escape(getFieldName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));

            model = (PmlField) Proxy.newProxyInstance(PmlField.class.getClassLoader(),
                    new Class[] { PmlField.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlFieldImpl clone = new PmlFieldImpl();

        clone.setFieldId(getFieldId());
        clone.setFieldCode(getFieldCode());
        clone.setFieldName(getFieldName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());
        clone.setDepartmentsId(getDepartmentsId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFieldImpl pmlField = (PmlFieldImpl) obj;

        int value = 0;

        value = getFieldName().toLowerCase()
                    .compareTo(pmlField.getFieldName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlFieldImpl pmlField = null;

        try {
            pmlField = (PmlFieldImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlField.getPrimaryKey();

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
