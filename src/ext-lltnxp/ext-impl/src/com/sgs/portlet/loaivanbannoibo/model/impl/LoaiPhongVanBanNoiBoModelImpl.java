package com.sgs.portlet.loaivanbannoibo.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBoSoap;
import com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="LoaiPhongVanBanNoiBoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>LoaiPhongVanBanNoiBo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo
 * @see com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBoModel
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.LoaiPhongVanBanNoiBoImpl
 *
 */
public class LoaiPhongVanBanNoiBoModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_phong_loai_vanbannoibo";
    public static final Object[][] TABLE_COLUMNS = {
            { "loaiVanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "phongVanBanNoiBoId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_phong_loai_vanbannoibo (loaiVanBanNoiBoId LONG not null,phongVanBanNoiBoId LONG not null,primary key (loaiVanBanNoiBoId, phongVanBanNoiBoId))";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_phong_loai_vanbannoibo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo"));
    private long _loaiVanBanNoiBoId;
    private long _phongVanBanNoiBoId;

    public LoaiPhongVanBanNoiBoModelImpl() {
    }

    public static LoaiPhongVanBanNoiBo toModel(
        LoaiPhongVanBanNoiBoSoap soapModel) {
        LoaiPhongVanBanNoiBo model = new LoaiPhongVanBanNoiBoImpl();

        model.setLoaiVanBanNoiBoId(soapModel.getLoaiVanBanNoiBoId());
        model.setPhongVanBanNoiBoId(soapModel.getPhongVanBanNoiBoId());

        return model;
    }

    public static List<LoaiPhongVanBanNoiBo> toModels(
        LoaiPhongVanBanNoiBoSoap[] soapModels) {
        List<LoaiPhongVanBanNoiBo> models = new ArrayList<LoaiPhongVanBanNoiBo>(soapModels.length);

        for (LoaiPhongVanBanNoiBoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public LoaiPhongVanBanNoiBoPK getPrimaryKey() {
        return new LoaiPhongVanBanNoiBoPK(_loaiVanBanNoiBoId,
            _phongVanBanNoiBoId);
    }

    public void setPrimaryKey(LoaiPhongVanBanNoiBoPK pk) {
        setLoaiVanBanNoiBoId(pk.loaiVanBanNoiBoId);
        setPhongVanBanNoiBoId(pk.phongVanBanNoiBoId);
    }

    public Serializable getPrimaryKeyObj() {
        return new LoaiPhongVanBanNoiBoPK(_loaiVanBanNoiBoId,
            _phongVanBanNoiBoId);
    }

    public long getLoaiVanBanNoiBoId() {
        return _loaiVanBanNoiBoId;
    }

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId) {
        if (loaiVanBanNoiBoId != _loaiVanBanNoiBoId) {
            _loaiVanBanNoiBoId = loaiVanBanNoiBoId;
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

    public LoaiPhongVanBanNoiBo toEscapedModel() {
        if (isEscapedModel()) {
            return (LoaiPhongVanBanNoiBo) this;
        } else {
            LoaiPhongVanBanNoiBo model = new LoaiPhongVanBanNoiBoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setLoaiVanBanNoiBoId(getLoaiVanBanNoiBoId());
            model.setPhongVanBanNoiBoId(getPhongVanBanNoiBoId());

            model = (LoaiPhongVanBanNoiBo) Proxy.newProxyInstance(LoaiPhongVanBanNoiBo.class.getClassLoader(),
                    new Class[] { LoaiPhongVanBanNoiBo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        LoaiPhongVanBanNoiBoImpl clone = new LoaiPhongVanBanNoiBoImpl();

        clone.setLoaiVanBanNoiBoId(getLoaiVanBanNoiBoId());
        clone.setPhongVanBanNoiBoId(getPhongVanBanNoiBoId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        LoaiPhongVanBanNoiBoImpl loaiPhongVanBanNoiBo = (LoaiPhongVanBanNoiBoImpl) obj;

        LoaiPhongVanBanNoiBoPK pk = loaiPhongVanBanNoiBo.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LoaiPhongVanBanNoiBoImpl loaiPhongVanBanNoiBo = null;

        try {
            loaiPhongVanBanNoiBo = (LoaiPhongVanBanNoiBoImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        LoaiPhongVanBanNoiBoPK pk = loaiPhongVanBanNoiBo.getPrimaryKey();

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
