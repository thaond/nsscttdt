package com.nss.portlet.managementworkflowjournal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LogWorkflowJournalArticleSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.managementworkflowjournal.service.http.LogWorkflowJournalArticleServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.service.http.LogWorkflowJournalArticleServiceSoap
 *
 */
public class LogWorkflowJournalArticleSoap implements Serializable {
    private long _logWorkflowJournalArticleId;
    private long _resourcePrimkey;
    private int _transition;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userIds;
    private Date _dateReceiptOfUserReceipt;
    private Date _dateProcessOfUserReceipt;
    private Date _dateSendOfUserReceipt;
    private long _useridProcess;
    private String _userIdsProcess;
    private String _processInformation;
    private String _workflowStatusBefore;
    private String _workflowStatusAfter;

    public LogWorkflowJournalArticleSoap() {
    }

    public static LogWorkflowJournalArticleSoap toSoapModel(
        LogWorkflowJournalArticle model) {
        LogWorkflowJournalArticleSoap soapModel = new LogWorkflowJournalArticleSoap();

        soapModel.setLogWorkflowJournalArticleId(model.getLogWorkflowJournalArticleId());
        soapModel.setResourcePrimkey(model.getResourcePrimkey());
        soapModel.setTransition(model.getTransition());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserIds(model.getUserIds());
        soapModel.setDateReceiptOfUserReceipt(model.getDateReceiptOfUserReceipt());
        soapModel.setDateProcessOfUserReceipt(model.getDateProcessOfUserReceipt());
        soapModel.setDateSendOfUserReceipt(model.getDateSendOfUserReceipt());
        soapModel.setUseridProcess(model.getUseridProcess());
        soapModel.setUserIdsProcess(model.getUserIdsProcess());
        soapModel.setProcessInformation(model.getProcessInformation());
        soapModel.setWorkflowStatusBefore(model.getWorkflowStatusBefore());
        soapModel.setWorkflowStatusAfter(model.getWorkflowStatusAfter());

        return soapModel;
    }

    public static LogWorkflowJournalArticleSoap[] toSoapModels(
        LogWorkflowJournalArticle[] models) {
        LogWorkflowJournalArticleSoap[] soapModels = new LogWorkflowJournalArticleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LogWorkflowJournalArticleSoap[][] toSoapModels(
        LogWorkflowJournalArticle[][] models) {
        LogWorkflowJournalArticleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LogWorkflowJournalArticleSoap[models.length][models[0].length];
        } else {
            soapModels = new LogWorkflowJournalArticleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LogWorkflowJournalArticleSoap[] toSoapModels(
        List<LogWorkflowJournalArticle> models) {
        List<LogWorkflowJournalArticleSoap> soapModels = new ArrayList<LogWorkflowJournalArticleSoap>(models.size());

        for (LogWorkflowJournalArticle model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LogWorkflowJournalArticleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _logWorkflowJournalArticleId;
    }

    public void setPrimaryKey(long pk) {
        setLogWorkflowJournalArticleId(pk);
    }

    public long getLogWorkflowJournalArticleId() {
        return _logWorkflowJournalArticleId;
    }

    public void setLogWorkflowJournalArticleId(long logWorkflowJournalArticleId) {
        _logWorkflowJournalArticleId = logWorkflowJournalArticleId;
    }

    public long getResourcePrimkey() {
        return _resourcePrimkey;
    }

    public void setResourcePrimkey(long resourcePrimkey) {
        _resourcePrimkey = resourcePrimkey;
    }

    public int getTransition() {
        return _transition;
    }

    public void setTransition(int transition) {
        _transition = transition;
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

    public String getUserIds() {
        return _userIds;
    }

    public void setUserIds(String userIds) {
        _userIds = userIds;
    }

    public Date getDateReceiptOfUserReceipt() {
        return _dateReceiptOfUserReceipt;
    }

    public void setDateReceiptOfUserReceipt(Date dateReceiptOfUserReceipt) {
        _dateReceiptOfUserReceipt = dateReceiptOfUserReceipt;
    }

    public Date getDateProcessOfUserReceipt() {
        return _dateProcessOfUserReceipt;
    }

    public void setDateProcessOfUserReceipt(Date dateProcessOfUserReceipt) {
        _dateProcessOfUserReceipt = dateProcessOfUserReceipt;
    }

    public Date getDateSendOfUserReceipt() {
        return _dateSendOfUserReceipt;
    }

    public void setDateSendOfUserReceipt(Date dateSendOfUserReceipt) {
        _dateSendOfUserReceipt = dateSendOfUserReceipt;
    }

    public long getUseridProcess() {
        return _useridProcess;
    }

    public void setUseridProcess(long useridProcess) {
        _useridProcess = useridProcess;
    }

    public String getUserIdsProcess() {
        return _userIdsProcess;
    }

    public void setUserIdsProcess(String userIdsProcess) {
        _userIdsProcess = userIdsProcess;
    }

    public String getProcessInformation() {
        return _processInformation;
    }

    public void setProcessInformation(String processInformation) {
        _processInformation = processInformation;
    }

    public String getWorkflowStatusBefore() {
        return _workflowStatusBefore;
    }

    public void setWorkflowStatusBefore(String workflowStatusBefore) {
        _workflowStatusBefore = workflowStatusBefore;
    }

    public String getWorkflowStatusAfter() {
        return _workflowStatusAfter;
    }

    public void setWorkflowStatusAfter(String workflowStatusAfter) {
        _workflowStatusAfter = workflowStatusAfter;
    }
}
