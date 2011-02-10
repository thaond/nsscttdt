package com.sgs.portlet.onedoor.role.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoor.role.model.PmlRole;
import com.sgs.portlet.onedoor.role.model.PmlRoleSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlRoleModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlRole</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.role.model.PmlRole
 * @see com.sgs.portlet.onedoor.role.model.PmlRoleModel
 * @see com.sgs.portlet.onedoor.role.model.impl.PmlRoleImpl
 *
 */
public class PmlRoleModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_role";
    public static final Object[][] TABLE_COLUMNS = {
            { "roleid", new Integer(Types.VARCHAR) },
            

            { "rolecode", new Integer(Types.VARCHAR) },
            

            { "rolename", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_role (roleid VARCHAR(75) not null primary key,rolecode VARCHAR(75) null,rolename VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_role";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoor.role.model.PmlRole"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoor.role.model.PmlRole"));
    private String _roleId;
    private String _roleCode;
    private String _roleName;
    private String _description;
    private String _active;

    public PmlRoleModelImpl() {
    }

    public static PmlRole toModel(PmlRoleSoap soapModel) {
        PmlRole model = new PmlRoleImpl();

        model.setRoleId(soapModel.getRoleId());
        model.setRoleCode(soapModel.getRoleCode());
        model.setRoleName(soapModel.getRoleName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<PmlRole> toModels(PmlRoleSoap[] soapModels) {
        List<PmlRole> models = new ArrayList<PmlRole>(soapModels.length);

        for (PmlRoleSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _roleId;
    }

    public void setPrimaryKey(String pk) {
        setRoleId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _roleId;
    }

    public String getRoleId() {
        return GetterUtil.getString(_roleId);
    }

    public void setRoleId(String roleId) {
        if (((roleId == null) && (_roleId != null)) ||
                ((roleId != null) && (_roleId == null)) ||
                ((roleId != null) && (_roleId != null) &&
                !roleId.equals(_roleId))) {
            _roleId = roleId;
        }
    }

    public String getRoleCode() {
        return GetterUtil.getString(_roleCode);
    }

    public void setRoleCode(String roleCode) {
        if (((roleCode == null) && (_roleCode != null)) ||
                ((roleCode != null) && (_roleCode == null)) ||
                ((roleCode != null) && (_roleCode != null) &&
                !roleCode.equals(_roleCode))) {
            _roleCode = roleCode;
        }
    }

    public String getRoleName() {
        return GetterUtil.getString(_roleName);
    }

    public void setRoleName(String roleName) {
        if (((roleName == null) && (_roleName != null)) ||
                ((roleName != null) && (_roleName == null)) ||
                ((roleName != null) && (_roleName != null) &&
                !roleName.equals(_roleName))) {
            _roleName = roleName;
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

    public PmlRole toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlRole) this;
        } else {
            PmlRole model = new PmlRoleImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setRoleId(HtmlUtil.escape(getRoleId()));
            model.setRoleCode(HtmlUtil.escape(getRoleCode()));
            model.setRoleName(HtmlUtil.escape(getRoleName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (PmlRole) Proxy.newProxyInstance(PmlRole.class.getClassLoader(),
                    new Class[] { PmlRole.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlRoleImpl clone = new PmlRoleImpl();

        clone.setRoleId(getRoleId());
        clone.setRoleCode(getRoleCode());
        clone.setRoleName(getRoleName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlRoleImpl pmlRole = (PmlRoleImpl) obj;

        int value = 0;

        value = getRoleName().toLowerCase()
                    .compareTo(pmlRole.getRoleName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlRoleImpl pmlRole = null;

        try {
            pmlRole = (PmlRoleImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlRole.getPrimaryKey();

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
