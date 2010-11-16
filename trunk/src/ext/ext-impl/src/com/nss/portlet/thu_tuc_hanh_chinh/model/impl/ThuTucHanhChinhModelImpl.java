package com.nss.portlet.thu_tuc_hanh_chinh.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;
import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinhSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ThuTucHanhChinhModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ThuTucHanhChinh</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinhModel
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.impl.ThuTucHanhChinhImpl
 *
 */
public class ThuTucHanhChinhModelImpl extends BaseModelImpl<ThuTucHanhChinh> {
    public static final String TABLE_NAME = "nss_thu_tuc_hanh_chinh";
    public static final Object[][] TABLE_COLUMNS = {
            { "maThuTucHanhChinh", new Integer(Types.BIGINT) },
            

            { "tenThuTucHanhChinh", new Integer(Types.VARCHAR) },
            

            { "diaChiLienHe", new Integer(Types.VARCHAR) },
            

            { "maLinhVucThuTucHanhChinh", new Integer(Types.BIGINT) },
            

            { "maDonViThuTucHanhChinh", new Integer(Types.BIGINT) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "active", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_thu_tuc_hanh_chinh (maThuTucHanhChinh LONG not null primary key,tenThuTucHanhChinh VARCHAR(75) null,diaChiLienHe VARCHAR(75) null,maLinhVucThuTucHanhChinh LONG,maDonViThuTucHanhChinh LONG,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,active INTEGER,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_thu_tuc_hanh_chinh";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh"));
    private long _maThuTucHanhChinh;
    private String _tenThuTucHanhChinh;
    private String _diaChiLienHe;
    private long _maLinhVucThuTucHanhChinh;
    private long _maDonViThuTucHanhChinh;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;
    private transient ExpandoBridge _expandoBridge;

    public ThuTucHanhChinhModelImpl() {
    }

    public static ThuTucHanhChinh toModel(ThuTucHanhChinhSoap soapModel) {
        ThuTucHanhChinh model = new ThuTucHanhChinhImpl();

        model.setMaThuTucHanhChinh(soapModel.getMaThuTucHanhChinh());
        model.setTenThuTucHanhChinh(soapModel.getTenThuTucHanhChinh());
        model.setDiaChiLienHe(soapModel.getDiaChiLienHe());
        model.setMaLinhVucThuTucHanhChinh(soapModel.getMaLinhVucThuTucHanhChinh());
        model.setMaDonViThuTucHanhChinh(soapModel.getMaDonViThuTucHanhChinh());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setActive(soapModel.getActive());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<ThuTucHanhChinh> toModels(
        ThuTucHanhChinhSoap[] soapModels) {
        List<ThuTucHanhChinh> models = new ArrayList<ThuTucHanhChinh>(soapModels.length);

        for (ThuTucHanhChinhSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maThuTucHanhChinh;
    }

    public void setPrimaryKey(long pk) {
        setMaThuTucHanhChinh(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maThuTucHanhChinh);
    }

    public long getMaThuTucHanhChinh() {
        return _maThuTucHanhChinh;
    }

    public void setMaThuTucHanhChinh(long maThuTucHanhChinh) {
        _maThuTucHanhChinh = maThuTucHanhChinh;
    }

    public String getTenThuTucHanhChinh() {
        return GetterUtil.getString(_tenThuTucHanhChinh);
    }

    public void setTenThuTucHanhChinh(String tenThuTucHanhChinh) {
        _tenThuTucHanhChinh = tenThuTucHanhChinh;
    }

    public String getDiaChiLienHe() {
        return GetterUtil.getString(_diaChiLienHe);
    }

    public void setDiaChiLienHe(String diaChiLienHe) {
        _diaChiLienHe = diaChiLienHe;
    }

    public long getMaLinhVucThuTucHanhChinh() {
        return _maLinhVucThuTucHanhChinh;
    }

    public void setMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh) {
        _maLinhVucThuTucHanhChinh = maLinhVucThuTucHanhChinh;
    }

    public long getMaDonViThuTucHanhChinh() {
        return _maDonViThuTucHanhChinh;
    }

    public void setMaDonViThuTucHanhChinh(long maDonViThuTucHanhChinh) {
        _maDonViThuTucHanhChinh = maDonViThuTucHanhChinh;
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

    public ThuTucHanhChinh toEscapedModel() {
        if (isEscapedModel()) {
            return (ThuTucHanhChinh) this;
        } else {
            ThuTucHanhChinh model = new ThuTucHanhChinhImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaThuTucHanhChinh(getMaThuTucHanhChinh());
            model.setTenThuTucHanhChinh(HtmlUtil.escape(getTenThuTucHanhChinh()));
            model.setDiaChiLienHe(HtmlUtil.escape(getDiaChiLienHe()));
            model.setMaLinhVucThuTucHanhChinh(getMaLinhVucThuTucHanhChinh());
            model.setMaDonViThuTucHanhChinh(getMaDonViThuTucHanhChinh());
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setActive(getActive());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (ThuTucHanhChinh) Proxy.newProxyInstance(ThuTucHanhChinh.class.getClassLoader(),
                    new Class[] { ThuTucHanhChinh.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(ThuTucHanhChinh.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        ThuTucHanhChinhImpl clone = new ThuTucHanhChinhImpl();

        clone.setMaThuTucHanhChinh(getMaThuTucHanhChinh());
        clone.setTenThuTucHanhChinh(getTenThuTucHanhChinh());
        clone.setDiaChiLienHe(getDiaChiLienHe());
        clone.setMaLinhVucThuTucHanhChinh(getMaLinhVucThuTucHanhChinh());
        clone.setMaDonViThuTucHanhChinh(getMaDonViThuTucHanhChinh());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setActive(getActive());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(ThuTucHanhChinh thuTucHanhChinh) {
        int value = 0;

        value = getTenThuTucHanhChinh().toLowerCase()
                    .compareTo(thuTucHanhChinh.getTenThuTucHanhChinh()
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

        ThuTucHanhChinh thuTucHanhChinh = null;

        try {
            thuTucHanhChinh = (ThuTucHanhChinh) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = thuTucHanhChinh.getPrimaryKey();

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

        sb.append("{maThuTucHanhChinh=");
        sb.append(getMaThuTucHanhChinh());
        sb.append(", tenThuTucHanhChinh=");
        sb.append(getTenThuTucHanhChinh());
        sb.append(", diaChiLienHe=");
        sb.append(getDiaChiLienHe());
        sb.append(", maLinhVucThuTucHanhChinh=");
        sb.append(getMaLinhVucThuTucHanhChinh());
        sb.append(", maDonViThuTucHanhChinh=");
        sb.append(getMaDonViThuTucHanhChinh());
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
        sb.append("com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maThuTucHanhChinh</column-name><column-value><![CDATA[");
        sb.append(getMaThuTucHanhChinh());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenThuTucHanhChinh</column-name><column-value><![CDATA[");
        sb.append(getTenThuTucHanhChinh());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>diaChiLienHe</column-name><column-value><![CDATA[");
        sb.append(getDiaChiLienHe());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maLinhVucThuTucHanhChinh</column-name><column-value><![CDATA[");
        sb.append(getMaLinhVucThuTucHanhChinh());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maDonViThuTucHanhChinh</column-name><column-value><![CDATA[");
        sb.append(getMaDonViThuTucHanhChinh());
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
