package com.nss.portlet.managementworkflowjournal.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="LogWorkflowJournalArticleModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>LogWorkflowJournalArticle</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle
 * @see com.nss.portlet.managementworkflowjournal.model.impl.LogWorkflowJournalArticleImpl
 * @see com.nss.portlet.managementworkflowjournal.model.impl.LogWorkflowJournalArticleModelImpl
 *
 */
public interface LogWorkflowJournalArticleModel extends BaseModel<LogWorkflowJournalArticle> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getLogWorkflowJournalArticleId();

    public void setLogWorkflowJournalArticleId(long logWorkflowJournalArticleId);

    public long getResourcePrimkey();

    public void setResourcePrimkey(long resourcePrimkey);

    public int getTransition();

    public void setTransition(int transition);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public String getUserIds();

    public void setUserIds(String userIds);

    public Date getDateReceiptOfUserReceipt();

    public void setDateReceiptOfUserReceipt(Date dateReceiptOfUserReceipt);

    public Date getDateProcessOfUserReceipt();

    public void setDateProcessOfUserReceipt(Date dateProcessOfUserReceipt);

    public Date getDateSendOfUserReceipt();

    public void setDateSendOfUserReceipt(Date dateSendOfUserReceipt);

    public long getUseridProcess();

    public void setUseridProcess(long useridProcess);

    public String getUserIdsProcess();

    public void setUserIdsProcess(String userIdsProcess);

    public String getProcessInformation();

    public void setProcessInformation(String processInformation);

    public String getWorkflowStatusBefore();

    public void setWorkflowStatusBefore(String workflowStatusBefore);

    public String getWorkflowStatusAfter();

    public void setWorkflowStatusAfter(String workflowStatusAfter);

    public LogWorkflowJournalArticle toEscapedModel();
}
