package com.sgs.portlet.document.send.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSendSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmBookDocumentSendModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmBookDocumentSend</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend
 * @see com.sgs.portlet.document.send.model.PmlEdmBookDocumentSendModel
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmBookDocumentSendImpl
 *
 */
public class PmlEdmBookDocumentSendModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_bookdocumentsend";
    public static final Object[][] TABLE_COLUMNS = {
            { "bookdocumentsendid", new Integer(Types.BIGINT) },
            

            { "datecreated", new Integer(Types.TIMESTAMP) },
            

            { "currentrecord", new Integer(Types.BIGINT) },
            

            { "departmentsid", new Integer(Types.VARCHAR) },
            

            { "documentrecordtypeid", new Integer(Types.INTEGER) },
            

            { "yearinuse", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "isagency", new Integer(Types.VARCHAR) },
            

            { "agencyid", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_bookdocumentsend (bookdocumentsendid LONG not null primary key,datecreated DATE null,currentrecord LONG,departmentsid VARCHAR(75) null,documentrecordtypeid INTEGER,yearinuse VARCHAR(75) null,active VARCHAR(75) null,isagency VARCHAR(75) null,agencyid VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_bookdocumentsend";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend"));
    private long _bookDocumentSendId;
    private Date _dateCreated;
    private long _currentRecord;
    private String _departmentsId;
    private int _documentRecordTypeId;
    private String _yearInUse;
    private String _active;
    private String _isAgency;
    private String _agencyId;

    public PmlEdmBookDocumentSendModelImpl() {
    }

    public static PmlEdmBookDocumentSend toModel(
        PmlEdmBookDocumentSendSoap soapModel) {
        PmlEdmBookDocumentSend model = new PmlEdmBookDocumentSendImpl();

        model.setBookDocumentSendId(soapModel.getBookDocumentSendId());
        model.setDateCreated(soapModel.getDateCreated());
        model.setCurrentRecord(soapModel.getCurrentRecord());
        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setDocumentRecordTypeId(soapModel.getDocumentRecordTypeId());
        model.setYearInUse(soapModel.getYearInUse());
        model.setActive(soapModel.getActive());
        model.setIsAgency(soapModel.getIsAgency());
        model.setAgencyId(soapModel.getAgencyId());

        return model;
    }

    public static List<PmlEdmBookDocumentSend> toModels(
        PmlEdmBookDocumentSendSoap[] soapModels) {
        List<PmlEdmBookDocumentSend> models = new ArrayList<PmlEdmBookDocumentSend>(soapModels.length);

        for (PmlEdmBookDocumentSendSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _bookDocumentSendId;
    }

    public void setPrimaryKey(long pk) {
        setBookDocumentSendId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_bookDocumentSendId);
    }

    public long getBookDocumentSendId() {
        return _bookDocumentSendId;
    }

    public void setBookDocumentSendId(long bookDocumentSendId) {
        if (bookDocumentSendId != _bookDocumentSendId) {
            _bookDocumentSendId = bookDocumentSendId;
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

    public long getCurrentRecord() {
        return _currentRecord;
    }

    public void setCurrentRecord(long currentRecord) {
        if (currentRecord != _currentRecord) {
            _currentRecord = currentRecord;
        }
    }

    public String getDepartmentsId() {
        return GetterUtil.getString(_departmentsId);
    }

    public void setDepartmentsId(String departmentsId) {
        if (((departmentsId == null) && (_departmentsId != null)) ||
                ((departmentsId != null) && (_departmentsId == null)) ||
                ((departmentsId != null) && (_departmentsId != null) &&
                !departmentsId.equals(_departmentsId))) {
            _departmentsId = departmentsId;
        }
    }

    public int getDocumentRecordTypeId() {
        return _documentRecordTypeId;
    }

    public void setDocumentRecordTypeId(int documentRecordTypeId) {
        if (documentRecordTypeId != _documentRecordTypeId) {
            _documentRecordTypeId = documentRecordTypeId;
        }
    }

    public String getYearInUse() {
        return GetterUtil.getString(_yearInUse);
    }

    public void setYearInUse(String yearInUse) {
        if (((yearInUse == null) && (_yearInUse != null)) ||
                ((yearInUse != null) && (_yearInUse == null)) ||
                ((yearInUse != null) && (_yearInUse != null) &&
                !yearInUse.equals(_yearInUse))) {
            _yearInUse = yearInUse;
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

    public String getIsAgency() {
        return GetterUtil.getString(_isAgency);
    }

    public void setIsAgency(String isAgency) {
        if (((isAgency == null) && (_isAgency != null)) ||
                ((isAgency != null) && (_isAgency == null)) ||
                ((isAgency != null) && (_isAgency != null) &&
                !isAgency.equals(_isAgency))) {
            _isAgency = isAgency;
        }
    }

    public String getAgencyId() {
        return GetterUtil.getString(_agencyId);
    }

    public void setAgencyId(String agencyId) {
        if (((agencyId == null) && (_agencyId != null)) ||
                ((agencyId != null) && (_agencyId == null)) ||
                ((agencyId != null) && (_agencyId != null) &&
                !agencyId.equals(_agencyId))) {
            _agencyId = agencyId;
        }
    }

    public PmlEdmBookDocumentSend toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmBookDocumentSend) this;
        } else {
            PmlEdmBookDocumentSend model = new PmlEdmBookDocumentSendImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setBookDocumentSendId(getBookDocumentSendId());
            model.setDateCreated(getDateCreated());
            model.setCurrentRecord(getCurrentRecord());
            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));
            model.setDocumentRecordTypeId(getDocumentRecordTypeId());
            model.setYearInUse(HtmlUtil.escape(getYearInUse()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setIsAgency(HtmlUtil.escape(getIsAgency()));
            model.setAgencyId(HtmlUtil.escape(getAgencyId()));

            model = (PmlEdmBookDocumentSend) Proxy.newProxyInstance(PmlEdmBookDocumentSend.class.getClassLoader(),
                    new Class[] { PmlEdmBookDocumentSend.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmBookDocumentSendImpl clone = new PmlEdmBookDocumentSendImpl();

        clone.setBookDocumentSendId(getBookDocumentSendId());
        clone.setDateCreated(getDateCreated());
        clone.setCurrentRecord(getCurrentRecord());
        clone.setDepartmentsId(getDepartmentsId());
        clone.setDocumentRecordTypeId(getDocumentRecordTypeId());
        clone.setYearInUse(getYearInUse());
        clone.setActive(getActive());
        clone.setIsAgency(getIsAgency());
        clone.setAgencyId(getAgencyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmBookDocumentSendImpl pmlEdmBookDocumentSend = (PmlEdmBookDocumentSendImpl) obj;

        int value = 0;

        if (getBookDocumentSendId() < pmlEdmBookDocumentSend.getBookDocumentSendId()) {
            value = -1;
        } else if (getBookDocumentSendId() > pmlEdmBookDocumentSend.getBookDocumentSendId()) {
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

        PmlEdmBookDocumentSendImpl pmlEdmBookDocumentSend = null;

        try {
            pmlEdmBookDocumentSend = (PmlEdmBookDocumentSendImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmBookDocumentSend.getPrimaryKey();

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
