package com.nss.portlet.linh_vuc_van_ban.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBanSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LinhVucVanBanModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>LinhVucVanBan</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan
 * @see com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBanModel
 * @see com.nss.portlet.linh_vuc_van_ban.model.impl.LinhVucVanBanImpl
 *
 */
public class LinhVucVanBanModelImpl extends BaseModelImpl<LinhVucVanBan> {
    public static final String TABLE_NAME = "nss_linh_vuc_van_ban";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_linh_vuc_van_ban", new Integer(Types.BIGINT) },
            

            { "ten_linh_vuc_van_ban", new Integer(Types.VARCHAR) },
            

            { "parentid", new Integer(Types.BIGINT) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "active", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_linh_vuc_van_ban (ma_linh_vuc_van_ban LONG not null primary key,ten_linh_vuc_van_ban VARCHAR(75) null,parentid LONG,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,active INTEGER,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_linh_vuc_van_ban";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan"));
    private long _maLinhVucVanBan;
    private String _tenLinhVucVanBan;
    private long _parentid;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;
    private transient ExpandoBridge _expandoBridge;

    public LinhVucVanBanModelImpl() {
    }

    public static LinhVucVanBan toModel(LinhVucVanBanSoap soapModel) {
        LinhVucVanBan model = new LinhVucVanBanImpl();

        model.setMaLinhVucVanBan(soapModel.getMaLinhVucVanBan());
        model.setTenLinhVucVanBan(soapModel.getTenLinhVucVanBan());
        model.setParentid(soapModel.getParentid());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setActive(soapModel.getActive());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<LinhVucVanBan> toModels(LinhVucVanBanSoap[] soapModels) {
        List<LinhVucVanBan> models = new ArrayList<LinhVucVanBan>(soapModels.length);

        for (LinhVucVanBanSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maLinhVucVanBan;
    }

    public void setPrimaryKey(long pk) {
        setMaLinhVucVanBan(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maLinhVucVanBan);
    }

    public long getMaLinhVucVanBan() {
        return _maLinhVucVanBan;
    }

    public void setMaLinhVucVanBan(long maLinhVucVanBan) {
        _maLinhVucVanBan = maLinhVucVanBan;
    }

    public String getTenLinhVucVanBan() {
        return GetterUtil.getString(_tenLinhVucVanBan);
    }

    public void setTenLinhVucVanBan(String tenLinhVucVanBan) {
        _tenLinhVucVanBan = tenLinhVucVanBan;
    }

    public long getParentid() {
        return _parentid;
    }

    public void setParentid(long parentid) {
        _parentid = parentid;
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

    public LinhVucVanBan toEscapedModel() {
        if (isEscapedModel()) {
            return (LinhVucVanBan) this;
        } else {
            LinhVucVanBan model = new LinhVucVanBanImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaLinhVucVanBan(getMaLinhVucVanBan());
            model.setTenLinhVucVanBan(HtmlUtil.escape(getTenLinhVucVanBan()));
            model.setParentid(getParentid());
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setActive(getActive());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (LinhVucVanBan) Proxy.newProxyInstance(LinhVucVanBan.class.getClassLoader(),
                    new Class[] { LinhVucVanBan.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(LinhVucVanBan.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        LinhVucVanBanImpl clone = new LinhVucVanBanImpl();

        clone.setMaLinhVucVanBan(getMaLinhVucVanBan());
        clone.setTenLinhVucVanBan(getTenLinhVucVanBan());
        clone.setParentid(getParentid());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setActive(getActive());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(LinhVucVanBan linhVucVanBan) {
        int value = 0;

        value = getTenLinhVucVanBan().toLowerCase()
                    .compareTo(linhVucVanBan.getTenLinhVucVanBan().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LinhVucVanBan linhVucVanBan = null;

        try {
            linhVucVanBan = (LinhVucVanBan) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = linhVucVanBan.getPrimaryKey();

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

        sb.append("{maLinhVucVanBan=");
        sb.append(getMaLinhVucVanBan());
        sb.append(", tenLinhVucVanBan=");
        sb.append(getTenLinhVucVanBan());
        sb.append(", parentid=");
        sb.append(getParentid());
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
        sb.append("com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maLinhVucVanBan</column-name><column-value><![CDATA[");
        sb.append(getMaLinhVucVanBan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenLinhVucVanBan</column-name><column-value><![CDATA[");
        sb.append(getTenLinhVucVanBan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentid</column-name><column-value><![CDATA[");
        sb.append(getParentid());
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
