package com.nss.portlet.managementworkflowjournal.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticleSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="WorkflowJournalArticleModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>WorkflowJournalArticle</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle
 * @see com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticleModel
 * @see com.nss.portlet.managementworkflowjournal.model.impl.WorkflowJournalArticleImpl
 *
 */
public class WorkflowJournalArticleModelImpl extends BaseModelImpl<WorkflowJournalArticle> {
    public static final String TABLE_NAME = "nss_workflow_journal_article";
    public static final Object[][] TABLE_COLUMNS = {
            { "workflowJournalArticleId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "roleId", new Integer(Types.BIGINT) },
            

            { "processDefinitionId", new Integer(Types.BIGINT) },
            

            { "processInstanceId", new Integer(Types.BIGINT) },
            

            { "resourcePrimkey", new Integer(Types.BIGINT) },
            

            { "journalType", new Integer(Types.VARCHAR) },
            

            { "countImageOfArticle", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_workflow_journal_article (workflowJournalArticleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,roleId LONG,processDefinitionId LONG,processInstanceId LONG,resourcePrimkey LONG,journalType VARCHAR(75) null,countImageOfArticle INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_workflow_journal_article";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle"));
    private long _workflowJournalArticleId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private long _roleId;
    private long _processDefinitionId;
    private long _processInstanceId;
    private long _originalProcessInstanceId;
    private boolean _setOriginalProcessInstanceId;
    private long _resourcePrimkey;
    private long _originalResourcePrimkey;
    private boolean _setOriginalResourcePrimkey;
    private String _journalType;
    private int _countImageOfArticle;
    private transient ExpandoBridge _expandoBridge;

    public WorkflowJournalArticleModelImpl() {
    }

    public static WorkflowJournalArticle toModel(
        WorkflowJournalArticleSoap soapModel) {
        WorkflowJournalArticle model = new WorkflowJournalArticleImpl();

        model.setWorkflowJournalArticleId(soapModel.getWorkflowJournalArticleId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setRoleId(soapModel.getRoleId());
        model.setProcessDefinitionId(soapModel.getProcessDefinitionId());
        model.setProcessInstanceId(soapModel.getProcessInstanceId());
        model.setResourcePrimkey(soapModel.getResourcePrimkey());
        model.setJournalType(soapModel.getJournalType());
        model.setCountImageOfArticle(soapModel.getCountImageOfArticle());

        return model;
    }

    public static List<WorkflowJournalArticle> toModels(
        WorkflowJournalArticleSoap[] soapModels) {
        List<WorkflowJournalArticle> models = new ArrayList<WorkflowJournalArticle>(soapModels.length);

        for (WorkflowJournalArticleSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _workflowJournalArticleId;
    }

    public void setPrimaryKey(long pk) {
        setWorkflowJournalArticleId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_workflowJournalArticleId);
    }

    public long getWorkflowJournalArticleId() {
        return _workflowJournalArticleId;
    }

    public void setWorkflowJournalArticleId(long workflowJournalArticleId) {
        _workflowJournalArticleId = workflowJournalArticleId;
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

    public long getRoleId() {
        return _roleId;
    }

    public void setRoleId(long roleId) {
        _roleId = roleId;
    }

    public long getProcessDefinitionId() {
        return _processDefinitionId;
    }

    public void setProcessDefinitionId(long processDefinitionId) {
        _processDefinitionId = processDefinitionId;
    }

    public long getProcessInstanceId() {
        return _processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        _processInstanceId = processInstanceId;

        if (!_setOriginalProcessInstanceId) {
            _setOriginalProcessInstanceId = true;

            _originalProcessInstanceId = processInstanceId;
        }
    }

    public long getOriginalProcessInstanceId() {
        return _originalProcessInstanceId;
    }

    public long getResourcePrimkey() {
        return _resourcePrimkey;
    }

    public void setResourcePrimkey(long resourcePrimkey) {
        _resourcePrimkey = resourcePrimkey;

        if (!_setOriginalResourcePrimkey) {
            _setOriginalResourcePrimkey = true;

            _originalResourcePrimkey = resourcePrimkey;
        }
    }

    public long getOriginalResourcePrimkey() {
        return _originalResourcePrimkey;
    }

    public String getJournalType() {
        return GetterUtil.getString(_journalType);
    }

    public void setJournalType(String journalType) {
        _journalType = journalType;
    }

    public int getCountImageOfArticle() {
        return _countImageOfArticle;
    }

    public void setCountImageOfArticle(int countImageOfArticle) {
        _countImageOfArticle = countImageOfArticle;
    }

    public WorkflowJournalArticle toEscapedModel() {
        if (isEscapedModel()) {
            return (WorkflowJournalArticle) this;
        } else {
            WorkflowJournalArticle model = new WorkflowJournalArticleImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setWorkflowJournalArticleId(getWorkflowJournalArticleId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setRoleId(getRoleId());
            model.setProcessDefinitionId(getProcessDefinitionId());
            model.setProcessInstanceId(getProcessInstanceId());
            model.setResourcePrimkey(getResourcePrimkey());
            model.setJournalType(HtmlUtil.escape(getJournalType()));
            model.setCountImageOfArticle(getCountImageOfArticle());

            model = (WorkflowJournalArticle) Proxy.newProxyInstance(WorkflowJournalArticle.class.getClassLoader(),
                    new Class[] { WorkflowJournalArticle.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(WorkflowJournalArticle.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        WorkflowJournalArticleImpl clone = new WorkflowJournalArticleImpl();

        clone.setWorkflowJournalArticleId(getWorkflowJournalArticleId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setRoleId(getRoleId());
        clone.setProcessDefinitionId(getProcessDefinitionId());
        clone.setProcessInstanceId(getProcessInstanceId());
        clone.setResourcePrimkey(getResourcePrimkey());
        clone.setJournalType(getJournalType());
        clone.setCountImageOfArticle(getCountImageOfArticle());

        return clone;
    }

    public int compareTo(WorkflowJournalArticle workflowJournalArticle) {
        int value = 0;

        if (getResourcePrimkey() < workflowJournalArticle.getResourcePrimkey()) {
            value = -1;
        } else if (getResourcePrimkey() > workflowJournalArticle.getResourcePrimkey()) {
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

        WorkflowJournalArticle workflowJournalArticle = null;

        try {
            workflowJournalArticle = (WorkflowJournalArticle) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = workflowJournalArticle.getPrimaryKey();

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

        sb.append("{workflowJournalArticleId=");
        sb.append(getWorkflowJournalArticleId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", roleId=");
        sb.append(getRoleId());
        sb.append(", processDefinitionId=");
        sb.append(getProcessDefinitionId());
        sb.append(", processInstanceId=");
        sb.append(getProcessInstanceId());
        sb.append(", resourcePrimkey=");
        sb.append(getResourcePrimkey());
        sb.append(", journalType=");
        sb.append(getJournalType());
        sb.append(", countImageOfArticle=");
        sb.append(getCountImageOfArticle());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append(
            "com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>workflowJournalArticleId</column-name><column-value><![CDATA[");
        sb.append(getWorkflowJournalArticleId());
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
            "<column><column-name>roleId</column-name><column-value><![CDATA[");
        sb.append(getRoleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>processDefinitionId</column-name><column-value><![CDATA[");
        sb.append(getProcessDefinitionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>processInstanceId</column-name><column-value><![CDATA[");
        sb.append(getProcessInstanceId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resourcePrimkey</column-name><column-value><![CDATA[");
        sb.append(getResourcePrimkey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>journalType</column-name><column-value><![CDATA[");
        sb.append(getJournalType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>countImageOfArticle</column-name><column-value><![CDATA[");
        sb.append(getCountImageOfArticle());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
