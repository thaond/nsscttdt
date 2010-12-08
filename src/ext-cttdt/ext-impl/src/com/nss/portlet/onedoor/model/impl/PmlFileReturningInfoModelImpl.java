package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.onedoor.model.PmlFileReturningInfo;
import com.nss.portlet.onedoor.model.PmlFileReturningInfoSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFileReturningInfoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFileReturningInfo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlFileReturningInfo
 * @see com.nss.portlet.onedoor.model.PmlFileReturningInfoModel
 * @see com.nss.portlet.onedoor.model.impl.PmlFileReturningInfoImpl
 *
 */
public class PmlFileReturningInfoModelImpl extends BaseModelImpl<PmlFileReturningInfo> {
    public static final String TABLE_NAME = "pml_filereturninginfo";
    public static final Object[][] TABLE_COLUMNS = {
            { "filereturninginfoid", new Integer(Types.BIGINT) },
            

            { "fileid", new Integer(Types.VARCHAR) },
            

            { "filesender", new Integer(Types.VARCHAR) },
            

            { "licensenumber", new Integer(Types.VARCHAR) },
            

            { "issuingdatelicense", new Integer(Types.TIMESTAMP) },
            

            { "receivelicensedate", new Integer(Types.TIMESTAMP) },
            

            { "documentnumber", new Integer(Types.VARCHAR) },
            

            { "billnumber", new Integer(Types.VARCHAR) },
            

            { "numbermoney", new Integer(Types.BIGINT) },
            

            { "note", new Integer(Types.VARCHAR) },
            

            { "conclude", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_filereturninginfo (filereturninginfoid LONG not null primary key,fileid VARCHAR(75) null,filesender VARCHAR(75) null,licensenumber VARCHAR(75) null,issuingdatelicense DATE null,receivelicensedate DATE null,documentnumber VARCHAR(75) null,billnumber VARCHAR(75) null,numbermoney LONG,note VARCHAR(75) null,conclude VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_filereturninginfo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlFileReturningInfo"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlFileReturningInfo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlFileReturningInfo"));
    private long _fileReturningInfoId;
    private long _originalFileReturningInfoId;
    private boolean _setOriginalFileReturningInfoId;
    private String _fileId;
    private String _originalFileId;
    private String _fileSender;
    private String _licenseNumber;
    private Date _issuingDateLicense;
    private Date _receiveLicenseDate;
    private String _documentNumber;
    private String _billNumber;
    private long _numberMoney;
    private String _note;
    private String _conclude;
    private transient ExpandoBridge _expandoBridge;

    public PmlFileReturningInfoModelImpl() {
    }

    public static PmlFileReturningInfo toModel(
        PmlFileReturningInfoSoap soapModel) {
        PmlFileReturningInfo model = new PmlFileReturningInfoImpl();

        model.setFileReturningInfoId(soapModel.getFileReturningInfoId());
        model.setFileId(soapModel.getFileId());
        model.setFileSender(soapModel.getFileSender());
        model.setLicenseNumber(soapModel.getLicenseNumber());
        model.setIssuingDateLicense(soapModel.getIssuingDateLicense());
        model.setReceiveLicenseDate(soapModel.getReceiveLicenseDate());
        model.setDocumentNumber(soapModel.getDocumentNumber());
        model.setBillNumber(soapModel.getBillNumber());
        model.setNumberMoney(soapModel.getNumberMoney());
        model.setNote(soapModel.getNote());
        model.setConclude(soapModel.getConclude());

        return model;
    }

    public static List<PmlFileReturningInfo> toModels(
        PmlFileReturningInfoSoap[] soapModels) {
        List<PmlFileReturningInfo> models = new ArrayList<PmlFileReturningInfo>(soapModels.length);

        for (PmlFileReturningInfoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _fileReturningInfoId;
    }

    public void setPrimaryKey(long pk) {
        setFileReturningInfoId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_fileReturningInfoId);
    }

    public long getFileReturningInfoId() {
        return _fileReturningInfoId;
    }

    public void setFileReturningInfoId(long fileReturningInfoId) {
        _fileReturningInfoId = fileReturningInfoId;

        if (!_setOriginalFileReturningInfoId) {
            _setOriginalFileReturningInfoId = true;

            _originalFileReturningInfoId = fileReturningInfoId;
        }
    }

    public long getOriginalFileReturningInfoId() {
        return _originalFileReturningInfoId;
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        _fileId = fileId;

        if (_originalFileId == null) {
            _originalFileId = fileId;
        }
    }

    public String getOriginalFileId() {
        return GetterUtil.getString(_originalFileId);
    }

    public String getFileSender() {
        return GetterUtil.getString(_fileSender);
    }

    public void setFileSender(String fileSender) {
        _fileSender = fileSender;
    }

    public String getLicenseNumber() {
        return GetterUtil.getString(_licenseNumber);
    }

    public void setLicenseNumber(String licenseNumber) {
        _licenseNumber = licenseNumber;
    }

    public Date getIssuingDateLicense() {
        return _issuingDateLicense;
    }

    public void setIssuingDateLicense(Date issuingDateLicense) {
        _issuingDateLicense = issuingDateLicense;
    }

    public Date getReceiveLicenseDate() {
        return _receiveLicenseDate;
    }

    public void setReceiveLicenseDate(Date receiveLicenseDate) {
        _receiveLicenseDate = receiveLicenseDate;
    }

    public String getDocumentNumber() {
        return GetterUtil.getString(_documentNumber);
    }

    public void setDocumentNumber(String documentNumber) {
        _documentNumber = documentNumber;
    }

    public String getBillNumber() {
        return GetterUtil.getString(_billNumber);
    }

    public void setBillNumber(String billNumber) {
        _billNumber = billNumber;
    }

    public long getNumberMoney() {
        return _numberMoney;
    }

    public void setNumberMoney(long numberMoney) {
        _numberMoney = numberMoney;
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        _note = note;
    }

    public String getConclude() {
        return GetterUtil.getString(_conclude);
    }

    public void setConclude(String conclude) {
        _conclude = conclude;
    }

    public PmlFileReturningInfo toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFileReturningInfo) this;
        } else {
            PmlFileReturningInfo model = new PmlFileReturningInfoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileReturningInfoId(getFileReturningInfoId());
            model.setFileId(HtmlUtil.escape(getFileId()));
            model.setFileSender(HtmlUtil.escape(getFileSender()));
            model.setLicenseNumber(HtmlUtil.escape(getLicenseNumber()));
            model.setIssuingDateLicense(getIssuingDateLicense());
            model.setReceiveLicenseDate(getReceiveLicenseDate());
            model.setDocumentNumber(HtmlUtil.escape(getDocumentNumber()));
            model.setBillNumber(HtmlUtil.escape(getBillNumber()));
            model.setNumberMoney(getNumberMoney());
            model.setNote(HtmlUtil.escape(getNote()));
            model.setConclude(HtmlUtil.escape(getConclude()));

            model = (PmlFileReturningInfo) Proxy.newProxyInstance(PmlFileReturningInfo.class.getClassLoader(),
                    new Class[] { PmlFileReturningInfo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlFileReturningInfo.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PmlFileReturningInfoImpl clone = new PmlFileReturningInfoImpl();

        clone.setFileReturningInfoId(getFileReturningInfoId());
        clone.setFileId(getFileId());
        clone.setFileSender(getFileSender());
        clone.setLicenseNumber(getLicenseNumber());
        clone.setIssuingDateLicense(getIssuingDateLicense());
        clone.setReceiveLicenseDate(getReceiveLicenseDate());
        clone.setDocumentNumber(getDocumentNumber());
        clone.setBillNumber(getBillNumber());
        clone.setNumberMoney(getNumberMoney());
        clone.setNote(getNote());
        clone.setConclude(getConclude());

        return clone;
    }

    public int compareTo(PmlFileReturningInfo pmlFileReturningInfo) {
        int value = 0;

        if (getFileReturningInfoId() < pmlFileReturningInfo.getFileReturningInfoId()) {
            value = -1;
        } else if (getFileReturningInfoId() > pmlFileReturningInfo.getFileReturningInfoId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlFileReturningInfo pmlFileReturningInfo = null;

        try {
            pmlFileReturningInfo = (PmlFileReturningInfo) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlFileReturningInfo.getPrimaryKey();

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

        sb.append("{fileReturningInfoId=");
        sb.append(getFileReturningInfoId());
        sb.append(", fileId=");
        sb.append(getFileId());
        sb.append(", fileSender=");
        sb.append(getFileSender());
        sb.append(", licenseNumber=");
        sb.append(getLicenseNumber());
        sb.append(", issuingDateLicense=");
        sb.append(getIssuingDateLicense());
        sb.append(", receiveLicenseDate=");
        sb.append(getReceiveLicenseDate());
        sb.append(", documentNumber=");
        sb.append(getDocumentNumber());
        sb.append(", billNumber=");
        sb.append(getBillNumber());
        sb.append(", numberMoney=");
        sb.append(getNumberMoney());
        sb.append(", note=");
        sb.append(getNote());
        sb.append(", conclude=");
        sb.append(getConclude());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlFileReturningInfo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fileReturningInfoId</column-name><column-value><![CDATA[");
        sb.append(getFileReturningInfoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileId</column-name><column-value><![CDATA[");
        sb.append(getFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileSender</column-name><column-value><![CDATA[");
        sb.append(getFileSender());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>licenseNumber</column-name><column-value><![CDATA[");
        sb.append(getLicenseNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>issuingDateLicense</column-name><column-value><![CDATA[");
        sb.append(getIssuingDateLicense());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiveLicenseDate</column-name><column-value><![CDATA[");
        sb.append(getReceiveLicenseDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>documentNumber</column-name><column-value><![CDATA[");
        sb.append(getDocumentNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billNumber</column-name><column-value><![CDATA[");
        sb.append(getBillNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>numberMoney</column-name><column-value><![CDATA[");
        sb.append(getNumberMoney());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>note</column-name><column-value><![CDATA[");
        sb.append(getNote());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>conclude</column-name><column-value><![CDATA[");
        sb.append(getConclude());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
