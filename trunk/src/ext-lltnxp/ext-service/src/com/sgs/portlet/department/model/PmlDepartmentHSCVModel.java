package com.sgs.portlet.department.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlDepartmentHSCVModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDepartmentHSCV</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.department.model.PmlDepartmentHSCV
 * @see com.sgs.portlet.department.model.impl.PmlDepartmentHSCVImpl
 * @see com.sgs.portlet.department.model.impl.PmlDepartmentHSCVModelImpl
 *
 */
public interface PmlDepartmentHSCVModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getPmlDepartmentHSCVId();

    public void setPmlDepartmentHSCVId(long pmlDepartmentHSCVId);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public long getId_ho_so_cong_viec();

    public void setId_ho_so_cong_viec(long id_ho_so_cong_viec);

    public String getDescription();

    public void setDescription(String description);

    public PmlDepartmentHSCV toEscapedModel();
}
