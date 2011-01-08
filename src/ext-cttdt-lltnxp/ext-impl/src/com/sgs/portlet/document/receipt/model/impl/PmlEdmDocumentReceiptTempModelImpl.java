package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTempSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptTempModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocumentReceiptTemp</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTempModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptTempImpl
 *
 */
public class PmlEdmDocumentReceiptTempModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documentreceipt_temp";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentReceiptId", new Integer(Types.BIGINT) },
            

            { "levelsendid", new Integer(Types.INTEGER) },
            

            { "documenttypeid", new Integer(Types.BIGINT) },
            

            { "documentreference", new Integer(Types.VARCHAR) },
            

            { "issuingplaceid", new Integer(Types.VARCHAR) },
            

            { "issuingdate", new Integer(Types.TIMESTAMP) },
            

            { "datearrive", new Integer(Types.TIMESTAMP) },
            

            { "signer", new Integer(Types.VARCHAR) },
            

            { "privilegelevelid", new Integer(Types.VARCHAR) },
            

            { "confidentiallevelid", new Integer(Types.VARCHAR) },
            

            { "opinion", new Integer(Types.VARCHAR) },
            

            { "briefcontent", new Integer(Types.VARCHAR) },
            

            { "ispublic", new Integer(Types.VARCHAR) },
            

            { "numberdocumentreceipt", new Integer(Types.VARCHAR) },
            

            { "processtime", new Integer(Types.INTEGER) },
            

            { "status", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "numberlocaldocumentreceipt", new Integer(Types.VARCHAR) },
            

            { "issuingplaceothername", new Integer(Types.VARCHAR) },
            

            { "documenttype", new Integer(Types.VARCHAR) },
            

            { "datebutphe", new Integer(Types.TIMESTAMP) },
            

            { "datehoanthanh", new Integer(Types.TIMESTAMP) },
            

            { "statusid", new Integer(Types.BIGINT) },
            

            { "thoigiannhancvden", new Integer(Types.VARCHAR) },
            

            { "socongvandiphucdap", new Integer(Types.VARCHAR) },
            

            { "generalorderno", new Integer(Types.BIGINT) },
            

            { "maindepartmentprocessid", new Integer(Types.VARCHAR) },
            

            { "mainuserprocessid", new Integer(Types.BIGINT) },
            

            { "orgexternalid", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documentreceipt_temp (documentReceiptId LONG not null primary key,levelsendid INTEGER,documenttypeid LONG,documentreference VARCHAR(75) null,issuingplaceid VARCHAR(75) null,issuingdate DATE null,datearrive DATE null,signer VARCHAR(75) null,privilegelevelid VARCHAR(75) null,confidentiallevelid VARCHAR(75) null,opinion VARCHAR(75) null,briefcontent VARCHAR(75) null,ispublic VARCHAR(75) null,numberdocumentreceipt VARCHAR(75) null,processtime INTEGER,status VARCHAR(75) null,active VARCHAR(75) null,numberlocaldocumentreceipt VARCHAR(75) null,issuingplaceothername VARCHAR(75) null,documenttype VARCHAR(75) null,datebutphe DATE null,datehoanthanh DATE null,statusid LONG,thoigiannhancvden VARCHAR(75) null,socongvandiphucdap VARCHAR(75) null,generalorderno LONG,maindepartmentprocessid VARCHAR(75) null,mainuserprocessid LONG,orgexternalid LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documentreceipt_temp";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp"));
    private long _documentReceiptId;
    private int _levelSendId;
    private long _documentTypeId;
    private String _documentReference;
    private String _issuingPlaceId;
    private Date _issuingDate;
    private Date _dateArrive;
    private String _signer;
    private String _privilegeLevelId;
    private String _confidentialLevelId;
    private String _opinion;
    private String _briefContent;
    private String _isPublic;
    private String _numberDocumentReceipt;
    private int _processTime;
    private String _status;
    private String _active;
    private String _numberLocalDocumentReceipt;
    private String _issuingPlaceOtherName;
    private String _documentType;
    private Date _dateButPhe;
    private Date _dateHoanThanh;
    private long _statusId;
    private String _thoigiannhancvden;
    private String _socongvandiphucdap;
    private long _generalOrderNo;
    private String _mainDepartmentProcessId;
    private long _mainUserProcessId;
    private long _orgExternalId;

    public PmlEdmDocumentReceiptTempModelImpl() {
    }

    public static PmlEdmDocumentReceiptTemp toModel(
        PmlEdmDocumentReceiptTempSoap soapModel) {
        PmlEdmDocumentReceiptTemp model = new PmlEdmDocumentReceiptTempImpl();

        model.setDocumentReceiptId(soapModel.getDocumentReceiptId());
        model.setLevelSendId(soapModel.getLevelSendId());
        model.setDocumentTypeId(soapModel.getDocumentTypeId());
        model.setDocumentReference(soapModel.getDocumentReference());
        model.setIssuingPlaceId(soapModel.getIssuingPlaceId());
        model.setIssuingDate(soapModel.getIssuingDate());
        model.setDateArrive(soapModel.getDateArrive());
        model.setSigner(soapModel.getSigner());
        model.setPrivilegeLevelId(soapModel.getPrivilegeLevelId());
        model.setConfidentialLevelId(soapModel.getConfidentialLevelId());
        model.setOpinion(soapModel.getOpinion());
        model.setBriefContent(soapModel.getBriefContent());
        model.setIsPublic(soapModel.getIsPublic());
        model.setNumberDocumentReceipt(soapModel.getNumberDocumentReceipt());
        model.setProcessTime(soapModel.getProcessTime());
        model.setStatus(soapModel.getStatus());
        model.setActive(soapModel.getActive());
        model.setNumberLocalDocumentReceipt(soapModel.getNumberLocalDocumentReceipt());
        model.setIssuingPlaceOtherName(soapModel.getIssuingPlaceOtherName());
        model.setDocumentType(soapModel.getDocumentType());
        model.setDateButPhe(soapModel.getDateButPhe());
        model.setDateHoanThanh(soapModel.getDateHoanThanh());
        model.setStatusId(soapModel.getStatusId());
        model.setThoigiannhancvden(soapModel.getThoigiannhancvden());
        model.setSocongvandiphucdap(soapModel.getSocongvandiphucdap());
        model.setGeneralOrderNo(soapModel.getGeneralOrderNo());
        model.setMainDepartmentProcessId(soapModel.getMainDepartmentProcessId());
        model.setMainUserProcessId(soapModel.getMainUserProcessId());
        model.setOrgExternalId(soapModel.getOrgExternalId());

        return model;
    }

    public static List<PmlEdmDocumentReceiptTemp> toModels(
        PmlEdmDocumentReceiptTempSoap[] soapModels) {
        List<PmlEdmDocumentReceiptTemp> models = new ArrayList<PmlEdmDocumentReceiptTemp>(soapModels.length);

        for (PmlEdmDocumentReceiptTempSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentReceiptId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentReceiptId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentReceiptId);
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        if (documentReceiptId != _documentReceiptId) {
            _documentReceiptId = documentReceiptId;
        }
    }

    public int getLevelSendId() {
        return _levelSendId;
    }

    public void setLevelSendId(int levelSendId) {
        if (levelSendId != _levelSendId) {
            _levelSendId = levelSendId;
        }
    }

    public long getDocumentTypeId() {
        return _documentTypeId;
    }

    public void setDocumentTypeId(long documentTypeId) {
        if (documentTypeId != _documentTypeId) {
            _documentTypeId = documentTypeId;
        }
    }

    public String getDocumentReference() {
        return GetterUtil.getString(_documentReference);
    }

    public void setDocumentReference(String documentReference) {
        if (((documentReference == null) && (_documentReference != null)) ||
                ((documentReference != null) && (_documentReference == null)) ||
                ((documentReference != null) && (_documentReference != null) &&
                !documentReference.equals(_documentReference))) {
            _documentReference = documentReference;
        }
    }

    public String getIssuingPlaceId() {
        return GetterUtil.getString(_issuingPlaceId);
    }

    public void setIssuingPlaceId(String issuingPlaceId) {
        if (((issuingPlaceId == null) && (_issuingPlaceId != null)) ||
                ((issuingPlaceId != null) && (_issuingPlaceId == null)) ||
                ((issuingPlaceId != null) && (_issuingPlaceId != null) &&
                !issuingPlaceId.equals(_issuingPlaceId))) {
            _issuingPlaceId = issuingPlaceId;
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

    public Date getDateArrive() {
        return _dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        if (((dateArrive == null) && (_dateArrive != null)) ||
                ((dateArrive != null) && (_dateArrive == null)) ||
                ((dateArrive != null) && (_dateArrive != null) &&
                !dateArrive.equals(_dateArrive))) {
            _dateArrive = dateArrive;
        }
    }

    public String getSigner() {
        return GetterUtil.getString(_signer);
    }

    public void setSigner(String signer) {
        if (((signer == null) && (_signer != null)) ||
                ((signer != null) && (_signer == null)) ||
                ((signer != null) && (_signer != null) &&
                !signer.equals(_signer))) {
            _signer = signer;
        }
    }

    public String getPrivilegeLevelId() {
        return GetterUtil.getString(_privilegeLevelId);
    }

    public void setPrivilegeLevelId(String privilegeLevelId) {
        if (((privilegeLevelId == null) && (_privilegeLevelId != null)) ||
                ((privilegeLevelId != null) && (_privilegeLevelId == null)) ||
                ((privilegeLevelId != null) && (_privilegeLevelId != null) &&
                !privilegeLevelId.equals(_privilegeLevelId))) {
            _privilegeLevelId = privilegeLevelId;
        }
    }

    public String getConfidentialLevelId() {
        return GetterUtil.getString(_confidentialLevelId);
    }

    public void setConfidentialLevelId(String confidentialLevelId) {
        if (((confidentialLevelId == null) && (_confidentialLevelId != null)) ||
                ((confidentialLevelId != null) &&
                (_confidentialLevelId == null)) ||
                ((confidentialLevelId != null) &&
                (_confidentialLevelId != null) &&
                !confidentialLevelId.equals(_confidentialLevelId))) {
            _confidentialLevelId = confidentialLevelId;
        }
    }

    public String getOpinion() {
        return GetterUtil.getString(_opinion);
    }

    public void setOpinion(String opinion) {
        if (((opinion == null) && (_opinion != null)) ||
                ((opinion != null) && (_opinion == null)) ||
                ((opinion != null) && (_opinion != null) &&
                !opinion.equals(_opinion))) {
            _opinion = opinion;
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

    public String getIsPublic() {
        return GetterUtil.getString(_isPublic);
    }

    public void setIsPublic(String isPublic) {
        if (((isPublic == null) && (_isPublic != null)) ||
                ((isPublic != null) && (_isPublic == null)) ||
                ((isPublic != null) && (_isPublic != null) &&
                !isPublic.equals(_isPublic))) {
            _isPublic = isPublic;
        }
    }

    public String getNumberDocumentReceipt() {
        return GetterUtil.getString(_numberDocumentReceipt);
    }

    public void setNumberDocumentReceipt(String numberDocumentReceipt) {
        if (((numberDocumentReceipt == null) &&
                (_numberDocumentReceipt != null)) ||
                ((numberDocumentReceipt != null) &&
                (_numberDocumentReceipt == null)) ||
                ((numberDocumentReceipt != null) &&
                (_numberDocumentReceipt != null) &&
                !numberDocumentReceipt.equals(_numberDocumentReceipt))) {
            _numberDocumentReceipt = numberDocumentReceipt;
        }
    }

    public int getProcessTime() {
        return _processTime;
    }

    public void setProcessTime(int processTime) {
        if (processTime != _processTime) {
            _processTime = processTime;
        }
    }

    public String getStatus() {
        return GetterUtil.getString(_status);
    }

    public void setStatus(String status) {
        if (((status == null) && (_status != null)) ||
                ((status != null) && (_status == null)) ||
                ((status != null) && (_status != null) &&
                !status.equals(_status))) {
            _status = status;
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

    public String getNumberLocalDocumentReceipt() {
        return GetterUtil.getString(_numberLocalDocumentReceipt);
    }

    public void setNumberLocalDocumentReceipt(String numberLocalDocumentReceipt) {
        if (((numberLocalDocumentReceipt == null) &&
                (_numberLocalDocumentReceipt != null)) ||
                ((numberLocalDocumentReceipt != null) &&
                (_numberLocalDocumentReceipt == null)) ||
                ((numberLocalDocumentReceipt != null) &&
                (_numberLocalDocumentReceipt != null) &&
                !numberLocalDocumentReceipt.equals(_numberLocalDocumentReceipt))) {
            _numberLocalDocumentReceipt = numberLocalDocumentReceipt;
        }
    }

    public String getIssuingPlaceOtherName() {
        return GetterUtil.getString(_issuingPlaceOtherName);
    }

    public void setIssuingPlaceOtherName(String issuingPlaceOtherName) {
        if (((issuingPlaceOtherName == null) &&
                (_issuingPlaceOtherName != null)) ||
                ((issuingPlaceOtherName != null) &&
                (_issuingPlaceOtherName == null)) ||
                ((issuingPlaceOtherName != null) &&
                (_issuingPlaceOtherName != null) &&
                !issuingPlaceOtherName.equals(_issuingPlaceOtherName))) {
            _issuingPlaceOtherName = issuingPlaceOtherName;
        }
    }

    public String getDocumentType() {
        return GetterUtil.getString(_documentType);
    }

    public void setDocumentType(String documentType) {
        if (((documentType == null) && (_documentType != null)) ||
                ((documentType != null) && (_documentType == null)) ||
                ((documentType != null) && (_documentType != null) &&
                !documentType.equals(_documentType))) {
            _documentType = documentType;
        }
    }

    public Date getDateButPhe() {
        return _dateButPhe;
    }

    public void setDateButPhe(Date dateButPhe) {
        if (((dateButPhe == null) && (_dateButPhe != null)) ||
                ((dateButPhe != null) && (_dateButPhe == null)) ||
                ((dateButPhe != null) && (_dateButPhe != null) &&
                !dateButPhe.equals(_dateButPhe))) {
            _dateButPhe = dateButPhe;
        }
    }

    public Date getDateHoanThanh() {
        return _dateHoanThanh;
    }

    public void setDateHoanThanh(Date dateHoanThanh) {
        if (((dateHoanThanh == null) && (_dateHoanThanh != null)) ||
                ((dateHoanThanh != null) && (_dateHoanThanh == null)) ||
                ((dateHoanThanh != null) && (_dateHoanThanh != null) &&
                !dateHoanThanh.equals(_dateHoanThanh))) {
            _dateHoanThanh = dateHoanThanh;
        }
    }

    public long getStatusId() {
        return _statusId;
    }

    public void setStatusId(long statusId) {
        if (statusId != _statusId) {
            _statusId = statusId;
        }
    }

    public String getThoigiannhancvden() {
        return GetterUtil.getString(_thoigiannhancvden);
    }

    public void setThoigiannhancvden(String thoigiannhancvden) {
        if (((thoigiannhancvden == null) && (_thoigiannhancvden != null)) ||
                ((thoigiannhancvden != null) && (_thoigiannhancvden == null)) ||
                ((thoigiannhancvden != null) && (_thoigiannhancvden != null) &&
                !thoigiannhancvden.equals(_thoigiannhancvden))) {
            _thoigiannhancvden = thoigiannhancvden;
        }
    }

    public String getSocongvandiphucdap() {
        return GetterUtil.getString(_socongvandiphucdap);
    }

    public void setSocongvandiphucdap(String socongvandiphucdap) {
        if (((socongvandiphucdap == null) && (_socongvandiphucdap != null)) ||
                ((socongvandiphucdap != null) && (_socongvandiphucdap == null)) ||
                ((socongvandiphucdap != null) && (_socongvandiphucdap != null) &&
                !socongvandiphucdap.equals(_socongvandiphucdap))) {
            _socongvandiphucdap = socongvandiphucdap;
        }
    }

    public long getGeneralOrderNo() {
        return _generalOrderNo;
    }

    public void setGeneralOrderNo(long generalOrderNo) {
        if (generalOrderNo != _generalOrderNo) {
            _generalOrderNo = generalOrderNo;
        }
    }

    public String getMainDepartmentProcessId() {
        return GetterUtil.getString(_mainDepartmentProcessId);
    }

    public void setMainDepartmentProcessId(String mainDepartmentProcessId) {
        if (((mainDepartmentProcessId == null) &&
                (_mainDepartmentProcessId != null)) ||
                ((mainDepartmentProcessId != null) &&
                (_mainDepartmentProcessId == null)) ||
                ((mainDepartmentProcessId != null) &&
                (_mainDepartmentProcessId != null) &&
                !mainDepartmentProcessId.equals(_mainDepartmentProcessId))) {
            _mainDepartmentProcessId = mainDepartmentProcessId;
        }
    }

    public long getMainUserProcessId() {
        return _mainUserProcessId;
    }

    public void setMainUserProcessId(long mainUserProcessId) {
        if (mainUserProcessId != _mainUserProcessId) {
            _mainUserProcessId = mainUserProcessId;
        }
    }

    public long getOrgExternalId() {
        return _orgExternalId;
    }

    public void setOrgExternalId(long orgExternalId) {
        if (orgExternalId != _orgExternalId) {
            _orgExternalId = orgExternalId;
        }
    }

    public PmlEdmDocumentReceiptTemp toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocumentReceiptTemp) this;
        } else {
            PmlEdmDocumentReceiptTemp model = new PmlEdmDocumentReceiptTempImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentReceiptId(getDocumentReceiptId());
            model.setLevelSendId(getLevelSendId());
            model.setDocumentTypeId(getDocumentTypeId());
            model.setDocumentReference(HtmlUtil.escape(getDocumentReference()));
            model.setIssuingPlaceId(HtmlUtil.escape(getIssuingPlaceId()));
            model.setIssuingDate(getIssuingDate());
            model.setDateArrive(getDateArrive());
            model.setSigner(HtmlUtil.escape(getSigner()));
            model.setPrivilegeLevelId(HtmlUtil.escape(getPrivilegeLevelId()));
            model.setConfidentialLevelId(HtmlUtil.escape(
                    getConfidentialLevelId()));
            model.setOpinion(HtmlUtil.escape(getOpinion()));
            model.setBriefContent(HtmlUtil.escape(getBriefContent()));
            model.setIsPublic(HtmlUtil.escape(getIsPublic()));
            model.setNumberDocumentReceipt(HtmlUtil.escape(
                    getNumberDocumentReceipt()));
            model.setProcessTime(getProcessTime());
            model.setStatus(HtmlUtil.escape(getStatus()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setNumberLocalDocumentReceipt(HtmlUtil.escape(
                    getNumberLocalDocumentReceipt()));
            model.setIssuingPlaceOtherName(HtmlUtil.escape(
                    getIssuingPlaceOtherName()));
            model.setDocumentType(HtmlUtil.escape(getDocumentType()));
            model.setDateButPhe(getDateButPhe());
            model.setDateHoanThanh(getDateHoanThanh());
            model.setStatusId(getStatusId());
            model.setThoigiannhancvden(HtmlUtil.escape(getThoigiannhancvden()));
            model.setSocongvandiphucdap(HtmlUtil.escape(getSocongvandiphucdap()));
            model.setGeneralOrderNo(getGeneralOrderNo());
            model.setMainDepartmentProcessId(HtmlUtil.escape(
                    getMainDepartmentProcessId()));
            model.setMainUserProcessId(getMainUserProcessId());
            model.setOrgExternalId(getOrgExternalId());

            model = (PmlEdmDocumentReceiptTemp) Proxy.newProxyInstance(PmlEdmDocumentReceiptTemp.class.getClassLoader(),
                    new Class[] { PmlEdmDocumentReceiptTemp.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocumentReceiptTempImpl clone = new PmlEdmDocumentReceiptTempImpl();

        clone.setDocumentReceiptId(getDocumentReceiptId());
        clone.setLevelSendId(getLevelSendId());
        clone.setDocumentTypeId(getDocumentTypeId());
        clone.setDocumentReference(getDocumentReference());
        clone.setIssuingPlaceId(getIssuingPlaceId());
        clone.setIssuingDate(getIssuingDate());
        clone.setDateArrive(getDateArrive());
        clone.setSigner(getSigner());
        clone.setPrivilegeLevelId(getPrivilegeLevelId());
        clone.setConfidentialLevelId(getConfidentialLevelId());
        clone.setOpinion(getOpinion());
        clone.setBriefContent(getBriefContent());
        clone.setIsPublic(getIsPublic());
        clone.setNumberDocumentReceipt(getNumberDocumentReceipt());
        clone.setProcessTime(getProcessTime());
        clone.setStatus(getStatus());
        clone.setActive(getActive());
        clone.setNumberLocalDocumentReceipt(getNumberLocalDocumentReceipt());
        clone.setIssuingPlaceOtherName(getIssuingPlaceOtherName());
        clone.setDocumentType(getDocumentType());
        clone.setDateButPhe(getDateButPhe());
        clone.setDateHoanThanh(getDateHoanThanh());
        clone.setStatusId(getStatusId());
        clone.setThoigiannhancvden(getThoigiannhancvden());
        clone.setSocongvandiphucdap(getSocongvandiphucdap());
        clone.setGeneralOrderNo(getGeneralOrderNo());
        clone.setMainDepartmentProcessId(getMainDepartmentProcessId());
        clone.setMainUserProcessId(getMainUserProcessId());
        clone.setOrgExternalId(getOrgExternalId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmDocumentReceiptTempImpl pmlEdmDocumentReceiptTemp = (PmlEdmDocumentReceiptTempImpl) obj;

        long pk = pmlEdmDocumentReceiptTemp.getPrimaryKey();

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

        PmlEdmDocumentReceiptTempImpl pmlEdmDocumentReceiptTemp = null;

        try {
            pmlEdmDocumentReceiptTemp = (PmlEdmDocumentReceiptTempImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmDocumentReceiptTemp.getPrimaryKey();

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
