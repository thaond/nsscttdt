package com.sgs.portlet.document_manager.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="AttactFileDocumentModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>AttactFileDocument</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.model.AttactFileDocument
 * @see com.sgs.portlet.document_manager.model.impl.AttactFileDocumentImpl
 * @see com.sgs.portlet.document_manager.model.impl.AttactFileDocumentModelImpl
 *
 */
public interface AttactFileDocumentModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getAttactFileDocumentId();

    public void setAttactFileDocumentId(long attactFileDocumentId);

    public String getAttactFileDocumentTitle();

    public void setAttactFileDocumentTitle(String attactFileDocumentTitle);

    public String getAttactFileDocumentPath();

    public void setAttactFileDocumentPath(String attactFileDocumentPath);

    public long getDocumentManagerId();

    public void setDocumentManagerId(long documentManagerId);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public AttactFileDocument toEscapedModel();
}
