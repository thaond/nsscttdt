package com.sgs.portlet.department.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="DepartmentModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Department</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.model.Department
 * @see com.sgs.portlet.department.model.impl.DepartmentImpl
 * @see com.sgs.portlet.department.model.impl.DepartmentModelImpl
 *
 */
public interface DepartmentModel extends BaseModel {
    public String getPrimaryKey();

    public void setPrimaryKey(String pk);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public String getDepartmentsParentId();

    public void setDepartmentsParentId(String departmentsParentId);

    public String getDepartmentsCode();

    public void setDepartmentsCode(String departmentsCode);

    public String getDepartmentsName();

    public void setDepartmentsName(String departmentsName);

    public String getAbbreviateName();

    public void setAbbreviateName(String abbreviateName);

    public String getDescription();

    public void setDescription(String description);

    public String getActive();

    public void setActive(String active);

    public String getAgencyId();

    public void setAgencyId(String agencyId);

    public long getRoleId();

    public void setRoleId(long roleId);

    public String getHasTeam();

    public void setHasTeam(String hasTeam);

    public Department toEscapedModel();
}
