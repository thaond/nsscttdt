package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlStateWorkFlow;
import com.sgs.portlet.document.model.PmlStateWorkFlowSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlStateWorkFlowModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlStateWorkFlow</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlStateWorkFlow
 * @see com.sgs.portlet.document.model.PmlStateWorkFlowModel
 * @see com.sgs.portlet.document.model.impl.PmlStateWorkFlowImpl
 *
 */
public class PmlStateWorkFlowModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_state_wf";
    public static final Object[][] TABLE_COLUMNS = {
            { "statewfid", new Integer(Types.BIGINT) },
            

            { "workflow", new Integer(Types.VARCHAR) },
            

            { "stateprocessid", new Integer(Types.BIGINT) },
            

            { "solvingtime", new Integer(Types.INTEGER) },
            

            { "version_", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_state_wf (statewfid LONG not null primary key,workflow VARCHAR(75) null,stateprocessid LONG,solvingtime INTEGER,version_ INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table pml_state_wf";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlStateWorkFlow"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlStateWorkFlow"));
    private long _stateWfId;
    private String _workflow;
    private long _stateProcessId;
    private int _solvingTime;
    private int _version_;

    public PmlStateWorkFlowModelImpl() {
    }

    public static PmlStateWorkFlow toModel(PmlStateWorkFlowSoap soapModel) {
        PmlStateWorkFlow model = new PmlStateWorkFlowImpl();

        model.setStateWfId(soapModel.getStateWfId());
        model.setWorkflow(soapModel.getWorkflow());
        model.setStateProcessId(soapModel.getStateProcessId());
        model.setSolvingTime(soapModel.getSolvingTime());
        model.setVersion_(soapModel.getVersion_());

        return model;
    }

    public static List<PmlStateWorkFlow> toModels(
        PmlStateWorkFlowSoap[] soapModels) {
        List<PmlStateWorkFlow> models = new ArrayList<PmlStateWorkFlow>(soapModels.length);

        for (PmlStateWorkFlowSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _stateWfId;
    }

    public void setPrimaryKey(long pk) {
        setStateWfId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_stateWfId);
    }

    public long getStateWfId() {
        return _stateWfId;
    }

    public void setStateWfId(long stateWfId) {
        if (stateWfId != _stateWfId) {
            _stateWfId = stateWfId;
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

    public long getStateProcessId() {
        return _stateProcessId;
    }

    public void setStateProcessId(long stateProcessId) {
        if (stateProcessId != _stateProcessId) {
            _stateProcessId = stateProcessId;
        }
    }

    public int getSolvingTime() {
        return _solvingTime;
    }

    public void setSolvingTime(int solvingTime) {
        if (solvingTime != _solvingTime) {
            _solvingTime = solvingTime;
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

    public PmlStateWorkFlow toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlStateWorkFlow) this;
        } else {
            PmlStateWorkFlow model = new PmlStateWorkFlowImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setStateWfId(getStateWfId());
            model.setWorkflow(HtmlUtil.escape(getWorkflow()));
            model.setStateProcessId(getStateProcessId());
            model.setSolvingTime(getSolvingTime());
            model.setVersion_(getVersion_());

            model = (PmlStateWorkFlow) Proxy.newProxyInstance(PmlStateWorkFlow.class.getClassLoader(),
                    new Class[] { PmlStateWorkFlow.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlStateWorkFlowImpl clone = new PmlStateWorkFlowImpl();

        clone.setStateWfId(getStateWfId());
        clone.setWorkflow(getWorkflow());
        clone.setStateProcessId(getStateProcessId());
        clone.setSolvingTime(getSolvingTime());
        clone.setVersion_(getVersion_());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlStateWorkFlowImpl pmlStateWorkFlow = (PmlStateWorkFlowImpl) obj;

        int value = 0;

        if (getStateWfId() < pmlStateWorkFlow.getStateWfId()) {
            value = -1;
        } else if (getStateWfId() > pmlStateWorkFlow.getStateWfId()) {
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

        PmlStateWorkFlowImpl pmlStateWorkFlow = null;

        try {
            pmlStateWorkFlow = (PmlStateWorkFlowImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlStateWorkFlow.getPrimaryKey();

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
