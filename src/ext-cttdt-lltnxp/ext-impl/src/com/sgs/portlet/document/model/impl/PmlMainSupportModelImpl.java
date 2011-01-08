package com.sgs.portlet.document.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.model.PmlMainSupport;
import com.sgs.portlet.document.model.PmlMainSupportSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlMainSupportModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlMainSupport</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.model.PmlMainSupport
 * @see com.sgs.portlet.document.model.PmlMainSupportModel
 * @see com.sgs.portlet.document.model.impl.PmlMainSupportImpl
 *
 */
public class PmlMainSupportModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_main_support";
    public static final Object[][] TABLE_COLUMNS = {
            { "processid", new Integer(Types.BIGINT) },
            

            { "processid_main", new Integer(Types.BIGINT) },
            

            { "type_", new Integer(Types.VARCHAR) },
            

            { "supportinfomation", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_main_support (processid LONG not null primary key,processid_main LONG,type_ VARCHAR(75) null,supportinfomation VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_main_support";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.model.PmlMainSupport"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.model.PmlMainSupport"));
    private long _processId;
    private long _processId_Main;
    private String _type_;
    private String _supportInfomation;

    public PmlMainSupportModelImpl() {
    }

    public static PmlMainSupport toModel(PmlMainSupportSoap soapModel) {
        PmlMainSupport model = new PmlMainSupportImpl();

        model.setProcessId(soapModel.getProcessId());
        model.setProcessId_Main(soapModel.getProcessId_Main());
        model.setType_(soapModel.getType_());
        model.setSupportInfomation(soapModel.getSupportInfomation());

        return model;
    }

    public static List<PmlMainSupport> toModels(PmlMainSupportSoap[] soapModels) {
        List<PmlMainSupport> models = new ArrayList<PmlMainSupport>(soapModels.length);

        for (PmlMainSupportSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _processId;
    }

    public void setPrimaryKey(long pk) {
        setProcessId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_processId);
    }

    public long getProcessId() {
        return _processId;
    }

    public void setProcessId(long processId) {
        if (processId != _processId) {
            _processId = processId;
        }
    }

    public long getProcessId_Main() {
        return _processId_Main;
    }

    public void setProcessId_Main(long processId_Main) {
        if (processId_Main != _processId_Main) {
            _processId_Main = processId_Main;
        }
    }

    public String getType_() {
        return GetterUtil.getString(_type_);
    }

    public void setType_(String type_) {
        if (((type_ == null) && (_type_ != null)) ||
                ((type_ != null) && (_type_ == null)) ||
                ((type_ != null) && (_type_ != null) && !type_.equals(_type_))) {
            _type_ = type_;
        }
    }

    public String getSupportInfomation() {
        return GetterUtil.getString(_supportInfomation);
    }

    public void setSupportInfomation(String supportInfomation) {
        if (((supportInfomation == null) && (_supportInfomation != null)) ||
                ((supportInfomation != null) && (_supportInfomation == null)) ||
                ((supportInfomation != null) && (_supportInfomation != null) &&
                !supportInfomation.equals(_supportInfomation))) {
            _supportInfomation = supportInfomation;
        }
    }

    public PmlMainSupport toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlMainSupport) this;
        } else {
            PmlMainSupport model = new PmlMainSupportImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setProcessId(getProcessId());
            model.setProcessId_Main(getProcessId_Main());
            model.setType_(HtmlUtil.escape(getType_()));
            model.setSupportInfomation(HtmlUtil.escape(getSupportInfomation()));

            model = (PmlMainSupport) Proxy.newProxyInstance(PmlMainSupport.class.getClassLoader(),
                    new Class[] { PmlMainSupport.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlMainSupportImpl clone = new PmlMainSupportImpl();

        clone.setProcessId(getProcessId());
        clone.setProcessId_Main(getProcessId_Main());
        clone.setType_(getType_());
        clone.setSupportInfomation(getSupportInfomation());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlMainSupportImpl pmlMainSupport = (PmlMainSupportImpl) obj;

        int value = 0;

        if (getProcessId() < pmlMainSupport.getProcessId()) {
            value = -1;
        } else if (getProcessId() > pmlMainSupport.getProcessId()) {
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

        PmlMainSupportImpl pmlMainSupport = null;

        try {
            pmlMainSupport = (PmlMainSupportImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlMainSupport.getPrimaryKey();

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
