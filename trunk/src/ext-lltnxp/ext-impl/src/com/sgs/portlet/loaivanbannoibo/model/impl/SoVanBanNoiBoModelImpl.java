package com.sgs.portlet.loaivanbannoibo.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBoSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="SoVanBanNoiBoModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>SoVanBanNoiBo</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo
 * @see com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBoModel
 * @see com.sgs.portlet.loaivanbannoibo.model.impl.SoVanBanNoiBoImpl
 *
 */
public class SoVanBanNoiBoModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_edm_sovanbannoibo";
    public static final Object[][] TABLE_COLUMNS = {
            { "soVanBanNoiBoId", new Integer(Types.BIGINT) },
            

            { "maSoVanBanNoiBo", new Integer(Types.VARCHAR) },
            

            { "tenSoVanBanNoiBo", new Integer(Types.VARCHAR) },
            

            { "ngayTao", new Integer(Types.TIMESTAMP) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_edm_sovanbannoibo (soVanBanNoiBoId LONG not null primary key,maSoVanBanNoiBo VARCHAR(75) null,tenSoVanBanNoiBo VARCHAR(75) null,ngayTao DATE null,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_edm_sovanbannoibo";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo"));
    private long _soVanBanNoiBoId;
    private String _maSoVanBanNoiBo;
    private String _tenSoVanBanNoiBo;
    private Date _ngayTao;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public SoVanBanNoiBoModelImpl() {
    }

    public static SoVanBanNoiBo toModel(SoVanBanNoiBoSoap soapModel) {
        SoVanBanNoiBo model = new SoVanBanNoiBoImpl();

        model.setSoVanBanNoiBoId(soapModel.getSoVanBanNoiBoId());
        model.setMaSoVanBanNoiBo(soapModel.getMaSoVanBanNoiBo());
        model.setTenSoVanBanNoiBo(soapModel.getTenSoVanBanNoiBo());
        model.setNgayTao(soapModel.getNgayTao());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<SoVanBanNoiBo> toModels(SoVanBanNoiBoSoap[] soapModels) {
        List<SoVanBanNoiBo> models = new ArrayList<SoVanBanNoiBo>(soapModels.length);

        for (SoVanBanNoiBoSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _soVanBanNoiBoId;
    }

    public void setPrimaryKey(long pk) {
        setSoVanBanNoiBoId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_soVanBanNoiBoId);
    }

    public long getSoVanBanNoiBoId() {
        return _soVanBanNoiBoId;
    }

    public void setSoVanBanNoiBoId(long soVanBanNoiBoId) {
        if (soVanBanNoiBoId != _soVanBanNoiBoId) {
            _soVanBanNoiBoId = soVanBanNoiBoId;
        }
    }

    public String getMaSoVanBanNoiBo() {
        return GetterUtil.getString(_maSoVanBanNoiBo);
    }

    public void setMaSoVanBanNoiBo(String maSoVanBanNoiBo) {
        if (((maSoVanBanNoiBo == null) && (_maSoVanBanNoiBo != null)) ||
                ((maSoVanBanNoiBo != null) && (_maSoVanBanNoiBo == null)) ||
                ((maSoVanBanNoiBo != null) && (_maSoVanBanNoiBo != null) &&
                !maSoVanBanNoiBo.equals(_maSoVanBanNoiBo))) {
            _maSoVanBanNoiBo = maSoVanBanNoiBo;
        }
    }

    public String getTenSoVanBanNoiBo() {
        return GetterUtil.getString(_tenSoVanBanNoiBo);
    }

    public void setTenSoVanBanNoiBo(String tenSoVanBanNoiBo) {
        if (((tenSoVanBanNoiBo == null) && (_tenSoVanBanNoiBo != null)) ||
                ((tenSoVanBanNoiBo != null) && (_tenSoVanBanNoiBo == null)) ||
                ((tenSoVanBanNoiBo != null) && (_tenSoVanBanNoiBo != null) &&
                !tenSoVanBanNoiBo.equals(_tenSoVanBanNoiBo))) {
            _tenSoVanBanNoiBo = tenSoVanBanNoiBo;
        }
    }

    public Date getNgayTao() {
        return _ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        if (((ngayTao == null) && (_ngayTao != null)) ||
                ((ngayTao != null) && (_ngayTao == null)) ||
                ((ngayTao != null) && (_ngayTao != null) &&
                !ngayTao.equals(_ngayTao))) {
            _ngayTao = ngayTao;
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

    public SoVanBanNoiBo toEscapedModel() {
        if (isEscapedModel()) {
            return (SoVanBanNoiBo) this;
        } else {
            SoVanBanNoiBo model = new SoVanBanNoiBoImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setSoVanBanNoiBoId(getSoVanBanNoiBoId());
            model.setMaSoVanBanNoiBo(HtmlUtil.escape(getMaSoVanBanNoiBo()));
            model.setTenSoVanBanNoiBo(HtmlUtil.escape(getTenSoVanBanNoiBo()));
            model.setNgayTao(getNgayTao());
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (SoVanBanNoiBo) Proxy.newProxyInstance(SoVanBanNoiBo.class.getClassLoader(),
                    new Class[] { SoVanBanNoiBo.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        SoVanBanNoiBoImpl clone = new SoVanBanNoiBoImpl();

        clone.setSoVanBanNoiBoId(getSoVanBanNoiBoId());
        clone.setMaSoVanBanNoiBo(getMaSoVanBanNoiBo());
        clone.setTenSoVanBanNoiBo(getTenSoVanBanNoiBo());
        clone.setNgayTao(getNgayTao());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        SoVanBanNoiBoImpl soVanBanNoiBo = (SoVanBanNoiBoImpl) obj;

        long pk = soVanBanNoiBo.getPrimaryKey();

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

        SoVanBanNoiBoImpl soVanBanNoiBo = null;

        try {
            soVanBanNoiBo = (SoVanBanNoiBoImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = soVanBanNoiBo.getPrimaryKey();

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
