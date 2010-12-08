package com.nss.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile;
import com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFileSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFilePCCCAttachedFileModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFilePCCCAttachedFile</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile
 * @see com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFileModel
 * @see com.nss.portlet.onedoor.model.impl.PmlFilePCCCAttachedFileImpl
 *
 */
public class PmlFilePCCCAttachedFileModelImpl extends BaseModelImpl<PmlFilePCCCAttachedFile> {
    public static final String TABLE_NAME = "pml_filepccc_attachedfile";
    public static final Object[][] TABLE_COLUMNS = {
            { "attachedfileid", new Integer(Types.BIGINT) },
            

            { "filepcccid", new Integer(Types.VARCHAR) },
            

            { "objecttype", new Integer(Types.VARCHAR) },
            

            { "attachedfilename", new Integer(Types.VARCHAR) },
            

            { "path", new Integer(Types.VARCHAR) },
            

            { "datecreated", new Integer(Types.TIMESTAMP) },
            

            { "filetype", new Integer(Types.VARCHAR) },
            

            { "title", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_filepccc_attachedfile (attachedfileid LONG not null primary key,filepcccid VARCHAR(75) null,objecttype VARCHAR(75) null,attachedfilename VARCHAR(75) null,path VARCHAR(75) null,datecreated DATE null,filetype VARCHAR(75) null,title VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_filepccc_attachedfile";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile"));
    private long _attachedFileId;
    private String _filePcccId;
    private String _objectType;
    private String _attachedFileName;
    private String _path;
    private Date _dateCreated;
    private String _fileType;
    private String _title;
    private transient ExpandoBridge _expandoBridge;

    public PmlFilePCCCAttachedFileModelImpl() {
    }

    public static PmlFilePCCCAttachedFile toModel(
        PmlFilePCCCAttachedFileSoap soapModel) {
        PmlFilePCCCAttachedFile model = new PmlFilePCCCAttachedFileImpl();

        model.setAttachedFileId(soapModel.getAttachedFileId());
        model.setFilePcccId(soapModel.getFilePcccId());
        model.setObjectType(soapModel.getObjectType());
        model.setAttachedFileName(soapModel.getAttachedFileName());
        model.setPath(soapModel.getPath());
        model.setDateCreated(soapModel.getDateCreated());
        model.setFileType(soapModel.getFileType());
        model.setTitle(soapModel.getTitle());

        return model;
    }

    public static List<PmlFilePCCCAttachedFile> toModels(
        PmlFilePCCCAttachedFileSoap[] soapModels) {
        List<PmlFilePCCCAttachedFile> models = new ArrayList<PmlFilePCCCAttachedFile>(soapModels.length);

        for (PmlFilePCCCAttachedFileSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _attachedFileId;
    }

    public void setPrimaryKey(long pk) {
        setAttachedFileId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_attachedFileId);
    }

    public long getAttachedFileId() {
        return _attachedFileId;
    }

    public void setAttachedFileId(long attachedFileId) {
        _attachedFileId = attachedFileId;
    }

    public String getFilePcccId() {
        return GetterUtil.getString(_filePcccId);
    }

    public void setFilePcccId(String filePcccId) {
        _filePcccId = filePcccId;
    }

    public String getObjectType() {
        return GetterUtil.getString(_objectType);
    }

    public void setObjectType(String objectType) {
        _objectType = objectType;
    }

    public String getAttachedFileName() {
        return GetterUtil.getString(_attachedFileName);
    }

    public void setAttachedFileName(String attachedFileName) {
        _attachedFileName = attachedFileName;
    }

    public String getPath() {
        return GetterUtil.getString(_path);
    }

    public void setPath(String path) {
        _path = path;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
    }

    public String getFileType() {
        return GetterUtil.getString(_fileType);
    }

    public void setFileType(String fileType) {
        _fileType = fileType;
    }

    public String getTitle() {
        return GetterUtil.getString(_title);
    }

    public void setTitle(String title) {
        _title = title;
    }

    public PmlFilePCCCAttachedFile toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFilePCCCAttachedFile) this;
        } else {
            PmlFilePCCCAttachedFile model = new PmlFilePCCCAttachedFileImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setAttachedFileId(getAttachedFileId());
            model.setFilePcccId(HtmlUtil.escape(getFilePcccId()));
            model.setObjectType(HtmlUtil.escape(getObjectType()));
            model.setAttachedFileName(HtmlUtil.escape(getAttachedFileName()));
            model.setPath(HtmlUtil.escape(getPath()));
            model.setDateCreated(getDateCreated());
            model.setFileType(HtmlUtil.escape(getFileType()));
            model.setTitle(HtmlUtil.escape(getTitle()));

            model = (PmlFilePCCCAttachedFile) Proxy.newProxyInstance(PmlFilePCCCAttachedFile.class.getClassLoader(),
                    new Class[] { PmlFilePCCCAttachedFile.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlFilePCCCAttachedFile.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PmlFilePCCCAttachedFileImpl clone = new PmlFilePCCCAttachedFileImpl();

        clone.setAttachedFileId(getAttachedFileId());
        clone.setFilePcccId(getFilePcccId());
        clone.setObjectType(getObjectType());
        clone.setAttachedFileName(getAttachedFileName());
        clone.setPath(getPath());
        clone.setDateCreated(getDateCreated());
        clone.setFileType(getFileType());
        clone.setTitle(getTitle());

        return clone;
    }

    public int compareTo(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile) {
        long pk = pmlFilePCCCAttachedFile.getPrimaryKey();

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

        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = null;

        try {
            pmlFilePCCCAttachedFile = (PmlFilePCCCAttachedFile) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlFilePCCCAttachedFile.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{attachedFileId=");
        sb.append(getAttachedFileId());
        sb.append(", filePcccId=");
        sb.append(getFilePcccId());
        sb.append(", objectType=");
        sb.append(getObjectType());
        sb.append(", attachedFileName=");
        sb.append(getAttachedFileName());
        sb.append(", path=");
        sb.append(getPath());
        sb.append(", dateCreated=");
        sb.append(getDateCreated());
        sb.append(", fileType=");
        sb.append(getFileType());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>attachedFileId</column-name><column-value><![CDATA[");
        sb.append(getAttachedFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>filePcccId</column-name><column-value><![CDATA[");
        sb.append(getFilePcccId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectType</column-name><column-value><![CDATA[");
        sb.append(getObjectType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attachedFileName</column-name><column-value><![CDATA[");
        sb.append(getAttachedFileName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>path</column-name><column-value><![CDATA[");
        sb.append(getPath());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateCreated</column-name><column-value><![CDATA[");
        sb.append(getDateCreated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileType</column-name><column-value><![CDATA[");
        sb.append(getFileType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
