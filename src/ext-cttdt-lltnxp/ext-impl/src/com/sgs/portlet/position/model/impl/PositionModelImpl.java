package com.sgs.portlet.position.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.model.PositionSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PositionModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Position</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.position.model.Position
 * @see com.sgs.portlet.position.model.PositionModel
 * @see com.sgs.portlet.position.model.impl.PositionImpl
 *
 */
public class PositionModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_position";
    public static final Object[][] TABLE_COLUMNS = {
            { "positionid", new Integer(Types.VARCHAR) },
            

            { "positioncode", new Integer(Types.VARCHAR) },
            

            { "positionname", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_position (positionid VARCHAR(75) not null primary key,positioncode VARCHAR(75) null,positionname VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_position";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.position.model.Position"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.position.model.Position"));
    private String _positionId;
    private String _positionCode;
    private String _positionName;
    private String _description;
    private String _active;

    public PositionModelImpl() {
    }

    public static Position toModel(PositionSoap soapModel) {
        Position model = new PositionImpl();

        model.setPositionId(soapModel.getPositionId());
        model.setPositionCode(soapModel.getPositionCode());
        model.setPositionName(soapModel.getPositionName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<Position> toModels(PositionSoap[] soapModels) {
        List<Position> models = new ArrayList<Position>(soapModels.length);

        for (PositionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _positionId;
    }

    public void setPrimaryKey(String pk) {
        setPositionId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _positionId;
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

    public String getPositionCode() {
        return GetterUtil.getString(_positionCode);
    }

    public void setPositionCode(String positionCode) {
        if (((positionCode == null) && (_positionCode != null)) ||
                ((positionCode != null) && (_positionCode == null)) ||
                ((positionCode != null) && (_positionCode != null) &&
                !positionCode.equals(_positionCode))) {
            _positionCode = positionCode;
        }
    }

    public String getPositionName() {
        return GetterUtil.getString(_positionName);
    }

    public void setPositionName(String positionName) {
        if (((positionName == null) && (_positionName != null)) ||
                ((positionName != null) && (_positionName == null)) ||
                ((positionName != null) && (_positionName != null) &&
                !positionName.equals(_positionName))) {
            _positionName = positionName;
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

    public Position toEscapedModel() {
        if (isEscapedModel()) {
            return (Position) this;
        } else {
            Position model = new PositionImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setPositionId(HtmlUtil.escape(getPositionId()));
            model.setPositionCode(HtmlUtil.escape(getPositionCode()));
            model.setPositionName(HtmlUtil.escape(getPositionName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (Position) Proxy.newProxyInstance(Position.class.getClassLoader(),
                    new Class[] { Position.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PositionImpl clone = new PositionImpl();

        clone.setPositionId(getPositionId());
        clone.setPositionCode(getPositionCode());
        clone.setPositionName(getPositionName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PositionImpl position = (PositionImpl) obj;

        int value = 0;

        value = getPositionName().toLowerCase()
                    .compareTo(position.getPositionName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PositionImpl position = null;

        try {
            position = (PositionImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = position.getPrimaryKey();

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
