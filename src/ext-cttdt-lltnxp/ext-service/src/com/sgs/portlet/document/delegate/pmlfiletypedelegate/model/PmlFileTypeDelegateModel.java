package com.sgs.portlet.document.delegate.pmlfiletypedelegate.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlFileTypeDelegateModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlFileTypeDelegate</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.impl.PmlFileTypeDelegateImpl
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.impl.PmlFileTypeDelegateModelImpl
 *
 */
public interface PmlFileTypeDelegateModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getFileTypeDelegateId();

    public void setFileTypeDelegateId(long fileTypeDelegateId);

    public String getFileTypeId();

    public void setFileTypeId(String fileTypeId);

    public long getDelegateId();

    public void setDelegateId(long delegateId);

    public PmlFileTypeDelegate toEscapedModel();
}
