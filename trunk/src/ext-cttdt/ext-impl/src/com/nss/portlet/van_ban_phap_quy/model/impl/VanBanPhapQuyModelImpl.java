package com.nss.portlet.van_ban_phap_quy.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="VanBanPhapQuyModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>VanBanPhapQuy</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy
 * @see com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuyModel
 * @see com.nss.portlet.van_ban_phap_quy.model.impl.VanBanPhapQuyImpl
 *
 */
public class VanBanPhapQuyModelImpl extends BaseModelImpl<VanBanPhapQuy> {
    public static final String TABLE_NAME = "nss_van_ban_phap_quy";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_van_ban_phap_quy", new Integer(Types.BIGINT) },
            

            { "ky_hieu_van_ban", new Integer(Types.VARCHAR) },
            

            { "ma_loai_van_ban", new Integer(Types.BIGINT) },
            

            { "ma_linh_vuc_van_ban", new Integer(Types.BIGINT) },
            

            { "tom_tat", new Integer(Types.VARCHAR) },
            

            { "nguon", new Integer(Types.VARCHAR) },
            

            { "noi_dung", new Integer(Types.VARCHAR) },
            

            { "ngay_ky", new Integer(Types.TIMESTAMP) },
            

            { "ngay_co_hieu_luc", new Integer(Types.TIMESTAMP) },
            

            { "nguoi_ky", new Integer(Types.VARCHAR) },
            

            { "ngay_ban_hanh", new Integer(Types.TIMESTAMP) },
            

            { "ngay_het_hieu_luc", new Integer(Types.TIMESTAMP) },
            

            { "ma_co_quan_ban_hanh", new Integer(Types.BIGINT) },
            

            { "tag_", new Integer(Types.VARCHAR) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "modifieddate", new Integer(Types.TIMESTAMP) },
            

            { "active", new Integer(Types.INTEGER) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_van_ban_phap_quy (ma_van_ban_phap_quy LONG not null primary key,ky_hieu_van_ban VARCHAR(75) null,ma_loai_van_ban LONG,ma_linh_vuc_van_ban LONG,tom_tat VARCHAR(75) null,nguon VARCHAR(75) null,noi_dung VARCHAR(75) null,ngay_ky DATE null,ngay_co_hieu_luc DATE null,nguoi_ky VARCHAR(75) null,ngay_ban_hanh DATE null,ngay_het_hieu_luc DATE null,ma_co_quan_ban_hanh LONG,tag_ VARCHAR(75) null,companyid LONG,userid LONG,createdate DATE null,modifieddate DATE null,active INTEGER,description VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_van_ban_phap_quy";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy"));
    private long _maVanBanPhapQuy;
    private String _kyHieuVanBan;
    private long _maLoaiVanBan;
    private long _maLinhVucVanBan;
    private String _tomTat;
    private String _nguon;
    private String _noiDung;
    private Date _ngayKy;
    private Date _ngayCoHieuLuc;
    private String _nguoiKy;
    private Date _ngayBanHanh;
    private Date _ngayHetHieuLuc;
    private long _maCoQuanBanHanh;
    private String _tag_;
    private long _companyid;
    private long _userid;
    private Date _createdate;
    private Date _modifieddate;
    private int _active;
    private String _description;
    private transient ExpandoBridge _expandoBridge;

    public VanBanPhapQuyModelImpl() {
    }

