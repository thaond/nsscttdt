package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtendSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptExtendModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocumentReceiptExtend</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtendModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptExtendImpl
 *
 */
public class PmlEdmDocumentReceiptExtendModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documentreceiptextend";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentreceiptextendid", new Integer(Types.BIGINT) },
            

            { "documentreceiptid", new Integer(Types.BIGINT) },
            

            { "documentreceiptlogid", new Integer(Types.BIGINT) },
            

            { "extendorderno", new Integer(Types.INTEGER) },
            

            { "startprocessdate", new Integer(Types.TIMESTAMP) },
            

            { "numdayprocessbef", new Integer(Types.INTEGER) },
            

            { "limitdatebef", new Integer(Types.TIMESTAMP) },
            

            { "extendreason", new Integer(Types.VARCHAR) },
            

            { "numdayprocessaft", new Integer(Types.INTEGER) },
            

            { "limitdateaft", new Integer(Types.TIMESTAMP) },
            

            { "leanonlimitdate", new Integer(Types.BOOLEAN) },
            

            { "extenduserid", new Integer(Types.BIGINT) },
            

            { "extenddepartmentid", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documentreceiptextend (documentreceiptextendid LONG not null primary key,documentreceiptid LONG,documentreceiptlogid LONG,extendorderno INTEGER,startprocessdate DATE null,numdayprocessbef INTEGER,limitdatebef DATE null,extendreason VARCHAR(75) null,numdayprocessaft INTEGER,limitdateaft DATE null,leanonlimitdate BOOLEAN,extenduserid LONG,extenddepartmentid VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documentreceiptextend";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend"));
    private long _documentReceiptExtendId;
    private long _documentReceiptId;
    private long _documentReceiptLogId;
    private int _extendOrderNo;
    private Date _startProcessDate;
    private int _numDayProcessBef;
    private Date _limitDateBef;
    private String _extendReason;
    private int _numDayProcessAft;
    private Date _limitDateAft;
    private boolean _leanOnLimitDate;
    private long _extendUserId;
    private String _extendDepartmentId;

    public PmlEdmDocumentReceiptExtendModelImpl() {
    }

    public static PmlEdmDocumentReceiptExtend toModel(
        PmlEdmDocumentReceiptExtendSoap soapModel) {
        PmlEdmDocumentReceiptExtend model = new PmlEdmDocumentReceiptExtendImpl();

        model.setDocumentReceiptExtendId(soapModel.getDocumentReceiptExtendId());
        model.setDocumentReceiptId(soapModel.getDocumentReceiptId());
        model.setDocumentReceiptLogId(soapModel.getDocumentReceiptLogId());
        model.setExtendOrderNo(soapModel.getExtendOrderNo());
        model.setStartProcessDate(soapModel.getStartProcessDate());
        model.setNumDayProcessBef(soapModel.getNumDayProcessBef());
        model.setLimitDateBef(soapModel.getLimitDateBef());
        model.setExtendReason(soapModel.getExtendReason());
        model.setNumDayProcessAft(soapModel.getNumDayProcessAft());
        model.setLimitDateAft(soapModel.getLimitDateAft());
        model.setLeanOnLimitDate(soapModel.getLeanOnLimitDate());
        model.setExtendUserId(soapModel.getExtendUserId());
        model.setExtendDepartmentId(soapModel.getExtendDepartmentId());

        return model;
    }

    public static List<PmlEdmDocumentReceiptExtend> toModels(
        PmlEdmDocumentReceiptExtendSoap[] soapModels) {
        List<PmlEdmDocumentReceiptExtend> models = new ArrayList<PmlEdmDocumentReceiptExtend>(soapModels.length);

        for (PmlEdmDocumentReceiptExtendSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentReceiptExtendId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentReceiptExtendId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentReceiptExtendId);
    }

    public long getDocumentReceiptExtendId() {
        return _documentReceiptExtendId;
    }

    public void setDocumentReceiptExtendId(long documentReceiptExtendId) {
        if (documentReceiptExtendId != _documentReceiptExtendId) {
            _documentReceiptExtendId = documentReceiptExtendId;
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

    public int getExtendOrderNo() {
        return _extendOrderNo;
    }

    public void setExtendOrderNo(int extendOrderNo) {
        if (extendOrderNo != _extendOrderNo) {
            _extendOrderNo = extendOrderNo;
        }
    }

    public Date getStartProcessDate() {
        return _startProcessDate;
    }

    public void setStartProcessDate(Date startProcessDate) {
        if (((startProcessDate == null) && (_startProcessDate != null)) ||
                ((startProcessDate != null) && (_startProcessDate == null)) ||
                ((startProcessDate != null) && (_startProcessDate != null) &&
                !startProcessDate.equals(_startProcessDate))) {
            _startProcessDate = startProcessDate;
        }
    }

    public int getNumDayProcessBef() {
        return _numDayProcessBef;
    }

    public void setNumDayProcessBef(int numDayProcessBef) {
        if (numDayProcessBef != _numDayProcessBef) {
            _numDayProcessBef = numDayProcessBef;
        }
    }

    public Date getLimitDateBef() {
        return _limitDateBef;
    }

    public void setLimitDateBef(Date limitDateBef) {
        if (((limitDateBef == null) && (_limitDateBef != null)) ||
                ((limitDateBef != null) && (_limitDateBef == null)) ||
                ((limitDateBef != null) && (_limitDateBef != null) &&
                !limitDateBef.equals(_limitDateBef))) {
            _limitDateBef = limitDateBef;
        }
    }

    public String getExtendReason() {
        return GetterUtil.getString(_extendReason);
    }

    public void setExtendReason(String extendReason) {
        if (((extendReason == null) && (_extendReason != null)) ||
                ((extendReason != null) && (_extendReason == null)) ||
                ((extendReason != null) && (_extendReason != null) &&
                !extendReason.equals(_extendReason))) {
            _extendReason = extendReason;
        }
    }

    public int getNumDayProcessAft() {
        return _numDayProcessAft;
    }

    public void setNumDayProcessAft(int numDayProcessAft) {
        if (numDayProcessAft != _numDayProcessAft) {
            _numDayProcessAft = numDayProcessAft;
        }
    }

    public Date getLimitDateAft() {
        return _limitDateAft;
    }

    public void setLimitDateAft(Date limitDateAft) {
        if (((limitDateAft == null) && (_limitDateAft != null)) ||
                ((limitDateAft != null) && (_limitDateAft == null)) ||
                ((limitDateAft != null) && (_limitDateAft != null) &&
                !limitDateAft.equals(_limitDateAft))) {
            _limitDateAft = limitDateAft;
        }
    }

    public boolean getLeanOnLimitDate() {
        return _leanOnLimitDate;
    }

    public boolean isLeanOnLimitDate() {
        return _leanOnLimitDate;
    }

    public void setLeanOnLimitDate(boolean leanOnLimitDate) {
        if (leanOnLimitDate != _leanOnLimitDate) {
            _leanOnLimitDate = leanOnLimitDate;
        }
    }

    public long getExtendUserId() {
        return _extendUserId;
    }

    public void setExtendUserId(long extendUserId) {
        if (extendUserId != _extendUserId) {
            _extendUserId = extendUserId;
        }
    }

    public String getExtendDepartmentId() {
        return GetterUtil.getString(_extendDepartmentId);
    }

    public void setExtendDepartmentId(String extendDepartmentId) {
        if (((extendDepartmentId == null) && (_extendDepartmentId != null)) ||
                ((extendDepartmentId != null) && (_extendDepartmentId == null)) ||
                ((extendDepartmentId != null) && (_extendDepartmentId != null) &&
                !extendDepartmentId.equals(_extendDepartmentId))) {
            _extendDepartmentId = extendDepartmentId;
        }
    }

    public PmlEdmDocumentReceiptExtend toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocumentReceiptExtend) this;
        } else {
            PmlEdmDocumentReceiptExtend model = new PmlEdmDocumentReceiptExtendImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentReceiptExtendId(getDocumentReceiptExtendId());
            model.setDocumentReceiptId(getDocumentReceiptId());
            model.setDocumentReceiptLogId(getDocumentReceiptLogId());
            model.setExtendOrderNo(getExtendOrderNo());
            model.setStartProcessDate(getStartProcessDate());
            model.setNumDayProcessBef(getNumDayProcessBef());
            model.setLimitDateBef(getLimitDateBef());
            model.setExtendReason(HtmlUtil.escape(getExtendReason()));
            model.setNumDayProcessAft(getNumDayProcessAft());
            model.setLimitDateAft(getLimitDateAft());
            model.setLeanOnLimitDate(getLeanOnLimitDate());
            model.setExtendUserId(getExtendUserId());
            model.setExtendDepartmentId(HtmlUtil.escape(getExtendDepartmentId()));

            model = (PmlEdmDocumentReceiptExtend) Proxy.newProxyInstance(PmlEdmDocumentReceiptExtend.class.getClassLoader(),
                    new Class[] { PmlEdmDocumentReceiptExtend.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocumentReceiptExtendImpl clone = new PmlEdmDocumentReceiptExtendImpl();

        clone.setDocumentReceiptExtendId(getDocumentReceiptExtendId());
        clone.setDocumentReceiptId(getDocumentReceiptId());
        clone.setDocumentReceiptLogId(getDocumentReceiptLogId());
        clone.setExtendOrderNo(getExtendOrderNo());
        clone.setStartProcessDate(getStartProcessDate());
        clone.setNumDayProcessBef(getNumDayProcessBef());
        clone.setLimitDateBef(getLimitDateBef());
        clone.setExtendReason(getExtendReason());
        clone.setNumDayProcessAft(getNumDayProcessAft());
        clone.setLimitDateAft(getLimitDateAft());
        clone.setLeanOnLimitDate(getLeanOnLimitDate());
        clone.setExtendUserId(getExtendUserId());
        clone.setExtendDepartmentId(getExtendDepartmentId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmDocumentReceiptExtendImpl pmlEdmDocumentReceiptExtend = (PmlEdmDocumentReceiptExtendImpl) obj;

        int value = 0;

        if (getExtendOrderNo() < pmlEdmDocumentReceiptExtend.getExtendOrderNo()) {
            value = -1;
        } else if (getExtendOrderNo() > pmlEdmDocumentReceiptExtend.getExtendOrderNo()) {
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

        PmlEdmDocumentReceiptExtendImpl pmlEdmDocumentReceiptExtend = null;

        try {
            pmlEdmDocumentReceiptExtend = (PmlEdmDocumentReceiptExtendImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmDocumentReceiptExtend.getPrimaryKey();

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
