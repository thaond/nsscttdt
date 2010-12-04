package com.nss.portlet.journal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="JournalArticleResourceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.journal.service.http.JournalArticleResourceServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.http.JournalArticleResourceServiceSoap
 *
 */
public class JournalArticleResourceSoap implements Serializable {
    private long _resourcePrimKey;
    private long _groupId;
    private String _articleId;

    public JournalArticleResourceSoap() {
    }

    public static JournalArticleResourceSoap toSoapModel(
        JournalArticleResource model) {
        JournalArticleResourceSoap soapModel = new JournalArticleResourceSoap();

        soapModel.setResourcePrimKey(model.getResourcePrimKey());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setArticleId(model.getArticleId());

        return soapModel;
    }

    public static JournalArticleResourceSoap[] toSoapModels(
        JournalArticleResource[] models) {
        JournalArticleResourceSoap[] soapModels = new JournalArticleResourceSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static JournalArticleResourceSoap[][] toSoapModels(
        JournalArticleResource[][] models) {
        JournalArticleResourceSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new JournalArticleResourceSoap[models.length][models[0].length];
        } else {
            soapModels = new JournalArticleResourceSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static JournalArticleResourceSoap[] toSoapModels(
        List<JournalArticleResource> models) {
        List<JournalArticleResourceSoap> soapModels = new ArrayList<JournalArticleResourceSoap>(models.size());

        for (JournalArticleResource model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new JournalArticleResourceSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _resourcePrimKey;
    }

    public void setPrimaryKey(long pk) {
        setResourcePrimKey(pk);
    }

    public long getResourcePrimKey() {
        return _resourcePrimKey;
    }

    public void setResourcePrimKey(long resourcePrimKey) {
        _resourcePrimKey = resourcePrimKey;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public String getArticleId() {
        return _articleId;
    }

    public void setArticleId(String articleId) {
        _articleId = articleId;
    }
}
