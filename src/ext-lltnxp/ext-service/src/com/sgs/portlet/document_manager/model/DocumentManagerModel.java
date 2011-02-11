package com.sgs.portlet.document_manager.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="DocumentManagerModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>DocumentManager</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.model.DocumentManager
 * @see com.sgs.portlet.document_manager.model.impl.DocumentManagerImpl
 * @see com.sgs.portlet.document_manager.model.impl.DocumentManagerModelImpl
 *
 */
public interface DocumentManagerModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentManagerId();

    public void setDocumentManagerId(long documentManagerId);

    public String getDocumentManagerCode();

    public void setDocumentManagerCode(String documentManagerCode);

    public String getDocumentManagerCategory();

    public void setDocumentManagerCategory(String documentManagerCategory);

    public String getDocumentManagerStyle();

    public void setDocumentManagerStyle(String documentManagerStyle);

    public String getDocumentManagerDescription();

    public void setDocumentManagerDescription(String documentManagerDescription);

    public Date getDocumentManagerDateCreate();

    public void setDocumentManagerDateCreate(Date documentManagerDateCreate);

    public String getDocumentManagerTitle();

    public void setDocumentManagerTitle(String documentManagerTitle);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public DocumentManager toEscapedModel();
}
