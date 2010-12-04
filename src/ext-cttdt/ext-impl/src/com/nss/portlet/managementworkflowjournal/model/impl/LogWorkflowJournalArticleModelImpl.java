package com.nss.portlet.managementworkflowjournal.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticleSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LogWorkflowJournalArticleModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>LogWorkflowJournalArticle</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle
 * @see com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticleModel
 * @see com.nss.portlet.managementworkflowjournal.model.impl.LogWorkflowJournalArticleImpl
 *
 */
public class LogWorkflowJournalArticleModelImpl extends BaseModelImpl<LogWorkflowJournalArticle> {
    public static final String TABLE_NAME = "log_workflow_journal_article";
    public static final Object[][] TABLE_COLUMNS = {
            { "logWorkflowJournalArticleId", new Integer(Types.BIGINT) },
            

            { "resourcePrimkey", new Integer(Types.BIGINT) },
            

            { "transition", new Integer(Types.INTEGER) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userIds", new Integer(Types.VARCHAR) },
            

            { "dateReceiptOfUserReceipt", new Integer(Types.TIMESTAMP) },
            

            { "dateProcessOfUserReceipt", new Integer(Types.TIMESTAMP) },
            

            { "dateSendOfUserReceipt", new Integer(Types.TIMESTAMP) },
            

            { "useridProcess", new Integer(Types.BIGINT) },
            

            { "userIdsProcess", new Integer(Types.VARCHAR) },
            

            { "processInformation", new Integer(Types.VARCHAR) },
            

            { "workflowStatusBefore", new Integer(Types.VARCHAR) },
            

            { "workflowStatusAfter", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table log_workflow_journal_article (logWorkflowJournalArticleId LONG not null primary key,resourcePrimkey LONG,transition INTEGER,groupId LONG,companyId LONG,userId LONG,userIds VARCHAR(75) null,dateReceiptOfUserReceipt DATE null,dateProcessOfUserReceipt DATE null,dateSendOfUserReceipt DATE null,useridProcess LONG,userIdsProcess VARCHAR(75) null,processInformation VARCHAR(75) null,workflowStatusBefore VARCHAR(75) null,workflowStatusAfter VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table log_workflow_journal_article";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle"));
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
    private transient ExpandoBridge _expandoBridge;

    public LogWorkflowJournalArticleModelImpl() {
    }

    public static LogWorkflowJournalArticle toModel(
        LogWorkflowJournalArticleSoap soapModel) {
        LogWorkflowJournalArticle model = new LogWorkflowJournalArticleImpl();

        model.setLogWorkflowJournalArticleId(soapModel.getLogWorkflowJournalArticleId());
        model.setResourcePrimkey(soapModel.getResourcePrimkey());
        model.setTransition(soapModel.getTransition());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserIds(soapModel.getUserIds());
        model.setDateReceiptOfUserReceipt(soapModel.getDateReceiptOfUserReceipt());
        model.setDateProcessOfUserReceipt(soapModel.getDateProcessOfUserReceipt());
        model.setDateSendOfUserReceipt(soapModel.getDateSendOfUserReceipt());
        model.setUseridProcess(soapModel.getUseridProcess());
        model.setUserIdsProcess(soapModel.getUserIdsProcess());
        model.setProcessInformation(soapModel.getProcessInformation());
        model.setWorkflowStatusBefore(soapModel.getWorkflowStatusBefore());
        model.setWorkflowStatusAfter(soapModel.getWorkflowStatusAfter());

        return model;
    }

    public static List<LogWorkflowJournalArticle> toModels(
        LogWorkflowJournalArticleSoap[] soapModels) {
        List<LogWorkflowJournalArticle> models = new ArrayList<LogWorkflowJournalArticle>(soapModels.length);

        for (LogWorkflowJournalArticleSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _logWorkflowJournalArticleId;
    }

    public void setPrimaryKey(long pk) {
        setLogWorkflowJournalArticleId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_logWorkflowJournalArticleId);
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
        return GetterUtil.getString(_userIds);
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
        return GetterUtil.getString(_userIdsProcess);
    }

    public void setUserIdsProcess(String userIdsProcess) {
        _userIdsProcess = userIdsProcess;
    }

    public String getProcessInformation() {
        return GetterUtil.getString(_processInformation);
    }

    public void setProcessInformation(String processInformation) {
        _processInformation = processInformation;
    }

    public String getWorkflowStatusBefore() {
        return GetterUtil.getString(_workflowStatusBefore);
    }

    public void setWorkflowStatusBefore(String workflowStatusBefore) {
        _workflowStatusBefore = workflowStatusBefore;
    }

    public String getWorkflowStatusAfter() {
        return GetterUtil.getString(_workflowStatusAfter);
    }

    public void setWorkflowStatusAfter(String workflowStatusAfter) {
        _workflowStatusAfter = workflowStatusAfter;
    }

    public LogWorkflowJournalArticle toEscapedModel() {
        if (isEscapedModel()) {
            return (LogWorkflowJournalArticle) this;
        } else {
            LogWorkflowJournalArticle model = new LogWorkflowJournalArticleImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setLogWorkflowJournalArticleId(getLogWorkflowJournalArticleId());
            model.setResourcePrimkey(getResourcePrimkey());
            model.setTransition(getTransition());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserIds(HtmlUtil.escape(getUserIds()));
            model.setDateReceiptOfUserReceipt(getDateReceiptOfUserReceipt());
            model.setDateProcessOfUserReceipt(getDateProcessOfUserReceipt());
            model.setDateSendOfUserReceipt(getDateSendOfUserReceipt());
            model.setUseridProcess(getUseridProcess());
            model.setUserIdsProcess(HtmlUtil.escape(getUserIdsProcess()));
            model.setProcessInformation(HtmlUtil.escape(getProcessInformation()));
            model.setWorkflowStatusBefore(HtmlUtil.escape(
                    getWorkflowStatusBefore()));
            model.setWorkflowStatusAfter(HtmlUtil.escape(
                    getWorkflowStatusAfter()));

            model = (LogWorkflowJournalArticle) Proxy.newProxyInstance(LogWorkflowJournalArticle.class.getClassLoader(),
                    new Class[] { LogWorkflowJournalArticle.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(LogWorkflowJournalArticle.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        LogWorkflowJournalArticleImpl clone = new LogWorkflowJournalArticleImpl();

        clone.setLogWorkflowJournalArticleId(getLogWorkflowJournalArticleId());
        clone.setResourcePrimkey(getResourcePrimkey());
        clone.setTransition(getTransition());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserIds(getUserIds());
        clone.setDateReceiptOfUserReceipt(getDateReceiptOfUserReceipt());
        clone.setDateProcessOfUserReceipt(getDateProcessOfUserReceipt());
        clone.setDateSendOfUserReceipt(getDateSendOfUserReceipt());
        clone.setUseridProcess(getUseridProcess());
        clone.setUserIdsProcess(getUserIdsProcess());
        clone.setProcessInformation(getProcessInformation());
        clone.setWorkflowStatusBefore(getWorkflowStatusBefore());
        clone.setWorkflowStatusAfter(getWorkflowStatusAfter());

        return clone;
    }

    public int compareTo(LogWorkflowJournalArticle logWorkflowJournalArticle) {
        int value = 0;

        if (getResourcePrimkey() < logWorkflowJournalArticle.getResourcePrimkey()) {
            value = -1;
        } else if (getResourcePrimkey() > logWorkflowJournalArticle.getResourcePrimkey()) {
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

        LogWorkflowJournalArticle logWorkflowJournalArticle = null;

        try {
            logWorkflowJournalArticle = (LogWorkflowJournalArticle) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = logWorkflowJournalArticle.getPrimaryKey();

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

        sb.append("{logWorkflowJournalArticleId=");
        sb.append(getLogWorkflowJournalArticleId());
        sb.append(", resourcePrimkey=");
        sb.append(getResourcePrimkey());
        sb.append(", transition=");
        sb.append(getTransition());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userIds=");
        sb.append(getUserIds());
        sb.append(", dateReceiptOfUserReceipt=");
        sb.append(getDateReceiptOfUserReceipt());
        sb.append(", dateProcessOfUserReceipt=");
        sb.append(getDateProcessOfUserReceipt());
        sb.append(", dateSendOfUserReceipt=");
        sb.append(getDateSendOfUserReceipt());
        sb.append(", useridProcess=");
        sb.append(getUseridProcess());
        sb.append(", userIdsProcess=");
        sb.append(getUserIdsProcess());
        sb.append(", processInformation=");
        sb.append(getProcessInformation());
        sb.append(", workflowStatusBefore=");
        sb.append(getWorkflowStatusBefore());
        sb.append(", workflowStatusAfter=");
        sb.append(getWorkflowStatusAfter());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append(
            "com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>logWorkflowJournalArticleId</column-name><column-value><![CDATA[");
        sb.append(getLogWorkflowJournalArticleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resourcePrimkey</column-name><column-value><![CDATA[");
        sb.append(getResourcePrimkey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>transition</column-name><column-value><![CDATA[");
        sb.append(getTransition());
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
            "<column><column-name>userIds</column-name><column-value><![CDATA[");
        sb.append(getUserIds());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateReceiptOfUserReceipt</column-name><column-value><![CDATA[");
        sb.append(getDateReceiptOfUserReceipt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateProcessOfUserReceipt</column-name><column-value><![CDATA[");
        sb.append(getDateProcessOfUserReceipt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateSendOfUserReceipt</column-name><column-value><![CDATA[");
        sb.append(getDateSendOfUserReceipt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>useridProcess</column-name><column-value><![CDATA[");
        sb.append(getUseridProcess());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userIdsProcess</column-name><column-value><![CDATA[");
        sb.append(getUserIdsProcess());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>processInformation</column-name><column-value><![CDATA[");
        sb.append(getProcessInformation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>workflowStatusBefore</column-name><column-value><![CDATA[");
        sb.append(getWorkflowStatusBefore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>workflowStatusAfter</column-name><column-value><![CDATA[");
        sb.append(getWorkflowStatusAfter());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
