package com.nss.portlet.journal.model;


/**
 * <a href="JournalTemplate.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalTemplate</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.nss.portlet.journal.model.impl.JournalTemplateImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalTemplateModel
 * @see com.nss.portlet.journal.model.impl.JournalTemplateImpl
 * @see com.nss.portlet.journal.model.impl.JournalTemplateModelImpl
 *
 */
public interface JournalTemplate extends JournalTemplateModel {
    public java.lang.String getUserUuid()
        throws com.liferay.portal.SystemException;

    public void setUserUuid(java.lang.String userUuid);

    public java.lang.String getSmallImageType()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void setSmallImageType(java.lang.String smallImageType);
}
