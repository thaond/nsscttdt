package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordToSoap;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmBookDocumentRecordToModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmBookDocumentRecordTo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo
 * @see com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordToModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToImpl
 *
 */
public class PmlEdmBookDocumentRecordToModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_bookdocumentrecordto";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentreceiptid", new Integer(Types.BIGINT) },
            

            { "documentrecordtoid", new Integer(Types.BIGINT) },
            

            { "datecreate", new Integer(Types.TIMESTAMP) },
            

            { "datecomplete", new Integer(Types.TIMESTAMP) },
            

            { "soCongVanDenPhongHienTai", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_bookdocumentrecordto (documentreceiptid LONG not null,documentrecordtoid LONG not null,datecreate DATE null,datecomplete DATE null,soCongVanDenPhongHienTai INTEGER,primary key (documentreceiptid, documentrecordtoid))";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_bookdocumentrecordto";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo"));
    private long _documentReceiptId;
    private long _documentRecordToId;
    private Date _dateCreate;
    private Date _dateComplete;
    private int _soCongVanDenPhongHienTai;

    public PmlEdmBookDocumentRecordToModelImpl() {
    }

    public static PmlEdmBookDocumentRecordTo toModel(
        PmlEdmBookDocumentRecordToSoap soapModel) {
        PmlEdmBookDocumentRecordTo model = new PmlEdmBookDocumentRecordToImpl();

        model.setDocumentReceiptId(soapModel.getDocumentReceiptId());
        model.setDocumentRecordToId(soapModel.getDocumentRecordToId());
        model.setDateCreate(soapModel.getDateCreate());
        model.setDateComplete(soapModel.getDateComplete());
        model.setSoCongVanDenPhongHienTai(soapModel.getSoCongVanDenPhongHienTai());

        return model;
    }

    public static List<PmlEdmBookDocumentRecordTo> toModels(
        PmlEdmBookDocumentRecordToSoap[] soapModels) {
        List<PmlEdmBookDocumentRecordTo> models = new ArrayList<PmlEdmBookDocumentRecordTo>(soapModels.length);

        for (PmlEdmBookDocumentRecordToSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public PmlEdmBookDocumentRecordToPK getPrimaryKey() {
        return new PmlEdmBookDocumentRecordToPK(_documentReceiptId,
            _documentRecordToId);
    }

    public void setPrimaryKey(PmlEdmBookDocumentRecordToPK pk) {
        setDocumentReceiptId(pk.documentReceiptId);
        setDocumentRecordToId(pk.documentRecordToId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PmlEdmBookDocumentRecordToPK(_documentReceiptId,
            _documentRecordToId);
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        if (documentReceiptId != _documentReceiptId) {
            _documentReceiptId = documentReceiptId;
        }
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

    public Date getDateComplete() {
        return _dateComplete;
    }

    public void setDateComplete(Date dateComplete) {
        if (((dateComplete == null) && (_dateComplete != null)) ||
                ((dateComplete != null) && (_dateComplete == null)) ||
                ((dateComplete != null) && (_dateComplete != null) &&
                !dateComplete.equals(_dateComplete))) {
            _dateComplete = dateComplete;
        }
    }

    public int getSoCongVanDenPhongHienTai() {
        return _soCongVanDenPhongHienTai;
    }

    public void setSoCongVanDenPhongHienTai(int soCongVanDenPhongHienTai) {
        if (soCongVanDenPhongHienTai != _soCongVanDenPhongHienTai) {
            _soCongVanDenPhongHienTai = soCongVanDenPhongHienTai;
        }
    }

    public PmlEdmBookDocumentRecordTo toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmBookDocumentRecordTo) this;
        } else {
            PmlEdmBookDocumentRecordTo model = new PmlEdmBookDocumentRecordToImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentReceiptId(getDocumentReceiptId());
            model.setDocumentRecordToId(getDocumentRecordToId());
            model.setDateCreate(getDateCreate());
            model.setDateComplete(getDateComplete());
            model.setSoCongVanDenPhongHienTai(getSoCongVanDenPhongHienTai());

            model = (PmlEdmBookDocumentRecordTo) Proxy.newProxyInstance(PmlEdmBookDocumentRecordTo.class.getClassLoader(),
                    new Class[] { PmlEdmBookDocumentRecordTo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmBookDocumentRecordToImpl clone = new PmlEdmBookDocumentRecordToImpl();

        clone.setDocumentReceiptId(getDocumentReceiptId());
        clone.setDocumentRecordToId(getDocumentRecordToId());
        clone.setDateCreate(getDateCreate());
        clone.setDateComplete(getDateComplete());
        clone.setSoCongVanDenPhongHienTai(getSoCongVanDenPhongHienTai());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmBookDocumentRecordToImpl pmlEdmBookDocumentRecordTo = (PmlEdmBookDocumentRecordToImpl) obj;

        int value = 0;

        if (getDocumentReceiptId() < pmlEdmBookDocumentRecordTo.getDocumentReceiptId()) {
            value = -1;
        } else if (getDocumentReceiptId() > pmlEdmBookDocumentRecordTo.getDocumentReceiptId()) {
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

        PmlEdmBookDocumentRecordToImpl pmlEdmBookDocumentRecordTo = null;

        try {
            pmlEdmBookDocumentRecordTo = (PmlEdmBookDocumentRecordToImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PmlEdmBookDocumentRecordToPK pk = pmlEdmBookDocumentRecordTo.getPrimaryKey();

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
