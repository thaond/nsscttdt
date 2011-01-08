package com.sgs.portlet.onedoorpccc.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoorpccc.model.PmlPaintDocument;
import com.sgs.portlet.onedoorpccc.model.PmlPaintDocumentSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlPaintDocumentModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlPaintDocument</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.model.PmlPaintDocument
 * @see com.sgs.portlet.onedoorpccc.model.PmlPaintDocumentModel
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlPaintDocumentImpl
 *
 */
public class PmlPaintDocumentModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_paintdocument";
    public static final Object[][] TABLE_COLUMNS = {
            { "paintdocumentid", new Integer(Types.BIGINT) },
            

            { "fileid", new Integer(Types.VARCHAR) },
            

            { "paintdocumentname", new Integer(Types.VARCHAR) },
            

            { "quantity", new Integer(Types.INTEGER) },
            

            { "note", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_paintdocument (paintdocumentid LONG not null primary key,fileid VARCHAR(75) null,paintdocumentname VARCHAR(75) null,quantity INTEGER,note VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_paintdocument";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoorpccc.model.PmlPaintDocument"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoorpccc.model.PmlPaintDocument"));
    private long _paintDocumentId;
    private String _fileId;
    private String _paintDocumentName;
    private int _quantity;
    private String _note;

    public PmlPaintDocumentModelImpl() {
    }

    public static PmlPaintDocument toModel(PmlPaintDocumentSoap soapModel) {
        PmlPaintDocument model = new PmlPaintDocumentImpl();

        model.setPaintDocumentId(soapModel.getPaintDocumentId());
        model.setFileId(soapModel.getFileId());
        model.setPaintDocumentName(soapModel.getPaintDocumentName());
        model.setQuantity(soapModel.getQuantity());
        model.setNote(soapModel.getNote());

        return model;
    }

    public static List<PmlPaintDocument> toModels(
        PmlPaintDocumentSoap[] soapModels) {
        List<PmlPaintDocument> models = new ArrayList<PmlPaintDocument>(soapModels.length);

        for (PmlPaintDocumentSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _paintDocumentId;
    }

    public void setPrimaryKey(long pk) {
        setPaintDocumentId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_paintDocumentId);
    }

    public long getPaintDocumentId() {
        return _paintDocumentId;
    }

    public void setPaintDocumentId(long paintDocumentId) {
        if (paintDocumentId != _paintDocumentId) {
            _paintDocumentId = paintDocumentId;
        }
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        if (((fileId == null) && (_fileId != null)) ||
                ((fileId != null) && (_fileId == null)) ||
                ((fileId != null) && (_fileId != null) &&
                !fileId.equals(_fileId))) {
            _fileId = fileId;
        }
    }

    public String getPaintDocumentName() {
        return GetterUtil.getString(_paintDocumentName);
    }

    public void setPaintDocumentName(String paintDocumentName) {
        if (((paintDocumentName == null) && (_paintDocumentName != null)) ||
                ((paintDocumentName != null) && (_paintDocumentName == null)) ||
                ((paintDocumentName != null) && (_paintDocumentName != null) &&
                !paintDocumentName.equals(_paintDocumentName))) {
            _paintDocumentName = paintDocumentName;
        }
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity != _quantity) {
            _quantity = quantity;
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

    public PmlPaintDocument toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlPaintDocument) this;
        } else {
            PmlPaintDocument model = new PmlPaintDocumentImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setPaintDocumentId(getPaintDocumentId());
            model.setFileId(HtmlUtil.escape(getFileId()));
            model.setPaintDocumentName(HtmlUtil.escape(getPaintDocumentName()));
            model.setQuantity(getQuantity());
            model.setNote(HtmlUtil.escape(getNote()));

            model = (PmlPaintDocument) Proxy.newProxyInstance(PmlPaintDocument.class.getClassLoader(),
                    new Class[] { PmlPaintDocument.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlPaintDocumentImpl clone = new PmlPaintDocumentImpl();

        clone.setPaintDocumentId(getPaintDocumentId());
        clone.setFileId(getFileId());
        clone.setPaintDocumentName(getPaintDocumentName());
        clone.setQuantity(getQuantity());
        clone.setNote(getNote());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlPaintDocumentImpl pmlPaintDocument = (PmlPaintDocumentImpl) obj;

        int value = 0;

        if (getPaintDocumentId() < pmlPaintDocument.getPaintDocumentId()) {
            value = -1;
        } else if (getPaintDocumentId() > pmlPaintDocument.getPaintDocumentId()) {
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

        PmlPaintDocumentImpl pmlPaintDocument = null;

        try {
            pmlPaintDocument = (PmlPaintDocumentImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlPaintDocument.getPrimaryKey();

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
