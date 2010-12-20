package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.onedoor.model.PmlWfOnedoorProcess;
import com.nss.portlet.onedoor.model.PmlWfOnedoorProcessSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlWfOnedoorProcessModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlWfOnedoorProcess</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlWfOnedoorProcess
 * @see com.nss.portlet.onedoor.model.PmlWfOnedoorProcessModel
 * @see com.nss.portlet.onedoor.model.impl.PmlWfOnedoorProcessImpl
 *
 */
public class PmlWfOnedoorProcessModelImpl extends BaseModelImpl<PmlWfOnedoorProcess> {
    public static final String TABLE_NAME = "pml_wf_onedoor";
    public static final Object[][] TABLE_COLUMNS = {
            { "fileId", new Integer(Types.VARCHAR) },
            

            { "processId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_wf_onedoor (fileId VARCHAR(75) not null primary key,processId LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_wf_onedoor";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlWfOnedoorProcess"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlWfOnedoorProcess"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlWfOnedoorProcess"));
    private String _fileId;
    private long _processId;

    public PmlWfOnedoorProcessModelImpl() {
    }

    public static PmlWfOnedoorProcess toModel(PmlWfOnedoorProcessSoap soapModel) {
        PmlWfOnedoorProcess model = new PmlWfOnedoorProcessImpl();

        model.setFileId(soapModel.getFileId());
        model.setProcessId(soapModel.getProcessId());

        return model;
    }

    public static List<PmlWfOnedoorProcess> toModels(
        PmlWfOnedoorProcessSoap[] soapModels) {
        List<PmlWfOnedoorProcess> models = new ArrayList<PmlWfOnedoorProcess>(soapModels.length);

        for (PmlWfOnedoorProcessSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _fileId;
    }

    public void setPrimaryKey(String pk) {
        setFileId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _fileId;
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public long getProcessId() {
        return _processId;
    }

    public void setProcessId(long processId) {
        _processId = processId;
    }

    public PmlWfOnedoorProcess toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlWfOnedoorProcess) this;
        } else {
            PmlWfOnedoorProcess model = new PmlWfOnedoorProcessImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileId(HtmlUtil.escape(getFileId()));
            model.setProcessId(getProcessId());

            model = (PmlWfOnedoorProcess) Proxy.newProxyInstance(PmlWfOnedoorProcess.class.getClassLoader(),
                    new Class[] { PmlWfOnedoorProcess.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlWfOnedoorProcessImpl clone = new PmlWfOnedoorProcessImpl();

        clone.setFileId(getFileId());
        clone.setProcessId(getProcessId());

        return clone;
    }

    public int compareTo(PmlWfOnedoorProcess pmlWfOnedoorProcess) {
        String pk = pmlWfOnedoorProcess.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlWfOnedoorProcess pmlWfOnedoorProcess = null;

        try {
            pmlWfOnedoorProcess = (PmlWfOnedoorProcess) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlWfOnedoorProcess.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{fileId=");
        sb.append(getFileId());
        sb.append(", processId=");
        sb.append(getProcessId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlWfOnedoorProcess");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fileId</column-name><column-value><![CDATA[");
        sb.append(getFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>processId</column-name><column-value><![CDATA[");
        sb.append(getProcessId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
