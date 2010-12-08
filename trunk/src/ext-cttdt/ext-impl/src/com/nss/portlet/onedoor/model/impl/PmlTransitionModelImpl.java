package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.onedoor.model.PmlTransition;
import com.nss.portlet.onedoor.model.PmlTransitionSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTransitionModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlTransition</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlTransition
 * @see com.nss.portlet.onedoor.model.PmlTransitionModel
 * @see com.nss.portlet.onedoor.model.impl.PmlTransitionImpl
 *
 */
public class PmlTransitionModelImpl extends BaseModelImpl<PmlTransition> {
    public static final String TABLE_NAME = "pml_transition";
    public static final Object[][] TABLE_COLUMNS = {
            { "transitionid", new Integer(Types.BIGINT) },
            

            { "transitionname", new Integer(Types.VARCHAR) },
            

            { "filetypeid", new Integer(Types.VARCHAR) },
            

            { "notransition", new Integer(Types.INTEGER) },
            

            { "stateprocesscurrent", new Integer(Types.BIGINT) },
            

            { "stateprocessnext", new Integer(Types.BIGINT) },
            

            { "version_", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_transition (transitionid LONG not null primary key,transitionname VARCHAR(75) null,filetypeid VARCHAR(75) null,notransition INTEGER,stateprocesscurrent LONG,stateprocessnext LONG,version_ VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_transition";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlTransition"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlTransition"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlTransition"));
    private long _transitionId;
    private String _transitionName;
    private String _fileTypeId;
    private int _noTransition;
    private long _stateProcessCurrent;
    private long _stateProcessNext;
    private String _version_;
    private transient ExpandoBridge _expandoBridge;

    public PmlTransitionModelImpl() {
    }

    public static PmlTransition toModel(PmlTransitionSoap soapModel) {
        PmlTransition model = new PmlTransitionImpl();

        model.setTransitionId(soapModel.getTransitionId());
        model.setTransitionName(soapModel.getTransitionName());
        model.setFileTypeId(soapModel.getFileTypeId());
        model.setNoTransition(soapModel.getNoTransition());
        model.setStateProcessCurrent(soapModel.getStateProcessCurrent());
        model.setStateProcessNext(soapModel.getStateProcessNext());
        model.setVersion_(soapModel.getVersion_());

        return model;
    }

    public static List<PmlTransition> toModels(PmlTransitionSoap[] soapModels) {
        List<PmlTransition> models = new ArrayList<PmlTransition>(soapModels.length);

        for (PmlTransitionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _transitionId;
    }

    public void setPrimaryKey(long pk) {
        setTransitionId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_transitionId);
    }

    public long getTransitionId() {
        return _transitionId;
    }

    public void setTransitionId(long transitionId) {
        _transitionId = transitionId;
    }

    public String getTransitionName() {
        return GetterUtil.getString(_transitionName);
    }

    public void setTransitionName(String transitionName) {
        _transitionName = transitionName;
    }

    public String getFileTypeId() {
        return GetterUtil.getString(_fileTypeId);
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public int getNoTransition() {
        return _noTransition;
    }

    public void setNoTransition(int noTransition) {
        _noTransition = noTransition;
    }

    public long getStateProcessCurrent() {
        return _stateProcessCurrent;
    }

    public void setStateProcessCurrent(long stateProcessCurrent) {
        _stateProcessCurrent = stateProcessCurrent;
    }

    public long getStateProcessNext() {
        return _stateProcessNext;
    }

    public void setStateProcessNext(long stateProcessNext) {
        _stateProcessNext = stateProcessNext;
    }

    public String getVersion_() {
        return GetterUtil.getString(_version_);
    }

    public void setVersion_(String version_) {
        _version_ = version_;
    }

    public PmlTransition toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlTransition) this;
        } else {
            PmlTransition model = new PmlTransitionImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setTransitionId(getTransitionId());
            model.setTransitionName(HtmlUtil.escape(getTransitionName()));
            model.setFileTypeId(HtmlUtil.escape(getFileTypeId()));
            model.setNoTransition(getNoTransition());
            model.setStateProcessCurrent(getStateProcessCurrent());
            model.setStateProcessNext(getStateProcessNext());
            model.setVersion_(HtmlUtil.escape(getVersion_()));

            model = (PmlTransition) Proxy.newProxyInstance(PmlTransition.class.getClassLoader(),
                    new Class[] { PmlTransition.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlTransition.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PmlTransitionImpl clone = new PmlTransitionImpl();

        clone.setTransitionId(getTransitionId());
        clone.setTransitionName(getTransitionName());
        clone.setFileTypeId(getFileTypeId());
        clone.setNoTransition(getNoTransition());
        clone.setStateProcessCurrent(getStateProcessCurrent());
        clone.setStateProcessNext(getStateProcessNext());
        clone.setVersion_(getVersion_());

        return clone;
    }

    public int compareTo(PmlTransition pmlTransition) {
        int value = 0;

        if (getTransitionId() < pmlTransition.getTransitionId()) {
            value = -1;
        } else if (getTransitionId() > pmlTransition.getTransitionId()) {
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

        PmlTransition pmlTransition = null;

        try {
            pmlTransition = (PmlTransition) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlTransition.getPrimaryKey();

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

        sb.append("{transitionId=");
        sb.append(getTransitionId());
        sb.append(", transitionName=");
        sb.append(getTransitionName());
        sb.append(", fileTypeId=");
        sb.append(getFileTypeId());
        sb.append(", noTransition=");
        sb.append(getNoTransition());
        sb.append(", stateProcessCurrent=");
        sb.append(getStateProcessCurrent());
        sb.append(", stateProcessNext=");
        sb.append(getStateProcessNext());
        sb.append(", version_=");
        sb.append(getVersion_());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlTransition");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>transitionId</column-name><column-value><![CDATA[");
        sb.append(getTransitionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>transitionName</column-name><column-value><![CDATA[");
        sb.append(getTransitionName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileTypeId</column-name><column-value><![CDATA[");
        sb.append(getFileTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>noTransition</column-name><column-value><![CDATA[");
        sb.append(getNoTransition());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stateProcessCurrent</column-name><column-value><![CDATA[");
        sb.append(getStateProcessCurrent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stateProcessNext</column-name><column-value><![CDATA[");
        sb.append(getStateProcessNext());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version_</column-name><column-value><![CDATA[");
        sb.append(getVersion_());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
