package com.sgs.portlet.organizationexternal.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.model.OrganizationExternalSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="OrganizationExternalModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>OrganizationExternal</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.organizationexternal.model.OrganizationExternal
 * @see com.sgs.portlet.organizationexternal.model.OrganizationExternalModel
 * @see com.sgs.portlet.organizationexternal.model.impl.OrganizationExternalImpl
 *
 */
public class OrganizationExternalModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_organization_external";
    public static final Object[][] TABLE_COLUMNS = {
            { "orgexternalid", new Integer(Types.BIGINT) },
            

            { "orgexternalcode", new Integer(Types.VARCHAR) },
            

            { "orgexternalname", new Integer(Types.VARCHAR) },
            

            { "isownerorg", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_organization_external (orgexternalid LONG not null primary key,orgexternalcode VARCHAR(75) null,orgexternalname VARCHAR(75) null,isownerorg BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_organization_external";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.organizationexternal.model.OrganizationExternal"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.organizationexternal.model.OrganizationExternal"));
    private long _orgExternalId;
    private String _orgExternalCode;
    private String _orgExternalName;
    private boolean _isOwnerOrg;

    public OrganizationExternalModelImpl() {
    }

    public static OrganizationExternal toModel(
        OrganizationExternalSoap soapModel) {
        OrganizationExternal model = new OrganizationExternalImpl();

        model.setOrgExternalId(soapModel.getOrgExternalId());
        model.setOrgExternalCode(soapModel.getOrgExternalCode());
        model.setOrgExternalName(soapModel.getOrgExternalName());
        model.setIsOwnerOrg(soapModel.getIsOwnerOrg());

        return model;
    }

    public static List<OrganizationExternal> toModels(
        OrganizationExternalSoap[] soapModels) {
        List<OrganizationExternal> models = new ArrayList<OrganizationExternal>(soapModels.length);

        for (OrganizationExternalSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _orgExternalId;
    }

    public void setPrimaryKey(long pk) {
        setOrgExternalId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_orgExternalId);
    }

    public long getOrgExternalId() {
        return _orgExternalId;
    }

    public void setOrgExternalId(long orgExternalId) {
        if (orgExternalId != _orgExternalId) {
            _orgExternalId = orgExternalId;
        }
    }

    public String getOrgExternalCode() {
        return GetterUtil.getString(_orgExternalCode);
    }

    public void setOrgExternalCode(String orgExternalCode) {
        if (((orgExternalCode == null) && (_orgExternalCode != null)) ||
                ((orgExternalCode != null) && (_orgExternalCode == null)) ||
                ((orgExternalCode != null) && (_orgExternalCode != null) &&
                !orgExternalCode.equals(_orgExternalCode))) {
            _orgExternalCode = orgExternalCode;
        }
    }

    public String getOrgExternalName() {
        return GetterUtil.getString(_orgExternalName);
    }

    public void setOrgExternalName(String orgExternalName) {
        if (((orgExternalName == null) && (_orgExternalName != null)) ||
                ((orgExternalName != null) && (_orgExternalName == null)) ||
                ((orgExternalName != null) && (_orgExternalName != null) &&
                !orgExternalName.equals(_orgExternalName))) {
            _orgExternalName = orgExternalName;
        }
    }

    public boolean getIsOwnerOrg() {
        return _isOwnerOrg;
    }

    public boolean isIsOwnerOrg() {
        return _isOwnerOrg;
    }

    public void setIsOwnerOrg(boolean isOwnerOrg) {
        if (isOwnerOrg != _isOwnerOrg) {
            _isOwnerOrg = isOwnerOrg;
        }
    }

    public OrganizationExternal toEscapedModel() {
        if (isEscapedModel()) {
            return (OrganizationExternal) this;
        } else {
            OrganizationExternal model = new OrganizationExternalImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setOrgExternalId(getOrgExternalId());
            model.setOrgExternalCode(HtmlUtil.escape(getOrgExternalCode()));
            model.setOrgExternalName(HtmlUtil.escape(getOrgExternalName()));
            model.setIsOwnerOrg(getIsOwnerOrg());

            model = (OrganizationExternal) Proxy.newProxyInstance(OrganizationExternal.class.getClassLoader(),
                    new Class[] { OrganizationExternal.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        OrganizationExternalImpl clone = new OrganizationExternalImpl();

        clone.setOrgExternalId(getOrgExternalId());
        clone.setOrgExternalCode(getOrgExternalCode());
        clone.setOrgExternalName(getOrgExternalName());
        clone.setIsOwnerOrg(getIsOwnerOrg());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        OrganizationExternalImpl organizationExternal = (OrganizationExternalImpl) obj;

        int value = 0;

        value = getOrgExternalName().toLowerCase()
                    .compareTo(organizationExternal.getOrgExternalName()
                                                   .toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        OrganizationExternalImpl organizationExternal = null;

        try {
            organizationExternal = (OrganizationExternalImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = organizationExternal.getPrimaryKey();

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
