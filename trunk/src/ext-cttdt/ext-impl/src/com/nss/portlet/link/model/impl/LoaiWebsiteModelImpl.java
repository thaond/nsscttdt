package com.nss.portlet.link.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.model.LoaiWebsiteSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LoaiWebsiteModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>LoaiWebsite</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.model.LoaiWebsite
 * @see com.nss.portlet.link.model.LoaiWebsiteModel
 * @see com.nss.portlet.link.model.impl.LoaiWebsiteImpl
 *
 */
public class LoaiWebsiteModelImpl extends BaseModelImpl<LoaiWebsite> {
    public static final String TABLE_NAME = "nss_loai_website";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_loai_website", new Integer(Types.BIGINT) },
            

            { "ten_loai_website", new Integer(Types.VARCHAR) },
            

            { "mo_ta_loai_website", new Integer(Types.VARCHAR) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "active", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_loai_website (ma_loai_website LONG not null primary key,ten_loai_website VARCHAR(75) null,mo_ta_loai_website VARCHAR(75) null,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,active INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_loai_website";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.link.model.LoaiWebsite"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.link.model.LoaiWebsite"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.link.model.LoaiWebsite"));
    private long _maLoaiWebsite;
    private String _tenLoaiWebsite;
    private String _moTaLoaiWebsite;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private transient ExpandoBridge _expandoBridge;

    public LoaiWebsiteModelImpl() {
    }

    public static LoaiWebsite toModel(LoaiWebsiteSoap soapModel) {
        LoaiWebsite model = new LoaiWebsiteImpl();

        model.setMaLoaiWebsite(soapModel.getMaLoaiWebsite());
        model.setTenLoaiWebsite(soapModel.getTenLoaiWebsite());
        model.setMoTaLoaiWebsite(soapModel.getMoTaLoaiWebsite());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<LoaiWebsite> toModels(LoaiWebsiteSoap[] soapModels) {
        List<LoaiWebsite> models = new ArrayList<LoaiWebsite>(soapModels.length);

        for (LoaiWebsiteSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maLoaiWebsite;
    }

    public void setPrimaryKey(long pk) {
        setMaLoaiWebsite(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maLoaiWebsite);
    }

    public long getMaLoaiWebsite() {
        return _maLoaiWebsite;
    }

    public void setMaLoaiWebsite(long maLoaiWebsite) {
        _maLoaiWebsite = maLoaiWebsite;
    }

    public String getTenLoaiWebsite() {
        return GetterUtil.getString(_tenLoaiWebsite);
    }

    public void setTenLoaiWebsite(String tenLoaiWebsite) {
        _tenLoaiWebsite = tenLoaiWebsite;
    }

    public String getMoTaLoaiWebsite() {
        return GetterUtil.getString(_moTaLoaiWebsite);
    }

    public void setMoTaLoaiWebsite(String moTaLoaiWebsite) {
        _moTaLoaiWebsite = moTaLoaiWebsite;
    }

    public long getCompanyid() {
        return _companyid;
    }

    public void setCompanyid(long companyid) {
        _companyid = companyid;
    }

    public long getUserid() {
        return _userid;
    }

    public void setUserid(long userid) {
        _userid = userid;
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

    public int getActive() {
        return _active;
    }

    public void setActive(int active) {
        _active = active;
    }

    public LoaiWebsite toEscapedModel() {
        if (isEscapedModel()) {
            return (LoaiWebsite) this;
        } else {
            LoaiWebsite model = new LoaiWebsiteImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaLoaiWebsite(getMaLoaiWebsite());
            model.setTenLoaiWebsite(HtmlUtil.escape(getTenLoaiWebsite()));
            model.setMoTaLoaiWebsite(HtmlUtil.escape(getMoTaLoaiWebsite()));
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setActive(getActive());

            model = (LoaiWebsite) Proxy.newProxyInstance(LoaiWebsite.class.getClassLoader(),
                    new Class[] { LoaiWebsite.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(LoaiWebsite.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        LoaiWebsiteImpl clone = new LoaiWebsiteImpl();

        clone.setMaLoaiWebsite(getMaLoaiWebsite());
        clone.setTenLoaiWebsite(getTenLoaiWebsite());
        clone.setMoTaLoaiWebsite(getMoTaLoaiWebsite());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(LoaiWebsite loaiWebsite) {
        int value = 0;

        value = getTenLoaiWebsite().toLowerCase()
                    .compareTo(loaiWebsite.getTenLoaiWebsite().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LoaiWebsite loaiWebsite = null;

        try {
            loaiWebsite = (LoaiWebsite) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = loaiWebsite.getPrimaryKey();

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

        sb.append("{maLoaiWebsite=");
        sb.append(getMaLoaiWebsite());
        sb.append(", tenLoaiWebsite=");
        sb.append(getTenLoaiWebsite());
        sb.append(", moTaLoaiWebsite=");
        sb.append(getMoTaLoaiWebsite());
        sb.append(", companyid=");
        sb.append(getCompanyid());
        sb.append(", userid=");
        sb.append(getUserid());
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
        sb.append("com.nss.portlet.link.model.LoaiWebsite");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maLoaiWebsite</column-name><column-value><![CDATA[");
        sb.append(getMaLoaiWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenLoaiWebsite</column-name><column-value><![CDATA[");
        sb.append(getTenLoaiWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moTaLoaiWebsite</column-name><column-value><![CDATA[");
        sb.append(getMoTaLoaiWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyid</column-name><column-value><![CDATA[");
        sb.append(getCompanyid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userid</column-name><column-value><![CDATA[");
        sb.append(getUserid());
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
