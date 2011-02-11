package com.sgs.portlet.document.send.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendPK;

import java.util.Date;


/**
 * <a href="PmlEdmWriteDocumentSendModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmWriteDocumentSend</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl
 * @see com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendModelImpl
 *
 */
public interface PmlEdmWriteDocumentSendModel extends BaseModel {
    public PmlEdmWriteDocumentSendPK getPrimaryKey();

    public void setPrimaryKey(PmlEdmWriteDocumentSendPK pk);

    public long getBookDocumentSendId();

    public void setBookDocumentSendId(long bookDocumentSendId);

    public long getDocumentSendId();

    public void setDocumentSendId(long documentSendId);

    public Date getDateCreated();

    public void setDateCreated(Date dateCreated);

    public int getSoCongVanDiPhongHienTai();

    public void setSoCongVanDiPhongHienTai(int soCongVanDiPhongHienTai);

    public PmlEdmWriteDocumentSend toEscapedModel();
}
