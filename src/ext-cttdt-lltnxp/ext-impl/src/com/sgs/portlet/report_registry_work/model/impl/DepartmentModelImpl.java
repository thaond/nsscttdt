package com.sgs.portlet.report_registry_work.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.report_registry_work.model.Department;
import com.sgs.portlet.report_registry_work.model.DepartmentSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="DepartmentModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Department</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.model.Department
 * @see com.sgs.portlet.report_registry_work.model.DepartmentModel
 * @see com.sgs.portlet.report_registry_work.model.impl.DepartmentImpl
 *
 */
public class DepartmentModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "department";
    public static final Object[][] TABLE_COLUMNS = {
            { "departmentId", new Integer(Types.BIGINT) },
            

            { "departmentCode", new Integer(Types.VARCHAR) },
            

            { "departmentName", new Integer(Types.VARCHAR) },
            

            { "departmentDescription", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table department (departmentId LONG not null primary key,departmentCode VARCHAR(75) null,departmentName VARCHAR(75) null,departmentDescription VARCHAR(75) null,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table department";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.report_registry_work.model.Department"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.report_registry_work.model.Department"));
    private long _departmentId;
    private String _departmentCode;
    private String _departmentName;
    private String _departmentDescription;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public DepartmentModelImpl() {
    }

    public static Department toModel(DepartmentSoap soapModel) {
        Department model = new DepartmentImpl();

        model.setDepartmentId(soapModel.getDepartmentId());
        model.setDepartmentCode(soapModel.getDepartmentCode());
        model.setDepartmentName(soapModel.getDepartmentName());
        model.setDepartmentDescription(soapModel.getDepartmentDescription());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<Department> toModels(DepartmentSoap[] soapModels) {
        List<Department> models = new ArrayList<Department>(soapModels.length);

        for (DepartmentSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _departmentId;
    }

    public void setPrimaryKey(long pk) {
        setDepartmentId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_departmentId);
    }

    public long getDepartmentId() {
        return _departmentId;
    }

    public void setDepartmentId(long departmentId) {
        if (departmentId != _departmentId) {
            _departmentId = departmentId;
        }
    }

    public String getDepartmentCode() {
        return GetterUtil.getString(_departmentCode);
    }

    public void setDepartmentCode(String departmentCode) {
        if (((departmentCode == null) && (_departmentCode != null)) ||
                ((departmentCode != null) && (_departmentCode == null)) ||
                ((departmentCode != null) && (_departmentCode != null) &&
                !departmentCode.equals(_departmentCode))) {
            _departmentCode = departmentCode;
        }
    }

    public String getDepartmentName() {
        return GetterUtil.getString(_departmentName);
    }

    public void setDepartmentName(String departmentName) {
        if (((departmentName == null) && (_departmentName != null)) ||
                ((departmentName != null) && (_departmentName == null)) ||
                ((departmentName != null) && (_departmentName != null) &&
                !departmentName.equals(_departmentName))) {
            _departmentName = departmentName;
        }
    }

    public String getDepartmentDescription() {
        return GetterUtil.getString(_departmentDescription);
    }

    public void setDepartmentDescription(String departmentDescription) {
        if (((departmentDescription == null) &&
                (_departmentDescription != null)) ||
                ((departmentDescription != null) &&
                (_departmentDescription == null)) ||
                ((departmentDescription != null) &&
                (_departmentDescription != null) &&
                !departmentDescription.equals(_departmentDescription))) {
            _departmentDescription = departmentDescription;
        }
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        if (groupId != _groupId) {
            _groupId = groupId;
        }
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        if (companyId != _companyId) {
            _companyId = companyId;
        }
    }

    public Department toEscapedModel() {
        if (isEscapedModel()) {
            return (Department) this;
        } else {
            Department model = new DepartmentImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDepartmentId(getDepartmentId());
            model.setDepartmentCode(HtmlUtil.escape(getDepartmentCode()));
            model.setDepartmentName(HtmlUtil.escape(getDepartmentName()));
            model.setDepartmentDescription(HtmlUtil.escape(
                    getDepartmentDescription()));
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (Department) Proxy.newProxyInstance(Department.class.getClassLoader(),
                    new Class[] { Department.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        DepartmentImpl clone = new DepartmentImpl();

        clone.setDepartmentId(getDepartmentId());
        clone.setDepartmentCode(getDepartmentCode());
        clone.setDepartmentName(getDepartmentName());
        clone.setDepartmentDescription(getDepartmentDescription());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        DepartmentImpl department = (DepartmentImpl) obj;

        long pk = department.getPrimaryKey();

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

        DepartmentImpl department = null;

        try {
            department = (DepartmentImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = department.getPrimaryKey();

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
