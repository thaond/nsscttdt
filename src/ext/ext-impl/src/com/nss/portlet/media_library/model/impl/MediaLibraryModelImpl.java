package com.nss.portlet.media_library.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.model.MediaLibrarySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MediaLibraryModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>MediaLibrary</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.media_library.model.MediaLibrary
 * @see com.nss.portlet.media_library.model.MediaLibraryModel
 * @see com.nss.portlet.media_library.model.impl.MediaLibraryImpl
 *
 */
public class MediaLibraryModelImpl extends BaseModelImpl<MediaLibrary> {
    public static final String TABLE_NAME = "nss_media_library";
    public static final Object[][] TABLE_COLUMNS = {
            { "maMediaLibrary", new Integer(Types.BIGINT) },
            

            { "maMediaChuDe", new Integer(Types.BIGINT) },
            

            { "tieuDeMediaLibrary", new Integer(Types.VARCHAR) },
            

            { "tenMediaLibrary", new Integer(Types.VARCHAR) },
            

            { "kichThuoc", new Integer(Types.BIGINT) },
            

            { "duongDan", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "luotXem", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "active_", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_media_library (maMediaLibrary LONG not null primary key,maMediaChuDe LONG,tieuDeMediaLibrary VARCHAR(75) null,tenMediaLibrary VARCHAR(75) null,kichThuoc LONG,duongDan VARCHAR(75) null,userId LONG,luotXem LONG,createdate DATE null,modifieddate DATE null,active_ BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table nss_media_library";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.media_library.model.MediaLibrary"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.media_library.model.MediaLibrary"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.media_library.model.MediaLibrary"));
    private long _maMediaLibrary;
    private long _maMediaChuDe;
    private String _tieuDeMediaLibrary;
    private String _tenMediaLibrary;
    private long _kichThuoc;
    private String _duongDan;
    private long _userId;
    private long _luotXem;
    private Date _createdate;
    private Date _modifieddate;
    private boolean _active;
    private transient ExpandoBridge _expandoBridge;

    public MediaLibraryModelImpl() {
    }

    public static MediaLibrary toModel(MediaLibrarySoap soapModel) {
        MediaLibrary model = new MediaLibraryImpl();

        model.setMaMediaLibrary(soapModel.getMaMediaLibrary());
        model.setMaMediaChuDe(soapModel.getMaMediaChuDe());
        model.setTieuDeMediaLibrary(soapModel.getTieuDeMediaLibrary());
        model.setTenMediaLibrary(soapModel.getTenMediaLibrary());
        model.setKichThuoc(soapModel.getKichThuoc());
        model.setDuongDan(soapModel.getDuongDan());
        model.setUserId(soapModel.getUserId());
        model.setLuotXem(soapModel.getLuotXem());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<MediaLibrary> toModels(MediaLibrarySoap[] soapModels) {
        List<MediaLibrary> models = new ArrayList<MediaLibrary>(soapModels.length);

        for (MediaLibrarySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maMediaLibrary;
    }

    public void setPrimaryKey(long pk) {
        setMaMediaLibrary(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maMediaLibrary);
    }

    public long getMaMediaLibrary() {
        return _maMediaLibrary;
    }

    public void setMaMediaLibrary(long maMediaLibrary) {
        _maMediaLibrary = maMediaLibrary;
    }

    public long getMaMediaChuDe() {
        return _maMediaChuDe;
    }

    public void setMaMediaChuDe(long maMediaChuDe) {
        _maMediaChuDe = maMediaChuDe;
    }

    public String getTieuDeMediaLibrary() {
        return GetterUtil.getString(_tieuDeMediaLibrary);
    }

    public void setTieuDeMediaLibrary(String tieuDeMediaLibrary) {
        _tieuDeMediaLibrary = tieuDeMediaLibrary;
    }

    public String getTenMediaLibrary() {
        return GetterUtil.getString(_tenMediaLibrary);
    }

    public void setTenMediaLibrary(String tenMediaLibrary) {
        _tenMediaLibrary = tenMediaLibrary;
    }

    public long getKichThuoc() {
        return _kichThuoc;
    }

    public void setKichThuoc(long kichThuoc) {
        _kichThuoc = kichThuoc;
    }

    public String getDuongDan() {
        return GetterUtil.getString(_duongDan);
    }

    public void setDuongDan(String duongDan) {
        _duongDan = duongDan;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getLuotXem() {
        return _luotXem;
    }

    public void setLuotXem(long luotXem) {
        _luotXem = luotXem;
    }

    public Date getCreatedate() {
        return _createdate;
    }

    public void setCreatedate(Date createdate) {
        _createdate = createdate;
    }

    public Date getModifieddate() {
        return _modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        _modifieddate = modifieddate;
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

    public MediaLibrary toEscapedModel() {
        if (isEscapedModel()) {
            return (MediaLibrary) this;
        } else {
            MediaLibrary model = new MediaLibraryImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaMediaLibrary(getMaMediaLibrary());
            model.setMaMediaChuDe(getMaMediaChuDe());
            model.setTieuDeMediaLibrary(HtmlUtil.escape(getTieuDeMediaLibrary()));
            model.setTenMediaLibrary(HtmlUtil.escape(getTenMediaLibrary()));
            model.setKichThuoc(getKichThuoc());
            model.setDuongDan(HtmlUtil.escape(getDuongDan()));
            model.setUserId(getUserId());
            model.setLuotXem(getLuotXem());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setActive(getActive());

            model = (MediaLibrary) Proxy.newProxyInstance(MediaLibrary.class.getClassLoader(),
                    new Class[] { MediaLibrary.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(MediaLibrary.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        MediaLibraryImpl clone = new MediaLibraryImpl();

        clone.setMaMediaLibrary(getMaMediaLibrary());
        clone.setMaMediaChuDe(getMaMediaChuDe());
        clone.setTieuDeMediaLibrary(getTieuDeMediaLibrary());
        clone.setTenMediaLibrary(getTenMediaLibrary());
        clone.setKichThuoc(getKichThuoc());
        clone.setDuongDan(getDuongDan());
        clone.setUserId(getUserId());
        clone.setLuotXem(getLuotXem());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(MediaLibrary mediaLibrary) {
        int value = 0;

        if (getMaMediaChuDe() < mediaLibrary.getMaMediaChuDe()) {
            value = -1;
        } else if (getMaMediaChuDe() > mediaLibrary.getMaMediaChuDe()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        value = getTieuDeMediaLibrary()
                    .compareTo(mediaLibrary.getTieuDeMediaLibrary());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MediaLibrary mediaLibrary = null;

        try {
            mediaLibrary = (MediaLibrary) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = mediaLibrary.getPrimaryKey();

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

        sb.append("{maMediaLibrary=");
        sb.append(getMaMediaLibrary());
        sb.append(", maMediaChuDe=");
        sb.append(getMaMediaChuDe());
        sb.append(", tieuDeMediaLibrary=");
        sb.append(getTieuDeMediaLibrary());
        sb.append(", tenMediaLibrary=");
        sb.append(getTenMediaLibrary());
        sb.append(", kichThuoc=");
        sb.append(getKichThuoc());
        sb.append(", duongDan=");
        sb.append(getDuongDan());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", luotXem=");
        sb.append(getLuotXem());
        sb.append(", createdate=");
        sb.append(getCreatedate());
        sb.append(", modifieddate=");
        sb.append(getModifieddate());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.media_library.model.MediaLibrary");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maMediaLibrary</column-name><column-value><![CDATA[");
        sb.append(getMaMediaLibrary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maMediaChuDe</column-name><column-value><![CDATA[");
        sb.append(getMaMediaChuDe());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tieuDeMediaLibrary</column-name><column-value><![CDATA[");
        sb.append(getTieuDeMediaLibrary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenMediaLibrary</column-name><column-value><![CDATA[");
        sb.append(getTenMediaLibrary());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kichThuoc</column-name><column-value><![CDATA[");
        sb.append(getKichThuoc());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>duongDan</column-name><column-value><![CDATA[");
        sb.append(getDuongDan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>luotXem</column-name><column-value><![CDATA[");
        sb.append(getLuotXem());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdate</column-name><column-value><![CDATA[");
        sb.append(getCreatedate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifieddate</column-name><column-value><![CDATA[");
        sb.append(getModifieddate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
