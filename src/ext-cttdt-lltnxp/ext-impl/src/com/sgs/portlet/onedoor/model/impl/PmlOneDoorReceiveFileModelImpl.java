package com.sgs.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFileSoap;

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
 * @see com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile
 * @see com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFileModel
 * @see com.sgs.portlet.onedoor.model.impl.PmlOneDoorReceiveFileImpl
 *
 */
public class PmlOneDoorReceiveFileModelImpl extends BaseModelImpl {
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
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile"));
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
        if (((fileId == null) && (_fileId != null)) ||
                ((fileId != null) && (_fileId == null)) ||
                ((fileId != null) && (_fileId != null) &&
                !fileId.equals(_fileId))) {
            _fileId = fileId;
        }
    }

    public String getCityId() {
        return GetterUtil.getString(_cityId);
    }

    public void setCityId(String cityId) {
        if (((cityId == null) && (_cityId != null)) ||
                ((cityId != null) && (_cityId == null)) ||
                ((cityId != null) && (_cityId != null) &&
                !cityId.equals(_cityId))) {
            _cityId = cityId;
        }
    }

    public String getDistrictId() {
        return GetterUtil.getString(_districtId);
    }

    public void setDistrictId(String districtId) {
        if (((districtId == null) && (_districtId != null)) ||
                ((districtId != null) && (_districtId == null)) ||
                ((districtId != null) && (_districtId != null) &&
                !districtId.equals(_districtId))) {
            _districtId = districtId;
        }
    }

    public String getWardsId() {
        return GetterUtil.getString(_wardsId);
    }

    public void setWardsId(String wardsId) {
        if (((wardsId == null) && (_wardsId != null)) ||
                ((wardsId != null) && (_wardsId == null)) ||
                ((wardsId != null) && (_wardsId != null) &&
                !wardsId.equals(_wardsId))) {
            _wardsId = wardsId;
        }
    }

    public String getStreetId() {
        return GetterUtil.getString(_streetId);
    }

    public void setStreetId(String streetId) {
        if (((streetId == null) && (_streetId != null)) ||
                ((streetId != null) && (_streetId == null)) ||
                ((streetId != null) && (_streetId != null) &&
                !streetId.equals(_streetId))) {
            _streetId = streetId;
        }
    }

    public Date getExactReturningDate() {
        return _exactReturningDate;
    }

    public void setExactReturningDate(Date exactReturningDate) {
        if (((exactReturningDate == null) && (_exactReturningDate != null)) ||
                ((exactReturningDate != null) && (_exactReturningDate == null)) ||
                ((exactReturningDate != null) && (_exactReturningDate != null) &&
                !exactReturningDate.equals(_exactReturningDate))) {
            _exactReturningDate = exactReturningDate;
        }
    }

    public long getReceiverId() {
        return _receiverId;
    }

    public void setReceiverId(long receiverId) {
        if (receiverId != _receiverId) {
            _receiverId = receiverId;
        }
    }

    public Date getValidDate() {
        return _validDate;
    }

    public void setValidDate(Date validDate) {
        if (((validDate == null) && (_validDate != null)) ||
                ((validDate != null) && (_validDate == null)) ||
                ((validDate != null) && (_validDate != null) &&
                !validDate.equals(_validDate))) {
            _validDate = validDate;
        }
    }

    public Date getExpectedReturningDate() {
        return _expectedReturningDate;
    }

    public void setExpectedReturningDate(Date expectedReturningDate) {
        if (((expectedReturningDate == null) &&
                (_expectedReturningDate != null)) ||
                ((expectedReturningDate != null) &&
                (_expectedReturningDate == null)) ||
                ((expectedReturningDate != null) &&
                (_expectedReturningDate != null) &&
                !expectedReturningDate.equals(_expectedReturningDate))) {
            _expectedReturningDate = expectedReturningDate;
        }
    }

    public Date getApplicationDate() {
        return _applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        if (((applicationDate == null) && (_applicationDate != null)) ||
                ((applicationDate != null) && (_applicationDate == null)) ||
                ((applicationDate != null) && (_applicationDate != null) &&
                !applicationDate.equals(_applicationDate))) {
            _applicationDate = applicationDate;
        }
    }

    public String getOtherContent() {
        return GetterUtil.getString(_otherContent);
    }

    public void setOtherContent(String otherContent) {
        if (((otherContent == null) && (_otherContent != null)) ||
                ((otherContent != null) && (_otherContent == null)) ||
                ((otherContent != null) && (_otherContent != null) &&
                !otherContent.equals(_otherContent))) {
            _otherContent = otherContent;
        }
    }

    public String getBriefContent() {
        return GetterUtil.getString(_briefContent);
    }

    public void setBriefContent(String briefContent) {
        if (((briefContent == null) && (_briefContent != null)) ||
                ((briefContent != null) && (_briefContent == null)) ||
                ((briefContent != null) && (_briefContent != null) &&
                !briefContent.equals(_briefContent))) {
            _briefContent = briefContent;
        }
    }

    public String getApplicantName() {
        return GetterUtil.getString(_applicantName);
    }

    public void setApplicantName(String applicantName) {
        if (((applicantName == null) && (_applicantName != null)) ||
                ((applicantName != null) && (_applicantName == null)) ||
                ((applicantName != null) && (_applicantName != null) &&
                !applicantName.equals(_applicantName))) {
            _applicantName = applicantName;
        }
    }

    public String getOrganization() {
        return GetterUtil.getString(_organization);
    }

    public void setOrganization(String organization) {
        if (((organization == null) && (_organization != null)) ||
                ((organization != null) && (_organization == null)) ||
                ((organization != null) && (_organization != null) &&
                !organization.equals(_organization))) {
            _organization = organization;
        }
    }

    public String getAuthorisedLetter() {
        return GetterUtil.getString(_authorisedLetter);
    }

    public void setAuthorisedLetter(String authorisedLetter) {
        if (((authorisedLetter == null) && (_authorisedLetter != null)) ||
                ((authorisedLetter != null) && (_authorisedLetter == null)) ||
                ((authorisedLetter != null) && (_authorisedLetter != null) &&
                !authorisedLetter.equals(_authorisedLetter))) {
            _authorisedLetter = authorisedLetter;
        }
    }

    public String getIdNumber() {
        return GetterUtil.getString(_idNumber);
    }

    public void setIdNumber(String idNumber) {
        if (((idNumber == null) && (_idNumber != null)) ||
                ((idNumber != null) && (_idNumber == null)) ||
                ((idNumber != null) && (_idNumber != null) &&
                !idNumber.equals(_idNumber))) {
            _idNumber = idNumber;
        }
    }

    public Date getIssuingDate() {
        return _issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        if (((issuingDate == null) && (_issuingDate != null)) ||
                ((issuingDate != null) && (_issuingDate == null)) ||
                ((issuingDate != null) && (_issuingDate != null) &&
                !issuingDate.equals(_issuingDate))) {
            _issuingDate = issuingDate;
        }
    }

    public String getIssuingPlace() {
        return GetterUtil.getString(_issuingPlace);
    }

    public void setIssuingPlace(String issuingPlace) {
        if (((issuingPlace == null) && (_issuingPlace != null)) ||
                ((issuingPlace != null) && (_issuingPlace == null)) ||
                ((issuingPlace != null) && (_issuingPlace != null) &&
                !issuingPlace.equals(_issuingPlace))) {
            _issuingPlace = issuingPlace;
        }
    }

    public String getTelephone() {
        return GetterUtil.getString(_telephone);
    }

    public void setTelephone(String telephone) {
        if (((telephone == null) && (_telephone != null)) ||
                ((telephone != null) && (_telephone == null)) ||
                ((telephone != null) && (_telephone != null) &&
                !telephone.equals(_telephone))) {
            _telephone = telephone;
        }
    }

    public String getGender() {
        return GetterUtil.getString(_gender);
    }

    public void setGender(String gender) {
        if (((gender == null) && (_gender != null)) ||
                ((gender != null) && (_gender == null)) ||
                ((gender != null) && (_gender != null) &&
                !gender.equals(_gender))) {
            _gender = gender;
        }
    }

    public String getStreetNumber() {
        return GetterUtil.getString(_streetNumber);
    }

    public void setStreetNumber(String streetNumber) {
        if (((streetNumber == null) && (_streetNumber != null)) ||
                ((streetNumber != null) && (_streetNumber == null)) ||
                ((streetNumber != null) && (_streetNumber != null) &&
                !streetNumber.equals(_streetNumber))) {
            _streetNumber = streetNumber;
        }
    }

    public String getPermanentAddress() {
        return GetterUtil.getString(_permanentAddress);
    }

    public void setPermanentAddress(String permanentAddress) {
        if (((permanentAddress == null) && (_permanentAddress != null)) ||
                ((permanentAddress != null) && (_permanentAddress == null)) ||
                ((permanentAddress != null) && (_permanentAddress != null) &&
                !permanentAddress.equals(_permanentAddress))) {
            _permanentAddress = permanentAddress;
        }
    }

    public String getContactInfomation() {
        return GetterUtil.getString(_contactInfomation);
    }

    public void setContactInfomation(String contactInfomation) {
        if (((contactInfomation == null) && (_contactInfomation != null)) ||
                ((contactInfomation != null) && (_contactInfomation == null)) ||
                ((contactInfomation != null) && (_contactInfomation != null) &&
                !contactInfomation.equals(_contactInfomation))) {
            _contactInfomation = contactInfomation;
        }
    }

    public String getOldNumberReceipt() {
        return GetterUtil.getString(_oldNumberReceipt);
    }

    public void setOldNumberReceipt(String oldNumberReceipt) {
        if (((oldNumberReceipt == null) && (_oldNumberReceipt != null)) ||
                ((oldNumberReceipt != null) && (_oldNumberReceipt == null)) ||
                ((oldNumberReceipt != null) && (_oldNumberReceipt != null) &&
                !oldNumberReceipt.equals(_oldNumberReceipt))) {
            _oldNumberReceipt = oldNumberReceipt;
        }
    }

    public String getNumberReceipt() {
        return GetterUtil.getString(_numberReceipt);
    }

    public void setNumberReceipt(String numberReceipt) {
        if (((numberReceipt == null) && (_numberReceipt != null)) ||
                ((numberReceipt != null) && (_numberReceipt == null)) ||
                ((numberReceipt != null) && (_numberReceipt != null) &&
                !numberReceipt.equals(_numberReceipt))) {
            _numberReceipt = numberReceipt;
        }
    }

    public String getFileTypeId() {
        return GetterUtil.getString(_fileTypeId);
    }

    public void setFileTypeId(String fileTypeId) {
        if (((fileTypeId == null) && (_fileTypeId != null)) ||
                ((fileTypeId != null) && (_fileTypeId == null)) ||
                ((fileTypeId != null) && (_fileTypeId != null) &&
                !fileTypeId.equals(_fileTypeId))) {
            _fileTypeId = fileTypeId;
        }
    }

    public String getFieldId() {
        return GetterUtil.getString(_fieldId);
    }

    public void setFieldId(String fieldId) {
        if (((fieldId == null) && (_fieldId != null)) ||
                ((fieldId != null) && (_fieldId == null)) ||
                ((fieldId != null) && (_fieldId != null) &&
                !fieldId.equals(_fieldId))) {
            _fieldId = fieldId;
        }
    }

    public int getSolvingTime() {
        return _solvingTime;
    }

    public void setSolvingTime(int solvingTime) {
        if (solvingTime != _solvingTime) {
            _solvingTime = solvingTime;
        }
    }

    public String getAmendedContent() {
        return GetterUtil.getString(_amendedContent);
    }

    public void setAmendedContent(String amendedContent) {
        if (((amendedContent == null) && (_amendedContent != null)) ||
                ((amendedContent != null) && (_amendedContent == null)) ||
                ((amendedContent != null) && (_amendedContent != null) &&
                !amendedContent.equals(_amendedContent))) {
            _amendedContent = amendedContent;
        }
    }

    public Date getLandCheckingDate() {
        return _landCheckingDate;
    }

    public void setLandCheckingDate(Date landCheckingDate) {
        if (((landCheckingDate == null) && (_landCheckingDate != null)) ||
                ((landCheckingDate != null) && (_landCheckingDate == null)) ||
                ((landCheckingDate != null) && (_landCheckingDate != null) &&
                !landCheckingDate.equals(_landCheckingDate))) {
            _landCheckingDate = landCheckingDate;
        }
    }

    public String getDecisionNotice() {
        return GetterUtil.getString(_decisionNotice);
    }

    public void setDecisionNotice(String decisionNotice) {
        if (((decisionNotice == null) && (_decisionNotice != null)) ||
                ((decisionNotice != null) && (_decisionNotice == null)) ||
                ((decisionNotice != null) && (_decisionNotice != null) &&
                !decisionNotice.equals(_decisionNotice))) {
            _decisionNotice = decisionNotice;
        }
    }

    public String getReceiver() {
        return GetterUtil.getString(_receiver);
    }

    public void setReceiver(String receiver) {
        if (((receiver == null) && (_receiver != null)) ||
                ((receiver != null) && (_receiver == null)) ||
                ((receiver != null) && (_receiver != null) &&
                !receiver.equals(_receiver))) {
            _receiver = receiver;
        }
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        if (((dateCreated == null) && (_dateCreated != null)) ||
                ((dateCreated != null) && (_dateCreated == null)) ||
                ((dateCreated != null) && (_dateCreated != null) &&
                !dateCreated.equals(_dateCreated))) {
            _dateCreated = dateCreated;
        }
    }

    public Date getLastUpdate() {
        return _lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        if (((lastUpdate == null) && (_lastUpdate != null)) ||
                ((lastUpdate != null) && (_lastUpdate == null)) ||
                ((lastUpdate != null) && (_lastUpdate != null) &&
                !lastUpdate.equals(_lastUpdate))) {
            _lastUpdate = lastUpdate;
        }
    }

    public String getLastTestProcessInfo() {
        return GetterUtil.getString(_lastTestProcessInfo);
    }

    public void setLastTestProcessInfo(String lastTestProcessInfo) {
        if (((lastTestProcessInfo == null) && (_lastTestProcessInfo != null)) ||
                ((lastTestProcessInfo != null) &&
                (_lastTestProcessInfo == null)) ||
                ((lastTestProcessInfo != null) &&
                (_lastTestProcessInfo != null) &&
                !lastTestProcessInfo.equals(_lastTestProcessInfo))) {
            _lastTestProcessInfo = lastTestProcessInfo;
        }
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        if (((active == null) && (_active != null)) ||
                ((active != null) && (_active == null)) ||
                ((active != null) && (_active != null) &&
                !active.equals(_active))) {
            _active = active;
        }
    }

    public long getGeneralorderno() {
        return _generalorderno;
    }

    public void setGeneralorderno(long generalorderno) {
        if (generalorderno != _generalorderno) {
            _generalorderno = generalorderno;
        }
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

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlOneDoorReceiveFileImpl pmlOneDoorReceiveFile = (PmlOneDoorReceiveFileImpl) obj;

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

        PmlOneDoorReceiveFileImpl pmlOneDoorReceiveFile = null;

        try {
            pmlOneDoorReceiveFile = (PmlOneDoorReceiveFileImpl) obj;
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
}
