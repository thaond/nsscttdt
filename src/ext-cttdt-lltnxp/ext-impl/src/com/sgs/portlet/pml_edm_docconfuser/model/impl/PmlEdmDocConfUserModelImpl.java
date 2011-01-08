package com.sgs.portlet.pml_edm_docconfuser.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser;
import com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUserSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmDocConfUserModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmDocConfUser</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser
 * @see com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUserModel
 * @see com.sgs.portlet.pml_edm_docconfuser.model.impl.PmlEdmDocConfUserImpl
 *
 */
public class PmlEdmDocConfUserModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_docconfuser";
    public static final Object[][] TABLE_COLUMNS = {
            { "dcuId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "viewAllDoc", new Integer(Types.BOOLEAN) },
            

            { "viewDepDoc", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_docconfuser (dcuId LONG not null primary key,userId LONG,viewAllDoc BOOLEAN,viewDepDoc VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_docconfuser";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser"));
    private long _dcuId;
    private long _userId;
    private boolean _viewAllDoc;
    private String _viewDepDoc;

    public PmlEdmDocConfUserModelImpl() {
    }

    public static PmlEdmDocConfUser toModel(PmlEdmDocConfUserSoap soapModel) {
        PmlEdmDocConfUser model = new PmlEdmDocConfUserImpl();

        model.setDcuId(soapModel.getDcuId());
        model.setUserId(soapModel.getUserId());
        model.setViewAllDoc(soapModel.getViewAllDoc());
        model.setViewDepDoc(soapModel.getViewDepDoc());

        return model;
    }

    public static List<PmlEdmDocConfUser> toModels(
        PmlEdmDocConfUserSoap[] soapModels) {
        List<PmlEdmDocConfUser> models = new ArrayList<PmlEdmDocConfUser>(soapModels.length);

        for (PmlEdmDocConfUserSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _dcuId;
    }

    public void setPrimaryKey(long pk) {
        setDcuId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_dcuId);
    }

    public long getDcuId() {
        return _dcuId;
    }

    public void setDcuId(long dcuId) {
        if (dcuId != _dcuId) {
            _dcuId = dcuId;
        }
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public boolean getViewAllDoc() {
        return _viewAllDoc;
    }

    public boolean isViewAllDoc() {
        return _viewAllDoc;
    }

    public void setViewAllDoc(boolean viewAllDoc) {
        if (viewAllDoc != _viewAllDoc) {
            _viewAllDoc = viewAllDoc;
        }
    }

    public String getViewDepDoc() {
        return GetterUtil.getString(_viewDepDoc);
    }

    public void setViewDepDoc(String viewDepDoc) {
        if (((viewDepDoc == null) && (_viewDepDoc != null)) ||
                ((viewDepDoc != null) && (_viewDepDoc == null)) ||
                ((viewDepDoc != null) && (_viewDepDoc != null) &&
                !viewDepDoc.equals(_viewDepDoc))) {
            _viewDepDoc = viewDepDoc;
        }
    }

    public PmlEdmDocConfUser toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmDocConfUser) this;
        } else {
            PmlEdmDocConfUser model = new PmlEdmDocConfUserImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDcuId(getDcuId());
            model.setUserId(getUserId());
            model.setViewAllDoc(getViewAllDoc());
            model.setViewDepDoc(HtmlUtil.escape(getViewDepDoc()));

            model = (PmlEdmDocConfUser) Proxy.newProxyInstance(PmlEdmDocConfUser.class.getClassLoader(),
                    new Class[] { PmlEdmDocConfUser.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmDocConfUserImpl clone = new PmlEdmDocConfUserImpl();

        clone.setDcuId(getDcuId());
        clone.setUserId(getUserId());
        clone.setViewAllDoc(getViewAllDoc());
        clone.setViewDepDoc(getViewDepDoc());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmDocConfUserImpl pmlEdmDocConfUser = (PmlEdmDocConfUserImpl) obj;

        long pk = pmlEdmDocConfUser.getPrimaryKey();

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

        PmlEdmDocConfUserImpl pmlEdmDocConfUser = null;

        try {
            pmlEdmDocConfUser = (PmlEdmDocConfUserImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlEdmDocConfUser.getPrimaryKey();

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
