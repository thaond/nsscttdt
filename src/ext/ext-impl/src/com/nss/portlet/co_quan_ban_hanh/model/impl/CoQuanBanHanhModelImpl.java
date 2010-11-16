package com.nss.portlet.co_quan_ban_hanh.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanhSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="CoQuanBanHanhModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>CoQuanBanHanh</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh
 * @see com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanhModel
 * @see com.nss.portlet.co_quan_ban_hanh.model.impl.CoQuanBanHanhImpl
 *
 */
public class CoQuanBanHanhModelImpl extends BaseModelImpl<CoQuanBanHanh> {
    public static final String TABLE_NAME = "nss_co_quan_ban_hanh";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_co_quan_ban_hanh", new Integer(Types.BIGINT) },
            

            { "ten_co_quan_ban_hanh", new Integer(Types.VARCHAR) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "active", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_co_quan_ban_hanh (ma_co_quan_ban_hanh LONG not null primary key,ten_co_quan_ban_hanh VARCHAR(75) null,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,active INTEGER,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_co_quan_ban_hanh";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh"));
    private long _maCoQuanBanHanh;
    private String _tenCoQuanBanHanh;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;
    private transient ExpandoBridge _expandoBridge;

    public CoQuanBanHanhModelImpl() {
    }

    public static CoQuanBanHanh toModel(CoQuanBanHanhSoap soapModel) {
        CoQuanBanHanh model = new CoQuanBanHanhImpl();

        model.setMaCoQuanBanHanh(soapModel.getMaCoQuanBanHanh());
        model.setTenCoQuanBanHanh(soapModel.getTenCoQuanBanHanh());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setActive(soapModel.getActive());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<CoQuanBanHanh> toModels(CoQuanBanHanhSoap[] soapModels) {
        List<CoQuanBanHanh> models = new ArrayList<CoQuanBanHanh>(soapModels.length);

        for (CoQuanBanHanhSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maCoQuanBanHanh;
    }

    public void setPrimaryKey(long pk) {
        setMaCoQuanBanHanh(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maCoQuanBanHanh);
    }

    public long getMaCoQuanBanHanh() {
        return _maCoQuanBanHanh;
    }

    public void setMaCoQuanBanHanh(long maCoQuanBanHanh) {
        _maCoQuanBanHanh = maCoQuanBanHanh;
    }

    public String getTenCoQuanBanHanh() {
        return GetterUtil.getString(_tenCoQuanBanHanh);
    }

    public void setTenCoQuanBanHanh(String tenCoQuanBanHanh) {
        _tenCoQuanBanHanh = tenCoQuanBanHanh;
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

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        _description = description;
    }

    public CoQuanBanHanh toEscapedModel() {
        if (isEscapedModel()) {
            return (CoQuanBanHanh) this;
        } else {
            CoQuanBanHanh model = new CoQuanBanHanhImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaCoQuanBanHanh(getMaCoQuanBanHanh());
            model.setTenCoQuanBanHanh(HtmlUtil.escape(getTenCoQuanBanHanh()));
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setActive(getActive());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (CoQuanBanHanh) Proxy.newProxyInstance(CoQuanBanHanh.class.getClassLoader(),
                    new Class[] { CoQuanBanHanh.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(CoQuanBanHanh.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        CoQuanBanHanhImpl clone = new CoQuanBanHanhImpl();

        clone.setMaCoQuanBanHanh(getMaCoQuanBanHanh());
        clone.setTenCoQuanBanHanh(getTenCoQuanBanHanh());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setActive(getActive());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(CoQuanBanHanh coQuanBanHanh) {
        int value = 0;

        value = getTenCoQuanBanHanh().toLowerCase()
                    .compareTo(coQuanBanHanh.getTenCoQuanBanHanh().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        CoQuanBanHanh coQuanBanHanh = null;

        try {
            coQuanBanHanh = (CoQuanBanHanh) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = coQuanBanHanh.getPrimaryKey();

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

        sb.append("{maCoQuanBanHanh=");
        sb.append(getMaCoQuanBanHanh());
        sb.append(", tenCoQuanBanHanh=");
        sb.append(getTenCoQuanBanHanh());
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
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maCoQuanBanHanh</column-name><column-value><![CDATA[");
        sb.append(getMaCoQuanBanHanh());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenCoQuanBanHanh</column-name><column-value><![CDATA[");
        sb.append(getTenCoQuanBanHanh());
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
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
