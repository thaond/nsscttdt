package com.nss.portlet.qa_chu_de.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoiSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="QAChuDeCauHoiModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>QAChuDeCauHoi</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi
 * @see com.nss.portlet.qa_chu_de.model.QAChuDeCauHoiModel
 * @see com.nss.portlet.qa_chu_de.model.impl.QAChuDeCauHoiImpl
 *
 */
public class QAChuDeCauHoiModelImpl extends BaseModelImpl<QAChuDeCauHoi> {
    public static final String TABLE_NAME = "nss_qa_chu_de";
    public static final Object[][] TABLE_COLUMNS = {
            { "maChuDeCauHoi", new Integer(Types.BIGINT) },
            

            { "tenChuDeCauHoi", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_qa_chu_de (maChuDeCauHoi LONG not null primary key,tenChuDeCauHoi VARCHAR(75) null,active INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table nss_qa_chu_de";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi"));
    private long _maChuDeCauHoi;
    private String _tenChuDeCauHoi;
    private int _active;
    private transient ExpandoBridge _expandoBridge;

    public QAChuDeCauHoiModelImpl() {
    }

    public static QAChuDeCauHoi toModel(QAChuDeCauHoiSoap soapModel) {
        QAChuDeCauHoi model = new QAChuDeCauHoiImpl();

        model.setMaChuDeCauHoi(soapModel.getMaChuDeCauHoi());
        model.setTenChuDeCauHoi(soapModel.getTenChuDeCauHoi());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<QAChuDeCauHoi> toModels(QAChuDeCauHoiSoap[] soapModels) {
        List<QAChuDeCauHoi> models = new ArrayList<QAChuDeCauHoi>(soapModels.length);

        for (QAChuDeCauHoiSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maChuDeCauHoi;
    }

    public void setPrimaryKey(long pk) {
        setMaChuDeCauHoi(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maChuDeCauHoi);
    }

    public long getMaChuDeCauHoi() {
        return _maChuDeCauHoi;
    }

    public void setMaChuDeCauHoi(long maChuDeCauHoi) {
        _maChuDeCauHoi = maChuDeCauHoi;
    }

    public String getTenChuDeCauHoi() {
        return GetterUtil.getString(_tenChuDeCauHoi);
    }

    public void setTenChuDeCauHoi(String tenChuDeCauHoi) {
        _tenChuDeCauHoi = tenChuDeCauHoi;
    }

    public int getActive() {
        return _active;
    }

    public void setActive(int active) {
        _active = active;
    }

    public QAChuDeCauHoi toEscapedModel() {
        if (isEscapedModel()) {
            return (QAChuDeCauHoi) this;
        } else {
            QAChuDeCauHoi model = new QAChuDeCauHoiImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaChuDeCauHoi(getMaChuDeCauHoi());
            model.setTenChuDeCauHoi(HtmlUtil.escape(getTenChuDeCauHoi()));
            model.setActive(getActive());

            model = (QAChuDeCauHoi) Proxy.newProxyInstance(QAChuDeCauHoi.class.getClassLoader(),
                    new Class[] { QAChuDeCauHoi.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(QAChuDeCauHoi.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        QAChuDeCauHoiImpl clone = new QAChuDeCauHoiImpl();

        clone.setMaChuDeCauHoi(getMaChuDeCauHoi());
        clone.setTenChuDeCauHoi(getTenChuDeCauHoi());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(QAChuDeCauHoi qaChuDeCauHoi) {
        int value = 0;

        value = getTenChuDeCauHoi().toLowerCase()
                    .compareTo(qaChuDeCauHoi.getTenChuDeCauHoi().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        QAChuDeCauHoi qaChuDeCauHoi = null;

        try {
            qaChuDeCauHoi = (QAChuDeCauHoi) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = qaChuDeCauHoi.getPrimaryKey();

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

        sb.append("{maChuDeCauHoi=");
        sb.append(getMaChuDeCauHoi());
        sb.append(", tenChuDeCauHoi=");
        sb.append(getTenChuDeCauHoi());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maChuDeCauHoi</column-name><column-value><![CDATA[");
        sb.append(getMaChuDeCauHoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenChuDeCauHoi</column-name><column-value><![CDATA[");
        sb.append(getTenChuDeCauHoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
