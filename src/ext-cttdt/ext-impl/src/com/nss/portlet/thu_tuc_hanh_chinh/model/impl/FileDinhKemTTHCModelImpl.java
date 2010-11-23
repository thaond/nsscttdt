package com.nss.portlet.thu_tuc_hanh_chinh.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC;
import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHCSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="FileDinhKemTTHCModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>FileDinhKemTTHC</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHCModel
 * @see com.nss.portlet.thu_tuc_hanh_chinh.model.impl.FileDinhKemTTHCImpl
 *
 */
public class FileDinhKemTTHCModelImpl extends BaseModelImpl<FileDinhKemTTHC> {
    public static final String TABLE_NAME = "nss_file_dinh_kem_tthc";
    public static final Object[][] TABLE_COLUMNS = {
            { "maFileDinhKemTTHC", new Integer(Types.BIGINT) },
            

            { "maThuTucHanhChinh", new Integer(Types.BIGINT) },
            

            { "tenFile", new Integer(Types.VARCHAR) },
            

            { "mo_ta", new Integer(Types.VARCHAR) },
            

            { "kichThuoc", new Integer(Types.BIGINT) },
            

            { "duongDan", new Integer(Types.VARCHAR) },
            

            { "phienBan", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_file_dinh_kem_tthc (maFileDinhKemTTHC LONG not null primary key,maThuTucHanhChinh LONG,tenFile VARCHAR(75) null,mo_ta VARCHAR(75) null,kichThuoc LONG,duongDan VARCHAR(75) null,phienBan INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_file_dinh_kem_tthc";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC"));
    private long _maFileDinhKemTTHC;
    private long _maThuTucHanhChinh;
    private String _tenFile;
    private String _moTa;
    private long _kichThuoc;
    private String _duongDan;
    private int _phienBan;
    private transient ExpandoBridge _expandoBridge;

    public FileDinhKemTTHCModelImpl() {
    }

    public static FileDinhKemTTHC toModel(FileDinhKemTTHCSoap soapModel) {
        FileDinhKemTTHC model = new FileDinhKemTTHCImpl();

        model.setMaFileDinhKemTTHC(soapModel.getMaFileDinhKemTTHC());
        model.setMaThuTucHanhChinh(soapModel.getMaThuTucHanhChinh());
        model.setTenFile(soapModel.getTenFile());
        model.setMoTa(soapModel.getMoTa());
        model.setKichThuoc(soapModel.getKichThuoc());
        model.setDuongDan(soapModel.getDuongDan());
        model.setPhienBan(soapModel.getPhienBan());

        return model;
    }

    public static List<FileDinhKemTTHC> toModels(
        FileDinhKemTTHCSoap[] soapModels) {
        List<FileDinhKemTTHC> models = new ArrayList<FileDinhKemTTHC>(soapModels.length);

        for (FileDinhKemTTHCSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maFileDinhKemTTHC;
    }

    public void setPrimaryKey(long pk) {
        setMaFileDinhKemTTHC(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maFileDinhKemTTHC);
    }

    public long getMaFileDinhKemTTHC() {
        return _maFileDinhKemTTHC;
    }

    public void setMaFileDinhKemTTHC(long maFileDinhKemTTHC) {
        _maFileDinhKemTTHC = maFileDinhKemTTHC;
    }

    public long getMaThuTucHanhChinh() {
        return _maThuTucHanhChinh;
    }

    public void setMaThuTucHanhChinh(long maThuTucHanhChinh) {
        _maThuTucHanhChinh = maThuTucHanhChinh;
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

    public FileDinhKemTTHC toEscapedModel() {
        if (isEscapedModel()) {
            return (FileDinhKemTTHC) this;
        } else {
            FileDinhKemTTHC model = new FileDinhKemTTHCImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaFileDinhKemTTHC(getMaFileDinhKemTTHC());
            model.setMaThuTucHanhChinh(getMaThuTucHanhChinh());
            model.setTenFile(HtmlUtil.escape(getTenFile()));
            model.setMoTa(HtmlUtil.escape(getMoTa()));
            model.setKichThuoc(getKichThuoc());
            model.setDuongDan(HtmlUtil.escape(getDuongDan()));
            model.setPhienBan(getPhienBan());

            model = (FileDinhKemTTHC) Proxy.newProxyInstance(FileDinhKemTTHC.class.getClassLoader(),
                    new Class[] { FileDinhKemTTHC.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(FileDinhKemTTHC.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        FileDinhKemTTHCImpl clone = new FileDinhKemTTHCImpl();

        clone.setMaFileDinhKemTTHC(getMaFileDinhKemTTHC());
        clone.setMaThuTucHanhChinh(getMaThuTucHanhChinh());
        clone.setTenFile(getTenFile());
        clone.setMoTa(getMoTa());
        clone.setKichThuoc(getKichThuoc());
        clone.setDuongDan(getDuongDan());
        clone.setPhienBan(getPhienBan());

        return clone;
    }

    public int compareTo(FileDinhKemTTHC fileDinhKemTTHC) {
        int value = 0;

        if (getMaFileDinhKemTTHC() < fileDinhKemTTHC.getMaFileDinhKemTTHC()) {
            value = -1;
        } else if (getMaFileDinhKemTTHC() > fileDinhKemTTHC.getMaFileDinhKemTTHC()) {
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

        FileDinhKemTTHC fileDinhKemTTHC = null;

        try {
            fileDinhKemTTHC = (FileDinhKemTTHC) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = fileDinhKemTTHC.getPrimaryKey();

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

        sb.append("{maFileDinhKemTTHC=");
        sb.append(getMaFileDinhKemTTHC());
        sb.append(", maThuTucHanhChinh=");
        sb.append(getMaThuTucHanhChinh());
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
        sb.append("com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maFileDinhKemTTHC</column-name><column-value><![CDATA[");
        sb.append(getMaFileDinhKemTTHC());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maThuTucHanhChinh</column-name><column-value><![CDATA[");
        sb.append(getMaThuTucHanhChinh());
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
