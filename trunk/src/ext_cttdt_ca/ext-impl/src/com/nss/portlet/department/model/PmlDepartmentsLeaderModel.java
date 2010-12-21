package com.nss.portlet.department.model;

import com.liferay.portal.model.BaseModel;

import com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK;


/**
 * <a href="PmlDepartmentsLeaderModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlDepartmentsLeader</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.model.PmlDepartmentsLeader
 * @see com.nss.portlet.department.model.impl.PmlDepartmentsLeaderImpl
 * @see com.nss.portlet.department.model.impl.PmlDepartmentsLeaderModelImpl
 *
 */
public interface PmlDepartmentsLeaderModel extends BaseModel<PmlDepartmentsLeader> {
    public PmlDepartmentsLeaderPK getPrimaryKey();

    public void setPrimaryKey(PmlDepartmentsLeaderPK pk);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public long getUserId();

    public void setUserId(long userId);

    public boolean getMain();

    public boolean isMain();

    public void setMain(boolean main);

    public PmlDepartmentsLeader toEscapedModel();
}
