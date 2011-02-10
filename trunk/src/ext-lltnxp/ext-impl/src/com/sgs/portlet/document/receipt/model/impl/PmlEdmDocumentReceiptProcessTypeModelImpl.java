package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessTypeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptProcessTypeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocumentReceiptProcessType</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessTypeModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptProcessTypeImpl
 *
 */
public class PmlEdmDocumentReceiptProcessTypeModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documentreceiptprocesstype";
    public static final Object[][] TABLE_COLUMNS = {
            { "docReceiptProcessTypeId", new Integer(Types.BIGINT) },
            

            { "documentReceiptId", new Integer(Types.BIGINT) },
            

            { "documentReceiptLogId", new Integer(Types.BIGINT) },
            

            { "processTypeOrderNo", new Integer(Types.INTEGER) },
            

            { "dateEdit", new Integer(Types.TIMESTAMP) },
            

            { "processTypeIdBefore", new Integer(Types.VARCHAR) },
            

            { "processTypeIdAfter", new Integer(Types.VARCHAR) },
            

            { "processTypeReason", new Integer(Types.VARCHAR) },
            

            { "processerId", new Integer(Types.BIGINT) },
            

            { "departmentId", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documentreceiptprocesstype (docReceiptProcessTypeId LONG not null primary key,documentReceiptId LONG,documentReceiptLogId LONG,processTypeOrderNo INTEGER,dateEdit DATE null,processTypeIdBefore VARCHAR(75) null,processTypeIdAfter VARCHAR(75) null,processTypeReason VARCHAR(75) null,processerId LONG,departmentId VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documentreceiptprocesstype";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType"));
    private long _docReceiptProcessTypeId;
    private long _documentReceiptId;
    private long _documentReceiptLogId;
    private int _processTypeOrderNo;
    private Date _dateEdit;
    private String _processTypeIdBefore;
    private String _processTypeIdAfter;
    private String _processTypeReason;
    private long _processerId;
    private String _departmentId;

    public PmlEdmDocumentReceiptProcessTypeModelImpl() {
    }

    public static PmlEdmDocumentReceiptProcessType toModel(
        PmlEdmDocumentReceiptProcessTypeSoap soapModel) {
        PmlEdmDocumentReceiptProcessType model = new PmlEdmDocumentReceiptProcessTypeImpl();

        model.setDocReceiptProcessTypeId(soapModel.getDocReceiptProcessTypeId());
        model.setDocumentReceiptId(soapModel.getDocumentReceiptId());
        model.setDocumentReceiptLogId(soapModel.getDocumentReceiptLogId());
        model.setProcessTypeOrderNo(soapModel.getProcessTypeOrderNo());
        model.setDateEdit(soapModel.getDateEdit());
        model.setProcessTypeIdBefore(soapModel.getProcessTypeIdBefore());
        model.setProcessTypeIdAfter(soapModel.getProcessTypeIdAfter());
        model.setProcessTypeReason(soapModel.getProcessTypeReason());
        model.setProcesserId(soapModel.getProcesserId());
        model.setDepartmentId(soapModel.getDepartmentId());

        return model;
    }

    public static List<PmlEdmDocumentReceiptProcessType> toModels(
        PmlEdmDocumentReceiptProcessTypeSoap[] soapModels) {
        List<PmlEdmDocumentReceiptProcessType> models = new ArrayList<PmlEdmDocumentReceiptProcessType>(soapModels.length);

        for (PmlEdmDocumentReceiptProcessTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _docReceiptProcessTypeId;
    }

    public void setPrimaryKey(long pk) {
        setDocReceiptProcessTypeId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_docReceiptProcessTypeId);
    }

    public long getDocReceiptProcessTypeId() {
        return _docReceiptProcessTypeId;
    }

    public void setDocReceiptProcessTypeId(long docReceiptProcessTypeId) {
        if (docReceiptProcessTypeId != _docReceiptProcessTypeId) {
            _docReceiptProcessTypeId = docReceiptProcessTypeId;
        }
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        if (documentReceiptId != _documentReceiptId) {
            _documentReceiptId = documentReceiptId;
        }
    }

    public long getDocumentReceiptLogId() {
        return _documentReceiptLogId;
    }

    public void setDocumentReceiptLogId(long documentReceiptLogId) {
        if (documentReceiptLogId != _documentReceiptLogId) {
            _documentReceiptLogId = documentReceiptLogId;
        }
    }

    public int getProcessTypeOrderNo() {
        return _processTypeOrderNo;
    }

    public void setProcessTypeOrderNo(int processTypeOrderNo) {
        if (processTypeOrderNo != _processTypeOrderNo) {
            _processTypeOrderNo = processTypeOrderNo;
        }
    }

    public Date getDateEdit() {
        return _dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        if (((dateEdit == null) && (_dateEdit != null)) ||
                ((dateEdit != null) && (_dateEdit == null)) ||
                ((dateEdit != null) && (_dateEdit != null) &&
                !dateEdit.equals(_dateEdit))) {
            _dateEdit = dateEdit;
        }
    }

    public String getProcessTypeIdBefore() {
        return GetterUtil.getString(_processTypeIdBefore);
    }

    public void setProcessTypeIdBefore(String processTypeIdBefore) {
        if (((processTypeIdBefore == null) && (_processTypeIdBefore != null)) ||
                ((processTypeIdBefore != null) &&
                (_processTypeIdBefore == null)) ||
                ((processTypeIdBefore != null) &&
                (_processTypeIdBefore != null) &&
                !processTypeIdBefore.equals(_processTypeIdBefore))) {
            _processTypeIdBefore = processTypeIdBefore;
        }
    }

    public String getProcessTypeIdAfter() {
        return GetterUtil.getString(_processTypeIdAfter);
    }

    public void setProcessTypeIdAfter(String processTypeIdAfter) {
        if (((processTypeIdAfter == null) && (_processTypeIdAfter != null)) ||
                ((processTypeIdAfter != null) && (_processTypeIdAfter == null)) ||
                ((processTypeIdAfter != null) && (_processTypeIdAfter != null) &&
                !processTypeIdAfter.equals(_processTypeIdAfter))) {
            _processTypeIdAfter = processTypeIdAfter;
        }
    }

    public String getProcessTypeReason() {
        return GetterUtil.getString(_processTypeReason);
    }

    public void setProcessTypeReason(String processTypeReason) {
        if (((processTypeReason == null) && (_processTypeReason != null)) ||
                ((processTypeReason != null) && (_processTypeReason == null)) ||
                ((processTypeReason != null) && (_processTypeReason != null) &&
                !processTypeReason.equals(_processTypeReason))) {
            _processTypeReason = processTypeReason;
        }
    }

    public long getProcesserId() {
        return _processerId;
    }

    public void setProcesserId(long processerId) {
        if (processerId != _processerId) {
            _processerId = processerId;
        }
    }

    public String getDepartmentId() {
        return GetterUtil.getString(_departmentId);
    }

    public void setDepartmentId(String departmentId) {
        if (((departmentId == null) && (_departmentId != null)) ||
                ((departmentId != null) && (_departmentId == null)) ||
                ((departmentId != null) && (_departmentId != null) &&
                !departmentId.equals(_departmentId))) {
            _departmentId = departmentId;
        }
    }

    public PmlEdmDocumentReceiptProcessType toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocumentReceiptProcessType) this;
        } else {
            PmlEdmDocumentReceiptProcessType model = new PmlEdmDocumentReceiptProcessTypeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocReceiptProcessTypeId(getDocReceiptProcessTypeId());
            model.setDocumentReceiptId(getDocumentReceiptId());
            model.setDocumentReceiptLogId(getDocumentReceiptLogId());
            model.setProcessTypeOrderNo(getProcessTypeOrderNo());
            model.setDateEdit(getDateEdit());
            model.setProcessTypeIdBefore(HtmlUtil.escape(
                    getProcessTypeIdBefore()));
            model.setProcessTypeIdAfter(HtmlUtil.escape(getProcessTypeIdAfter()));
            model.setProcessTypeReason(HtmlUtil.escape(getProcessTypeReason()));
            model.setProcesserId(getProcesserId());
            model.setDepartmentId(HtmlUtil.escape(getDepartmentId()));

            model = (PmlEdmDocumentReceiptProcessType) Proxy.newProxyInstance(PmlEdmDocumentReceiptProcessType.class.getClassLoader(),
                    new Class[] { PmlEdmDocumentReceiptProcessType.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocumentReceiptProcessTypeImpl clone = new PmlEdmDocumentReceiptProcessTypeImpl();

        clone.setDocReceiptProcessTypeId(getDocReceiptProcessTypeId());
        clone.setDocumentReceiptId(getDocumentReceiptId());
        clone.setDocumentReceiptLogId(getDocumentReceiptLogId());
        clone.setProcessTypeOrderNo(getProcessTypeOrderNo());
        clone.setDateEdit(getDateEdit());
        clone.setProcessTypeIdBefore(getProcessTypeIdBefore());
        clone.setProcessTypeIdAfter(getProcessTypeIdAfter());
        clone.setProcessTypeReason(getProcessTypeReason());
        clone.setProcesserId(getProcesserId());
        clone.setDepartmentId(getDepartmentId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmDocumentReceiptProcessTypeImpl pmlEdmDocumentReceiptProcessType = (PmlEdmDocumentReceiptProcessTypeImpl) obj;

        int value = 0;

        if (getProcessTypeOrderNo() < pmlEdmDocumentReceiptProcessType.getProcessTypeOrderNo()) {
            value = -1;
        } else if (getProcessTypeOrderNo() > pmlEdmDocumentReceiptProcessType.getProcessTypeOrderNo()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlEdmDocumentReceiptProcessTypeImpl pmlEdmDocumentReceiptProcessType = null;

        try {
            pmlEdmDocumentReceiptProcessType = (PmlEdmDocumentReceiptProcessTypeImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmDocumentReceiptProcessType.getPrimaryKey();

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
