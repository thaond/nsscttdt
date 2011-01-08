package com.sgs.portlet.onedoorpccc.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo;
import com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfoSoap;

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
 * @see com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo
 * @see com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfoModel
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlFileReturningInfoImpl
 *
 */
public class PmlFileReturningInfoModelImpl extends BaseModelImpl {
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
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo"));
    private long _fileReturningInfoId;
    private String _fileId;
    private String _fileSender;
    private String _licenseNumber;
    private Date _issuingDateLicense;
    private Date _receiveLicenseDate;
    private String _documentNumber;
    private String _billNumber;
    private long _numberMoney;
    private String _note;
    private String _conclude;

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
        if (fileReturningInfoId != _fileReturningInfoId) {
            _fileReturningInfoId = fileReturningInfoId;
        }
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        if (((fileId == null) && (_fileId != null)) ||
                ((fileId != null) && (_fileId == null)) ||
                ((fileId != null) && (_fileId != null) &&
                !fileId.equals(_fileId))) {
            _fileId = fileId;
        }
    }

    public String getFileSender() {
        return GetterUtil.getString(_fileSender);
    }

    public void setFileSender(String fileSender) {
        if (((fileSender == null) && (_fileSender != null)) ||
                ((fileSender != null) && (_fileSender == null)) ||
                ((fileSender != null) && (_fileSender != null) &&
                !fileSender.equals(_fileSender))) {
            _fileSender = fileSender;
        }
    }

    public String getLicenseNumber() {
        return GetterUtil.getString(_licenseNumber);
    }

    public void setLicenseNumber(String licenseNumber) {
        if (((licenseNumber == null) && (_licenseNumber != null)) ||
                ((licenseNumber != null) && (_licenseNumber == null)) ||
                ((licenseNumber != null) && (_licenseNumber != null) &&
                !licenseNumber.equals(_licenseNumber))) {
            _licenseNumber = licenseNumber;
        }
    }

    public Date getIssuingDateLicense() {
        return _issuingDateLicense;
    }

    public void setIssuingDateLicense(Date issuingDateLicense) {
        if (((issuingDateLicense == null) && (_issuingDateLicense != null)) ||
                ((issuingDateLicense != null) && (_issuingDateLicense == null)) ||
                ((issuingDateLicense != null) && (_issuingDateLicense != null) &&
                !issuingDateLicense.equals(_issuingDateLicense))) {
            _issuingDateLicense = issuingDateLicense;
        }
    }

    public Date getReceiveLicenseDate() {
        return _receiveLicenseDate;
    }

    public void setReceiveLicenseDate(Date receiveLicenseDate) {
        if (((receiveLicenseDate == null) && (_receiveLicenseDate != null)) ||
                ((receiveLicenseDate != null) && (_receiveLicenseDate == null)) ||
                ((receiveLicenseDate != null) && (_receiveLicenseDate != null) &&
                !receiveLicenseDate.equals(_receiveLicenseDate))) {
            _receiveLicenseDate = receiveLicenseDate;
        }
    }

    public String getDocumentNumber() {
        return GetterUtil.getString(_documentNumber);
    }

    public void setDocumentNumber(String documentNumber) {
        if (((documentNumber == null) && (_documentNumber != null)) ||
                ((documentNumber != null) && (_documentNumber == null)) ||
                ((documentNumber != null) && (_documentNumber != null) &&
                !documentNumber.equals(_documentNumber))) {
            _documentNumber = documentNumber;
        }
    }

    public String getBillNumber() {
        return GetterUtil.getString(_billNumber);
    }

    public void setBillNumber(String billNumber) {
        if (((billNumber == null) && (_billNumber != null)) ||
                ((billNumber != null) && (_billNumber == null)) ||
                ((billNumber != null) && (_billNumber != null) &&
                !billNumber.equals(_billNumber))) {
            _billNumber = billNumber;
        }
    }

    public long getNumberMoney() {
        return _numberMoney;
    }

    public void setNumberMoney(long numberMoney) {
        if (numberMoney != _numberMoney) {
            _numberMoney = numberMoney;
        }
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        if (((note == null) && (_note != null)) ||
                ((note != null) && (_note == null)) ||
                ((note != null) && (_note != null) && !note.equals(_note))) {
            _note = note;
        }
    }

    public String getConclude() {
        return GetterUtil.getString(_conclude);
    }

    public void setConclude(String conclude) {
        if (((conclude == null) && (_conclude != null)) ||
                ((conclude != null) && (_conclude == null)) ||
                ((conclude != null) && (_conclude != null) &&
                !conclude.equals(_conclude))) {
            _conclude = conclude;
        }
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

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFileReturningInfoImpl pmlFileReturningInfo = (PmlFileReturningInfoImpl) obj;

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

        PmlFileReturningInfoImpl pmlFileReturningInfo = null;

        try {
            pmlFileReturningInfo = (PmlFileReturningInfoImpl) obj;
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
}
