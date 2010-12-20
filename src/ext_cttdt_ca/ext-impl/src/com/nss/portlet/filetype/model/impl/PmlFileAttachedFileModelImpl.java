package com.nss.portlet.filetype.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.filetype.model.PmlFileAttachedFile;
import com.nss.portlet.filetype.model.PmlFileAttachedFileSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileAttachedFileModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFileAttachedFile</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.model.PmlFileAttachedFile
 * @see com.nss.portlet.filetype.model.PmlFileAttachedFileModel
 * @see com.nss.portlet.filetype.model.impl.PmlFileAttachedFileImpl
 *
 */
public class PmlFileAttachedFileModelImpl extends BaseModelImpl<PmlFileAttachedFile> {
    public static final String TABLE_NAME = "pml_file_attachedfile";
    public static final Object[][] TABLE_COLUMNS = {
            { "fileAttachedFileId", new Integer(Types.VARCHAR) },
            

            { "fileId", new Integer(Types.VARCHAR) },
            

            { "original", new Integer(Types.INTEGER) },
            

            { "copy_", new Integer(Types.INTEGER) },
            

            { "attachedFileId", new Integer(Types.VARCHAR) },
            

            { "attachedFileName", new Integer(Types.VARCHAR) },
            

            { "note", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_file_attachedfile (fileAttachedFileId VARCHAR(75) not null primary key,fileId VARCHAR(75) null,original INTEGER,copy_ INTEGER,attachedFileId VARCHAR(75) null,attachedFileName VARCHAR(75) null,note VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_file_attachedfile";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.filetype.model.PmlFileAttachedFile"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.filetype.model.PmlFileAttachedFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.filetype.model.PmlFileAttachedFile"));
    private String _fileAttachedFileId;
    private String _fileId;
    private int _original;
    private int _copy_;
    private String _attachedFileId;
    private String _attachedFileName;
    private String _note;

    public PmlFileAttachedFileModelImpl() {
    }

    public static PmlFileAttachedFile toModel(PmlFileAttachedFileSoap soapModel) {
        PmlFileAttachedFile model = new PmlFileAttachedFileImpl();

        model.setFileAttachedFileId(soapModel.getFileAttachedFileId());
        model.setFileId(soapModel.getFileId());
        model.setOriginal(soapModel.getOriginal());
        model.setCopy_(soapModel.getCopy_());
        model.setAttachedFileId(soapModel.getAttachedFileId());
        model.setAttachedFileName(soapModel.getAttachedFileName());
        model.setNote(soapModel.getNote());

        return model;
    }

    public static List<PmlFileAttachedFile> toModels(
        PmlFileAttachedFileSoap[] soapModels) {
        List<PmlFileAttachedFile> models = new ArrayList<PmlFileAttachedFile>(soapModels.length);

        for (PmlFileAttachedFileSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _fileAttachedFileId;
    }

    public void setPrimaryKey(String pk) {
        setFileAttachedFileId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _fileAttachedFileId;
    }

    public String getFileAttachedFileId() {
        return GetterUtil.getString(_fileAttachedFileId);
    }

    public void setFileAttachedFileId(String fileAttachedFileId) {
        _fileAttachedFileId = fileAttachedFileId;
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public int getOriginal() {
        return _original;
    }

    public void setOriginal(int original) {
        _original = original;
    }

    public int getCopy_() {
        return _copy_;
    }

    public void setCopy_(int copy_) {
        _copy_ = copy_;
    }

    public String getAttachedFileId() {
        return GetterUtil.getString(_attachedFileId);
    }

    public void setAttachedFileId(String attachedFileId) {
        _attachedFileId = attachedFileId;
    }

    public String getAttachedFileName() {
        return GetterUtil.getString(_attachedFileName);
    }

    public void setAttachedFileName(String attachedFileName) {
        _attachedFileName = attachedFileName;
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        _note = note;
    }

    public PmlFileAttachedFile toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFileAttachedFile) this;
        } else {
            PmlFileAttachedFile model = new PmlFileAttachedFileImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileAttachedFileId(HtmlUtil.escape(getFileAttachedFileId()));
            model.setFileId(HtmlUtil.escape(getFileId()));
            model.setOriginal(getOriginal());
            model.setCopy_(getCopy_());
            model.setAttachedFileId(HtmlUtil.escape(getAttachedFileId()));
            model.setAttachedFileName(HtmlUtil.escape(getAttachedFileName()));
            model.setNote(HtmlUtil.escape(getNote()));

            model = (PmlFileAttachedFile) Proxy.newProxyInstance(PmlFileAttachedFile.class.getClassLoader(),
                    new Class[] { PmlFileAttachedFile.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlFileAttachedFileImpl clone = new PmlFileAttachedFileImpl();

        clone.setFileAttachedFileId(getFileAttachedFileId());
        clone.setFileId(getFileId());
        clone.setOriginal(getOriginal());
        clone.setCopy_(getCopy_());
        clone.setAttachedFileId(getAttachedFileId());
        clone.setAttachedFileName(getAttachedFileName());
        clone.setNote(getNote());

        return clone;
    }

    public int compareTo(PmlFileAttachedFile pmlFileAttachedFile) {
        int value = 0;

        value = getFileAttachedFileId()
                    .compareTo(pmlFileAttachedFile.getFileAttachedFileId());

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

        PmlFileAttachedFile pmlFileAttachedFile = null;

        try {
            pmlFileAttachedFile = (PmlFileAttachedFile) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlFileAttachedFile.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{fileAttachedFileId=");
        sb.append(getFileAttachedFileId());
        sb.append(", fileId=");
        sb.append(getFileId());
        sb.append(", original=");
        sb.append(getOriginal());
        sb.append(", copy_=");
        sb.append(getCopy_());
        sb.append(", attachedFileId=");
        sb.append(getAttachedFileId());
        sb.append(", attachedFileName=");
        sb.append(getAttachedFileName());
        sb.append(", note=");
        sb.append(getNote());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.filetype.model.PmlFileAttachedFile");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fileAttachedFileId</column-name><column-value><![CDATA[");
        sb.append(getFileAttachedFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileId</column-name><column-value><![CDATA[");
        sb.append(getFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>original</column-name><column-value><![CDATA[");
        sb.append(getOriginal());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>copy_</column-name><column-value><![CDATA[");
        sb.append(getCopy_());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attachedFileId</column-name><column-value><![CDATA[");
        sb.append(getAttachedFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attachedFileName</column-name><column-value><![CDATA[");
        sb.append(getAttachedFileName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>note</column-name><column-value><![CDATA[");
        sb.append(getNote());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
