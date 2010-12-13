package com.nss.portlet.qa_cau_tra_loi.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA;
import com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQASoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="CauTraLoiQAModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>CauTraLoiQA</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA
 * @see com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQAModel
 * @see com.nss.portlet.qa_cau_tra_loi.model.impl.CauTraLoiQAImpl
 *
 */
public class CauTraLoiQAModelImpl extends BaseModelImpl<CauTraLoiQA> {
    public static final String TABLE_NAME = "nss_qa_cau_tra_loi";
    public static final Object[][] TABLE_COLUMNS = {
            { "maCauTraLoiQA", new Integer(Types.BIGINT) },
            

            { "maCauHoiQA", new Integer(Types.BIGINT) },
            

            { "maNguoiTraLoi", new Integer(Types.BIGINT) },
            

            { "noiDungTraLoi", new Integer(Types.VARCHAR) },
            

            { "createdate", new Integer(Types.TIMESTAMP) },
            

            { "publishdate", new Integer(Types.TIMESTAMP) },
            

            { "publish", new Integer(Types.BOOLEAN) },
            

            { "answerThroughWeb", new Integer(Types.BOOLEAN) },
            

            { "answerThroughEmail", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_qa_cau_tra_loi (maCauTraLoiQA LONG not null primary key,maCauHoiQA LONG,maNguoiTraLoi LONG,noiDungTraLoi VARCHAR(75) null,createdate DATE null,publishdate DATE null,publish BOOLEAN,answerThroughWeb BOOLEAN,answerThroughEmail VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_qa_cau_tra_loi";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA"));
    private long _maCauTraLoiQA;
    private long _maCauHoiQA;
    private long _maNguoiTraLoi;
    private String _noiDungTraLoi;
    private Date _createdate;
    private Date _publishdate;
    private boolean _publish;
    private boolean _answerThroughWeb;
    private String _answerThroughEmail;
    private transient ExpandoBridge _expandoBridge;

    public CauTraLoiQAModelImpl() {
    }

    public static CauTraLoiQA toModel(CauTraLoiQASoap soapModel) {
        CauTraLoiQA model = new CauTraLoiQAImpl();

        model.setMaCauTraLoiQA(soapModel.getMaCauTraLoiQA());
        model.setMaCauHoiQA(soapModel.getMaCauHoiQA());
        model.setMaNguoiTraLoi(soapModel.getMaNguoiTraLoi());
        model.setNoiDungTraLoi(soapModel.getNoiDungTraLoi());
        model.setCreatedate(soapModel.getCreatedate());
        model.setPublishdate(soapModel.getPublishdate());
        model.setPublish(soapModel.getPublish());
        model.setAnswerThroughWeb(soapModel.getAnswerThroughWeb());
        model.setAnswerThroughEmail(soapModel.getAnswerThroughEmail());

        return model;
    }

    public static List<CauTraLoiQA> toModels(CauTraLoiQASoap[] soapModels) {
        List<CauTraLoiQA> models = new ArrayList<CauTraLoiQA>(soapModels.length);

        for (CauTraLoiQASoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _maCauTraLoiQA;
    }

    public void setPrimaryKey(long pk) {
        setMaCauTraLoiQA(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_maCauTraLoiQA);
    }

    public long getMaCauTraLoiQA() {
        return _maCauTraLoiQA;
    }

    public void setMaCauTraLoiQA(long maCauTraLoiQA) {
        _maCauTraLoiQA = maCauTraLoiQA;
    }

    public long getMaCauHoiQA() {
        return _maCauHoiQA;
    }

    public void setMaCauHoiQA(long maCauHoiQA) {
        _maCauHoiQA = maCauHoiQA;
    }

    public long getMaNguoiTraLoi() {
        return _maNguoiTraLoi;
    }

    public void setMaNguoiTraLoi(long maNguoiTraLoi) {
        _maNguoiTraLoi = maNguoiTraLoi;
    }

    public String getNoiDungTraLoi() {
        return GetterUtil.getString(_noiDungTraLoi);
    }

    public void setNoiDungTraLoi(String noiDungTraLoi) {
        _noiDungTraLoi = noiDungTraLoi;
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

    public boolean getAnswerThroughWeb() {
        return _answerThroughWeb;
    }

    public boolean isAnswerThroughWeb() {
        return _answerThroughWeb;
    }

    public void setAnswerThroughWeb(boolean answerThroughWeb) {
        _answerThroughWeb = answerThroughWeb;
    }

    public String getAnswerThroughEmail() {
        return GetterUtil.getString(_answerThroughEmail);
    }

    public void setAnswerThroughEmail(String answerThroughEmail) {
        _answerThroughEmail = answerThroughEmail;
    }

    public CauTraLoiQA toEscapedModel() {
        if (isEscapedModel()) {
            return (CauTraLoiQA) this;
        } else {
            CauTraLoiQA model = new CauTraLoiQAImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMaCauTraLoiQA(getMaCauTraLoiQA());
            model.setMaCauHoiQA(getMaCauHoiQA());
            model.setMaNguoiTraLoi(getMaNguoiTraLoi());
            model.setNoiDungTraLoi(HtmlUtil.escape(getNoiDungTraLoi()));
            model.setCreatedate(getCreatedate());
            model.setPublishdate(getPublishdate());
            model.setPublish(getPublish());
            model.setAnswerThroughWeb(getAnswerThroughWeb());
            model.setAnswerThroughEmail(HtmlUtil.escape(getAnswerThroughEmail()));

            model = (CauTraLoiQA) Proxy.newProxyInstance(CauTraLoiQA.class.getClassLoader(),
                    new Class[] { CauTraLoiQA.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(CauTraLoiQA.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        CauTraLoiQAImpl clone = new CauTraLoiQAImpl();

        clone.setMaCauTraLoiQA(getMaCauTraLoiQA());
        clone.setMaCauHoiQA(getMaCauHoiQA());
        clone.setMaNguoiTraLoi(getMaNguoiTraLoi());
        clone.setNoiDungTraLoi(getNoiDungTraLoi());
        clone.setCreatedate(getCreatedate());
        clone.setPublishdate(getPublishdate());
        clone.setPublish(getPublish());
        clone.setAnswerThroughWeb(getAnswerThroughWeb());
        clone.setAnswerThroughEmail(getAnswerThroughEmail());

        return clone;
    }

    public int compareTo(CauTraLoiQA cauTraLoiQA) {
        long pk = cauTraLoiQA.getPrimaryKey();

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

        CauTraLoiQA cauTraLoiQA = null;

        try {
            cauTraLoiQA = (CauTraLoiQA) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = cauTraLoiQA.getPrimaryKey();

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

        sb.append("{maCauTraLoiQA=");
        sb.append(getMaCauTraLoiQA());
        sb.append(", maCauHoiQA=");
        sb.append(getMaCauHoiQA());
        sb.append(", maNguoiTraLoi=");
        sb.append(getMaNguoiTraLoi());
        sb.append(", noiDungTraLoi=");
        sb.append(getNoiDungTraLoi());
        sb.append(", createdate=");
        sb.append(getCreatedate());
        sb.append(", publishdate=");
        sb.append(getPublishdate());
        sb.append(", publish=");
        sb.append(getPublish());
        sb.append(", answerThroughWeb=");
        sb.append(getAnswerThroughWeb());
        sb.append(", answerThroughEmail=");
        sb.append(getAnswerThroughEmail());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>maCauTraLoiQA</column-name><column-value><![CDATA[");
        sb.append(getMaCauTraLoiQA());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maCauHoiQA</column-name><column-value><![CDATA[");
        sb.append(getMaCauHoiQA());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maNguoiTraLoi</column-name><column-value><![CDATA[");
        sb.append(getMaNguoiTraLoi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>noiDungTraLoi</column-name><column-value><![CDATA[");
        sb.append(getNoiDungTraLoi());
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
        sb.append(
            "<column><column-name>answerThroughWeb</column-name><column-value><![CDATA[");
        sb.append(getAnswerThroughWeb());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>answerThroughEmail</column-name><column-value><![CDATA[");
        sb.append(getAnswerThroughEmail());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
