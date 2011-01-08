package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentTypeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmDocumentTypeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocumentType</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentType
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentTypeModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentTypeImpl
 *
 */
public class PmlEdmDocumentTypeModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documenttype";
    public static final Object[][] TABLE_COLUMNS = {
            { "documenttypeid", new Integer(Types.BIGINT) },
            

            { "documenttypename", new Integer(Types.VARCHAR) },
            

            { "documentsymbol", new Integer(Types.VARCHAR) },
            

            { "documentrecordtypeid", new Integer(Types.INTEGER) },
            

            { "sendreceiptdistinction", new Integer(Types.INTEGER) },
            

            { "HaveDepartExtends", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documenttype (documenttypeid LONG not null primary key,documenttypename VARCHAR(75) null,documentsymbol VARCHAR(75) null,documentrecordtypeid INTEGER,sendreceiptdistinction INTEGER,HaveDepartExtends BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documenttype";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"));
    private long _documentTypeId;
    private String _documentTypeName;
    private String _documentSymbol;
    private int _documentRecordTypeId;
    private int _sendReceiptDistinction;
    private boolean _HaveDepartExtends;

    public PmlEdmDocumentTypeModelImpl() {
    }

    public static PmlEdmDocumentType toModel(PmlEdmDocumentTypeSoap soapModel) {
        PmlEdmDocumentType model = new PmlEdmDocumentTypeImpl();

        model.setDocumentTypeId(soapModel.getDocumentTypeId());
        model.setDocumentTypeName(soapModel.getDocumentTypeName());
        model.setDocumentSymbol(soapModel.getDocumentSymbol());
        model.setDocumentRecordTypeId(soapModel.getDocumentRecordTypeId());
        model.setSendReceiptDistinction(soapModel.getSendReceiptDistinction());
        model.setHaveDepartExtends(soapModel.getHaveDepartExtends());

        return model;
    }

    public static List<PmlEdmDocumentType> toModels(
        PmlEdmDocumentTypeSoap[] soapModels) {
        List<PmlEdmDocumentType> models = new ArrayList<PmlEdmDocumentType>(soapModels.length);

        for (PmlEdmDocumentTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentTypeId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentTypeId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentTypeId);
    }

    public long getDocumentTypeId() {
        return _documentTypeId;
    }

    public void setDocumentTypeId(long documentTypeId) {
        if (documentTypeId != _documentTypeId) {
            _documentTypeId = documentTypeId;
        }
    }

    public String getDocumentTypeName() {
        return GetterUtil.getString(_documentTypeName);
    }

    public void setDocumentTypeName(String documentTypeName) {
        if (((documentTypeName == null) && (_documentTypeName != null)) ||
                ((documentTypeName != null) && (_documentTypeName == null)) ||
                ((documentTypeName != null) && (_documentTypeName != null) &&
                !documentTypeName.equals(_documentTypeName))) {
            _documentTypeName = documentTypeName;
        }
    }

    public String getDocumentSymbol() {
        return GetterUtil.getString(_documentSymbol);
    }

    public void setDocumentSymbol(String documentSymbol) {
        if (((documentSymbol == null) && (_documentSymbol != null)) ||
                ((documentSymbol != null) && (_documentSymbol == null)) ||
                ((documentSymbol != null) && (_documentSymbol != null) &&
                !documentSymbol.equals(_documentSymbol))) {
            _documentSymbol = documentSymbol;
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

    public int getSendReceiptDistinction() {
        return _sendReceiptDistinction;
    }

    public void setSendReceiptDistinction(int sendReceiptDistinction) {
        if (sendReceiptDistinction != _sendReceiptDistinction) {
            _sendReceiptDistinction = sendReceiptDistinction;
        }
    }

    public boolean getHaveDepartExtends() {
        return _HaveDepartExtends;
    }

    public boolean isHaveDepartExtends() {
        return _HaveDepartExtends;
    }

    public void setHaveDepartExtends(boolean HaveDepartExtends) {
        if (HaveDepartExtends != _HaveDepartExtends) {
            _HaveDepartExtends = HaveDepartExtends;
        }
    }

    public PmlEdmDocumentType toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocumentType) this;
        } else {
            PmlEdmDocumentType model = new PmlEdmDocumentTypeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentTypeId(getDocumentTypeId());
            model.setDocumentTypeName(HtmlUtil.escape(getDocumentTypeName()));
            model.setDocumentSymbol(HtmlUtil.escape(getDocumentSymbol()));
            model.setDocumentRecordTypeId(getDocumentRecordTypeId());
            model.setSendReceiptDistinction(getSendReceiptDistinction());
            model.setHaveDepartExtends(getHaveDepartExtends());

            model = (PmlEdmDocumentType) Proxy.newProxyInstance(PmlEdmDocumentType.class.getClassLoader(),
                    new Class[] { PmlEdmDocumentType.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocumentTypeImpl clone = new PmlEdmDocumentTypeImpl();

        clone.setDocumentTypeId(getDocumentTypeId());
        clone.setDocumentTypeName(getDocumentTypeName());
        clone.setDocumentSymbol(getDocumentSymbol());
        clone.setDocumentRecordTypeId(getDocumentRecordTypeId());
        clone.setSendReceiptDistinction(getSendReceiptDistinction());
        clone.setHaveDepartExtends(getHaveDepartExtends());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmDocumentTypeImpl pmlEdmDocumentType = (PmlEdmDocumentTypeImpl) obj;

        int value = 0;

        value = getDocumentTypeName().toLowerCase()
                    .compareTo(pmlEdmDocumentType.getDocumentTypeName()
                                                 .toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlEdmDocumentTypeImpl pmlEdmDocumentType = null;

        try {
            pmlEdmDocumentType = (PmlEdmDocumentTypeImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmDocumentType.getPrimaryKey();

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
