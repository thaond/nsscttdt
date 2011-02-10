package com.sgs.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoor.model.PmlWorkflow;
import com.sgs.portlet.onedoor.model.PmlWorkflowSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlWorkflowModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlWorkflow</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlWorkflow
 * @see com.sgs.portlet.onedoor.model.PmlWorkflowModel
 * @see com.sgs.portlet.onedoor.model.impl.PmlWorkflowImpl
 *
 */
public class PmlWorkflowModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_workflow";
    public static final Object[][] TABLE_COLUMNS = {
            { "workflowId", new Integer(Types.BIGINT) },
            

            { "fileTypeId", new Integer(Types.VARCHAR) },
            

            { "workflow", new Integer(Types.VARCHAR) },
            

            { "version_", new Integer(Types.INTEGER) },
            

            { "startDate", new Integer(Types.TIMESTAMP) },
            

            { "endDate", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_workflow (workflowId LONG not null primary key,fileTypeId VARCHAR(75) null,workflow VARCHAR(75) null,version_ INTEGER,startDate DATE null,endDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table pml_workflow";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoor.model.PmlWorkflow"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoor.model.PmlWorkflow"));
    private long _workflowId;
    private String _fileTypeId;
    private String _workflow;
    private int _version_;
    private Date _startDate;
    private Date _endDate;

    public PmlWorkflowModelImpl() {
    }

    public static PmlWorkflow toModel(PmlWorkflowSoap soapModel) {
        PmlWorkflow model = new PmlWorkflowImpl();

        model.setWorkflowId(soapModel.getWorkflowId());
        model.setFileTypeId(soapModel.getFileTypeId());
        model.setWorkflow(soapModel.getWorkflow());
        model.setVersion_(soapModel.getVersion_());
        model.setStartDate(soapModel.getStartDate());
        model.setEndDate(soapModel.getEndDate());

        return model;
    }

    public static List<PmlWorkflow> toModels(PmlWorkflowSoap[] soapModels) {
        List<PmlWorkflow> models = new ArrayList<PmlWorkflow>(soapModels.length);

        for (PmlWorkflowSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _workflowId;
    }

    public void setPrimaryKey(long pk) {
        setWorkflowId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_workflowId);
    }

    public long getWorkflowId() {
        return _workflowId;
    }

    public void setWorkflowId(long workflowId) {
        if (workflowId != _workflowId) {
            _workflowId = workflowId;
        }
    }

    public String getFileTypeId() {
        return GetterUtil.getString(_fileTypeId);
    }

    public void setFileTypeId(String fileTypeId) {
        if (((fileTypeId == null) && (_fileTypeId != null)) ||
                ((fileTypeId != null) && (_fileTypeId == null)) ||
                ((fileTypeId != null) && (_fileTypeId != null) &&
                !fileTypeId.equals(_fileTypeId))) {
            _fileTypeId = fileTypeId;
        }
    }

    public String getWorkflow() {
        return GetterUtil.getString(_workflow);
    }

    public void setWorkflow(String workflow) {
        if (((workflow == null) && (_workflow != null)) ||
                ((workflow != null) && (_workflow == null)) ||
                ((workflow != null) && (_workflow != null) &&
                !workflow.equals(_workflow))) {
            _workflow = workflow;
        }
    }

    public int getVersion_() {
        return _version_;
    }

    public void setVersion_(int version_) {
        if (version_ != _version_) {
            _version_ = version_;
        }
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        if (((startDate == null) && (_startDate != null)) ||
                ((startDate != null) && (_startDate == null)) ||
                ((startDate != null) && (_startDate != null) &&
                !startDate.equals(_startDate))) {
            _startDate = startDate;
        }
    }

    public Date getEndDate() {
        return _endDate;
    }

    public void setEndDate(Date endDate) {
        if (((endDate == null) && (_endDate != null)) ||
                ((endDate != null) && (_endDate == null)) ||
                ((endDate != null) && (_endDate != null) &&
                !endDate.equals(_endDate))) {
            _endDate = endDate;
        }
    }

    public PmlWorkflow toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlWorkflow) this;
        } else {
            PmlWorkflow model = new PmlWorkflowImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setWorkflowId(getWorkflowId());
            model.setFileTypeId(HtmlUtil.escape(getFileTypeId()));
            model.setWorkflow(HtmlUtil.escape(getWorkflow()));
            model.setVersion_(getVersion_());
            model.setStartDate(getStartDate());
            model.setEndDate(getEndDate());

            model = (PmlWorkflow) Proxy.newProxyInstance(PmlWorkflow.class.getClassLoader(),
                    new Class[] { PmlWorkflow.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlWorkflowImpl clone = new PmlWorkflowImpl();

        clone.setWorkflowId(getWorkflowId());
        clone.setFileTypeId(getFileTypeId());
        clone.setWorkflow(getWorkflow());
        clone.setVersion_(getVersion_());
        clone.setStartDate(getStartDate());
        clone.setEndDate(getEndDate());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlWorkflowImpl pmlWorkflow = (PmlWorkflowImpl) obj;

        int value = 0;

        if (getWorkflowId() < pmlWorkflow.getWorkflowId()) {
            value = -1;
        } else if (getWorkflowId() > pmlWorkflow.getWorkflowId()) {
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

        PmlWorkflowImpl pmlWorkflow = null;

        try {
            pmlWorkflow = (PmlWorkflowImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlWorkflow.getPrimaryKey();

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
