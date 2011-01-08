package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcessSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileStatusStateProcessModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFileStatusStateProcess</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess
 * @see com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcessModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlFileStatusStateProcessImpl
 *
 */
public class PmlFileStatusStateProcessModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_filestatus_stateprocess";
    public static final Object[][] TABLE_COLUMNS = {
            { "id", new Integer(Types.BIGINT) },
            

            { "filestatusid", new Integer(Types.BIGINT) },
            

            { "stateprocessid", new Integer(Types.BIGINT) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_filestatus_stateprocess (id LONG not null primary key,filestatusid LONG,stateprocessid LONG,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_filestatus_stateprocess";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"));
    private long _id;
    private long _fileStatusId;
    private long _stateProcessId;
    private String _description;

    public PmlFileStatusStateProcessModelImpl() {
    }

    public static PmlFileStatusStateProcess toModel(
        PmlFileStatusStateProcessSoap soapModel) {
        PmlFileStatusStateProcess model = new PmlFileStatusStateProcessImpl();

        model.setId(soapModel.getId());
        model.setFileStatusId(soapModel.getFileStatusId());
        model.setStateProcessId(soapModel.getStateProcessId());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<PmlFileStatusStateProcess> toModels(
        PmlFileStatusStateProcessSoap[] soapModels) {
        List<PmlFileStatusStateProcess> models = new ArrayList<PmlFileStatusStateProcess>(soapModels.length);

        for (PmlFileStatusStateProcessSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        if (id != _id) {
            _id = id;
        }
    }

    public long getFileStatusId() {
        return _fileStatusId;
    }

    public void setFileStatusId(long fileStatusId) {
        if (fileStatusId != _fileStatusId) {
            _fileStatusId = fileStatusId;
        }
    }

    public long getStateProcessId() {
        return _stateProcessId;
    }

    public void setStateProcessId(long stateProcessId) {
        if (stateProcessId != _stateProcessId) {
            _stateProcessId = stateProcessId;
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

    public PmlFileStatusStateProcess toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFileStatusStateProcess) this;
        } else {
            PmlFileStatusStateProcess model = new PmlFileStatusStateProcessImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setId(getId());
            model.setFileStatusId(getFileStatusId());
            model.setStateProcessId(getStateProcessId());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (PmlFileStatusStateProcess) Proxy.newProxyInstance(PmlFileStatusStateProcess.class.getClassLoader(),
                    new Class[] { PmlFileStatusStateProcess.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlFileStatusStateProcessImpl clone = new PmlFileStatusStateProcessImpl();

        clone.setId(getId());
        clone.setFileStatusId(getFileStatusId());
        clone.setStateProcessId(getStateProcessId());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFileStatusStateProcessImpl pmlFileStatusStateProcess = (PmlFileStatusStateProcessImpl) obj;

        long pk = pmlFileStatusStateProcess.getPrimaryKey();

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

        PmlFileStatusStateProcessImpl pmlFileStatusStateProcess = null;

        try {
            pmlFileStatusStateProcess = (PmlFileStatusStateProcessImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlFileStatusStateProcess.getPrimaryKey();

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
