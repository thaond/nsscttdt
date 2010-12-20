package com.nss.portlet.agency.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.agency.model.Agency;
import com.nss.portlet.agency.model.AgencySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="AgencyModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Agency</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.agency.model.Agency
 * @see com.nss.portlet.agency.model.AgencyModel
 * @see com.nss.portlet.agency.model.impl.AgencyImpl
 *
 */
public class AgencyModelImpl extends BaseModelImpl<Agency> {
    public static final String TABLE_NAME = "pml_agency";
    public static final Object[][] TABLE_COLUMNS = {
            { "agencyid", new Integer(Types.VARCHAR) },
            

            { "agencycode", new Integer(Types.VARCHAR) },
            

            { "agencyname", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_agency (agencyid VARCHAR(75) not null primary key,agencycode VARCHAR(75) null,agencyname VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_agency";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.agency.model.Agency"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.agency.model.Agency"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.agency.model.Agency"));
    private String _agencyId;
    private String _agencyCode;
    private String _agencyName;
    private String _description;
    private String _active;

    public AgencyModelImpl() {
    }

    public static Agency toModel(AgencySoap soapModel) {
        Agency model = new AgencyImpl();

        model.setAgencyId(soapModel.getAgencyId());
        model.setAgencyCode(soapModel.getAgencyCode());
        model.setAgencyName(soapModel.getAgencyName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<Agency> toModels(AgencySoap[] soapModels) {
        List<Agency> models = new ArrayList<Agency>(soapModels.length);

        for (AgencySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _agencyId;
    }

    public void setPrimaryKey(String pk) {
        setAgencyId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _agencyId;
    }

    public String getAgencyId() {
        return GetterUtil.getString(_agencyId);
    }

    public void setAgencyId(String agencyId) {
        _agencyId = agencyId;
    }

    public String getAgencyCode() {
        return GetterUtil.getString(_agencyCode);
    }

    public void setAgencyCode(String agencyCode) {
        _agencyCode = agencyCode;
    }

    public String getAgencyName() {
        return GetterUtil.getString(_agencyName);
    }

    public void setAgencyName(String agencyName) {
        _agencyName = agencyName;
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

    public Agency toEscapedModel() {
        if (isEscapedModel()) {
            return (Agency) this;
        } else {
            Agency model = new AgencyImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setAgencyId(HtmlUtil.escape(getAgencyId()));
            model.setAgencyCode(HtmlUtil.escape(getAgencyCode()));
            model.setAgencyName(HtmlUtil.escape(getAgencyName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (Agency) Proxy.newProxyInstance(Agency.class.getClassLoader(),
                    new Class[] { Agency.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        AgencyImpl clone = new AgencyImpl();

        clone.setAgencyId(getAgencyId());
        clone.setAgencyCode(getAgencyCode());
        clone.setAgencyName(getAgencyName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Agency agency) {
        int value = 0;

        value = getAgencyName().toLowerCase()
                    .compareTo(agency.getAgencyName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Agency agency = null;

        try {
            agency = (Agency) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = agency.getPrimaryKey();

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

        sb.append("{agencyId=");
        sb.append(getAgencyId());
        sb.append(", agencyCode=");
        sb.append(getAgencyCode());
        sb.append(", agencyName=");
        sb.append(getAgencyName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.agency.model.Agency");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>agencyId</column-name><column-value><![CDATA[");
        sb.append(getAgencyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>agencyCode</column-name><column-value><![CDATA[");
        sb.append(getAgencyCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>agencyName</column-name><column-value><![CDATA[");
        sb.append(getAgencyName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
