package com.sgs.portlet.receivergroup.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.receivergroup.model.Receiver;
import com.sgs.portlet.receivergroup.model.ReceiverSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ReceiverModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Receiver</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.model.Receiver
 * @see com.sgs.portlet.receivergroup.model.ReceiverModel
 * @see com.sgs.portlet.receivergroup.model.impl.ReceiverImpl
 *
 */
public class ReceiverModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_Receiver";
    public static final Object[][] TABLE_COLUMNS = {
            { "receiverId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "modifiedDate", new Integer(Types.TIMESTAMP) },
            

            { "receiverUserId", new Integer(Types.BIGINT) },
            

            { "receiverUserName", new Integer(Types.VARCHAR) },
            

            { "viewName", new Integer(Types.VARCHAR) },
            

            { "receiverType", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_Receiver (receiverId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,receiverUserId LONG,receiverUserName VARCHAR(75) null,viewName VARCHAR(75) null,receiverType INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table pml_Receiver";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.receivergroup.model.Receiver"),
            true);
    public static final boolean CACHE_ENABLED_RECEIVERGROUPS_RECEIVERS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.ReceiverGroups_Receivers"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.receivergroup.model.Receiver"));
    private long _receiverId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _receiverUserId;
    private String _receiverUserName;
    private String _viewName;
    private int _receiverType;

    public ReceiverModelImpl() {
    }

    public static Receiver toModel(ReceiverSoap soapModel) {
        Receiver model = new ReceiverImpl();

        model.setReceiverId(soapModel.getReceiverId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setReceiverUserId(soapModel.getReceiverUserId());
        model.setReceiverUserName(soapModel.getReceiverUserName());
        model.setViewName(soapModel.getViewName());
        model.setReceiverType(soapModel.getReceiverType());

        return model;
    }

    public static List<Receiver> toModels(ReceiverSoap[] soapModels) {
        List<Receiver> models = new ArrayList<Receiver>(soapModels.length);

        for (ReceiverSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _receiverId;
    }

    public void setPrimaryKey(long pk) {
        setReceiverId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_receiverId);
    }

    public long getReceiverId() {
        return _receiverId;
    }

    public void setReceiverId(long receiverId) {
        if (receiverId != _receiverId) {
            _receiverId = receiverId;
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

    public long getReceiverUserId() {
        return _receiverUserId;
    }

    public void setReceiverUserId(long receiverUserId) {
        if (receiverUserId != _receiverUserId) {
            _receiverUserId = receiverUserId;
        }
    }

    public String getReceiverUserName() {
        return GetterUtil.getString(_receiverUserName);
    }

    public void setReceiverUserName(String receiverUserName) {
        if (((receiverUserName == null) && (_receiverUserName != null)) ||
                ((receiverUserName != null) && (_receiverUserName == null)) ||
                ((receiverUserName != null) && (_receiverUserName != null) &&
                !receiverUserName.equals(_receiverUserName))) {
            _receiverUserName = receiverUserName;
        }
    }

    public String getViewName() {
        return GetterUtil.getString(_viewName);
    }

    public void setViewName(String viewName) {
        if (((viewName == null) && (_viewName != null)) ||
                ((viewName != null) && (_viewName == null)) ||
                ((viewName != null) && (_viewName != null) &&
                !viewName.equals(_viewName))) {
            _viewName = viewName;
        }
    }

    public int getReceiverType() {
        return _receiverType;
    }

    public void setReceiverType(int receiverType) {
        if (receiverType != _receiverType) {
            _receiverType = receiverType;
        }
    }

    public Receiver toEscapedModel() {
        if (isEscapedModel()) {
            return (Receiver) this;
        } else {
            Receiver model = new ReceiverImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setReceiverId(getReceiverId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setCreateDate(getCreateDate());
            model.setModifiedDate(getModifiedDate());
            model.setReceiverUserId(getReceiverUserId());
            model.setReceiverUserName(HtmlUtil.escape(getReceiverUserName()));
            model.setViewName(HtmlUtil.escape(getViewName()));
            model.setReceiverType(getReceiverType());

            model = (Receiver) Proxy.newProxyInstance(Receiver.class.getClassLoader(),
                    new Class[] { Receiver.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        ReceiverImpl clone = new ReceiverImpl();

        clone.setReceiverId(getReceiverId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setReceiverUserId(getReceiverUserId());
        clone.setReceiverUserName(getReceiverUserName());
        clone.setViewName(getViewName());
        clone.setReceiverType(getReceiverType());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        ReceiverImpl receiver = (ReceiverImpl) obj;

        long pk = receiver.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ReceiverImpl receiver = null;

        try {
            receiver = (ReceiverImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = receiver.getPrimaryKey();

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
