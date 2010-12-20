package com.nss.portlet.journal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="JournalContentSearchSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.journal.service.http.JournalContentSearchServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.http.JournalContentSearchServiceSoap
 *
 */
public class JournalContentSearchSoap implements Serializable {
    private long _contentSearchId;
    private long _groupId;
    private long _companyId;
    private boolean _privateLayout;
    private long _layoutId;
    private String _portletId;
    private String _articleId;

    public JournalContentSearchSoap() {
    }

    public static JournalContentSearchSoap toSoapModel(
        JournalContentSearch model) {
        JournalContentSearchSoap soapModel = new JournalContentSearchSoap();

        soapModel.setContentSearchId(model.getContentSearchId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setPrivateLayout(model.getPrivateLayout());
        soapModel.setLayoutId(model.getLayoutId());
        soapModel.setPortletId(model.getPortletId());
        soapModel.setArticleId(model.getArticleId());

        return soapModel;
    }

    public static JournalContentSearchSoap[] toSoapModels(
        JournalContentSearch[] models) {
        JournalContentSearchSoap[] soapModels = new JournalContentSearchSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static JournalContentSearchSoap[][] toSoapModels(
        JournalContentSearch[][] models) {
        JournalContentSearchSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new JournalContentSearchSoap[models.length][models[0].length];
        } else {
            soapModels = new JournalContentSearchSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static JournalContentSearchSoap[] toSoapModels(
        List<JournalContentSearch> models) {
        List<JournalContentSearchSoap> soapModels = new ArrayList<JournalContentSearchSoap>(models.size());

        for (JournalContentSearch model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new JournalContentSearchSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contentSearchId;
    }

    public void setPrimaryKey(long pk) {
        setContentSearchId(pk);
    }

    public long getContentSearchId() {
        return _contentSearchId;
    }

    public void setContentSearchId(long contentSearchId) {
        _contentSearchId = contentSearchId;
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

    public boolean getPrivateLayout() {
        return _privateLayout;
    }

    public boolean isPrivateLayout() {
        return _privateLayout;
    }

    public void setPrivateLayout(boolean privateLayout) {
        _privateLayout = privateLayout;
    }

    public long getLayoutId() {
        return _layoutId;
    }

    public void setLayoutId(long layoutId) {
        _layoutId = layoutId;
    }

    public String getPortletId() {
        return _portletId;
    }

    public void setPortletId(String portletId) {
        _portletId = portletId;
    }

    public String getArticleId() {
        return _articleId;
    }

    public void setArticleId(String articleId) {
        _articleId = articleId;
    }
}
