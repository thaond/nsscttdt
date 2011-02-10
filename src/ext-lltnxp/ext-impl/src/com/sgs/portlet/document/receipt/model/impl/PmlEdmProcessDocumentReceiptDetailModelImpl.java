package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail;
import com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetailSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmProcessDocumentReceiptDetailModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmProcessDocumentReceiptDetail</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail
 * @see com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetailModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmProcessDocumentReceiptDetailImpl
 *
 */
public class PmlEdmProcessDocumentReceiptDetailModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_processdocumentreceiptdetail";
    public static final Object[][] TABLE_COLUMNS = {
            { "id", new Integer(Types.BIGINT) },
            

            { "documentreceiptid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) },
            

            { "note", new Integer(Types.VARCHAR) },
            

            { "datecreated", new Integer(Types.TIMESTAMP) },
            

            { "dateupdate", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_processdocumentreceiptdetail (id LONG not null primary key,documentreceiptid LONG,userid LONG,note VARCHAR(75) null,datecreated DATE null,dateupdate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_processdocumentreceiptdetail";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail"));
    private long _id;
    private long _documentReceiptId;
    private long _userId;
    private String _note;
    private Date _dateCreated;
    private Date _dateUpdate;

    public PmlEdmProcessDocumentReceiptDetailModelImpl() {
    }

    public static PmlEdmProcessDocumentReceiptDetail toModel(
        PmlEdmProcessDocumentReceiptDetailSoap soapModel) {
        PmlEdmProcessDocumentReceiptDetail model = new PmlEdmProcessDocumentReceiptDetailImpl();

        model.setId(soapModel.getId());
        model.setDocumentReceiptId(soapModel.getDocumentReceiptId());
        model.setUserId(soapModel.getUserId());
        model.setNote(soapModel.getNote());
        model.setDateCreated(soapModel.getDateCreated());
        model.setDateUpdate(soapModel.getDateUpdate());

        return model;
    }

    public static List<PmlEdmProcessDocumentReceiptDetail> toModels(
        PmlEdmProcessDocumentReceiptDetailSoap[] soapModels) {
        List<PmlEdmProcessDocumentReceiptDetail> models = new ArrayList<PmlEdmProcessDocumentReceiptDetail>(soapModels.length);

        for (PmlEdmProcessDocumentReceiptDetailSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        if (id != _id) {
            _id = id;
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

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        if (((note == null) && (_note != null)) ||
                ((note != null) && (_note == null)) ||
                ((note != null) && (_note != null) && !note.equals(_note))) {
            _note = note;
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

    public Date getDateUpdate() {
        return _dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        if (((dateUpdate == null) && (_dateUpdate != null)) ||
                ((dateUpdate != null) && (_dateUpdate == null)) ||
                ((dateUpdate != null) && (_dateUpdate != null) &&
                !dateUpdate.equals(_dateUpdate))) {
            _dateUpdate = dateUpdate;
        }
    }

    public PmlEdmProcessDocumentReceiptDetail toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmProcessDocumentReceiptDetail) this;
        } else {
            PmlEdmProcessDocumentReceiptDetail model = new PmlEdmProcessDocumentReceiptDetailImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setId(getId());
            model.setDocumentReceiptId(getDocumentReceiptId());
            model.setUserId(getUserId());
            model.setNote(HtmlUtil.escape(getNote()));
            model.setDateCreated(getDateCreated());
            model.setDateUpdate(getDateUpdate());

            model = (PmlEdmProcessDocumentReceiptDetail) Proxy.newProxyInstance(PmlEdmProcessDocumentReceiptDetail.class.getClassLoader(),
                    new Class[] { PmlEdmProcessDocumentReceiptDetail.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmProcessDocumentReceiptDetailImpl clone = new PmlEdmProcessDocumentReceiptDetailImpl();

        clone.setId(getId());
        clone.setDocumentReceiptId(getDocumentReceiptId());
        clone.setUserId(getUserId());
        clone.setNote(getNote());
        clone.setDateCreated(getDateCreated());
        clone.setDateUpdate(getDateUpdate());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmProcessDocumentReceiptDetailImpl pmlEdmProcessDocumentReceiptDetail =
            (PmlEdmProcessDocumentReceiptDetailImpl) obj;

        long pk = pmlEdmProcessDocumentReceiptDetail.getPrimaryKey();

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

        PmlEdmProcessDocumentReceiptDetailImpl pmlEdmProcessDocumentReceiptDetail =
            null;

        try {
            pmlEdmProcessDocumentReceiptDetail = (PmlEdmProcessDocumentReceiptDetailImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmProcessDocumentReceiptDetail.getPrimaryKey();

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
