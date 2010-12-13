package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.onedoor.model.PmlFilePCCC;
import com.nss.portlet.onedoor.model.PmlFilePCCCSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFilePCCCModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFilePCCC</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlFilePCCC
 * @see com.nss.portlet.onedoor.model.PmlFilePCCCModel
 * @see com.nss.portlet.onedoor.model.impl.PmlFilePCCCImpl
 *
 */
public class PmlFilePCCCModelImpl extends BaseModelImpl<PmlFilePCCC> {
    public static final String TABLE_NAME = "pml_file_pccc";
    public static final Object[][] TABLE_COLUMNS = {
            { "fileid", new Integer(Types.VARCHAR) },
            

            { "fileName", new Integer(Types.VARCHAR) },
            

            { "applicantrepresentation", new Integer(Types.VARCHAR) },
            

            { "applicanttelephone", new Integer(Types.VARCHAR) },
            

            { "receiverrepresentation", new Integer(Types.VARCHAR) },
            

            { "receivertelephone", new Integer(Types.VARCHAR) },
            

            { "projectname", new Integer(Types.VARCHAR) },
            

            { "applicantcategory", new Integer(Types.VARCHAR) },
            

            { "addressbuilder", new Integer(Types.VARCHAR) },
            

            { "investor", new Integer(Types.VARCHAR) },
            

            { "designCop", new Integer(Types.VARCHAR) },
            

            { "filenumber", new Integer(Types.INTEGER) },
            

            { "inputdatadate", new Integer(Types.TIMESTAMP) },
            

            { "noteinformationmanagement", new Integer(Types.VARCHAR) },
            

            { "totalhour", new Integer(Types.INTEGER) },
            

            { "totaldate", new Integer(Types.INTEGER) },
            

            { "conclusion", new Integer(Types.VARCHAR) },
            

            { "receiveofunit", new Integer(Types.VARCHAR) },
            

            { "applicanttime", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_file_pccc (fileid VARCHAR(75) not null primary key,fileName VARCHAR(75) null,applicantrepresentation VARCHAR(75) null,applicanttelephone VARCHAR(75) null,receiverrepresentation VARCHAR(75) null,receivertelephone VARCHAR(75) null,projectname VARCHAR(75) null,applicantcategory VARCHAR(75) null,addressbuilder VARCHAR(75) null,investor VARCHAR(75) null,designCop VARCHAR(75) null,filenumber INTEGER,inputdatadate DATE null,noteinformationmanagement VARCHAR(75) null,totalhour INTEGER,totaldate INTEGER,conclusion VARCHAR(75) null,receiveofunit VARCHAR(75) null,applicanttime VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_file_pccc";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlFilePCCC"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlFilePCCC"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlFilePCCC"));
    private String _fileId;
    private String _fileName;
    private String _applicantRepresentation;
    private String _applicantTelephone;
    private String _receiverRepresentation;
    private String _receiverTelephone;
    private String _projectName;
    private String _applicantCategory;
    private String _addressBuilder;
    private String _investor;
    private String _designCop;
    private int _fileNumber;
    private Date _inputDataDate;
    private String _noteInformationManagement;
    private int _totalHour;
    private int _totalDate;
    private String _conclusion;
    private String _receiveOfUnit;
    private String _applicantTime;

    public PmlFilePCCCModelImpl() {
    }

    public static PmlFilePCCC toModel(PmlFilePCCCSoap soapModel) {
        PmlFilePCCC model = new PmlFilePCCCImpl();

        model.setFileId(soapModel.getFileId());
        model.setFileName(soapModel.getFileName());
        model.setApplicantRepresentation(soapModel.getApplicantRepresentation());
        model.setApplicantTelephone(soapModel.getApplicantTelephone());
        model.setReceiverRepresentation(soapModel.getReceiverRepresentation());
        model.setReceiverTelephone(soapModel.getReceiverTelephone());
        model.setProjectName(soapModel.getProjectName());
        model.setApplicantCategory(soapModel.getApplicantCategory());
        model.setAddressBuilder(soapModel.getAddressBuilder());
        model.setInvestor(soapModel.getInvestor());
        model.setDesignCop(soapModel.getDesignCop());
        model.setFileNumber(soapModel.getFileNumber());
        model.setInputDataDate(soapModel.getInputDataDate());
        model.setNoteInformationManagement(soapModel.getNoteInformationManagement());
        model.setTotalHour(soapModel.getTotalHour());
        model.setTotalDate(soapModel.getTotalDate());
        model.setConclusion(soapModel.getConclusion());
        model.setReceiveOfUnit(soapModel.getReceiveOfUnit());
        model.setApplicantTime(soapModel.getApplicantTime());

        return model;
    }

    public static List<PmlFilePCCC> toModels(PmlFilePCCCSoap[] soapModels) {
        List<PmlFilePCCC> models = new ArrayList<PmlFilePCCC>(soapModels.length);

        for (PmlFilePCCCSoap soapModel : soapModels) {
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

    public String getFileName() {
        return GetterUtil.getString(_fileName);
    }

    public void setFileName(String fileName) {
        _fileName = fileName;
    }

    public String getApplicantRepresentation() {
        return GetterUtil.getString(_applicantRepresentation);
    }

    public void setApplicantRepresentation(String applicantRepresentation) {
        _applicantRepresentation = applicantRepresentation;
    }

    public String getApplicantTelephone() {
        return GetterUtil.getString(_applicantTelephone);
    }

    public void setApplicantTelephone(String applicantTelephone) {
        _applicantTelephone = applicantTelephone;
    }

    public String getReceiverRepresentation() {
        return GetterUtil.getString(_receiverRepresentation);
    }

    public void setReceiverRepresentation(String receiverRepresentation) {
        _receiverRepresentation = receiverRepresentation;
    }

    public String getReceiverTelephone() {
        return GetterUtil.getString(_receiverTelephone);
    }

    public void setReceiverTelephone(String receiverTelephone) {
        _receiverTelephone = receiverTelephone;
    }

    public String getProjectName() {
        return GetterUtil.getString(_projectName);
    }

    public void setProjectName(String projectName) {
        _projectName = projectName;
    }

    public String getApplicantCategory() {
        return GetterUtil.getString(_applicantCategory);
    }

    public void setApplicantCategory(String applicantCategory) {
        _applicantCategory = applicantCategory;
    }

    public String getAddressBuilder() {
        return GetterUtil.getString(_addressBuilder);
    }

    public void setAddressBuilder(String addressBuilder) {
        _addressBuilder = addressBuilder;
    }

    public String getInvestor() {
        return GetterUtil.getString(_investor);
    }

    public void setInvestor(String investor) {
        _investor = investor;
    }

    public String getDesignCop() {
        return GetterUtil.getString(_designCop);
    }

    public void setDesignCop(String designCop) {
        _designCop = designCop;
    }

    public int getFileNumber() {
        return _fileNumber;
    }

    public void setFileNumber(int fileNumber) {
        _fileNumber = fileNumber;
    }

    public Date getInputDataDate() {
        return _inputDataDate;
    }

    public void setInputDataDate(Date inputDataDate) {
        _inputDataDate = inputDataDate;
    }

    public String getNoteInformationManagement() {
        return GetterUtil.getString(_noteInformationManagement);
    }

    public void setNoteInformationManagement(String noteInformationManagement) {
        _noteInformationManagement = noteInformationManagement;
    }

    public int getTotalHour() {
        return _totalHour;
    }

    public void setTotalHour(int totalHour) {
        _totalHour = totalHour;
    }

    public int getTotalDate() {
        return _totalDate;
    }

    public void setTotalDate(int totalDate) {
        _totalDate = totalDate;
    }

    public String getConclusion() {
        return GetterUtil.getString(_conclusion);
    }

    public void setConclusion(String conclusion) {
        _conclusion = conclusion;
    }

    public String getReceiveOfUnit() {
        return GetterUtil.getString(_receiveOfUnit);
    }

    public void setReceiveOfUnit(String receiveOfUnit) {
        _receiveOfUnit = receiveOfUnit;
    }

    public String getApplicantTime() {
        return GetterUtil.getString(_applicantTime);
    }

    public void setApplicantTime(String applicantTime) {
        _applicantTime = applicantTime;
    }

    public PmlFilePCCC toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFilePCCC) this;
        } else {
            PmlFilePCCC model = new PmlFilePCCCImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileId(HtmlUtil.escape(getFileId()));
            model.setFileName(HtmlUtil.escape(getFileName()));
            model.setApplicantRepresentation(HtmlUtil.escape(
                    getApplicantRepresentation()));
            model.setApplicantTelephone(HtmlUtil.escape(getApplicantTelephone()));
            model.setReceiverRepresentation(HtmlUtil.escape(
                    getReceiverRepresentation()));
            model.setReceiverTelephone(HtmlUtil.escape(getReceiverTelephone()));
            model.setProjectName(HtmlUtil.escape(getProjectName()));
            model.setApplicantCategory(HtmlUtil.escape(getApplicantCategory()));
            model.setAddressBuilder(HtmlUtil.escape(getAddressBuilder()));
            model.setInvestor(HtmlUtil.escape(getInvestor()));
            model.setDesignCop(HtmlUtil.escape(getDesignCop()));
            model.setFileNumber(getFileNumber());
            model.setInputDataDate(getInputDataDate());
            model.setNoteInformationManagement(HtmlUtil.escape(
                    getNoteInformationManagement()));
            model.setTotalHour(getTotalHour());
            model.setTotalDate(getTotalDate());
            model.setConclusion(HtmlUtil.escape(getConclusion()));
            model.setReceiveOfUnit(HtmlUtil.escape(getReceiveOfUnit()));
            model.setApplicantTime(HtmlUtil.escape(getApplicantTime()));

            model = (PmlFilePCCC) Proxy.newProxyInstance(PmlFilePCCC.class.getClassLoader(),
                    new Class[] { PmlFilePCCC.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlFilePCCCImpl clone = new PmlFilePCCCImpl();

        clone.setFileId(getFileId());
        clone.setFileName(getFileName());
        clone.setApplicantRepresentation(getApplicantRepresentation());
        clone.setApplicantTelephone(getApplicantTelephone());
        clone.setReceiverRepresentation(getReceiverRepresentation());
        clone.setReceiverTelephone(getReceiverTelephone());
        clone.setProjectName(getProjectName());
        clone.setApplicantCategory(getApplicantCategory());
        clone.setAddressBuilder(getAddressBuilder());
        clone.setInvestor(getInvestor());
        clone.setDesignCop(getDesignCop());
        clone.setFileNumber(getFileNumber());
        clone.setInputDataDate(getInputDataDate());
        clone.setNoteInformationManagement(getNoteInformationManagement());
        clone.setTotalHour(getTotalHour());
        clone.setTotalDate(getTotalDate());
        clone.setConclusion(getConclusion());
        clone.setReceiveOfUnit(getReceiveOfUnit());
        clone.setApplicantTime(getApplicantTime());

        return clone;
    }

    public int compareTo(PmlFilePCCC pmlFilePCCC) {
        int value = 0;

        value = getFileId().compareTo(pmlFilePCCC.getFileId());

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

        PmlFilePCCC pmlFilePCCC = null;

        try {
            pmlFilePCCC = (PmlFilePCCC) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlFilePCCC.getPrimaryKey();

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
        sb.append(", fileName=");
        sb.append(getFileName());
        sb.append(", applicantRepresentation=");
        sb.append(getApplicantRepresentation());
        sb.append(", applicantTelephone=");
        sb.append(getApplicantTelephone());
        sb.append(", receiverRepresentation=");
        sb.append(getReceiverRepresentation());
        sb.append(", receiverTelephone=");
        sb.append(getReceiverTelephone());
        sb.append(", projectName=");
        sb.append(getProjectName());
        sb.append(", applicantCategory=");
        sb.append(getApplicantCategory());
        sb.append(", addressBuilder=");
        sb.append(getAddressBuilder());
        sb.append(", investor=");
        sb.append(getInvestor());
        sb.append(", designCop=");
        sb.append(getDesignCop());
        sb.append(", fileNumber=");
        sb.append(getFileNumber());
        sb.append(", inputDataDate=");
        sb.append(getInputDataDate());
        sb.append(", noteInformationManagement=");
        sb.append(getNoteInformationManagement());
        sb.append(", totalHour=");
        sb.append(getTotalHour());
        sb.append(", totalDate=");
        sb.append(getTotalDate());
        sb.append(", conclusion=");
        sb.append(getConclusion());
        sb.append(", receiveOfUnit=");
        sb.append(getReceiveOfUnit());
        sb.append(", applicantTime=");
        sb.append(getApplicantTime());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlFilePCCC");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fileId</column-name><column-value><![CDATA[");
        sb.append(getFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileName</column-name><column-value><![CDATA[");
        sb.append(getFileName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicantRepresentation</column-name><column-value><![CDATA[");
        sb.append(getApplicantRepresentation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicantTelephone</column-name><column-value><![CDATA[");
        sb.append(getApplicantTelephone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiverRepresentation</column-name><column-value><![CDATA[");
        sb.append(getReceiverRepresentation());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiverTelephone</column-name><column-value><![CDATA[");
        sb.append(getReceiverTelephone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>projectName</column-name><column-value><![CDATA[");
        sb.append(getProjectName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicantCategory</column-name><column-value><![CDATA[");
        sb.append(getApplicantCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>addressBuilder</column-name><column-value><![CDATA[");
        sb.append(getAddressBuilder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>investor</column-name><column-value><![CDATA[");
        sb.append(getInvestor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>designCop</column-name><column-value><![CDATA[");
        sb.append(getDesignCop());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileNumber</column-name><column-value><![CDATA[");
        sb.append(getFileNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>inputDataDate</column-name><column-value><![CDATA[");
        sb.append(getInputDataDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>noteInformationManagement</column-name><column-value><![CDATA[");
        sb.append(getNoteInformationManagement());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>totalHour</column-name><column-value><![CDATA[");
        sb.append(getTotalHour());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>totalDate</column-name><column-value><![CDATA[");
        sb.append(getTotalDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>conclusion</column-name><column-value><![CDATA[");
        sb.append(getConclusion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>receiveOfUnit</column-name><column-value><![CDATA[");
        sb.append(getReceiveOfUnit());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicantTime</column-name><column-value><![CDATA[");
        sb.append(getApplicantTime());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
