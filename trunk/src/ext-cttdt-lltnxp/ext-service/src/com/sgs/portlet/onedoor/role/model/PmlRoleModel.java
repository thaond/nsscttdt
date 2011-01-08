package com.sgs.portlet.onedoor.role.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlRoleModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlRole</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.role.model.PmlRole
 * @see com.sgs.portlet.onedoor.role.model.impl.PmlRoleImpl
 * @see com.sgs.portlet.onedoor.role.model.impl.PmlRoleModelImpl
 *
 */
public interface PmlRoleModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getRoleId();

    public void setRoleId(String roleId);

    public String getRoleCode();

    public void setRoleCode(String roleCode);

    public String getRoleName();

    public void setRoleName(String roleName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public PmlRole toEscapedModel();
}
