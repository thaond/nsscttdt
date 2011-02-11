package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmDocumentRecordTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentRecordTypeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentRecordTypeServiceSoap
 *
 */
public class PmlEdmDocumentRecordTypeSoap implements Serializable {
    private int _documentRecordTypeId;
    private String _documentRecordTypeName;
    private String _documentRecordTypeCode;

    public PmlEdmDocumentRecordTypeSoap() {
    }

    public static PmlEdmDocumentRecordTypeSoap toSoapModel(
        PmlEdmDocumentRecordType model) {
        PmlEdmDocumentRecordTypeSoap soapModel = new PmlEdmDocumentRecordTypeSoap();

        soapModel.setDocumentRecordTypeId(model.getDocumentRecordTypeId());
        soapModel.setDocumentRecordTypeName(model.getDocumentRecordTypeName());
        soapModel.setDocumentRecordTypeCode(model.getDocumentRecordTypeCode());

        return soapModel;
    }

    public static PmlEdmDocumentRecordTypeSoap[] toSoapModels(
        List<PmlEdmDocumentRecordType> models) {
        List<PmlEdmDocumentRecordTypeSoap> soapModels = new ArrayList<PmlEdmDocumentRecordTypeSoap>(models.size());

        for (PmlEdmDocumentRecordType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocumentRecordTypeSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _documentRecordTypeId;
    }

    public void setPrimaryKey(int pk) {
        setDocumentRecordTypeId(pk);
    }

    public int getDocumentRecordTypeId() {
        return _documentRecordTypeId;
    }

    public void setDocumentRecordTypeId(int documentRecordTypeId) {
        _documentRecordTypeId = documentRecordTypeId;
    }

    public String getDocumentRecordTypeName() {
        return _documentRecordTypeName;
    }

    public void setDocumentRecordTypeName(String documentRecordTypeName) {
        _documentRecordTypeName = documentRecordTypeName;
    }

    public String getDocumentRecordTypeCode() {
        return _documentRecordTypeCode;
    }

    public void setDocumentRecordTypeCode(String documentRecordTypeCode) {
        _documentRecordTypeCode = documentRecordTypeCode;
    }
}
