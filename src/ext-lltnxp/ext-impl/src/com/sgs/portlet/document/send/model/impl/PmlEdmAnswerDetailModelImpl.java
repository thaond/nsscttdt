package com.sgs.portlet.document.send.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetailSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmAnswerDetailModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmAnswerDetail</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmAnswerDetail
 * @see com.sgs.portlet.document.send.model.PmlEdmAnswerDetailModel
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmAnswerDetailImpl
 *
 */
public class PmlEdmAnswerDetailModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_answerdetail";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentreceiptid", new Integer(Types.BIGINT) },
            

            { "documentsendid", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_answerdetail (documentreceiptid LONG not null primary key,documentsendid LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_answerdetail";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.send.model.PmlEdmAnswerDetail"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.send.model.PmlEdmAnswerDetail"));
    private long _documentReceiptId;
    private long _documentSendId;

    public PmlEdmAnswerDetailModelImpl() {
    }

    public static PmlEdmAnswerDetail toModel(PmlEdmAnswerDetailSoap soapModel) {
        PmlEdmAnswerDetail model = new PmlEdmAnswerDetailImpl();

        model.setDocumentReceiptId(soapModel.getDocumentReceiptId());
        model.setDocumentSendId(soapModel.getDocumentSendId());

        return model;
    }

    public static List<PmlEdmAnswerDetail> toModels(
        PmlEdmAnswerDetailSoap[] soapModels) {
        List<PmlEdmAnswerDetail> models = new ArrayList<PmlEdmAnswerDetail>(soapModels.length);

        for (PmlEdmAnswerDetailSoap soapModel : soapModels) {
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

    public long getDocumentSendId() {
        return _documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        if (documentSendId != _documentSendId) {
            _documentSendId = documentSendId;
        }
    }

    public PmlEdmAnswerDetail toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmAnswerDetail) this;
        } else {
            PmlEdmAnswerDetail model = new PmlEdmAnswerDetailImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentReceiptId(getDocumentReceiptId());
            model.setDocumentSendId(getDocumentSendId());

            model = (PmlEdmAnswerDetail) Proxy.newProxyInstance(PmlEdmAnswerDetail.class.getClassLoader(),
                    new Class[] { PmlEdmAnswerDetail.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmAnswerDetailImpl clone = new PmlEdmAnswerDetailImpl();

        clone.setDocumentReceiptId(getDocumentReceiptId());
        clone.setDocumentSendId(getDocumentSendId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmAnswerDetailImpl pmlEdmAnswerDetail = (PmlEdmAnswerDetailImpl) obj;

        long pk = pmlEdmAnswerDetail.getPrimaryKey();

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

        PmlEdmAnswerDetailImpl pmlEdmAnswerDetail = null;

        try {
            pmlEdmAnswerDetail = (PmlEdmAnswerDetailImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmAnswerDetail.getPrimaryKey();

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
