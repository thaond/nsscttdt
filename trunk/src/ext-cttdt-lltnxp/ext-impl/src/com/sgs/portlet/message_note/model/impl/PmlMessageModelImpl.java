package com.sgs.portlet.message_note.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.message_note.model.PmlMessage;
import com.sgs.portlet.message_note.model.PmlMessageSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlMessageModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlMessage</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.message_note.model.PmlMessage
 * @see com.sgs.portlet.message_note.model.PmlMessageModel
 * @see com.sgs.portlet.message_note.model.impl.PmlMessageImpl
 *
 */
public class PmlMessageModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_message_note";
    public static final Object[][] TABLE_COLUMNS = {
            { "messageId", new Integer(Types.BIGINT) },
            

            { "documentId", new Integer(Types.BIGINT) },
            

            { "fromUserId", new Integer(Types.BIGINT) },
            

            { "toUserId", new Integer(Types.BIGINT) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "objectType", new Integer(Types.VARCHAR) },
            

            { "isAlert", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_message_note (messageId LONG not null primary key,documentId LONG,fromUserId LONG,toUserId LONG,createDate DATE null,objectType VARCHAR(75) null,isAlert BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_message_note";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.message_note.model.PmlMessage"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.message_note.model.PmlMessage"));
    private long _messageId;
    private long _documentId;
    private long _fromUserId;
    private long _toUserId;
    private Date _createDate;
    private String _objectType;
    private boolean _isAlert;

    public PmlMessageModelImpl() {
    }

    public static PmlMessage toModel(PmlMessageSoap soapModel) {
        PmlMessage model = new PmlMessageImpl();

        model.setMessageId(soapModel.getMessageId());
        model.setDocumentId(soapModel.getDocumentId());
        model.setFromUserId(soapModel.getFromUserId());
        model.setToUserId(soapModel.getToUserId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setObjectType(soapModel.getObjectType());
        model.setIsAlert(soapModel.getIsAlert());

        return model;
    }

    public static List<PmlMessage> toModels(PmlMessageSoap[] soapModels) {
        List<PmlMessage> models = new ArrayList<PmlMessage>(soapModels.length);

        for (PmlMessageSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _messageId;
    }

    public void setPrimaryKey(long pk) {
        setMessageId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_messageId);
    }

    public long getMessageId() {
        return _messageId;
    }

    public void setMessageId(long messageId) {
        if (messageId != _messageId) {
            _messageId = messageId;
        }
    }

    public long getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(long documentId) {
        if (documentId != _documentId) {
            _documentId = documentId;
        }
    }

    public long getFromUserId() {
        return _fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        if (fromUserId != _fromUserId) {
            _fromUserId = fromUserId;
        }
    }

    public long getToUserId() {
        return _toUserId;
    }

    public void setToUserId(long toUserId) {
        if (toUserId != _toUserId) {
            _toUserId = toUserId;
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

    public String getObjectType() {
        return GetterUtil.getString(_objectType);
    }

    public void setObjectType(String objectType) {
        if (((objectType == null) && (_objectType != null)) ||
                ((objectType != null) && (_objectType == null)) ||
                ((objectType != null) && (_objectType != null) &&
                !objectType.equals(_objectType))) {
            _objectType = objectType;
        }
    }

    public boolean getIsAlert() {
        return _isAlert;
    }

    public boolean isIsAlert() {
        return _isAlert;
    }

    public void setIsAlert(boolean isAlert) {
        if (isAlert != _isAlert) {
            _isAlert = isAlert;
        }
    }

    public PmlMessage toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlMessage) this;
        } else {
            PmlMessage model = new PmlMessageImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMessageId(getMessageId());
            model.setDocumentId(getDocumentId());
            model.setFromUserId(getFromUserId());
            model.setToUserId(getToUserId());
            model.setCreateDate(getCreateDate());
            model.setObjectType(HtmlUtil.escape(getObjectType()));
            model.setIsAlert(getIsAlert());

            model = (PmlMessage) Proxy.newProxyInstance(PmlMessage.class.getClassLoader(),
                    new Class[] { PmlMessage.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlMessageImpl clone = new PmlMessageImpl();

        clone.setMessageId(getMessageId());
        clone.setDocumentId(getDocumentId());
        clone.setFromUserId(getFromUserId());
        clone.setToUserId(getToUserId());
        clone.setCreateDate(getCreateDate());
        clone.setObjectType(getObjectType());
        clone.setIsAlert(getIsAlert());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlMessageImpl pmlMessage = (PmlMessageImpl) obj;

        int value = 0;

        value = DateUtil.compareTo(getCreateDate(), pmlMessage.getCreateDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlMessageImpl pmlMessage = null;

        try {
            pmlMessage = (PmlMessageImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlMessage.getPrimaryKey();

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
