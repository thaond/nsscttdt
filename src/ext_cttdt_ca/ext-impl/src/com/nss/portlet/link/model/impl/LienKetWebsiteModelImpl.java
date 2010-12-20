package com.nss.portlet.link.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.link.model.LienKetWebsite;
import com.nss.portlet.link.model.LienKetWebsiteSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LienKetWebsiteModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>LienKetWebsite</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.link.model.LienKetWebsite
 * @see com.nss.portlet.link.model.LienKetWebsiteModel
 * @see com.nss.portlet.link.model.impl.LienKetWebsiteImpl
 *
 */
public class LienKetWebsiteModelImpl extends BaseModelImpl<LienKetWebsite> {
    public static final String TABLE_NAME = "nss_lien_ket_website";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_website", new Integer(Types.BIGINT) },
            

            { "ten_website", new Integer(Types.VARCHAR) },
            

            { "url_website", new Integer(Types.VARCHAR) },
            

            { "mo_ta_website", new Integer(Types.VARCHAR) },
            

            { "loai_website", new Integer(Types.BIGINT) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "thu_tu_website", new Integer(Types.INTEGER) },
            

            { "target", new Integer(Types.VARCHAR) },
            

            { "imageid_liferay", new Integer(Types.BIGINT) },
            

            { "active", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_lien_ket_website (ma_website LONG not null primary key,ten_website VARCHAR(75) null,url_website VARCHAR(75) null,mo_ta_website VARCHAR(75) null,loai_website LONG,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,thu_tu_website INTEGER,target VARCHAR(75) null,imageid_liferay LONG,active INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_lien_ket_website";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.link.model.LienKetWebsite"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.link.model.LienKetWebsite"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.link.model.LienKetWebsite"));
    private long _maWebsite;
    private String _tenWebsite;
    private String _urlWebsite;
    private String _moTaWebsite;
    private long _loaiWebsite;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuWebsite;
    private String _target;
    private long _imageId_liferay;
    private int _active;
    private transient ExpandoBridge _expandoBridge;

    public LienKetWebsiteModelImpl() {
    }

