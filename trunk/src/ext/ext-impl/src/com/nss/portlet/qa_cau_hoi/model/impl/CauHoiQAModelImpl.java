package com.nss.portlet.qa_cau_hoi.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;
import com.nss.portlet.qa_cau_hoi.model.CauHoiQASoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="CauHoiQAModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>CauHoiQA</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_hoi.model.CauHoiQA
 * @see com.nss.portlet.qa_cau_hoi.model.CauHoiQAModel
 * @see com.nss.portlet.qa_cau_hoi.model.impl.CauHoiQAImpl
 *
 */
public class CauHoiQAModelImpl extends BaseModelImpl<CauHoiQA> {
    public static final String TABLE_NAME = "nss_qa_cau_hoi";
    public static final Object[][] TABLE_COLUMNS = {
            { "maCauHoiQA", new Integer(Types.BIGINT) },
            

            { "maChuDeCauHoi", new Integer(Types.BIGINT) },
            

            { "tieuDe", new Integer(Types.VARCHAR) },
            

            { "tenNguoiHoi", new Integer(Types.VARCHAR) },
            

            { "email", new Integer(Types.VARCHAR) },
            

            { "noiDungHoi", new Integer(Types.VARCHAR) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "publishdate", new Integer(Types.TIMESTAMP) },
            

            { "publish", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_qa_cau_hoi (maCauHoiQA LONG not null primary key,maChuDeCauHoi LONG,tieuDe VARCHAR(75) null,tenNguoiHoi VARCHAR(75) null,email VARCHAR(75) null,noiDungHoi VARCHAR(75) null,createdate DATE null,publishdate DATE null,publish BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table nss_qa_cau_hoi";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.qa_cau_hoi.model.CauHoiQA"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.qa_cau_hoi.model.CauHoiQA"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.qa_cau_hoi.model.CauHoiQA"));
    private long _maCauHoiQA;
    private long _maChuDeCauHoi;
    private String _tieuDe;
    private String _tenNguoiHoi;
    private String _email;
    private String _noiDungHoi;
    private Date _createdate;
    private Date _publishdate;
    private boolean _publish;
    private transient ExpandoBridge _expandoBridge;

    public CauHoiQAModelImpl() {
    }

    public static CauHoiQA toModel(CauHoiQASoap soapModel) {
        CauHoiQA model = new CauHoiQAImpl();

        model.setMaCauHoiQA(soapModel.getMaCauHoiQA());
        model.setMaChuDeCauHoi(soapModel.getMaChuDeCauHoi());
        model.setTieuDe(soapModel.getTieuDe());
        model.setTenNguoiHoi(soapModel.getTenNguoiHoi());
        model.setEmail(soapModel.getEmail());
        model.setNoiDungHoi(soapModel.getNoiDungHoi());
        model.setCreatedate(soapModel.getCreatedate());
        model.setPublishdate(soapModel.getPublishdate());
        model.setPublish(soapModel.getPublish());

        return model;
    }

    public static List<CauHoiQA> toModels(CauHoiQASoap[] soapModels) {
        List<CauHoiQA> models = new ArrayList<CauHoiQA>(soapModels.length);

        for (CauHoiQASoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maCauHoiQA;
    }

    public void setPrimaryKey(long pk) {
        setMaCauHoiQA(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maCauHoiQA);
    }

    public long getMaCauHoiQA() {
        return _maCauHoiQA;
    }

    public void setMaCauHoiQA(long maCauHoiQA) {
        _maCauHoiQA = maCauHoiQA;
    }

    public long getMaChuDeCauHoi() {
        return _maChuDeCauHoi;
    }

    public void setMaChuDeCauHoi(long maChuDeCauHoi) {
        _maChuDeCauHoi = maChuDeCauHoi;
    }

    public String getTieuDe() {
        return GetterUtil.getString(_tieuDe);
    }

    public void setTieuDe(String tieuDe) {
        _tieuDe = tieuDe;
    }

    public String getTenNguoiHoi() {
        return GetterUtil.getString(_tenNguoiHoi);
    }

    public void setTenNguoiHoi(String tenNguoiHoi) {
        _tenNguoiHoi = tenNguoiHoi;
    }

    public String getEmail() {
        return GetterUtil.getString(_email);
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getNoiDungHoi() {
        return GetterUtil.getString(_noiDungHoi);
    }

    public void setNoiDungHoi(String noiDungHoi) {
        _noiDungHoi = noiDungHoi;
    }

    public Date getCreatedate() {
        return _createdate;
    }

    public void setCreatedate(Date createdate) {
        _createdate = createdate;
    }

    public Date getPublishdate() {
        return _publishdate;
    }

    public void setPublishdate(Date publishdate) {
        _publishdate = publishdate;
    }

    public boolean getPublish() {
        return _publish;
    }

    public boolean isPublish() {
        return _publish;
    }

    public void setPublish(boolean publish) {
        _publish = publish;
    }

    public CauHoiQA toEscapedModel() {
        if (isEscapedModel()) {
            return (CauHoiQA) this;
        } else {
            CauHoiQA model = new CauHoiQAImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaCauHoiQA(getMaCauHoiQA());
            model.setMaChuDeCauHoi(getMaChuDeCauHoi());
            model.setTieuDe(HtmlUtil.escape(getTieuDe()));
            model.setTenNguoiHoi(HtmlUtil.escape(getTenNguoiHoi()));
            model.setEmail(HtmlUtil.escape(getEmail()));
            model.setNoiDungHoi(HtmlUtil.escape(getNoiDungHoi()));
            model.setCreatedate(getCreatedate());
            model.setPublishdate(getPublishdate());
            model.setPublish(getPublish());

            model = (CauHoiQA) Proxy.newProxyInstance(CauHoiQA.class.getClassLoader(),
                    new Class[] { CauHoiQA.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(CauHoiQA.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        CauHoiQAImpl clone = new CauHoiQAImpl();

        clone.setMaCauHoiQA(getMaCauHoiQA());
        clone.setMaChuDeCauHoi(getMaChuDeCauHoi());
        clone.setTieuDe(getTieuDe());
        clone.setTenNguoiHoi(getTenNguoiHoi());
        clone.setEmail(getEmail());
        clone.setNoiDungHoi(getNoiDungHoi());
        clone.setCreatedate(getCreatedate());
        clone.setPublishdate(getPublishdate());
        clone.setPublish(getPublish());

        return clone;
    }

    public int compareTo(CauHoiQA cauHoiQA) {
        int value = 0;

        value = getTieuDe().toLowerCase()
                    .compareTo(cauHoiQA.getTieuDe().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        CauHoiQA cauHoiQA = null;

        try {
            cauHoiQA = (CauHoiQA) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = cauHoiQA.getPrimaryKey();

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

        sb.append("{maCauHoiQA=");
        sb.append(getMaCauHoiQA());
        sb.append(", maChuDeCauHoi=");
        sb.append(getMaChuDeCauHoi());
        sb.append(", tieuDe=");
        sb.append(getTieuDe());
        sb.append(", tenNguoiHoi=");
        sb.append(getTenNguoiHoi());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", noiDungHoi=");
        sb.append(getNoiDungHoi());
        sb.append(", createdate=");
        sb.append(getCreatedate());
        sb.append(", publishdate=");
        sb.append(getPublishdate());
        sb.append(", publish=");
        sb.append(getPublish());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.qa_cau_hoi.model.CauHoiQA");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maCauHoiQA</column-name><column-value><![CDATA[");
        sb.append(getMaCauHoiQA());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maChuDeCauHoi</column-name><column-value><![CDATA[");
        sb.append(getMaChuDeCauHoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tieuDe</column-name><column-value><![CDATA[");
        sb.append(getTieuDe());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tenNguoiHoi</column-name><column-value><![CDATA[");
        sb.append(getTenNguoiHoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>noiDungHoi</column-name><column-value><![CDATA[");
        sb.append(getNoiDungHoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdate</column-name><column-value><![CDATA[");
        sb.append(getCreatedate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publishdate</column-name><column-value><![CDATA[");
        sb.append(getPublishdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publish</column-name><column-value><![CDATA[");
        sb.append(getPublish());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
