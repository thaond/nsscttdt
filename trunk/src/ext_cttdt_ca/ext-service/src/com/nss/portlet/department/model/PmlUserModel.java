package com.nss.portlet.department.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlUserModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlUser</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.model.PmlUser
 * @see com.nss.portlet.department.model.impl.PmlUserImpl
 * @see com.nss.portlet.department.model.impl.PmlUserModelImpl
 *
 */
public interface PmlUserModel extends BaseModel<PmlUser> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getUserId();

    public void setUserId(long userId);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public String getPositionId();

    public void setPositionId(String positionId);

    public Boolean getActive();

    public void setActive(Boolean active);

    public PmlUser toEscapedModel();
}
