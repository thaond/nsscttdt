package com.sgs.portlet.agency.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.model.AgencySoap;

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
 * @see com.sgs.portlet.agency.model.Agency
 * @see com.sgs.portlet.agency.model.AgencyModel
 * @see com.sgs.portlet.agency.model.impl.AgencyImpl
 *
 */
public class AgencyModelImpl extends BaseModelImpl {
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
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.agency.model.Agency"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.agency.model.Agency"));
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
        if (((agencyId == null) && (_agencyId != null)) ||
                ((agencyId != null) && (_agencyId == null)) ||
                ((agencyId != null) && (_agencyId != null) &&
                !agencyId.equals(_agencyId))) {
            _agencyId = agencyId;
        }
    }

    public String getAgencyCode() {
        return GetterUtil.getString(_agencyCode);
    }

    public void setAgencyCode(String agencyCode) {
        if (((agencyCode == null) && (_agencyCode != null)) ||
                ((agencyCode != null) && (_agencyCode == null)) ||
                ((agencyCode != null) && (_agencyCode != null) &&
                !agencyCode.equals(_agencyCode))) {
            _agencyCode = agencyCode;
        }
    }

    public String getAgencyName() {
        return GetterUtil.getString(_agencyName);
    }

    public void setAgencyName(String agencyName) {
        if (((agencyName == null) && (_agencyName != null)) ||
                ((agencyName != null) && (_agencyName == null)) ||
                ((agencyName != null) && (_agencyName != null) &&
                !agencyName.equals(_agencyName))) {
            _agencyName = agencyName;
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

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        AgencyImpl agency = (AgencyImpl) obj;

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

        AgencyImpl agency = null;

        try {
            agency = (AgencyImpl) obj;
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
}
