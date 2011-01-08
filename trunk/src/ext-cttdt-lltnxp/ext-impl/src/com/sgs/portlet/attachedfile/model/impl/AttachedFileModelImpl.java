package com.sgs.portlet.attachedfile.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.model.AttachedFileSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="AttachedFileModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>AttachedFile</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.attachedfile.model.AttachedFile
 * @see com.sgs.portlet.attachedfile.model.AttachedFileModel
 * @see com.sgs.portlet.attachedfile.model.impl.AttachedFileImpl
 *
 */
public class AttachedFileModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_attachedfile";
    public static final Object[][] TABLE_COLUMNS = {
            { "attachedfileid", new Integer(Types.VARCHAR) },
            

            { "attachedfilecode", new Integer(Types.VARCHAR) },
            

            { "attachedfilename", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_attachedfile (attachedfileid VARCHAR(75) not null primary key,attachedfilecode VARCHAR(75) null,attachedfilename VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_attachedfile";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.attachedfile.model.AttachedFile"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.attachedfile.model.AttachedFile"));
    private String _attachedFileId;
    private String _attachedFileCode;
    private String _attachedFileName;
    private String _description;
    private String _active;

    public AttachedFileModelImpl() {
    }

    public static AttachedFile toModel(AttachedFileSoap soapModel) {
        AttachedFile model = new AttachedFileImpl();

        model.setAttachedFileId(soapModel.getAttachedFileId());
        model.setAttachedFileCode(soapModel.getAttachedFileCode());
        model.setAttachedFileName(soapModel.getAttachedFileName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<AttachedFile> toModels(AttachedFileSoap[] soapModels) {
        List<AttachedFile> models = new ArrayList<AttachedFile>(soapModels.length);

        for (AttachedFileSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _attachedFileId;
    }

    public void setPrimaryKey(String pk) {
        setAttachedFileId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _attachedFileId;
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

    public String getAttachedFileCode() {
        return GetterUtil.getString(_attachedFileCode);
    }

    public void setAttachedFileCode(String attachedFileCode) {
        if (((attachedFileCode == null) && (_attachedFileCode != null)) ||
                ((attachedFileCode != null) && (_attachedFileCode == null)) ||
                ((attachedFileCode != null) && (_attachedFileCode != null) &&
                !attachedFileCode.equals(_attachedFileCode))) {
            _attachedFileCode = attachedFileCode;
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

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        if (((description == null) && (_description != null)) ||
                ((description != null) && (_description == null)) ||
                ((description != null) && (_description != null) &&
                !description.equals(_description))) {
            _description = description;
        }
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        if (((active == null) && (_active != null)) ||
                ((active != null) && (_active == null)) ||
                ((active != null) && (_active != null) &&
                !active.equals(_active))) {
            _active = active;
        }
    }

    public AttachedFile toEscapedModel() {
        if (isEscapedModel()) {
            return (AttachedFile) this;
        } else {
            AttachedFile model = new AttachedFileImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setAttachedFileId(HtmlUtil.escape(getAttachedFileId()));
            model.setAttachedFileCode(HtmlUtil.escape(getAttachedFileCode()));
            model.setAttachedFileName(HtmlUtil.escape(getAttachedFileName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (AttachedFile) Proxy.newProxyInstance(AttachedFile.class.getClassLoader(),
                    new Class[] { AttachedFile.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        AttachedFileImpl clone = new AttachedFileImpl();

        clone.setAttachedFileId(getAttachedFileId());
        clone.setAttachedFileCode(getAttachedFileCode());
        clone.setAttachedFileName(getAttachedFileName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        AttachedFileImpl attachedFile = (AttachedFileImpl) obj;

        int value = 0;

        value = getAttachedFileId().compareTo(attachedFile.getAttachedFileId());

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

        AttachedFileImpl attachedFile = null;

        try {
            attachedFile = (AttachedFileImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = attachedFile.getPrimaryKey();

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
