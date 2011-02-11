package com.sgs.portlet.receivergroup.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.receivergroup.model.ReceiverGroup;
import com.sgs.portlet.receivergroup.model.ReceiverGroupSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ReceiverGroupModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ReceiverGroup</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.model.ReceiverGroup
 * @see com.sgs.portlet.receivergroup.model.ReceiverGroupModel
 * @see com.sgs.portlet.receivergroup.model.impl.ReceiverGroupImpl
 *
 */
public class ReceiverGroupModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_ReceiverGroup";
    public static final Object[][] TABLE_COLUMNS = {
            { "receiverGroupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "modifiedDate", new Integer(Types.TIMESTAMP) },
            

            { "receiverGroupName", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "type_", new Integer(Types.INTEGER) },
            

            { "active_", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_ReceiverGroup (receiverGroupId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,receiverGroupName VARCHAR(75) null,description VARCHAR(75) null,type_ INTEGER,active_ BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_ReceiverGroup";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.receivergroup.model.ReceiverGroup"),
            true);
    public static final boolean CACHE_ENABLED_RECEIVERGROUPS_RECEIVERS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.ReceiverGroups_Receivers"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.receivergroup.model.ReceiverGroup"));
    private long _receiverGroupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _receiverGroupName;
    private String _description;
    private int _type;
    private boolean _active;

    public ReceiverGroupModelImpl() {
    }

    public static ReceiverGroup toModel(ReceiverGroupSoap soapModel) {
        ReceiverGroup model = new ReceiverGroupImpl();

        model.setReceiverGroupId(soapModel.getReceiverGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setReceiverGroupName(soapModel.getReceiverGroupName());
        model.setDescription(soapModel.getDescription());
        model.setType(soapModel.getType());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<ReceiverGroup> toModels(ReceiverGroupSoap[] soapModels) {
        List<ReceiverGroup> models = new ArrayList<ReceiverGroup>(soapModels.length);

        for (ReceiverGroupSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _receiverGroupId;
    }

    public void setPrimaryKey(long pk) {
        setReceiverGroupId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_receiverGroupId);
    }

    public long getReceiverGroupId() {
        return _receiverGroupId;
    }

    public void setReceiverGroupId(long receiverGroupId) {
        if (receiverGroupId != _receiverGroupId) {
            _receiverGroupId = receiverGroupId;
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

    public String getReceiverGroupName() {
        return GetterUtil.getString(_receiverGroupName);
    }

    public void setReceiverGroupName(String receiverGroupName) {
        if (((receiverGroupName == null) && (_receiverGroupName != null)) ||
                ((receiverGroupName != null) && (_receiverGroupName == null)) ||
                ((receiverGroupName != null) && (_receiverGroupName != null) &&
                !receiverGroupName.equals(_receiverGroupName))) {
            _receiverGroupName = receiverGroupName;
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

    public ReceiverGroup toEscapedModel() {
        if (isEscapedModel()) {
            return (ReceiverGroup) this;
        } else {
            ReceiverGroup model = new ReceiverGroupImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setReceiverGroupId(getReceiverGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setCreateDate(getCreateDate());
            model.setModifiedDate(getModifiedDate());
            model.setReceiverGroupName(HtmlUtil.escape(getReceiverGroupName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setType(getType());
            model.setActive(getActive());

            model = (ReceiverGroup) Proxy.newProxyInstance(ReceiverGroup.class.getClassLoader(),
                    new Class[] { ReceiverGroup.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        ReceiverGroupImpl clone = new ReceiverGroupImpl();

        clone.setReceiverGroupId(getReceiverGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setReceiverGroupName(getReceiverGroupName());
        clone.setDescription(getDescription());
        clone.setType(getType());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        ReceiverGroupImpl receiverGroup = (ReceiverGroupImpl) obj;

        int value = 0;

        value = getReceiverGroupName()
                    .compareTo(receiverGroup.getReceiverGroupName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ReceiverGroupImpl receiverGroup = null;

        try {
            receiverGroup = (ReceiverGroupImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = receiverGroup.getPrimaryKey();

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
