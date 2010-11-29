package com.nss.portlet.managementworkflowjournal.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="ManagementWorkflowJournalModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>ManagementWorkflowJournal</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal
 * @see com.nss.portlet.managementworkflowjournal.model.impl.ManagementWorkflowJournalImpl
 * @see com.nss.portlet.managementworkflowjournal.model.impl.ManagementWorkflowJournalModelImpl
 *
 */
public interface ManagementWorkflowJournalModel extends BaseModel<ManagementWorkflowJournal> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getManagementWorkflowJournalId();

    public void setManagementWorkflowJournalId(long managementWorkflowJournalId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public long getProcessDefinitionId();

    public void setProcessDefinitionId(long processDefinitionId);

    public String getWorkflowname();

    public void setWorkflowname(String workflowname);

    public int getVersion_();

    public void setVersion_(int version_);

    public String getDescription();

    public void setDescription(String description);

    public Date getDateFrom();

    public void setDateFrom(Date dateFrom);

    public Date getDateTo();

    public void setDateTo(Date dateTo);

    public ManagementWorkflowJournal toEscapedModel();
}
