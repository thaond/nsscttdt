package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.onedoor.model.PmlPaintDocument;
import com.nss.portlet.onedoor.model.PmlPaintDocumentSoap;

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
 * @see com.nss.portlet.onedoor.model.PmlPaintDocument
 * @see com.nss.portlet.onedoor.model.PmlPaintDocumentModel
 * @see com.nss.portlet.onedoor.model.impl.PmlPaintDocumentImpl
 *
 */
public class PmlPaintDocumentModelImpl extends BaseModelImpl<PmlPaintDocument> {
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
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlPaintDocument"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlPaintDocument"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlPaintDocument"));
    private long _paintDocumentId;
    private String _fileId;
    private String _paintDocumentName;
    private int _quantity;
    private String _note;
    private transient ExpandoBridge _expandoBridge;

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
        _paintDocumentId = paintDocumentId;
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public String getPaintDocumentName() {
        return GetterUtil.getString(_paintDocumentName);
    }

    public void setPaintDocumentName(String paintDocumentName) {
        _paintDocumentName = paintDocumentName;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        _quantity = quantity;
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        _note = note;
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

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlPaintDocument.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
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

    public int compareTo(PmlPaintDocument pmlPaintDocument) {
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

        PmlPaintDocument pmlPaintDocument = null;

        try {
            pmlPaintDocument = (PmlPaintDocument) obj;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{paintDocumentId=");
        sb.append(getPaintDocumentId());
        sb.append(", fileId=");
        sb.append(getFileId());
        sb.append(", paintDocumentName=");
        sb.append(getPaintDocumentName());
        sb.append(", quantity=");
        sb.append(getQuantity());
        sb.append(", note=");
        sb.append(getNote());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlPaintDocument");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>paintDocumentId</column-name><column-value><![CDATA[");
        sb.append(getPaintDocumentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileId</column-name><column-value><![CDATA[");
        sb.append(getFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>paintDocumentName</column-name><column-value><![CDATA[");
        sb.append(getPaintDocumentName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quantity</column-name><column-value><![CDATA[");
        sb.append(getQuantity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>note</column-name><column-value><![CDATA[");
        sb.append(getNote());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
