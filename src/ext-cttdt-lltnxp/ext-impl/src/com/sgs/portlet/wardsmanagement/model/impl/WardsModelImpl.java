package com.sgs.portlet.wardsmanagement.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.model.WardsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="WardsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Wards</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.wardsmanagement.model.Wards
 * @see com.sgs.portlet.wardsmanagement.model.WardsModel
 * @see com.sgs.portlet.wardsmanagement.model.impl.WardsImpl
 *
 */
public class WardsModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_wards";
    public static final Object[][] TABLE_COLUMNS = {
            { "wardsId", new Integer(Types.VARCHAR) },
            

            { "wardsCode", new Integer(Types.VARCHAR) },
            

            { "wardsName", new Integer(Types.VARCHAR) },
            

            { "districtId", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_wards (wardsId VARCHAR(75) not null primary key,wardsCode VARCHAR(75) null,wardsName VARCHAR(75) null,districtId VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_wards";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.wardsmanagement.model.Wards"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.wardsmanagement.model.Wards"));
    private String _wardsId;
    private String _wardsCode;
    private String _wardsName;
    private String _districtId;
    private String _description;
    private String _active;

    public WardsModelImpl() {
    }

    public static Wards toModel(WardsSoap soapModel) {
        Wards model = new WardsImpl();

        model.setWardsId(soapModel.getWardsId());
        model.setWardsCode(soapModel.getWardsCode());
        model.setWardsName(soapModel.getWardsName());
        model.setDistrictId(soapModel.getDistrictId());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<Wards> toModels(WardsSoap[] soapModels) {
        List<Wards> models = new ArrayList<Wards>(soapModels.length);

        for (WardsSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _wardsId;
    }

    public void setPrimaryKey(String pk) {
        setWardsId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _wardsId;
    }

    public String getWardsId() {
        return GetterUtil.getString(_wardsId);
    }

    public void setWardsId(String wardsId) {
        if (((wardsId == null) && (_wardsId != null)) ||
                ((wardsId != null) && (_wardsId == null)) ||
                ((wardsId != null) && (_wardsId != null) &&
                !wardsId.equals(_wardsId))) {
            _wardsId = wardsId;
        }
    }

    public String getWardsCode() {
        return GetterUtil.getString(_wardsCode);
    }

    public void setWardsCode(String wardsCode) {
        if (((wardsCode == null) && (_wardsCode != null)) ||
                ((wardsCode != null) && (_wardsCode == null)) ||
                ((wardsCode != null) && (_wardsCode != null) &&
                !wardsCode.equals(_wardsCode))) {
            _wardsCode = wardsCode;
        }
    }

    public String getWardsName() {
        return GetterUtil.getString(_wardsName);
    }

    public void setWardsName(String wardsName) {
        if (((wardsName == null) && (_wardsName != null)) ||
                ((wardsName != null) && (_wardsName == null)) ||
                ((wardsName != null) && (_wardsName != null) &&
                !wardsName.equals(_wardsName))) {
            _wardsName = wardsName;
        }
    }

    public String getDistrictId() {
        return GetterUtil.getString(_districtId);
    }

    public void setDistrictId(String districtId) {
        if (((districtId == null) && (_districtId != null)) ||
                ((districtId != null) && (_districtId == null)) ||
                ((districtId != null) && (_districtId != null) &&
                !districtId.equals(_districtId))) {
            _districtId = districtId;
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

    public Wards toEscapedModel() {
        if (isEscapedModel()) {
            return (Wards) this;
        } else {
            Wards model = new WardsImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setWardsId(HtmlUtil.escape(getWardsId()));
            model.setWardsCode(HtmlUtil.escape(getWardsCode()));
            model.setWardsName(HtmlUtil.escape(getWardsName()));
            model.setDistrictId(HtmlUtil.escape(getDistrictId()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (Wards) Proxy.newProxyInstance(Wards.class.getClassLoader(),
                    new Class[] { Wards.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        WardsImpl clone = new WardsImpl();

        clone.setWardsId(getWardsId());
        clone.setWardsCode(getWardsCode());
        clone.setWardsName(getWardsName());
        clone.setDistrictId(getDistrictId());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        WardsImpl wards = (WardsImpl) obj;

        int value = 0;

        value = getWardsName().toLowerCase()
                    .compareTo(wards.getWardsName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        WardsImpl wards = null;

        try {
            wards = (WardsImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = wards.getPrimaryKey();

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
