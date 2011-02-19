package com.sgs.portlet.loaivanbannoibo.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBoSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="LoaiVanBanNoiBoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>LoaiVanBanNoiBo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo
 * @see com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBoModel
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.LoaiVanBanNoiBoImpl
 *
 */
public class LoaiVanBanNoiBoModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_loaivanbannoibo";
    public static final Object[][] TABLE_COLUMNS = {
            { "loaiVanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "kyHieuLoaiVanBanNoiBo", new Integer(Types.VARCHAR) },
            

            { "tenLoaiVanBanNoiBo", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_loaivanbannoibo (loaiVanBanNoiBoId LONG not null primary key,kyHieuLoaiVanBanNoiBo VARCHAR(75) null,tenLoaiVanBanNoiBo VARCHAR(75) null,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_loaivanbannoibo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo"));
    private long _loaiVanBanNoiBoId;
    private String _kyHieuLoaiVanBanNoiBo;
    private String _tenLoaiVanBanNoiBo;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public LoaiVanBanNoiBoModelImpl() {
    }

    public static LoaiVanBanNoiBo toModel(LoaiVanBanNoiBoSoap soapModel) {
        LoaiVanBanNoiBo model = new LoaiVanBanNoiBoImpl();

        model.setLoaiVanBanNoiBoId(soapModel.getLoaiVanBanNoiBoId());
        model.setKyHieuLoaiVanBanNoiBo(soapModel.getKyHieuLoaiVanBanNoiBo());
        model.setTenLoaiVanBanNoiBo(soapModel.getTenLoaiVanBanNoiBo());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<LoaiVanBanNoiBo> toModels(
        LoaiVanBanNoiBoSoap[] soapModels) {
        List<LoaiVanBanNoiBo> models = new ArrayList<LoaiVanBanNoiBo>(soapModels.length);

        for (LoaiVanBanNoiBoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _loaiVanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setLoaiVanBanNoiBoId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_loaiVanBanNoiBoId);
    }

    public long getLoaiVanBanNoiBoId() {
        return _loaiVanBanNoiBoId;
    }

    public void setLoaiVanBanNoiBoId(long loaiVanBanNoiBoId) {
        if (loaiVanBanNoiBoId != _loaiVanBanNoiBoId) {
            _loaiVanBanNoiBoId = loaiVanBanNoiBoId;
        }
    }

    public String getKyHieuLoaiVanBanNoiBo() {
        return GetterUtil.getString(_kyHieuLoaiVanBanNoiBo);
    }

    public void setKyHieuLoaiVanBanNoiBo(String kyHieuLoaiVanBanNoiBo) {
        if (((kyHieuLoaiVanBanNoiBo == null) &&
                (_kyHieuLoaiVanBanNoiBo != null)) ||
                ((kyHieuLoaiVanBanNoiBo != null) &&
                (_kyHieuLoaiVanBanNoiBo == null)) ||
                ((kyHieuLoaiVanBanNoiBo != null) &&
                (_kyHieuLoaiVanBanNoiBo != null) &&
                !kyHieuLoaiVanBanNoiBo.equals(_kyHieuLoaiVanBanNoiBo))) {
            _kyHieuLoaiVanBanNoiBo = kyHieuLoaiVanBanNoiBo;
        }
    }

    public String getTenLoaiVanBanNoiBo() {
        return GetterUtil.getString(_tenLoaiVanBanNoiBo);
    }

    public void setTenLoaiVanBanNoiBo(String tenLoaiVanBanNoiBo) {
        if (((tenLoaiVanBanNoiBo == null) && (_tenLoaiVanBanNoiBo != null)) ||
                ((tenLoaiVanBanNoiBo != null) && (_tenLoaiVanBanNoiBo == null)) ||
                ((tenLoaiVanBanNoiBo != null) && (_tenLoaiVanBanNoiBo != null) &&
                !tenLoaiVanBanNoiBo.equals(_tenLoaiVanBanNoiBo))) {
            _tenLoaiVanBanNoiBo = tenLoaiVanBanNoiBo;
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

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        if (groupId != _groupId) {
            _groupId = groupId;
        }
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        if (companyId != _companyId) {
            _companyId = companyId;
        }
    }

    public LoaiVanBanNoiBo toEscapedModel() {
        if (isEscapedModel()) {
            return (LoaiVanBanNoiBo) this;
        } else {
            LoaiVanBanNoiBo model = new LoaiVanBanNoiBoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setLoaiVanBanNoiBoId(getLoaiVanBanNoiBoId());
            model.setKyHieuLoaiVanBanNoiBo(HtmlUtil.escape(
                    getKyHieuLoaiVanBanNoiBo()));
            model.setTenLoaiVanBanNoiBo(HtmlUtil.escape(getTenLoaiVanBanNoiBo()));
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (LoaiVanBanNoiBo) Proxy.newProxyInstance(LoaiVanBanNoiBo.class.getClassLoader(),
                    new Class[] { LoaiVanBanNoiBo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        LoaiVanBanNoiBoImpl clone = new LoaiVanBanNoiBoImpl();

        clone.setLoaiVanBanNoiBoId(getLoaiVanBanNoiBoId());
        clone.setKyHieuLoaiVanBanNoiBo(getKyHieuLoaiVanBanNoiBo());
        clone.setTenLoaiVanBanNoiBo(getTenLoaiVanBanNoiBo());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        LoaiVanBanNoiBoImpl loaiVanBanNoiBo = (LoaiVanBanNoiBoImpl) obj;

        long pk = loaiVanBanNoiBo.getPrimaryKey();

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

        LoaiVanBanNoiBoImpl loaiVanBanNoiBo = null;

        try {
            loaiVanBanNoiBo = (LoaiVanBanNoiBoImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = loaiVanBanNoiBo.getPrimaryKey();

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
