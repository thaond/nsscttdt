package com.liferay.portlet.messageboards.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="MBDiscussionModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBDiscussion</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBDiscussion
 * @see com.liferay.portlet.messageboards.model.impl.MBDiscussionImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBDiscussionModelImpl
 *
 */
public interface MBDiscussionModel extends BaseModel<MBDiscussion> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDiscussionId();

    public void setDiscussionId(long discussionId);

    public String getClassName();

    public long getClassNameId();

    public void setClassNameId(long classNameId);

    public long getClassPK();

    public void setClassPK(long classPK);

    public long getThreadId();

    public void setThreadId(long threadId);

    public MBDiscussion toEscapedModel();
}
