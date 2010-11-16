package com.nss.portlet.van_ban_phap_quy.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.van_ban_phap_quy.model.FileDinhKem;
import com.nss.portlet.van_ban_phap_quy.model.FileDinhKemSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="FileDinhKemModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>FileDinhKem</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.van_ban_phap_quy.model.FileDinhKem
 * @see com.nss.portlet.van_ban_phap_quy.model.FileDinhKemModel
 * @see com.nss.portlet.van_ban_phap_quy.model.impl.FileDinhKemImpl
 *
 */
public class FileDinhKemModelImpl extends BaseModelImpl<FileDinhKem> {
    public static final String TABLE_NAME = "nss_file_dinh_kem";
    public static final Object[][] TABLE_COLUMNS = {
            { "ma_file_dinh_kem", new Integer(Types.BIGINT) },
            

            { "ma_van_ban_phap_quy", new Integer(Types.BIGINT) },
            

            { "ten_file", new Integer(Types.VARCHAR) },
            

            { "mo_ta", new Integer(Types.VARCHAR) },
            

            { "kich_thuoc", new Integer(Types.BIGINT) },
            

            { "duong_dan", new Integer(Types.VARCHAR) },
            

            { "phien_ban", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_file_dinh_kem (ma_file_dinh_kem LONG not null primary key,ma_van_ban_phap_quy LONG,ten_file VARCHAR(75) null,mo_ta VARCHAR(75) null,kich_thuoc LONG,duong_dan VARCHAR(75) null,phien_ban INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_file_dinh_kem";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.van_ban_phap_quy.model.FileDinhKem"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.van_ban_phap_quy.model.FileDinhKem"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.van_ban_phap_quy.model.FileDinhKem"));
    private long _maFileDinhKem;
    private long _maVanBanPhapQuy;
    private String _tenFile;
    private String _moTa;
    private long _kichThuoc;
    private String _duongDan;
    private int _phienBan;
    private transient ExpandoBridge _expandoBridge;

    public FileDinhKemModelImpl() {
    }

    public static FileDinhKem toModel(FileDinhKemSoap soapModel) {
        FileDinhKem model = new FileDinhKemImpl();

        model.setMaFileDinhKem(soapModel.getMaFileDinhKem());
        model.setMaVanBanPhapQuy(soapModel.getMaVanBanPhapQuy());
        model.setTenFile(soapModel.getTenFile());
        model.setMoTa(soapModel.getMoTa());
        model.setKichThuoc(soapModel.getKichThuoc());
        model.setDuongDan(soapModel.getDuongDan());
        model.setPhienBan(soapModel.getPhienBan());

        return model;
    }

    public static List<FileDinhKem> toModels(FileDinhKemSoap[] soapModels) {
        List<FileDinhKem> models = new ArrayList<FileDinhKem>(soapModels.length);

        for (FileDinhKemSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maFileDinhKem;
    }

    public void setPrimaryKey(long pk) {
        setMaFileDinhKem(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maFileDinhKem);
    }

    public long getMaFileDinhKem() {
        return _maFileDinhKem;
    }

    public void setMaFileDinhKem(long maFileDinhKem) {
        _maFileDinhKem = maFileDinhKem;
    }

    public long getMaVanBanPhapQuy() {
        return _maVanBanPhapQuy;
    }

    public void setMaVanBanPhapQuy(long maVanBanPhapQuy) {
        _maVanBanPhapQuy = maVanBanPhapQuy;
    }

    public String getTenFile() {
        return GetterUtil.getString(_tenFile);
    }

    public void setTenFile(String tenFile) {
        _tenFile = tenFile;
    }

    public String getMoTa() {
        return GetterUtil.getString(_moTa);
    }

    public void setMoTa(String moTa) {
        _moTa = moTa;
    }

    public long getKichThuoc() {
        return _kichThuoc;
    }

    public void setKichThuoc(long kichThuoc) {
        _kichThuoc = kichThuoc;
    }

    public String getDuongDan() {
        return GetterUtil.getString(_duongDan);
    }

    public void setDuongDan(String duongDan) {
        _duongDan = duongDan;
    }

    public int getPhienBan() {
        return _phienBan;
    }

    public void setPhienBan(int phienBan) {
        _phienBan = phienBan;
    }

    public FileDinhKem toEscapedModel() {
        if (isEscapedModel()) {
            return (FileDinhKem) this;
        } else {
            FileDinhKem model = new FileDinhKemImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaFileDinhKem(getMaFileDinhKem());
            model.setMaVanBanPhapQuy(getMaVanBanPhapQuy());
            model.setTenFile(HtmlUtil.escape(getTenFile()));
            model.setMoTa(HtmlUtil.escape(getMoTa()));
            model.setKichThuoc(getKichThuoc());
            model.setDuongDan(HtmlUtil.escape(getDuongDan()));
            model.setPhienBan(getPhienBan());

            model = (FileDinhKem) Proxy.newProxyInstance(FileDinhKem.class.getClassLoader(),
                    new Class[] { FileDinhKem.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(FileDinhKem.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        FileDinhKemImpl clone = new FileDinhKemImpl();

        clone.setMaFileDinhKem(getMaFileDinhKem());
        clone.setMaVanBanPhapQuy(getMaVanBanPhapQuy());
        clone.setTenFile(getTenFile());
        clone.setMoTa(getMoTa());
        clone.setKichThuoc(getKichThuoc());
        clone.setDuongDan(getDuongDan());
        clone.setPhienBan(getPhienBan());

        return clone;
    }

    public int compareTo(FileDinhKem fileDinhKem) {
        int value = 0;

        if (getMaFileDinhKem() < fileDinhKem.getMaFileDinhKem()) {
            value = -1;
        } else if (getMaFileDinhKem() > fileDinhKem.getMaFileDinhKem()) {
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

        FileDinhKem fileDinhKem = null;

        try {
            fileDinhKem = (FileDinhKem) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = fileDinhKem.getPrimaryKey();

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

        sb.append("{maFileDinhKem=");
        sb.append(getMaFileDinhKem());
        sb.append(", maVanBanPhapQuy=");
        sb.append(getMaVanBanPhapQuy());
        sb.append(", tenFile=");
        sb.append(getTenFile());
        sb.append(", moTa=");
        sb.append(getMoTa());
        sb.append(", kichThuoc=");
        sb.append(getKichThuoc());
        sb.append(", duongDan=");
        sb.append(getDuongDan());
        sb.append(", phienBan=");
        sb.append(getPhienBan());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.van_ban_phap_quy.model.FileDinhKem");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maFileDinhKem</column-name><column-value><![CDATA[");
        sb.append(getMaFileDinhKem());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maVanBanPhapQuy</column-name><column-value><![CDATA[");
        sb.append(getMaVanBanPhapQuy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenFile</column-name><column-value><![CDATA[");
        sb.append(getTenFile());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moTa</column-name><column-value><![CDATA[");
        sb.append(getMoTa());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kichThuoc</column-name><column-value><![CDATA[");
        sb.append(getKichThuoc());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>duongDan</column-name><column-value><![CDATA[");
        sb.append(getDuongDan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>phienBan</column-name><column-value><![CDATA[");
        sb.append(getPhienBan());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
