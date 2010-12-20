package com.liferay.portlet.messageboards.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MBCategorySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBCategoryServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBCategoryServiceSoap
 *
 */
public class MBCategorySoap implements Serializable {
    private String _uuid;
    private long _categoryId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _parentCategoryId;
    private String _name;
    private String _description;
    private int _threadCount;
    private int _messageCount;
    private Date _lastPostDate;
    private long _image_liferay;
    private int _orderNumber;

    public MBCategorySoap() {
    }

    public static MBCategorySoap toSoapModel(MBCategory model) {
        MBCategorySoap soapModel = new MBCategorySoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setParentCategoryId(model.getParentCategoryId());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setThreadCount(model.getThreadCount());
        soapModel.setMessageCount(model.getMessageCount());
        soapModel.setLastPostDate(model.getLastPostDate());
        soapModel.setImage_liferay(model.getImage_liferay());
        soapModel.setOrderNumber(model.getOrderNumber());

        return soapModel;
    }

    public static MBCategorySoap[] toSoapModels(MBCategory[] models) {
        MBCategorySoap[] soapModels = new MBCategorySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MBCategorySoap[][] toSoapModels(MBCategory[][] models) {
        MBCategorySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MBCategorySoap[models.length][models[0].length];
        } else {
            soapModels = new MBCategorySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MBCategorySoap[] toSoapModels(List<MBCategory> models) {
        List<MBCategorySoap> soapModels = new ArrayList<MBCategorySoap>(models.size());

        for (MBCategory model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MBCategorySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _categoryId;
    }

    public void setPrimaryKey(long pk) {
        setCategoryId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public long getParentCategoryId() {
        return _parentCategoryId;
    }

    public void setParentCategoryId(long parentCategoryId) {
        _parentCategoryId = parentCategoryId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public int getThreadCount() {
        return _threadCount;
    }

    public void setThreadCount(int threadCount) {
        _threadCount = threadCount;
    }

    public int getMessageCount() {
        return _messageCount;
    }

    public void setMessageCount(int messageCount) {
        _messageCount = messageCount;
    }

    public Date getLastPostDate() {
        return _lastPostDate;
    }

    public void setLastPostDate(Date lastPostDate) {
        _lastPostDate = lastPostDate;
    }

    public long getImage_liferay() {
        return _image_liferay;
    }

    public void setImage_liferay(long image_liferay) {
        _image_liferay = image_liferay;
    }

    public int getOrderNumber() {
        return _orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        _orderNumber = orderNumber;
    }
}
