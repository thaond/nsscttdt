package com.sgs.portlet.loaivanbannoibo.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBoSoap;
import com.sgs.portlet.loaivanbannoibo.service.persistence.SoPhongVanBanNoiBoPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="SoPhongVanBanNoiBoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>SoPhongVanBanNoiBo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo
 * @see com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBoModel
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.SoPhongVanBanNoiBoImpl
 *
 */
public class SoPhongVanBanNoiBoModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_so_phong_vanbannoibo";
    public static final Object[][] TABLE_COLUMNS = {
            { "soVanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "phongVanBanNoiBoId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_so_phong_vanbannoibo (soVanBanNoiBoId LONG not null,phongVanBanNoiBoId LONG not null,primary key (soVanBanNoiBoId, phongVanBanNoiBoId))";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_so_phong_vanbannoibo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.loaivanbannoibo.model.SoPhongVanBanNoiBo"));
    private long _soVanBanNoiBoId;
    private long _phongVanBanNoiBoId;

    public SoPhongVanBanNoiBoModelImpl() {
    }

    public static SoPhongVanBanNoiBo toModel(SoPhongVanBanNoiBoSoap soapModel) {
        SoPhongVanBanNoiBo model = new SoPhongVanBanNoiBoImpl();

        model.setSoVanBanNoiBoId(soapModel.getSoVanBanNoiBoId());
        model.setPhongVanBanNoiBoId(soapModel.getPhongVanBanNoiBoId());

        return model;
    }

    public static List<SoPhongVanBanNoiBo> toModels(
        SoPhongVanBanNoiBoSoap[] soapModels) {
        List<SoPhongVanBanNoiBo> models = new ArrayList<SoPhongVanBanNoiBo>(soapModels.length);

        for (SoPhongVanBanNoiBoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public SoPhongVanBanNoiBoPK getPrimaryKey() {
        return new SoPhongVanBanNoiBoPK(_soVanBanNoiBoId, _phongVanBanNoiBoId);
    }

    public void setPrimaryKey(SoPhongVanBanNoiBoPK pk) {
        setSoVanBanNoiBoId(pk.soVanBanNoiBoId);
        setPhongVanBanNoiBoId(pk.phongVanBanNoiBoId);
    }

    public Serializable getPrimaryKeyObj() {
        return new SoPhongVanBanNoiBoPK(_soVanBanNoiBoId, _phongVanBanNoiBoId);
    }

    public long getSoVanBanNoiBoId() {
        return _soVanBanNoiBoId;
    }

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId) {
        if (soVanBanNoiBoId != _soVanBanNoiBoId) {
            _soVanBanNoiBoId = soVanBanNoiBoId;
        }
    }

    public long getPhongVanBanNoiBoId() {
        return _phongVanBanNoiBoId;
    }

    public void setPhongVanBanNoiBoId(long phongVanBanNoiBoId) {
        if (phongVanBanNoiBoId != _phongVanBanNoiBoId) {
            _phongVanBanNoiBoId = phongVanBanNoiBoId;
        }
    }

    public SoPhongVanBanNoiBo toEscapedModel() {
        if (isEscapedModel()) {
            return (SoPhongVanBanNoiBo) this;
        } else {
            SoPhongVanBanNoiBo model = new SoPhongVanBanNoiBoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setSoVanBanNoiBoId(getSoVanBanNoiBoId());
            model.setPhongVanBanNoiBoId(getPhongVanBanNoiBoId());

            model = (SoPhongVanBanNoiBo) Proxy.newProxyInstance(SoPhongVanBanNoiBo.class.getClassLoader(),
                    new Class[] { SoPhongVanBanNoiBo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        SoPhongVanBanNoiBoImpl clone = new SoPhongVanBanNoiBoImpl();

        clone.setSoVanBanNoiBoId(getSoVanBanNoiBoId());
        clone.setPhongVanBanNoiBoId(getPhongVanBanNoiBoId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        SoPhongVanBanNoiBoImpl soPhongVanBanNoiBo = (SoPhongVanBanNoiBoImpl) obj;

        SoPhongVanBanNoiBoPK pk = soPhongVanBanNoiBo.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SoPhongVanBanNoiBoImpl soPhongVanBanNoiBo = null;

        try {
            soPhongVanBanNoiBo = (SoPhongVanBanNoiBoImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        SoPhongVanBanNoiBoPK pk = soPhongVanBanNoiBo.getPrimaryKey();

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
