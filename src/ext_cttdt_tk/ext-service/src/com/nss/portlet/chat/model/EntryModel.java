package com.nss.portlet.chat.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="EntryModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Entry</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.chat.model.Entry
 * @see com.nss.portlet.chat.model.impl.EntryImpl
 * @see com.nss.portlet.chat.model.impl.EntryModelImpl
 *
 */
public interface EntryModel extends BaseModel<Entry> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getEntryId();

    public void setEntryId(long entryId);

    public long getCreateDate();

    public void setCreateDate(long createDate);

    public long getFromUserId();

    public void setFromUserId(long fromUserId);

    public long getToUserId();

    public void setToUserId(long toUserId);

    public String getContent();

    public void setContent(String content);

    public Entry toEscapedModel();
}
