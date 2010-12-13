package com.nss.portlet.thong_tin_lien_quan.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan;
import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuanSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ThongTinLienQuanModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ThongTinLienQuan</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan
 * @see com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuanModel
 * @see com.nss.portlet.thong_tin_lien_quan.model.impl.ThongTinLienQuanImpl
 *
 */
public class ThongTinLienQuanModelImpl extends BaseModelImpl<ThongTinLienQuan> {
    public static final String TABLE_NAME = "nss_thong_tin_lien_quan";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_thong_tin_lien_quan", new Integer(Types.BIGINT) },
            

            { "ten_thong_tin_lien_quan", new Integer(Types.VARCHAR) },
            

            { "url_website", new Integer(Types.VARCHAR) },
            

            { "mo_ta_thong_tin_lien_quan", new Integer(Types.VARCHAR) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "thu_tu_thong_tin", new Integer(Types.INTEGER) },
            

            { "target", new Integer(Types.VARCHAR) },
            

            { "imageid_liferay", new Integer(Types.BIGINT) },
            

            { "active", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_thong_tin_lien_quan (ma_thong_tin_lien_quan LONG not null primary key,ten_thong_tin_lien_quan VARCHAR(75) null,url_website VARCHAR(75) null,mo_ta_thong_tin_lien_quan VARCHAR(75) null,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,thu_tu_thong_tin INTEGER,target VARCHAR(75) null,imageid_liferay LONG,active INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_thong_tin_lien_quan";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan"));
    private long _maThongTinLienQuan;
    private String _tenThongTinLienQuan;
    private String _urlWebsite;
    private String _moTaThongTinLienQuan;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuThongTin;
    private String _target;
    private long _imageId_liferay;
    private int _active;
    private transient ExpandoBridge _expandoBridge;

    public ThongTinLienQuanModelImpl() {
    }

    public static ThongTinLienQuan toModel(ThongTinLienQuanSoap soapModel) {
        ThongTinLienQuan model = new ThongTinLienQuanImpl();

        model.setMaThongTinLienQuan(soapModel.getMaThongTinLienQuan());
        model.setTenThongTinLienQuan(soapModel.getTenThongTinLienQuan());
        model.setUrlWebsite(soapModel.getUrlWebsite());
        model.setMoTaThongTinLienQuan(soapModel.getMoTaThongTinLienQuan());
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

    public static List<ThongTinLienQuan> toModels(
        ThongTinLienQuanSoap[] soapModels) {
        List<ThongTinLienQuan> models = new ArrayList<ThongTinLienQuan>(soapModels.length);

        for (ThongTinLienQuanSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maThongTinLienQuan;
    }

    public void setPrimaryKey(long pk) {
        setMaThongTinLienQuan(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maThongTinLienQuan);
    }

    public long getMaThongTinLienQuan() {
        return _maThongTinLienQuan;
    }

    public void setMaThongTinLienQuan(long maThongTinLienQuan) {
        _maThongTinLienQuan = maThongTinLienQuan;
    }

    public String getTenThongTinLienQuan() {
        return GetterUtil.getString(_tenThongTinLienQuan);
    }

    public void setTenThongTinLienQuan(String tenThongTinLienQuan) {
        _tenThongTinLienQuan = tenThongTinLienQuan;
    }

    public String getUrlWebsite() {
        return GetterUtil.getString(_urlWebsite);
    }

    public void setUrlWebsite(String urlWebsite) {
        _urlWebsite = urlWebsite;
    }

    public String getMoTaThongTinLienQuan() {
        return GetterUtil.getString(_moTaThongTinLienQuan);
    }

    public void setMoTaThongTinLienQuan(String moTaThongTinLienQuan) {
        _moTaThongTinLienQuan = moTaThongTinLienQuan;
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

    public ThongTinLienQuan toEscapedModel() {
        if (isEscapedModel()) {
            return (ThongTinLienQuan) this;
        } else {
            ThongTinLienQuan model = new ThongTinLienQuanImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaThongTinLienQuan(getMaThongTinLienQuan());
            model.setTenThongTinLienQuan(HtmlUtil.escape(
                    getTenThongTinLienQuan()));
            model.setUrlWebsite(HtmlUtil.escape(getUrlWebsite()));
            model.setMoTaThongTinLienQuan(HtmlUtil.escape(
                    getMoTaThongTinLienQuan()));
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setThuTuThongTin(getThuTuThongTin());
            model.setTarget(HtmlUtil.escape(getTarget()));
            model.setImageId_liferay(getImageId_liferay());
            model.setActive(getActive());

            model = (ThongTinLienQuan) Proxy.newProxyInstance(ThongTinLienQuan.class.getClassLoader(),
                    new Class[] { ThongTinLienQuan.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(ThongTinLienQuan.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        ThongTinLienQuanImpl clone = new ThongTinLienQuanImpl();

        clone.setMaThongTinLienQuan(getMaThongTinLienQuan());
        clone.setTenThongTinLienQuan(getTenThongTinLienQuan());
        clone.setUrlWebsite(getUrlWebsite());
        clone.setMoTaThongTinLienQuan(getMoTaThongTinLienQuan());
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

    public int compareTo(ThongTinLienQuan thongTinLienQuan) {
        int value = 0;

        if (getThuTuThongTin() < thongTinLienQuan.getThuTuThongTin()) {
            value = -1;
        } else if (getThuTuThongTin() > thongTinLienQuan.getThuTuThongTin()) {
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

        ThongTinLienQuan thongTinLienQuan = null;

        try {
            thongTinLienQuan = (ThongTinLienQuan) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = thongTinLienQuan.getPrimaryKey();

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

        sb.append("{maThongTinLienQuan=");
        sb.append(getMaThongTinLienQuan());
        sb.append(", tenThongTinLienQuan=");
        sb.append(getTenThongTinLienQuan());
        sb.append(", urlWebsite=");
        sb.append(getUrlWebsite());
        sb.append(", moTaThongTinLienQuan=");
        sb.append(getMoTaThongTinLienQuan());
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
        sb.append("com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maThongTinLienQuan</column-name><column-value><![CDATA[");
        sb.append(getMaThongTinLienQuan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenThongTinLienQuan</column-name><column-value><![CDATA[");
        sb.append(getTenThongTinLienQuan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlWebsite</column-name><column-value><![CDATA[");
        sb.append(getUrlWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moTaThongTinLienQuan</column-name><column-value><![CDATA[");
        sb.append(getMoTaThongTinLienQuan());
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