    public static VanBanPhapQuy toModel(VanBanPhapQuySoap soapModel) {
        VanBanPhapQuy model = new VanBanPhapQuyImpl();

        model.setMaVanBanPhapQuy(soapModel.getMaVanBanPhapQuy());
        model.setKyHieuVanBan(soapModel.getKyHieuVanBan());
        model.setMaLoaiVanBan(soapModel.getMaLoaiVanBan());
        model.setMaLinhVucVanBan(soapModel.getMaLinhVucVanBan());
        model.setTomTat(soapModel.getTomTat());
        model.setNguon(soapModel.getNguon());
        model.setNoiDung(soapModel.getNoiDung());
        model.setNgayKy(soapModel.getNgayKy());
        model.setNgayCoHieuLuc(soapModel.getNgayCoHieuLuc());
        model.setNguoiKy(soapModel.getNguoiKy());
        model.setNgayBanHanh(soapModel.getNgayBanHanh());
        model.setNgayHetHieuLuc(soapModel.getNgayHetHieuLuc());
        model.setMaCoQuanBanHanh(soapModel.getMaCoQuanBanHanh());
        model.setTag_(soapModel.getTag_());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());
        model.setCreatedate(soapModel.getCreatedate());
        model.setModifieddate(soapModel.getModifieddate());
        model.setActive(soapModel.getActive());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<VanBanPhapQuy> toModels(VanBanPhapQuySoap[] soapModels) {
        List<VanBanPhapQuy> models = new ArrayList<VanBanPhapQuy>(soapModels.length);

        for (VanBanPhapQuySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maVanBanPhapQuy;
    }

    public void setPrimaryKey(long pk) {
        setMaVanBanPhapQuy(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maVanBanPhapQuy);
    }

    public long getMaVanBanPhapQuy() {
        return _maVanBanPhapQuy;
    }

    public void setMaVanBanPhapQuy(long maVanBanPhapQuy) {
        _maVanBanPhapQuy = maVanBanPhapQuy;
    }

    public String getKyHieuVanBan() {
        return GetterUtil.getString(_kyHieuVanBan);
    }

    public void setKyHieuVanBan(String kyHieuVanBan) {
        _kyHieuVanBan = kyHieuVanBan;
    }

    public long getMaLoaiVanBan() {
        return _maLoaiVanBan;
    }

    public void setMaLoaiVanBan(long maLoaiVanBan) {
        _maLoaiVanBan = maLoaiVanBan;
    }

    public long getMaLinhVucVanBan() {
        return _maLinhVucVanBan;
    }

    public void setMaLinhVucVanBan(long maLinhVucVanBan) {
        _maLinhVucVanBan = maLinhVucVanBan;
    }

    public String getTomTat() {
        return GetterUtil.getString(_tomTat);
    }

    public void setTomTat(String tomTat) {
        _tomTat = tomTat;
    }

    public String getNguon() {
        return GetterUtil.getString(_nguon);
    }

    public void setNguon(String nguon) {
        _nguon = nguon;
    }

    public String getNoiDung() {
        return GetterUtil.getString(_noiDung);
    }

    public void setNoiDung(String noiDung) {
        _noiDung = noiDung;
    }

    public Date getNgayKy() {
        return _ngayKy;
    }

    public void setNgayKy(Date ngayKy) {
        _ngayKy = ngayKy;
    }

    public Date getNgayCoHieuLuc() {
        return _ngayCoHieuLuc;
    }

    public void setNgayCoHieuLuc(Date ngayCoHieuLuc) {
        _ngayCoHieuLuc = ngayCoHieuLuc;
    }

    public String getNguoiKy() {
        return GetterUtil.getString(_nguoiKy);
    }

    public void setNguoiKy(String nguoiKy) {
        _nguoiKy = nguoiKy;
    }

    public Date getNgayBanHanh() {
        return _ngayBanHanh;
    }

    public void setNgayBanHanh(Date ngayBanHanh) {
        _ngayBanHanh = ngayBanHanh;
    }

    public Date getNgayHetHieuLuc() {
        return _ngayHetHieuLuc;
    }

    public void setNgayHetHieuLuc(Date ngayHetHieuLuc) {
        _ngayHetHieuLuc = ngayHetHieuLuc;
    }

    public long getMaCoQuanBanHanh() {
        return _maCoQuanBanHanh;
    }

    public void setMaCoQuanBanHanh(long maCoQuanBanHanh) {
        _maCoQuanBanHanh = maCoQuanBanHanh;
    }

    public String getTag_() {
        return GetterUtil.getString(_tag_);
    }

    public void setTag_(String tag_) {
        _tag_ = tag_;
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

    public VanBanPhapQuy toEscapedModel() {
        if (isEscapedModel()) {
            return (VanBanPhapQuy) this;
        } else {
            VanBanPhapQuy model = new VanBanPhapQuyImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaVanBanPhapQuy(getMaVanBanPhapQuy());
            model.setKyHieuVanBan(HtmlUtil.escape(getKyHieuVanBan()));
            model.setMaLoaiVanBan(getMaLoaiVanBan());
            model.setMaLinhVucVanBan(getMaLinhVucVanBan());
            model.setTomTat(HtmlUtil.escape(getTomTat()));
            model.setNguon(HtmlUtil.escape(getNguon()));
            model.setNoiDung(HtmlUtil.escape(getNoiDung()));
            model.setNgayKy(getNgayKy());
            model.setNgayCoHieuLuc(getNgayCoHieuLuc());
            model.setNguoiKy(HtmlUtil.escape(getNguoiKy()));
            model.setNgayBanHanh(getNgayBanHanh());
            model.setNgayHetHieuLuc(getNgayHetHieuLuc());
            model.setMaCoQuanBanHanh(getMaCoQuanBanHanh());
            model.setTag_(HtmlUtil.escape(getTag_()));
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());
            model.setCreatedate(getCreatedate());
            model.setModifieddate(getModifieddate());
            model.setActive(getActive());
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (VanBanPhapQuy) Proxy.newProxyInstance(VanBanPhapQuy.class.getClassLoader(),
                    new Class[] { VanBanPhapQuy.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(VanBanPhapQuy.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        VanBanPhapQuyImpl clone = new VanBanPhapQuyImpl();

        clone.setMaVanBanPhapQuy(getMaVanBanPhapQuy());
        clone.setKyHieuVanBan(getKyHieuVanBan());
        clone.setMaLoaiVanBan(getMaLoaiVanBan());
        clone.setMaLinhVucVanBan(getMaLinhVucVanBan());
        clone.setTomTat(getTomTat());
        clone.setNguon(getNguon());
        clone.setNoiDung(getNoiDung());
        clone.setNgayKy(getNgayKy());
        clone.setNgayCoHieuLuc(getNgayCoHieuLuc());
        clone.setNguoiKy(getNguoiKy());
        clone.setNgayBanHanh(getNgayBanHanh());
        clone.setNgayHetHieuLuc(getNgayHetHieuLuc());
        clone.setMaCoQuanBanHanh(getMaCoQuanBanHanh());
        clone.setTag_(getTag_());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());
        clone.setCreatedate(getCreatedate());
        clone.setModifieddate(getModifieddate());
        clone.setActive(getActive());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(VanBanPhapQuy vanBanPhapQuy) {
        int value = 0;

        value = getKyHieuVanBan().toLowerCase()
                    .compareTo(vanBanPhapQuy.getKyHieuVanBan().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        VanBanPhapQuy vanBanPhapQuy = null;

        try {
            vanBanPhapQuy = (VanBanPhapQuy) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = vanBanPhapQuy.getPrimaryKey();

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

        sb.append("{maVanBanPhapQuy=");
        sb.append(getMaVanBanPhapQuy());
        sb.append(", kyHieuVanBan=");
        sb.append(getKyHieuVanBan());
        sb.append(", maLoaiVanBan=");
        sb.append(getMaLoaiVanBan());
        sb.append(", maLinhVucVanBan=");
        sb.append(getMaLinhVucVanBan());
        sb.append(", tomTat=");
        sb.append(getTomTat());
        sb.append(", nguon=");
        sb.append(getNguon());
        sb.append(", noiDung=");
        sb.append(getNoiDung());
        sb.append(", ngayKy=");
        sb.append(getNgayKy());
        sb.append(", ngayCoHieuLuc=");
        sb.append(getNgayCoHieuLuc());
        sb.append(", nguoiKy=");
        sb.append(getNguoiKy());
        sb.append(", ngayBanHanh=");
        sb.append(getNgayBanHanh());
        sb.append(", ngayHetHieuLuc=");
        sb.append(getNgayHetHieuLuc());
        sb.append(", maCoQuanBanHanh=");
        sb.append(getMaCoQuanBanHanh());
        sb.append(", tag_=");
        sb.append(getTag_());
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
        sb.append("com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maVanBanPhapQuy</column-name><column-value><![CDATA[");
        sb.append(getMaVanBanPhapQuy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kyHieuVanBan</column-name><column-value><![CDATA[");
        sb.append(getKyHieuVanBan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maLoaiVanBan</column-name><column-value><![CDATA[");
        sb.append(getMaLoaiVanBan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maLinhVucVanBan</column-name><column-value><![CDATA[");
        sb.append(getMaLinhVucVanBan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tomTat</column-name><column-value><![CDATA[");
        sb.append(getTomTat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nguon</column-name><column-value><![CDATA[");
        sb.append(getNguon());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>noiDung</column-name><column-value><![CDATA[");
        sb.append(getNoiDung());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ngayKy</column-name><column-value><![CDATA[");
        sb.append(getNgayKy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ngayCoHieuLuc</column-name><column-value><![CDATA[");
        sb.append(getNgayCoHieuLuc());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nguoiKy</column-name><column-value><![CDATA[");
        sb.append(getNguoiKy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ngayBanHanh</column-name><column-value><![CDATA[");
        sb.append(getNgayBanHanh());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ngayHetHieuLuc</column-name><column-value><![CDATA[");
        sb.append(getNgayHetHieuLuc());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maCoQuanBanHanh</column-name><column-value><![CDATA[");
        sb.append(getMaCoQuanBanHanh());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tag_</column-name><column-value><![CDATA[");
        sb.append(getTag_());
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
