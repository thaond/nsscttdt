package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevelSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmPrivilegeLevelModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmPrivilegeLevel</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel
 * @see com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevelModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmPrivilegeLevelImpl
 *
 */
public class PmlEdmPrivilegeLevelModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_privilegelevel";
    public static final Object[][] TABLE_COLUMNS = {
            { "privilegelevelid", new Integer(Types.VARCHAR) },
            

            { "privilegelevelname", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_privilegelevel (privilegelevelid VARCHAR(75) not null primary key,privilegelevelname VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_privilegelevel";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel"));
    private String _privilegeLevelId;
    private String _privilegeLevelName;

    public PmlEdmPrivilegeLevelModelImpl() {
    }

    public static PmlEdmPrivilegeLevel toModel(
        PmlEdmPrivilegeLevelSoap soapModel) {
        PmlEdmPrivilegeLevel model = new PmlEdmPrivilegeLevelImpl();

        model.setPrivilegeLevelId(soapModel.getPrivilegeLevelId());
        model.setPrivilegeLevelName(soapModel.getPrivilegeLevelName());

        return model;
    }

    public static List<PmlEdmPrivilegeLevel> toModels(
        PmlEdmPrivilegeLevelSoap[] soapModels) {
        List<PmlEdmPrivilegeLevel> models = new ArrayList<PmlEdmPrivilegeLevel>(soapModels.length);

        for (PmlEdmPrivilegeLevelSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _privilegeLevelId;
    }

    public void setPrimaryKey(String pk) {
        setPrivilegeLevelId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _privilegeLevelId;
    }

    public String getPrivilegeLevelId() {
        return GetterUtil.getString(_privilegeLevelId);
    }

    public void setPrivilegeLevelId(String privilegeLevelId) {
        if (((privilegeLevelId == null) && (_privilegeLevelId != null)) ||
                ((privilegeLevelId != null) && (_privilegeLevelId == null)) ||
                ((privilegeLevelId != null) && (_privilegeLevelId != null) &&
                !privilegeLevelId.equals(_privilegeLevelId))) {
            _privilegeLevelId = privilegeLevelId;
        }
    }

    public String getPrivilegeLevelName() {
        return GetterUtil.getString(_privilegeLevelName);
    }

    public void setPrivilegeLevelName(String privilegeLevelName) {
        if (((privilegeLevelName == null) && (_privilegeLevelName != null)) ||
                ((privilegeLevelName != null) && (_privilegeLevelName == null)) ||
                ((privilegeLevelName != null) && (_privilegeLevelName != null) &&
                !privilegeLevelName.equals(_privilegeLevelName))) {
            _privilegeLevelName = privilegeLevelName;
        }
    }

    public PmlEdmPrivilegeLevel toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmPrivilegeLevel) this;
        } else {
            PmlEdmPrivilegeLevel model = new PmlEdmPrivilegeLevelImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setPrivilegeLevelId(HtmlUtil.escape(getPrivilegeLevelId()));
            model.setPrivilegeLevelName(HtmlUtil.escape(getPrivilegeLevelName()));

            model = (PmlEdmPrivilegeLevel) Proxy.newProxyInstance(PmlEdmPrivilegeLevel.class.getClassLoader(),
                    new Class[] { PmlEdmPrivilegeLevel.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmPrivilegeLevelImpl clone = new PmlEdmPrivilegeLevelImpl();

        clone.setPrivilegeLevelId(getPrivilegeLevelId());
        clone.setPrivilegeLevelName(getPrivilegeLevelName());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmPrivilegeLevelImpl pmlEdmPrivilegeLevel = (PmlEdmPrivilegeLevelImpl) obj;

        int value = 0;

        value = getPrivilegeLevelName().toLowerCase()
                    .compareTo(pmlEdmPrivilegeLevel.getPrivilegeLevelName()
                                                   .toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlEdmPrivilegeLevelImpl pmlEdmPrivilegeLevel = null;

        try {
            pmlEdmPrivilegeLevel = (PmlEdmPrivilegeLevelImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlEdmPrivilegeLevel.getPrimaryKey();

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
