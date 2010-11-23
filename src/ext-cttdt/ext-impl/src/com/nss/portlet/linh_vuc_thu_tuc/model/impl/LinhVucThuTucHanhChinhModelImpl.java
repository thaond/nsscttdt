package com.nss.portlet.linh_vuc_thu_tuc.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;
import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinhSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="LinhVucThuTucHanhChinhModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>LinhVucThuTucHanhChinh</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh
 * @see com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinhModel
 * @see com.nss.portlet.linh_vuc_thu_tuc.model.impl.LinhVucThuTucHanhChinhImpl
 *
 */
public class LinhVucThuTucHanhChinhModelImpl extends BaseModelImpl<LinhVucThuTucHanhChinh> {
    public static final String TABLE_NAME = "nss_linh_vuc_thu_tuc";
    public static final Object[][] TABLE_COLUMNS = {
            { "maLinhVucThuTucHanhChinh", new Integer(Types.BIGINT) },
            

            { "tenLinhVucThuTucHanhChinh", new Integer(Types.VARCHAR) },
            

            { "maLoaiThuTucHanhChinh", new Integer(Types.BIGINT) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "active", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_linh_vuc_thu_tuc (maLinhVucThuTucHanhChinh LONG not null primary key,tenLinhVucThuTucHanhChinh VARCHAR(75) null,maLoaiThuTucHanhChinh LONG,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,active INTEGER,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_linh_vuc_thu_tuc";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh"));
    private long _maLinhVucThuTucHanhChinh;
    private String _tenLinhVucThuTucHanhChinh;
    private long _maLoaiThuTucHanhChinh;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;
    private transient ExpandoBridge _expandoBridge;

    public LinhVucThuTucHanhChinhModelImpl() {
    }

    public static LinhVucThuTucHanhChinh toModel(
        LinhVucThuTucHanhChinhSoap soapModel) {
        LinhVucThuTucHanhChinh model = new LinhVucThuTucHanhChinhImpl();

        model.setMaLinhVucThuTucHanhChinh(soapModel.getMaLinhVucThuTucHanhChinh());
        model.setTenLinhVucThuTucHanhChinh(soapModel.getTenLinhVucThuTucHanhChinh());
        model.setMaLoaiThuTucHanhChinh(soapModel.getMaLoaiThuTucHanhChinh());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setActive(soapModel.getActive());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<LinhVucThuTucHanhChinh> toModels(
        LinhVucThuTucHanhChinhSoap[] soapModels) {
        List<LinhVucThuTucHanhChinh> models = new ArrayList<LinhVucThuTucHanhChinh>(soapModels.length);

        for (LinhVucThuTucHanhChinhSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maLinhVucThuTucHanhChinh;
    }

    public void setPrimaryKey(long pk) {
        setMaLinhVucThuTucHanhChinh(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maLinhVucThuTucHanhChinh);
    }

    public long getMaLinhVucThuTucHanhChinh() {
        return _maLinhVucThuTucHanhChinh;
    }

    public void setMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh) {
        _maLinhVucThuTucHanhChinh = maLinhVucThuTucHanhChinh;
    }

    public String getTenLinhVucThuTucHanhChinh() {
        return GetterUtil.getString(_tenLinhVucThuTucHanhChinh);
    }

    public void setTenLinhVucThuTucHanhChinh(String tenLinhVucThuTucHanhChinh) {
        _tenLinhVucThuTucHanhChinh = tenLinhVucThuTucHanhChinh;
    }

    public long getMaLoaiThuTucHanhChinh() {
        return _maLoaiThuTucHanhChinh;
    }

    public void setMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh) {
        _maLoaiThuTucHanhChinh = maLoaiThuTucHanhChinh;
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

    public LinhVucThuTucHanhChinh toEscapedModel() {
        if (isEscapedModel()) {
            return (LinhVucThuTucHanhChinh) this;
        } else {
            LinhVucThuTucHanhChinh model = new LinhVucThuTucHanhChinhImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaLinhVucThuTucHanhChinh(getMaLinhVucThuTucHanhChinh());
            model.setTenLinhVucThuTucHanhChinh(HtmlUtil.escape(
                    getTenLinhVucThuTucHanhChinh()));
            model.setMaLoaiThuTucHanhChinh(getMaLoaiThuTucHanhChinh());
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setActive(getActive());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (LinhVucThuTucHanhChinh) Proxy.newProxyInstance(LinhVucThuTucHanhChinh.class.getClassLoader(),
                    new Class[] { LinhVucThuTucHanhChinh.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(LinhVucThuTucHanhChinh.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        LinhVucThuTucHanhChinhImpl clone = new LinhVucThuTucHanhChinhImpl();

        clone.setMaLinhVucThuTucHanhChinh(getMaLinhVucThuTucHanhChinh());
        clone.setTenLinhVucThuTucHanhChinh(getTenLinhVucThuTucHanhChinh());
        clone.setMaLoaiThuTucHanhChinh(getMaLoaiThuTucHanhChinh());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setActive(getActive());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(LinhVucThuTucHanhChinh linhVucThuTucHanhChinh) {
        int value = 0;

        value = getTenLinhVucThuTucHanhChinh().toLowerCase()
                    .compareTo(linhVucThuTucHanhChinh.getTenLinhVucThuTucHanhChinh()
                                                     .toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = null;

        try {
            linhVucThuTucHanhChinh = (LinhVucThuTucHanhChinh) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = linhVucThuTucHanhChinh.getPrimaryKey();

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

        sb.append("{maLinhVucThuTucHanhChinh=");
        sb.append(getMaLinhVucThuTucHanhChinh());
        sb.append(", tenLinhVucThuTucHanhChinh=");
        sb.append(getTenLinhVucThuTucHanhChinh());
        sb.append(", maLoaiThuTucHanhChinh=");
        sb.append(getMaLoaiThuTucHanhChinh());
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
        sb.append(
            "com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maLinhVucThuTucHanhChinh</column-name><column-value><![CDATA[");
        sb.append(getMaLinhVucThuTucHanhChinh());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenLinhVucThuTucHanhChinh</column-name><column-value><![CDATA[");
        sb.append(getTenLinhVucThuTucHanhChinh());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maLoaiThuTucHanhChinh</column-name><column-value><![CDATA[");
        sb.append(getMaLoaiThuTucHanhChinh());
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
