package com.sgs.portlet.recievergroup.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.recievergroup.model.RecieverGroup;
import com.sgs.portlet.recievergroup.model.RecieverGroupSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="RecieverGroupModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>RecieverGroup</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.model.RecieverGroup
 * @see com.sgs.portlet.recievergroup.model.RecieverGroupModel
 * @see com.sgs.portlet.recievergroup.model.impl.RecieverGroupImpl
 *
 */
public class RecieverGroupModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_RecieverGroup";
    public static final Object[][] TABLE_COLUMNS = {
            { "recieverGroupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "modifiedDate", new Integer(Types.TIMESTAMP) },
            

            { "recieverGroupName", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "type_", new Integer(Types.INTEGER) },
            

            { "active_", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_RecieverGroup (recieverGroupId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,recieverGroupName VARCHAR(75) null,description VARCHAR(75) null,type_ INTEGER,active_ BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_RecieverGroup";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.recievergroup.model.RecieverGroup"),
            true);
    public static final boolean CACHE_ENABLED_RECIEVERGROUPS_RECIEVERS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.RecieverGroups_Recievers"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.recievergroup.model.RecieverGroup"));
    private long _recieverGroupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _recieverGroupName;
    private String _description;
    private int _type;
    private boolean _active;

    public RecieverGroupModelImpl() {
    }

    public static RecieverGroup toModel(RecieverGroupSoap soapModel) {
        RecieverGroup model = new RecieverGroupImpl();

        model.setRecieverGroupId(soapModel.getRecieverGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setRecieverGroupName(soapModel.getRecieverGroupName());
        model.setDescription(soapModel.getDescription());
        model.setType(soapModel.getType());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<RecieverGroup> toModels(RecieverGroupSoap[] soapModels) {
        List<RecieverGroup> models = new ArrayList<RecieverGroup>(soapModels.length);

        for (RecieverGroupSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _recieverGroupId;
    }

    public void setPrimaryKey(long pk) {
        setRecieverGroupId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_recieverGroupId);
    }

    public long getRecieverGroupId() {
        return _recieverGroupId;
    }

    public void setRecieverGroupId(long recieverGroupId) {
        if (recieverGroupId != _recieverGroupId) {
            _recieverGroupId = recieverGroupId;
        }
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        if (companyId != _companyId) {
            _companyId = companyId;
        }
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public String getUserName() {
        return GetterUtil.getString(_userName);
    }

    public void setUserName(String userName) {
        if (((userName == null) && (_userName != null)) ||
                ((userName != null) && (_userName == null)) ||
                ((userName != null) && (_userName != null) &&
                !userName.equals(_userName))) {
            _userName = userName;
        }
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        if (((createDate == null) && (_createDate != null)) ||
                ((createDate != null) && (_createDate == null)) ||
                ((createDate != null) && (_createDate != null) &&
                !createDate.equals(_createDate))) {
            _createDate = createDate;
        }
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        if (((modifiedDate == null) && (_modifiedDate != null)) ||
                ((modifiedDate != null) && (_modifiedDate == null)) ||
                ((modifiedDate != null) && (_modifiedDate != null) &&
                !modifiedDate.equals(_modifiedDate))) {
            _modifiedDate = modifiedDate;
        }
    }

    public String getRecieverGroupName() {
        return GetterUtil.getString(_recieverGroupName);
    }

    public void setRecieverGroupName(String recieverGroupName) {
        if (((recieverGroupName == null) && (_recieverGroupName != null)) ||
                ((recieverGroupName != null) && (_recieverGroupName == null)) ||
                ((recieverGroupName != null) && (_recieverGroupName != null) &&
                !recieverGroupName.equals(_recieverGroupName))) {
            _recieverGroupName = recieverGroupName;
        }
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        if (((description == null) && (_description != null)) ||
                ((description != null) && (_description == null)) ||
                ((description != null) && (_description != null) &&
                !description.equals(_description))) {
            _description = description;
        }
    }

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        if (type != _type) {
            _type = type;
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

    public RecieverGroup toEscapedModel() {
        if (isEscapedModel()) {
            return (RecieverGroup) this;
        } else {
            RecieverGroup model = new RecieverGroupImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setRecieverGroupId(getRecieverGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setCreateDate(getCreateDate());
            model.setModifiedDate(getModifiedDate());
            model.setRecieverGroupName(HtmlUtil.escape(getRecieverGroupName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setType(getType());
            model.setActive(getActive());

            model = (RecieverGroup) Proxy.newProxyInstance(RecieverGroup.class.getClassLoader(),
                    new Class[] { RecieverGroup.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        RecieverGroupImpl clone = new RecieverGroupImpl();

        clone.setRecieverGroupId(getRecieverGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setRecieverGroupName(getRecieverGroupName());
        clone.setDescription(getDescription());
        clone.setType(getType());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        RecieverGroupImpl recieverGroup = (RecieverGroupImpl) obj;

        int value = 0;

        value = getRecieverGroupName()
                    .compareTo(recieverGroup.getRecieverGroupName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        RecieverGroupImpl recieverGroup = null;

        try {
            recieverGroup = (RecieverGroupImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = recieverGroup.getPrimaryKey();

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
