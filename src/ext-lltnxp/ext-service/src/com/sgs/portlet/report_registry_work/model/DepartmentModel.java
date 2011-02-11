package com.sgs.portlet.report_registry_work.model;

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
 * @see com.sgs.portlet.report_registry_work.model.Department
 * @see com.sgs.portlet.report_registry_work.model.impl.DepartmentImpl
 * @see com.sgs.portlet.report_registry_work.model.impl.DepartmentModelImpl
 *
 */
public interface DepartmentModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getDepartmentId();

    public void setDepartmentId(long departmentId);

    public String getDepartmentCode();

    public void setDepartmentCode(String departmentCode);

    public String getDepartmentName();

    public void setDepartmentName(String departmentName);

    public String getDepartmentDescription();

    public void setDepartmentDescription(String departmentDescription);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public Department toEscapedModel();
}
