package com.nss.portlet.position.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.position.model.Position;
import com.nss.portlet.position.model.PositionSoap;

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
 * @see com.nss.portlet.position.model.Position
 * @see com.nss.portlet.position.model.PositionModel
 * @see com.nss.portlet.position.model.impl.PositionImpl
 *
 */
public class PositionModelImpl extends BaseModelImpl<Position> {
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
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.position.model.Position"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.position.model.Position"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.position.model.Position"));
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
        _positionId = positionId;
    }

    public String getPositionCode() {
        return GetterUtil.getString(_positionCode);
    }

    public void setPositionCode(String positionCode) {
        _positionCode = positionCode;
    }

    public String getPositionName() {
        return GetterUtil.getString(_positionName);
    }

    public void setPositionName(String positionName) {
        _positionName = positionName;
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

    public int compareTo(Position position) {
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

        Position position = null;

        try {
            position = (Position) obj;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{positionId=");
        sb.append(getPositionId());
        sb.append(", positionCode=");
        sb.append(getPositionCode());
        sb.append(", positionName=");
        sb.append(getPositionName());
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
        sb.append("com.nss.portlet.position.model.Position");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>positionId</column-name><column-value><![CDATA[");
        sb.append(getPositionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>positionCode</column-name><column-value><![CDATA[");
        sb.append(getPositionCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>positionName</column-name><column-value><![CDATA[");
        sb.append(getPositionName());
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
