package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevelSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmConfidentialLevelModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmConfidentialLevel</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel
 * @see com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevelModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmConfidentialLevelImpl
 *
 */
public class PmlEdmConfidentialLevelModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_confidentiallevel";
    public static final Object[][] TABLE_COLUMNS = {
            { "confidentiallevelid", new Integer(Types.VARCHAR) },
            

            { "confidentiallevelname", new Integer(Types.VARCHAR) },
            

            { "limitviewdetail", new Integer(Types.BOOLEAN) },
            

            { "haveprocess", new Integer(Types.BOOLEAN) },
            

            { "confidentiallevelsymbol", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_confidentiallevel (confidentiallevelid VARCHAR(75) not null primary key,confidentiallevelname VARCHAR(75) null,limitviewdetail BOOLEAN,haveprocess BOOLEAN,confidentiallevelsymbol INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_confidentiallevel";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel"));
    private String _confidentialLevelId;
    private String _confidentialLevelName;
    private boolean _limitViewDetail;
    private boolean _haveProcess;
    private int _confidentialLevelSymbol;

    public PmlEdmConfidentialLevelModelImpl() {
    }

    public static PmlEdmConfidentialLevel toModel(
        PmlEdmConfidentialLevelSoap soapModel) {
        PmlEdmConfidentialLevel model = new PmlEdmConfidentialLevelImpl();

        model.setConfidentialLevelId(soapModel.getConfidentialLevelId());
        model.setConfidentialLevelName(soapModel.getConfidentialLevelName());
        model.setLimitViewDetail(soapModel.getLimitViewDetail());
        model.setHaveProcess(soapModel.getHaveProcess());
        model.setConfidentialLevelSymbol(soapModel.getConfidentialLevelSymbol());

        return model;
    }

    public static List<PmlEdmConfidentialLevel> toModels(
        PmlEdmConfidentialLevelSoap[] soapModels) {
        List<PmlEdmConfidentialLevel> models = new ArrayList<PmlEdmConfidentialLevel>(soapModels.length);

        for (PmlEdmConfidentialLevelSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _confidentialLevelId;
    }

    public void setPrimaryKey(String pk) {
        setConfidentialLevelId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _confidentialLevelId;
    }

    public String getConfidentialLevelId() {
        return GetterUtil.getString(_confidentialLevelId);
    }

    public void setConfidentialLevelId(String confidentialLevelId) {
        if (((confidentialLevelId == null) && (_confidentialLevelId != null)) ||
                ((confidentialLevelId != null) &&
                (_confidentialLevelId == null)) ||
                ((confidentialLevelId != null) &&
                (_confidentialLevelId != null) &&
                !confidentialLevelId.equals(_confidentialLevelId))) {
            _confidentialLevelId = confidentialLevelId;
        }
    }

    public String getConfidentialLevelName() {
        return GetterUtil.getString(_confidentialLevelName);
    }

    public void setConfidentialLevelName(String confidentialLevelName) {
        if (((confidentialLevelName == null) &&
                (_confidentialLevelName != null)) ||
                ((confidentialLevelName != null) &&
                (_confidentialLevelName == null)) ||
                ((confidentialLevelName != null) &&
                (_confidentialLevelName != null) &&
                !confidentialLevelName.equals(_confidentialLevelName))) {
            _confidentialLevelName = confidentialLevelName;
        }
    }

    public boolean getLimitViewDetail() {
        return _limitViewDetail;
    }

    public boolean isLimitViewDetail() {
        return _limitViewDetail;
    }

    public void setLimitViewDetail(boolean limitViewDetail) {
        if (limitViewDetail != _limitViewDetail) {
            _limitViewDetail = limitViewDetail;
        }
    }

    public boolean getHaveProcess() {
        return _haveProcess;
    }

    public boolean isHaveProcess() {
        return _haveProcess;
    }

    public void setHaveProcess(boolean haveProcess) {
        if (haveProcess != _haveProcess) {
            _haveProcess = haveProcess;
        }
    }

    public int getConfidentialLevelSymbol() {
        return _confidentialLevelSymbol;
    }

    public void setConfidentialLevelSymbol(int confidentialLevelSymbol) {
        if (confidentialLevelSymbol != _confidentialLevelSymbol) {
            _confidentialLevelSymbol = confidentialLevelSymbol;
        }
    }

    public PmlEdmConfidentialLevel toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmConfidentialLevel) this;
        } else {
            PmlEdmConfidentialLevel model = new PmlEdmConfidentialLevelImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setConfidentialLevelId(HtmlUtil.escape(
                    getConfidentialLevelId()));
            model.setConfidentialLevelName(HtmlUtil.escape(
                    getConfidentialLevelName()));
            model.setLimitViewDetail(getLimitViewDetail());
            model.setHaveProcess(getHaveProcess());
            model.setConfidentialLevelSymbol(getConfidentialLevelSymbol());

            model = (PmlEdmConfidentialLevel) Proxy.newProxyInstance(PmlEdmConfidentialLevel.class.getClassLoader(),
                    new Class[] { PmlEdmConfidentialLevel.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmConfidentialLevelImpl clone = new PmlEdmConfidentialLevelImpl();

        clone.setConfidentialLevelId(getConfidentialLevelId());
        clone.setConfidentialLevelName(getConfidentialLevelName());
        clone.setLimitViewDetail(getLimitViewDetail());
        clone.setHaveProcess(getHaveProcess());
        clone.setConfidentialLevelSymbol(getConfidentialLevelSymbol());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmConfidentialLevelImpl pmlEdmConfidentialLevel = (PmlEdmConfidentialLevelImpl) obj;

        int value = 0;

        value = getConfidentialLevelName().toLowerCase()
                    .compareTo(pmlEdmConfidentialLevel.getConfidentialLevelName()
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

        PmlEdmConfidentialLevelImpl pmlEdmConfidentialLevel = null;

        try {
            pmlEdmConfidentialLevel = (PmlEdmConfidentialLevelImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlEdmConfidentialLevel.getPrimaryKey();

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
