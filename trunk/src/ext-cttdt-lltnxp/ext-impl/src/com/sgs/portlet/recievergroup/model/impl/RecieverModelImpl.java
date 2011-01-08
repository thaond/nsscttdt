package com.sgs.portlet.recievergroup.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.recievergroup.model.Reciever;
import com.sgs.portlet.recievergroup.model.RecieverSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="RecieverModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Reciever</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.model.Reciever
 * @see com.sgs.portlet.recievergroup.model.RecieverModel
 * @see com.sgs.portlet.recievergroup.model.impl.RecieverImpl
 *
 */
public class RecieverModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_Reciever";
    public static final Object[][] TABLE_COLUMNS = {
            { "recieverId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "modifiedDate", new Integer(Types.TIMESTAMP) },
            

            { "recieverUserId", new Integer(Types.BIGINT) },
            

            { "recieverUserName", new Integer(Types.VARCHAR) },
            

            { "viewName", new Integer(Types.VARCHAR) },
            

            { "recieverType", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_Reciever (recieverId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,recieverUserId LONG,recieverUserName VARCHAR(75) null,viewName VARCHAR(75) null,recieverType INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table pml_Reciever";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.recievergroup.model.Reciever"),
            true);
    public static final boolean CACHE_ENABLED_RECIEVERGROUPS_RECIEVERS = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.RecieverGroups_Recievers"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.recievergroup.model.Reciever"));
    private long _recieverId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _recieverUserId;
    private String _recieverUserName;
    private String _viewName;
    private int _recieverType;

    public RecieverModelImpl() {
    }

    public static Reciever toModel(RecieverSoap soapModel) {
        Reciever model = new RecieverImpl();

        model.setRecieverId(soapModel.getRecieverId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setRecieverUserId(soapModel.getRecieverUserId());
        model.setRecieverUserName(soapModel.getRecieverUserName());
        model.setViewName(soapModel.getViewName());
        model.setRecieverType(soapModel.getRecieverType());

        return model;
    }

    public static List<Reciever> toModels(RecieverSoap[] soapModels) {
        List<Reciever> models = new ArrayList<Reciever>(soapModels.length);

        for (RecieverSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _recieverId;
    }

    public void setPrimaryKey(long pk) {
        setRecieverId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_recieverId);
    }

    public long getRecieverId() {
        return _recieverId;
    }

    public void setRecieverId(long recieverId) {
        if (recieverId != _recieverId) {
            _recieverId = recieverId;
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

    public long getRecieverUserId() {
        return _recieverUserId;
    }

    public void setRecieverUserId(long recieverUserId) {
        if (recieverUserId != _recieverUserId) {
            _recieverUserId = recieverUserId;
        }
    }

    public String getRecieverUserName() {
        return GetterUtil.getString(_recieverUserName);
    }

    public void setRecieverUserName(String recieverUserName) {
        if (((recieverUserName == null) && (_recieverUserName != null)) ||
                ((recieverUserName != null) && (_recieverUserName == null)) ||
                ((recieverUserName != null) && (_recieverUserName != null) &&
                !recieverUserName.equals(_recieverUserName))) {
            _recieverUserName = recieverUserName;
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

    public int getRecieverType() {
        return _recieverType;
    }

    public void setRecieverType(int recieverType) {
        if (recieverType != _recieverType) {
            _recieverType = recieverType;
        }
    }

    public Reciever toEscapedModel() {
        if (isEscapedModel()) {
            return (Reciever) this;
        } else {
            Reciever model = new RecieverImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setRecieverId(getRecieverId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setCreateDate(getCreateDate());
            model.setModifiedDate(getModifiedDate());
            model.setRecieverUserId(getRecieverUserId());
            model.setRecieverUserName(HtmlUtil.escape(getRecieverUserName()));
            model.setViewName(HtmlUtil.escape(getViewName()));
            model.setRecieverType(getRecieverType());

            model = (Reciever) Proxy.newProxyInstance(Reciever.class.getClassLoader(),
                    new Class[] { Reciever.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        RecieverImpl clone = new RecieverImpl();

        clone.setRecieverId(getRecieverId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setRecieverUserId(getRecieverUserId());
        clone.setRecieverUserName(getRecieverUserName());
        clone.setViewName(getViewName());
        clone.setRecieverType(getRecieverType());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        RecieverImpl reciever = (RecieverImpl) obj;

        long pk = reciever.getPrimaryKey();

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

        RecieverImpl reciever = null;

        try {
            reciever = (RecieverImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = reciever.getPrimaryKey();

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
