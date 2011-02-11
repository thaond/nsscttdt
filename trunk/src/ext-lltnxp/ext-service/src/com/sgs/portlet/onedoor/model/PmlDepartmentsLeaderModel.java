package com.sgs.portlet.onedoor.model;

import com.liferay.portal.model.BaseModel;

import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK;


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
 * @see com.sgs.portlet.onedoor.model.PmlDepartmentsLeader
 * @see com.sgs.portlet.onedoor.model.impl.PmlDepartmentsLeaderImpl
 * @see com.sgs.portlet.onedoor.model.impl.PmlDepartmentsLeaderModelImpl
 *
 */
public interface PmlDepartmentsLeaderModel extends BaseModel {
    public PmlDepartmentsLeaderPK getPrimaryKey();

    public void setPrimaryKey(PmlDepartmentsLeaderPK pk);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public long getUserId();

    public void setUserId(long userId);

    public long getClericalId();

    public void setClericalId(long clericalId);

    public boolean getMain();

    public boolean isMain();

    public void setMain(boolean main);

    public PmlDepartmentsLeader toEscapedModel();
}
