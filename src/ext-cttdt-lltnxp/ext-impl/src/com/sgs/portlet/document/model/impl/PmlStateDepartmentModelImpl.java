package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlStateDepartment;
import com.sgs.portlet.document.model.PmlStateDepartmentSoap;
import com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlStateDepartmentModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlStateDepartment</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlStateDepartment
 * @see com.sgs.portlet.document.model.PmlStateDepartmentModel
 * @see com.sgs.portlet.document.model.impl.PmlStateDepartmentImpl
 *
 */
public class PmlStateDepartmentModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_state_department";
    public static final Object[][] TABLE_COLUMNS = {
            { "departmentid", new Integer(Types.VARCHAR) },
            

            { "statewfid", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_state_department (departmentid VARCHAR(75) not null,statewfid LONG not null,primary key (departmentid, statewfid))";
    public static final String TABLE_SQL_DROP = "drop table pml_state_department";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlStateDepartment"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlStateDepartment"));
    private String _departmentId;
    private long _stateWfId;

    public PmlStateDepartmentModelImpl() {
    }

    public static PmlStateDepartment toModel(PmlStateDepartmentSoap soapModel) {
        PmlStateDepartment model = new PmlStateDepartmentImpl();

        model.setDepartmentId(soapModel.getDepartmentId());
        model.setStateWfId(soapModel.getStateWfId());

        return model;
    }

    public static List<PmlStateDepartment> toModels(
        PmlStateDepartmentSoap[] soapModels) {
        List<PmlStateDepartment> models = new ArrayList<PmlStateDepartment>(soapModels.length);

        for (PmlStateDepartmentSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public PmlStateDepartmentPK getPrimaryKey() {
        return new PmlStateDepartmentPK(_departmentId, _stateWfId);
    }

    public void setPrimaryKey(PmlStateDepartmentPK pk) {
        setDepartmentId(pk.departmentId);
        setStateWfId(pk.stateWfId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PmlStateDepartmentPK(_departmentId, _stateWfId);
    }

    public String getDepartmentId() {
        return GetterUtil.getString(_departmentId);
    }

    public void setDepartmentId(String departmentId) {
        if (((departmentId == null) && (_departmentId != null)) ||
                ((departmentId != null) && (_departmentId == null)) ||
                ((departmentId != null) && (_departmentId != null) &&
                !departmentId.equals(_departmentId))) {
            _departmentId = departmentId;
        }
    }

    public long getStateWfId() {
        return _stateWfId;
    }

    public void setStateWfId(long stateWfId) {
        if (stateWfId != _stateWfId) {
            _stateWfId = stateWfId;
        }
    }

    public PmlStateDepartment toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlStateDepartment) this;
        } else {
            PmlStateDepartment model = new PmlStateDepartmentImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDepartmentId(HtmlUtil.escape(getDepartmentId()));
            model.setStateWfId(getStateWfId());

            model = (PmlStateDepartment) Proxy.newProxyInstance(PmlStateDepartment.class.getClassLoader(),
                    new Class[] { PmlStateDepartment.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlStateDepartmentImpl clone = new PmlStateDepartmentImpl();

        clone.setDepartmentId(getDepartmentId());
        clone.setStateWfId(getStateWfId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlStateDepartmentImpl pmlStateDepartment = (PmlStateDepartmentImpl) obj;

        PmlStateDepartmentPK pk = pmlStateDepartment.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlStateDepartmentImpl pmlStateDepartment = null;

        try {
            pmlStateDepartment = (PmlStateDepartmentImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PmlStateDepartmentPK pk = pmlStateDepartment.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }
}
