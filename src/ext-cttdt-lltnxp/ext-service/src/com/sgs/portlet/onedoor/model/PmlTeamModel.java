package com.sgs.portlet.onedoor.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="PmlTeamModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlTeam</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlTeam
 * @see com.sgs.portlet.onedoor.model.impl.PmlTeamImpl
 * @see com.sgs.portlet.onedoor.model.impl.PmlTeamModelImpl
 *
 */
public interface PmlTeamModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getTeamId();

    public void setTeamId(long teamId);

    public String getDepartmentId();

    public void setDepartmentId(String departmentId);

    public String getTeamName();

    public void setTeamName(String teamName);

    public String getDescription();

    public void setDescription(String description);

    public long getOrganizationId();

    public void setOrganizationId(long organizationId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public String getSpecialTeam();

    public void setSpecialTeam(String specialTeam);

    public String getTeamCode();

    public void setTeamCode(String teamCode);

    public PmlTeam toEscapedModel();
}
