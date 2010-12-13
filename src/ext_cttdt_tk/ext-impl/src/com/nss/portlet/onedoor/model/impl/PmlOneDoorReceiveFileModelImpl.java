package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFileSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlOneDoorReceiveFileModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlOneDoorReceiveFile</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile
 * @see com.nss.portlet.onedoor.model.PmlOneDoorReceiveFileModel
 * @see com.nss.portlet.onedoor.model.impl.PmlOneDoorReceiveFileImpl
 *
 */
public class PmlOneDoorReceiveFileModelImpl extends BaseModelImpl<PmlOneDoorReceiveFile> {
    public static final String TABLE_NAME = "pml_file";
    public static final Object[][] TABLE_COLUMNS = {
            { "fileId", new Integer(Types.VARCHAR) },
            

            { "cityId", new Integer(Types.VARCHAR) },
            

            { "districtId", new Integer(Types.VARCHAR) },
            

            { "wardsId", new Integer(Types.VARCHAR) },
            

            { "streetId", new Integer(Types.VARCHAR) },
            

            { "exactReturningDate", new Integer(Types.TIMESTAMP) },
            

            { "receiverId", new Integer(Types.BIGINT) },
            

            { "validDate", new Integer(Types.TIMESTAMP) },
            

            { "expectedReturningDate", new Integer(Types.TIMESTAMP) },
            

            { "applicationDate", new Integer(Types.TIMESTAMP) },
            

            { "otherContent", new Integer(Types.VARCHAR) },
            

            { "briefContent", new Integer(Types.VARCHAR) },
            

            { "applicantName", new Integer(Types.VARCHAR) },
            

            { "organization", new Integer(Types.VARCHAR) },
            

            { "authorisedLetter", new Integer(Types.VARCHAR) },
            

            { "idNumber", new Integer(Types.VARCHAR) },
            

            { "issuingDate", new Integer(Types.TIMESTAMP) },
            

            { "issuingPlace", new Integer(Types.VARCHAR) },
            

            { "telephone", new Integer(Types.VARCHAR) },
            

            { "gender", new Integer(Types.VARCHAR) },
            

            { "streetNumber", new Integer(Types.VARCHAR) },
            

            { "permanentAddress", new Integer(Types.VARCHAR) },
            

            { "contactInfomation", new Integer(Types.VARCHAR) },
            

            { "oldNumberReceipt", new Integer(Types.VARCHAR) },
            

            { "numberReceipt", new Integer(Types.VARCHAR) },
            

            { "fileTypeId", new Integer(Types.VARCHAR) },
            

            { "fieldId", new Integer(Types.VARCHAR) },
            

            { "solvingTime", new Integer(Types.INTEGER) },
            

            { "amendedContent", new Integer(Types.VARCHAR) },
            

            { "landCheckingDate", new Integer(Types.TIMESTAMP) },
            

            { "decisionNotice", new Integer(Types.VARCHAR) },
            

            { "receiver", new Integer(Types.VARCHAR) },
            

            { "dateCreated", new Integer(Types.TIMESTAMP) },
            

            { "lastUpdate", new Integer(Types.TIMESTAMP) },
            

            { "lasttestprocessinfo", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "generalorderno", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_file (fileId VARCHAR(75) not null primary key,cityId VARCHAR(75) null,districtId VARCHAR(75) null,wardsId VARCHAR(75) null,streetId VARCHAR(75) null,exactReturningDate DATE null,receiverId LONG,validDate DATE null,expectedReturningDate DATE null,applicationDate DATE null,otherContent VARCHAR(75) null,briefContent VARCHAR(75) null,applicantName VARCHAR(75) null,organization VARCHAR(75) null,authorisedLetter VARCHAR(75) null,idNumber VARCHAR(75) null,issuingDate DATE null,issuingPlace VARCHAR(75) null,telephone VARCHAR(75) null,gender VARCHAR(75) null,streetNumber VARCHAR(75) null,permanentAddress VARCHAR(75) null,contactInfomation VARCHAR(75) null,oldNumberReceipt VARCHAR(75) null,numberReceipt VARCHAR(75) null,fileTypeId VARCHAR(75) null,fieldId VARCHAR(75) null,solvingTime INTEGER,amendedContent VARCHAR(75) null,landCheckingDate DATE null,decisionNotice VARCHAR(75) null,receiver VARCHAR(75) null,dateCreated DATE null,lastUpdate DATE null,lasttestprocessinfo VARCHAR(75) null,active VARCHAR(75) null,generalorderno LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_file";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile"));
    private String _fileId;
    private String _cityId;
    private String _districtId;
    private String _wardsId;
    private String _streetId;
    private Date _exactReturningDate;
    private long _receiverId;
    private Date _validDate;
    private Date _expectedReturningDate;
    private Date _applicationDate;
    private String _otherContent;
    private String _briefContent;
    private String _applicantName;
    private String _organization;
    private String _authorisedLetter;
    private String _idNumber;
    private Date _issuingDate;
    private String _issuingPlace;
    private String _telephone;
    private String _gender;
    private String _streetNumber;
    private String _permanentAddress;
    private String _contactInfomation;
    private String _oldNumberReceipt;
    private String _numberReceipt;
    private String _fileTypeId;
    private String _fieldId;
    private int _solvingTime;
    private String _amendedContent;
    private Date _landCheckingDate;
    private String _decisionNotice;
    private String _receiver;
    private Date _dateCreated;
    private Date _lastUpdate;
    private String _lastTestProcessInfo;
    private String _active;
    private long _generalorderno;

    public PmlOneDoorReceiveFileModelImpl() {
    }

    public static PmlOneDoorReceiveFile toModel(
        PmlOneDoorReceiveFileSoap soapModel) {
        PmlOneDoorReceiveFile model = new PmlOneDoorReceiveFileImpl();

        model.setFileId(soapModel.getFileId());
        model.setCityId(soapModel.getCityId());
        model.setDistrictId(soapModel.getDistrictId());
        model.setWardsId(soapModel.getWardsId());
        model.setStreetId(soapModel.getStreetId());
        model.setExactReturningDate(soapModel.getExactReturningDate());
        model.setReceiverId(soapModel.getReceiverId());
        model.setValidDate(soapModel.getValidDate());
        model.setExpectedReturningDate(soapModel.getExpectedReturningDate());
        model.setApplicationDate(soapModel.getApplicationDate());
        model.setOtherContent(soapModel.getOtherContent());
        model.setBriefContent(soapModel.getBriefContent());
        model.setApplicantName(soapModel.getApplicantName());
        model.setOrganization(soapModel.getOrganization());
        model.setAuthorisedLetter(soapModel.getAuthorisedLetter());
        model.setIdNumber(soapModel.getIdNumber());
        model.setIssuingDate(soapModel.getIssuingDate());
        model.setIssuingPlace(soapModel.getIssuingPlace());
        model.setTelephone(soapModel.getTelephone());
        model.setGender(soapModel.getGender());
        model.setStreetNumber(soapModel.getStreetNumber());
        model.setPermanentAddress(soapModel.getPermanentAddress());
        model.setContactInfomation(soapModel.getContactInfomation());
        model.setOldNumberReceipt(soapModel.getOldNumberReceipt());
        model.setNumberReceipt(soapModel.getNumberReceipt());
        model.setFileTypeId(soapModel.getFileTypeId());
        model.setFieldId(soapModel.getFieldId());
        model.setSolvingTime(soapModel.getSolvingTime());
        model.setAmendedContent(soapModel.getAmendedContent());
        model.setLandCheckingDate(soapModel.getLandCheckingDate());
        model.setDecisionNotice(soapModel.getDecisionNotice());
        model.setReceiver(soapModel.getReceiver());
        model.setDateCreated(soapModel.getDateCreated());
        model.setLastUpdate(soapModel.getLastUpdate());
        model.setLastTestProcessInfo(soapModel.getLastTestProcessInfo());
        model.setActive(soapModel.getActive());
        model.setGeneralorderno(soapModel.getGeneralorderno());

        return model;
    }

    public static List<PmlOneDoorReceiveFile> toModels(
        PmlOneDoorReceiveFileSoap[] soapModels) {
        List<PmlOneDoorReceiveFile> models = new ArrayList<PmlOneDoorReceiveFile>(soapModels.length);

        for (PmlOneDoorReceiveFileSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _fileId;
    }

    public void setPrimaryKey(String pk) {
        setFileId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _fileId;
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public String getCityId() {
        return GetterUtil.getString(_cityId);
    }

    public void setCityId(String cityId) {
        _cityId = cityId;
    }

    public String getDistrictId() {
        return GetterUtil.getString(_districtId);
    }

    public void setDistrictId(String districtId) {
        _districtId = districtId;
    }

    public String getWardsId() {
        return GetterUtil.getString(_wardsId);
    }

    public void setWardsId(String wardsId) {
        _wardsId = wardsId;
    }

    public String getStreetId() {
        return GetterUtil.getString(_streetId);
    }

    public void setStreetId(String streetId) {
        _streetId = streetId;
    }

    public Date getExactReturningDate() {
        return _exactReturningDate;
    }

    public void setExactReturningDate(Date exactReturningDate) {
        _exactReturningDate = exactReturningDate;
    }

    public long getReceiverId() {
        return _receiverId;
    }

    public void setReceiverId(long receiverId) {
        _receiverId = receiverId;
    }

    public Date getValidDate() {
        return _validDate;
    }

    public void setValidDate(Date validDate) {
        _validDate = validDate;
    }

    public Date getExpectedReturningDate() {
        return _expectedReturningDate;
    }

    public void setExpectedReturningDate(Date expectedReturningDate) {
        _expectedReturningDate = expectedReturningDate;
    }

    public Date getApplicationDate() {
        return _applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        _applicationDate = applicationDate;
    }

    public String getOtherContent() {
        return GetterUtil.getString(_otherContent);
    }

    public void setOtherContent(String otherContent) {
        _otherContent = otherContent;
    }

    public String getBriefContent() {
        return GetterUtil.getString(_briefContent);
    }

    public void setBriefContent(String briefContent) {
        _briefContent = briefContent;
    }

    public String getApplicantName() {
        return GetterUtil.getString(_applicantName);
    }

    public void setApplicantName(String applicantName) {
        _applicantName = applicantName;
    }

    public String getOrganization() {
        return GetterUtil.getString(_organization);
    }

    public void setOrganization(String organization) {
        _organization = organization;
    }

    public String getAuthorisedLetter() {
        return GetterUtil.getString(_authorisedLetter);
    }

    public void setAuthorisedLetter(String authorisedLetter) {
        _authorisedLetter = authorisedLetter;
    }

    public String getIdNumber() {
        return GetterUtil.getString(_idNumber);
    }

    public void setIdNumber(String idNumber) {
        _idNumber = idNumber;
    }

    public Date getIssuingDate() {
        return _issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        _issuingDate = issuingDate;
    }

    public String getIssuingPlace() {
        return GetterUtil.getString(_issuingPlace);
    }

    public void setIssuingPlace(String issuingPlace) {
        _issuingPlace = issuingPlace;
    }

    public String getTelephone() {
        return GetterUtil.getString(_telephone);
    }

    public void setTelephone(String telephone) {
        _telephone = telephone;
    }

    public String getGender() {
        return GetterUtil.getString(_gender);
    }

    public void setGender(String gender) {
        _gender = gender;
    }

    public String getStreetNumber() {
        return GetterUtil.getString(_streetNumber);
    }

    public void setStreetNumber(String streetNumber) {
        _streetNumber = streetNumber;
    }

    public String getPermanentAddress() {
        return GetterUtil.getString(_permanentAddress);
    }

    public void setPermanentAddress(String permanentAddress) {
        _permanentAddress = permanentAddress;
    }

    public String getContactInfomation() {
        return GetterUtil.getString(_contactInfomation);
    }

    public void setContactInfomation(String contactInfomation) {
        _contactInfomation = contactInfomation;
    }

    public String getOldNumberReceipt() {
        return GetterUtil.getString(_oldNumberReceipt);
    }

    public void setOldNumberReceipt(String oldNumberReceipt) {
        _oldNumberReceipt = oldNumberReceipt;
    }

    public String getNumberReceipt() {
        return GetterUtil.getString(_numberReceipt);
    }

    public void setNumberReceipt(String numberReceipt) {
        _numberReceipt = numberReceipt;
    }

    public String getFileTypeId() {
        return GetterUtil.getString(_fileTypeId);
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public String getFieldId() {
        return GetterUtil.getString(_fieldId);
    }

    public void setFieldId(String fieldId) {
        _fieldId = fieldId;
    }

    public int getSolvingTime() {
        return _solvingTime;
    }

    public void setSolvingTime(int solvingTime) {
        _solvingTime = solvingTime;
    }

    public String getAmendedContent() {
        return GetterUtil.getString(_amendedContent);
    }

    public void setAmendedContent(String amendedContent) {
        _amendedContent = amendedContent;
    }

    public Date getLandCheckingDate() {
        return _landCheckingDate;
    }

    public void setLandCheckingDate(Date landCheckingDate) {
        _landCheckingDate = landCheckingDate;
    }

    public String getDecisionNotice() {
        return GetterUtil.getString(_decisionNotice);
    }

    public void setDecisionNotice(String decisionNotice) {
        _decisionNotice = decisionNotice;
    }

    public String getReceiver() {
        return GetterUtil.getString(_receiver);
    }

    public void setReceiver(String receiver) {
        _receiver = receiver;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
    }

    public Date getLastUpdate() {
        return _lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        _lastUpdate = lastUpdate;
    }

    public String getLastTestProcessInfo() {
        return GetterUtil.getString(_lastTestProcessInfo);
    }

    public void setLastTestProcessInfo(String lastTestProcessInfo) {
        _lastTestProcessInfo = lastTestProcessInfo;
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        _active = active;
    }

    public long getGeneralorderno() {
        return _generalorderno;
    }

    public void setGeneralorderno(long generalorderno) {
        _generalorderno = generalorderno;
    }

    public PmlOneDoorReceiveFile toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlOneDoorReceiveFile) this;
        } else {
            PmlOneDoorReceiveFile model = new PmlOneDoorReceiveFileImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileId(HtmlUtil.escape(getFileId()));
            model.setCityId(HtmlUtil.escape(getCityId()));
            model.setDistrictId(HtmlUtil.escape(getDistrictId()));
            model.setWardsId(HtmlUtil.escape(getWardsId()));
            model.setStreetId(HtmlUtil.escape(getStreetId()));
            model.setExactReturningDate(getExactReturningDate());
            model.setReceiverId(getReceiverId());
            model.setValidDate(getValidDate());
            model.setExpectedReturningDate(getExpectedReturningDate());
            model.setApplicationDate(getApplicationDate());
            model.setOtherContent(HtmlUtil.escape(getOtherContent()));
            model.setBriefContent(HtmlUtil.escape(getBriefContent()));
            model.setApplicantName(HtmlUtil.escape(getApplicantName()));
            model.setOrganization(HtmlUtil.escape(getOrganization()));
            model.setAuthorisedLetter(HtmlUtil.escape(getAuthorisedLetter()));
            model.setIdNumber(HtmlUtil.escape(getIdNumber()));
            model.setIssuingDate(getIssuingDate());
            model.setIssuingPlace(HtmlUtil.escape(getIssuingPlace()));
            model.setTelephone(HtmlUtil.escape(getTelephone()));
            model.setGender(HtmlUtil.escape(getGender()));
            model.setStreetNumber(HtmlUtil.escape(getStreetNumber()));
            model.setPermanentAddress(HtmlUtil.escape(getPermanentAddress()));
            model.setContactInfomation(HtmlUtil.escape(getContactInfomation()));
            model.setOldNumberReceipt(HtmlUtil.escape(getOldNumberReceipt()));
            model.setNumberReceipt(HtmlUtil.escape(getNumberReceipt()));
            model.setFileTypeId(HtmlUtil.escape(getFileTypeId()));
            model.setFieldId(HtmlUtil.escape(getFieldId()));
            model.setSolvingTime(getSolvingTime());
            model.setAmendedContent(HtmlUtil.escape(getAmendedContent()));
            model.setLandCheckingDate(getLandCheckingDate());
            model.setDecisionNotice(HtmlUtil.escape(getDecisionNotice()));
            model.setReceiver(HtmlUtil.escape(getReceiver()));
            model.setDateCreated(getDateCreated());
            model.setLastUpdate(getLastUpdate());
            model.setLastTestProcessInfo(HtmlUtil.escape(
                    getLastTestProcessInfo()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setGeneralorderno(getGeneralorderno());

            model = (PmlOneDoorReceiveFile) Proxy.newProxyInstance(PmlOneDoorReceiveFile.class.getClassLoader(),
                    new Class[] { PmlOneDoorReceiveFile.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlOneDoorReceiveFileImpl clone = new PmlOneDoorReceiveFileImpl();

        clone.setFileId(getFileId());
        clone.setCityId(getCityId());
        clone.setDistrictId(getDistrictId());
        clone.setWardsId(getWardsId());
        clone.setStreetId(getStreetId());
        clone.setExactReturningDate(getExactReturningDate());
        clone.setReceiverId(getReceiverId());
        clone.setValidDate(getValidDate());
        clone.setExpectedReturningDate(getExpectedReturningDate());
        clone.setApplicationDate(getApplicationDate());
        clone.setOtherContent(getOtherContent());
        clone.setBriefContent(getBriefContent());
        clone.setApplicantName(getApplicantName());
        clone.setOrganization(getOrganization());
        clone.setAuthorisedLetter(getAuthorisedLetter());
        clone.setIdNumber(getIdNumber());
        clone.setIssuingDate(getIssuingDate());
        clone.setIssuingPlace(getIssuingPlace());
        clone.setTelephone(getTelephone());
        clone.setGender(getGender());
        clone.setStreetNumber(getStreetNumber());
        clone.setPermanentAddress(getPermanentAddress());
        clone.setContactInfomation(getContactInfomation());
        clone.setOldNumberReceipt(getOldNumberReceipt());
        clone.setNumberReceipt(getNumberReceipt());
        clone.setFileTypeId(getFileTypeId());
        clone.setFieldId(getFieldId());
        clone.setSolvingTime(getSolvingTime());
        clone.setAmendedContent(getAmendedContent());
        clone.setLandCheckingDate(getLandCheckingDate());
        clone.setDecisionNotice(getDecisionNotice());
        clone.setReceiver(getReceiver());
        clone.setDateCreated(getDateCreated());
        clone.setLastUpdate(getLastUpdate());
        clone.setLastTestProcessInfo(getLastTestProcessInfo());
        clone.setActive(getActive());
        clone.setGeneralorderno(getGeneralorderno());

        return clone;
    }

    public int compareTo(PmlOneDoorReceiveFile pmlOneDoorReceiveFile) {
        int value = 0;

        if (getGeneralorderno() < pmlOneDoorReceiveFile.getGeneralorderno()) {
            value = -1;
        } else if (getGeneralorderno() > pmlOneDoorReceiveFile.getGeneralorderno()) {
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

        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = null;

        try {
            pmlOneDoorReceiveFile = (PmlOneDoorReceiveFile) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlOneDoorReceiveFile.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{fileId=");
        sb.append(getFileId());
        sb.append(", cityId=");
        sb.append(getCityId());
        sb.append(", districtId=");
        sb.append(getDistrictId());
        sb.append(", wardsId=");
        sb.append(getWardsId());
        sb.append(", streetId=");
        sb.append(getStreetId());
        sb.append(", exactReturningDate=");
        sb.append(getExactReturningDate());
        sb.append(", receiverId=");
        sb.append(getReceiverId());
        sb.append(", validDate=");
        sb.append(getValidDate());
        sb.append(", expectedReturningDate=");
        sb.append(getExpectedReturningDate());
        sb.append(", applicationDate=");
        sb.append(getApplicationDate());
        sb.append(", otherContent=");
        sb.append(getOtherContent());
        sb.append(", briefContent=");
        sb.append(getBriefContent());
        sb.append(", applicantName=");
        sb.append(getApplicantName());
        sb.append(", organization=");
        sb.append(getOrganization());
        sb.append(", authorisedLetter=");
        sb.append(getAuthorisedLetter());
        sb.append(", idNumber=");
        sb.append(getIdNumber());
        sb.append(", issuingDate=");
        sb.append(getIssuingDate());
        sb.append(", issuingPlace=");
        sb.append(getIssuingPlace());
        sb.append(", telephone=");
        sb.append(getTelephone());
        sb.append(", gender=");
        sb.append(getGender());
        sb.append(", streetNumber=");
        sb.append(getStreetNumber());
        sb.append(", permanentAddress=");
        sb.append(getPermanentAddress());
        sb.append(", contactInfomation=");
        sb.append(getContactInfomation());
        sb.append(", oldNumberReceipt=");
        sb.append(getOldNumberReceipt());
        sb.append(", numberReceipt=");
        sb.append(getNumberReceipt());
        sb.append(", fileTypeId=");
        sb.append(getFileTypeId());
        sb.append(", fieldId=");
        sb.append(getFieldId());
        sb.append(", solvingTime=");
        sb.append(getSolvingTime());
        sb.append(", amendedContent=");
        sb.append(getAmendedContent());
        sb.append(", landCheckingDate=");
        sb.append(getLandCheckingDate());
        sb.append(", decisionNotice=");
        sb.append(getDecisionNotice());
        sb.append(", receiver=");
        sb.append(getReceiver());
        sb.append(", dateCreated=");
        sb.append(getDateCreated());
        sb.append(", lastUpdate=");
        sb.append(getLastUpdate());
        sb.append(", lastTestProcessInfo=");
        sb.append(getLastTestProcessInfo());
        sb.append(", active=");
        sb.append(getActive());
        sb.append(", generalorderno=");
        sb.append(getGeneralorderno());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fileId</column-name><column-value><![CDATA[");
        sb.append(getFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cityId</column-name><column-value><![CDATA[");
        sb.append(getCityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>districtId</column-name><column-value><![CDATA[");
        sb.append(getDistrictId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>wardsId</column-name><column-value><![CDATA[");
        sb.append(getWardsId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>streetId</column-name><column-value><![CDATA[");
        sb.append(getStreetId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>exactReturningDate</column-name><column-value><![CDATA[");
        sb.append(getExactReturningDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiverId</column-name><column-value><![CDATA[");
        sb.append(getReceiverId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>validDate</column-name><column-value><![CDATA[");
        sb.append(getValidDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>expectedReturningDate</column-name><column-value><![CDATA[");
        sb.append(getExpectedReturningDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicationDate</column-name><column-value><![CDATA[");
        sb.append(getApplicationDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>otherContent</column-name><column-value><![CDATA[");
        sb.append(getOtherContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>briefContent</column-name><column-value><![CDATA[");
        sb.append(getBriefContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicantName</column-name><column-value><![CDATA[");
        sb.append(getApplicantName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>organization</column-name><column-value><![CDATA[");
        sb.append(getOrganization());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorisedLetter</column-name><column-value><![CDATA[");
        sb.append(getAuthorisedLetter());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>idNumber</column-name><column-value><![CDATA[");
        sb.append(getIdNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>issuingDate</column-name><column-value><![CDATA[");
        sb.append(getIssuingDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>issuingPlace</column-name><column-value><![CDATA[");
        sb.append(getIssuingPlace());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>telephone</column-name><column-value><![CDATA[");
        sb.append(getTelephone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>gender</column-name><column-value><![CDATA[");
        sb.append(getGender());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>streetNumber</column-name><column-value><![CDATA[");
        sb.append(getStreetNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>permanentAddress</column-name><column-value><![CDATA[");
        sb.append(getPermanentAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactInfomation</column-name><column-value><![CDATA[");
        sb.append(getContactInfomation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>oldNumberReceipt</column-name><column-value><![CDATA[");
        sb.append(getOldNumberReceipt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>numberReceipt</column-name><column-value><![CDATA[");
        sb.append(getNumberReceipt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileTypeId</column-name><column-value><![CDATA[");
        sb.append(getFileTypeId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fieldId</column-name><column-value><![CDATA[");
        sb.append(getFieldId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>solvingTime</column-name><column-value><![CDATA[");
        sb.append(getSolvingTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>amendedContent</column-name><column-value><![CDATA[");
        sb.append(getAmendedContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>landCheckingDate</column-name><column-value><![CDATA[");
        sb.append(getLandCheckingDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>decisionNotice</column-name><column-value><![CDATA[");
        sb.append(getDecisionNotice());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiver</column-name><column-value><![CDATA[");
        sb.append(getReceiver());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateCreated</column-name><column-value><![CDATA[");
        sb.append(getDateCreated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastUpdate</column-name><column-value><![CDATA[");
        sb.append(getLastUpdate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastTestProcessInfo</column-name><column-value><![CDATA[");
        sb.append(getLastTestProcessInfo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>generalorderno</column-name><column-value><![CDATA[");
        sb.append(getGeneralorderno());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
