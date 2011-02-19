package com.sgs.portlet.sovanbannoibo.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBoSoap;
import com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="SoLoaiVanBanNoiBoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>SoLoaiVanBanNoiBo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo
 * @see com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBoModel
 * @see com.sgs.portlet.sovanbannoibo.model.impl.SoLoaiVanBanNoiBoImpl
 *
 */
public class SoLoaiVanBanNoiBoModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_so_loai_vanbannoibo";
    public static final Object[][] TABLE_COLUMNS = {
            { "soVanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "loaiVanBanNoiBoId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_so_loai_vanbannoibo (soVanBanNoiBoId LONG not null,loaiVanBanNoiBoId LONG not null,primary key (soVanBanNoiBoId, loaiVanBanNoiBoId))";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_so_loai_vanbannoibo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo"));
    private long _soVanBanNoiBoId;
    private long _loaiVanBanNoiBoId;

    public SoLoaiVanBanNoiBoModelImpl() {
    }

    public static SoLoaiVanBanNoiBo toModel(SoLoaiVanBanNoiBoSoap soapModel) {
        SoLoaiVanBanNoiBo model = new SoLoaiVanBanNoiBoImpl();

        model.setSoVanBanNoiBoId(soapModel.getSoVanBanNoiBoId());
        model.setLoaiVanBanNoiBoId(soapModel.getLoaiVanBanNoiBoId());

        return model;
    }

    public static List<SoLoaiVanBanNoiBo> toModels(
        SoLoaiVanBanNoiBoSoap[] soapModels) {
        List<SoLoaiVanBanNoiBo> models = new ArrayList<SoLoaiVanBanNoiBo>(soapModels.length);

        for (SoLoaiVanBanNoiBoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public SoLoaiVanBanNoiBoPK getPrimaryKey() {
        return new SoLoaiVanBanNoiBoPK(_soVanBanNoiBoId, _loaiVanBanNoiBoId);
    }

    public void setPrimaryKey(SoLoaiVanBanNoiBoPK pk) {
        setSoVanBanNoiBoId(pk.soVanBanNoiBoId);
        setLoaiVanBanNoiBoId(pk.loaiVanBanNoiBoId);
    }

    public Serializable getPrimaryKeyObj() {
        return new SoLoaiVanBanNoiBoPK(_soVanBanNoiBoId, _loaiVanBanNoiBoId);
    }

    public long getSoVanBanNoiBoId() {
        return _soVanBanNoiBoId;
    }

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId) {
        if (soVanBanNoiBoId != _soVanBanNoiBoId) {
            _soVanBanNoiBoId = soVanBanNoiBoId;
        }
    }

    public long getLoaiVanBanNoiBoId() {
        return _loaiVanBanNoiBoId;
    }

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId) {
        if (loaiVanBanNoiBoId != _loaiVanBanNoiBoId) {
            _loaiVanBanNoiBoId = loaiVanBanNoiBoId;
        }
    }

    public SoLoaiVanBanNoiBo toEscapedModel() {
        if (isEscapedModel()) {
            return (SoLoaiVanBanNoiBo) this;
        } else {
            SoLoaiVanBanNoiBo model = new SoLoaiVanBanNoiBoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setSoVanBanNoiBoId(getSoVanBanNoiBoId());
            model.setLoaiVanBanNoiBoId(getLoaiVanBanNoiBoId());

            model = (SoLoaiVanBanNoiBo) Proxy.newProxyInstance(SoLoaiVanBanNoiBo.class.getClassLoader(),
                    new Class[] { SoLoaiVanBanNoiBo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        SoLoaiVanBanNoiBoImpl clone = new SoLoaiVanBanNoiBoImpl();

        clone.setSoVanBanNoiBoId(getSoVanBanNoiBoId());
        clone.setLoaiVanBanNoiBoId(getLoaiVanBanNoiBoId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        SoLoaiVanBanNoiBoImpl soLoaiVanBanNoiBo = (SoLoaiVanBanNoiBoImpl) obj;

        SoLoaiVanBanNoiBoPK pk = soLoaiVanBanNoiBo.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SoLoaiVanBanNoiBoImpl soLoaiVanBanNoiBo = null;

        try {
            soLoaiVanBanNoiBo = (SoLoaiVanBanNoiBoImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        SoLoaiVanBanNoiBoPK pk = soLoaiVanBanNoiBo.getPrimaryKey();

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
