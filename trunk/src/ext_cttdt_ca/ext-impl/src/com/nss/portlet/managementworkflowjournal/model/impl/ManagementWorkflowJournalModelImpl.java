package com.nss.portlet.managementworkflowjournal.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournalSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ManagementWorkflowJournalModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ManagementWorkflowJournal</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal
 * @see com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournalModel
 * @see com.nss.portlet.managementworkflowjournal.model.impl.ManagementWorkflowJournalImpl
 *
 */
public class ManagementWorkflowJournalModelImpl extends BaseModelImpl<ManagementWorkflowJournal> {
    public static final String TABLE_NAME = "nss_quan_ly_quy_trinh_duyet_tin";
    public static final Object[][] TABLE_COLUMNS = {
            { "managementWorkflowJournalId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "processDefinitionId", new Integer(Types.BIGINT) },
            

            { "workflowname", new Integer(Types.VARCHAR) },
            

            { "version_", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "dateFrom", new Integer(Types.TIMESTAMP) },
            

            { "dateTo", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_quan_ly_quy_trinh_duyet_tin (managementWorkflowJournalId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,processDefinitionId LONG,workflowname VARCHAR(75) null,version_ INTEGER,description VARCHAR(75) null,dateFrom DATE null,dateTo DATE null)";
    public static final String TABLE_SQL_DROP = "drop table nss_quan_ly_quy_trinh_duyet_tin";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal"));
    private long _managementWorkflowJournalId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private long _processDefinitionId;
    private String _workflowname;
    private String _originalWorkflowname;
    private int _version_;
    private int _originalVersion_;
    private boolean _setOriginalVersion_;
    private String _description;
    private Date _dateFrom;
    private Date _dateTo;
    private transient ExpandoBridge _expandoBridge;

    public ManagementWorkflowJournalModelImpl() {
    }

    public static ManagementWorkflowJournal toModel(
        ManagementWorkflowJournalSoap soapModel) {
        ManagementWorkflowJournal model = new ManagementWorkflowJournalImpl();

        model.setManagementWorkflowJournalId(soapModel.getManagementWorkflowJournalId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setProcessDefinitionId(soapModel.getProcessDefinitionId());
        model.setWorkflowname(soapModel.getWorkflowname());
        model.setVersion_(soapModel.getVersion_());
        model.setDescription(soapModel.getDescription());
        model.setDateFrom(soapModel.getDateFrom());
        model.setDateTo(soapModel.getDateTo());

        return model;
    }

    public static List<ManagementWorkflowJournal> toModels(
        ManagementWorkflowJournalSoap[] soapModels) {
        List<ManagementWorkflowJournal> models = new ArrayList<ManagementWorkflowJournal>(soapModels.length);

        for (ManagementWorkflowJournalSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _managementWorkflowJournalId;
    }

    public void setPrimaryKey(long pk) {
        setManagementWorkflowJournalId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_managementWorkflowJournalId);
    }

    public long getManagementWorkflowJournalId() {
        return _managementWorkflowJournalId;
    }

    public void setManagementWorkflowJournalId(long managementWorkflowJournalId) {
        _managementWorkflowJournalId = managementWorkflowJournalId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getProcessDefinitionId() {
        return _processDefinitionId;
    }

    public void setProcessDefinitionId(long processDefinitionId) {
        _processDefinitionId = processDefinitionId;
    }

    public String getWorkflowname() {
        return GetterUtil.getString(_workflowname);
    }

    public void setWorkflowname(String workflowname) {
        _workflowname = workflowname;

        if (_originalWorkflowname == null) {
            _originalWorkflowname = workflowname;
        }
    }

    public String getOriginalWorkflowname() {
        return GetterUtil.getString(_originalWorkflowname);
    }

    public int getVersion_() {
        return _version_;
    }

    public void setVersion_(int version_) {
        _version_ = version_;

        if (!_setOriginalVersion_) {
            _setOriginalVersion_ = true;

            _originalVersion_ = version_;
        }
    }

    public int getOriginalVersion_() {
        return _originalVersion_;
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Date getDateFrom() {
        return _dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        _dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return _dateTo;
    }

    public void setDateTo(Date dateTo) {
        _dateTo = dateTo;
    }

    public ManagementWorkflowJournal toEscapedModel() {
        if (isEscapedModel()) {
            return (ManagementWorkflowJournal) this;
        } else {
            ManagementWorkflowJournal model = new ManagementWorkflowJournalImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setManagementWorkflowJournalId(getManagementWorkflowJournalId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setProcessDefinitionId(getProcessDefinitionId());
            model.setWorkflowname(HtmlUtil.escape(getWorkflowname()));
            model.setVersion_(getVersion_());
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setDateFrom(getDateFrom());
            model.setDateTo(getDateTo());

            model = (ManagementWorkflowJournal) Proxy.newProxyInstance(ManagementWorkflowJournal.class.getClassLoader(),
                    new Class[] { ManagementWorkflowJournal.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(ManagementWorkflowJournal.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        ManagementWorkflowJournalImpl clone = new ManagementWorkflowJournalImpl();

        clone.setManagementWorkflowJournalId(getManagementWorkflowJournalId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setProcessDefinitionId(getProcessDefinitionId());
        clone.setWorkflowname(getWorkflowname());
        clone.setVersion_(getVersion_());
        clone.setDescription(getDescription());
        clone.setDateFrom(getDateFrom());
        clone.setDateTo(getDateTo());

        return clone;
    }

    public int compareTo(ManagementWorkflowJournal managementWorkflowJournal) {
        int value = 0;

        if (getVersion_() < managementWorkflowJournal.getVersion_()) {
            value = -1;
        } else if (getVersion_() > managementWorkflowJournal.getVersion_()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ManagementWorkflowJournal managementWorkflowJournal = null;

        try {
            managementWorkflowJournal = (ManagementWorkflowJournal) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = managementWorkflowJournal.getPrimaryKey();

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

        sb.append("{managementWorkflowJournalId=");
        sb.append(getManagementWorkflowJournalId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", processDefinitionId=");
        sb.append(getProcessDefinitionId());
        sb.append(", workflowname=");
        sb.append(getWorkflowname());
        sb.append(", version_=");
        sb.append(getVersion_());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", dateFrom=");
        sb.append(getDateFrom());
        sb.append(", dateTo=");
        sb.append(getDateTo());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append(
            "com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>managementWorkflowJournalId</column-name><column-value><![CDATA[");
        sb.append(getManagementWorkflowJournalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>processDefinitionId</column-name><column-value><![CDATA[");
        sb.append(getProcessDefinitionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>workflowname</column-name><column-value><![CDATA[");
        sb.append(getWorkflowname());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version_</column-name><column-value><![CDATA[");
        sb.append(getVersion_());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateFrom</column-name><column-value><![CDATA[");
        sb.append(getDateFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateTo</column-name><column-value><![CDATA[");
        sb.append(getDateTo());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
