package com.sgs.portlet.pmluser.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlUserSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pmluser.service.http.PmlUserServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmluser.service.http.PmlUserServiceSoap
 *
 */
public class PmlUserSoap implements Serializable {
    private long _userId;
    private String _positionId;
    private String _departmentsId;
    private String _roleId;
    private String _handPhone;
    private String _note;
    private long _teamId;
    private boolean _active;
    private String _screenName;
    private String _firstName;
    private String _middleName;
    private String _lastName;
    private boolean _male;
    private Date _birthday;

    public PmlUserSoap() {
    }

    public static PmlUserSoap toSoapModel(PmlUser model) {
        PmlUserSoap soapModel = new PmlUserSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setPositionId(model.getPositionId());
        soapModel.setDepartmentsId(model.getDepartmentsId());
        soapModel.setRoleId(model.getRoleId());
        soapModel.setHandPhone(model.getHandPhone());
        soapModel.setNote(model.getNote());
        soapModel.setTeamId(model.getTeamId());
        soapModel.setActive(model.getActive());
        soapModel.setScreenName(model.getScreenName());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setMiddleName(model.getMiddleName());
        soapModel.setLastName(model.getLastName());
        soapModel.setMale(model.getMale());
        soapModel.setBirthday(model.getBirthday());

        return soapModel;
    }

    public static PmlUserSoap[] toSoapModels(List<PmlUser> models) {
        List<PmlUserSoap> soapModels = new ArrayList<PmlUserSoap>(models.size());

        for (PmlUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlUserSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getPositionId() {
        return _positionId;
    }

    public void setPositionId(String positionId) {
        _positionId = positionId;
    }

    public String getDepartmentsId() {
        return _departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public String getRoleId() {
        return _roleId;
    }

    public void setRoleId(String roleId) {
        _roleId = roleId;
    }

    public String getHandPhone() {
        return _handPhone;
    }

    public void setHandPhone(String handPhone) {
        _handPhone = handPhone;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    public long getTeamId() {
        return _teamId;
    }

    public void setTeamId(long teamId) {
        _teamId = teamId;
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        _active = active;
    }

    public String getScreenName() {
        return _screenName;
    }

    public void setScreenName(String screenName) {
        _screenName = screenName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getMiddleName() {
        return _middleName;
    }

    public void setMiddleName(String middleName) {
        _middleName = middleName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public boolean getMale() {
        return _male;
    }

    public boolean isMale() {
        return _male;
    }

    public void setMale(boolean male) {
        _male = male;
    }

    public Date getBirthday() {
        return _birthday;
    }

    public void setBirthday(Date birthday) {
        _birthday = birthday;
    }
}
