package com.sgs.portlet.document.send.model;

import com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmWriteDocumentSendSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.send.service.http.PmlEdmWriteDocumentSendServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.http.PmlEdmWriteDocumentSendServiceSoap
 *
 */
public class PmlEdmWriteDocumentSendSoap implements Serializable {
    private long _bookDocumentSendId;
    private long _documentSendId;
    private Date _dateCreated;
    private int _soCongVanDiPhongHienTai;

    public PmlEdmWriteDocumentSendSoap() {
    }

    public static PmlEdmWriteDocumentSendSoap toSoapModel(
        PmlEdmWriteDocumentSend model) {
        PmlEdmWriteDocumentSendSoap soapModel = new PmlEdmWriteDocumentSendSoap();

        soapModel.setBookDocumentSendId(model.getBookDocumentSendId());
        soapModel.setDocumentSendId(model.getDocumentSendId());
        soapModel.setDateCreated(model.getDateCreated());
        soapModel.setSoCongVanDiPhongHienTai(model.getSoCongVanDiPhongHienTai());

        return soapModel;
    }

    public static PmlEdmWriteDocumentSendSoap[] toSoapModels(
        List<PmlEdmWriteDocumentSend> models) {
        List<PmlEdmWriteDocumentSendSoap> soapModels = new ArrayList<PmlEdmWriteDocumentSendSoap>(models.size());

        for (PmlEdmWriteDocumentSend model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmWriteDocumentSendSoap[soapModels.size()]);
    }

    public PmlEdmWriteDocumentSendPK getPrimaryKey() {
        return new PmlEdmWriteDocumentSendPK(_bookDocumentSendId,
            _documentSendId);
    }

    public void setPrimaryKey(PmlEdmWriteDocumentSendPK pk) {
        setBookDocumentSendId(pk.bookDocumentSendId);
        setDocumentSendId(pk.documentSendId);
    }

    public long getBookDocumentSendId() {
        return _bookDocumentSendId;
    }

    public void setBookDocumentSendId(long bookDocumentSendId) {
        _bookDocumentSendId = bookDocumentSendId;
    }

    public long getDocumentSendId() {
        return _documentSendId;
    }

    public void setDocumentSendId(long documentSendId) {
        _documentSendId = documentSendId;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
    }

    public int getSoCongVanDiPhongHienTai() {
        return _soCongVanDiPhongHienTai;
    }

    public void setSoCongVanDiPhongHienTai(int soCongVanDiPhongHienTai) {
        _soCongVanDiPhongHienTai = soCongVanDiPhongHienTai;
    }
}
