package com.nss.portlet.generatetemplateid.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.generatetemplateid.model.IdTemplate;
import com.nss.portlet.generatetemplateid.model.IdTemplateSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="IdTemplateModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>IdTemplate</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.generatetemplateid.model.IdTemplate
 * @see com.nss.portlet.generatetemplateid.model.IdTemplateModel
 * @see com.nss.portlet.generatetemplateid.model.impl.IdTemplateImpl
 *
 */
public class IdTemplateModelImpl extends BaseModelImpl<IdTemplate> {
    public static final String TABLE_NAME = "pml_idtemplate";
    public static final Object[][] TABLE_COLUMNS = {
            { "templateId", new Integer(Types.BIGINT) },
            

            { "format", new Integer(Types.VARCHAR) },
            

            { "startNumber", new Integer(Types.VARCHAR) },
            

            { "len", new Integer(Types.BIGINT) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_idtemplate (templateId LONG not null primary key,format VARCHAR(75) null,startNumber VARCHAR(75) null,len LONG,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_idtemplate";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.generatetemplateid.model.IdTemplate"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.generatetemplateid.model.IdTemplate"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.generatetemplateid.model.IdTemplate"));
    private long _templateId;
    private String _format;
    private String _startNumber;
    private long _len;
    private String _description;
    private transient ExpandoBridge _expandoBridge;

    public IdTemplateModelImpl() {
    }

    public static IdTemplate toModel(IdTemplateSoap soapModel) {
        IdTemplate model = new IdTemplateImpl();

        model.setTemplateId(soapModel.getTemplateId());
        model.setFormat(soapModel.getFormat());
        model.setStartNumber(soapModel.getStartNumber());
        model.setLen(soapModel.getLen());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<IdTemplate> toModels(IdTemplateSoap[] soapModels) {
        List<IdTemplate> models = new ArrayList<IdTemplate>(soapModels.length);

        for (IdTemplateSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _templateId;
    }

    public void setPrimaryKey(long pk) {
        setTemplateId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_templateId);
    }

    public long getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(long templateId) {
        _templateId = templateId;
    }

    public String getFormat() {
        return GetterUtil.getString(_format);
    }

    public void setFormat(String format) {
        _format = format;
    }

    public String getStartNumber() {
        return GetterUtil.getString(_startNumber);
    }

    public void setStartNumber(String startNumber) {
        _startNumber = startNumber;
    }

    public long getLen() {
        return _len;
    }

    public void setLen(long len) {
        _len = len;
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        _description = description;
    }

    public IdTemplate toEscapedModel() {
        if (isEscapedModel()) {
            return (IdTemplate) this;
        } else {
            IdTemplate model = new IdTemplateImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setTemplateId(getTemplateId());
            model.setFormat(HtmlUtil.escape(getFormat()));
            model.setStartNumber(HtmlUtil.escape(getStartNumber()));
            model.setLen(getLen());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (IdTemplate) Proxy.newProxyInstance(IdTemplate.class.getClassLoader(),
                    new Class[] { IdTemplate.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(IdTemplate.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        IdTemplateImpl clone = new IdTemplateImpl();

        clone.setTemplateId(getTemplateId());
        clone.setFormat(getFormat());
        clone.setStartNumber(getStartNumber());
        clone.setLen(getLen());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(IdTemplate idTemplate) {
        long pk = idTemplate.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        IdTemplate idTemplate = null;

        try {
            idTemplate = (IdTemplate) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = idTemplate.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{templateId=");
        sb.append(getTemplateId());
        sb.append(", format=");
        sb.append(getFormat());
        sb.append(", startNumber=");
        sb.append(getStartNumber());
        sb.append(", len=");
        sb.append(getLen());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.generatetemplateid.model.IdTemplate");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>templateId</column-name><column-value><![CDATA[");
        sb.append(getTemplateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>format</column-name><column-value><![CDATA[");
        sb.append(getFormat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startNumber</column-name><column-value><![CDATA[");
        sb.append(getStartNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>len</column-name><column-value><![CDATA[");
        sb.append(getLen());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
