package com.nss.portlet.necessary_info.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.necessary_info.model.ThongTinCanThiet;
import com.nss.portlet.necessary_info.model.ThongTinCanThietSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ThongTinCanThietModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ThongTinCanThiet</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.necessary_info.model.ThongTinCanThiet
 * @see com.nss.portlet.necessary_info.model.ThongTinCanThietModel
 * @see com.nss.portlet.necessary_info.model.impl.ThongTinCanThietImpl
 *
 */
public class ThongTinCanThietModelImpl extends BaseModelImpl<ThongTinCanThiet> {
    public static final String TABLE_NAME = "nss_thong_tin_can_thiet";
    public static final Object[][] TABLE_COLUMNS = {
            { "maThongTinCanThiet", new Integer(Types.BIGINT) },
            

            { "tenThongTinCanThiet", new Integer(Types.VARCHAR) },
            

            { "urlWebsite", new Integer(Types.VARCHAR) },
            

            { "moTaThongTinCanThiet", new Integer(Types.VARCHAR) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "thuTuThongTin", new Integer(Types.INTEGER) },
            

            { "target", new Integer(Types.VARCHAR) },
            

            { "imageId_liferay", new Integer(Types.BIGINT) },
            

            { "active_", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_thong_tin_can_thiet (maThongTinCanThiet LONG not null primary key,tenThongTinCanThiet VARCHAR(75) null,urlWebsite VARCHAR(75) null,moTaThongTinCanThiet VARCHAR(75) null,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,thuTuThongTin INTEGER,target VARCHAR(75) null,imageId_liferay LONG,active_ INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_thong_tin_can_thiet";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.necessary_info.model.ThongTinCanThiet"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.necessary_info.model.ThongTinCanThiet"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.necessary_info.model.ThongTinCanThiet"));
    private long _maThongTinCanThiet;
    private String _tenThongTinCanThiet;
    private String _urlWebsite;
    private String _moTaThongTinCanThiet;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuThongTin;
    private String _target;
    private long _imageId_liferay;
    private int _active;
    private transient ExpandoBridge _expandoBridge;

    public ThongTinCanThietModelImpl() {
    }

    public static ThongTinCanThiet toModel(ThongTinCanThietSoap soapModel) {
        ThongTinCanThiet model = new ThongTinCanThietImpl();

        model.setMaThongTinCanThiet(soapModel.getMaThongTinCanThiet());
        model.setTenThongTinCanThiet(soapModel.getTenThongTinCanThiet());
        model.setUrlWebsite(soapModel.getUrlWebsite());
        model.setMoTaThongTinCanThiet(soapModel.getMoTaThongTinCanThiet());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setThuTuThongTin(soapModel.getThuTuThongTin());
        model.setTarget(soapModel.getTarget());
        model.setImageId_liferay(soapModel.getImageId_liferay());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<ThongTinCanThiet> toModels(
        ThongTinCanThietSoap[] soapModels) {
        List<ThongTinCanThiet> models = new ArrayList<ThongTinCanThiet>(soapModels.length);

        for (ThongTinCanThietSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maThongTinCanThiet;
    }

    public void setPrimaryKey(long pk) {
        setMaThongTinCanThiet(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maThongTinCanThiet);
    }

    public long getMaThongTinCanThiet() {
        return _maThongTinCanThiet;
    }

    public void setMaThongTinCanThiet(long maThongTinCanThiet) {
        _maThongTinCanThiet = maThongTinCanThiet;
    }

    public String getTenThongTinCanThiet() {
        return GetterUtil.getString(_tenThongTinCanThiet);
    }

    public void setTenThongTinCanThiet(String tenThongTinCanThiet) {
        _tenThongTinCanThiet = tenThongTinCanThiet;
    }

    public String getUrlWebsite() {
        return GetterUtil.getString(_urlWebsite);
    }

    public void setUrlWebsite(String urlWebsite) {
        _urlWebsite = urlWebsite;
    }

    public String getMoTaThongTinCanThiet() {
        return GetterUtil.getString(_moTaThongTinCanThiet);
    }

    public void setMoTaThongTinCanThiet(String moTaThongTinCanThiet) {
        _moTaThongTinCanThiet = moTaThongTinCanThiet;
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

    public int getThuTuThongTin() {
        return _thuTuThongTin;
    }

    public void setThuTuThongTin(int thuTuThongTin) {
        _thuTuThongTin = thuTuThongTin;
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

    public ThongTinCanThiet toEscapedModel() {
        if (isEscapedModel()) {
            return (ThongTinCanThiet) this;
        } else {
            ThongTinCanThiet model = new ThongTinCanThietImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaThongTinCanThiet(getMaThongTinCanThiet());
            model.setTenThongTinCanThiet(HtmlUtil.escape(
                    getTenThongTinCanThiet()));
            model.setUrlWebsite(HtmlUtil.escape(getUrlWebsite()));
            model.setMoTaThongTinCanThiet(HtmlUtil.escape(
                    getMoTaThongTinCanThiet()));
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setThuTuThongTin(getThuTuThongTin());
            model.setTarget(HtmlUtil.escape(getTarget()));
            model.setImageId_liferay(getImageId_liferay());
            model.setActive(getActive());

            model = (ThongTinCanThiet) Proxy.newProxyInstance(ThongTinCanThiet.class.getClassLoader(),
                    new Class[] { ThongTinCanThiet.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(ThongTinCanThiet.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        ThongTinCanThietImpl clone = new ThongTinCanThietImpl();

        clone.setMaThongTinCanThiet(getMaThongTinCanThiet());
        clone.setTenThongTinCanThiet(getTenThongTinCanThiet());
        clone.setUrlWebsite(getUrlWebsite());
        clone.setMoTaThongTinCanThiet(getMoTaThongTinCanThiet());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setThuTuThongTin(getThuTuThongTin());
        clone.setTarget(getTarget());
        clone.setImageId_liferay(getImageId_liferay());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(ThongTinCanThiet thongTinCanThiet) {
        int value = 0;

        if (getThuTuThongTin() < thongTinCanThiet.getThuTuThongTin()) {
            value = -1;
        } else if (getThuTuThongTin() > thongTinCanThiet.getThuTuThongTin()) {
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

        ThongTinCanThiet thongTinCanThiet = null;

        try {
            thongTinCanThiet = (ThongTinCanThiet) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = thongTinCanThiet.getPrimaryKey();

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

        sb.append("{maThongTinCanThiet=");
        sb.append(getMaThongTinCanThiet());
        sb.append(", tenThongTinCanThiet=");
        sb.append(getTenThongTinCanThiet());
        sb.append(", urlWebsite=");
        sb.append(getUrlWebsite());
        sb.append(", moTaThongTinCanThiet=");
        sb.append(getMoTaThongTinCanThiet());
        sb.append(", companyid=");
        sb.append(getCompanyid());
        sb.append(", userid=");
        sb.append(getUserid());
        sb.append(", createdate=");
        sb.append(getCreatedate());
        sb.append(", modifieddate=");
        sb.append(getModifieddate());
        sb.append(", thuTuThongTin=");
        sb.append(getThuTuThongTin());
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
        sb.append("com.nss.portlet.necessary_info.model.ThongTinCanThiet");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maThongTinCanThiet</column-name><column-value><![CDATA[");
        sb.append(getMaThongTinCanThiet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenThongTinCanThiet</column-name><column-value><![CDATA[");
        sb.append(getTenThongTinCanThiet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlWebsite</column-name><column-value><![CDATA[");
        sb.append(getUrlWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moTaThongTinCanThiet</column-name><column-value><![CDATA[");
        sb.append(getMoTaThongTinCanThiet());
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
            "<column><column-name>thuTuThongTin</column-name><column-value><![CDATA[");
        sb.append(getThuTuThongTin());
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
