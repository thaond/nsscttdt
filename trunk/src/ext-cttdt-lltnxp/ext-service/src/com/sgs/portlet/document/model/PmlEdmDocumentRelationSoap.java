package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmDocumentRelationSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlEdmDocumentRelationServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlEdmDocumentRelationServiceSoap
 *
 */
public class PmlEdmDocumentRelationSoap implements Serializable {
    private long _documentRelationId;
    private long _docLeftId;
    private long _docRightId;
    private boolean _leftIsReceipt;
    private boolean _rightIsReceipt;

    public PmlEdmDocumentRelationSoap() {
    }

    public static PmlEdmDocumentRelationSoap toSoapModel(
        PmlEdmDocumentRelation model) {
        PmlEdmDocumentRelationSoap soapModel = new PmlEdmDocumentRelationSoap();

        soapModel.setDocumentRelationId(model.getDocumentRelationId());
        soapModel.setDocLeftId(model.getDocLeftId());
        soapModel.setDocRightId(model.getDocRightId());
        soapModel.setLeftIsReceipt(model.getLeftIsReceipt());
        soapModel.setRightIsReceipt(model.getRightIsReceipt());

        return soapModel;
    }

    public static PmlEdmDocumentRelationSoap[] toSoapModels(
        List<PmlEdmDocumentRelation> models) {
        List<PmlEdmDocumentRelationSoap> soapModels = new ArrayList<PmlEdmDocumentRelationSoap>(models.size());

        for (PmlEdmDocumentRelation model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocumentRelationSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentRelationId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentRelationId(pk);
    }

    public long getDocumentRelationId() {
        return _documentRelationId;
    }

    public void setDocumentRelationId(long documentRelationId) {
        _documentRelationId = documentRelationId;
    }

    public long getDocLeftId() {
        return _docLeftId;
    }

    public void setDocLeftId(long docLeftId) {
        _docLeftId = docLeftId;
    }

    public long getDocRightId() {
        return _docRightId;
    }

    public void setDocRightId(long docRightId) {
        _docRightId = docRightId;
    }

    public boolean getLeftIsReceipt() {
        return _leftIsReceipt;
    }

    public boolean isLeftIsReceipt() {
        return _leftIsReceipt;
    }

    public void setLeftIsReceipt(boolean leftIsReceipt) {
        _leftIsReceipt = leftIsReceipt;
    }

    public boolean getRightIsReceipt() {
        return _rightIsReceipt;
    }

    public boolean isRightIsReceipt() {
        return _rightIsReceipt;
    }

    public void setRightIsReceipt(boolean rightIsReceipt) {
        _rightIsReceipt = rightIsReceipt;
    }
}
