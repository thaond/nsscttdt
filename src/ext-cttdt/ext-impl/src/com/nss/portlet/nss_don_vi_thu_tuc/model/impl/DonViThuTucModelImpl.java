package com.nss.portlet.nss_don_vi_thu_tuc.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTucSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="DonViThuTucModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>DonViThuTuc</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc
 * @see com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTucModel
 * @see com.nss.portlet.nss_don_vi_thu_tuc.model.impl.DonViThuTucImpl
 *
 */
public class DonViThuTucModelImpl extends BaseModelImpl<DonViThuTuc> {
    public static final String TABLE_NAME = "nss_don_vi_thu_tuc";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_don_vi_thu_tuc", new Integer(Types.BIGINT) },
            

            { "ten_don_vi_thu_tuc", new Integer(Types.VARCHAR) },
            

            { "capDonVi", new Integer(Types.INTEGER) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "active", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_don_vi_thu_tuc (ma_don_vi_thu_tuc LONG not null primary key,ten_don_vi_thu_tuc VARCHAR(75) null,capDonVi INTEGER,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,active INTEGER,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_don_vi_thu_tuc";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc"));
    private long _maDonViThuTuc;
    private String _tenDonViThuTuc;
    private int _capDonVi;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;
    private transient ExpandoBridge _expandoBridge;

    public DonViThuTucModelImpl() {
    }

    public static DonViThuTuc toModel(DonViThuTucSoap soapModel) {
        DonViThuTuc model = new DonViThuTucImpl();

        model.setMaDonViThuTuc(soapModel.getMaDonViThuTuc());
        model.setTenDonViThuTuc(soapModel.getTenDonViThuTuc());
        model.setCapDonVi(soapModel.getCapDonVi());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setActive(soapModel.getActive());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<DonViThuTuc> toModels(DonViThuTucSoap[] soapModels) {
        List<DonViThuTuc> models = new ArrayList<DonViThuTuc>(soapModels.length);

        for (DonViThuTucSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maDonViThuTuc;
    }

    public void setPrimaryKey(long pk) {
        setMaDonViThuTuc(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maDonViThuTuc);
    }

    public long getMaDonViThuTuc() {
        return _maDonViThuTuc;
    }

    public void setMaDonViThuTuc(long maDonViThuTuc) {
        _maDonViThuTuc = maDonViThuTuc;
    }

    public String getTenDonViThuTuc() {
        return GetterUtil.getString(_tenDonViThuTuc);
    }

    public void setTenDonViThuTuc(String tenDonViThuTuc) {
        _tenDonViThuTuc = tenDonViThuTuc;
    }

    public int getCapDonVi() {
        return _capDonVi;
    }

    public void setCapDonVi(int capDonVi) {
        _capDonVi = capDonVi;
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

    public DonViThuTuc toEscapedModel() {
        if (isEscapedModel()) {
            return (DonViThuTuc) this;
        } else {
            DonViThuTuc model = new DonViThuTucImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaDonViThuTuc(getMaDonViThuTuc());
            model.setTenDonViThuTuc(HtmlUtil.escape(getTenDonViThuTuc()));
            model.setCapDonVi(getCapDonVi());
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setActive(getActive());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (DonViThuTuc) Proxy.newProxyInstance(DonViThuTuc.class.getClassLoader(),
                    new Class[] { DonViThuTuc.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(DonViThuTuc.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        DonViThuTucImpl clone = new DonViThuTucImpl();

        clone.setMaDonViThuTuc(getMaDonViThuTuc());
        clone.setTenDonViThuTuc(getTenDonViThuTuc());
        clone.setCapDonVi(getCapDonVi());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setActive(getActive());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(DonViThuTuc donViThuTuc) {
        int value = 0;

        value = getTenDonViThuTuc().toLowerCase()
                    .compareTo(donViThuTuc.getTenDonViThuTuc().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        DonViThuTuc donViThuTuc = null;

        try {
            donViThuTuc = (DonViThuTuc) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = donViThuTuc.getPrimaryKey();

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

        sb.append("{maDonViThuTuc=");
        sb.append(getMaDonViThuTuc());
        sb.append(", tenDonViThuTuc=");
        sb.append(getTenDonViThuTuc());
        sb.append(", capDonVi=");
        sb.append(getCapDonVi());
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
        sb.append("com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maDonViThuTuc</column-name><column-value><![CDATA[");
        sb.append(getMaDonViThuTuc());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenDonViThuTuc</column-name><column-value><![CDATA[");
        sb.append(getTenDonViThuTuc());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>capDonVi</column-name><column-value><![CDATA[");
        sb.append(getCapDonVi());
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
