package com.sgs.portlet.document.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.document.service.persistence.PmlStateDepartmentPK;


/**
 * <a href="PmlStateDepartmentModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlStateDepartment</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlStateDepartment
 * @see com.sgs.portlet.document.model.impl.PmlStateDepartmentImpl
 * @see com.sgs.portlet.document.model.impl.PmlStateDepartmentModelImpl
 *
 */
public interface PmlStateDepartmentModel extends BaseModel {
    public PmlStateDepartmentPK getPrimaryKey();

    public void setPrimaryKey(PmlStateDepartmentPK pk);

    public String getDepartmentId();

    public void setDepartmentId(String departmentId);

    public long getStateWfId();

    public void setStateWfId(long stateWfId);

    public PmlStateDepartment toEscapedModel();
}
