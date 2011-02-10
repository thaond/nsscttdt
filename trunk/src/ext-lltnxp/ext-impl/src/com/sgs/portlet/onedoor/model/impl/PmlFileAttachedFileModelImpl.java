package com.sgs.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoor.model.PmlFileAttachedFile;
import com.sgs.portlet.onedoor.model.PmlFileAttachedFileSoap;

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
 * @see com.sgs.portlet.onedoor.model.PmlFileAttachedFile
 * @see com.sgs.portlet.onedoor.model.PmlFileAttachedFileModel
 * @see com.sgs.portlet.onedoor.model.impl.PmlFileAttachedFileImpl
 *
 */
public class PmlFileAttachedFileModelImpl extends BaseModelImpl {
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
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoor.model.PmlFileAttachedFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoor.model.PmlFileAttachedFile"));
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
        if (((fileAttachedFileId == null) && (_fileAttachedFileId != null)) ||
                ((fileAttachedFileId != null) && (_fileAttachedFileId == null)) ||
                ((fileAttachedFileId != null) && (_fileAttachedFileId != null) &&
                !fileAttachedFileId.equals(_fileAttachedFileId))) {
            _fileAttachedFileId = fileAttachedFileId;
        }
    }

    public String getFileId() {
        return GetterUtil.getString(_fileId);
    }

    public void setFileId(String fileId) {
        if (((fileId == null) && (_fileId != null)) ||
                ((fileId != null) && (_fileId == null)) ||
                ((fileId != null) && (_fileId != null) &&
                !fileId.equals(_fileId))) {
            _fileId = fileId;
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

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFileAttachedFileImpl pmlFileAttachedFile = (PmlFileAttachedFileImpl) obj;

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

        PmlFileAttachedFileImpl pmlFileAttachedFile = null;

        try {
            pmlFileAttachedFile = (PmlFileAttachedFileImpl) obj;
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
}
