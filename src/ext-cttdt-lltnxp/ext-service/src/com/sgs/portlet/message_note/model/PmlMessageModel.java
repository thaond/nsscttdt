package com.sgs.portlet.message_note.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlMessageModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlMessage</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.message_note.model.PmlMessage
 * @see com.sgs.portlet.message_note.model.impl.PmlMessageImpl
 * @see com.sgs.portlet.message_note.model.impl.PmlMessageModelImpl
 *
 */
public interface PmlMessageModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMessageId();

    public void setMessageId(long messageId);

    public long getDocumentId();

    public void setDocumentId(long documentId);

    public long getFromUserId();

    public void setFromUserId(long fromUserId);

    public long getToUserId();

    public void setToUserId(long toUserId);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public String getObjectType();

    public void setObjectType(String objectType);

    public boolean getIsAlert();

    public boolean isIsAlert();

    public void setIsAlert(boolean isAlert);

    public PmlMessage toEscapedModel();
}
