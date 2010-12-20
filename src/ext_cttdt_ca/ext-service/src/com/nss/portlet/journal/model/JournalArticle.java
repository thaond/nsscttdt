package com.nss.portlet.journal.model;


/**
 * <a href="JournalArticle.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalArticle</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.nss.portlet.journal.model.impl.JournalArticleImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalArticleModel
 * @see com.nss.portlet.journal.model.impl.JournalArticleImpl
 * @see com.nss.portlet.journal.model.impl.JournalArticleModelImpl
 *
 */
public interface JournalArticle extends JournalArticleModel {
    public java.lang.String getApprovedByUserUuid()
        throws com.liferay.portal.SystemException;

    public java.lang.String[] getAvailableLocales();

    public java.lang.String getContentByLocale(java.lang.String languageId);

    public java.lang.String getDefaultLocale();

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge();

    public java.lang.String getSmallImageType()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.lang.String getUserUuid()
        throws com.liferay.portal.SystemException;

    public boolean isTemplateDriven();

    public void setApprovedByUserUuid(java.lang.String approvedByUserUuid);

    public void setSmallImageType(java.lang.String smallImageType);

    public void setUserUuid(java.lang.String userUuid);
}
