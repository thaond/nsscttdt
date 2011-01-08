package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordToSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentRecordToModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocumentRecordTo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordToModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordToImpl
 *
 */
public class PmlEdmDocumentRecordToModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documentrecordto";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentrecordtoid", new Integer(Types.BIGINT) },
            

            { "datecreate", new Integer(Types.TIMESTAMP) },
            

            { "currentrecord", new Integer(Types.BIGINT) },
            

            { "departmentsid", new Integer(Types.VARCHAR) },
            

            { "documentrecordtypeid", new Integer(Types.INTEGER) },
            

            { "yearinuse", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "isagency", new Integer(Types.VARCHAR) },
            

            { "agencyid", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documentrecordto (documentrecordtoid LONG not null primary key,datecreate DATE null,currentrecord LONG,departmentsid VARCHAR(75) null,documentrecordtypeid INTEGER,yearinuse VARCHAR(75) null,active VARCHAR(75) null,isagency VARCHAR(75) null,agencyid VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documentrecordto";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo"));
    private long _documentRecordToId;
    private Date _dateCreate;
    private long _currentRecord;
    private String _departmentsId;
    private int _documentRecordTypeId;
    private String _yearInUse;
    private String _active;
    private String _isAgency;
    private String _agencyId;

    public PmlEdmDocumentRecordToModelImpl() {
    }

    public static PmlEdmDocumentRecordTo toModel(
        PmlEdmDocumentRecordToSoap soapModel) {
        PmlEdmDocumentRecordTo model = new PmlEdmDocumentRecordToImpl();

        model.setDocumentRecordToId(soapModel.getDocumentRecordToId());
        model.setDateCreate(soapModel.getDateCreate());
        model.setCurrentRecord(soapModel.getCurrentRecord());
        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setDocumentRecordTypeId(soapModel.getDocumentRecordTypeId());
        model.setYearInUse(soapModel.getYearInUse());
        model.setActive(soapModel.getActive());
        model.setIsAgency(soapModel.getIsAgency());
        model.setAgencyId(soapModel.getAgencyId());

        return model;
    }

    public static List<PmlEdmDocumentRecordTo> toModels(
        PmlEdmDocumentRecordToSoap[] soapModels) {
        List<PmlEdmDocumentRecordTo> models = new ArrayList<PmlEdmDocumentRecordTo>(soapModels.length);

        for (PmlEdmDocumentRecordToSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentRecordToId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentRecordToId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentRecordToId);
    }

    public long getDocumentRecordToId() {
        return _documentRecordToId;
    }

    public void setDocumentRecordToId(long documentRecordToId) {
        if (documentRecordToId != _documentRecordToId) {
            _documentRecordToId = documentRecordToId;
        }
    }

    public Date getDateCreate() {
        return _dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        if (((dateCreate == null) && (_dateCreate != null)) ||
                ((dateCreate != null) && (_dateCreate == null)) ||
                ((dateCreate != null) && (_dateCreate != null) &&
                !dateCreate.equals(_dateCreate))) {
            _dateCreate = dateCreate;
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

    public PmlEdmDocumentRecordTo toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocumentRecordTo) this;
        } else {
            PmlEdmDocumentRecordTo model = new PmlEdmDocumentRecordToImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentRecordToId(getDocumentRecordToId());
            model.setDateCreate(getDateCreate());
            model.setCurrentRecord(getCurrentRecord());
            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));
            model.setDocumentRecordTypeId(getDocumentRecordTypeId());
            model.setYearInUse(HtmlUtil.escape(getYearInUse()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setIsAgency(HtmlUtil.escape(getIsAgency()));
            model.setAgencyId(HtmlUtil.escape(getAgencyId()));

            model = (PmlEdmDocumentRecordTo) Proxy.newProxyInstance(PmlEdmDocumentRecordTo.class.getClassLoader(),
                    new Class[] { PmlEdmDocumentRecordTo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocumentRecordToImpl clone = new PmlEdmDocumentRecordToImpl();

        clone.setDocumentRecordToId(getDocumentRecordToId());
        clone.setDateCreate(getDateCreate());
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

        PmlEdmDocumentRecordToImpl pmlEdmDocumentRecordTo = (PmlEdmDocumentRecordToImpl) obj;

        long pk = pmlEdmDocumentRecordTo.getPrimaryKey();

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

        PmlEdmDocumentRecordToImpl pmlEdmDocumentRecordTo = null;

        try {
            pmlEdmDocumentRecordTo = (PmlEdmDocumentRecordToImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmDocumentRecordTo.getPrimaryKey();

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
