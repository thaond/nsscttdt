package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.model.PmlFileStatusSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileStatusModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFileStatus</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlFileStatus
 * @see com.sgs.portlet.document.model.PmlFileStatusModel
 * @see com.sgs.portlet.document.model.impl.PmlFileStatusImpl
 *
 */
public class PmlFileStatusModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_filestatus";
    public static final Object[][] TABLE_COLUMNS = {
            { "filestatusid", new Integer(Types.BIGINT) },
            

            { "filestatuscode", new Integer(Types.VARCHAR) },
            

            { "filestatusname", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "type", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_filestatus (filestatusid LONG not null primary key,filestatuscode VARCHAR(75) null,filestatusname VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null,type VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_filestatus";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlFileStatus"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlFileStatus"));
    private long _fileStatusId;
    private String _fileStatusCode;
    private String _fileStatusName;
    private String _description;
    private String _active;
    private String _type;

    public PmlFileStatusModelImpl() {
    }

    public static PmlFileStatus toModel(PmlFileStatusSoap soapModel) {
        PmlFileStatus model = new PmlFileStatusImpl();

        model.setFileStatusId(soapModel.getFileStatusId());
        model.setFileStatusCode(soapModel.getFileStatusCode());
        model.setFileStatusName(soapModel.getFileStatusName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());
        model.setType(soapModel.getType());

        return model;
    }

    public static List<PmlFileStatus> toModels(PmlFileStatusSoap[] soapModels) {
        List<PmlFileStatus> models = new ArrayList<PmlFileStatus>(soapModels.length);

        for (PmlFileStatusSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _fileStatusId;
    }

    public void setPrimaryKey(long pk) {
        setFileStatusId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_fileStatusId);
    }

    public long getFileStatusId() {
        return _fileStatusId;
    }

    public void setFileStatusId(long fileStatusId) {
        if (fileStatusId != _fileStatusId) {
            _fileStatusId = fileStatusId;
        }
    }

    public String getFileStatusCode() {
        return GetterUtil.getString(_fileStatusCode);
    }

    public void setFileStatusCode(String fileStatusCode) {
        if (((fileStatusCode == null) && (_fileStatusCode != null)) ||
                ((fileStatusCode != null) && (_fileStatusCode == null)) ||
                ((fileStatusCode != null) && (_fileStatusCode != null) &&
                !fileStatusCode.equals(_fileStatusCode))) {
            _fileStatusCode = fileStatusCode;
        }
    }

    public String getFileStatusName() {
        return GetterUtil.getString(_fileStatusName);
    }

    public void setFileStatusName(String fileStatusName) {
        if (((fileStatusName == null) && (_fileStatusName != null)) ||
                ((fileStatusName != null) && (_fileStatusName == null)) ||
                ((fileStatusName != null) && (_fileStatusName != null) &&
                !fileStatusName.equals(_fileStatusName))) {
            _fileStatusName = fileStatusName;
        }
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        if (((description == null) && (_description != null)) ||
                ((description != null) && (_description == null)) ||
                ((description != null) && (_description != null) &&
                !description.equals(_description))) {
            _description = description;
        }
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        if (((active == null) && (_active != null)) ||
                ((active != null) && (_active == null)) ||
                ((active != null) && (_active != null) &&
                !active.equals(_active))) {
            _active = active;
        }
    }

    public String getType() {
        return GetterUtil.getString(_type);
    }

    public void setType(String type) {
        if (((type == null) && (_type != null)) ||
                ((type != null) && (_type == null)) ||
                ((type != null) && (_type != null) && !type.equals(_type))) {
            _type = type;
        }
    }

    public PmlFileStatus toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFileStatus) this;
        } else {
            PmlFileStatus model = new PmlFileStatusImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileStatusId(getFileStatusId());
            model.setFileStatusCode(HtmlUtil.escape(getFileStatusCode()));
            model.setFileStatusName(HtmlUtil.escape(getFileStatusName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setType(HtmlUtil.escape(getType()));

            model = (PmlFileStatus) Proxy.newProxyInstance(PmlFileStatus.class.getClassLoader(),
                    new Class[] { PmlFileStatus.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlFileStatusImpl clone = new PmlFileStatusImpl();

        clone.setFileStatusId(getFileStatusId());
        clone.setFileStatusCode(getFileStatusCode());
        clone.setFileStatusName(getFileStatusName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());
        clone.setType(getType());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFileStatusImpl pmlFileStatus = (PmlFileStatusImpl) obj;

        int value = 0;

        if (getFileStatusId() < pmlFileStatus.getFileStatusId()) {
            value = -1;
        } else if (getFileStatusId() > pmlFileStatus.getFileStatusId()) {
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

        PmlFileStatusImpl pmlFileStatus = null;

        try {
            pmlFileStatus = (PmlFileStatusImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlFileStatus.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
