package com.nss.portlet.journalworkflow.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.journalworkflow.model.InstanceBean;
import com.nss.portlet.journalworkflow.model.InstanceBeanSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="InstanceBeanModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>InstanceBean</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.model.InstanceBean
 * @see com.nss.portlet.journalworkflow.model.InstanceBeanModel
 * @see com.nss.portlet.journalworkflow.model.impl.InstanceBeanImpl
 *
 */
public class InstanceBeanModelImpl extends BaseModelImpl<InstanceBean> {
    public static final String TABLE_NAME = "InstanceBean";
    public static final Object[][] TABLE_COLUMNS = {
            { "processInstanceId", new Integer(Types.BIGINT) },
            

            { "businessProcessId", new Integer(Types.BIGINT) },
            

            { "articleId", new Integer(Types.BIGINT) },
            

            { "categoryId", new Integer(Types.BIGINT) },
            

            { "previousNode", new Integer(Types.VARCHAR) },
            

            { "status", new Integer(Types.VARCHAR) },
            

            { "createUserId", new Integer(Types.BIGINT) },
            

            { "finish", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table InstanceBean (processInstanceId LONG not null primary key,businessProcessId LONG,articleId LONG,categoryId LONG,previousNode VARCHAR(75) null,status VARCHAR(75) null,createUserId LONG,finish BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table InstanceBean";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.journalworkflow.model.InstanceBean"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.journalworkflow.model.InstanceBean"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.journalworkflow.model.InstanceBean"));
    private long _processInstanceId;
    private long _businessProcessId;
    private long _articleId;
    private long _categoryId;
    private String _previousNode;
    private String _status;
    private long _createUserId;
    private boolean _finish;
    private transient ExpandoBridge _expandoBridge;

    public InstanceBeanModelImpl() {
    }

    public static InstanceBean toModel(InstanceBeanSoap soapModel) {
        InstanceBean model = new InstanceBeanImpl();

        model.setProcessInstanceId(soapModel.getProcessInstanceId());
        model.setBusinessProcessId(soapModel.getBusinessProcessId());
        model.setArticleId(soapModel.getArticleId());
        model.setCategoryId(soapModel.getCategoryId());
        model.setPreviousNode(soapModel.getPreviousNode());
        model.setStatus(soapModel.getStatus());
        model.setCreateUserId(soapModel.getCreateUserId());
        model.setFinish(soapModel.getFinish());

        return model;
    }

    public static List<InstanceBean> toModels(InstanceBeanSoap[] soapModels) {
        List<InstanceBean> models = new ArrayList<InstanceBean>(soapModels.length);

        for (InstanceBeanSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _processInstanceId;
    }

    public void setPrimaryKey(long pk) {
        setProcessInstanceId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_processInstanceId);
    }

    public long getProcessInstanceId() {
        return _processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        _processInstanceId = processInstanceId;
    }

    public long getBusinessProcessId() {
        return _businessProcessId;
    }

    public void setBusinessProcessId(long businessProcessId) {
        _businessProcessId = businessProcessId;
    }

    public long getArticleId() {
        return _articleId;
    }

    public void setArticleId(long articleId) {
        _articleId = articleId;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public String getPreviousNode() {
        return GetterUtil.getString(_previousNode);
    }

    public void setPreviousNode(String previousNode) {
        _previousNode = previousNode;
    }

    public String getStatus() {
        return GetterUtil.getString(_status);
    }

    public void setStatus(String status) {
        _status = status;
    }

    public long getCreateUserId() {
        return _createUserId;
    }

    public void setCreateUserId(long createUserId) {
        _createUserId = createUserId;
    }

    public boolean getFinish() {
        return _finish;
    }

    public boolean isFinish() {
        return _finish;
    }

    public void setFinish(boolean finish) {
        _finish = finish;
    }

    public InstanceBean toEscapedModel() {
        if (isEscapedModel()) {
            return (InstanceBean) this;
        } else {
            InstanceBean model = new InstanceBeanImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setProcessInstanceId(getProcessInstanceId());
            model.setBusinessProcessId(getBusinessProcessId());
            model.setArticleId(getArticleId());
            model.setCategoryId(getCategoryId());
            model.setPreviousNode(HtmlUtil.escape(getPreviousNode()));
            model.setStatus(HtmlUtil.escape(getStatus()));
            model.setCreateUserId(getCreateUserId());
            model.setFinish(getFinish());

            model = (InstanceBean) Proxy.newProxyInstance(InstanceBean.class.getClassLoader(),
                    new Class[] { InstanceBean.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(InstanceBean.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        InstanceBeanImpl clone = new InstanceBeanImpl();

        clone.setProcessInstanceId(getProcessInstanceId());
        clone.setBusinessProcessId(getBusinessProcessId());
        clone.setArticleId(getArticleId());
        clone.setCategoryId(getCategoryId());
        clone.setPreviousNode(getPreviousNode());
        clone.setStatus(getStatus());
        clone.setCreateUserId(getCreateUserId());
        clone.setFinish(getFinish());

        return clone;
    }

    public int compareTo(InstanceBean instanceBean) {
        long pk = instanceBean.getPrimaryKey();

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

        InstanceBean instanceBean = null;

        try {
            instanceBean = (InstanceBean) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = instanceBean.getPrimaryKey();

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

        sb.append("{processInstanceId=");
        sb.append(getProcessInstanceId());
        sb.append(", businessProcessId=");
        sb.append(getBusinessProcessId());
        sb.append(", articleId=");
        sb.append(getArticleId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append(", previousNode=");
        sb.append(getPreviousNode());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", createUserId=");
        sb.append(getCreateUserId());
        sb.append(", finish=");
        sb.append(getFinish());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.journalworkflow.model.InstanceBean");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>processInstanceId</column-name><column-value><![CDATA[");
        sb.append(getProcessInstanceId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>businessProcessId</column-name><column-value><![CDATA[");
        sb.append(getBusinessProcessId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>articleId</column-name><column-value><![CDATA[");
        sb.append(getArticleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>previousNode</column-name><column-value><![CDATA[");
        sb.append(getPreviousNode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createUserId</column-name><column-value><![CDATA[");
        sb.append(getCreateUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>finish</column-name><column-value><![CDATA[");
        sb.append(getFinish());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
