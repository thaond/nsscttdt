package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTypeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmDocumentRecordTypeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocumentRecordType</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType
 * @see com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTypeModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeImpl
 *
 */
public class PmlEdmDocumentRecordTypeModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documentrecordtype";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentrecordtypeid", new Integer(Types.INTEGER) },
            

            { "documentrecordtypename", new Integer(Types.VARCHAR) },
            

            { "documentrecordtypecode", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documentrecordtype (documentrecordtypeid INTEGER not null primary key,documentrecordtypename VARCHAR(75) null,documentrecordtypecode VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documentrecordtype";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"));
    private int _documentRecordTypeId;
    private String _documentRecordTypeName;
    private String _documentRecordTypeCode;

    public PmlEdmDocumentRecordTypeModelImpl() {
    }

    public static PmlEdmDocumentRecordType toModel(
        PmlEdmDocumentRecordTypeSoap soapModel) {
        PmlEdmDocumentRecordType model = new PmlEdmDocumentRecordTypeImpl();

        model.setDocumentRecordTypeId(soapModel.getDocumentRecordTypeId());
        model.setDocumentRecordTypeName(soapModel.getDocumentRecordTypeName());
        model.setDocumentRecordTypeCode(soapModel.getDocumentRecordTypeCode());

        return model;
    }

    public static List<PmlEdmDocumentRecordType> toModels(
        PmlEdmDocumentRecordTypeSoap[] soapModels) {
        List<PmlEdmDocumentRecordType> models = new ArrayList<PmlEdmDocumentRecordType>(soapModels.length);

        for (PmlEdmDocumentRecordTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public int getPrimaryKey() {
        return _documentRecordTypeId;
    }

    public void setPrimaryKey(int pk) {
        setDocumentRecordTypeId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Integer(_documentRecordTypeId);
    }

    public int getDocumentRecordTypeId() {
        return _documentRecordTypeId;
    }

    public void setDocumentRecordTypeId(int documentRecordTypeId) {
        if (documentRecordTypeId != _documentRecordTypeId) {
            _documentRecordTypeId = documentRecordTypeId;
        }
    }

    public String getDocumentRecordTypeName() {
        return GetterUtil.getString(_documentRecordTypeName);
    }

    public void setDocumentRecordTypeName(String documentRecordTypeName) {
        if (((documentRecordTypeName == null) &&
                (_documentRecordTypeName != null)) ||
                ((documentRecordTypeName != null) &&
                (_documentRecordTypeName == null)) ||
                ((documentRecordTypeName != null) &&
                (_documentRecordTypeName != null) &&
                !documentRecordTypeName.equals(_documentRecordTypeName))) {
            _documentRecordTypeName = documentRecordTypeName;
        }
    }

    public String getDocumentRecordTypeCode() {
        return GetterUtil.getString(_documentRecordTypeCode);
    }

    public void setDocumentRecordTypeCode(String documentRecordTypeCode) {
        if (((documentRecordTypeCode == null) &&
                (_documentRecordTypeCode != null)) ||
                ((documentRecordTypeCode != null) &&
                (_documentRecordTypeCode == null)) ||
                ((documentRecordTypeCode != null) &&
                (_documentRecordTypeCode != null) &&
                !documentRecordTypeCode.equals(_documentRecordTypeCode))) {
            _documentRecordTypeCode = documentRecordTypeCode;
        }
    }

    public PmlEdmDocumentRecordType toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocumentRecordType) this;
        } else {
            PmlEdmDocumentRecordType model = new PmlEdmDocumentRecordTypeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentRecordTypeId(getDocumentRecordTypeId());
            model.setDocumentRecordTypeName(HtmlUtil.escape(
                    getDocumentRecordTypeName()));
            model.setDocumentRecordTypeCode(HtmlUtil.escape(
                    getDocumentRecordTypeCode()));

            model = (PmlEdmDocumentRecordType) Proxy.newProxyInstance(PmlEdmDocumentRecordType.class.getClassLoader(),
                    new Class[] { PmlEdmDocumentRecordType.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocumentRecordTypeImpl clone = new PmlEdmDocumentRecordTypeImpl();

        clone.setDocumentRecordTypeId(getDocumentRecordTypeId());
        clone.setDocumentRecordTypeName(getDocumentRecordTypeName());
        clone.setDocumentRecordTypeCode(getDocumentRecordTypeCode());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmDocumentRecordTypeImpl pmlEdmDocumentRecordType = (PmlEdmDocumentRecordTypeImpl) obj;

        int value = 0;

        value = getDocumentRecordTypeName().toLowerCase()
                    .compareTo(pmlEdmDocumentRecordType.getDocumentRecordTypeName()
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

        PmlEdmDocumentRecordTypeImpl pmlEdmDocumentRecordType = null;

        try {
            pmlEdmDocumentRecordType = (PmlEdmDocumentRecordTypeImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        int pk = pmlEdmDocumentRecordType.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey();
    }
}
