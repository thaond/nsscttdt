package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.model.PmlStateProcessSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlStateProcessModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlStateProcess</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlStateProcess
 * @see com.nss.portlet.onedoor.model.PmlStateProcessModel
 * @see com.nss.portlet.onedoor.model.impl.PmlStateProcessImpl
 *
 */
public class PmlStateProcessModelImpl extends BaseModelImpl<PmlStateProcess> {
    public static final String TABLE_NAME = "pml_stateprocess";
    public static final Object[][] TABLE_COLUMNS = {
            { "stateprocessid", new Integer(Types.BIGINT) },
            

            { "stateprocesscode", new Integer(Types.VARCHAR) },
            

            { "stateprocessname", new Integer(Types.VARCHAR) },
            

            { "filestatusid", new Integer(Types.BIGINT) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_stateprocess (stateprocessid LONG not null primary key,stateprocesscode VARCHAR(75) null,stateprocessname VARCHAR(75) null,filestatusid LONG,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_stateprocess";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlStateProcess"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlStateProcess"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlStateProcess"));
    private long _stateProcessId;
    private String _stateProcessCode;
    private String _stateProcessName;
    private long _fileStatusId;
    private String _description;
    private String _active;
    private transient ExpandoBridge _expandoBridge;

    public PmlStateProcessModelImpl() {
    }

    public static PmlStateProcess toModel(PmlStateProcessSoap soapModel) {
        PmlStateProcess model = new PmlStateProcessImpl();

        model.setStateProcessId(soapModel.getStateProcessId());
        model.setStateProcessCode(soapModel.getStateProcessCode());
        model.setStateProcessName(soapModel.getStateProcessName());
        model.setFileStatusId(soapModel.getFileStatusId());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<PmlStateProcess> toModels(
        PmlStateProcessSoap[] soapModels) {
        List<PmlStateProcess> models = new ArrayList<PmlStateProcess>(soapModels.length);

        for (PmlStateProcessSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _stateProcessId;
    }

    public void setPrimaryKey(long pk) {
        setStateProcessId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_stateProcessId);
    }

    public long getStateProcessId() {
        return _stateProcessId;
    }

    public void setStateProcessId(long stateProcessId) {
        _stateProcessId = stateProcessId;
    }

    public String getStateProcessCode() {
        return GetterUtil.getString(_stateProcessCode);
    }

    public void setStateProcessCode(String stateProcessCode) {
        _stateProcessCode = stateProcessCode;
    }

    public String getStateProcessName() {
        return GetterUtil.getString(_stateProcessName);
    }

    public void setStateProcessName(String stateProcessName) {
        _stateProcessName = stateProcessName;
    }

    public long getFileStatusId() {
        return _fileStatusId;
    }

    public void setFileStatusId(long fileStatusId) {
        _fileStatusId = fileStatusId;
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        _active = active;
    }

    public PmlStateProcess toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlStateProcess) this;
        } else {
            PmlStateProcess model = new PmlStateProcessImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setStateProcessId(getStateProcessId());
            model.setStateProcessCode(HtmlUtil.escape(getStateProcessCode()));
            model.setStateProcessName(HtmlUtil.escape(getStateProcessName()));
            model.setFileStatusId(getFileStatusId());
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (PmlStateProcess) Proxy.newProxyInstance(PmlStateProcess.class.getClassLoader(),
                    new Class[] { PmlStateProcess.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlStateProcess.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PmlStateProcessImpl clone = new PmlStateProcessImpl();

        clone.setStateProcessId(getStateProcessId());
        clone.setStateProcessCode(getStateProcessCode());
        clone.setStateProcessName(getStateProcessName());
        clone.setFileStatusId(getFileStatusId());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(PmlStateProcess pmlStateProcess) {
        int value = 0;

        if (getStateProcessId() < pmlStateProcess.getStateProcessId()) {
            value = -1;
        } else if (getStateProcessId() > pmlStateProcess.getStateProcessId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlStateProcess pmlStateProcess = null;

        try {
            pmlStateProcess = (PmlStateProcess) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlStateProcess.getPrimaryKey();

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

        sb.append("{stateProcessId=");
        sb.append(getStateProcessId());
        sb.append(", stateProcessCode=");
        sb.append(getStateProcessCode());
        sb.append(", stateProcessName=");
        sb.append(getStateProcessName());
        sb.append(", fileStatusId=");
        sb.append(getFileStatusId());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlStateProcess");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>stateProcessId</column-name><column-value><![CDATA[");
        sb.append(getStateProcessId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stateProcessCode</column-name><column-value><![CDATA[");
        sb.append(getStateProcessCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stateProcessName</column-name><column-value><![CDATA[");
        sb.append(getStateProcessName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileStatusId</column-name><column-value><![CDATA[");
        sb.append(getFileStatusId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
