package com.sgs.portlet.pmluser.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.model.PmlUserSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlUserModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlUser</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmluser.model.PmlUser
 * @see com.sgs.portlet.pmluser.model.PmlUserModel
 * @see com.sgs.portlet.pmluser.model.impl.PmlUserImpl
 *
 */
public class PmlUserModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_user";
    public static final Object[][] TABLE_COLUMNS = {
            { "userId", new Integer(Types.BIGINT) },
            

            { "positionId", new Integer(Types.VARCHAR) },
            

            { "departmentsId", new Integer(Types.VARCHAR) },
            

            { "roleId", new Integer(Types.VARCHAR) },
            

            { "handphone", new Integer(Types.VARCHAR) },
            

            { "note", new Integer(Types.VARCHAR) },
            

            { "teamid", new Integer(Types.BIGINT) },
            

            { "active", new Integer(Types.BOOLEAN) },
            

            { "screenname", new Integer(Types.VARCHAR) },
            

            { "firstname", new Integer(Types.VARCHAR) },
            

            { "middlename", new Integer(Types.VARCHAR) },
            

            { "lastname", new Integer(Types.VARCHAR) },
            

            { "male", new Integer(Types.BOOLEAN) },
            

            { "birthday", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_user (userId LONG not null primary key,positionId VARCHAR(75) null,departmentsId VARCHAR(75) null,roleId VARCHAR(75) null,handphone VARCHAR(75) null,note VARCHAR(75) null,teamid LONG,active BOOLEAN,screenname VARCHAR(75) null,firstname VARCHAR(75) null,middlename VARCHAR(75) null,lastname VARCHAR(75) null,male BOOLEAN,birthday DATE null)";
    public static final String TABLE_SQL_DROP = "drop table pml_user";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pmluser.model.PmlUser"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pmluser.model.PmlUser"));
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

    public PmlUserModelImpl() {
    }

    public static PmlUser toModel(PmlUserSoap soapModel) {
        PmlUser model = new PmlUserImpl();

        model.setUserId(soapModel.getUserId());
        model.setPositionId(soapModel.getPositionId());
        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setRoleId(soapModel.getRoleId());
        model.setHandPhone(soapModel.getHandPhone());
        model.setNote(soapModel.getNote());
        model.setTeamId(soapModel.getTeamId());
        model.setActive(soapModel.getActive());
        model.setScreenName(soapModel.getScreenName());
        model.setFirstName(soapModel.getFirstName());
        model.setMiddleName(soapModel.getMiddleName());
        model.setLastName(soapModel.getLastName());
        model.setMale(soapModel.getMale());
        model.setBirthday(soapModel.getBirthday());

        return model;
    }

    public static List<PmlUser> toModels(PmlUserSoap[] soapModels) {
        List<PmlUser> models = new ArrayList<PmlUser>(soapModels.length);

        for (PmlUserSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_userId);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public String getPositionId() {
        return GetterUtil.getString(_positionId);
    }

    public void setPositionId(String positionId) {
        if (((positionId == null) && (_positionId != null)) ||
                ((positionId != null) && (_positionId == null)) ||
                ((positionId != null) && (_positionId != null) &&
                !positionId.equals(_positionId))) {
            _positionId = positionId;
        }
    }

    public String getDepartmentsId() {
        return GetterUtil.getString(_departmentsId);
    }

    public void setDepartmentsId(String departmentsId) {
        if (((departmentsId == null) && (_departmentsId != null)) ||
                ((departmentsId != null) && (_departmentsId == null)) ||
                ((departmentsId != null) && (_departmentsId != null) &&
                !departmentsId.equals(_departmentsId))) {
            _departmentsId = departmentsId;
        }
    }

    public String getRoleId() {
        return GetterUtil.getString(_roleId);
    }

    public void setRoleId(String roleId) {
        if (((roleId == null) && (_roleId != null)) ||
                ((roleId != null) && (_roleId == null)) ||
                ((roleId != null) && (_roleId != null) &&
                !roleId.equals(_roleId))) {
            _roleId = roleId;
        }
    }

    public String getHandPhone() {
        return GetterUtil.getString(_handPhone);
    }

    public void setHandPhone(String handPhone) {
        if (((handPhone == null) && (_handPhone != null)) ||
                ((handPhone != null) && (_handPhone == null)) ||
                ((handPhone != null) && (_handPhone != null) &&
                !handPhone.equals(_handPhone))) {
            _handPhone = handPhone;
        }
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        if (((note == null) && (_note != null)) ||
                ((note != null) && (_note == null)) ||
                ((note != null) && (_note != null) && !note.equals(_note))) {
            _note = note;
        }
    }

    public long getTeamId() {
        return _teamId;
    }

    public void setTeamId(long teamId) {
        if (teamId != _teamId) {
            _teamId = teamId;
        }
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        if (active != _active) {
            _active = active;
        }
    }

    public String getScreenName() {
        return GetterUtil.getString(_screenName);
    }

    public void setScreenName(String screenName) {
        if (((screenName == null) && (_screenName != null)) ||
                ((screenName != null) && (_screenName == null)) ||
                ((screenName != null) && (_screenName != null) &&
                !screenName.equals(_screenName))) {
            _screenName = screenName;
        }
    }

    public String getFirstName() {
        return GetterUtil.getString(_firstName);
    }

    public void setFirstName(String firstName) {
        if (((firstName == null) && (_firstName != null)) ||
                ((firstName != null) && (_firstName == null)) ||
                ((firstName != null) && (_firstName != null) &&
                !firstName.equals(_firstName))) {
            _firstName = firstName;
        }
    }

    public String getMiddleName() {
        return GetterUtil.getString(_middleName);
    }

    public void setMiddleName(String middleName) {
        if (((middleName == null) && (_middleName != null)) ||
                ((middleName != null) && (_middleName == null)) ||
                ((middleName != null) && (_middleName != null) &&
                !middleName.equals(_middleName))) {
            _middleName = middleName;
        }
    }

    public String getLastName() {
        return GetterUtil.getString(_lastName);
    }

    public void setLastName(String lastName) {
        if (((lastName == null) && (_lastName != null)) ||
                ((lastName != null) && (_lastName == null)) ||
                ((lastName != null) && (_lastName != null) &&
                !lastName.equals(_lastName))) {
            _lastName = lastName;
        }
    }

    public boolean getMale() {
        return _male;
    }

    public boolean isMale() {
        return _male;
    }

    public void setMale(boolean male) {
        if (male != _male) {
            _male = male;
        }
    }

    public Date getBirthday() {
        return _birthday;
    }

    public void setBirthday(Date birthday) {
        if (((birthday == null) && (_birthday != null)) ||
                ((birthday != null) && (_birthday == null)) ||
                ((birthday != null) && (_birthday != null) &&
                !birthday.equals(_birthday))) {
            _birthday = birthday;
        }
    }

    public PmlUser toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlUser) this;
        } else {
            PmlUser model = new PmlUserImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setUserId(getUserId());
            model.setPositionId(HtmlUtil.escape(getPositionId()));
            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));
            model.setRoleId(HtmlUtil.escape(getRoleId()));
            model.setHandPhone(HtmlUtil.escape(getHandPhone()));
            model.setNote(HtmlUtil.escape(getNote()));
            model.setTeamId(getTeamId());
            model.setActive(getActive());
            model.setScreenName(HtmlUtil.escape(getScreenName()));
            model.setFirstName(HtmlUtil.escape(getFirstName()));
            model.setMiddleName(HtmlUtil.escape(getMiddleName()));
            model.setLastName(HtmlUtil.escape(getLastName()));
            model.setMale(getMale());
            model.setBirthday(getBirthday());

            model = (PmlUser) Proxy.newProxyInstance(PmlUser.class.getClassLoader(),
                    new Class[] { PmlUser.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlUserImpl clone = new PmlUserImpl();

        clone.setUserId(getUserId());
        clone.setPositionId(getPositionId());
        clone.setDepartmentsId(getDepartmentsId());
        clone.setRoleId(getRoleId());
        clone.setHandPhone(getHandPhone());
        clone.setNote(getNote());
        clone.setTeamId(getTeamId());
        clone.setActive(getActive());
        clone.setScreenName(getScreenName());
        clone.setFirstName(getFirstName());
        clone.setMiddleName(getMiddleName());
        clone.setLastName(getLastName());
        clone.setMale(getMale());
        clone.setBirthday(getBirthday());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlUserImpl pmlUser = (PmlUserImpl) obj;

        int value = 0;

        value = getFirstName().toLowerCase()
                    .compareTo(pmlUser.getFirstName().toLowerCase());

        if (value != 0) {
            return value;
        }

        value = getLastName().toLowerCase()
                    .compareTo(pmlUser.getLastName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlUserImpl pmlUser = null;

        try {
            pmlUser = (PmlUserImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlUser.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
