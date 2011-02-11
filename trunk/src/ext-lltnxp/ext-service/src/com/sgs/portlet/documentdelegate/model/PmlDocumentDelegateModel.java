package com.sgs.portlet.documentdelegate.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlDocumentDelegateModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDocumentDelegate</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate
 * @see com.sgs.portlet.documentdelegate.model.impl.PmlDocumentDelegateImpl
 * @see com.sgs.portlet.documentdelegate.model.impl.PmlDocumentDelegateModelImpl
 *
 */
public interface PmlDocumentDelegateModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDocumentDelegateId();

    public void setDocumentDelegateId(long documentDelegateId);

    public long getUserDelegateId();

    public void setUserDelegateId(long userDelegateId);

    public long getUserIsDelegateId();

    public void setUserIsDelegateId(long userIsDelegateId);

    public int getDocumentId();

    public void setDocumentId(int documentId);

    public Date getFromtDate();

    public void setFromtDate(Date fromtDate);

    public Date getToDate();

    public void setToDate(Date toDate);

    public Date getCancelDate();

    public void setCancelDate(Date cancelDate);

    public PmlDocumentDelegate toEscapedModel();
}
