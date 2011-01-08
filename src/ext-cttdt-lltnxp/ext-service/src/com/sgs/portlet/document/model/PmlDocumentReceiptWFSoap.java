package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDocumentReceiptWFSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlDocumentReceiptWFServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlDocumentReceiptWFServiceSoap
 *
 */
public class PmlDocumentReceiptWFSoap implements Serializable {
    private long _processId;
    private long _documentReceiptId;
    private String _isMain;

    public PmlDocumentReceiptWFSoap() {
    }

    public static PmlDocumentReceiptWFSoap toSoapModel(
        PmlDocumentReceiptWF model) {
        PmlDocumentReceiptWFSoap soapModel = new PmlDocumentReceiptWFSoap();

        soapModel.setProcessId(model.getProcessId());
        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setIsMain(model.getIsMain());

        return soapModel;
    }

    public static PmlDocumentReceiptWFSoap[] toSoapModels(
        List<PmlDocumentReceiptWF> models) {
        List<PmlDocumentReceiptWFSoap> soapModels = new ArrayList<PmlDocumentReceiptWFSoap>(models.size());

        for (PmlDocumentReceiptWF model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDocumentReceiptWFSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _processId;
    }

    public void setPrimaryKey(long pk) {
        setProcessId(pk);
    }

    public long getProcessId() {
        return _processId;
    }

    public void setProcessId(long processId) {
        _processId = processId;
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public String getIsMain() {
        return _isMain;
    }

    public void setIsMain(String isMain) {
        _isMain = isMain;
    }
}
