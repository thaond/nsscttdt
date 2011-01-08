package com.sgs.portlet.onedoorpccc.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFileSoap;

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
 * @see com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile
 * @see com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFileModel
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCAttachedFileImpl
 *
 */
public class PmlFilePCCCAttachedFileModelImpl extends BaseModelImpl {
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
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile"));
    private long _attachedFileId;
    private String _filePcccId;
    private String _objectType;
    private String _attachedFileName;
    private String _path;
    private Date _dateCreated;
    private String _fileType;
    private String _title;

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
        if (attachedFileId != _attachedFileId) {
            _attachedFileId = attachedFileId;
        }
    }

    public String getFilePcccId() {
        return GetterUtil.getString(_filePcccId);
    }

    public void setFilePcccId(String filePcccId) {
        if (((filePcccId == null) && (_filePcccId != null)) ||
                ((filePcccId != null) && (_filePcccId == null)) ||
                ((filePcccId != null) && (_filePcccId != null) &&
                !filePcccId.equals(_filePcccId))) {
            _filePcccId = filePcccId;
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

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFilePCCCAttachedFileImpl pmlFilePCCCAttachedFile = (PmlFilePCCCAttachedFileImpl) obj;

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

        PmlFilePCCCAttachedFileImpl pmlFilePCCCAttachedFile = null;

        try {
            pmlFilePCCCAttachedFile = (PmlFilePCCCAttachedFileImpl) obj;
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
}
