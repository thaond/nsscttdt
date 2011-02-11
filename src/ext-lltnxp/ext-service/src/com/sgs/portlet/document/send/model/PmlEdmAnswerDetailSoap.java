package com.sgs.portlet.document.send.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmAnswerDetailSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmAnswerDetailServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmAnswerDetailServiceSoap
 *
 */
public class PmlEdmAnswerDetailSoap implements Serializable {
    private long _documentReceiptId;
    private long _documentSendId;

    public PmlEdmAnswerDetailSoap() {
    }

    public static PmlEdmAnswerDetailSoap toSoapModel(PmlEdmAnswerDetail model) {
        PmlEdmAnswerDetailSoap soapModel = new PmlEdmAnswerDetailSoap();

        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setDocumentSendId(model.getDocumentSendId());

        return soapModel;
    }

    public static PmlEdmAnswerDetailSoap[] toSoapModels(
        List<PmlEdmAnswerDetail> models) {
        List<PmlEdmAnswerDetailSoap> soapModels = new ArrayList<PmlEdmAnswerDetailSoap>(models.size());

        for (PmlEdmAnswerDetail model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmAnswerDetailSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentReceiptId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentReceiptId(pk);
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public long getDocumentSendId() {
        return _documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        _documentSendId = documentSendId;
    }
}
