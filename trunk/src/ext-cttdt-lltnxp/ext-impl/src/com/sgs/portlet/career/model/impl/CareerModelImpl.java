package com.sgs.portlet.career.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.career.model.Career;
import com.sgs.portlet.career.model.CareerSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="CareerModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Career</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.career.model.Career
 * @see com.sgs.portlet.career.model.CareerModel
 * @see com.sgs.portlet.career.model.impl.CareerImpl
 *
 */
public class CareerModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_career";
    public static final Object[][] TABLE_COLUMNS = {
            { "careerid", new Integer(Types.VARCHAR) },
            

            { "careercode", new Integer(Types.VARCHAR) },
            

            { "careername", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_career (careerid VARCHAR(75) not null primary key,careercode VARCHAR(75) null,careername VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_career";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.career.model.Career"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.career.model.Career"));
    private String _careerId;
    private String _careerCode;
    private String _careerName;
    private String _description;
    private String _active;

    public CareerModelImpl() {
    }

    public static Career toModel(CareerSoap soapModel) {
        Career model = new CareerImpl();

        model.setCareerId(soapModel.getCareerId());
        model.setCareerCode(soapModel.getCareerCode());
        model.setCareerName(soapModel.getCareerName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<Career> toModels(CareerSoap[] soapModels) {
        List<Career> models = new ArrayList<Career>(soapModels.length);

        for (CareerSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _careerId;
    }

    public void setPrimaryKey(String pk) {
        setCareerId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _careerId;
    }

    public String getCareerId() {
        return GetterUtil.getString(_careerId);
    }

    public void setCareerId(String careerId) {
        if (((careerId == null) && (_careerId != null)) ||
                ((careerId != null) && (_careerId == null)) ||
                ((careerId != null) && (_careerId != null) &&
                !careerId.equals(_careerId))) {
            _careerId = careerId;
        }
    }

    public String getCareerCode() {
        return GetterUtil.getString(_careerCode);
    }

    public void setCareerCode(String careerCode) {
        if (((careerCode == null) && (_careerCode != null)) ||
                ((careerCode != null) && (_careerCode == null)) ||
                ((careerCode != null) && (_careerCode != null) &&
                !careerCode.equals(_careerCode))) {
            _careerCode = careerCode;
        }
    }

    public String getCareerName() {
        return GetterUtil.getString(_careerName);
    }

    public void setCareerName(String careerName) {
        if (((careerName == null) && (_careerName != null)) ||
                ((careerName != null) && (_careerName == null)) ||
                ((careerName != null) && (_careerName != null) &&
                !careerName.equals(_careerName))) {
            _careerName = careerName;
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

    public Career toEscapedModel() {
        if (isEscapedModel()) {
            return (Career) this;
        } else {
            Career model = new CareerImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setCareerId(HtmlUtil.escape(getCareerId()));
            model.setCareerCode(HtmlUtil.escape(getCareerCode()));
            model.setCareerName(HtmlUtil.escape(getCareerName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (Career) Proxy.newProxyInstance(Career.class.getClassLoader(),
                    new Class[] { Career.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        CareerImpl clone = new CareerImpl();

        clone.setCareerId(getCareerId());
        clone.setCareerCode(getCareerCode());
        clone.setCareerName(getCareerName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        CareerImpl career = (CareerImpl) obj;

        int value = 0;

        value = getCareerName().toLowerCase()
                    .compareTo(career.getCareerName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        CareerImpl career = null;

        try {
            career = (CareerImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = career.getPrimaryKey();

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
