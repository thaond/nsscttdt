package com.nss.portlet.contact.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.contact.model.HoTroTrucTuyen;
import com.nss.portlet.contact.model.HoTroTrucTuyenSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="HoTroTrucTuyenModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>HoTroTrucTuyen</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.contact.model.HoTroTrucTuyen
 * @see com.nss.portlet.contact.model.HoTroTrucTuyenModel
 * @see com.nss.portlet.contact.model.impl.HoTroTrucTuyenImpl
 *
 */
public class HoTroTrucTuyenModelImpl extends BaseModelImpl<HoTroTrucTuyen> {
    public static final String TABLE_NAME = "nss_ho_tro_truc_tuyen";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_ho_tro_truc_tuyen", new Integer(Types.INTEGER) },
            

            { "ten", new Integer(Types.VARCHAR) },
            

            { "link", new Integer(Types.VARCHAR) },
            

            { "image_url", new Integer(Types.VARCHAR) },
            

            { "order_", new Integer(Types.INTEGER) },
            

            { "active", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_ho_tro_truc_tuyen (ma_ho_tro_truc_tuyen INTEGER not null primary key,ten VARCHAR(75) null,link VARCHAR(75) null,image_url VARCHAR(75) null,order_ INTEGER,active INTEGER,description VARCHAR(75) null,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table nss_ho_tro_truc_tuyen";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.contact.model.HoTroTrucTuyen"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.contact.model.HoTroTrucTuyen"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.contact.model.HoTroTrucTuyen"));
    private int _maHoTroTrucTuyen;
    private String _ten;
    private String _link;
    private String _imageUrl;
    private int _order;
    private int _active;
    private String _description;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;

    public HoTroTrucTuyenModelImpl() {
    }

    public static HoTroTrucTuyen toModel(HoTroTrucTuyenSoap soapModel) {
        HoTroTrucTuyen model = new HoTroTrucTuyenImpl();

        model.setMaHoTroTrucTuyen(soapModel.getMaHoTroTrucTuyen());
        model.setTen(soapModel.getTen());
        model.setLink(soapModel.getLink());
        model.setImageUrl(soapModel.getImageUrl());
        model.setOrder(soapModel.getOrder());
        model.setActive(soapModel.getActive());
        model.setDescription(soapModel.getDescription());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());

        return model;
    }

    public static List<HoTroTrucTuyen> toModels(HoTroTrucTuyenSoap[] soapModels) {
        List<HoTroTrucTuyen> models = new ArrayList<HoTroTrucTuyen>(soapModels.length);

        for (HoTroTrucTuyenSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public int getPrimaryKey() {
        return _maHoTroTrucTuyen;
    }

    public void setPrimaryKey(int pk) {
        setMaHoTroTrucTuyen(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Integer(_maHoTroTrucTuyen);
    }

    public int getMaHoTroTrucTuyen() {
        return _maHoTroTrucTuyen;
    }

    public void setMaHoTroTrucTuyen(int maHoTroTrucTuyen) {
        _maHoTroTrucTuyen = maHoTroTrucTuyen;
    }

    public String getTen() {
        return GetterUtil.getString(_ten);
    }

    public void setTen(String ten) {
        _ten = ten;
    }

    public String getLink() {
        return GetterUtil.getString(_link);
    }

    public void setLink(String link) {
        _link = link;
    }

    public String getImageUrl() {
        return GetterUtil.getString(_imageUrl);
    }

    public void setImageUrl(String imageUrl) {
        _imageUrl = imageUrl;
    }

    public int getOrder() {
        return _order;
    }

    public void setOrder(int order) {
        _order = order;
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

    public HoTroTrucTuyen toEscapedModel() {
        if (isEscapedModel()) {
            return (HoTroTrucTuyen) this;
        } else {
            HoTroTrucTuyen model = new HoTroTrucTuyenImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaHoTroTrucTuyen(getMaHoTroTrucTuyen());
            model.setTen(HtmlUtil.escape(getTen()));
            model.setLink(HtmlUtil.escape(getLink()));
            model.setImageUrl(HtmlUtil.escape(getImageUrl()));
            model.setOrder(getOrder());
            model.setActive(getActive());
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());

            model = (HoTroTrucTuyen) Proxy.newProxyInstance(HoTroTrucTuyen.class.getClassLoader(),
                    new Class[] { HoTroTrucTuyen.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        HoTroTrucTuyenImpl clone = new HoTroTrucTuyenImpl();

        clone.setMaHoTroTrucTuyen(getMaHoTroTrucTuyen());
        clone.setTen(getTen());
        clone.setLink(getLink());
        clone.setImageUrl(getImageUrl());
        clone.setOrder(getOrder());
        clone.setActive(getActive());
        clone.setDescription(getDescription());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());

        return clone;
    }

    public int compareTo(HoTroTrucTuyen hoTroTrucTuyen) {
        int value = 0;

        if (getOrder() < hoTroTrucTuyen.getOrder()) {
            value = -1;
        } else if (getOrder() > hoTroTrucTuyen.getOrder()) {
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

        HoTroTrucTuyen hoTroTrucTuyen = null;

        try {
            hoTroTrucTuyen = (HoTroTrucTuyen) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        int pk = hoTroTrucTuyen.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{maHoTroTrucTuyen=");
        sb.append(getMaHoTroTrucTuyen());
        sb.append(", ten=");
        sb.append(getTen());
        sb.append(", link=");
        sb.append(getLink());
        sb.append(", imageUrl=");
        sb.append(getImageUrl());
        sb.append(", order=");
        sb.append(getOrder());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", companyid=");
        sb.append(getCompanyid());
        sb.append(", userid=");
        sb.append(getUserid());
        sb.append(", createdate=");
        sb.append(getCreatedate());
        sb.append(", modifieddate=");
        sb.append(getModifieddate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.contact.model.HoTroTrucTuyen");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maHoTroTrucTuyen</column-name><column-value><![CDATA[");
        sb.append(getMaHoTroTrucTuyen());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ten</column-name><column-value><![CDATA[");
        sb.append(getTen());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>link</column-name><column-value><![CDATA[");
        sb.append(getLink());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageUrl</column-name><column-value><![CDATA[");
        sb.append(getImageUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>order</column-name><column-value><![CDATA[");
        sb.append(getOrder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
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

        sb.append("</model>");

        return sb.toString();
    }
}
