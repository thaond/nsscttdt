package com.nss.portlet.journal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="JournalArticleSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.journal.service.http.JournalArticleServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.http.JournalArticleServiceSoap
 *
 */
public class JournalArticleSoap implements Serializable {
    private String _uuid;
    private long _id;
    private long _resourcePrimKey;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _articleId;
    private double _version;
    private String _title;
    private String _urlTitle;
    private String _description;
    private String _content;
    private String _type;
    private String _structureId;
    private String _templateId;
    private Date _displayDate;
    private boolean _approved;
    private long _approvedByUserId;
    private String _approvedByUserName;
    private Date _approvedDate;
    private boolean _expired;
    private Date _expirationDate;
    private Date _reviewDate;
    private boolean _indexable;
    private boolean _smallImage;
    private long _smallImageId;
    private String _smallImageURL;

    public JournalArticleSoap() {
    }

    public static JournalArticleSoap toSoapModel(JournalArticle model) {
        JournalArticleSoap soapModel = new JournalArticleSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setResourcePrimKey(model.getResourcePrimKey());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setArticleId(model.getArticleId());
        soapModel.setVersion(model.getVersion());
        soapModel.setTitle(model.getTitle());
        soapModel.setUrlTitle(model.getUrlTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setContent(model.getContent());
        soapModel.setType(model.getType());
        soapModel.setStructureId(model.getStructureId());
        soapModel.setTemplateId(model.getTemplateId());
        soapModel.setDisplayDate(model.getDisplayDate());
        soapModel.setApproved(model.getApproved());
        soapModel.setApprovedByUserId(model.getApprovedByUserId());
        soapModel.setApprovedByUserName(model.getApprovedByUserName());
        soapModel.setApprovedDate(model.getApprovedDate());
        soapModel.setExpired(model.getExpired());
        soapModel.setExpirationDate(model.getExpirationDate());
        soapModel.setReviewDate(model.getReviewDate());
        soapModel.setIndexable(model.getIndexable());
        soapModel.setSmallImage(model.getSmallImage());
        soapModel.setSmallImageId(model.getSmallImageId());
        soapModel.setSmallImageURL(model.getSmallImageURL());

        return soapModel;
    }

    public static JournalArticleSoap[] toSoapModels(JournalArticle[] models) {
        JournalArticleSoap[] soapModels = new JournalArticleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static JournalArticleSoap[][] toSoapModels(JournalArticle[][] models) {
        JournalArticleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new JournalArticleSoap[models.length][models[0].length];
        } else {
            soapModels = new JournalArticleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static JournalArticleSoap[] toSoapModels(List<JournalArticle> models) {
        List<JournalArticleSoap> soapModels = new ArrayList<JournalArticleSoap>(models.size());

        for (JournalArticle model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new JournalArticleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
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

    public String getArticleId() {
        return _articleId;
    }

    public void setArticleId(String articleId) {
        _articleId = articleId;
    }

    public double getVersion() {
        return _version;
    }

    public void setVersion(double version) {
        _version = version;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getUrlTitle() {
        return _urlTitle;
    }

    public void setUrlTitle(String urlTitle) {
        _urlTitle = urlTitle;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public String getStructureId() {
        return _structureId;
    }

    public void setStructureId(String structureId) {
        _structureId = structureId;
    }

    public String getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(String templateId) {
        _templateId = templateId;
    }

    public Date getDisplayDate() {
        return _displayDate;
    }

    public void setDisplayDate(Date displayDate) {
        _displayDate = displayDate;
    }

    public boolean getApproved() {
        return _approved;
    }

    public boolean isApproved() {
        return _approved;
    }

    public void setApproved(boolean approved) {
        _approved = approved;
    }

    public long getApprovedByUserId() {
        return _approvedByUserId;
    }

    public void setApprovedByUserId(long approvedByUserId) {
        _approvedByUserId = approvedByUserId;
    }

    public String getApprovedByUserName() {
        return _approvedByUserName;
    }

    public void setApprovedByUserName(String approvedByUserName) {
        _approvedByUserName = approvedByUserName;
    }

    public Date getApprovedDate() {
        return _approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        _approvedDate = approvedDate;
    }

    public boolean getExpired() {
        return _expired;
    }

    public boolean isExpired() {
        return _expired;
    }

    public void setExpired(boolean expired) {
        _expired = expired;
    }

    public Date getExpirationDate() {
        return _expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        _expirationDate = expirationDate;
    }

    public Date getReviewDate() {
        return _reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        _reviewDate = reviewDate;
    }

    public boolean getIndexable() {
        return _indexable;
    }

    public boolean isIndexable() {
        return _indexable;
    }

    public void setIndexable(boolean indexable) {
        _indexable = indexable;
    }

    public boolean getSmallImage() {
        return _smallImage;
    }

    public boolean isSmallImage() {
        return _smallImage;
    }

    public void setSmallImage(boolean smallImage) {
        _smallImage = smallImage;
    }

    public long getSmallImageId() {
        return _smallImageId;
    }

    public void setSmallImageId(long smallImageId) {
        _smallImageId = smallImageId;
    }

    public String getSmallImageURL() {
        return _smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        _smallImageURL = smallImageURL;
    }
}
