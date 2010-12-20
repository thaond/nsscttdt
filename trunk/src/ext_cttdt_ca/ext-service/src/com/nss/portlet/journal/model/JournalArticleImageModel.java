package com.nss.portlet.journal.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="JournalArticleImageModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalArticleImage</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalArticleImage
 * @see com.nss.portlet.journal.model.impl.JournalArticleImageImpl
 * @see com.nss.portlet.journal.model.impl.JournalArticleImageModelImpl
 *
 */
public interface JournalArticleImageModel extends BaseModel<JournalArticleImage> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getArticleImageId();

    public void setArticleImageId(long articleImageId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public String getArticleId();

    public void setArticleId(String articleId);

    public double getVersion();

    public void setVersion(double version);

    public String getElInstanceId();

    public void setElInstanceId(String elInstanceId);

    public String getElName();

    public void setElName(String elName);

    public String getLanguageId();

    public void setLanguageId(String languageId);

    public boolean getTempImage();

    public boolean isTempImage();

    public void setTempImage(boolean tempImage);

    public JournalArticleImage toEscapedModel();
}
