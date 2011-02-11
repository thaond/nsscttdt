package com.sgs.portlet.pmluser.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


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
 * @see com.sgs.portlet.pmluser.model.PmlUser
 * @see com.sgs.portlet.pmluser.model.impl.PmlUserImpl
 * @see com.sgs.portlet.pmluser.model.impl.PmlUserModelImpl
 *
 */
public interface PmlUserModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getUserId();

    public void setUserId(long userId);

    public String getPositionId();

    public void setPositionId(String positionId);

    public String getDepartmentsId();

    public void setDepartmentsId(String departmentsId);

    public String getRoleId();

    public void setRoleId(String roleId);

    public String getHandPhone();

    public void setHandPhone(String handPhone);

    public String getNote();

    public void setNote(String note);

    public long getTeamId();

    public void setTeamId(long teamId);

    public boolean getActive();

    public boolean isActive();

    public void setActive(boolean active);

    public String getScreenName();

    public void setScreenName(String screenName);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getMiddleName();

    public void setMiddleName(String middleName);

    public String getLastName();

    public void setLastName(String lastName);

    public boolean getMale();

    public boolean isMale();

    public void setMale(boolean male);

    public Date getBirthday();

    public void setBirthday(Date birthday);

    public boolean getIsLeaderMetting();

    public boolean isIsLeaderMetting();

    public void setIsLeaderMetting(boolean isLeaderMetting);

    public boolean getIsVanThuPhong();

    public boolean isIsVanThuPhong();

    public void setIsVanThuPhong(boolean isVanThuPhong);

    public PmlUser toEscapedModel();
}
