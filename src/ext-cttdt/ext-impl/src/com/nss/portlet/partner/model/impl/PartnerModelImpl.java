package com.nss.portlet.partner.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.partner.model.Partner;
import com.nss.portlet.partner.model.PartnerSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PartnerModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Partner</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.partner.model.Partner
 * @see com.nss.portlet.partner.model.PartnerModel
 * @see com.nss.portlet.partner.model.impl.PartnerImpl
 *
 */
public class PartnerModelImpl extends BaseModelImpl<Partner> {
    public static final String TABLE_NAME = "nss_partner";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_partner", new Integer(Types.BIGINT) },
            

            { "ten_partner", new Integer(Types.VARCHAR) },
            

            { "url_partner", new Integer(Types.VARCHAR) },
            

            { "mo_ta_partner", new Integer(Types.VARCHAR) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "thu_tu_partner", new Integer(Types.INTEGER) },
            

            { "target", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.INTEGER) },
            

            { "imageid_liferay", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_partner (ma_partner LONG not null primary key,ten_partner VARCHAR(75) null,url_partner VARCHAR(75) null,mo_ta_partner VARCHAR(75) null,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,thu_tu_partner INTEGER,target VARCHAR(75) null,active INTEGER,imageid_liferay LONG)";
    public static final String TABLE_SQL_DROP = "drop table nss_partner";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.partner.model.Partner"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.partner.model.Partner"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.partner.model.Partner"));
    private long _maPartner;
    private String _tenPartner;
    private String _urlPartner;
    private String _moTaPartner;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuPartner;
    private String _target;
    private int _active;
    private long _imageId_liferay;
    private transient ExpandoBridge _expandoBridge;

    public PartnerModelImpl() {
    }

    public static Partner toModel(PartnerSoap soapModel) {
        Partner model = new PartnerImpl();

        model.setMaPartner(soapModel.getMaPartner());
        model.setTenPartner(soapModel.getTenPartner());
        model.setUrlPartner(soapModel.getUrlPartner());
        model.setMoTaPartner(soapModel.getMoTaPartner());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setThuTuPartner(soapModel.getThuTuPartner());
        model.setTarget(soapModel.getTarget());
        model.setActive(soapModel.getActive());
        model.setImageId_liferay(soapModel.getImageId_liferay());

        return model;
    }

    public static List<Partner> toModels(PartnerSoap[] soapModels) {
        List<Partner> models = new ArrayList<Partner>(soapModels.length);

        for (PartnerSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maPartner;
    }

    public void setPrimaryKey(long pk) {
        setMaPartner(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maPartner);
    }

    public long getMaPartner() {
        return _maPartner;
    }

    public void setMaPartner(long maPartner) {
        _maPartner = maPartner;
    }

    public String getTenPartner() {
        return GetterUtil.getString(_tenPartner);
    }

    public void setTenPartner(String tenPartner) {
        _tenPartner = tenPartner;
    }

    public String getUrlPartner() {
        return GetterUtil.getString(_urlPartner);
    }

    public void setUrlPartner(String urlPartner) {
        _urlPartner = urlPartner;
    }

    public String getMoTaPartner() {
        return GetterUtil.getString(_moTaPartner);
    }

    public void setMoTaPartner(String moTaPartner) {
        _moTaPartner = moTaPartner;
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

    public int getThuTuPartner() {
        return _thuTuPartner;
    }

    public void setThuTuPartner(int thuTuPartner) {
        _thuTuPartner = thuTuPartner;
    }

    public String getTarget() {
        return GetterUtil.getString(_target);
    }

    public void setTarget(String target) {
        _target = target;
    }

    public int getActive() {
        return _active;
    }

    public void setActive(int active) {
        _active = active;
    }

    public long getImageId_liferay() {
        return _imageId_liferay;
    }

    public void setImageId_liferay(long imageId_liferay) {
        _imageId_liferay = imageId_liferay;
    }

    public Partner toEscapedModel() {
        if (isEscapedModel()) {
            return (Partner) this;
        } else {
            Partner model = new PartnerImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaPartner(getMaPartner());
            model.setTenPartner(HtmlUtil.escape(getTenPartner()));
            model.setUrlPartner(HtmlUtil.escape(getUrlPartner()));
            model.setMoTaPartner(HtmlUtil.escape(getMoTaPartner()));
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setThuTuPartner(getThuTuPartner());
            model.setTarget(HtmlUtil.escape(getTarget()));
            model.setActive(getActive());
            model.setImageId_liferay(getImageId_liferay());

            model = (Partner) Proxy.newProxyInstance(Partner.class.getClassLoader(),
                    new Class[] { Partner.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(Partner.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PartnerImpl clone = new PartnerImpl();

        clone.setMaPartner(getMaPartner());
        clone.setTenPartner(getTenPartner());
        clone.setUrlPartner(getUrlPartner());
        clone.setMoTaPartner(getMoTaPartner());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setThuTuPartner(getThuTuPartner());
        clone.setTarget(getTarget());
        clone.setActive(getActive());
        clone.setImageId_liferay(getImageId_liferay());

        return clone;
    }

    public int compareTo(Partner partner) {
        int value = 0;

        if (getThuTuPartner() < partner.getThuTuPartner()) {
            value = -1;
        } else if (getThuTuPartner() > partner.getThuTuPartner()) {
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

        Partner partner = null;

        try {
            partner = (Partner) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = partner.getPrimaryKey();

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

        sb.append("{maPartner=");
        sb.append(getMaPartner());
        sb.append(", tenPartner=");
        sb.append(getTenPartner());
        sb.append(", urlPartner=");
        sb.append(getUrlPartner());
        sb.append(", moTaPartner=");
        sb.append(getMoTaPartner());
        sb.append(", companyid=");
        sb.append(getCompanyid());
        sb.append(", userid=");
        sb.append(getUserid());
        sb.append(", createdate=");
        sb.append(getCreatedate());
        sb.append(", modifieddate=");
        sb.append(getModifieddate());
        sb.append(", thuTuPartner=");
        sb.append(getThuTuPartner());
        sb.append(", target=");
        sb.append(getTarget());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", imageId_liferay=");
        sb.append(getImageId_liferay());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.partner.model.Partner");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maPartner</column-name><column-value><![CDATA[");
        sb.append(getMaPartner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenPartner</column-name><column-value><![CDATA[");
        sb.append(getTenPartner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlPartner</column-name><column-value><![CDATA[");
        sb.append(getUrlPartner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moTaPartner</column-name><column-value><![CDATA[");
        sb.append(getMoTaPartner());
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
            "<column><column-name>thuTuPartner</column-name><column-value><![CDATA[");
        sb.append(getThuTuPartner());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>target</column-name><column-value><![CDATA[");
        sb.append(getTarget());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageId_liferay</column-name><column-value><![CDATA[");
        sb.append(getImageId_liferay());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
