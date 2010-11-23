package com.nss.portlet.qa_phan_quyen.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen;
import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyenSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="QAPhanQuyenModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>QAPhanQuyen</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen
 * @see com.nss.portlet.qa_phan_quyen.model.QAPhanQuyenModel
 * @see com.nss.portlet.qa_phan_quyen.model.impl.QAPhanQuyenImpl
 *
 */
public class QAPhanQuyenModelImpl extends BaseModelImpl<QAPhanQuyen> {
    public static final String TABLE_NAME = "nss_qa_phan_quyen";
    public static final Object[][] TABLE_COLUMNS = {
            { "maPhanQuyen", new Integer(Types.BIGINT) },
            

            { "maChuDeCauHoi", new Integer(Types.BIGINT) },
            

            { "maNguoiTraLoi", new Integer(Types.BIGINT) },
            

            { "quyenXem", new Integer(Types.BOOLEAN) },
            

            { "quyenCapNhat", new Integer(Types.BOOLEAN) },
            

            { "quyenTraLoi", new Integer(Types.BOOLEAN) },
            

            { "quyenDuyet", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_qa_phan_quyen (maPhanQuyen LONG not null primary key,maChuDeCauHoi LONG,maNguoiTraLoi LONG,quyenXem BOOLEAN,quyenCapNhat BOOLEAN,quyenTraLoi BOOLEAN,quyenDuyet BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table nss_qa_phan_quyen";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen"));
    private long _maPhanQuyen;
    private long _maChuDeCauHoi;
    private long _maNguoiTraLoi;
    private boolean _quyenXem;
    private boolean _quyenCapNhat;
    private boolean _quyenTraLoi;
    private boolean _quyenDuyet;
    private transient ExpandoBridge _expandoBridge;

    public QAPhanQuyenModelImpl() {
    }

    public static QAPhanQuyen toModel(QAPhanQuyenSoap soapModel) {
        QAPhanQuyen model = new QAPhanQuyenImpl();

        model.setMaPhanQuyen(soapModel.getMaPhanQuyen());
        model.setMaChuDeCauHoi(soapModel.getMaChuDeCauHoi());
        model.setMaNguoiTraLoi(soapModel.getMaNguoiTraLoi());
        model.setQuyenXem(soapModel.getQuyenXem());
        model.setQuyenCapNhat(soapModel.getQuyenCapNhat());
        model.setQuyenTraLoi(soapModel.getQuyenTraLoi());
        model.setQuyenDuyet(soapModel.getQuyenDuyet());

        return model;
    }

    public static List<QAPhanQuyen> toModels(QAPhanQuyenSoap[] soapModels) {
        List<QAPhanQuyen> models = new ArrayList<QAPhanQuyen>(soapModels.length);

        for (QAPhanQuyenSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maPhanQuyen;
    }

    public void setPrimaryKey(long pk) {
        setMaPhanQuyen(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maPhanQuyen);
    }

    public long getMaPhanQuyen() {
        return _maPhanQuyen;
    }

    public void setMaPhanQuyen(long maPhanQuyen) {
        _maPhanQuyen = maPhanQuyen;
    }

    public long getMaChuDeCauHoi() {
        return _maChuDeCauHoi;
    }

    public void setMaChuDeCauHoi(long maChuDeCauHoi) {
        _maChuDeCauHoi = maChuDeCauHoi;
    }

    public long getMaNguoiTraLoi() {
        return _maNguoiTraLoi;
    }

    public void setMaNguoiTraLoi(long maNguoiTraLoi) {
        _maNguoiTraLoi = maNguoiTraLoi;
    }

    public boolean getQuyenXem() {
        return _quyenXem;
    }

    public boolean isQuyenXem() {
        return _quyenXem;
    }

    public void setQuyenXem(boolean quyenXem) {
        _quyenXem = quyenXem;
    }

    public boolean getQuyenCapNhat() {
        return _quyenCapNhat;
    }

    public boolean isQuyenCapNhat() {
        return _quyenCapNhat;
    }

    public void setQuyenCapNhat(boolean quyenCapNhat) {
        _quyenCapNhat = quyenCapNhat;
    }

    public boolean getQuyenTraLoi() {
        return _quyenTraLoi;
    }

    public boolean isQuyenTraLoi() {
        return _quyenTraLoi;
    }

    public void setQuyenTraLoi(boolean quyenTraLoi) {
        _quyenTraLoi = quyenTraLoi;
    }

    public boolean getQuyenDuyet() {
        return _quyenDuyet;
    }

    public boolean isQuyenDuyet() {
        return _quyenDuyet;
    }

    public void setQuyenDuyet(boolean quyenDuyet) {
        _quyenDuyet = quyenDuyet;
    }

    public QAPhanQuyen toEscapedModel() {
        if (isEscapedModel()) {
            return (QAPhanQuyen) this;
        } else {
            QAPhanQuyen model = new QAPhanQuyenImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaPhanQuyen(getMaPhanQuyen());
            model.setMaChuDeCauHoi(getMaChuDeCauHoi());
            model.setMaNguoiTraLoi(getMaNguoiTraLoi());
            model.setQuyenXem(getQuyenXem());
            model.setQuyenCapNhat(getQuyenCapNhat());
            model.setQuyenTraLoi(getQuyenTraLoi());
            model.setQuyenDuyet(getQuyenDuyet());

            model = (QAPhanQuyen) Proxy.newProxyInstance(QAPhanQuyen.class.getClassLoader(),
                    new Class[] { QAPhanQuyen.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(QAPhanQuyen.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        QAPhanQuyenImpl clone = new QAPhanQuyenImpl();

        clone.setMaPhanQuyen(getMaPhanQuyen());
        clone.setMaChuDeCauHoi(getMaChuDeCauHoi());
        clone.setMaNguoiTraLoi(getMaNguoiTraLoi());
        clone.setQuyenXem(getQuyenXem());
        clone.setQuyenCapNhat(getQuyenCapNhat());
        clone.setQuyenTraLoi(getQuyenTraLoi());
        clone.setQuyenDuyet(getQuyenDuyet());

        return clone;
    }

    public int compareTo(QAPhanQuyen qaPhanQuyen) {
        long pk = qaPhanQuyen.getPrimaryKey();

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

        QAPhanQuyen qaPhanQuyen = null;

        try {
            qaPhanQuyen = (QAPhanQuyen) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = qaPhanQuyen.getPrimaryKey();

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

        sb.append("{maPhanQuyen=");
        sb.append(getMaPhanQuyen());
        sb.append(", maChuDeCauHoi=");
        sb.append(getMaChuDeCauHoi());
        sb.append(", maNguoiTraLoi=");
        sb.append(getMaNguoiTraLoi());
        sb.append(", quyenXem=");
        sb.append(getQuyenXem());
        sb.append(", quyenCapNhat=");
        sb.append(getQuyenCapNhat());
        sb.append(", quyenTraLoi=");
        sb.append(getQuyenTraLoi());
        sb.append(", quyenDuyet=");
        sb.append(getQuyenDuyet());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maPhanQuyen</column-name><column-value><![CDATA[");
        sb.append(getMaPhanQuyen());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maChuDeCauHoi</column-name><column-value><![CDATA[");
        sb.append(getMaChuDeCauHoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maNguoiTraLoi</column-name><column-value><![CDATA[");
        sb.append(getMaNguoiTraLoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quyenXem</column-name><column-value><![CDATA[");
        sb.append(getQuyenXem());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quyenCapNhat</column-name><column-value><![CDATA[");
        sb.append(getQuyenCapNhat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quyenTraLoi</column-name><column-value><![CDATA[");
        sb.append(getQuyenTraLoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quyenDuyet</column-name><column-value><![CDATA[");
        sb.append(getQuyenDuyet());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
