package com.sgs.portlet.pml_template.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pml_template.model.PmlTemplate;
import com.sgs.portlet.pml_template.model.PmlTemplateSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlTemplateModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlTemplate</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_template.model.PmlTemplate
 * @see com.sgs.portlet.pml_template.model.PmlTemplateModel
 * @see com.sgs.portlet.pml_template.model.impl.PmlTemplateImpl
 *
 */
public class PmlTemplateModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_template";
    public static final Object[][] TABLE_COLUMNS = {
            { "templateId", new Integer(Types.BIGINT) },
            

            { "templateCode", new Integer(Types.VARCHAR) },
            

            { "templateName", new Integer(Types.VARCHAR) },
            

            { "numberOfDocument", new Integer(Types.INTEGER) },
            

            { "publishDate", new Integer(Types.TIMESTAMP) },
            

            { "departmentId", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_template (templateId LONG not null primary key,templateCode VARCHAR(75) null,templateName VARCHAR(75) null,numberOfDocument INTEGER,publishDate DATE null,departmentId VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_template";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pml_template.model.PmlTemplate"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pml_template.model.PmlTemplate"));
    private long _templateId;
    private String _templateCode;
    private String _templateName;
    private int _numberOfDocument;
    private Date _publishDate;
    private String _departmentId;

    public PmlTemplateModelImpl() {
    }

    public static PmlTemplate toModel(PmlTemplateSoap soapModel) {
        PmlTemplate model = new PmlTemplateImpl();

        model.setTemplateId(soapModel.getTemplateId());
        model.setTemplateCode(soapModel.getTemplateCode());
        model.setTemplateName(soapModel.getTemplateName());
        model.setNumberOfDocument(soapModel.getNumberOfDocument());
        model.setPublishDate(soapModel.getPublishDate());
        model.setDepartmentId(soapModel.getDepartmentId());

        return model;
    }

    public static List<PmlTemplate> toModels(PmlTemplateSoap[] soapModels) {
        List<PmlTemplate> models = new ArrayList<PmlTemplate>(soapModels.length);

        for (PmlTemplateSoap soapModel : soapModels) {
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
        if (templateId != _templateId) {
            _templateId = templateId;
        }
    }

    public String getTemplateCode() {
        return GetterUtil.getString(_templateCode);
    }

    public void setTemplateCode(String templateCode) {
        if (((templateCode == null) && (_templateCode != null)) ||
                ((templateCode != null) && (_templateCode == null)) ||
                ((templateCode != null) && (_templateCode != null) &&
                !templateCode.equals(_templateCode))) {
            _templateCode = templateCode;
        }
    }

    public String getTemplateName() {
        return GetterUtil.getString(_templateName);
    }

    public void setTemplateName(String templateName) {
        if (((templateName == null) && (_templateName != null)) ||
                ((templateName != null) && (_templateName == null)) ||
                ((templateName != null) && (_templateName != null) &&
                !templateName.equals(_templateName))) {
            _templateName = templateName;
        }
    }

    public int getNumberOfDocument() {
        return _numberOfDocument;
    }

    public void setNumberOfDocument(int numberOfDocument) {
        if (numberOfDocument != _numberOfDocument) {
            _numberOfDocument = numberOfDocument;
        }
    }

    public Date getPublishDate() {
        return _publishDate;
    }

    public void setPublishDate(Date publishDate) {
        if (((publishDate == null) && (_publishDate != null)) ||
                ((publishDate != null) && (_publishDate == null)) ||
                ((publishDate != null) && (_publishDate != null) &&
                !publishDate.equals(_publishDate))) {
            _publishDate = publishDate;
        }
    }

    public String getDepartmentId() {
        return GetterUtil.getString(_departmentId);
    }

    public void setDepartmentId(String departmentId) {
        if (((departmentId == null) && (_departmentId != null)) ||
                ((departmentId != null) && (_departmentId == null)) ||
                ((departmentId != null) && (_departmentId != null) &&
                !departmentId.equals(_departmentId))) {
            _departmentId = departmentId;
        }
    }

    public PmlTemplate toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlTemplate) this;
        } else {
            PmlTemplate model = new PmlTemplateImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setTemplateId(getTemplateId());
            model.setTemplateCode(HtmlUtil.escape(getTemplateCode()));
            model.setTemplateName(HtmlUtil.escape(getTemplateName()));
            model.setNumberOfDocument(getNumberOfDocument());
            model.setPublishDate(getPublishDate());
            model.setDepartmentId(HtmlUtil.escape(getDepartmentId()));

            model = (PmlTemplate) Proxy.newProxyInstance(PmlTemplate.class.getClassLoader(),
                    new Class[] { PmlTemplate.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlTemplateImpl clone = new PmlTemplateImpl();

        clone.setTemplateId(getTemplateId());
        clone.setTemplateCode(getTemplateCode());
        clone.setTemplateName(getTemplateName());
        clone.setNumberOfDocument(getNumberOfDocument());
        clone.setPublishDate(getPublishDate());
        clone.setDepartmentId(getDepartmentId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlTemplateImpl pmlTemplate = (PmlTemplateImpl) obj;

        long pk = pmlTemplate.getPrimaryKey();

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

        PmlTemplateImpl pmlTemplate = null;

        try {
            pmlTemplate = (PmlTemplateImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlTemplate.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
