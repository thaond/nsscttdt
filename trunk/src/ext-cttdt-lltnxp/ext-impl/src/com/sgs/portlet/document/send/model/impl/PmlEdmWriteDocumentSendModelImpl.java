package com.sgs.portlet.document.send.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSendSoap;
import com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmWriteDocumentSendModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmWriteDocumentSend</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend
 * @see com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSendModel
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl
 *
 */
public class PmlEdmWriteDocumentSendModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_writedocumentsend";
    public static final Object[][] TABLE_COLUMNS = {
            { "bookdocumentsendid", new Integer(Types.BIGINT) },
            

            { "documentsendid", new Integer(Types.BIGINT) },
            

            { "datecreated", new Integer(Types.TIMESTAMP) },
            

            { "soCongVanDiPhongHienTai", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_writedocumentsend (bookdocumentsendid LONG not null,documentsendid LONG not null,datecreated DATE null,soCongVanDiPhongHienTai INTEGER,primary key (bookdocumentsendid, documentsendid))";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_writedocumentsend";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend"));
    private long _bookDocumentSendId;
    private long _documentSendId;
    private Date _dateCreated;
    private int _soCongVanDiPhongHienTai;

    public PmlEdmWriteDocumentSendModelImpl() {
    }

    public static PmlEdmWriteDocumentSend toModel(
        PmlEdmWriteDocumentSendSoap soapModel) {
        PmlEdmWriteDocumentSend model = new PmlEdmWriteDocumentSendImpl();

        model.setBookDocumentSendId(soapModel.getBookDocumentSendId());
        model.setDocumentSendId(soapModel.getDocumentSendId());
        model.setDateCreated(soapModel.getDateCreated());
        model.setSoCongVanDiPhongHienTai(soapModel.getSoCongVanDiPhongHienTai());

        return model;
    }

    public static List<PmlEdmWriteDocumentSend> toModels(
        PmlEdmWriteDocumentSendSoap[] soapModels) {
        List<PmlEdmWriteDocumentSend> models = new ArrayList<PmlEdmWriteDocumentSend>(soapModels.length);

        for (PmlEdmWriteDocumentSendSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public PmlEdmWriteDocumentSendPK getPrimaryKey() {
        return new PmlEdmWriteDocumentSendPK(_bookDocumentSendId,
            _documentSendId);
    }

    public void setPrimaryKey(PmlEdmWriteDocumentSendPK pk) {
        setBookDocumentSendId(pk.bookDocumentSendId);
        setDocumentSendId(pk.documentSendId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PmlEdmWriteDocumentSendPK(_bookDocumentSendId,
            _documentSendId);
    }

    public long getBookDocumentSendId() {
        return _bookDocumentSendId;
    }

    public void setBookDocumentSendId(long bookDocumentSendId) {
        if (bookDocumentSendId != _bookDocumentSendId) {
            _bookDocumentSendId = bookDocumentSendId;
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

    public int getSoCongVanDiPhongHienTai() {
        return _soCongVanDiPhongHienTai;
    }

    public void setSoCongVanDiPhongHienTai(int soCongVanDiPhongHienTai) {
        if (soCongVanDiPhongHienTai != _soCongVanDiPhongHienTai) {
            _soCongVanDiPhongHienTai = soCongVanDiPhongHienTai;
        }
    }

    public PmlEdmWriteDocumentSend toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmWriteDocumentSend) this;
        } else {
            PmlEdmWriteDocumentSend model = new PmlEdmWriteDocumentSendImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setBookDocumentSendId(getBookDocumentSendId());
            model.setDocumentSendId(getDocumentSendId());
            model.setDateCreated(getDateCreated());
            model.setSoCongVanDiPhongHienTai(getSoCongVanDiPhongHienTai());

            model = (PmlEdmWriteDocumentSend) Proxy.newProxyInstance(PmlEdmWriteDocumentSend.class.getClassLoader(),
                    new Class[] { PmlEdmWriteDocumentSend.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmWriteDocumentSendImpl clone = new PmlEdmWriteDocumentSendImpl();

        clone.setBookDocumentSendId(getBookDocumentSendId());
        clone.setDocumentSendId(getDocumentSendId());
        clone.setDateCreated(getDateCreated());
        clone.setSoCongVanDiPhongHienTai(getSoCongVanDiPhongHienTai());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmWriteDocumentSendImpl pmlEdmWriteDocumentSend = (PmlEdmWriteDocumentSendImpl) obj;

        int value = 0;

        if (getBookDocumentSendId() < pmlEdmWriteDocumentSend.getBookDocumentSendId()) {
            value = -1;
        } else if (getBookDocumentSendId() > pmlEdmWriteDocumentSend.getBookDocumentSendId()) {
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

        PmlEdmWriteDocumentSendImpl pmlEdmWriteDocumentSend = null;

        try {
            pmlEdmWriteDocumentSend = (PmlEdmWriteDocumentSendImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PmlEdmWriteDocumentSendPK pk = pmlEdmWriteDocumentSend.getPrimaryKey();

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
