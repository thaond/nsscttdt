package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFileSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmAttachedFileModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmAttachedFile</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile
 * @see com.sgs.portlet.document.receipt.model.PmlEdmAttachedFileModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl
 *
 */
public class PmlEdmAttachedFileModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_attachedfile";
    public static final Object[][] TABLE_COLUMNS = {
            { "attachedfileid", new Integer(Types.BIGINT) },
            

            { "objectcontentid", new Integer(Types.BIGINT) },
            

            { "objecttype", new Integer(Types.VARCHAR) },
            

            { "attachedfilename", new Integer(Types.VARCHAR) },
            

            { "path", new Integer(Types.VARCHAR) },
            

            { "datecreated", new Integer(Types.TIMESTAMP) },
            

            { "filetype", new Integer(Types.VARCHAR) },
            

            { "fileid", new Integer(Types.INTEGER) },
            

            { "title", new Integer(Types.VARCHAR) },
            

            { "displayorhidden", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_attachedfile (attachedfileid LONG not null primary key,objectcontentid LONG,objecttype VARCHAR(75) null,attachedfilename VARCHAR(75) null,path VARCHAR(75) null,datecreated DATE null,filetype VARCHAR(75) null,fileid INTEGER,title VARCHAR(75) null,displayorhidden BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_attachedfile";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile"));
    private long _attachedFileId;
    private long _objectContentId;
    private String _objectType;
    private String _attachedFileName;
    private String _path;
    private Date _dateCreated;
    private String _fileType;
    private int _fileId;
    private String _title;
    private boolean _displayOrHidden;

    public PmlEdmAttachedFileModelImpl() {
    }

    public static PmlEdmAttachedFile toModel(PmlEdmAttachedFileSoap soapModel) {
        PmlEdmAttachedFile model = new PmlEdmAttachedFileImpl();

        model.setAttachedFileId(soapModel.getAttachedFileId());
        model.setObjectContentId(soapModel.getObjectContentId());
        model.setObjectType(soapModel.getObjectType());
        model.setAttachedFileName(soapModel.getAttachedFileName());
        model.setPath(soapModel.getPath());
        model.setDateCreated(soapModel.getDateCreated());
        model.setFileType(soapModel.getFileType());
        model.setFileId(soapModel.getFileId());
        model.setTitle(soapModel.getTitle());
        model.setDisplayOrHidden(soapModel.getDisplayOrHidden());

        return model;
    }

    public static List<PmlEdmAttachedFile> toModels(
        PmlEdmAttachedFileSoap[] soapModels) {
        List<PmlEdmAttachedFile> models = new ArrayList<PmlEdmAttachedFile>(soapModels.length);

        for (PmlEdmAttachedFileSoap soapModel : soapModels) {
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
        if (attachedFileId != _attachedFileId) {
            _attachedFileId = attachedFileId;
        }
    }

    public long getObjectContentId() {
        return _objectContentId;
    }

    public void setObjectContentId(long objectContentId) {
        if (objectContentId != _objectContentId) {
            _objectContentId = objectContentId;
        }
    }

    public String getObjectType() {
        return GetterUtil.getString(_objectType);
    }

    public void setObjectType(String objectType) {
        if (((objectType == null) && (_objectType != null)) ||
                ((objectType != null) && (_objectType == null)) ||
                ((objectType != null) && (_objectType != null) &&
                !objectType.equals(_objectType))) {
            _objectType = objectType;
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

    public String getPath() {
        return GetterUtil.getString(_path);
    }

    public void setPath(String path) {
        if (((path == null) && (_path != null)) ||
                ((path != null) && (_path == null)) ||
                ((path != null) && (_path != null) && !path.equals(_path))) {
            _path = path;
        }
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        if (((dateCreated == null) && (_dateCreated != null)) ||
                ((dateCreated != null) && (_dateCreated == null)) ||
                ((dateCreated != null) && (_dateCreated != null) &&
                !dateCreated.equals(_dateCreated))) {
            _dateCreated = dateCreated;
        }
    }

    public String getFileType() {
        return GetterUtil.getString(_fileType);
    }

    public void setFileType(String fileType) {
        if (((fileType == null) && (_fileType != null)) ||
                ((fileType != null) && (_fileType == null)) ||
                ((fileType != null) && (_fileType != null) &&
                !fileType.equals(_fileType))) {
            _fileType = fileType;
        }
    }

    public int getFileId() {
        return _fileId;
    }

    public void setFileId(int fileId) {
        if (fileId != _fileId) {
            _fileId = fileId;
        }
    }

    public String getTitle() {
        return GetterUtil.getString(_title);
    }

    public void setTitle(String title) {
        if (((title == null) && (_title != null)) ||
                ((title != null) && (_title == null)) ||
                ((title != null) && (_title != null) && !title.equals(_title))) {
            _title = title;
        }
    }

    public boolean getDisplayOrHidden() {
        return _displayOrHidden;
    }

    public boolean isDisplayOrHidden() {
        return _displayOrHidden;
    }

    public void setDisplayOrHidden(boolean displayOrHidden) {
        if (displayOrHidden != _displayOrHidden) {
            _displayOrHidden = displayOrHidden;
        }
    }

    public PmlEdmAttachedFile toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmAttachedFile) this;
        } else {
            PmlEdmAttachedFile model = new PmlEdmAttachedFileImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setAttachedFileId(getAttachedFileId());
            model.setObjectContentId(getObjectContentId());
            model.setObjectType(HtmlUtil.escape(getObjectType()));
            model.setAttachedFileName(HtmlUtil.escape(getAttachedFileName()));
            model.setPath(HtmlUtil.escape(getPath()));
            model.setDateCreated(getDateCreated());
            model.setFileType(HtmlUtil.escape(getFileType()));
            model.setFileId(getFileId());
            model.setTitle(HtmlUtil.escape(getTitle()));
            model.setDisplayOrHidden(getDisplayOrHidden());

            model = (PmlEdmAttachedFile) Proxy.newProxyInstance(PmlEdmAttachedFile.class.getClassLoader(),
                    new Class[] { PmlEdmAttachedFile.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmAttachedFileImpl clone = new PmlEdmAttachedFileImpl();

        clone.setAttachedFileId(getAttachedFileId());
        clone.setObjectContentId(getObjectContentId());
        clone.setObjectType(getObjectType());
        clone.setAttachedFileName(getAttachedFileName());
        clone.setPath(getPath());
        clone.setDateCreated(getDateCreated());
        clone.setFileType(getFileType());
        clone.setFileId(getFileId());
        clone.setTitle(getTitle());
        clone.setDisplayOrHidden(getDisplayOrHidden());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmAttachedFileImpl pmlEdmAttachedFile = (PmlEdmAttachedFileImpl) obj;

        long pk = pmlEdmAttachedFile.getPrimaryKey();

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

        PmlEdmAttachedFileImpl pmlEdmAttachedFile = null;

        try {
            pmlEdmAttachedFile = (PmlEdmAttachedFileImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmAttachedFile.getPrimaryKey();

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