    public static LienKetWebsite toModel(LienKetWebsiteSoap soapModel) {
        LienKetWebsite model = new LienKetWebsiteImpl();

        model.setMaWebsite(soapModel.getMaWebsite());
        model.setTenWebsite(soapModel.getTenWebsite());
        model.setUrlWebsite(soapModel.getUrlWebsite());
        model.setMoTaWebsite(soapModel.getMoTaWebsite());
        model.setLoaiWebsite(soapModel.getLoaiWebsite());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setThuTuWebsite(soapModel.getThuTuWebsite());
        model.setTarget(soapModel.getTarget());
        model.setImageId_liferay(soapModel.getImageId_liferay());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<LienKetWebsite> toModels(LienKetWebsiteSoap[] soapModels) {
        List<LienKetWebsite> models = new ArrayList<LienKetWebsite>(soapModels.length);

        for (LienKetWebsiteSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maWebsite;
    }

    public void setPrimaryKey(long pk) {
        setMaWebsite(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maWebsite);
    }

    public long getMaWebsite() {
        return _maWebsite;
    }

    public void setMaWebsite(long maWebsite) {
        _maWebsite = maWebsite;
    }

    public String getTenWebsite() {
        return GetterUtil.getString(_tenWebsite);
    }

    public void setTenWebsite(String tenWebsite) {
        _tenWebsite = tenWebsite;
    }

    public String getUrlWebsite() {
        return GetterUtil.getString(_urlWebsite);
    }

    public void setUrlWebsite(String urlWebsite) {
        _urlWebsite = urlWebsite;
    }

    public String getMoTaWebsite() {
        return GetterUtil.getString(_moTaWebsite);
    }

    public void setMoTaWebsite(String moTaWebsite) {
        _moTaWebsite = moTaWebsite;
    }

    public long getLoaiWebsite() {
        return _loaiWebsite;
    }

    public void setLoaiWebsite(long loaiWebsite) {
        _loaiWebsite = loaiWebsite;
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

    public int getThuTuWebsite() {
        return _thuTuWebsite;
    }

    public void setThuTuWebsite(int thuTuWebsite) {
        _thuTuWebsite = thuTuWebsite;
    }

    public String getTarget() {
        return GetterUtil.getString(_target);
    }

    public void setTarget(String target) {
        _target = target;
    }

    public long getImageId_liferay() {
        return _imageId_liferay;
    }

    public void setImageId_liferay(long imageId_liferay) {
        _imageId_liferay = imageId_liferay;
    }

    public int getActive() {
        return _active;
    }

    public void setActive(int active) {
        _active = active;
    }

    public LienKetWebsite toEscapedModel() {
        if (isEscapedModel()) {
            return (LienKetWebsite) this;
        } else {
            LienKetWebsite model = new LienKetWebsiteImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaWebsite(getMaWebsite());
            model.setTenWebsite(HtmlUtil.escape(getTenWebsite()));
            model.setUrlWebsite(HtmlUtil.escape(getUrlWebsite()));
            model.setMoTaWebsite(HtmlUtil.escape(getMoTaWebsite()));
            model.setLoaiWebsite(getLoaiWebsite());
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setThuTuWebsite(getThuTuWebsite());
            model.setTarget(HtmlUtil.escape(getTarget()));
            model.setImageId_liferay(getImageId_liferay());
            model.setActive(getActive());

            model = (LienKetWebsite) Proxy.newProxyInstance(LienKetWebsite.class.getClassLoader(),
                    new Class[] { LienKetWebsite.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(LienKetWebsite.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        LienKetWebsiteImpl clone = new LienKetWebsiteImpl();

        clone.setMaWebsite(getMaWebsite());
        clone.setTenWebsite(getTenWebsite());
        clone.setUrlWebsite(getUrlWebsite());
        clone.setMoTaWebsite(getMoTaWebsite());
        clone.setLoaiWebsite(getLoaiWebsite());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setThuTuWebsite(getThuTuWebsite());
        clone.setTarget(getTarget());
        clone.setImageId_liferay(getImageId_liferay());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(LienKetWebsite lienKetWebsite) {
        int value = 0;

        if (getThuTuWebsite() < lienKetWebsite.getThuTuWebsite()) {
            value = -1;
        } else if (getThuTuWebsite() > lienKetWebsite.getThuTuWebsite()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LienKetWebsite lienKetWebsite = null;

        try {
            lienKetWebsite = (LienKetWebsite) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = lienKetWebsite.getPrimaryKey();

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

        sb.append("{maWebsite=");
        sb.append(getMaWebsite());
        sb.append(", tenWebsite=");
        sb.append(getTenWebsite());
        sb.append(", urlWebsite=");
        sb.append(getUrlWebsite());
        sb.append(", moTaWebsite=");
        sb.append(getMoTaWebsite());
        sb.append(", loaiWebsite=");
        sb.append(getLoaiWebsite());
        sb.append(", companyid=");
        sb.append(getCompanyid());
        sb.append(", userid=");
        sb.append(getUserid());
        sb.append(", createdate=");
        sb.append(getCreatedate());
        sb.append(", modifieddate=");
        sb.append(getModifieddate());
        sb.append(", thuTuWebsite=");
        sb.append(getThuTuWebsite());
        sb.append(", target=");
        sb.append(getTarget());
        sb.append(", imageId_liferay=");
        sb.append(getImageId_liferay());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.link.model.LienKetWebsite");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maWebsite</column-name><column-value><![CDATA[");
        sb.append(getMaWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenWebsite</column-name><column-value><![CDATA[");
        sb.append(getTenWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlWebsite</column-name><column-value><![CDATA[");
        sb.append(getUrlWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moTaWebsite</column-name><column-value><![CDATA[");
        sb.append(getMoTaWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>loaiWebsite</column-name><column-value><![CDATA[");
        sb.append(getLoaiWebsite());
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
            "<column><column-name>thuTuWebsite</column-name><column-value><![CDATA[");
        sb.append(getThuTuWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>target</column-name><column-value><![CDATA[");
        sb.append(getTarget());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageId_liferay</column-name><column-value><![CDATA[");
        sb.append(getImageId_liferay());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
