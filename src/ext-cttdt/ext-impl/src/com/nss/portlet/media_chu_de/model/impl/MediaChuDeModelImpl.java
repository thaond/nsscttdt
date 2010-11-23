package com.nss.portlet.media_chu_de.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.model.MediaChuDeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="MediaChuDeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>MediaChuDe</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_chu_de.model.MediaChuDe
 * @see com.nss.portlet.media_chu_de.model.MediaChuDeModel
 * @see com.nss.portlet.media_chu_de.model.impl.MediaChuDeImpl
 *
 */
public class MediaChuDeModelImpl extends BaseModelImpl<MediaChuDe> {
    public static final String TABLE_NAME = "nss_media_chu_de";
    public static final Object[][] TABLE_COLUMNS = {
            { "maMediaChuDe", new Integer(Types.BIGINT) },
            

            { "tenMediaChuDe", new Integer(Types.VARCHAR) },
            

            { "active_", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_media_chu_de (maMediaChuDe LONG not null primary key,tenMediaChuDe VARCHAR(75) null,active_ BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table nss_media_chu_de";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.media_chu_de.model.MediaChuDe"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.media_chu_de.model.MediaChuDe"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.media_chu_de.model.MediaChuDe"));
    private long _maMediaChuDe;
    private String _tenMediaChuDe;
    private boolean _active;
    private transient ExpandoBridge _expandoBridge;

    public MediaChuDeModelImpl() {
    }

    public static MediaChuDe toModel(MediaChuDeSoap soapModel) {
        MediaChuDe model = new MediaChuDeImpl();

        model.setMaMediaChuDe(soapModel.getMaMediaChuDe());
        model.setTenMediaChuDe(soapModel.getTenMediaChuDe());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<MediaChuDe> toModels(MediaChuDeSoap[] soapModels) {
        List<MediaChuDe> models = new ArrayList<MediaChuDe>(soapModels.length);

        for (MediaChuDeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maMediaChuDe;
    }

    public void setPrimaryKey(long pk) {
        setMaMediaChuDe(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maMediaChuDe);
    }

    public long getMaMediaChuDe() {
        return _maMediaChuDe;
    }

    public void setMaMediaChuDe(long maMediaChuDe) {
        _maMediaChuDe = maMediaChuDe;
    }

    public String getTenMediaChuDe() {
        return GetterUtil.getString(_tenMediaChuDe);
    }

    public void setTenMediaChuDe(String tenMediaChuDe) {
        _tenMediaChuDe = tenMediaChuDe;
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        _active = active;
    }

    public MediaChuDe toEscapedModel() {
        if (isEscapedModel()) {
            return (MediaChuDe) this;
        } else {
            MediaChuDe model = new MediaChuDeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaMediaChuDe(getMaMediaChuDe());
            model.setTenMediaChuDe(HtmlUtil.escape(getTenMediaChuDe()));
            model.setActive(getActive());

            model = (MediaChuDe) Proxy.newProxyInstance(MediaChuDe.class.getClassLoader(),
                    new Class[] { MediaChuDe.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(MediaChuDe.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        MediaChuDeImpl clone = new MediaChuDeImpl();

        clone.setMaMediaChuDe(getMaMediaChuDe());
        clone.setTenMediaChuDe(getTenMediaChuDe());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(MediaChuDe mediaChuDe) {
        int value = 0;

        value = getTenMediaChuDe().compareTo(mediaChuDe.getTenMediaChuDe());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MediaChuDe mediaChuDe = null;

        try {
            mediaChuDe = (MediaChuDe) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = mediaChuDe.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{maMediaChuDe=");
        sb.append(getMaMediaChuDe());
        sb.append(", tenMediaChuDe=");
        sb.append(getTenMediaChuDe());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.media_chu_de.model.MediaChuDe");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maMediaChuDe</column-name><column-value><![CDATA[");
        sb.append(getMaMediaChuDe());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenMediaChuDe</column-name><column-value><![CDATA[");
        sb.append(getTenMediaChuDe());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
