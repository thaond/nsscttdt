package com.liferay.portlet.messageboards.model;


/**
 * <a href="MBMessage.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBMessage</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.liferay.portlet.messageboards.model.impl.MBMessageImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBMessageModel
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageModelImpl
 *
 */
public interface MBMessage extends MBMessageModel {
    public java.lang.String getUserUuid()
        throws com.liferay.portal.SystemException;

    public void setUserUuid(java.lang.String userUuid);

    public com.liferay.portlet.messageboards.model.MBCategory getCategory();

    public com.liferay.portlet.messageboards.model.MBThread getThread()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public boolean isRoot();

    public boolean isReply();

    public boolean isDiscussion();

    public java.lang.String getBody(boolean translate);

    public java.lang.String getThreadAttachmentsDir();

    public java.lang.String getAttachmentsDir();

    public void setAttachmentsDir(java.lang.String attachmentsDir);

    public java.lang.String[] getAttachmentsFiles()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.lang.String[] getTagsEntries()
        throws com.liferay.portal.SystemException;
}
