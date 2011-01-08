package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmDocumentTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentTypeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentTypeServiceSoap
 *
 */
public class PmlEdmDocumentTypeSoap implements Serializable {
    private long _documentTypeId;
    private String _documentTypeName;
    private String _documentSymbol;
    private int _documentRecordTypeId;
    private int _sendReceiptDistinction;
    private boolean _HaveDepartExtends;

    public PmlEdmDocumentTypeSoap() {
    }

    public static PmlEdmDocumentTypeSoap toSoapModel(PmlEdmDocumentType model) {
        PmlEdmDocumentTypeSoap soapModel = new PmlEdmDocumentTypeSoap();

        soapModel.setDocumentTypeId(model.getDocumentTypeId());
        soapModel.setDocumentTypeName(model.getDocumentTypeName());
        soapModel.setDocumentSymbol(model.getDocumentSymbol());
        soapModel.setDocumentRecordTypeId(model.getDocumentRecordTypeId());
        soapModel.setSendReceiptDistinction(model.getSendReceiptDistinction());
        soapModel.setHaveDepartExtends(model.getHaveDepartExtends());

        return soapModel;
    }

    public static PmlEdmDocumentTypeSoap[] toSoapModels(
        List<PmlEdmDocumentType> models) {
        List<PmlEdmDocumentTypeSoap> soapModels = new ArrayList<PmlEdmDocumentTypeSoap>(models.size());

        for (PmlEdmDocumentType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocumentTypeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentTypeId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentTypeId(pk);
    }

    public long getDocumentTypeId() {
        return _documentTypeId;
    }

    public void setDocumentTypeId(long documentTypeId) {
        _documentTypeId = documentTypeId;
    }

    public String getDocumentTypeName() {
        return _documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        _documentTypeName = documentTypeName;
    }

    public String getDocumentSymbol() {
        return _documentSymbol;
    }

    public void setDocumentSymbol(String documentSymbol) {
        _documentSymbol = documentSymbol;
    }

    public int getDocumentRecordTypeId() {
        return _documentRecordTypeId;
    }

    public void setDocumentRecordTypeId(int documentRecordTypeId) {
        _documentRecordTypeId = documentRecordTypeId;
    }

    public int getSendReceiptDistinction() {
        return _sendReceiptDistinction;
    }

    public void setSendReceiptDistinction(int sendReceiptDistinction) {
        _sendReceiptDistinction = sendReceiptDistinction;
    }

    public boolean getHaveDepartExtends() {
        return _HaveDepartExtends;
    }

    public boolean isHaveDepartExtends() {
        return _HaveDepartExtends;
    }

    public void setHaveDepartExtends(boolean HaveDepartExtends) {
        _HaveDepartExtends = HaveDepartExtends;
    }
}
