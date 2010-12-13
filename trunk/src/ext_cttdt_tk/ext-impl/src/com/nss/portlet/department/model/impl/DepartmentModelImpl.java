package com.nss.portlet.department.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.model.DepartmentSoap;

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
 * @see com.nss.portlet.department.model.Department
 * @see com.nss.portlet.department.model.DepartmentModel
 * @see com.nss.portlet.department.model.impl.DepartmentImpl
 *
 */
public class DepartmentModelImpl extends BaseModelImpl<Department> {
    public static final String TABLE_NAME = "pml_departments";
    public static final Object[][] TABLE_COLUMNS = {
            { "departmentsid", new Integer(Types.VARCHAR) },
            

            { "departmentsparentid", new Integer(Types.VARCHAR) },
            

            { "departmentscode", new Integer(Types.VARCHAR) },
            

            { "departmentsname", new Integer(Types.VARCHAR) },
            

            { "abbreviatename", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "agencyid", new Integer(Types.VARCHAR) },
            

            { "roleid", new Integer(Types.BIGINT) },
            

            { "hasteam", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_departments (departmentsid VARCHAR(75) not null primary key,departmentsparentid VARCHAR(75) null,departmentscode VARCHAR(75) null,departmentsname VARCHAR(75) null,abbreviatename VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null,agencyid VARCHAR(75) null,roleid LONG,hasteam VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_departments";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.department.model.Department"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.department.model.Department"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.department.model.Department"));
    private String _departmentsId;
    private String _departmentsParentId;
    private String _departmentsCode;
    private String _departmentsName;
    private String _abbreviateName;
    private String _description;
    private String _active;
    private String _agencyId;
    private long _roleId;
    private String _hasTeam;

    public DepartmentModelImpl() {
    }

    public static Department toModel(DepartmentSoap soapModel) {
        Department model = new DepartmentImpl();

        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setDepartmentsParentId(soapModel.getDepartmentsParentId());
        model.setDepartmentsCode(soapModel.getDepartmentsCode());
        model.setDepartmentsName(soapModel.getDepartmentsName());
        model.setAbbreviateName(soapModel.getAbbreviateName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());
        model.setAgencyId(soapModel.getAgencyId());
        model.setRoleId(soapModel.getRoleId());
        model.setHasTeam(soapModel.getHasTeam());

        return model;
    }

    public static List<Department> toModels(DepartmentSoap[] soapModels) {
        List<Department> models = new ArrayList<Department>(soapModels.length);

        for (DepartmentSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _departmentsId;
    }

    public void setPrimaryKey(String pk) {
        setDepartmentsId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _departmentsId;
    }

    public String getDepartmentsId() {
        return GetterUtil.getString(_departmentsId);
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public String getDepartmentsParentId() {
        return GetterUtil.getString(_departmentsParentId);
    }

    public void setDepartmentsParentId(String departmentsParentId) {
        _departmentsParentId = departmentsParentId;
    }

    public String getDepartmentsCode() {
        return GetterUtil.getString(_departmentsCode);
    }

    public void setDepartmentsCode(String departmentsCode) {
        _departmentsCode = departmentsCode;
    }

    public String getDepartmentsName() {
        return GetterUtil.getString(_departmentsName);
    }

    public void setDepartmentsName(String departmentsName) {
        _departmentsName = departmentsName;
    }

    public String getAbbreviateName() {
        return GetterUtil.getString(_abbreviateName);
    }

    public void setAbbreviateName(String abbreviateName) {
        _abbreviateName = abbreviateName;
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

    public String getAgencyId() {
        return GetterUtil.getString(_agencyId);
    }

    public void setAgencyId(String agencyId) {
        _agencyId = agencyId;
    }

    public long getRoleId() {
        return _roleId;
    }

    public void setRoleId(long roleId) {
        _roleId = roleId;
    }

    public String getHasTeam() {
        return GetterUtil.getString(_hasTeam);
    }

    public void setHasTeam(String hasTeam) {
        _hasTeam = hasTeam;
    }

    public Department toEscapedModel() {
        if (isEscapedModel()) {
            return (Department) this;
        } else {
            Department model = new DepartmentImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));
            model.setDepartmentsParentId(HtmlUtil.escape(
                    getDepartmentsParentId()));
            model.setDepartmentsCode(HtmlUtil.escape(getDepartmentsCode()));
            model.setDepartmentsName(HtmlUtil.escape(getDepartmentsName()));
            model.setAbbreviateName(HtmlUtil.escape(getAbbreviateName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setAgencyId(HtmlUtil.escape(getAgencyId()));
            model.setRoleId(getRoleId());
            model.setHasTeam(HtmlUtil.escape(getHasTeam()));

            model = (Department) Proxy.newProxyInstance(Department.class.getClassLoader(),
                    new Class[] { Department.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        DepartmentImpl clone = new DepartmentImpl();

        clone.setDepartmentsId(getDepartmentsId());
        clone.setDepartmentsParentId(getDepartmentsParentId());
        clone.setDepartmentsCode(getDepartmentsCode());
        clone.setDepartmentsName(getDepartmentsName());
        clone.setAbbreviateName(getAbbreviateName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());
        clone.setAgencyId(getAgencyId());
        clone.setRoleId(getRoleId());
        clone.setHasTeam(getHasTeam());

        return clone;
    }

    public int compareTo(Department department) {
        int value = 0;

        value = getDepartmentsName().toLowerCase()
                    .compareTo(department.getDepartmentsName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Department department = null;

        try {
            department = (Department) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = department.getPrimaryKey();

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

        sb.append("{departmentsId=");
        sb.append(getDepartmentsId());
        sb.append(", departmentsParentId=");
        sb.append(getDepartmentsParentId());
        sb.append(", departmentsCode=");
        sb.append(getDepartmentsCode());
        sb.append(", departmentsName=");
        sb.append(getDepartmentsName());
        sb.append(", abbreviateName=");
        sb.append(getAbbreviateName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", agencyId=");
        sb.append(getAgencyId());
        sb.append(", roleId=");
        sb.append(getRoleId());
        sb.append(", hasTeam=");
        sb.append(getHasTeam());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.department.model.Department");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>departmentsId</column-name><column-value><![CDATA[");
        sb.append(getDepartmentsId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>departmentsParentId</column-name><column-value><![CDATA[");
        sb.append(getDepartmentsParentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>departmentsCode</column-name><column-value><![CDATA[");
        sb.append(getDepartmentsCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>departmentsName</column-name><column-value><![CDATA[");
        sb.append(getDepartmentsName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>abbreviateName</column-name><column-value><![CDATA[");
        sb.append(getAbbreviateName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>agencyId</column-name><column-value><![CDATA[");
        sb.append(getAgencyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>roleId</column-name><column-value><![CDATA[");
        sb.append(getRoleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasTeam</column-name><column-value><![CDATA[");
        sb.append(getHasTeam());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
