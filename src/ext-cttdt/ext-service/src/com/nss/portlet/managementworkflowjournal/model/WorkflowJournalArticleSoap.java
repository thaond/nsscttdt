package com.nss.portlet.managementworkflowjournal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="WorkflowJournalArticleSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.managementworkflowjournal.service.http.WorkflowJournalArticleServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.service.http.WorkflowJournalArticleServiceSoap
 *
 */
public class WorkflowJournalArticleSoap implements Serializable {
    private long _workflowJournalArticleId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private long _roleId;
    private long _processDefinitionId;
    private long _processInstanceId;
    private long _resourcePrimkey;
    private String _journalType;
    private int _countImageOfArticle;

    public WorkflowJournalArticleSoap() {
    }

    public static WorkflowJournalArticleSoap toSoapModel(
        WorkflowJournalArticle model) {
        WorkflowJournalArticleSoap soapModel = new WorkflowJournalArticleSoap();

        soapModel.setWorkflowJournalArticleId(model.getWorkflowJournalArticleId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setRoleId(model.getRoleId());
        soapModel.setProcessDefinitionId(model.getProcessDefinitionId());
        soapModel.setProcessInstanceId(model.getProcessInstanceId());
        soapModel.setResourcePrimkey(model.getResourcePrimkey());
        soapModel.setJournalType(model.getJournalType());
        soapModel.setCountImageOfArticle(model.getCountImageOfArticle());

        return soapModel;
    }

    public static WorkflowJournalArticleSoap[] toSoapModels(
        WorkflowJournalArticle[] models) {
        WorkflowJournalArticleSoap[] soapModels = new WorkflowJournalArticleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static WorkflowJournalArticleSoap[][] toSoapModels(
        WorkflowJournalArticle[][] models) {
        WorkflowJournalArticleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new WorkflowJournalArticleSoap[models.length][models[0].length];
        } else {
            soapModels = new WorkflowJournalArticleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static WorkflowJournalArticleSoap[] toSoapModels(
        List<WorkflowJournalArticle> models) {
        List<WorkflowJournalArticleSoap> soapModels = new ArrayList<WorkflowJournalArticleSoap>(models.size());

        for (WorkflowJournalArticle model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new WorkflowJournalArticleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _workflowJournalArticleId;
    }

    public void setPrimaryKey(long pk) {
        setWorkflowJournalArticleId(pk);
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
    }

    public long getResourcePrimkey() {
        return _resourcePrimkey;
    }

    public void setResourcePrimkey(long resourcePrimkey) {
        _resourcePrimkey = resourcePrimkey;
    }

    public String getJournalType() {
        return _journalType;
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
}
