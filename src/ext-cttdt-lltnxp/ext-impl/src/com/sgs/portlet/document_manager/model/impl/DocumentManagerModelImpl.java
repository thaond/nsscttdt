package com.sgs.portlet.document_manager.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document_manager.model.DocumentManager;
import com.sgs.portlet.document_manager.model.DocumentManagerSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="DocumentManagerModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>DocumentManager</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.model.DocumentManager
 * @see com.sgs.portlet.document_manager.model.DocumentManagerModel
 * @see com.sgs.portlet.document_manager.model.impl.DocumentManagerImpl
 *
 */
public class DocumentManagerModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "document_manager";
    public static final Object[][] TABLE_COLUMNS = {
            { "documentManagerId", new Integer(Types.BIGINT) },
            

            { "documentManagerCode", new Integer(Types.VARCHAR) },
            

            { "documentManagerCategory", new Integer(Types.VARCHAR) },
            

            { "documentManagerStyle", new Integer(Types.VARCHAR) },
            

            { "documentManagerDescription", new Integer(Types.VARCHAR) },
            

            { "documentManagerDateCreate", new Integer(Types.TIMESTAMP) },
            

            { "documentManagerTitle", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table document_manager (documentManagerId LONG not null primary key,documentManagerCode VARCHAR(75) null,documentManagerCategory VARCHAR(75) null,documentManagerStyle VARCHAR(75) null,documentManagerDescription VARCHAR(75) null,documentManagerDateCreate DATE null,documentManagerTitle VARCHAR(75) null,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table document_manager";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document_manager.model.DocumentManager"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document_manager.model.DocumentManager"));
    private long _documentManagerId;
    private String _documentManagerCode;
    private String _documentManagerCategory;
    private String _documentManagerStyle;
    private String _documentManagerDescription;
    private Date _documentManagerDateCreate;
    private String _documentManagerTitle;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public DocumentManagerModelImpl() {
    }

    public static DocumentManager toModel(DocumentManagerSoap soapModel) {
        DocumentManager model = new DocumentManagerImpl();

        model.setDocumentManagerId(soapModel.getDocumentManagerId());
        model.setDocumentManagerCode(soapModel.getDocumentManagerCode());
        model.setDocumentManagerCategory(soapModel.getDocumentManagerCategory());
        model.setDocumentManagerStyle(soapModel.getDocumentManagerStyle());
        model.setDocumentManagerDescription(soapModel.getDocumentManagerDescription());
        model.setDocumentManagerDateCreate(soapModel.getDocumentManagerDateCreate());
        model.setDocumentManagerTitle(soapModel.getDocumentManagerTitle());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<DocumentManager> toModels(
        DocumentManagerSoap[] soapModels) {
        List<DocumentManager> models = new ArrayList<DocumentManager>(soapModels.length);

        for (DocumentManagerSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _documentManagerId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentManagerId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_documentManagerId);
    }

    public long getDocumentManagerId() {
        return _documentManagerId;
    }

    public void setDocumentManagerId(long documentManagerId) {
        if (documentManagerId != _documentManagerId) {
            _documentManagerId = documentManagerId;
        }
    }

    public String getDocumentManagerCode() {
        return GetterUtil.getString(_documentManagerCode);
    }

    public void setDocumentManagerCode(String documentManagerCode) {
        if (((documentManagerCode == null) && (_documentManagerCode != null)) ||
                ((documentManagerCode != null) &&
                (_documentManagerCode == null)) ||
                ((documentManagerCode != null) &&
                (_documentManagerCode != null) &&
                !documentManagerCode.equals(_documentManagerCode))) {
            _documentManagerCode = documentManagerCode;
        }
    }

    public String getDocumentManagerCategory() {
        return GetterUtil.getString(_documentManagerCategory);
    }

    public void setDocumentManagerCategory(String documentManagerCategory) {
        if (((documentManagerCategory == null) &&
                (_documentManagerCategory != null)) ||
                ((documentManagerCategory != null) &&
                (_documentManagerCategory == null)) ||
                ((documentManagerCategory != null) &&
                (_documentManagerCategory != null) &&
                !documentManagerCategory.equals(_documentManagerCategory))) {
            _documentManagerCategory = documentManagerCategory;
        }
    }

    public String getDocumentManagerStyle() {
        return GetterUtil.getString(_documentManagerStyle);
    }

    public void setDocumentManagerStyle(String documentManagerStyle) {
        if (((documentManagerStyle == null) && (_documentManagerStyle != null)) ||
                ((documentManagerStyle != null) &&
                (_documentManagerStyle == null)) ||
                ((documentManagerStyle != null) &&
                (_documentManagerStyle != null) &&
                !documentManagerStyle.equals(_documentManagerStyle))) {
            _documentManagerStyle = documentManagerStyle;
        }
    }

    public String getDocumentManagerDescription() {
        return GetterUtil.getString(_documentManagerDescription);
    }

    public void setDocumentManagerDescription(String documentManagerDescription) {
        if (((documentManagerDescription == null) &&
                (_documentManagerDescription != null)) ||
                ((documentManagerDescription != null) &&
                (_documentManagerDescription == null)) ||
                ((documentManagerDescription != null) &&
                (_documentManagerDescription != null) &&
                !documentManagerDescription.equals(_documentManagerDescription))) {
            _documentManagerDescription = documentManagerDescription;
        }
    }

    public Date getDocumentManagerDateCreate() {
        return _documentManagerDateCreate;
    }

    public void setDocumentManagerDateCreate(Date documentManagerDateCreate) {
        if (((documentManagerDateCreate == null) &&
                (_documentManagerDateCreate != null)) ||
                ((documentManagerDateCreate != null) &&
                (_documentManagerDateCreate == null)) ||
                ((documentManagerDateCreate != null) &&
                (_documentManagerDateCreate != null) &&
                !documentManagerDateCreate.equals(_documentManagerDateCreate))) {
            _documentManagerDateCreate = documentManagerDateCreate;
        }
    }

    public String getDocumentManagerTitle() {
        return GetterUtil.getString(_documentManagerTitle);
    }

    public void setDocumentManagerTitle(String documentManagerTitle) {
        if (((documentManagerTitle == null) && (_documentManagerTitle != null)) ||
                ((documentManagerTitle != null) &&
                (_documentManagerTitle == null)) ||
                ((documentManagerTitle != null) &&
                (_documentManagerTitle != null) &&
                !documentManagerTitle.equals(_documentManagerTitle))) {
            _documentManagerTitle = documentManagerTitle;
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

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        if (groupId != _groupId) {
            _groupId = groupId;
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

    public DocumentManager toEscapedModel() {
        if (isEscapedModel()) {
            return (DocumentManager) this;
        } else {
            DocumentManager model = new DocumentManagerImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDocumentManagerId(getDocumentManagerId());
            model.setDocumentManagerCode(HtmlUtil.escape(
                    getDocumentManagerCode()));
            model.setDocumentManagerCategory(HtmlUtil.escape(
                    getDocumentManagerCategory()));
            model.setDocumentManagerStyle(HtmlUtil.escape(
                    getDocumentManagerStyle()));
            model.setDocumentManagerDescription(HtmlUtil.escape(
                    getDocumentManagerDescription()));
            model.setDocumentManagerDateCreate(getDocumentManagerDateCreate());
            model.setDocumentManagerTitle(HtmlUtil.escape(
                    getDocumentManagerTitle()));
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (DocumentManager) Proxy.newProxyInstance(DocumentManager.class.getClassLoader(),
                    new Class[] { DocumentManager.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        DocumentManagerImpl clone = new DocumentManagerImpl();

        clone.setDocumentManagerId(getDocumentManagerId());
        clone.setDocumentManagerCode(getDocumentManagerCode());
        clone.setDocumentManagerCategory(getDocumentManagerCategory());
        clone.setDocumentManagerStyle(getDocumentManagerStyle());
        clone.setDocumentManagerDescription(getDocumentManagerDescription());
        clone.setDocumentManagerDateCreate(getDocumentManagerDateCreate());
        clone.setDocumentManagerTitle(getDocumentManagerTitle());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        DocumentManagerImpl documentManager = (DocumentManagerImpl) obj;

        long pk = documentManager.getPrimaryKey();

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

        DocumentManagerImpl documentManager = null;

        try {
            documentManager = (DocumentManagerImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = documentManager.getPrimaryKey();

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
