package com.nss.portlet.journal.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="JournalArticleResourceModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalArticleResource</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalArticleResource
 * @see com.nss.portlet.journal.model.impl.JournalArticleResourceImpl
 * @see com.nss.portlet.journal.model.impl.JournalArticleResourceModelImpl
 *
 */
public interface JournalArticleResourceModel extends BaseModel<JournalArticleResource> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getResourcePrimKey();

    public void setResourcePrimKey(long resourcePrimKey);

    public long getGroupId();

    public void setGroupId(long groupId);

    public String getArticleId();

    public void setArticleId(String articleId);

    public JournalArticleResource toEscapedModel();
}
