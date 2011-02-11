package com.sgs.portlet.pml_tinh_chat.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlTinhChatModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlTinhChat</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat
 * @see com.sgs.portlet.pml_tinh_chat.model.impl.PmlTinhChatImpl
 * @see com.sgs.portlet.pml_tinh_chat.model.impl.PmlTinhChatModelImpl
 *
 */
public interface PmlTinhChatModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getIdTinhChat();

    public void setIdTinhChat(long idTinhChat);

    public String getTenTinhChat();

    public void setTenTinhChat(String tenTinhChat);

    public PmlTinhChat toEscapedModel();
}
