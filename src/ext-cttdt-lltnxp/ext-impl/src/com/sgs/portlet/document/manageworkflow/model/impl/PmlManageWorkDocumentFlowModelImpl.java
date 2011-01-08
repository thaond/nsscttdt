package com.sgs.portlet.document.manageworkflow.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;
import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlowSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlManageWorkDocumentFlowModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlManageWorkDocumentFlow</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow
 * @see com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlowModel
 * @see com.sgs.portlet.document.manageworkflow.model.impl.PmlManageWorkDocumentFlowImpl
 *
 */
public class PmlManageWorkDocumentFlowModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_manage_documentworkflow";
    public static final Object[][] TABLE_COLUMNS = {
            { "managedocumentworkflowid", new Integer(Types.BIGINT) },
            

            { "workflowname", new Integer(Types.VARCHAR) },
            

            { "version_", new Integer(Types.INTEGER) },
            

            { "type_", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "startdate", new Integer(Types.TIMESTAMP) },
            

            { "enddate", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_manage_documentworkflow (managedocumentworkflowid LONG not null primary key,workflowname VARCHAR(75) null,version_ INTEGER,type_ INTEGER,description VARCHAR(75) null,startdate DATE null,enddate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table pml_manage_documentworkflow";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow"));
    private long _manageDocumentWorkFlowId;
    private String _workFlowName;
    private int _version;
    private int _type;
    private String _description;
    private Date _startDate;
    private Date _endDate;

    public PmlManageWorkDocumentFlowModelImpl() {
    }

    public static PmlManageWorkDocumentFlow toModel(
        PmlManageWorkDocumentFlowSoap soapModel) {
        PmlManageWorkDocumentFlow model = new PmlManageWorkDocumentFlowImpl();

        model.setManageDocumentWorkFlowId(soapModel.getManageDocumentWorkFlowId());
        model.setWorkFlowName(soapModel.getWorkFlowName());
        model.setVersion(soapModel.getVersion());
        model.setType(soapModel.getType());
        model.setDescription(soapModel.getDescription());
        model.setStartDate(soapModel.getStartDate());
        model.setEndDate(soapModel.getEndDate());

        return model;
    }

    public static List<PmlManageWorkDocumentFlow> toModels(
        PmlManageWorkDocumentFlowSoap[] soapModels) {
        List<PmlManageWorkDocumentFlow> models = new ArrayList<PmlManageWorkDocumentFlow>(soapModels.length);

        for (PmlManageWorkDocumentFlowSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _manageDocumentWorkFlowId;
    }

    public void setPrimaryKey(long pk) {
        setManageDocumentWorkFlowId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_manageDocumentWorkFlowId);
    }

    public long getManageDocumentWorkFlowId() {
        return _manageDocumentWorkFlowId;
    }

    public void setManageDocumentWorkFlowId(long manageDocumentWorkFlowId) {
        if (manageDocumentWorkFlowId != _manageDocumentWorkFlowId) {
            _manageDocumentWorkFlowId = manageDocumentWorkFlowId;
        }
    }

    public String getWorkFlowName() {
        return GetterUtil.getString(_workFlowName);
    }

    public void setWorkFlowName(String workFlowName) {
        if (((workFlowName == null) && (_workFlowName != null)) ||
                ((workFlowName != null) && (_workFlowName == null)) ||
                ((workFlowName != null) && (_workFlowName != null) &&
                !workFlowName.equals(_workFlowName))) {
            _workFlowName = workFlowName;
        }
    }

    public int getVersion() {
        return _version;
    }

    public void setVersion(int version) {
        if (version != _version) {
            _version = version;
        }
    }

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        if (type != _type) {
            _type = type;
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

    public PmlManageWorkDocumentFlow toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlManageWorkDocumentFlow) this;
        } else {
            PmlManageWorkDocumentFlow model = new PmlManageWorkDocumentFlowImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setManageDocumentWorkFlowId(getManageDocumentWorkFlowId());
            model.setWorkFlowName(HtmlUtil.escape(getWorkFlowName()));
            model.setVersion(getVersion());
            model.setType(getType());
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setStartDate(getStartDate());
            model.setEndDate(getEndDate());

            model = (PmlManageWorkDocumentFlow) Proxy.newProxyInstance(PmlManageWorkDocumentFlow.class.getClassLoader(),
                    new Class[] { PmlManageWorkDocumentFlow.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlManageWorkDocumentFlowImpl clone = new PmlManageWorkDocumentFlowImpl();

        clone.setManageDocumentWorkFlowId(getManageDocumentWorkFlowId());
        clone.setWorkFlowName(getWorkFlowName());
        clone.setVersion(getVersion());
        clone.setType(getType());
        clone.setDescription(getDescription());
        clone.setStartDate(getStartDate());
        clone.setEndDate(getEndDate());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlManageWorkDocumentFlowImpl pmlManageWorkDocumentFlow = (PmlManageWorkDocumentFlowImpl) obj;

        int value = 0;

        if (getManageDocumentWorkFlowId() < pmlManageWorkDocumentFlow.getManageDocumentWorkFlowId()) {
            value = -1;
        } else if (getManageDocumentWorkFlowId() > pmlManageWorkDocumentFlow.getManageDocumentWorkFlowId()) {
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

        PmlManageWorkDocumentFlowImpl pmlManageWorkDocumentFlow = null;

        try {
            pmlManageWorkDocumentFlow = (PmlManageWorkDocumentFlowImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlManageWorkDocumentFlow.getPrimaryKey();

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
