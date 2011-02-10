package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlEdmDocumentRelation;
import com.sgs.portlet.document.model.PmlEdmDocumentRelationSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmDocumentRelationModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocumentRelation</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlEdmDocumentRelation
 * @see com.sgs.portlet.document.model.PmlEdmDocumentRelationModel
 * @see com.sgs.portlet.document.model.impl.PmlEdmDocumentRelationImpl
 *
 */
public class PmlEdmDocumentRelationModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_documentrelation";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentrelationid", new Integer(Types.BIGINT) },
            

            { "docleftid", new Integer(Types.BIGINT) },
            

            { "docrightid", new Integer(Types.BIGINT) },
            

            { "leftisreceipt", new Integer(Types.BOOLEAN) },
            

            { "rightisreceipt", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_documentrelation (documentrelationid LONG not null primary key,docleftid LONG,docrightid LONG,leftisreceipt BOOLEAN,rightisreceipt BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_documentrelation";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlEdmDocumentRelation"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlEdmDocumentRelation"));
    private long _documentRelationId;
    private long _docLeftId;
    private long _docRightId;
    private boolean _leftIsReceipt;
    private boolean _rightIsReceipt;

    public PmlEdmDocumentRelationModelImpl() {
    }

    public static PmlEdmDocumentRelation toModel(
        PmlEdmDocumentRelationSoap soapModel) {
        PmlEdmDocumentRelation model = new PmlEdmDocumentRelationImpl();

        model.setDocumentRelationId(soapModel.getDocumentRelationId());
        model.setDocLeftId(soapModel.getDocLeftId());
        model.setDocRightId(soapModel.getDocRightId());
        model.setLeftIsReceipt(soapModel.getLeftIsReceipt());
        model.setRightIsReceipt(soapModel.getRightIsReceipt());

        return model;
    }

    public static List<PmlEdmDocumentRelation> toModels(
        PmlEdmDocumentRelationSoap[] soapModels) {
        List<PmlEdmDocumentRelation> models = new ArrayList<PmlEdmDocumentRelation>(soapModels.length);

        for (PmlEdmDocumentRelationSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentRelationId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentRelationId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentRelationId);
    }

    public long getDocumentRelationId() {
        return _documentRelationId;
    }

    public void setDocumentRelationId(long documentRelationId) {
        if (documentRelationId != _documentRelationId) {
            _documentRelationId = documentRelationId;
        }
    }

    public long getDocLeftId() {
        return _docLeftId;
    }

    public void setDocLeftId(long docLeftId) {
        if (docLeftId != _docLeftId) {
            _docLeftId = docLeftId;
        }
    }

    public long getDocRightId() {
        return _docRightId;
    }

    public void setDocRightId(long docRightId) {
        if (docRightId != _docRightId) {
            _docRightId = docRightId;
        }
    }

    public boolean getLeftIsReceipt() {
        return _leftIsReceipt;
    }

    public boolean isLeftIsReceipt() {
        return _leftIsReceipt;
    }

    public void setLeftIsReceipt(boolean leftIsReceipt) {
        if (leftIsReceipt != _leftIsReceipt) {
            _leftIsReceipt = leftIsReceipt;
        }
    }

    public boolean getRightIsReceipt() {
        return _rightIsReceipt;
    }

    public boolean isRightIsReceipt() {
        return _rightIsReceipt;
    }

    public void setRightIsReceipt(boolean rightIsReceipt) {
        if (rightIsReceipt != _rightIsReceipt) {
            _rightIsReceipt = rightIsReceipt;
        }
    }

    public PmlEdmDocumentRelation toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocumentRelation) this;
        } else {
            PmlEdmDocumentRelation model = new PmlEdmDocumentRelationImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentRelationId(getDocumentRelationId());
            model.setDocLeftId(getDocLeftId());
            model.setDocRightId(getDocRightId());
            model.setLeftIsReceipt(getLeftIsReceipt());
            model.setRightIsReceipt(getRightIsReceipt());

            model = (PmlEdmDocumentRelation) Proxy.newProxyInstance(PmlEdmDocumentRelation.class.getClassLoader(),
                    new Class[] { PmlEdmDocumentRelation.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocumentRelationImpl clone = new PmlEdmDocumentRelationImpl();

        clone.setDocumentRelationId(getDocumentRelationId());
        clone.setDocLeftId(getDocLeftId());
        clone.setDocRightId(getDocRightId());
        clone.setLeftIsReceipt(getLeftIsReceipt());
        clone.setRightIsReceipt(getRightIsReceipt());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmDocumentRelationImpl pmlEdmDocumentRelation = (PmlEdmDocumentRelationImpl) obj;

        long pk = pmlEdmDocumentRelation.getPrimaryKey();

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

        PmlEdmDocumentRelationImpl pmlEdmDocumentRelation = null;

        try {
            pmlEdmDocumentRelation = (PmlEdmDocumentRelationImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmDocumentRelation.getPrimaryKey();

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
