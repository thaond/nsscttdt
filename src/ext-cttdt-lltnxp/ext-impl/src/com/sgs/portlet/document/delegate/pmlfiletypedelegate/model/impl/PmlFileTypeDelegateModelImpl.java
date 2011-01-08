package com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegateSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileTypeDelegateModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlFileTypeDelegate</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegateModel
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.impl.PmlFileTypeDelegateImpl
 *
 */
public class PmlFileTypeDelegateModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_filetypedelegate";
    public static final Object[][] TABLE_COLUMNS = {
            { "filetypedelegateid", new Integer(Types.BIGINT) },
            

            { "filetypeid", new Integer(Types.VARCHAR) },
            

            { "delegateid", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_filetypedelegate (filetypedelegateid LONG not null primary key,filetypeid VARCHAR(75) null,delegateid LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_filetypedelegate";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate"));
    private long _fileTypeDelegateId;
    private String _fileTypeId;
    private long _delegateId;

    public PmlFileTypeDelegateModelImpl() {
    }

    public static PmlFileTypeDelegate toModel(PmlFileTypeDelegateSoap soapModel) {
        PmlFileTypeDelegate model = new PmlFileTypeDelegateImpl();

        model.setFileTypeDelegateId(soapModel.getFileTypeDelegateId());
        model.setFileTypeId(soapModel.getFileTypeId());
        model.setDelegateId(soapModel.getDelegateId());

        return model;
    }

    public static List<PmlFileTypeDelegate> toModels(
        PmlFileTypeDelegateSoap[] soapModels) {
        List<PmlFileTypeDelegate> models = new ArrayList<PmlFileTypeDelegate>(soapModels.length);

        for (PmlFileTypeDelegateSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _fileTypeDelegateId;
    }

    public void setPrimaryKey(long pk) {
        setFileTypeDelegateId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_fileTypeDelegateId);
    }

    public long getFileTypeDelegateId() {
        return _fileTypeDelegateId;
    }

    public void setFileTypeDelegateId(long fileTypeDelegateId) {
        if (fileTypeDelegateId != _fileTypeDelegateId) {
            _fileTypeDelegateId = fileTypeDelegateId;
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

    public long getDelegateId() {
        return _delegateId;
    }

    public void setDelegateId(long delegateId) {
        if (delegateId != _delegateId) {
            _delegateId = delegateId;
        }
    }

    public PmlFileTypeDelegate toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlFileTypeDelegate) this;
        } else {
            PmlFileTypeDelegate model = new PmlFileTypeDelegateImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setFileTypeDelegateId(getFileTypeDelegateId());
            model.setFileTypeId(HtmlUtil.escape(getFileTypeId()));
            model.setDelegateId(getDelegateId());

            model = (PmlFileTypeDelegate) Proxy.newProxyInstance(PmlFileTypeDelegate.class.getClassLoader(),
                    new Class[] { PmlFileTypeDelegate.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlFileTypeDelegateImpl clone = new PmlFileTypeDelegateImpl();

        clone.setFileTypeDelegateId(getFileTypeDelegateId());
        clone.setFileTypeId(getFileTypeId());
        clone.setDelegateId(getDelegateId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlFileTypeDelegateImpl pmlFileTypeDelegate = (PmlFileTypeDelegateImpl) obj;

        int value = 0;

        if (getFileTypeDelegateId() < pmlFileTypeDelegate.getFileTypeDelegateId()) {
            value = -1;
        } else if (getFileTypeDelegateId() > pmlFileTypeDelegate.getFileTypeDelegateId()) {
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

        PmlFileTypeDelegateImpl pmlFileTypeDelegate = null;

        try {
            pmlFileTypeDelegate = (PmlFileTypeDelegateImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlFileTypeDelegate.getPrimaryKey();

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
