package com.nss.portlet.journal.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="JournalContentSearchModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalContentSearch</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalContentSearch
 * @see com.nss.portlet.journal.model.impl.JournalContentSearchImpl
 * @see com.nss.portlet.journal.model.impl.JournalContentSearchModelImpl
 *
 */
public interface JournalContentSearchModel extends BaseModel<JournalContentSearch> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getContentSearchId();

    public void setContentSearchId(long contentSearchId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public boolean getPrivateLayout();

    public boolean isPrivateLayout();

    public void setPrivateLayout(boolean privateLayout);

    public long getLayoutId();

    public void setLayoutId(long layoutId);

    public String getPortletId();

    public void setPortletId(String portletId);

    public String getArticleId();

    public void setArticleId(String articleId);

    public JournalContentSearch toEscapedModel();
}
