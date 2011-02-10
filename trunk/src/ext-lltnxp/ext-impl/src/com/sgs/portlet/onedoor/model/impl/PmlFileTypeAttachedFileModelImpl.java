package com.sgs.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFileSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileTypeAttachedFileModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFileTypeAttachedFile</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile
 * @see com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFileModel
 * @see com.sgs.portlet.onedoor.model.impl.PmlFileTypeAttachedFileImpl
 *
 */
public class PmlFileTypeAttachedFileModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_filetype_attachedfile";
    public static final Object[][] TABLE_COLUMNS = {
            { "filetypeAttachedFileId", new Integer(Types.VARCHAR) },
            

            { "fileTypeId", new Integer(Types.VARCHAR) },
            

            { "original", new Integer(Types.INTEGER) },
            

            { "copy_", new Integer(Types.INTEGER) },
            

            { "attachedFileId", new Integer(Types.VARCHAR) },
            

            { "attachedFileName", new Integer(Types.VARCHAR) },
            

            { "note", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_filetype_attachedfile (filetypeAttachedFileId VARCHAR(75) not null primary key,fileTypeId VARCHAR(75) null,original INTEGER,copy_ INTEGER,attachedFileId VARCHAR(75) null,attachedFileName VARCHAR(75) null,note VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_filetype_attachedfile";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile"));
    private String _filetypeAttachedFileId;
    private String _fileTypeId;
    private int _original;
    private int _copy_;
    private String _attachedFileId;
    private String _attachedFileName;
    private String _note;

    public PmlFileTypeAttachedFileModelImpl() {
    }

    public static PmlFileTypeAttachedFile toModel(
        PmlFileTypeAttachedFileSoap soapModel) {
        PmlFileTypeAttachedFile model = new PmlFileTypeAttachedFileImpl();

        model.setFiletypeAttachedFileId(soapModel.getFiletypeAttachedFileId());
        model.setFileTypeId(soapModel.getFileTypeId());
        model.setOriginal(soapModel.getOriginal());
        model.setCopy_(soapModel.getCopy_());
        model.setAttachedFileId(soapModel.getAttachedFileId());
        model.setAttachedFileName(soapModel.getAttachedFileName());
        model.setNote(soapModel.getNote());

        return model;
    }

    public static List<PmlFileTypeAttachedFile> toModels(
        PmlFileTypeAttachedFileSoap[] soapModels) {
        List<PmlFileTypeAttachedFile> models = new ArrayList<PmlFileTypeAttachedFile>(soapModels.length);

        for (PmlFileTypeAttachedFileSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _filetypeAttachedFileId;
    }

    public void setPrimaryKey(String pk) {
        setFiletypeAttachedFileId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _filetypeAttachedFileId;
    }

    public String getFiletypeAttachedFileId() {
        return GetterUtil.getString(_filetypeAttachedFileId);
    }

    public void setFiletypeAttachedFileId(String filetypeAttachedFileId) {
        if (((filetypeAttachedFileId == null) &&
                (_filetypeAttachedFileId != null)) ||
                ((filetypeAttachedFileId != null) &&
                (_filetypeAttachedFileId == null)) ||
                ((filetypeAttachedFileId != null) &&
                (_filetypeAttachedFileId != null) &&
                !filetypeAttachedFileId.equals(_filetypeAttachedFileId))) {
            _filetypeAttachedFileId = filetypeAttachedFileId;
        }
    }

    public String getFileTypeId() {
        return GetterUtil.getString(_fileTypeId);
    }

    public void setFileTypeId(String fileTypeId) {
        if (((fileTypeId == null) && (_fileTypeId != null)) ||
                ((fileTypeId != null) && (_fileTypeId == null)) ||
                ((fileTypeId != null) && (_fileTypeId != null) &&
                !fileTypeId.equals(_fileTypeId))) {
            _fileTypeId = fileTypeId;
        }
    }

    public int getOriginal() {
        return _original;
    }

    public void setOriginal(int original) {
        if (original != _original) {
            _original = original;
        }
    }

    public int getCopy_() {
        return _copy_;
    }

    public void setCopy_(int copy_) {
        if (copy_ != _copy_) {
            _copy_ = copy_;
        }
    }

    public String getAttachedFileId() {
        return GetterUtil.getString(_attachedFileId);
    }

    public void setAttachedFileId(String attachedFileId) {
        if (((attachedFileId == null) && (_attachedFileId != null)) ||
                ((attachedFileId != null) && (_attachedFileId == null)) ||
                ((attachedFileId != null) && (_attachedFileId != null) &&
                !attachedFileId.equals(_attachedFileId))) {
            _attachedFileId = attachedFileId;
        }
    }

    public String getAttachedFileName() {
        return GetterUtil.getString(_attachedFileName);
    }

    public void setAttachedFileName(String attachedFileName) {
        if (((attachedFileName == null) && (_attachedFileName != null)) ||
                ((attachedFileName != null) && (_attachedFileName == null)) ||
                ((attachedFileName != null) && (_attachedFileName != null) &&
                !attachedFileName.equals(_attachedFileName))) {
            _attachedFileName = attachedFileName;
        }
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        if (((note == null) && (_note != null)) ||
                ((note != null) && (_note == null)) ||
                ((note != null) && (_note != null) && !note.equals(_note))) {
            _note = note;
        }
    }

    public PmlFileTypeAttachedFile toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFileTypeAttachedFile) this;
        } else {
            PmlFileTypeAttachedFile model = new PmlFileTypeAttachedFileImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFiletypeAttachedFileId(HtmlUtil.escape(
                    getFiletypeAttachedFileId()));
            model.setFileTypeId(HtmlUtil.escape(getFileTypeId()));
            model.setOriginal(getOriginal());
            model.setCopy_(getCopy_());
            model.setAttachedFileId(HtmlUtil.escape(getAttachedFileId()));
            model.setAttachedFileName(HtmlUtil.escape(getAttachedFileName()));
            model.setNote(HtmlUtil.escape(getNote()));

            model = (PmlFileTypeAttachedFile) Proxy.newProxyInstance(PmlFileTypeAttachedFile.class.getClassLoader(),
                    new Class[] { PmlFileTypeAttachedFile.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlFileTypeAttachedFileImpl clone = new PmlFileTypeAttachedFileImpl();

        clone.setFiletypeAttachedFileId(getFiletypeAttachedFileId());
        clone.setFileTypeId(getFileTypeId());
        clone.setOriginal(getOriginal());
        clone.setCopy_(getCopy_());
        clone.setAttachedFileId(getAttachedFileId());
        clone.setAttachedFileName(getAttachedFileName());
        clone.setNote(getNote());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFileTypeAttachedFileImpl pmlFileTypeAttachedFile = (PmlFileTypeAttachedFileImpl) obj;

        int value = 0;

        value = getFiletypeAttachedFileId()
                    .compareTo(pmlFileTypeAttachedFile.getFiletypeAttachedFileId());

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

        PmlFileTypeAttachedFileImpl pmlFileTypeAttachedFile = null;

        try {
            pmlFileTypeAttachedFile = (PmlFileTypeAttachedFileImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlFileTypeAttachedFile.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }
}
