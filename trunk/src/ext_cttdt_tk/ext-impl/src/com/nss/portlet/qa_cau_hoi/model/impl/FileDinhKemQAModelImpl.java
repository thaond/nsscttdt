package com.nss.portlet.qa_cau_hoi.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA;
import com.nss.portlet.qa_cau_hoi.model.FileDinhKemQASoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="FileDinhKemQAModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>FileDinhKemQA</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA
 * @see com.nss.portlet.qa_cau_hoi.model.FileDinhKemQAModel
 * @see com.nss.portlet.qa_cau_hoi.model.impl.FileDinhKemQAImpl
 *
 */
public class FileDinhKemQAModelImpl extends BaseModelImpl<FileDinhKemQA> {
    public static final String TABLE_NAME = "nss_qa_file_dinh_kem";
    public static final Object[][] TABLE_COLUMNS = {
            { "maFileDinhKemQA", new Integer(Types.BIGINT) },
            

            { "maCauHoi", new Integer(Types.BIGINT) },
            

            { "maCauTraLoi", new Integer(Types.BIGINT) },
            

            { "tenFile", new Integer(Types.VARCHAR) },
            

            { "kichThuoc", new Integer(Types.BIGINT) },
            

            { "duongDan", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_qa_file_dinh_kem (maFileDinhKemQA LONG not null primary key,maCauHoi LONG,maCauTraLoi LONG,tenFile VARCHAR(75) null,kichThuoc LONG,duongDan VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_qa_file_dinh_kem";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA"));
    private long _maFileDinhKemQA;
    private long _maCauHoi;
    private long _maCauTraLoi;
    private String _tenFile;
    private long _kichThuoc;
    private String _duongDan;
    private transient ExpandoBridge _expandoBridge;

    public FileDinhKemQAModelImpl() {
    }

    public static FileDinhKemQA toModel(FileDinhKemQASoap soapModel) {
        FileDinhKemQA model = new FileDinhKemQAImpl();

        model.setMaFileDinhKemQA(soapModel.getMaFileDinhKemQA());
        model.setMaCauHoi(soapModel.getMaCauHoi());
        model.setMaCauTraLoi(soapModel.getMaCauTraLoi());
        model.setTenFile(soapModel.getTenFile());
        model.setKichThuoc(soapModel.getKichThuoc());
        model.setDuongDan(soapModel.getDuongDan());

        return model;
    }

    public static List<FileDinhKemQA> toModels(FileDinhKemQASoap[] soapModels) {
        List<FileDinhKemQA> models = new ArrayList<FileDinhKemQA>(soapModels.length);

        for (FileDinhKemQASoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maFileDinhKemQA;
    }

    public void setPrimaryKey(long pk) {
        setMaFileDinhKemQA(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maFileDinhKemQA);
    }

    public long getMaFileDinhKemQA() {
        return _maFileDinhKemQA;
    }

    public void setMaFileDinhKemQA(long maFileDinhKemQA) {
        _maFileDinhKemQA = maFileDinhKemQA;
    }

    public long getMaCauHoi() {
        return _maCauHoi;
    }

    public void setMaCauHoi(long maCauHoi) {
        _maCauHoi = maCauHoi;
    }

    public long getMaCauTraLoi() {
        return _maCauTraLoi;
    }

    public void setMaCauTraLoi(long maCauTraLoi) {
        _maCauTraLoi = maCauTraLoi;
    }

    public String getTenFile() {
        return GetterUtil.getString(_tenFile);
    }

    public void setTenFile(String tenFile) {
        _tenFile = tenFile;
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

    public FileDinhKemQA toEscapedModel() {
        if (isEscapedModel()) {
            return (FileDinhKemQA) this;
        } else {
            FileDinhKemQA model = new FileDinhKemQAImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaFileDinhKemQA(getMaFileDinhKemQA());
            model.setMaCauHoi(getMaCauHoi());
            model.setMaCauTraLoi(getMaCauTraLoi());
            model.setTenFile(HtmlUtil.escape(getTenFile()));
            model.setKichThuoc(getKichThuoc());
            model.setDuongDan(HtmlUtil.escape(getDuongDan()));

            model = (FileDinhKemQA) Proxy.newProxyInstance(FileDinhKemQA.class.getClassLoader(),
                    new Class[] { FileDinhKemQA.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(FileDinhKemQA.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        FileDinhKemQAImpl clone = new FileDinhKemQAImpl();

        clone.setMaFileDinhKemQA(getMaFileDinhKemQA());
        clone.setMaCauHoi(getMaCauHoi());
        clone.setMaCauTraLoi(getMaCauTraLoi());
        clone.setTenFile(getTenFile());
        clone.setKichThuoc(getKichThuoc());
        clone.setDuongDan(getDuongDan());

        return clone;
    }

    public int compareTo(FileDinhKemQA fileDinhKemQA) {
        long pk = fileDinhKemQA.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        FileDinhKemQA fileDinhKemQA = null;

        try {
            fileDinhKemQA = (FileDinhKemQA) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = fileDinhKemQA.getPrimaryKey();

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

        sb.append("{maFileDinhKemQA=");
        sb.append(getMaFileDinhKemQA());
        sb.append(", maCauHoi=");
        sb.append(getMaCauHoi());
        sb.append(", maCauTraLoi=");
        sb.append(getMaCauTraLoi());
        sb.append(", tenFile=");
        sb.append(getTenFile());
        sb.append(", kichThuoc=");
        sb.append(getKichThuoc());
        sb.append(", duongDan=");
        sb.append(getDuongDan());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maFileDinhKemQA</column-name><column-value><![CDATA[");
        sb.append(getMaFileDinhKemQA());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maCauHoi</column-name><column-value><![CDATA[");
        sb.append(getMaCauHoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maCauTraLoi</column-name><column-value><![CDATA[");
        sb.append(getMaCauTraLoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenFile</column-name><column-value><![CDATA[");
        sb.append(getTenFile());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kichThuoc</column-name><column-value><![CDATA[");
        sb.append(getKichThuoc());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>duongDan</column-name><column-value><![CDATA[");
        sb.append(getDuongDan());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
