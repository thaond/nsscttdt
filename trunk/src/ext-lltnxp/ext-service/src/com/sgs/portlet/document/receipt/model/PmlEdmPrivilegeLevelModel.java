package com.sgs.portlet.document.receipt.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlEdmPrivilegeLevelModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlEdmPrivilegeLevel</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmPrivilegeLevelImpl
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmPrivilegeLevelModelImpl
 *
 */
public interface PmlEdmPrivilegeLevelModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getPrivilegeLevelId();

    public void setPrivilegeLevelId(String privilegeLevelId);

    public String getPrivilegeLevelName();

    public void setPrivilegeLevelName(String privilegeLevelName);

    public PmlEdmPrivilegeLevel toEscapedModel();
}
