package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDocumentSendWFSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlDocumentSendWFServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlDocumentSendWFServiceSoap
 *
 */
public class PmlDocumentSendWFSoap implements Serializable {
    private long _documentSendId;
    private long _processId;
    private String _isMain;

    public PmlDocumentSendWFSoap() {
    }

    public static PmlDocumentSendWFSoap toSoapModel(PmlDocumentSendWF model) {
        PmlDocumentSendWFSoap soapModel = new PmlDocumentSendWFSoap();

        soapModel.setDocumentSendId(model.getDocumentSendId());
        soapModel.setProcessId(model.getProcessId());
        soapModel.setIsMain(model.getIsMain());

        return soapModel;
    }

    public static PmlDocumentSendWFSoap[] toSoapModels(
        List<PmlDocumentSendWF> models) {
        List<PmlDocumentSendWFSoap> soapModels = new ArrayList<PmlDocumentSendWFSoap>(models.size());

        for (PmlDocumentSendWF model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDocumentSendWFSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentSendId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentSendId(pk);
    }

    public long getDocumentSendId() {
        return _documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        _documentSendId = documentSendId;
    }

    public long getProcessId() {
        return _processId;
    }

    public void setProcessId(long processId) {
        _processId = processId;
    }

    public String getIsMain() {
        return _isMain;
    }

    public void setIsMain(String isMain) {
        _isMain = isMain;
    }
}
