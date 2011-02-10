package com.sgs.portlet.document_manager.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document_manager.model.AttactFileDocument;
import com.sgs.portlet.document_manager.model.AttactFileDocumentSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="AttactFileDocumentModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>AttactFileDocument</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document_manager.model.AttactFileDocument
 * @see com.sgs.portlet.document_manager.model.AttactFileDocumentModel
 * @see com.sgs.portlet.document_manager.model.impl.AttactFileDocumentImpl
 *
 */
public class AttactFileDocumentModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "attact_file_document";
    public static final Object[][] TABLE_COLUMNS = {
            { "attactFileDocumentId", new Integer(Types.BIGINT) },
            

            { "attactFileDocumentTitle", new Integer(Types.VARCHAR) },
            

            { "attactFileDocumentPath", new Integer(Types.VARCHAR) },
            

            { "documentManagerId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table attact_file_document (attactFileDocumentId LONG not null primary key,attactFileDocumentTitle VARCHAR(75) null,attactFileDocumentPath VARCHAR(75) null,documentManagerId LONG,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table attact_file_document";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document_manager.model.AttactFileDocument"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document_manager.model.AttactFileDocument"));
    private long _attactFileDocumentId;
    private String _attactFileDocumentTitle;
    private String _attactFileDocumentPath;
    private long _documentManagerId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public AttactFileDocumentModelImpl() {
    }

    public static AttactFileDocument toModel(AttactFileDocumentSoap soapModel) {
        AttactFileDocument model = new AttactFileDocumentImpl();

        model.setAttactFileDocumentId(soapModel.getAttactFileDocumentId());
        model.setAttactFileDocumentTitle(soapModel.getAttactFileDocumentTitle());
        model.setAttactFileDocumentPath(soapModel.getAttactFileDocumentPath());
        model.setDocumentManagerId(soapModel.getDocumentManagerId());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<AttactFileDocument> toModels(
        AttactFileDocumentSoap[] soapModels) {
        List<AttactFileDocument> models = new ArrayList<AttactFileDocument>(soapModels.length);

        for (AttactFileDocumentSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _attactFileDocumentId;
    }

    public void setPrimaryKey(long pk) {
        setAttactFileDocumentId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_attactFileDocumentId);
    }

    public long getAttactFileDocumentId() {
        return _attactFileDocumentId;
    }

    public void setAttactFileDocumentId(long attactFileDocumentId) {
        if (attactFileDocumentId != _attactFileDocumentId) {
            _attactFileDocumentId = attactFileDocumentId;
        }
    }

    public String getAttactFileDocumentTitle() {
        return GetterUtil.getString(_attactFileDocumentTitle);
    }

    public void setAttactFileDocumentTitle(String attactFileDocumentTitle) {
        if (((attactFileDocumentTitle == null) &&
                (_attactFileDocumentTitle != null)) ||
                ((attactFileDocumentTitle != null) &&
                (_attactFileDocumentTitle == null)) ||
                ((attactFileDocumentTitle != null) &&
                (_attactFileDocumentTitle != null) &&
                !attactFileDocumentTitle.equals(_attactFileDocumentTitle))) {
            _attactFileDocumentTitle = attactFileDocumentTitle;
        }
    }

    public String getAttactFileDocumentPath() {
        return GetterUtil.getString(_attactFileDocumentPath);
    }

    public void setAttactFileDocumentPath(String attactFileDocumentPath) {
        if (((attactFileDocumentPath == null) &&
                (_attactFileDocumentPath != null)) ||
                ((attactFileDocumentPath != null) &&
                (_attactFileDocumentPath == null)) ||
                ((attactFileDocumentPath != null) &&
                (_attactFileDocumentPath != null) &&
                !attactFileDocumentPath.equals(_attactFileDocumentPath))) {
            _attactFileDocumentPath = attactFileDocumentPath;
        }
    }

    public long getDocumentManagerId() {
        return _documentManagerId;
    }

    public void setDocumentManagerId(long documentManagerId) {
        if (documentManagerId != _documentManagerId) {
            _documentManagerId = documentManagerId;
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

    public AttactFileDocument toEscapedModel() {
        if (isEscapedModel()) {
            return (AttactFileDocument) this;
        } else {
            AttactFileDocument model = new AttactFileDocumentImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setAttactFileDocumentId(getAttactFileDocumentId());
            model.setAttactFileDocumentTitle(HtmlUtil.escape(
                    getAttactFileDocumentTitle()));
            model.setAttactFileDocumentPath(HtmlUtil.escape(
                    getAttactFileDocumentPath()));
            model.setDocumentManagerId(getDocumentManagerId());
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (AttactFileDocument) Proxy.newProxyInstance(AttactFileDocument.class.getClassLoader(),
                    new Class[] { AttactFileDocument.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        AttactFileDocumentImpl clone = new AttactFileDocumentImpl();

        clone.setAttactFileDocumentId(getAttactFileDocumentId());
        clone.setAttactFileDocumentTitle(getAttactFileDocumentTitle());
        clone.setAttactFileDocumentPath(getAttactFileDocumentPath());
        clone.setDocumentManagerId(getDocumentManagerId());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        AttactFileDocumentImpl attactFileDocument = (AttactFileDocumentImpl) obj;

        long pk = attactFileDocument.getPrimaryKey();

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

        AttactFileDocumentImpl attactFileDocument = null;

        try {
            attactFileDocument = (AttactFileDocumentImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = attactFileDocument.getPrimaryKey();

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
