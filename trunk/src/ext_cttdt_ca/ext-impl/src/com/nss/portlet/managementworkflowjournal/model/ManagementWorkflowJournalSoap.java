package com.nss.portlet.managementworkflowjournal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ManagementWorkflowJournalSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.managementworkflowjournal.service.http.ManagementWorkflowJournalServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.service.http.ManagementWorkflowJournalServiceSoap
 *
 */
public class ManagementWorkflowJournalSoap implements Serializable {
    private long _managementWorkflowJournalId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private long _processDefinitionId;
    private String _workflowname;
    private int _version_;
    private String _description;
    private Date _dateFrom;
    private Date _dateTo;

    public ManagementWorkflowJournalSoap() {
    }

    public static ManagementWorkflowJournalSoap toSoapModel(
        ManagementWorkflowJournal model) {
        ManagementWorkflowJournalSoap soapModel = new ManagementWorkflowJournalSoap();

        soapModel.setManagementWorkflowJournalId(model.getManagementWorkflowJournalId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setProcessDefinitionId(model.getProcessDefinitionId());
        soapModel.setWorkflowname(model.getWorkflowname());
        soapModel.setVersion_(model.getVersion_());
        soapModel.setDescription(model.getDescription());
        soapModel.setDateFrom(model.getDateFrom());
        soapModel.setDateTo(model.getDateTo());

        return soapModel;
    }

    public static ManagementWorkflowJournalSoap[] toSoapModels(
        ManagementWorkflowJournal[] models) {
        ManagementWorkflowJournalSoap[] soapModels = new ManagementWorkflowJournalSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ManagementWorkflowJournalSoap[][] toSoapModels(
        ManagementWorkflowJournal[][] models) {
        ManagementWorkflowJournalSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ManagementWorkflowJournalSoap[models.length][models[0].length];
        } else {
            soapModels = new ManagementWorkflowJournalSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ManagementWorkflowJournalSoap[] toSoapModels(
        List<ManagementWorkflowJournal> models) {
        List<ManagementWorkflowJournalSoap> soapModels = new ArrayList<ManagementWorkflowJournalSoap>(models.size());

        for (ManagementWorkflowJournal model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ManagementWorkflowJournalSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _managementWorkflowJournalId;
    }

    public void setPrimaryKey(long pk) {
        setManagementWorkflowJournalId(pk);
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
        return _workflowname;
    }

    public void setWorkflowname(String workflowname) {
        _workflowname = workflowname;
    }

    public int getVersion_() {
        return _version_;
    }

    public void setVersion_(int version_) {
        _version_ = version_;
    }

    public String getDescription() {
        return _description;
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
}
