package com.sgs.portlet.pml_edm_docconfuser.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmDocConfUserModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmDocConfUser</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser
 * @see com.sgs.portlet.pml_edm_docconfuser.model.impl.PmlEdmDocConfUserImpl
 * @see com.sgs.portlet.pml_edm_docconfuser.model.impl.PmlEdmDocConfUserModelImpl
 *
 */
public interface PmlEdmDocConfUserModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDcuId();

    public void setDcuId(long dcuId);

    public long getUserId();

    public void setUserId(long userId);

    public boolean getViewAllDoc();

    public boolean isViewAllDoc();

    public void setViewAllDoc(boolean viewAllDoc);

    public String getViewDepDoc();

    public void setViewDepDoc(String viewDepDoc);

    public PmlEdmDocConfUser toEscapedModel();
}
