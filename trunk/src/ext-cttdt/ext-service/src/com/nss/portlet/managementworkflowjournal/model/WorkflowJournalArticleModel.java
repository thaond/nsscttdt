package com.nss.portlet.managementworkflowjournal.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="WorkflowJournalArticleModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>WorkflowJournalArticle</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle
 * @see com.nss.portlet.managementworkflowjournal.model.impl.WorkflowJournalArticleImpl
 * @see com.nss.portlet.managementworkflowjournal.model.impl.WorkflowJournalArticleModelImpl
 *
 */
public interface WorkflowJournalArticleModel extends BaseModel<WorkflowJournalArticle> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getWorkflowJournalArticleId();

    public void setWorkflowJournalArticleId(long workflowJournalArticleId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public long getRoleId();

    public void setRoleId(long roleId);

    public long getProcessDefinitionId();

    public void setProcessDefinitionId(long processDefinitionId);

    public long getProcessInstanceId();

    public void setProcessInstanceId(long processInstanceId);

    public long getResourcePrimkey();

    public void setResourcePrimkey(long resourcePrimkey);

    public String getJournalType();

    public void setJournalType(String journalType);

    public int getCountImageOfArticle();

    public void setCountImageOfArticle(int countImageOfArticle);

    public WorkflowJournalArticle toEscapedModel();
}
