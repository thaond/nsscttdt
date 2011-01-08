package com.sgs.portlet.document.send.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.send.model.PmlEdmCadre;
import com.sgs.portlet.document.send.model.PmlEdmCadreSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmCadreModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmCadre</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmCadre
 * @see com.sgs.portlet.document.send.model.PmlEdmCadreModel
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmCadreImpl
 *
 */
public class PmlEdmCadreModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_cadre";
    public static final Object[][] TABLE_COLUMNS = {
            { "userid", new Integer(Types.BIGINT) },
            

            { "positionid", new Integer(Types.VARCHAR) },
            

            { "departmentsid", new Integer(Types.VARCHAR) },
            

            { "handphone", new Integer(Types.VARCHAR) },
            

            { "note", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_cadre (userid LONG not null primary key,positionid VARCHAR(75) null,departmentsid VARCHAR(75) null,handphone VARCHAR(75) null,note VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_cadre";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.send.model.PmlEdmCadre"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.send.model.PmlEdmCadre"));
    private long _userId;
    private String _positionId;
    private String _departmentsId;
    private String _handPhone;
    private String _note;
    private String _active;

    public PmlEdmCadreModelImpl() {
    }

    public static PmlEdmCadre toModel(PmlEdmCadreSoap soapModel) {
        PmlEdmCadre model = new PmlEdmCadreImpl();

        model.setUserId(soapModel.getUserId());
        model.setPositionId(soapModel.getPositionId());
        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setHandPhone(soapModel.getHandPhone());
        model.setNote(soapModel.getNote());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<PmlEdmCadre> toModels(PmlEdmCadreSoap[] soapModels) {
        List<PmlEdmCadre> models = new ArrayList<PmlEdmCadre>(soapModels.length);

        for (PmlEdmCadreSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_userId);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public String getPositionId() {
        return GetterUtil.getString(_positionId);
    }

    public void setPositionId(String positionId) {
        if (((positionId == null) && (_positionId != null)) ||
                ((positionId != null) && (_positionId == null)) ||
                ((positionId != null) && (_positionId != null) &&
                !positionId.equals(_positionId))) {
            _positionId = positionId;
        }
    }

    public String getDepartmentsId() {
        return GetterUtil.getString(_departmentsId);
    }

    public void setDepartmentsId(String departmentsId) {
        if (((departmentsId == null) && (_departmentsId != null)) ||
                ((departmentsId != null) && (_departmentsId == null)) ||
                ((departmentsId != null) && (_departmentsId != null) &&
                !departmentsId.equals(_departmentsId))) {
            _departmentsId = departmentsId;
        }
    }

    public String getHandPhone() {
        return GetterUtil.getString(_handPhone);
    }

    public void setHandPhone(String handPhone) {
        if (((handPhone == null) && (_handPhone != null)) ||
                ((handPhone != null) && (_handPhone == null)) ||
                ((handPhone != null) && (_handPhone != null) &&
                !handPhone.equals(_handPhone))) {
            _handPhone = handPhone;
        }
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        if (((note == null) && (_note != null)) ||
                ((note != null) && (_note == null)) ||
                ((note != null) && (_note != null) && !note.equals(_note))) {
            _note = note;
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

    public PmlEdmCadre toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmCadre) this;
        } else {
            PmlEdmCadre model = new PmlEdmCadreImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setUserId(getUserId());
            model.setPositionId(HtmlUtil.escape(getPositionId()));
            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));
            model.setHandPhone(HtmlUtil.escape(getHandPhone()));
            model.setNote(HtmlUtil.escape(getNote()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (PmlEdmCadre) Proxy.newProxyInstance(PmlEdmCadre.class.getClassLoader(),
                    new Class[] { PmlEdmCadre.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmCadreImpl clone = new PmlEdmCadreImpl();

        clone.setUserId(getUserId());
        clone.setPositionId(getPositionId());
        clone.setDepartmentsId(getDepartmentsId());
        clone.setHandPhone(getHandPhone());
        clone.setNote(getNote());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmCadreImpl pmlEdmCadre = (PmlEdmCadreImpl) obj;

        int value = 0;

        if (getUserId() < pmlEdmCadre.getUserId()) {
            value = -1;
        } else if (getUserId() > pmlEdmCadre.getUserId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlEdmCadreImpl pmlEdmCadre = null;

        try {
            pmlEdmCadre = (PmlEdmCadreImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmCadre.getPrimaryKey();

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
