package com.nss.portlet.adv.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.adv.model.QuangCao;
import com.nss.portlet.adv.model.QuangCaoSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="QuangCaoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>QuangCao</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.adv.model.QuangCao
 * @see com.nss.portlet.adv.model.QuangCaoModel
 * @see com.nss.portlet.adv.model.impl.QuangCaoImpl
 *
 */
public class QuangCaoModelImpl extends BaseModelImpl<QuangCao> {
    public static final String TABLE_NAME = "nss_quang_cao";
    public static final Object[][] TABLE_COLUMNS = {
            { "maQuangCao", new Integer(Types.BIGINT) },
            

            { "tenQuangCao", new Integer(Types.VARCHAR) },
            

            { "urlWebsite", new Integer(Types.VARCHAR) },
            

            { "moTaQuangCao", new Integer(Types.VARCHAR) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "thuTuQuangCao", new Integer(Types.INTEGER) },
            

            { "target", new Integer(Types.VARCHAR) },
            

            { "imageId_liferay", new Integer(Types.BIGINT) },
            

            { "active_", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_quang_cao (maQuangCao LONG not null primary key,tenQuangCao VARCHAR(75) null,urlWebsite VARCHAR(75) null,moTaQuangCao VARCHAR(75) null,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,thuTuQuangCao INTEGER,target VARCHAR(75) null,imageId_liferay LONG,active_ INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_quang_cao";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.adv.model.QuangCao"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.adv.model.QuangCao"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.adv.model.QuangCao"));
    private long _maQuangCao;
    private String _tenQuangCao;
    private String _urlWebsite;
    private String _moTaQuangCao;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _thuTuQuangCao;
    private String _target;
    private long _imageId_liferay;
    private int _active;
    private transient ExpandoBridge _expandoBridge;

    public QuangCaoModelImpl() {
    }

    public static QuangCao toModel(QuangCaoSoap soapModel) {
        QuangCao model = new QuangCaoImpl();

        model.setMaQuangCao(soapModel.getMaQuangCao());
        model.setTenQuangCao(soapModel.getTenQuangCao());
        model.setUrlWebsite(soapModel.getUrlWebsite());
        model.setMoTaQuangCao(soapModel.getMoTaQuangCao());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setThuTuQuangCao(soapModel.getThuTuQuangCao());
        model.setTarget(soapModel.getTarget());
        model.setImageId_liferay(soapModel.getImageId_liferay());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<QuangCao> toModels(QuangCaoSoap[] soapModels) {
        List<QuangCao> models = new ArrayList<QuangCao>(soapModels.length);

        for (QuangCaoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maQuangCao;
    }

    public void setPrimaryKey(long pk) {
        setMaQuangCao(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maQuangCao);
    }

    public long getMaQuangCao() {
        return _maQuangCao;
    }

    public void setMaQuangCao(long maQuangCao) {
        _maQuangCao = maQuangCao;
    }

    public String getTenQuangCao() {
        return GetterUtil.getString(_tenQuangCao);
    }

    public void setTenQuangCao(String tenQuangCao) {
        _tenQuangCao = tenQuangCao;
    }

    public String getUrlWebsite() {
        return GetterUtil.getString(_urlWebsite);
    }

    public void setUrlWebsite(String urlWebsite) {
        _urlWebsite = urlWebsite;
    }

    public String getMoTaQuangCao() {
        return GetterUtil.getString(_moTaQuangCao);
    }

    public void setMoTaQuangCao(String moTaQuangCao) {
        _moTaQuangCao = moTaQuangCao;
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

    public int getThuTuQuangCao() {
        return _thuTuQuangCao;
    }

    public void setThuTuQuangCao(int thuTuQuangCao) {
        _thuTuQuangCao = thuTuQuangCao;
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

    public QuangCao toEscapedModel() {
        if (isEscapedModel()) {
            return (QuangCao) this;
        } else {
            QuangCao model = new QuangCaoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaQuangCao(getMaQuangCao());
            model.setTenQuangCao(HtmlUtil.escape(getTenQuangCao()));
            model.setUrlWebsite(HtmlUtil.escape(getUrlWebsite()));
            model.setMoTaQuangCao(HtmlUtil.escape(getMoTaQuangCao()));
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setThuTuQuangCao(getThuTuQuangCao());
            model.setTarget(HtmlUtil.escape(getTarget()));
            model.setImageId_liferay(getImageId_liferay());
            model.setActive(getActive());

            model = (QuangCao) Proxy.newProxyInstance(QuangCao.class.getClassLoader(),
                    new Class[] { QuangCao.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(QuangCao.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        QuangCaoImpl clone = new QuangCaoImpl();

        clone.setMaQuangCao(getMaQuangCao());
        clone.setTenQuangCao(getTenQuangCao());
        clone.setUrlWebsite(getUrlWebsite());
        clone.setMoTaQuangCao(getMoTaQuangCao());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setThuTuQuangCao(getThuTuQuangCao());
        clone.setTarget(getTarget());
        clone.setImageId_liferay(getImageId_liferay());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(QuangCao quangCao) {
        int value = 0;

        if (getThuTuQuangCao() < quangCao.getThuTuQuangCao()) {
            value = -1;
        } else if (getThuTuQuangCao() > quangCao.getThuTuQuangCao()) {
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

        QuangCao quangCao = null;

        try {
            quangCao = (QuangCao) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = quangCao.getPrimaryKey();

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

        sb.append("{maQuangCao=");
        sb.append(getMaQuangCao());
        sb.append(", tenQuangCao=");
        sb.append(getTenQuangCao());
        sb.append(", urlWebsite=");
        sb.append(getUrlWebsite());
        sb.append(", moTaQuangCao=");
        sb.append(getMoTaQuangCao());
        sb.append(", companyid=");
        sb.append(getCompanyid());
        sb.append(", userid=");
        sb.append(getUserid());
        sb.append(", createdate=");
        sb.append(getCreatedate());
        sb.append(", modifieddate=");
        sb.append(getModifieddate());
        sb.append(", thuTuQuangCao=");
        sb.append(getThuTuQuangCao());
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
        sb.append("com.nss.portlet.adv.model.QuangCao");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maQuangCao</column-name><column-value><![CDATA[");
        sb.append(getMaQuangCao());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenQuangCao</column-name><column-value><![CDATA[");
        sb.append(getTenQuangCao());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>urlWebsite</column-name><column-value><![CDATA[");
        sb.append(getUrlWebsite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moTaQuangCao</column-name><column-value><![CDATA[");
        sb.append(getMoTaQuangCao());
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
            "<column><column-name>thuTuQuangCao</column-name><column-value><![CDATA[");
        sb.append(getThuTuQuangCao());
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
