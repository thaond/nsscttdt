package com.sgs.portlet.document.receipt.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;
import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetailSoap;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlEdmLevelSendDetailModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlEdmLevelSendDetail</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail
 * @see com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetailModel
 * @see com.sgs.portlet.document.receipt.model.impl.PmlEdmLevelSendDetailImpl
 *
 */
public class PmlEdmLevelSendDetailModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_levelsenddetail";
    public static final Object[][] TABLE_COLUMNS = {
            { "levelsendid", new Integer(Types.INTEGER) },
            

            { "issuingPlaceId", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_levelsenddetail (levelsendid INTEGER not null,issuingPlaceId VARCHAR(75) not null,primary key (levelsendid, issuingPlaceId))";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_levelsenddetail";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail"));
    private int _levelSendId;
    private String _issuingPlaceId;

    public PmlEdmLevelSendDetailModelImpl() {
    }

    public static PmlEdmLevelSendDetail toModel(
        PmlEdmLevelSendDetailSoap soapModel) {
        PmlEdmLevelSendDetail model = new PmlEdmLevelSendDetailImpl();

        model.setLevelSendId(soapModel.getLevelSendId());
        model.setIssuingPlaceId(soapModel.getIssuingPlaceId());

        return model;
    }

    public static List<PmlEdmLevelSendDetail> toModels(
        PmlEdmLevelSendDetailSoap[] soapModels) {
        List<PmlEdmLevelSendDetail> models = new ArrayList<PmlEdmLevelSendDetail>(soapModels.length);

        for (PmlEdmLevelSendDetailSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public PmlEdmLevelSendDetailPK getPrimaryKey() {
        return new PmlEdmLevelSendDetailPK(_levelSendId, _issuingPlaceId);
    }

    public void setPrimaryKey(PmlEdmLevelSendDetailPK pk) {
        setLevelSendId(pk.levelSendId);
        setIssuingPlaceId(pk.issuingPlaceId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PmlEdmLevelSendDetailPK(_levelSendId, _issuingPlaceId);
    }

    public int getLevelSendId() {
        return _levelSendId;
    }

    public void setLevelSendId(int levelSendId) {
        if (levelSendId != _levelSendId) {
            _levelSendId = levelSendId;
        }
    }

    public String getIssuingPlaceId() {
        return GetterUtil.getString(_issuingPlaceId);
    }

    public void setIssuingPlaceId(String issuingPlaceId) {
        if (((issuingPlaceId == null) && (_issuingPlaceId != null)) ||
                ((issuingPlaceId != null) && (_issuingPlaceId == null)) ||
                ((issuingPlaceId != null) && (_issuingPlaceId != null) &&
                !issuingPlaceId.equals(_issuingPlaceId))) {
            _issuingPlaceId = issuingPlaceId;
        }
    }

    public PmlEdmLevelSendDetail toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlEdmLevelSendDetail) this;
        } else {
            PmlEdmLevelSendDetail model = new PmlEdmLevelSendDetailImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setLevelSendId(getLevelSendId());
            model.setIssuingPlaceId(HtmlUtil.escape(getIssuingPlaceId()));

            model = (PmlEdmLevelSendDetail) Proxy.newProxyInstance(PmlEdmLevelSendDetail.class.getClassLoader(),
                    new Class[] { PmlEdmLevelSendDetail.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlEdmLevelSendDetailImpl clone = new PmlEdmLevelSendDetailImpl();

        clone.setLevelSendId(getLevelSendId());
        clone.setIssuingPlaceId(getIssuingPlaceId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlEdmLevelSendDetailImpl pmlEdmLevelSendDetail = (PmlEdmLevelSendDetailImpl) obj;

        int value = 0;

        if (getLevelSendId() < pmlEdmLevelSendDetail.getLevelSendId()) {
            value = -1;
        } else if (getLevelSendId() > pmlEdmLevelSendDetail.getLevelSendId()) {
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

        PmlEdmLevelSendDetailImpl pmlEdmLevelSendDetail = null;

        try {
            pmlEdmLevelSendDetail = (PmlEdmLevelSendDetailImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PmlEdmLevelSendDetailPK pk = pmlEdmLevelSendDetail.getPrimaryKey();

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
