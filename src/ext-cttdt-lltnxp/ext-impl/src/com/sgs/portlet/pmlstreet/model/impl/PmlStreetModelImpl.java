package com.sgs.portlet.pmlstreet.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pmlstreet.model.PmlStreet;
import com.sgs.portlet.pmlstreet.model.PmlStreetSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlStreetModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlStreet</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlstreet.model.PmlStreet
 * @see com.sgs.portlet.pmlstreet.model.PmlStreetModel
 * @see com.sgs.portlet.pmlstreet.model.impl.PmlStreetImpl
 *
 */
public class PmlStreetModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_street";
    public static final Object[][] TABLE_COLUMNS = {
            { "streetId", new Integer(Types.VARCHAR) },
            

            { "streetName", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_street (streetId VARCHAR(75) not null primary key,streetName VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_street";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pmlstreet.model.PmlStreet"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pmlstreet.model.PmlStreet"));
    private String _streetId;
    private String _streetName;

    public PmlStreetModelImpl() {
    }

    public static PmlStreet toModel(PmlStreetSoap soapModel) {
        PmlStreet model = new PmlStreetImpl();

        model.setStreetId(soapModel.getStreetId());
        model.setStreetName(soapModel.getStreetName());

        return model;
    }

    public static List<PmlStreet> toModels(PmlStreetSoap[] soapModels) {
        List<PmlStreet> models = new ArrayList<PmlStreet>(soapModels.length);

        for (PmlStreetSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _streetId;
    }

    public void setPrimaryKey(String pk) {
        setStreetId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _streetId;
    }

    public String getStreetId() {
        return GetterUtil.getString(_streetId);
    }

    public void setStreetId(String streetId) {
        if (((streetId == null) && (_streetId != null)) ||
                ((streetId != null) && (_streetId == null)) ||
                ((streetId != null) && (_streetId != null) &&
                !streetId.equals(_streetId))) {
            _streetId = streetId;
        }
    }

    public String getStreetName() {
        return GetterUtil.getString(_streetName);
    }

    public void setStreetName(String streetName) {
        if (((streetName == null) && (_streetName != null)) ||
                ((streetName != null) && (_streetName == null)) ||
                ((streetName != null) && (_streetName != null) &&
                !streetName.equals(_streetName))) {
            _streetName = streetName;
        }
    }

    public PmlStreet toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlStreet) this;
        } else {
            PmlStreet model = new PmlStreetImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setStreetId(HtmlUtil.escape(getStreetId()));
            model.setStreetName(HtmlUtil.escape(getStreetName()));

            model = (PmlStreet) Proxy.newProxyInstance(PmlStreet.class.getClassLoader(),
                    new Class[] { PmlStreet.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlStreetImpl clone = new PmlStreetImpl();

        clone.setStreetId(getStreetId());
        clone.setStreetName(getStreetName());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlStreetImpl pmlStreet = (PmlStreetImpl) obj;

        int value = 0;

        value = getStreetName().toLowerCase()
                    .compareTo(pmlStreet.getStreetName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlStreetImpl pmlStreet = null;

        try {
            pmlStreet = (PmlStreetImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlStreet.getPrimaryKey();

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
