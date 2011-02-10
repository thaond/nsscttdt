package com.sgs.portlet.country.pmluserfiletype.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType;
import com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileTypeSoap;
import com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypePK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlUserFileTypeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlUserFileType</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType
 * @see com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileTypeModel
 * @see com.sgs.portlet.country.pmluserfiletype.model.impl.PmlUserFileTypeImpl
 *
 */
public class PmlUserFileTypeModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_user_file_type";
    public static final Object[][] TABLE_COLUMNS = {
            { "userid", new Integer(Types.BIGINT) },
            

            { "filetypeid", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_user_file_type (userid LONG not null,filetypeid VARCHAR(75) not null,description VARCHAR(75) null,primary key (userid, filetypeid))";
    public static final String TABLE_SQL_DROP = "drop table pml_user_file_type";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType"));
    private long _userId;
    private String _fileTypeId;
    private String _description;

    public PmlUserFileTypeModelImpl() {
    }

    public static PmlUserFileType toModel(PmlUserFileTypeSoap soapModel) {
        PmlUserFileType model = new PmlUserFileTypeImpl();

        model.setUserId(soapModel.getUserId());
        model.setFileTypeId(soapModel.getFileTypeId());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<PmlUserFileType> toModels(
        PmlUserFileTypeSoap[] soapModels) {
        List<PmlUserFileType> models = new ArrayList<PmlUserFileType>(soapModels.length);

        for (PmlUserFileTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public PmlUserFileTypePK getPrimaryKey() {
        return new PmlUserFileTypePK(_userId, _fileTypeId);
    }

    public void setPrimaryKey(PmlUserFileTypePK pk) {
        setUserId(pk.userId);
        setFileTypeId(pk.fileTypeId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PmlUserFileTypePK(_userId, _fileTypeId);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
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

    public PmlUserFileType toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlUserFileType) this;
        } else {
            PmlUserFileType model = new PmlUserFileTypeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setUserId(getUserId());
            model.setFileTypeId(HtmlUtil.escape(getFileTypeId()));
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (PmlUserFileType) Proxy.newProxyInstance(PmlUserFileType.class.getClassLoader(),
                    new Class[] { PmlUserFileType.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlUserFileTypeImpl clone = new PmlUserFileTypeImpl();

        clone.setUserId(getUserId());
        clone.setFileTypeId(getFileTypeId());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlUserFileTypeImpl pmlUserFileType = (PmlUserFileTypeImpl) obj;

        int value = 0;

        if (getUserId() < pmlUserFileType.getUserId()) {
            value = -1;
        } else if (getUserId() > pmlUserFileType.getUserId()) {
            value = 1;
        } else {
            value = 0;
        }

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

        PmlUserFileTypeImpl pmlUserFileType = null;

        try {
            pmlUserFileType = (PmlUserFileTypeImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PmlUserFileTypePK pk = pmlUserFileType.getPrimaryKey();

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
