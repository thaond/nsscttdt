package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog;
import com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLogSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentReceiptIssuingPlaceLogModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDocumentReceiptIssuingPlaceLog</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog
 * @see com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLogModel
 * @see com.sgs.portlet.document.model.impl.PmlDocumentReceiptIssuingPlaceLogImpl
 *
 */
public class PmlDocumentReceiptIssuingPlaceLogModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_documentreceipt_issuingplace_log";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentReceiptIssuingPlaceLogId", new Integer(Types.BIGINT) },
            

            { "documentReceiptId", new Integer(Types.BIGINT) },
            

            { "processor", new Integer(Types.BIGINT) },
            

            { "directProcessorId", new Integer(Types.BIGINT) },
            

            { "dateProcess", new Integer(Types.TIMESTAMP) },
            

            { "processInfomation", new Integer(Types.VARCHAR) },
            

            { "receiver", new Integer(Types.VARCHAR) },
            

            { "type_", new Integer(Types.INTEGER) },
            

            { "step", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_documentreceipt_issuingplace_log (documentReceiptIssuingPlaceLogId LONG not null primary key,documentReceiptId LONG,processor LONG,directProcessorId LONG,dateProcess DATE null,processInfomation VARCHAR(75) null,receiver VARCHAR(75) null,type_ INTEGER,step INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table pml_documentreceipt_issuingplace_log";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog"));
    private long _documentReceiptIssuingPlaceLogId;
    private long _documentReceiptId;
    private long _processor;
    private long _directProcessorId;
    private Date _dateProcess;
    private String _processInfomation;
    private String _receiver;
    private int _type_;
    private int _step;

    public PmlDocumentReceiptIssuingPlaceLogModelImpl() {
    }

    public static PmlDocumentReceiptIssuingPlaceLog toModel(
        PmlDocumentReceiptIssuingPlaceLogSoap soapModel) {
        PmlDocumentReceiptIssuingPlaceLog model = new PmlDocumentReceiptIssuingPlaceLogImpl();

        model.setDocumentReceiptIssuingPlaceLogId(soapModel.getDocumentReceiptIssuingPlaceLogId());
        model.setDocumentReceiptId(soapModel.getDocumentReceiptId());
        model.setProcessor(soapModel.getProcessor());
        model.setDirectProcessorId(soapModel.getDirectProcessorId());
        model.setDateProcess(soapModel.getDateProcess());
        model.setProcessInfomation(soapModel.getProcessInfomation());
        model.setReceiver(soapModel.getReceiver());
        model.setType_(soapModel.getType_());
        model.setStep(soapModel.getStep());

        return model;
    }

    public static List<PmlDocumentReceiptIssuingPlaceLog> toModels(
        PmlDocumentReceiptIssuingPlaceLogSoap[] soapModels) {
        List<PmlDocumentReceiptIssuingPlaceLog> models = new ArrayList<PmlDocumentReceiptIssuingPlaceLog>(soapModels.length);

        for (PmlDocumentReceiptIssuingPlaceLogSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentReceiptIssuingPlaceLogId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentReceiptIssuingPlaceLogId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentReceiptIssuingPlaceLogId);
    }

    public long getDocumentReceiptIssuingPlaceLogId() {
        return _documentReceiptIssuingPlaceLogId;
    }

    public void setDocumentReceiptIssuingPlaceLogId(
        long documentReceiptIssuingPlaceLogId) {
        if (documentReceiptIssuingPlaceLogId != _documentReceiptIssuingPlaceLogId) {
            _documentReceiptIssuingPlaceLogId = documentReceiptIssuingPlaceLogId;
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

    public long getProcessor() {
        return _processor;
    }

    public void setProcessor(long processor) {
        if (processor != _processor) {
            _processor = processor;
        }
    }

    public long getDirectProcessorId() {
        return _directProcessorId;
    }

    public void setDirectProcessorId(long directProcessorId) {
        if (directProcessorId != _directProcessorId) {
            _directProcessorId = directProcessorId;
        }
    }

    public Date getDateProcess() {
        return _dateProcess;
    }

    public void setDateProcess(Date dateProcess) {
        if (((dateProcess == null) && (_dateProcess != null)) ||
                ((dateProcess != null) && (_dateProcess == null)) ||
                ((dateProcess != null) && (_dateProcess != null) &&
                !dateProcess.equals(_dateProcess))) {
            _dateProcess = dateProcess;
        }
    }

    public String getProcessInfomation() {
        return GetterUtil.getString(_processInfomation);
    }

    public void setProcessInfomation(String processInfomation) {
        if (((processInfomation == null) && (_processInfomation != null)) ||
                ((processInfomation != null) && (_processInfomation == null)) ||
                ((processInfomation != null) && (_processInfomation != null) &&
                !processInfomation.equals(_processInfomation))) {
            _processInfomation = processInfomation;
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

    public int getType_() {
        return _type_;
    }

    public void setType_(int type_) {
        if (type_ != _type_) {
            _type_ = type_;
        }
    }

    public int getStep() {
        return _step;
    }

    public void setStep(int step) {
        if (step != _step) {
            _step = step;
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDocumentReceiptIssuingPlaceLog) this;
        } else {
            PmlDocumentReceiptIssuingPlaceLog model = new PmlDocumentReceiptIssuingPlaceLogImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentReceiptIssuingPlaceLogId(getDocumentReceiptIssuingPlaceLogId());
            model.setDocumentReceiptId(getDocumentReceiptId());
            model.setProcessor(getProcessor());
            model.setDirectProcessorId(getDirectProcessorId());
            model.setDateProcess(getDateProcess());
            model.setProcessInfomation(HtmlUtil.escape(getProcessInfomation()));
            model.setReceiver(HtmlUtil.escape(getReceiver()));
            model.setType_(getType_());
            model.setStep(getStep());

            model = (PmlDocumentReceiptIssuingPlaceLog) Proxy.newProxyInstance(PmlDocumentReceiptIssuingPlaceLog.class.getClassLoader(),
                    new Class[] { PmlDocumentReceiptIssuingPlaceLog.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDocumentReceiptIssuingPlaceLogImpl clone = new PmlDocumentReceiptIssuingPlaceLogImpl();

        clone.setDocumentReceiptIssuingPlaceLogId(getDocumentReceiptIssuingPlaceLogId());
        clone.setDocumentReceiptId(getDocumentReceiptId());
        clone.setProcessor(getProcessor());
        clone.setDirectProcessorId(getDirectProcessorId());
        clone.setDateProcess(getDateProcess());
        clone.setProcessInfomation(getProcessInfomation());
        clone.setReceiver(getReceiver());
        clone.setType_(getType_());
        clone.setStep(getStep());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDocumentReceiptIssuingPlaceLogImpl pmlDocumentReceiptIssuingPlaceLog = (PmlDocumentReceiptIssuingPlaceLogImpl) obj;

        long pk = pmlDocumentReceiptIssuingPlaceLog.getPrimaryKey();

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

        PmlDocumentReceiptIssuingPlaceLogImpl pmlDocumentReceiptIssuingPlaceLog = null;

        try {
            pmlDocumentReceiptIssuingPlaceLog = (PmlDocumentReceiptIssuingPlaceLogImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlDocumentReceiptIssuingPlaceLog.getPrimaryKey();

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
