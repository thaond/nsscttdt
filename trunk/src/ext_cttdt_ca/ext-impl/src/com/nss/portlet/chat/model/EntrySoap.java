package com.nss.portlet.chat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="EntrySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.chat.service.http.EntryServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.chat.service.http.EntryServiceSoap
 *
 */
public class EntrySoap implements Serializable {
    private long _entryId;
    private long _createDate;
    private long _fromUserId;
    private long _toUserId;
    private String _content;

    public EntrySoap() {
    }

    public static EntrySoap toSoapModel(Entry model) {
        EntrySoap soapModel = new EntrySoap();

        soapModel.setEntryId(model.getEntryId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setFromUserId(model.getFromUserId());
        soapModel.setToUserId(model.getToUserId());
        soapModel.setContent(model.getContent());

        return soapModel;
    }

    public static EntrySoap[] toSoapModels(Entry[] models) {
        EntrySoap[] soapModels = new EntrySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EntrySoap[][] toSoapModels(Entry[][] models) {
        EntrySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EntrySoap[models.length][models[0].length];
        } else {
            soapModels = new EntrySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EntrySoap[] toSoapModels(List<Entry> models) {
        List<EntrySoap> soapModels = new ArrayList<EntrySoap>(models.size());

        for (Entry model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EntrySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _entryId;
    }

    public void setPrimaryKey(long pk) {
        setEntryId(pk);
    }

    public long getEntryId() {
        return _entryId;
    }

    public void setEntryId(long entryId) {
        _entryId = entryId;
    }

    public long getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(long createDate) {
        _createDate = createDate;
    }

    public long getFromUserId() {
        return _fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        _fromUserId = fromUserId;
    }

    public long getToUserId() {
        return _toUserId;
    }

    public void setToUserId(long toUserId) {
        _toUserId = toUserId;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }
}
